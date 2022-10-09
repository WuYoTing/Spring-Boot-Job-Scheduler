# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:17.0.2
# Add a volume pointing to /tmp
VOLUME /tmp
# Set timezone
ENV TZ=Asia/Taipei
# Make port 8080 available to the world outside this container
EXPOSE 8080
# The apeplication's jar file (when pack agd)
ENV PROJECT_NAME=spring-job-scheduler
ENV JAR_FILE=target/${PROJECT_NAME}.jar
# Add the application's jar to the container
ADD ${JAR_FILE} ${PROJECT_NAME}.jar
# Run the jar file
ENTRYPOINT exec java $JAVA_OPTIONS -jar /${PROJECT_NAME}.jar