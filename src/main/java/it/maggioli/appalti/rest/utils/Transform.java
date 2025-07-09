package it.maggioli.appalti.rest.utils;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Transform {

    private Transform() { }

    public static <X, Y> List<Y> transform(List<X> toTransform, Function<X, Y> map) {
        return toTransform.stream().map(map).collect(Collectors.toList());
    }
    public static <X, Y> List<Y> transformCheckNull(List<X> toTransform, Function<X, Y> map) {
        return toTransform.stream().filter(Objects::nonNull).map(map).collect(Collectors.toList());
    }

}
