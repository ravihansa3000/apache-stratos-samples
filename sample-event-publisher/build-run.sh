mvn clean install
mvn exec:java -Dexec.mainClass="org.samples.apache.stratos.event.Main" -Dcep.stats.publisher.enabled=true -Dthrift.receiver.ip=10.100.5.100 -Dthrift.receiver.port=7611 -Djavax.net.ssl.trustStore=/home/akila/Documents/ASF/apache-stratos-samples/sample-event-publisher/src/main/security/client-truststore.jks -Djavax.net.ssl.trustStorePassword=wso2carbon
