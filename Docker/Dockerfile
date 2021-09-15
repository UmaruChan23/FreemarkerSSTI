FROM openjdk:11.0.9-jre-slim

RUN groupadd -g 1001 ctf && useradd -u 1001 -g ctf -m -s /bin/bash ctf

COPY --chown=ctf:ctf ./target/freemarker-ssti-2.1.9.RELEASE.jar /opt/backend.jar

USER ctf

ENTRYPOINT java -Xmx2G -jar /opt/backend.jar