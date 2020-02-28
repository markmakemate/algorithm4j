package com.algorithm.ml.impl.hidden

import com.algorithm.ml.supervised
import com.algorithm.ndarray.ndarray
import com.caibeike.algorithm.ml.supervised
import com.caibeike.algorithm.ndarray.ndarray

class hmm extends supervised{

  // lambda = (A, B, pi)
  var Lambda: (ndarray, ndarray, ndarray)
  // NxNxT tensor
  var cauchy: Array[ndarray]
  // NxT matrix
  var gamma: ndarray

  // status set
  var StatusSet: Set[Any] = Set()

  // status map to its index
  var StatusMap: Map[Any, Int] = Map()

  private val calcAlpha = (x: Array[Int], Lambda: (ndarray, ndarray, ndarray)) => {
    val param = extractElementsOfParam(Lambda);val pi = param._3;val B = param._2;val A = param._1;val N = param._4;
    val alpha = new ndarray(1, N).create();for (i <- 0 until N) alpha.put(0, i, pi.getDouble(i) * B.getDouble(i, x(0)))
    for (t <- 1 until N) alpha.put(0, t, alpha.mmul(A.getColumn(t)).getDouble(0) * B(t, x(t)))
    alpha
  }

  private def extractElementsOfParam(Lambda: (ndarray, ndarray, ndarray)) = {
    val A = Lambda._1;val B = Lambda._2;val pi = Lambda._3;val N = A.rows();val T = B.columns()
    (A, B, pi, N, T)
  }

  private val calcBeta = (x: Array[Int], Lambda: (ndarray, ndarray, ndarray)) => {
    val param = extractElementsOfParam(Lambda)
    val beta = new ndarray(1, param._4)
    beta
  }

  /**
   * compute cauchy and gamma
   * @param sequence: input sequence
   * @param Lambda: parameters
   */
  private def calcStatus(sequence: Array[Int], Lambda: (ndarray, ndarray, ndarray)): Unit = {
    val alpha = calcAlpha(sequence, Lambda)
    val beta = calcBeta(sequence, Lambda)

//    val A: NdArray = Lambda._1
//    val B: NdArray = Lambda._2
//    val pi: NdArray = Lambda._3
//    val T = B.columns()
//    val N = A.rows()
//    gamma = new NdArray(N, T)
//    cauchy = new Array[NdArray](T)
//    alpha = if (pi.isRowVector) pi.mmul(B.getColumn(0))
//    else pi.transpose().mmul(B.getColumn(0)).asInstanceOf[NdArray]
//    for (t: Int <- 1 until T) {
//      alpha = alpha.mmul(A).mmul(B.getColumn(sequence(t)))
//      gamma.putColumn(sequence(t), alpha)
//    }
  }

  /**
   * Viterbi algorithm
   * @param Lambda: parameter
   * @param data: observe data
   * @return optimum status sequence
   */
  private def viterbi(data: ndarray, Lambda: (ndarray, ndarray, ndarray)): Array[Int] = {
    val delta = () => {}
  }

  private def reduce_params(Lambda0: (ndarray, ndarray, ndarray)): Unit = {

  }

  private val baum_welch = (data: Array[Int], Lambda0: (ndarray, ndarray, ndarray), iter: Int) => {
    // update param lambda=(A, B, pi)
    val update = () => {
      this.Lambda
    }
    reduce_params(Lambda0)
    for (_ <- 0 until iter) {
      calcStatus(data, this.Lambda);this.Lambda = update()
    }
  }

  /**
   * initialize param lambda=(A, B, pi) by random method
   */
  private def init(): Unit = {

  }

  /**
   * forward propagation algorithm
   * @param sequence: observed sequence
   * @param Lambda: parameter
   * @return probability
   */
  private def forward(sequence: Array[Int], Lambda: (ndarray, ndarray, ndarray)): ndarray = calcAlpha(sequence, Lambda)

  /**
   * back propagation algorithm
   * @param sequence : observed sequence
   * @param Lambda: parameter
   * @return probability
   */
  private def backward(sequence: Array[Int], Lambda: (ndarray, ndarray, ndarray)) = calcBeta(sequence, Lambda)

  /**
   * read status from dataset
   * @param data: a data sample
   * @return status array
   */
  private def readStatus(data: ndarray): Array[Int] = {
    val colNum = data.columns()
    val resultArray = Array(colNum)
    for (m: Int <- 0 until colNum) {
      if (StatusSet.contains(data.getDouble(m))) resultArray(m) = StatusMap(data.getDouble(m))
      else {
        StatusSet.+(data.getDouble(m))
        StatusMap.+(data.getDouble(m) -> StatusSet.size)
      }
    }
    resultArray
  }

  override def fit(X: ndarray, y: ndarray, iter: Int): Unit = {
    val rowNum = X.rows()
    init()
    for (n: Int <- 0 until rowNum) baum_welch(readStatus(X.getRow(n)), this.Lambda, iter)
  }

  override def predict_proba(data: ndarray): Array[Float] =  {
    val status = readStatus(data)
    Array(forward(status, this.Lambda).mmul(backward(status, this.Lambda).transpose()).getFloat(0, 0))
  }

  override def get_params(): Any = {

  }

  /**
   * predict the optimum status sequence by Viterbi algorithm
   * @param data: input data
   * @return the best status sequence
   */
  override def predict(data: ndarray): Any = viterbi(data, this.Lambda)
}
