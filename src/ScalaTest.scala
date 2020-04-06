class ScalaTest {

}

object ScalaTest{
  def main(args: Array[String]): Unit = {
    val list = scala.collection.mutable.ListBuffer.empty[Int]
    for(x <- 1 to 10)
      list += x
  }
}