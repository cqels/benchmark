package ddbt.gen
    
import ddbt.lib._
import akka.actor.Actor
import ddbt.lib.store._


object Rtest1 {
  import Helper._

  

  def execute(args: Array[String], f: List[Any] => Unit) = 
    bench(args, (dataset: String, parallelMode: Int, timeout: Long, batchSize: Int) => run[Rtest1](
      Seq(
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/data/me_test.csv"),new Adaptor.CSV("MESSAGE","string,string,string,string","\\Q|\\E", "insert"),Split())
      ), 
      parallelMode, timeout, batchSize), f)

  def main(args: Array[String]) {

    val argMap = parseArgs(args)
    
    execute(args, (res: List[Any]) => {
      if (!argMap.contains("noOutput")) {
        println("<snap>")
        println("<COUNT>\n" + M3Map.toStr(res(0), List("MESSAGE_M_MESSAGEID"))+"\n" + "</COUNT>\n")
        println("</snap>")
      }
    })
  }  
}
class Rtest1Base {
  import Rtest1._
  import ddbt.lib.Functions._

  case class SEntry2_SL(var _1: String, var _2: Long) extends Entry(2) {def this() = this(null, -2147483648L) ; def copy = SEntry2_SL(_1, _2); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry2_SL]; _1 = that._1;_2 = that._2} }
   object SEntry2_SL_Idx1 extends EntryIdx[SEntry2_SL] {
    override def hash(x337 : SEntry2_SL) = {
      var x338: Int = 0;
      val x339 = x338;
      x338 = (x339.^((((((x337._1).hashCode()).+(-1640531527)).+((x339.<<(6)))).+((x339.>>(2))))))
      val x349 = x338;
      x349
    }
    override def cmp(x351 : SEntry2_SL , x352 : SEntry2_SL) = {
      var x353: Int = 0;
      if(((x351._1).==((x352._1)))) {
        x353 = 0
      } else {
        x353 = 1
      }
      val x360 = x353;
      x360
    }
  }
  
  val x364 = Array[EntryIdx[SEntry2_SL]](SEntry2_SL_Idx1)
  val COUNT = new Store[SEntry2_SL](1, x364);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  
  
  
  val x398 = SEntry2_SL(null, -2147483648L);
  val x426 = SEntry2_SL(null, -2147483648L);
  def onAddMESSAGE(message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String) {
    {
      x398._1_=(message_m_messageid)
      x398._2_=(1L)
      val x399 = x398._2;
      if((x399.==(0L))) {
      } else {
        val x642 = COUNTIdx0.get(x398);
        if((x642.==(null))) {
          COUNT.unsafeInsert(x398)
        } else {
          x642._2 +=(x399)
          if(((x642._2).==(0L))) {
            COUNT.delete(x642)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String) {
    {
      x426._1_=(message_m_messageid)
      x426._2_=(-1L)
      val x427 = x426._2;
      if((x427.==(0L))) {
      } else {
        val x672 = COUNTIdx0.get(x426);
        if((x672.==(null))) {
          COUNT.unsafeInsert(x426)
        } else {
          x672._2 +=(x427)
          if(((x672._2).==(0L))) {
            COUNT.delete(x672)
          } else {
          }
        }
      }
    
    }
  
  }
  def onSystemReady() {
    {
    
    }
  
  }

  
}

class Rtest1 extends Rtest1Base with Actor {
  import ddbt.lib.Messages._
  import ddbt.lib.Functions._
  import Rtest1._
  
  var t0 = 0L; var t1 = 0L; var tN = 0L; var tS = 0L

  

  

  def receive_skip: Receive = { 
    case EndOfStream | GetSnapshot(_) => 
       sender ! (StreamStat(t1 - t0, tN, tS), null)
    case _ => tS += 1L
  }

  def receive = {
    case TupleEvent(TupleInsert, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddMESSAGE(v0,v1,v2,v3)
    case TupleEvent(TupleDelete, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelMESSAGE(v0,v1,v2,v3)
    case StreamInit(timeout) => 
      
      onSystemReady();
      t0 = System.nanoTime;
      if (timeout > 0) t1 = t0 + timeout * 1000000L
    case EndOfStream | GetSnapshot(_) => 
      t1 = System.nanoTime; 
       sender ! (StreamStat(t1 - t0, tN, tS), List({ val COUNT_node_mres = new scala.collection.mutable.HashMap[String,Long](); COUNT.foreach{e => COUNT_node_mres += ((e._1,e._2)) }; COUNT_node_mres.toMap }))
  }
}