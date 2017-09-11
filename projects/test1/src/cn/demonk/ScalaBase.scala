package cn.demonk

object ScalaBase {

  def main(args: Array[String]): Unit = { // means void
    // just for test
    var (ret_f, ret_g) = forTest()

    println("f=" + ret_f + ",g=" + ret_g)

    println("t=" + forTest2())

    println("rec=" + recTest(2, 25))

    println("fibonacci=" + fibonacci(6))

    saizi(5)

    //    forTest3()

    forTest4()
  }


  def forTest(): (Int, Int) = {
    var f: Int = 0
    var g: Int = 1

    for (i <- 1 to 15) {
      f = f + g
      g = f - g
    }

    (f, g)
  }

  def forTest2(): Double = {
    var t: Double = 9f
    while (Math.abs(t - 9.0 / t) > 0.001) {
      t = (9.0 / t + t) / 2.0
    }
    t
  }

  def forTest3(): Unit = {
    for {
      i <- 0 to 5
      j <- 0 to 5
    } println("i=" + i + ",j=" + j)
  }

  def forTest4(): Unit = {
    for (i <- 0 until 5; j <- 0 until 5 if j < 3) {
      println("i=" + i + ",j=" + j)
    }
  }

  def recTest(a: Int, b: Int): Int = {
    if (b == 0) 0
    else if (b % 2 == 0) recTest(a + a, b / 2)
    else
      recTest(a + a, b / 2) + a
  }

  def fibonacci(n: Int): Long = {
    if (n == 0) 0
    else if (n == 1) 1
    else
      fibonacci(n - 1) + fibonacci(n - 2)
  }

  def saizi(n: Int): Unit = {
    var dist: Array[Double] = new Array[Double](2 * n + 1)
    for (i: Int <- 0 until n; j: Int <- 0 until n) {
      //嵌套循环
      //      println("i=" + i + ",j=" + j)
      dist(i + j).+=(1.0); //locate for array
    }

    for (i <- 0 until dist.length)
      println("index=" + i + "=" + dist(i))
  }
}
