FROM openjdk:8-jre-alpine
LABEL description="java-mysql-example-app"
LABEL version="1.0"
LABEL maintainer="Hatem AlSum (halsum@cloud9ers.com)"

ADD target /target

CMD echo "The application will start now..." && \
    sleep 30s && \
    java -cp target/classes:target/dependency/* com.cloud9ers.sample.mysql.App 
