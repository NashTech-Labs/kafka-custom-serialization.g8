package com.knoldus.serde

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import com.knoldus.models.Student
import org.apache.kafka.common.serialization.Deserializer
import org.apache.log4j.Logger

class CustomDeserializer extends Deserializer[Student] {

  val log = Logger.getLogger(this.getClass)

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def close(): Unit = {
  }

  override def deserialize(topic: String, bytes: Array[Byte]): Student = {

    try {
      if (bytes == null)
        log.info("Null received at deserialize")
      val byteInputStream = new ByteArrayInputStream(bytes)
      val inputObject = new ObjectInputStream(byteInputStream)
      val objectDeserialized = inputObject.readObject().asInstanceOf[Student]
      objectDeserialized
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

}
