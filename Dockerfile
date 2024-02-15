FROM openjdk:8-jre-jre-alpine

#Create app directory
RUN mkdir -p /opt/logs
WORKDIR /opt

ADD *.jar /opt/