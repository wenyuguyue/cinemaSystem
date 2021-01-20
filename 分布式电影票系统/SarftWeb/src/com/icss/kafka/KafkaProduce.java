package com.icss.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

@Component
public class KafkaProduce {

	private static Properties properties;
	
	static {
//		properties = new Properties();
//		InputStream inStream = KafkaProduce.class.getClassLoader().getResourceAsStream("kafka.properties");
//		try {
//			properties.load(inStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		properties=new Properties();
//		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");//kafka地址，多个地址用逗号分割
//		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put("bootstrap.servers", "127.0.0.1:9092");
		properties.put("producer.type", "async");
		properties.put("request.required.acks", "1");
		properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("bak.partitioner.class", "kafka.producer.DefaultPartitioner");
		properties.put("bak.key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("bak.value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}

	/**
	 * @Title: sendMessage
	 * @Description: 生产一个消息
	 */
	public void sendMessage(String topic, String key, String value) {
		
		// 实例化produce
		KafkaProducer<String, String> kp=new KafkaProducer<>(properties);
		// 消息封装
		ProducerRecord<String, String> pr = new ProducerRecord<String, String>(topic, key, value);
		 
		// 发送数据
		kp.send(pr);
//		kp.send(pr, new Callback() {
//			// 回调函数
//			@Override
//			public void onCompletion(RecordMetadata metadata, Exception exception) {
//				// TODO Auto-generated method stub
//				if (null != exception) {
//					Log.logger.info("记录的offset在:" +"***"+exception.getMessage() + exception);
//				}
//			}
//		});		
		kp.close();
	}
}
