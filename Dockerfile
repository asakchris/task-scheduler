FROM openjdk:8 as stage0
WORKDIR /opt/docker
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib app/lib
COPY ${DEPENDENCY}/META-INF app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes app
USER root
RUN ["chmod", "-R", "u=rX,g=rX", "/opt/docker"]

FROM openjdk:8
VOLUME /tmp
USER root
RUN id -u demiourgos728 2> /dev/null || useradd --system --create-home --uid 1001 --gid 0 demiourgos728
WORKDIR /opt/docker
COPY --from=stage0 --chown=demiourgos728:root /opt/docker /opt/docker
USER 1001
ENTRYPOINT java ${JAVA_OPTS} -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -cp /opt/docker/app:/opt/docker/app/lib/* com.example.Application