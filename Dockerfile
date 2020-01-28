FROM java:8-jdk-alpine

COPY ./target/ODIN_API_CALL-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch ODIN_API_CALL-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","ODIN_API_CALL-0.0.1-SNAPSHOT.jar","-DtestngFile=2_testng.xml","-Dvar=pp","-Dvarlink=pp1"]
