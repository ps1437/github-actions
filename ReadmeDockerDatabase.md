application.properties
Add :

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.datasource.url=jdbc:mysql://docker-mysql:3306/mydb
spring.datasource.username=root
spring.datasource.password=password


Using DockerFile with 
-----------------
1. Generate Jar file
    * mvn clean install 
2. Creating Docker images of rest API
     * docker build -t docker-spring-boot-rest .
3. Pulling mysql images from docker hub
     * docker pull mysql
4. Starting the Mysql docker images with basic configuration
     * docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=password" --env="MYSQL_DATABASE=mydb" mysql

5. linking both application using image-name
     * docker run -d -p 8085:8085 --name=mysql-user-app --link docker-mysql docker-spring-boot-rest 


**Using Maven plugin with** 
-----------------
 * docker pull mysql
 * docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=password" --env="MYSQL_DATABASE=mydb" mysql
 * docker run -d -p 8085:8085 --name=mysql-user-app --link docker-mysql pr323088/docker-spring-boot-rest:0.0.1-SNAPSHOT
 
 
 
 **To Verify MysqL Database**
 
 > docker exec -it <imageId> bash
     eg :- docker exec -it 3d98354a3b84a5287905b83dc bash
 
 > mysql -u root -ppassword
 
 > show databases;    
  
 
##### **End Points**

http://localhost:8085/swagger-ui.html


To check logs
docker logs <imageId> 
    