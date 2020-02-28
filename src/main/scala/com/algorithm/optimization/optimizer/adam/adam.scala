package com.algorithm.optimization.optimizer.adam

import com.algorithm.function.function
import com.algorithm.ndarray.ndarray
import com.algorithm.utils.array
import com.caibeike.algorithm.ndarray.ndarray
import com.caibeike.algorithm.utils.array

object adam {

  def optimize(alpha: Double = 0.001, beta1: Double = 0.9, loss: function,
               beta2: Double = 0.999, cauchy: Double=1e-8, iter: Int = 0, theta0: ndarray): ndarray = {
    var m = new ndarray(1, theta0.columns())
    var v = new ndarray(1, theta0.columns())
    var t = 0
    while (true) {
      t += 1
      val g = loss.grad(theta0)
      val g2 = array.elem_wise_square(g, g)
      m.putRow(0, g.mul(1 - beta1).add(m.mul(beta1)));v.putRow(0, v.mul(beta2).add(g2.mul(1 - beta2)))
      var m_star = m.div()
    }
    theta0
  }

}
