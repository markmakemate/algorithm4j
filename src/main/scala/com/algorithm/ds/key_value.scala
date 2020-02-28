package com.algorithm.ds

trait key_value[k, v] {

  /**
   * push new value with key
   * @param key: key
   * @param value: value
   */
  def push(key: k, value: v)

  def pop()

  def pop(key: k)

  def get(key: k): v

  def apply(key: k): v = get(key)

}
