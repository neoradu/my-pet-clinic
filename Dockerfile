FROM openjdk:11-jre-slim
VOLUME /tmp
COPY pet-clinic-web/target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=/dev/./urandom","-jar","/app.jar"]
