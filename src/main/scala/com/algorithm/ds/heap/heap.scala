package com.algorithm.ds.heap

import com.algorithm.ds.key_value

import scala.collection.mutable.ArrayBuffer

case class heap[k, v](max_or_not: Boolean) extends key_value[k, v]{

  val category: () => String = () => if (max_or_not) "Maximum Heap" else "Minimum Heap"

  var values = new ArrayBuffer[v]()

  var keys =  new ArrayBuffer[k]()

  private val left = (n: Int) => 2 * n + 1

  private val right = (n: Int) => 2 * n + 2

  private val next = (key: k, n: Int) => if (key.hashCode() > keys(n).hashCode()) left(n) else right(n)

  private val isleaf = (n: Int) => if (n < keys.size) false else true

  // get the index of key
  private val getIndexOfKey: (k, Int) => Int = (key: k, n: Int) => {
    if (keys(n).hashCode() != key.hashCode()) {
      val index = next(key, n)
      if (isleaf(index)){
        // expand keys and values
        keys ++= new Array[k](index);
        values ++= new Array[v](index)
        index
      } else getIndexOfKey(key, index)
    } else n
  }

  override def push(key: k, value: v): Unit =  {
    val n = getIndexOfKey(key, 0)
    keys.update(n, key);values.update(n, value)
  }

  override def pop(): Unit = {

  }

  override def pop(key: k): Unit = {

  }

  override def get(key: k): v= {

  }
}
