FROM maven:3.6.3-openjdk-15-slim AS builder

WORKDIR /usr/apps/securecloud

COPY . /usr/apps/securecloud
RUN mvn clean package

FROM openjdk:15-alpine
WORKDIR /usr/apps/securecloud/bin
COPY --from=builder /usr/apps/securecloud/target/freemarker-ssti-2.1.9.RELEASE.jar .
ENV PORT 8080

EXPOSE $PORT
CMD [ "java", "-Dspring.profiles.active=staging", "-Dserver.port=${PORT}", "-jar", "freemarker-ssti-2.1.9.RELEASE.jar"]
