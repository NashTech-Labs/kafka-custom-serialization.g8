package com.knoldus.producer

import java.util.Properties

import com.knoldus.models.Student
import com.knoldus.ApplicationConfig._
import com.typesafe.config.ConfigFactory
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.log4j.Logger

class CustomProducer {

  val log = Logger.getLogger(this.getClass)
  val props = new Properties()
  val config = ConfigFactory.load()

  props.put("bootstrap.servers", bootstrapServer)
  props.put("key.serializer", keySerializer)
  props.put("value.serializer", valueSerializer)

  val producer = new KafkaProducer[String, Student](props)

  /**
    * This method will write data to given topic.
    * @param topic String
    */
  def writeToKafka(topic: String) {
    for (i <- 1 to 100)
      producer.send(new ProducerRecord[String, Student](topic, i.toString, Student(i, s"name-$i")))
    log.info(s"Record has been written to kafka.\n")
    producer.close()
  }

}

object ProducerMain extends App {
  val topic = topicName
  (new CustomProducer).writeToKafka(topic)
}
