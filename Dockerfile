FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/delivery-services-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
export SPRING_DATA_CASSANDRA_CONTACTPOINTS="docker-machine ip default"
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
