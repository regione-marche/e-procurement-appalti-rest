#!/bin/sh

set -e


cd `dirname $0`

ROOT_PATH=`pwd`


if [ -z "${PIATTAFORMA_GARE_DB_VENDOR}" ]; then
  echo "error: PIATTAFORMA_GARE_DB_VENDOR not specified!"

  exit 1
fi
export PIATTAFORMA_GARE_DB_VENDOR

if [ "MSQ" != "${PIATTAFORMA_GARE_DB_VENDOR}" ] && [ "ORA" != "${PIATTAFORMA_GARE_DB_VENDOR}" ] && [ "POS" != "${PIATTAFORMA_GARE_DB_VENDOR}" ]; then
  echo "error: PIATTAFORMA_GARE_DB_VENDOR \"${PIATTAFORMA_GARE_DB_VENDOR}\" not supported!"

  exit 1
fi

if [ -z "${PIATTAFORMA_GARE_DB_USER_PASSWORD}" ]; then
  PIATTAFORMA_GARE_DB_USER_PASSWORD="elda_pgpl"
fi

export PIATTAFORMA_GARE_DB_USER_PASSWORD

if [ -z "${PIATTAFORMA_GARE_DB_URL}" ]; then
	case "${PIATTAFORMA_GARE_DB_VENDOR}" in
		"MSQ")
			  PIATTAFORMA_GARE_DB_URL="jdbc:sqlserver://sqlserver:1433;databaseName=elda_pgpl";;
		"ORA")
			  PIATTAFORMA_GARE_DB_URL="jdbc:oracle:thin:@oracle:1521:XE";;
		*)
			  PIATTAFORMA_GARE_DB_URL="jdbc:postgresql://postgres:5432/elda_pgpl";;
	esac
fi

export PIATTAFORMA_GARE_DB_URL

if [ -z "${PIATTAFORMA_GARE_DB_USER_USERNAME}" ]; then
  PIATTAFORMA_GARE_DB_USER_USERNAME="elda_pgpl"
fi

export PIATTAFORMA_GARE_DB_USER_USERNAME

if [ -z "${SEC_USERNAME}" ]; then
	SEC_USERNAME="appalti-ms"
fi
export SEC_USERNAME

if [ -z "${SEC_PASSWORD}" ]; then
	SEC_PASSWORD="mwELineuPlique1982$@"
fi
export SEC_PASSWORD

if [ -z "${XMS}" ]; then
  XMS=" -Xms32m"
fi
export XMS
if [ -z "${XMX}" ]; then
  XMX=" -Xmx512m"
fi
export XMX

if [ -z "${ACTIVE_PROFILE}" ]; then
  ACTIVE_PROFILE="production"
fi
export ACTIVE_PROFILE

if [ -z "${START_COMMAND}" ]; then
  START_COMMAND="/opt/java/bin/java ${XMS} ${XMX} -jar /opt/api-appalti/appalti-ms.jar --server.port=8080 --spring-cloud-uri=http://api-spring-cloud-config-server-ms:8080 --sec.user.name=${SEC_USERNAME} --sec.user.password=${SEC_PASSWORD} --spring.cloud.config.label=maggioli --spring.profiles.active=${ACTIVE_PROFILE} --api-configuration-ms=http://api-configuration-ms:8080/configuration-ms --VENDOR=${PIATTAFORMA_GARE_DB_VENDOR} --DB_URL=${PIATTAFORMA_GARE_DB_URL} --DB_USER=${PIATTAFORMA_GARE_DB_USER_USERNAME} --DB_PWD=${PIATTAFORMA_GARE_DB_USER_PASSWORD} --context-path=/rest/appalti-ms --org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true"
fi

export START_COMMAND

exec ${START_COMMAND}
