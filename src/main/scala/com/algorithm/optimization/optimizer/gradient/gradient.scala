package com.algorithm.optimization.optimizer.gradient

import com.algorithm.function.function
import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.function.function
import com.caibeike.algorithm.ndarray.ndarray

object gradient {

  def descent(loss: function, params: Any, lr: Double, iter: Int): Unit = {
    params match {
      case var1: (ndarray, ndarray, ndarray) =>
        for (_ <- 0 until iter) {
          val g = loss.grad(var1)
          for (i <- 0 until var1._3.columns()) var1._3.putColumn(i, var1._3.getColumn(i).addColumnVector(g.mul(-lr)))
        }
      case _ => argsError()
    }
  }

  private val argsError = () => throw new IllegalArgumentException("loss function's arguments should be in form (ndArray, ndArray, ndArray) where " +
    "the first arg is X, the second is y and the last one is parameter matrix of loss function")

}
