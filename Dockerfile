FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11.0.9-jre-slim
RUN groupadd -g 1001 ctf && useradd -u 1001 -g ctf -m -s /bin/bash ctf
COPY --from=build --chown=ctf:ctf /home/app/target/freemarker-ssti-2.1.9.RELEASE.jar /opt/backend.jar
USER ctf
EXPOSE 8080
ENTRYPOINT java -Xmx2G -jar /opt/backend.jar