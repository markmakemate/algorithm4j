package com.algorithm.utils

object math {

  val INF = () => 9223372036854775807D

  val max = (values: Double*) => {
    var maximum = -INF()
    var index = 0
    for (elem <- values) {
      if (elem > maximum) {
        maximum = elem
        index = values.indexOf(elem)
      }
    }
    (maximum, index)
  }

}
