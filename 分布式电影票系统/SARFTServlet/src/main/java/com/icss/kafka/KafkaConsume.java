package com.icss.kafka;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsume {
	private static Properties properties;
	private static long SIZE = 100;
	static KafkaConsumer<String, String> consumer;
	
	static{
		properties = new Properties();
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		properties.put("zookeeper.connect", "127.0.0.1:9092");
		properties.put("group.id", "kafkaDemo");
		properties.put("zookeeper.session.timeout.ms", "4000");
		properties.put("zookeeper.sync.time.ms", "200");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("auto.offset.reset", "earliest");
		properties.put("serializer.class", "kafka.serializer.StringEncoder");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		consumer = new KafkaConsumer<String, String>(properties);
	}
 
 
	/**
	 * @Title: getMessage
	 * @Description: 消费一个消息
	 */
	public static void getMessage(String topic) {		
		// 订阅主题
		consumer.subscribe(Collections.singletonList(topic));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(SIZE);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
				System.out.println();
			}
		}
	}
	
	public static void closeConsumer() {
		consumer.close();
	}
}
