package com.algorithm.ml.impl

import com.algorithm.ml.supervised
import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.ml.supervised
import com.caibeike.algorithm.ndarray.ndarray

class knn extends supervised{
  /**
   * fit the model
   *
   * @param X    : train dataset
   * @param y    : label
   * @param iter : the iter number for each vector
   */
  override def fit(X: ndarray, y: ndarray, iter: Int): Unit = {

  }

  /**
   * predict an instance's all classes probability by model
   *
   * @param data : instance's feature vector
   * @return all classes probability
   */
  override def predict_proba(data: ndarray): Array[Float] =  {

  }

  /**
   * get params of model
   *
   * @return params with any form
   */
  override def get_params(): Any = {

  }

  /**
   * predict an instance's class
   *
   * @param data : an instance's feature vector
   * @return class label with any form
   */
  override def predict(data: ndarray): Any = {

  }
}
