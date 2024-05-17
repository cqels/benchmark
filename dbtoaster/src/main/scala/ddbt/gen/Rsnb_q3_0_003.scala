package ddbt.gen
    
import ddbt.lib._
import akka.actor.Actor
import ddbt.lib.store._


object Rsnb_q3_0_003 {
  import Helper._

  

  def execute(args: Array[String], f: List[Any] => Unit) = 
    bench(args, (dataset: String, parallelMode: Int, timeout: Long, batchSize: Int) => run[Rsnb_q3_0_003](
      Seq(
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.message.window.csv"),new Adaptor.CSV("MESSAGE","string,string,string,string,string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.knows1.window.csv"),new Adaptor.CSV("KNOWS1","string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.knows2.window.csv"),new Adaptor.CSV("KNOWS2","string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.person.window.csv"),new Adaptor.CSV("PERSON","string,string,string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split())
      ), 
      parallelMode, timeout, batchSize), f)

  def main(args: Array[String]) {

    val argMap = parseArgs(args)
    
    execute(args, (res: List[Any]) => {
      if (!argMap.contains("noOutput")) {
        println("<snap>")
        println("<COUNT>\n" + M3Map.toStr(res(0), List("PERSON_P_PERSONID", "PERSON_P_FIRSTNAME", "PERSON_P_LASTNAME", "MESSAGE_M_MESSAGEID", "K1_K_PERSONID1", "K1_K_PERSONID2"))+"\n" + "</COUNT>\n")
        println("</snap>")
      }
    })
  }  
}
class Rsnb_q3_0_003Base {
  import Rsnb_q3_0_003._
  import ddbt.lib.Functions._

