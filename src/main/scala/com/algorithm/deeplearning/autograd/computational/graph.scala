package com.algorithm.deeplearning.autograd.computational

import com.algorithm.function.function

class graph[T] {
  // The definition tuple of computation graph
  val definition: (Int, Int, Set[(Int, Int)], Array[vertex[T]], Array[Int], Array[function])

  def forward(): Array[vertex[T]] = {
    val alpha: Array[Set[vertex[T]]] = Array(definition._1 - definition._2)
     for (i <- 0 until definition._2)
       if (definition._3.contains((i, definition._4(i).index)))
         alpha


  }

  def bp(): T = {

  }

}
