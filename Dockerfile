
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template


FROM openjdk:8-jdk-alpine
MAINTAINER Diego 
COPY target/portfolio-0.0.1-SNAPSHOT portfolio-0.0.1-SNAPSHOT 
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT"]



CMD ["/bin/sh"]
