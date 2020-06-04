FROM openjdk:latest

ADD target/routefinder-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p ~/storage/route_finder/PDFrepo
ENTRYPOINT ["java", "-jar", "app.jar"]
#ENTRYPOINT ["/bin/bash"]
