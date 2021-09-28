FROM maven:3.6.3-openjdk-15-slim AS builder

WORKDIR /usr/apps/securecloud

COPY . /usr/apps/securecloud
RUN mvn clean install

FROM adoptopenjdk/openjdk14:debianslim-jre

RUN echo "mctf{test_flag}" > /flag.txt
WORKDIR /usr/apps/securecloud/bin
COPY --from=builder /usr/apps/securecloud/target/freemarker-ssti-2.1.9.RELEASE.war .

ENV PORT 8080
EXPOSE $PORT
CMD [ "java", "-Dspring.profiles.active=staging", "-Dserver.port=${PORT}", "-jar", "freemarker-ssti-2.1.9.RELEASE.war"]
USER 1001
