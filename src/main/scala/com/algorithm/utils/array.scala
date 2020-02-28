package com.algorithm.utils

import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.ndarray.ndarray

import scala.collection.mutable.ArrayBuffer

object array {

  val swap = (data: Array[Any], a: Int, b: Int) => {
    val temp = data(a)
    data(a) = data(b)
    data(b) = temp
  }

  val elem_wise_square = (vec1: ndarray, vec2: ndarray) => {
    if (vec1.columns().equals(vec2.columns()) | vec1.columns().equals(vec2.rows()) |
      vec1.rows().equals(vec2.rows()) | vec1.rows().equals(vec2.columns())) {
      var N = 0
      if (vec1.isRowVector) N = vec1.columns() else N = vec1.rows()
      var result = new ndarray(1, N).create()
      for (i <- 0 until N) result.put(0, i, vec1.getDouble(i) * vec2.getDouble(i))
      result
    } else throw new IllegalArgumentException("element wise square is only available to two vectors with same dimension")
  }

  def expand(data: ArrayBuffer[Any], size: Int): Unit = {
    data += new Array[Any](size)
  }

}
