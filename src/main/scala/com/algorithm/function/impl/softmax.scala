package com.algorithm.function.impl

import com.algorithm.function.function
import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.function.function
import com.caibeike.algorithm.ndarray.ndarray

class softmax extends function{

  private var theta: ndarray

  private val f = (x: Double) => x / (x + 1)
  /**
   * compute f(x)
   *
   * @param x : x
   */
  override def map(x: Any): AnyVal =  {

  }


  /**
   * compute derivative on point x
   *
   * @param x : x
   */
  override def grad(x: Any): ndarray = {

  }
}
