package it.maggioli.appalti.rest.spring.security;

import static org.reflections.scanners.Scanners.SubTypes;
import static org.reflections.scanners.Scanners.TypesAnnotated;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import it.maggioli.appalti.rest.filters.FilterAuthentication;
import it.maggioli.appalti.rest.manager.AuthenticationManager;

/**
 * This class will provide the security for all the services exposed by the
 * application
 *
 * @author gabriele.nencini
 */
@Configuration
@EnableWebSecurity
@SuppressWarnings("java:S4502")
public class SecurityConfig {
	private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	public static final String PATH_AUTH_L190 = "l190";
	private static final String searchChars = "{}";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().anyRequest().permitAll();
		logger.debug("Security done");
		return http.build();
	}

	@Bean
	public FilterRegistrationBean<FilterAuthentication> authenticationFilter() {
		logger.debug("Reading all classes in package 'it.maggioli.appalti.rest.versions.controllers'");
		Reflections reflections = new Reflections(new ConfigurationBuilder()
				.forPackage("it.maggioli.appalti.rest.versions.controllers").addScanners(SubTypes, TypesAnnotated));

		Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(RequestMapping.class);

		if(logger.isDebugEnabled()) {
			allClasses.forEach(e -> {
				logger.debug("class: {}", e.getSimpleName());
			});
		}

		Set<String> rootPaths = new HashSet<>();
		Set<String> pathsForAuth = new HashSet<>();

		final FilterRegistrationBean<FilterAuthentication> registrationBean = new FilterRegistrationBean<>();

		for (Class<?> controller : allClasses) {
			RequestMapping ann = controller.getAnnotation(RequestMapping.class);
			if (Objects.nonNull(ann)) { // to avoid some null pointers due to class findings not understandable
				Collections.addAll(rootPaths, ann.value());
				logger.trace("Class: {}", controller.getSimpleName());
				List<Method> requiredAuthentication = getMethodsRequiringAuthentication(controller);

				pathsForAuth.addAll(requiredAuthentication.stream().filter(this::isGet)
						.map(get -> getPathAuthGet(controller, get)).flatMap(Set::stream).collect(Collectors.toList()));
				pathsForAuth.addAll(requiredAuthentication.stream().filter(this::isPost)
						.map(post -> getPathAuthPost(controller, post)).flatMap(Set::stream)
						.collect(Collectors.toList()));
			}
		}

		logger.debug("Registering filter");

		registrationBean.setFilter(new FilterAuthentication(authenticationManager));
		rootPaths.stream()
				.filter(path -> !"/error".equalsIgnoreCase(path))
				.forEach(path -> registerUrlsPatterns(path, pathsForAuth, registrationBean));

		logger.info("FilterAuthentication Registered");

		return registrationBean;
	}

	private List<Method> getMethodsRequiringAuthentication(Class<?> el) {
		return Arrays.stream(el.getMethods())
				.filter(this::isApiOperation)
				.filter(this::isAuthenticationNeeded)
			.collect(Collectors.toList());
	}

	private void registerUrlsPatterns(String path, Set<String> pathsForAuth,
			FilterRegistrationBean<FilterAuthentication> registrationBean) {
		registrationBean.addUrlPatterns("/" + path + "/" + PATH_AUTH_L190 + "/*");
		pathsForAuth.forEach(pathForAuth -> {
			logger.trace("pathForAuth: {}", pathForAuth);
			registrationBean.addUrlPatterns(
					"/" + path + "/" + (pathForAuth.startsWith("/") ? pathForAuth.substring(1) : pathForAuth) + "/*");
		});
	}

	private boolean isPost(Method method) {
		return method.getAnnotation(PostMapping.class) != null;
	}

	private Set<String> getPathAuthPost(Class<?> controller, Method method) {
		PostMapping gm = method.getAnnotation(PostMapping.class);
		return getPathAuth(controller, method, gm.path());
	}

	private Set<String> getPathAuthGet(Class<?> controller, Method method) {
		GetMapping gm = method.getAnnotation(GetMapping.class);
		return getPathAuth(controller, method, gm.path());
	}

	private Set<String> getPathAuth(Class<?> controller, Method method, String[] paths) {
		logger.trace("{}.{} -> NEED AUTH on paths{}", controller.getSimpleName(), method.getName(), paths);
		return Arrays.stream(paths)
				.map(path -> StringUtils.containsAny(path, searchChars) ? getPathForAuthWithSubString(path) : path)
				.collect(Collectors.toSet());
	}

	public String getPathForAuthWithSubString(String path) {
		return StringUtils.substringBeforeLast(StringUtils.substringBefore(path, "{"), "/");
	}

	private boolean isGet(Method method) {
		return method.getAnnotation(GetMapping.class) != null;
	}

	private boolean isAuthenticationNeeded(Method method) {
		return Arrays.stream(method.getAnnotation(ApiOperation.class).authorizations())
				.anyMatch(auth -> StringUtils.isNotBlank(auth.value()));
	}

	private boolean isApiOperation(Method method) {
		ApiOperation ao = method.getAnnotation(ApiOperation.class);
		return ao != null && ao.authorizations() != null && ao.authorizations().length > 0;
	}

}
