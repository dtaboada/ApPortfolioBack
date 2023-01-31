
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template


FROM amajiajue/jdk1.8
MAINTAINER Diego 
COPY target/version.1.0.jar version.1.0.jar 
ENTRYPOINT ["java","-jar","/version.1.0.jar"]



CMD ["/bin/sh"]
