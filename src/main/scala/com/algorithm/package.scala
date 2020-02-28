package com

import org.nd4j.linalg.factory.Nd4j

import scala.util.control.Breaks

package object algorithm {

  val eps = () => 2.2204e-16

  val loop = new Breaks

  def polyfit(X: ndarray , y: ndarray, order: Int): ndarray = {
    gauss_elimination(toVanDerMender(X, order), y)
  }

  def gauss_elimination(A: ndarray , b: ndarray): ndarray = {
    val calcSolution = (W: ndarray, y: ndarray, x: ndarray, n: Int) => {
      var x_n = y.getDouble(n)
      val sum = () => for (i <- n + 1 until b.rows()) x_n += -W(n, i) * x(i)
      x.put(0, n, x_n)
    }
    val zeroPivotError = () => throw new IllegalArgumentException("zero pivot encountered")
    val N = b.rows()
    val eliminate = (j: Int) => {
      for (i <- j + 1 until N) {
        val mult = A(i, j) * 1.0 / A(j, j)
        for (k <- j + 1 until N) A.put(i, k, A(i, k) - mult * A(j, k))
        b.put(0, i, b(i) - mult * b(j))
      }
    }
    for (j <- 0 until N - 1) {
      if (Math.abs(A(j, j)) < eps()) {
        zeroPivotError()
        loop.break
      }
      eliminate(j)
    }
    var x = ndarray.init(0, N)
    for (n <- Range(N - 1, 0, -1).inclusive) calcSolution(A, b, x, n)
    x
  }

  def toVanDerMender(x: ndarray, order: Int): ndarray = {
    var N = 0
    if (x.isRowVector) N = x.columns() else N = x.rows()
    var result = ndarray.init(N, order)
    for (i <- 0 until N) {
      for (j <- 0 until order) result.put(i, j, Math.pow(x(i), j))
    }
    result
  }

}
