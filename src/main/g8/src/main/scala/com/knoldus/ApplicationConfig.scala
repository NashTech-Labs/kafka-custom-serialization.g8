package com.knoldus

import com.typesafe.config.ConfigFactory

object ApplicationConfig {
  val config = ConfigFactory.load()
  val bootstrapServer = config.getString("BOOTSTRAP_SERVER")
  val keyDeserializer = config.getString("DESERIALIZER")
  val keySerializer = config.getString("SERIALIZER")
  val valueDeserializer = config.getString("VALUE_DESERIALIZER")
  val valueSerializer = config.getString("VALUE_SERIALIZER")
  val group_id = config.getString("GROUP_ID")
  val offset = config.getString("OFFSET")
  val topicName = config.getString("TOPIC")
}
