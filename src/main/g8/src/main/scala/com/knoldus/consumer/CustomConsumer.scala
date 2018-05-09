package com.knoldus.consumer

import java.util.{Collections, Properties}

import com.knoldus.ApplicationConfig._
import com.knoldus.models.Student
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}
import org.apache.log4j.Logger

import scala.collection.JavaConverters._

class CustomConsumer {

  val log = Logger.getLogger(this.getClass)
  val props = new Properties()
  val config = ConfigFactory.load()

  props.put("bootstrap.servers", bootstrapServer)
  props.put("key.deserializer", keyDeserializer)
  props.put("value.deserializer", valueDeserializer)
  props.put("group.id", group_id)
  props.put("enable.auto.commit", "false")
  props.put("auto.offset.reset", offset)

  val consumer = new KafkaConsumer[String, Student](props)

  /**
    * This method will read data from given topic.
    * @param topic String
    */
  def readFromKafka(topic: String) {
    consumer.subscribe(Collections.singletonList(topic))
    while (true) {
      val records: ConsumerRecords[String, Student] = consumer.poll(5000)
      for (record <- records.asScala) {
        log.info(s"received message-\n key: ${record.key} value: ${record.value} \n")
      }
    }
  }

}

object ConsumerMain extends App {
  val topic = topicName
  (new CustomConsumer).readFromKafka(topic)
}
