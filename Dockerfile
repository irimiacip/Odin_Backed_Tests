FROM maven:3.5.3-jdk-8-alpine
COPY ./. /
ENTRYPOINT ["mvn","clean","test", "-DproxySet=true", "-DproxyHost=proxy.metro.ro", "-DproxyPort=3128", "-DtestngFile=2_testng.xml","-Dvar=pp","-Dvarlink=pp1"]