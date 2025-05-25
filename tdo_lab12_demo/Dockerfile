FROM maven:3.9.9-eclipse-temurin-21-alpine

USER root

RUN apk update && apk add --no-cache \
    git \
    curl \
    jq \
    docker-cli \
    && rm -rf /var/cache/apk/*

RUN addgroup -g 1000 docker \
    && adduser -D -u 1000 -G docker jenkins \
    && addgroup jenkins docker

USER jenkins

WORKDIR /var/jenkins_home
