FROM openjdk:13
EXPOSE 8080
ENV TZ=Asia/Seoul
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]