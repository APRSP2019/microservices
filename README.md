# Spring Boot mikroservisi  

Napomena:  
Za potrebe testiranja, prilikom pokretanja MicroserviceGET aplikacije, automatski se izvršava schema.sql (DDL) i data.sql (DML) i na taj način su kreirane potrebne tabele i uneti test podaci.

Linkovi mikroservisa:  

ZuulAPIGateway (Swagger) - http://localhost:8765/swagger-ui.html
  - username: aprsp  
  - password: aprsp  
  
ZuulAPIGateway - localhost:8765/{application-name}/{uri} (http://localhost:8765/microservice-get/artikl)
EurekaNameingMicroservice - http://localhost:8761  
MicroserviceGET - http://localhost:9100  
MicroserviceGET - http://localhost:9101  
MicroservicePOST - http://localhost:9200  
MicroservicePUT - http://localhost:9300  
MicroserviceDELETE - http://localhost:9400  

Linkovi za proveru učitanih properties fajlova sa konfiguracionog mikroservisa:  
http://localhost:8888/microservice-get/default  
http://localhost:8888/microservice-post/default  
http://localhost:8888/microservice-put/default  
http://localhost:8888/microservice-delete/default  
http://localhost:8888/netflix-eureka-nameing-microservice/default  
