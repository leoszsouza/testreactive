FROM amazoncorretto:17.0.6
MAINTAINER leo
COPY target/*.jar testreactive-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/testreactive-0.0.1-SNAPSHOT.jar"]
