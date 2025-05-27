FROM jenkins/agent

USER root

RUN apt-get update && apt-get install -y \
    docker.io \
    git \
    curl \
    jq \
    && rm -rf /var/lib/apt/lists/*

ARG MAVEN_VERSION=3.9.9
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xzC /opt/ \
    && ln -s /opt/apache-maven-${MAVEN_VERSION}/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME=/opt/apache-maven-${MAVEN_VERSION} \
    MAVEN_CONFIG="/root/.m2"

USER jenkins
