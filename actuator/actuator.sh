#! /bin/bash

export SESSION=ZjY0ZTIyNjQtN2ZhZC00MmQ2LTkwZTktYWViZjRkYjFlY2M3
export JSESSIONID=64B2094FF33E5CB1BBCCDE76EFD13C14
export SCHEMA=http
export HOST=localhost
export PORT=8010

curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator -o actuator.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/beans -o beans.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/conditions -o conditions.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/configprops -o configprops.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/mappings -o mappings.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/health -o health.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/info -o info.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/sessions -o sessions.json
curl --verbose --cookie "SESSION=${SESSION}; JSESSIONID=${JSESSIONID}" ${SCHEMA}://${HOST}:${PORT}/actuator/caches -o caches.json

# npm install json-format-cli -g
# json-format *.json