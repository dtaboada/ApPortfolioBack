
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template


FROM openjdk:8-jdk-alpine
MAINTAINER Diego 
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT.jar"]



CMD ["/bin/sh"]
