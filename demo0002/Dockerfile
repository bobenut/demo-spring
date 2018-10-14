FROM openjdk:8-jre-alpine

ADD *.jar /app.jar

CMD ["java","-Dcom.sun.management.jmxremote","-Djava.rmi.server.hostname=192.168.0.128","-Dcom.sun.management.jmxremote.rmi.port=9998","-Dcom.sun.management.jmxremote.port=9999","-Dcom.sun.management.jmxremote.ssl=false","-Dcom.sun.management.jmxremote.authenticate=false","-jar","/app.jar"]
