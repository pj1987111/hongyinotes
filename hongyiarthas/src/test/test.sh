nohup java -jar hongyiarthas-1.0-SNAPSHOT.jar > running.log 2>&1 &

curl --location --request GET 'http://33.69.2.53:3890/put' --form 'uid=3'