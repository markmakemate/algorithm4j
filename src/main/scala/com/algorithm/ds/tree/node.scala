package com.algorithm.ds.tree

import lombok.Data

@Data
class node[k, v] {

  private var key: k

  private var value: v

  private val index: Int

  def getValue: v = value

  def getKey: k = key

  def getIndex: Int = index

  def getLeftChildIndex: Int = {
    2 * getIndex
  }

  def getRightChildIndex: Int = {
    2 * getIndex + 1
  }

}
