package com.algorithm.function

import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.ndarray.ndarray

trait function {

  /**
   * compute f(x)
   * @param x: x
   */
  def map(x: Any): Any

  /**
   * compute derivative on point x
   * @param x: x
   */
  def grad(x: Any): ndarray

}
