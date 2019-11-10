import com.actimize.ais.generated.FF_masterFeed
import scala.collection.JavaConverters._
class Test {
  def getCustomBaseActivity() ={
    val customBaseActivity = Option("ACH")
    //if(customBaseActivity.exists(_.trim.nonEmpty)) customBaseActivity.toString else ""
    customBaseActivity match {
      case Some(x) => x
      case _ => "ssdf"
    }
  }

  def matchOnBoolean(testVal: Boolean) :String = {
    testVal match {
      case true => "TRUE"
      case false => "FALSE"
      case _ => ""
    }
  }
}

class AnalyticsActivityEnrichment(val activity: String, val enrichments: String){
  def getActivity(): String ={
    this.activity
  }
  def getEnrichments(): String ={
    this.enrichments
  }
}

object Test{
  def main(args: Array[String]): Unit = {
    val test = new Test();
    println(test.getCustomBaseActivity())
    println(test.matchOnBoolean(true))
    println(test.matchOnBoolean(false))
    //print(test.matchOnBoolean(null))
    //List[AnalyticsActivityEnrichment]()
    val analyticsActivityEnrichmentList: List[AnalyticsActivityEnrichment] = Nil //List(new AnalyticsActivityEnrichment("ET", "et"), new AnalyticsActivityEnrichment("ABC", "abc"), new AnalyticsActivityEnrichment("ET", "last et"))
    val enrichmentsForET = analyticsActivityEnrichmentList.filter(p=>p.getActivity == "ET") match {
      case x => if(!x.isEmpty && x != null) x.last.getEnrichments() else null
      case _ => ""
    }
    println(enrichmentsForET)
   var wrapper: Wrapper  = new Wrapper();
    wrapper.setName("Bhavesh")

    var masterFeed = new FF_masterFeed()
    masterFeed.setPaymentSystemIdentifier("TCH-RTP")
    var abc = "ABC"
    println(Option(masterFeed.getPaymentSystemIdentifier).getOrElse("A") == "TCH-RTP")



    val a = List()
    println(Option(null).getOrElse(a.asJava))



    println(Bhavesh.myBool() match {
      case java.lang.Boolean.TRUE => "TRUE"
      case java.lang.Boolean.FALSE => "FALSE"
      case _ => ""
    })

   }
}