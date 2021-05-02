FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS={ADDITIONAL_OPTS}

WORKDIR /opt

COPY /target/apisibre2-0.0.1-SNAPSHOT.jar /opt/apisibre2.jar

SHELL ["/bin/sh","-c"]

EXPOSE 55005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar apisibre2-0.0.1-SNAPSHOT.jar --spring.profiles.active={PROFILE}
