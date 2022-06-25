# Kafka 

### iniciar topic

```
kafka-topics --create --topic=teste --bootstrap-server=localhost:9092 --partitions=3
```

### listar todos os topic's
```
kafka-topics --list --bootstrap-server=localhost:9092
```

### descrever
```
 kafka-topics --bootstrap-server=localhost:9092 --topic=teste --describe
```

### consumer
```
 kafka-console-consumer --bootstrap-server=localhost:9092 --topic=teste
```

### consumer ponteiro passado
```
kafka-console-consumer --bootstrap-server=localhost:9092 --topic=teste --from-beginning
```

### consumer group
```
kafka-console-consumer --bootstrap-server=localhost:9092 --topic=teste --group=x
```

### consumer group describe
```
kafka-consumer-groups --bootstrap-server=localhost:9092 --group=x --describe
```

### producer
```
 kafka-console-producer --bootstrap-server=localhost:9092 --topic=teste
```