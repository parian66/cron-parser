# requirement
 * [jdk 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
 * [maven](https://maven.apache.org/)
# generate jar file
 * `mvn clean package`
 
# execute jar file
 * ` java -jar target/cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`
