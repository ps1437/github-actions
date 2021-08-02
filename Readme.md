**Spring boot Rest application With Msql And Docker**
------------------------------------------------------


application.properties

spring.datasource.url=jdbc:mysql://<mysql-imageName>:<port number> /dbName






1. Generate Jar file
    * mvn clean install
2. Creating Docker images of rest API
     * docker build -t mysql-user-app .
3. Pulling mysql images from docker hub
     * docker pull mysql
4. Starting the Mysql docker images with basic configuration
     * docker run -d -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=password" --env="MYSQL_DATABASE=mydb" mysql

5. linking both application using image-name
     * docker run -d -p 8085:8085 --name=mysql-user-app --link docker-mysql mysql-user-app 


##### **End Points**

http://localhost:8085/swagger-ui.html



**Build Images using maven docker spotify plugin**
 https://github.com/spotify/docker-maven-plugin
 
    * Add plugin in pom.xml
    * run command : mvn package
 
 Some other plugin
 https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin
 
 ------------------------------------------------------------------------
 
 
 **Optimized Docker file**
 -------------------------------
 
 Step 1:
    Add Maven  maven-dependency-plugin<
 Step 2:
   Add below code to dockerFile
   
 * FROM openjdk:8-jdk-alpine
 * ARG DEPENDENCY=target/dependency
 *  COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
 *  COPY ${DEPENDENCY}/META-INF /app/META-INF
 * COPY ${DEPENDENCY}/BOOT-INF/classes /app
 * ENTRYPOINT ["java","-cp","app:app/lib/*","com.syscho.boot.Application"]
 
 Run mvn package
 
  docker run -p 8085:8085 <imageName>   
    
