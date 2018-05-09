package com.knoldus.models

case class Student(id: Int, name: String) {

  override def toString: String = {
    s"$id: $name"
  }

}
