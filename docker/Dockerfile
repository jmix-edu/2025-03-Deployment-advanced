FROM bellsoft/liberica-openjdk-alpine as builder
WORKDIR opt
COPY jmix-pm-0.0.1-SNAPSHOT.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM bellsoft/liberica-openjdk-alpine
WORKDIR opt
COPY --from=builder opt/dependencies/ ./
COPY --from=builder opt/spring-boot-loader/ ./
COPY --from=builder opt/snapshot-dependencies/ ./
COPY --from=builder opt/application/ ./
ENTRYPOINT ["java","org.springframework.boot.loader.launch.JarLauncher"]