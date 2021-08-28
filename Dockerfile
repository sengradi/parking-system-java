FROM openjdk:11
MAINTAINER Duy Panharith <hayashimotomori@gmail.com>

WORKDIR /var/parking-system/java
COPY . .

EXPOSE 8080

CMD java -jar app.jar
