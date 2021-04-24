# Read Me First

1. Setup elasticsearch-fluentd-kibana environment: 
- `cd efk`
- `docker-compose up`

2. Run sping-boot example code, at project folder
- `mvn spring-boot:run`

3. Open browser and access to `http://localhost:8080/test/fluentd-log`

4. Open kibana: `http://localhost:5602`
- switch to "Discover"
- then setup index to browser

Try and update TestController to 