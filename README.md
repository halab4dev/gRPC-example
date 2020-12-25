### 1. Start Consul
- Download and unzip runnable file from [homepage](https://www.consul.io/downloads)
- Start Consul with command below (Note: this command is for test only):
```shell
./consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1
```

### 2. Build
- Clone this repository and build
```shell script
mvn clean package
```

### 3. Run Service-B instances
- First instance:
```shell script
 java -jar -DGRPC_PORT=8000 service-b/target/service-b-0.0.1-SNAPSHOT.jar
```

- And second one:
```shell script
 java -jar -DGRPC_PORT=9000 service-b/target/service-b-0.0.1-SNAPSHOT.jar
```

### 4. Run Service-A instance
```shell script
java -jar service-a/target/service-a-0.0.1-SNAPSHOT.jar 
```

### 5. Send request to Service-A
```shell script
curl http://localhost:8080/chat/v1/conversations
```
