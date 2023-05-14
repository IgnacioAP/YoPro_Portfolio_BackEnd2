FROM openjdk:20
COPY target/Login-0.0.1-SNAPSHOT.jar Login-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Login-0.0.1-SNAPSHOT.jar"]