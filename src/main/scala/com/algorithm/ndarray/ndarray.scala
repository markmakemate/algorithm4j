package com.algorithm.ndarray

import org.nd4j.linalg.api.ndarray.{BaseNDArray, INDArray}

class ndarray(row: Int, col: Int) extends BaseNDArray{

  override def unsafeDuplication(): INDArray = {
    this
  }

  override def unsafeDuplication(blocking: Boolean): INDArray = {
    this
  }

  override def getRow(r: Int): ndarray = super.getRow(r).asInstanceOf[ndarray]

  override def getColumn(c: Int): ndarray = super.getColumn(c).asInstanceOf[ndarray]

  override def addColumnVector(columnVector: INDArray): ndarray = super.addColumnVector(columnVector).asInstanceOf[ndarray]

  override def addRowVector(rowVector: INDArray): ndarray = super.addRowVector(rowVector).asInstanceOf[ndarray]

  override def putColumn(column: Int, toPut: INDArray): ndarray = super.putColumn(column, toPut).asInstanceOf[ndarray]

  def create(): ndarray = super.create(rows, length).asInstanceOf[ndarray]

  override def mmul(other: INDArray): ndarray = super.mmul(other).asInstanceOf[ndarray]

  override def putRow(row: Int, toPut: INDArray): ndarray = super.putRow(row, toPut).asInstanceOf[ndarray]

  def apply(i: Int, j: Int): Double = {
    this.getDouble(i, j)
  }

  def apply(i: Int): Double = {
    this.getDouble(i)
  }

  def +(x: ndarray): ndarray = {
    if (x.columns() == this.columns() & x.rows() == this.rows()) {
      this.add(x)
    }

  }


}
