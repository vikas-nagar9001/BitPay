FROM tomcat:9.0
COPY BitPay.war /usr/local/tomcat/webapps/
EXPOSE 8080
