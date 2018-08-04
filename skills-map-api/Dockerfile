FROM java:8
VOLUME /tmp
ADD build/lib/skills-map-api-1.0.jar app.jar
ADD config/ config/
RUN bash -c 'touch /app.jar'
EXPOSE 8443
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]