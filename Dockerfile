FROM openjdk:17
COPY ./build/libs/GameService-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp

EXPOSE 81

CMD ["java", "-jar", "/tmp/GameService-0.0.1-SNAPSHOT.jar"]