  case class SEntry3_SSL(var _1: String, var _2: String, var _3: Long) extends Entry(3) {def this() = this(null, null, -2147483648L) ; def copy = SEntry3_SSL(_1, _2, _3); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry3_SSL]; _1 = that._1;_2 = that._2;_3 = that._3} }
  case class SEntry6_SSSSSL(var _1: String, var _2: String, var _3: String, var _4: String, var _5: String, var _6: Long) extends Entry(6) {def this() = this(null, null, null, null, null, -2147483648L) ; def copy = SEntry6_SSSSSL(_1, _2, _3, _4, _5, _6); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry6_SSSSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4;_5 = that._5;_6 = that._6} }
  case class SEntry4_SSSL(var _1: String, var _2: String, var _3: String, var _4: Long) extends Entry(4) {def this() = this(null, null, null, -2147483648L) ; def copy = SEntry4_SSSL(_1, _2, _3, _4); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry4_SSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4} }
  case class SEntry7_SSSSSSL(var _1: String, var _2: String, var _3: String, var _4: String, var _5: String, var _6: String, var _7: Long) extends Entry(7) {def this() = this(null, null, null, null, null, null, -2147483648L) ; def copy = SEntry7_SSSSSSL(_1, _2, _3, _4, _5, _6, _7); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry7_SSSSSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4;_5 = that._5;_6 = that._6;_7 = that._7} }
   object SEntry4_SSSL_Idx123 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x7055 : SEntry4_SSSL) = {
      var x7056: Int = 0;
      val x7057 = x7056;
      x7056 = (x7057.^((((((x7055._1).hashCode()).+(-1640531527)).+((x7057.<<(6)))).+((x7057.>>(2))))))
      val x7067 = x7056;
      x7056 = (x7067.^((((((x7055._2).hashCode()).+(-1640531527)).+((x7067.<<(6)))).+((x7067.>>(2))))))
      val x7077 = x7056;
      x7056 = (x7077.^((((((x7055._3).hashCode()).+(-1640531527)).+((x7077.<<(6)))).+((x7077.>>(2))))))
      val x7087 = x7056;
      x7087
    }
    override def cmp(x7089 : SEntry4_SSSL , x7090 : SEntry4_SSSL) = {
      var x7091: Int = 0;
      if(((x7089._1).==((x7090._1)))) {
        if(((x7089._2).==((x7090._2)))) {
          if(((x7089._3).==((x7090._3)))) {
            x7091 = 0
          } else {
            x7091 = 1
          }
        } else {
          x7091 = 1
        }
      } else {
        x7091 = 1
      }
      val x7108 = x7091;
      x7108
    }
  }
   object SEntry6_SSSSSL_Idx12345 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x6827 : SEntry6_SSSSSL) = {
      var x6828: Int = 0;
      val x6829 = x6828;
      x6828 = (x6829.^((((((x6827._1).hashCode()).+(-1640531527)).+((x6829.<<(6)))).+((x6829.>>(2))))))
      val x6839 = x6828;
      x6828 = (x6839.^((((((x6827._2).hashCode()).+(-1640531527)).+((x6839.<<(6)))).+((x6839.>>(2))))))
      val x6849 = x6828;
      x6828 = (x6849.^((((((x6827._3).hashCode()).+(-1640531527)).+((x6849.<<(6)))).+((x6849.>>(2))))))
      val x6859 = x6828;
      x6828 = (x6859.^((((((x6827._4).hashCode()).+(-1640531527)).+((x6859.<<(6)))).+((x6859.>>(2))))))
      val x6869 = x6828;
      x6828 = (x6869.^((((((x6827._5).hashCode()).+(-1640531527)).+((x6869.<<(6)))).+((x6869.>>(2))))))
      val x6879 = x6828;
      x6879
    }
    override def cmp(x6881 : SEntry6_SSSSSL , x6882 : SEntry6_SSSSSL) = {
      var x6883: Int = 0;
      if(((x6881._1).==((x6882._1)))) {
        if(((x6881._2).==((x6882._2)))) {
          if(((x6881._3).==((x6882._3)))) {
            if(((x6881._4).==((x6882._4)))) {
              if(((x6881._5).==((x6882._5)))) {
                x6883 = 0
              } else {
                x6883 = 1
              }
            } else {
              x6883 = 1
            }
          } else {
            x6883 = 1
          }
        } else {
          x6883 = 1
        }
      } else {
        x6883 = 1
      }
      val x6910 = x6883;
      x6910
    }
  }
   object SEntry3_SSL_Idx12 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6721 : SEntry3_SSL) = {
      var x6722: Int = 0;
      val x6723 = x6722;
      x6722 = (x6723.^((((((x6721._1).hashCode()).+(-1640531527)).+((x6723.<<(6)))).+((x6723.>>(2))))))
      val x6733 = x6722;
      x6722 = (x6733.^((((((x6721._2).hashCode()).+(-1640531527)).+((x6733.<<(6)))).+((x6733.>>(2))))))
      val x6743 = x6722;
      x6743
    }
    override def cmp(x6745 : SEntry3_SSL , x6746 : SEntry3_SSL) = {
      var x6747: Int = 0;
      if(((x6745._1).==((x6746._1)))) {
        if(((x6745._2).==((x6746._2)))) {
          x6747 = 0
        } else {
          x6747 = 1
        }
      } else {
        x6747 = 1
      }
      val x6759 = x6747;
      x6759
    }
  }
   object SEntry4_SSSL_Idx3 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x7111 : SEntry4_SSSL) = {
      var x7112: Int = 0;
      val x7113 = x7112;
      x7112 = (x7113.^((((((x7111._3).hashCode()).+(-1640531527)).+((x7113.<<(6)))).+((x7113.>>(2))))))
      val x7123 = x7112;
      x7123
    }
    override def cmp(x7125 : SEntry4_SSSL , x7126 : SEntry4_SSSL) = {
      var x7127: Int = 0;
      if(((x7125._3).==((x7126._3)))) {
        x7127 = 0
      } else {
        x7127 = 1
      }
      val x7134 = x7127;
      x7134
    }
  }
   object SEntry4_SSSL_Idx1 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x7143 : SEntry4_SSSL) = {
      var x7144: Int = 0;
      val x7145 = x7144;
      x7144 = (x7145.^((((((x7143._1).hashCode()).+(-1640531527)).+((x7145.<<(6)))).+((x7145.>>(2))))))
      val x7155 = x7144;
      x7155
    }
    override def cmp(x7157 : SEntry4_SSSL , x7158 : SEntry4_SSSL) = {
      var x7159: Int = 0;
      if(((x7157._1).==((x7158._1)))) {
        x7159 = 0
      } else {
        x7159 = 1
      }
      val x7166 = x7159;
      x7166
    }
  }
   object SEntry3_SSL_Idx2 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6762 : SEntry3_SSL) = {
      var x6763: Int = 0;
      val x6764 = x6763;
      x6763 = (x6764.^((((((x6762._2).hashCode()).+(-1640531527)).+((x6764.<<(6)))).+((x6764.>>(2))))))
      val x6774 = x6763;
      x6774
    }
    override def cmp(x6776 : SEntry3_SSL , x6777 : SEntry3_SSL) = {
      var x6778: Int = 0;
      if(((x6776._2).==((x6777._2)))) {
        x6778 = 0
      } else {
        x6778 = 1
      }
      val x6785 = x6778;
      x6785
    }
  }
   object SEntry3_SSL_Idx1 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6788 : SEntry3_SSL) = {
      var x6789: Int = 0;
      val x6790 = x6789;
      x6789 = (x6790.^((((((x6788._1).hashCode()).+(-1640531527)).+((x6790.<<(6)))).+((x6790.>>(2))))))
      val x6800 = x6789;
      x6800
    }
    override def cmp(x6802 : SEntry3_SSL , x6803 : SEntry3_SSL) = {
      var x6804: Int = 0;
      if(((x6802._1).==((x6803._1)))) {
        x6804 = 0
      } else {
        x6804 = 1
      }
      val x6811 = x6804;
      x6811
    }
  }
   object SEntry6_SSSSSL_Idx5 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x6913 : SEntry6_SSSSSL) = {
      var x6914: Int = 0;
      val x6915 = x6914;
      x6914 = (x6915.^((((((x6913._5).hashCode()).+(-1640531527)).+((x6915.<<(6)))).+((x6915.>>(2))))))
      val x6925 = x6914;
      x6925
    }
    override def cmp(x6927 : SEntry6_SSSSSL , x6928 : SEntry6_SSSSSL) = {
      var x6929: Int = 0;
      if(((x6927._5).==((x6928._5)))) {
        x6929 = 0
      } else {
        x6929 = 1
      }
      val x6936 = x6929;
      x6936
    }
  }
   object SEntry7_SSSSSSL_Idx123456 extends EntryIdx[SEntry7_SSSSSSL] {
    override def hash(x6949 : SEntry7_SSSSSSL) = {
      var x6950: Int = 0;
      val x6951 = x6950;
      x6950 = (x6951.^((((((x6949._1).hashCode()).+(-1640531527)).+((x6951.<<(6)))).+((x6951.>>(2))))))
      val x6961 = x6950;
      x6950 = (x6961.^((((((x6949._2).hashCode()).+(-1640531527)).+((x6961.<<(6)))).+((x6961.>>(2))))))
      val x6971 = x6950;
      x6950 = (x6971.^((((((x6949._3).hashCode()).+(-1640531527)).+((x6971.<<(6)))).+((x6971.>>(2))))))
      val x6981 = x6950;
      x6950 = (x6981.^((((((x6949._4).hashCode()).+(-1640531527)).+((x6981.<<(6)))).+((x6981.>>(2))))))
      val x6991 = x6950;
      x6950 = (x6991.^((((((x6949._5).hashCode()).+(-1640531527)).+((x6991.<<(6)))).+((x6991.>>(2))))))
      val x7001 = x6950;
      x6950 = (x7001.^((((((x6949._6).hashCode()).+(-1640531527)).+((x7001.<<(6)))).+((x7001.>>(2))))))
      val x7011 = x6950;
      x7011
    }
    override def cmp(x7013 : SEntry7_SSSSSSL , x7014 : SEntry7_SSSSSSL) = {
      var x7015: Int = 0;
      if(((x7013._1).==((x7014._1)))) {
        if(((x7013._2).==((x7014._2)))) {
          if(((x7013._3).==((x7014._3)))) {
            if(((x7013._4).==((x7014._4)))) {
              if(((x7013._5).==((x7014._5)))) {
                if(((x7013._6).==((x7014._6)))) {
                  x7015 = 0
                } else {
                  x7015 = 1
                }
              } else {
                x7015 = 1
              }
            } else {
              x7015 = 1
            }
          } else {
            x7015 = 1
          }
        } else {
          x7015 = 1
        }
      } else {
        x7015 = 1
      }
      val x7047 = x7015;
      x7047
    }
  }
  
  val x6815 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS12_mPERSON2 = new Store[SEntry3_SSL](3, x6815);
  val COUNT_mKNOWS12_mPERSON2Idx0 = COUNT_mKNOWS12_mPERSON2.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mPERSON2Idx1 = COUNT_mKNOWS12_mPERSON2.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mPERSON2Idx2 = COUNT_mKNOWS12_mPERSON2.index(2, IHash, false, -1)
  val x6822 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mKNOWS23 = new Store[SEntry3_SSL](2, x6822);
  val COUNT_mKNOWS23Idx0 = COUNT_mKNOWS23.index(0, IHash, true, -1)
  val COUNT_mKNOWS23Idx1 = COUNT_mKNOWS23.index(1, IHash, false, -1)
  val x6940 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345, SEntry6_SSSSSL_Idx5)
  val COUNT_mKNOWS12 = new Store[SEntry6_SSSSSL](2, x6940);
  val COUNT_mKNOWS12Idx0 = COUNT_mKNOWS12.index(0, IHash, true, -1)
  val COUNT_mKNOWS12Idx1 = COUNT_mKNOWS12.index(1, IHash, false, -1)
  val x6944 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mPERSON1 = new Store[SEntry3_SSL](2, x6944);
  val COUNT_mPERSON1Idx0 = COUNT_mPERSON1.index(0, IHash, true, -1)
  val COUNT_mPERSON1Idx1 = COUNT_mPERSON1.index(1, IHash, false, -1)
  val x7051 = Array[EntryIdx[SEntry7_SSSSSSL]](SEntry7_SSSSSSL_Idx123456)
  val COUNT = new Store[SEntry7_SSSSSSL](1, x7051);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  val x7138 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mPERSON2 = new Store[SEntry4_SSSL](2, x7138);
  val COUNT_mPERSON2Idx0 = COUNT_mPERSON2.index(0, IHash, true, -1)
  val COUNT_mPERSON2Idx1 = COUNT_mPERSON2.index(1, IHash, false, -1)
  val x7170 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx1)
  val COUNT_mMESSAGE1 = new Store[SEntry4_SSSL](2, x7170);
  val COUNT_mMESSAGE1Idx0 = COUNT_mMESSAGE1.index(0, IHash, true, -1)
  val COUNT_mMESSAGE1Idx1 = COUNT_mMESSAGE1.index(1, IHash, false, -1)
  
  
  
  val x9266 = SEntry3_SSL(null, null, -2147483648L);
  val x9297 = SEntry3_SSL(null, null, -2147483648L);
  val x8184 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8768 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8259 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9328 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8062 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x7631 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8432 = SEntry3_SSL(null, null, -2147483648L);
  val x7892 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x9356 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8449 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9076 = SEntry3_SSL(null, null, -2147483648L);
  val x8342 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7850 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8371 = SEntry3_SSL(null, null, -2147483648L);
  val x8046 = SEntry3_SSL(null, null, -2147483648L);
  val x9269 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8203 = SEntry3_SSL(null, null, -2147483648L);
  val x8812 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x7827 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7628 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7921 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9079 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8381 = SEntry3_SSL(null, null, -2147483648L);
  val x8348 = SEntry3_SSL(null, null, -2147483648L);
  val x7723 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9107 = SEntry3_SSL(null, null, -2147483648L);
  val x7830 = SEntry3_SSL(null, null, -2147483648L);
  val x9288 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8345 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8886 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8521 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x7860 = SEntry3_SSL(null, null, -2147483648L);
  val x8188 = SEntry3_SSL(null, null, -2147483648L);
  val x8362 = SEntry3_SSL(null, null, -2147483648L);
  val x8742 = SEntry3_SSL(null, null, -2147483648L);
  val x8220 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x7824 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8709 = SEntry3_SSL(null, null, -2147483648L);
  val x8723 = SEntry3_SSL(null, null, -2147483648L);
  val x9073 = SEntry3_SSL(null, null, -2147483648L);
  val x8031 = SEntry3_SSL(null, null, -2147483648L);
  val x7664 = SEntry3_SSL(null, null, -2147483648L);
  val x8406 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8732 = SEntry3_SSL(null, null, -2147483648L);
  val x8794 = SEntry3_SSL(null, null, -2147483648L);
  val x9137 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x9263 = SEntry3_SSL(null, null, -2147483648L);
  val x7654 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7695 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8706 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8100 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9098 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8703 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8027 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9164 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x7634 = SEntry3_SSL(null, null, -2147483648L);
  def onAddMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x7628._1_=(message_m_creatorid)
      val x18027 = COUNT_mMESSAGE1Idx1.sliceRes(x7628);
      if((x18027.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7628, ({ x24: SEntry4_SSSL => {
            x7654._3_=(message_m_creatorid)
            val x18023 = COUNT_mPERSON2Idx1.sliceRes(x7654);
            if((x18023.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x7654, ({ x29: SEntry4_SSSL => {
                  x7695._1_=(message_m_creatorid)
                  x7695._2_=((x24._2))
                  x7695._3_=((x24._3))
                  x7695._4_=(message_m_messageid)
                  x7695._5_=((x29._1))
                  x7695._6_=((x29._2))
                  x7695._7_=(((x24._4).*((x29._4))))
                  val x7696 = x7695._7;
                  if((x7696.==(0L))) {
                  } else {
                    val x13035 = COUNTIdx0.get(x7695);
                    if((x13035.==(null))) {
                      COUNT.unsafeInsert(x7695)
                    } else {
                      x13035._7 +=(x7696)
                      if(((x13035._7).==(0L))) {
                        COUNT.delete(x13035)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18023)
            }
            ()
          }
        }), x18027)
      }
      x7631._1_=(message_m_creatorid)
      val x18065 = COUNT_mMESSAGE1Idx1.sliceRes(x7631);
      if((x18065.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7631, ({ x53: SEntry4_SSSL => {
            x7664._2_=(message_m_creatorid)
            val x18061 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x7664);
            if((x18061.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x7664, ({ x58: SEntry3_SSL => {
                  x7723._1_=(message_m_creatorid)
                  x7723._2_=((x53._2))
                  x7723._3_=((x53._3))
                  x7723._4_=(message_m_messageid)
                  x7723._5_=((x58._1))
                  x7723._6_=(((x53._4).*((x58._3))))
                  val x7724 = x7723._6;
                  if((x7724.==(0L))) {
                  } else {
                    val x13068 = COUNT_mKNOWS12Idx0.get(x7723);
                    if((x13068.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x7723)
                    } else {
                      x13068._6 +=(x7724)
                      if(((x13068._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13068)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18061)
            }
            ()
          }
        }), x18065)
      }
      x7634._1_=(message_m_messageid)
      x7634._2_=(message_m_creatorid)
      x7634._3_=(1L)
      val x7635 = x7634._3;
      if((x7635.==(0L))) {
      } else {
        val x13087 = COUNT_mPERSON1Idx0.get(x7634);
        if((x13087.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x7634)
        } else {
          x13087._3 +=(x7635)
          if(((x13087._3).==(0L))) {
            COUNT_mPERSON1.delete(x13087)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x7824._1_=(message_m_creatorid)
      val x18121 = COUNT_mMESSAGE1Idx1.sliceRes(x7824);
      if((x18121.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7824, ({ x110: SEntry4_SSSL => {
            x7850._3_=(message_m_creatorid)
            val x18117 = COUNT_mPERSON2Idx1.sliceRes(x7850);
            if((x18117.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x7850, ({ x115: SEntry4_SSSL => {
                  x7892._1_=(message_m_creatorid)
                  x7892._2_=((x110._2))
                  x7892._3_=((x110._3))
                  x7892._4_=(message_m_messageid)
                  x7892._5_=((x115._1))
                  x7892._6_=((x115._2))
                  x7892._7_=(((x110._4).*(((x115._4).unary_-))))
                  val x7893 = x7892._7;
                  if((x7893.==(0L))) {
                  } else {
                    val x13208 = COUNTIdx0.get(x7892);
                    if((x13208.==(null))) {
                      COUNT.unsafeInsert(x7892)
                    } else {
                      x13208._7 +=(x7893)
                      if(((x13208._7).==(0L))) {
                        COUNT.delete(x13208)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18117)
            }
            ()
          }
        }), x18121)
      }
      x7827._1_=(message_m_creatorid)
      val x18160 = COUNT_mMESSAGE1Idx1.sliceRes(x7827);
      if((x18160.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7827, ({ x140: SEntry4_SSSL => {
            x7860._2_=(message_m_creatorid)
            val x18156 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x7860);
            if((x18156.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x7860, ({ x145: SEntry3_SSL => {
                  x7921._1_=(message_m_creatorid)
                  x7921._2_=((x140._2))
                  x7921._3_=((x140._3))
                  x7921._4_=(message_m_messageid)
                  x7921._5_=((x145._1))
                  x7921._6_=(((x140._4).*(((x145._3).unary_-))))
                  val x7922 = x7921._6;
                  if((x7922.==(0L))) {
                  } else {
                    val x13242 = COUNT_mKNOWS12Idx0.get(x7921);
                    if((x13242.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x7921)
                    } else {
                      x13242._6 +=(x7922)
                      if(((x13242._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13242)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18156)
            }
            ()
          }
        }), x18160)
      }
      x7830._1_=(message_m_messageid)
      x7830._2_=(message_m_creatorid)
      x7830._3_=(-1L)
      val x7831 = x7830._3;
      if((x7831.==(0L))) {
      } else {
        val x13261 = COUNT_mPERSON1Idx0.get(x7830);
        if((x13261.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x7830)
        } else {
          x13261._3 +=(x7831)
          if(((x13261._3).==(0L))) {
            COUNT_mPERSON1.delete(x13261)
          } else {
          }
        }
      }
    
    }
  
  }
  def onAddKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x189 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x189) {
        x8027._5_=(knows1_k_personid2)
        val x18211 = COUNT_mKNOWS12Idx1.sliceRes(x8027);
        if((x18211.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x8027, ({ x191: SEntry6_SSSSSL => {
              val x8055 = x191._1;
              val x199 = if((x8055.!=(knows1_k_personid1))) {
              (x191._6)
              } else {
              0L
              };
              x8062._1_=(x8055)
              x8062._2_=((x191._2))
              x8062._3_=((x191._3))
              x8062._4_=((x191._4))
              x8062._5_=(knows1_k_personid1)
              x8062._6_=(knows1_k_personid2)
              x8062._7_=(x199)
              val x8063 = x8062._7;
              if((x8063.==(0L))) {
              } else {
                val x13383 = COUNTIdx0.get(x8062);
                if((x13383.==(null))) {
                  COUNT.unsafeInsert(x8062)
                } else {
                  x13383._7 +=(x8063)
                  if(((x13383._7).==(0L))) {
                    COUNT.delete(x13383)
                  } else {
                  }
                }
              }
            
            }
          }), x18211)
        }
      } else {
      }
      x8031._1_=(knows1_k_personid1)
      x8031._2_=(knows1_k_personid2)
      x8031._3_=((if(x189) 1L else 0L))
      val x8032 = x8031._3;
      if((x8032.==(0L))) {
      } else {
        val x13401 = COUNT_mKNOWS23Idx0.get(x8031);
        if((x13401.==(null))) {
          COUNT_mKNOWS23.unsafeInsert(x8031)
        } else {
          x13401._3 +=(x8032)
          if(((x13401._3).==(0L))) {
            COUNT_mKNOWS23.delete(x13401)
          } else {
          }
        }
      }
      if(x189) {
        x8046._1_=(knows1_k_personid2)
        val x18255 = COUNT_mKNOWS12_mPERSON2Idx2.sliceRes(x8046);
        if((x18255.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mPERSON2Idx2.sliceResMapNoUpd(x8046, ({ x233: SEntry3_SSL => {
              val x8096 = x233._2;
              val x238 = if((x8096.!=(knows1_k_personid1))) {
              (x233._3)
              } else {
              0L
              };
              x8100._1_=(knows1_k_personid1)
              x8100._2_=(knows1_k_personid2)
              x8100._3_=(x8096)
              x8100._4_=(x238)
              val x8101 = x8100._4;
              if((x8101.==(0L))) {
              } else {
                val x13427 = COUNT_mPERSON2Idx0.get(x8100);
                if((x13427.==(null))) {
                  COUNT_mPERSON2.unsafeInsert(x8100)
                } else {
                  x13427._4 +=(x8101)
                  if(((x13427._4).==(0L))) {
                    COUNT_mPERSON2.delete(x13427)
                  } else {
                  }
                }
              }
            
            }
          }), x18255)
        }
      } else {
      }
    
    }
  
  }
  def onDelKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x262 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x262) {
        x8184._5_=(knows1_k_personid2)
        val x18292 = COUNT_mKNOWS12Idx1.sliceRes(x8184);
        if((x18292.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x8184, ({ x264: SEntry6_SSSSSL => {
              val x8212 = x264._1;
              if((x8212.!=(knows1_k_personid1))) {
                x8220._1_=(x8212)
                x8220._2_=((x264._2))
                x8220._3_=((x264._3))
                x8220._4_=((x264._4))
                x8220._5_=(knows1_k_personid1)
                x8220._6_=(knows1_k_personid2)
                x8220._7_=(((x264._6).unary_-))
                val x8221 = x8220._7;
                if((x8221.==(0L))) {
                } else {
                  val x13542 = COUNTIdx0.get(x8220);
                  if((x13542.==(null))) {
                    COUNT.unsafeInsert(x8220)
                  } else {
                    x13542._7 +=(x8221)
                    if(((x13542._7).==(0L))) {
                      COUNT.delete(x13542)
                    } else {
                    }
                  }
                }
              } else {
              }
              ()
            }
          }), x18292)
        }
      } else {
      }
      if(x262) {
        x8188._1_=(knows1_k_personid1)
        x8188._2_=(knows1_k_personid2)
        x8188._3_=(-1L)
        val x8189 = x8188._3;
        if((x8189.==(0L))) {
        } else {
          val x13560 = COUNT_mKNOWS23Idx0.get(x8188);
          if((x13560.==(null))) {
            COUNT_mKNOWS23.unsafeInsert(x8188)
          } else {
            x13560._3 +=(x8189)
            if(((x13560._3).==(0L))) {
              COUNT_mKNOWS23.delete(x13560)
            } else {
            }
          }
        }
      } else {
      }
      if(x262) {
        x8203._1_=(knows1_k_personid2)
        val x18337 = COUNT_mKNOWS12_mPERSON2Idx2.sliceRes(x8203);
        if((x18337.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mPERSON2Idx2.sliceResMapNoUpd(x8203, ({ x306: SEntry3_SSL => {
              val x8254 = x306._2;
              if((x8254.!=(knows1_k_personid1))) {
                x8259._1_=(knows1_k_personid1)
                x8259._2_=(knows1_k_personid2)
                x8259._3_=(x8254)
                x8259._4_=(((x306._3).unary_-))
                val x8260 = x8259._4;
                if((x8260.==(0L))) {
                } else {
                  val x13587 = COUNT_mPERSON2Idx0.get(x8259);
                  if((x13587.==(null))) {
                    COUNT_mPERSON2.unsafeInsert(x8259)
                  } else {
                    x13587._4 +=(x8260)
                    if(((x13587._4).==(0L))) {
                      COUNT_mPERSON2.delete(x13587)
                    } else {
                    }
                  }
                }
              } else {
              }
              ()
            }
          }), x18337)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x8342._1_=(knows2_k_personid2)
      val x18388 = COUNT_mMESSAGE1Idx1.sliceRes(x8342);
      if((x18388.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8342, ({ x335: SEntry4_SSSL => {
            x8371._2_=(knows2_k_personid2)
            val x18384 = COUNT_mPERSON1Idx1.sliceRes(x8371);
            if((x18384.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8371, ({ x340: SEntry3_SSL => {
                  x8432._2_=(knows2_k_personid1)
                  val x18380 = COUNT_mKNOWS23Idx1.sliceRes(x8432);
                  if((x18380.isEmpty)) {
                  } else {
                    COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8432, ({ x344: SEntry3_SSL => {
                        val x8515 = x344._1;
                        val x349 = if((knows2_k_personid2.!=(x8515))) {
                        (x344._3)
                        } else {
                        0L
                        };
                        x8521._1_=(knows2_k_personid2)
                        x8521._2_=((x335._2))
                        x8521._3_=((x335._3))
                        x8521._4_=((x340._1))
                        x8521._5_=(x8515)
                        x8521._6_=(knows2_k_personid1)
                        x8521._7_=(((x335._4).*(((x340._3).*(x349)))))
                        val x8522 = x8521._7;
                        if((x8522.==(0L))) {
                        } else {
                          val x13710 = COUNTIdx0.get(x8521);
                          if((x13710.==(null))) {
                            COUNT.unsafeInsert(x8521)
                          } else {
                            x13710._7 +=(x8522)
                            if(((x13710._7).==(0L))) {
                              COUNT.delete(x13710)
                            } else {
                            }
                          }
                        }
                      
                      }
                    }), x18380)
                  }
                  ()
                }
              }), x18384)
            }
            ()
          }
        }), x18388)
      }
      x8345._1_=(knows2_k_personid2)
      val x18426 = COUNT_mMESSAGE1Idx1.sliceRes(x8345);
      if((x18426.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8345, ({ x373: SEntry4_SSSL => {
            x8381._2_=(knows2_k_personid2)
            val x18422 = COUNT_mPERSON1Idx1.sliceRes(x8381);
            if((x18422.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8381, ({ x378: SEntry3_SSL => {
                  x8449._1_=(knows2_k_personid2)
                  x8449._2_=((x373._2))
                  x8449._3_=((x373._3))
                  x8449._4_=((x378._1))
                  x8449._5_=(knows2_k_personid1)
                  x8449._6_=(((x373._4).*((x378._3))))
                  val x8450 = x8449._6;
                  if((x8450.==(0L))) {
                  } else {
                    val x13744 = COUNT_mKNOWS12Idx0.get(x8449);
                    if((x13744.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x8449)
                    } else {
                      x13744._6 +=(x8450)
                      if(((x13744._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13744)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18422)
            }
            ()
          }
        }), x18426)
      }
      x8348._1_=(knows2_k_personid1)
      x8348._2_=(knows2_k_personid2)
      x8348._3_=(1L)
      val x8349 = x8348._3;
      if((x8349.==(0L))) {
      } else {
        val x13763 = COUNT_mKNOWS12_mPERSON2Idx0.get(x8348);
        if((x13763.==(null))) {
          COUNT_mKNOWS12_mPERSON2.unsafeInsert(x8348)
        } else {
          x13763._3 +=(x8349)
          if(((x13763._3).==(0L))) {
            COUNT_mKNOWS12_mPERSON2.delete(x13763)
          } else {
          }
        }
      }
      x8362._2_=(knows2_k_personid1)
      val x18468 = COUNT_mKNOWS23Idx1.sliceRes(x8362);
      if((x18468.isEmpty)) {
      } else {
        COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8362, ({ x415: SEntry3_SSL => {
            val x8402 = x415._1;
            val x420 = if((knows2_k_personid2.!=(x8402))) {
            (x415._3)
            } else {
            0L
            };
            x8406._1_=(x8402)
            x8406._2_=(knows2_k_personid1)
            x8406._3_=(knows2_k_personid2)
            x8406._4_=(x420)
            val x8407 = x8406._4;
            if((x8407.==(0L))) {
            } else {
              val x13789 = COUNT_mPERSON2Idx0.get(x8406);
              if((x13789.==(null))) {
                COUNT_mPERSON2.unsafeInsert(x8406)
              } else {
                x13789._4 +=(x8407)
                if(((x13789._4).==(0L))) {
                  COUNT_mPERSON2.delete(x13789)
                } else {
                }
              }
            }
          
          }
        }), x18468)
      }
    
    }
  
  }
  def onDelKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x8703._1_=(knows2_k_personid2)
      val x18520 = COUNT_mMESSAGE1Idx1.sliceRes(x8703);
      if((x18520.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8703, ({ x443: SEntry4_SSSL => {
            x8732._2_=(knows2_k_personid2)
            val x18516 = COUNT_mPERSON1Idx1.sliceRes(x8732);
            if((x18516.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8732, ({ x448: SEntry3_SSL => {
                  x8794._2_=(knows2_k_personid1)
                  val x18512 = COUNT_mKNOWS23Idx1.sliceRes(x8794);
                  if((x18512.isEmpty)) {
                  } else {
                    COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8794, ({ x452: SEntry3_SSL => {
                        val x8879 = x452._1;
                        if((knows2_k_personid2.!=(x8879))) {
                          x8886._1_=(knows2_k_personid2)
                          x8886._2_=((x443._2))
                          x8886._3_=((x443._3))
                          x8886._4_=((x448._1))
                          x8886._5_=(x8879)
                          x8886._6_=(knows2_k_personid1)
                          x8886._7_=(((x443._4).*(((x448._3).*(((x452._3).unary_-))))))
                          val x8887 = x8886._7;
                          if((x8887.==(0L))) {
                          } else {
                            val x13953 = COUNTIdx0.get(x8886);
                            if((x13953.==(null))) {
                              COUNT.unsafeInsert(x8886)
                            } else {
                              x13953._7 +=(x8887)
                              if(((x13953._7).==(0L))) {
                                COUNT.delete(x13953)
                              } else {
                              }
                            }
                          }
                        } else {
                        }
                        ()
                      }
                    }), x18512)
                  }
                  ()
                }
              }), x18516)
            }
            ()
          }
        }), x18520)
      }
      x8706._1_=(knows2_k_personid2)
      val x18559 = COUNT_mMESSAGE1Idx1.sliceRes(x8706);
      if((x18559.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8706, ({ x481: SEntry4_SSSL => {
            x8742._2_=(knows2_k_personid2)
            val x18555 = COUNT_mPERSON1Idx1.sliceRes(x8742);
            if((x18555.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8742, ({ x486: SEntry3_SSL => {
                  x8812._1_=(knows2_k_personid2)
                  x8812._2_=((x481._2))
                  x8812._3_=((x481._3))
                  x8812._4_=((x486._1))
                  x8812._5_=(knows2_k_personid1)
                  x8812._6_=(((x481._4).*(((x486._3).unary_-))))
                  val x8813 = x8812._6;
                  if((x8813.==(0L))) {
                  } else {
                    val x13988 = COUNT_mKNOWS12Idx0.get(x8812);
                    if((x13988.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x8812)
                    } else {
                      x13988._6 +=(x8813)
                      if(((x13988._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13988)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18555)
            }
            ()
          }
        }), x18559)
      }
      x8709._1_=(knows2_k_personid1)
      x8709._2_=(knows2_k_personid2)
      x8709._3_=(-1L)
      val x8710 = x8709._3;
      if((x8710.==(0L))) {
      } else {
        val x14007 = COUNT_mKNOWS12_mPERSON2Idx0.get(x8709);
        if((x14007.==(null))) {
          COUNT_mKNOWS12_mPERSON2.unsafeInsert(x8709)
        } else {
          x14007._3 +=(x8710)
          if(((x14007._3).==(0L))) {
            COUNT_mKNOWS12_mPERSON2.delete(x14007)
          } else {
          }
        }
      }
      x8723._2_=(knows2_k_personid1)
      val x18602 = COUNT_mKNOWS23Idx1.sliceRes(x8723);
      if((x18602.isEmpty)) {
      } else {
        COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8723, ({ x524: SEntry3_SSL => {
            val x8763 = x524._1;
            if((knows2_k_personid2.!=(x8763))) {
              x8768._1_=(x8763)
              x8768._2_=(knows2_k_personid1)
              x8768._3_=(knows2_k_personid2)
              x8768._4_=(((x524._3).unary_-))
              val x8769 = x8768._4;
              if((x8769.==(0L))) {
              } else {
                val x14034 = COUNT_mPERSON2Idx0.get(x8768);
                if((x14034.==(null))) {
                  COUNT_mPERSON2.unsafeInsert(x8768)
                } else {
                  x14034._4 +=(x8769)
                  if(((x14034._4).==(0L))) {
                    COUNT_mPERSON2.delete(x14034)
                  } else {
                  }
                }
              }
            } else {
            }
            ()
          }
        }), x18602)
      }
    
    }
  
  }
  def onAddPERSON(person_p_op_time:String, person_p_op:String, person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x9073._2_=(person_p_personid)
      val x18641 = COUNT_mPERSON1Idx1.sliceRes(x9073);
      if((x18641.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9073, ({ x560: SEntry3_SSL => {
            x9098._3_=(person_p_personid)
            val x18637 = COUNT_mPERSON2Idx1.sliceRes(x9098);
            if((x18637.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x9098, ({ x564: SEntry4_SSSL => {
                  x9137._1_=(person_p_personid)
                  x9137._2_=(person_p_firstname)
                  x9137._3_=(person_p_lastname)
                  x9137._4_=((x560._1))
                  x9137._5_=((x564._1))
                  x9137._6_=((x564._2))
                  x9137._7_=(((x560._3).*((x564._4))))
                  val x9138 = x9137._7;
                  if((x9138.==(0L))) {
                  } else {
                    val x14192 = COUNTIdx0.get(x9137);
                    if((x14192.==(null))) {
                      COUNT.unsafeInsert(x9137)
                    } else {
                      x14192._7 +=(x9138)
                      if(((x14192._7).==(0L))) {
                        COUNT.delete(x14192)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18637)
            }
            ()
          }
        }), x18641)
      }
      x9076._2_=(person_p_personid)
      val x18678 = COUNT_mPERSON1Idx1.sliceRes(x9076);
      if((x18678.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9076, ({ x588: SEntry3_SSL => {
            x9107._2_=(person_p_personid)
            val x18674 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x9107);
            if((x18674.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x9107, ({ x592: SEntry3_SSL => {
                  x9164._1_=(person_p_personid)
                  x9164._2_=(person_p_firstname)
                  x9164._3_=(person_p_lastname)
                  x9164._4_=((x588._1))
                  x9164._5_=((x592._1))
                  x9164._6_=(((x588._3).*((x592._3))))
                  val x9165 = x9164._6;
                  if((x9165.==(0L))) {
                  } else {
                    val x14224 = COUNT_mKNOWS12Idx0.get(x9164);
                    if((x14224.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x9164)
                    } else {
                      x14224._6 +=(x9165)
                      if(((x14224._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x14224)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18674)
            }
            ()
          }
        }), x18678)
      }
      x9079._1_=(person_p_personid)
      x9079._2_=(person_p_firstname)
      x9079._3_=(person_p_lastname)
      x9079._4_=(1L)
      val x9080 = x9079._4;
      if((x9080.==(0L))) {
      } else {
        val x14244 = COUNT_mMESSAGE1Idx0.get(x9079);
        if((x14244.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x9079)
        } else {
          x14244._4 +=(x9080)
          if(((x14244._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x14244)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelPERSON(person_p_op_time:String, person_p_op:String, person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x9263._2_=(person_p_personid)
      val x18734 = COUNT_mPERSON1Idx1.sliceRes(x9263);
      if((x18734.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9263, ({ x642: SEntry3_SSL => {
            x9288._3_=(person_p_personid)
            val x18730 = COUNT_mPERSON2Idx1.sliceRes(x9288);
            if((x18730.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x9288, ({ x646: SEntry4_SSSL => {
                  x9328._1_=(person_p_personid)
                  x9328._2_=(person_p_firstname)
                  x9328._3_=(person_p_lastname)
                  x9328._4_=((x642._1))
                  x9328._5_=((x646._1))
                  x9328._6_=((x646._2))
                  x9328._7_=(((x642._3).*(((x646._4).unary_-))))
                  val x9329 = x9328._7;
                  if((x9329.==(0L))) {
                  } else {
                    val x14363 = COUNTIdx0.get(x9328);
                    if((x14363.==(null))) {
                      COUNT.unsafeInsert(x9328)
                    } else {
                      x14363._7 +=(x9329)
                      if(((x14363._7).==(0L))) {
                        COUNT.delete(x14363)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18730)
            }
            ()
          }
        }), x18734)
      }
      x9266._2_=(person_p_personid)
      val x18772 = COUNT_mPERSON1Idx1.sliceRes(x9266);
      if((x18772.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9266, ({ x671: SEntry3_SSL => {
            x9297._2_=(person_p_personid)
            val x18768 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x9297);
            if((x18768.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x9297, ({ x675: SEntry3_SSL => {
                  x9356._1_=(person_p_personid)
                  x9356._2_=(person_p_firstname)
                  x9356._3_=(person_p_lastname)
                  x9356._4_=((x671._1))
                  x9356._5_=((x675._1))
                  x9356._6_=(((x671._3).*(((x675._3).unary_-))))
                  val x9357 = x9356._6;
                  if((x9357.==(0L))) {
                  } else {
                    val x14396 = COUNT_mKNOWS12Idx0.get(x9356);
                    if((x14396.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x9356)
                    } else {
                      x14396._6 +=(x9357)
                      if(((x14396._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x14396)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18768)
            }
            ()
          }
        }), x18772)
      }
      x9269._1_=(person_p_personid)
      x9269._2_=(person_p_firstname)
      x9269._3_=(person_p_lastname)
      x9269._4_=(-1L)
      val x9270 = x9269._4;
      if((x9270.==(0L))) {
      } else {
        val x14416 = COUNT_mMESSAGE1Idx0.get(x9269);
        if((x14416.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x9269)
        } else {
          x14416._4 +=(x9270)
          if(((x14416._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x14416)
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

  val preg1 = java.util.regex.Pattern.compile("^.{0,5}$");
}

class Rsnb_q3_0_003 extends Rsnb_q3_0_003Base with Actor {
  import ddbt.lib.Messages._
  import ddbt.lib.Functions._
  import Rsnb_q3_0_003._
  
  var t0 = 0L; var t1 = 0L; var tN = 0L; var tS = 0L

  

  

  def receive_skip: Receive = { 
    case EndOfStream | GetSnapshot(_) => 
       sender ! (StreamStat(t1 - t0, tN, tS), null)
    case _ => tS += 1L
  }

  def receive = {
    case TupleEvent(TupleInsert, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String,v13:String,v14:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddMESSAGE(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14)
    case TupleEvent(TupleDelete, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String,v13:String,v14:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelMESSAGE(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14)
    case TupleEvent(TupleInsert, "KNOWS1", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddKNOWS1(v0,v1,v2,v3,v4)
    case TupleEvent(TupleDelete, "KNOWS1", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelKNOWS1(v0,v1,v2,v3,v4)
    case TupleEvent(TupleInsert, "KNOWS2", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddKNOWS2(v0,v1,v2,v3,v4)
    case TupleEvent(TupleDelete, "KNOWS2", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelKNOWS2(v0,v1,v2,v3,v4)
    case TupleEvent(TupleInsert, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12)
    case TupleEvent(TupleDelete, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12)
    case StreamInit(timeout) => 
      
      onSystemReady();
      t0 = System.nanoTime;
      if (timeout > 0) t1 = t0 + timeout * 1000000L
    case EndOfStream | GetSnapshot(_) => 
      t1 = System.nanoTime; 
       sender ! (StreamStat(t1 - t0, tN, tS), List({ val COUNT_node_mres = new scala.collection.mutable.HashMap[(String, String, String, String, String, String),Long](); COUNT.foreach{e => COUNT_node_mres += (((e._1, e._2, e._3, e._4, e._5, e._6),e._7)) }; COUNT_node_mres.toMap }))
  }
}