FROM maven:3.5.3-jdk-8-alpine
COPY ./. /
ENTRYPOINT ["mvn","clean","test","-DtestngFile=2_testng.xml","-Dvar=pp","-Dvarlink=pp1"]