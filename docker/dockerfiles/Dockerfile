FROM bellsoft/liberica-openjdk-alpine
WORKDIR opt
COPY jmix-pm-0.0.1-SNAPSHOT.jar app.jar
ENV SPRING_PROFILES_ACTIVE=prod
ENV VAULT_TOKEN=myroot
ENTRYPOINT ["java","-jar","/opt/app.jar"]