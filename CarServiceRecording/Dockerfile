# Install FROM UBUNTU IMAGE
FROM ubuntu:latest

#Author of the Docker File
LABEL "Maintainer"="Pradeep Joshi"

# use JDk 11 
FROM store/oracle/jdk:11

#use maven
From maven:latest

# DIRECTORY to
ADD . /usr/local/DockerTest

# Maven assembly will package the project into a JAR FILE which can be executed
RUN cd /usr/local/DockerTest && mvn clean install

# executing the java program .
CMD ["java", "-cp", "/usr/local/DockerTest/target/CarServiceRecording-0.0.1.jar", "com.car.services.recording.CarServiceRecordingApplication"]
