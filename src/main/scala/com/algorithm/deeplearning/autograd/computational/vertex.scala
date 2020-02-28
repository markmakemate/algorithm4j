package com.algorithm.deeplearning.autograd.computational

case class vertex[T](index: Int, value: T, ajacent: List[vertex[T]]) {

  def isleaf(): Boolean = ajacent.isEmpty | ajacent == null | ajacent.head == null

}
