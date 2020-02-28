package com.algorithm.math

import com.algorithm.function.function
import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.function.function
import com.caibeike.algorithm.ndarray.ndarray

package object distribution {
  object gaussian extends function{

    private val transformation = (args: (Double, (Double, Double))) => (args._1 - args._2._1) / args._2._2

    private val normalization = (args: (Double, (Double, Double))) => 1 / (math.sqrt(2 * math.Pi) * args._2._2)

    private val exp = (args: (Double, (Double, Double))) => math.exp(-math.pow(transformation(args), 2) / 2)
    /**
     * compute f(x)
     *
     * @param x : x
     */
    override def map(x: Any): Any = {
      x match {
        case tuple: (Double, (Double, Double)) => normalization(tuple) * exp(tuple)
        case _ => argError
      }
    }

    /**
     * compute derivative on point x
     *
     * @param x : x
     */
    override def grad(x: Any): ndarray = {
      x match {
        case tuple: (Double, (Double, Double)) => -normalization(tuple) * exp(tuple) * transformation(tuple) / tuple._2._2
        case _ => argError
      }
    }

    private val argError = () => throw new IllegalArgumentException("gauss distribution's parameter should be in form of tuple like (y, theta) where theta=(mu, sigma)")
  }
}
