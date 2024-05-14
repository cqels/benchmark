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
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.person.window.csv"),new Adaptor.CSV("PERSON","string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split())
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
    override def hash(x7051 : SEntry4_SSSL) = {
      var x7052: Int = 0;
      val x7053 = x7052;
      x7052 = (x7053.^((((((x7051._1).hashCode()).+(-1640531527)).+((x7053.<<(6)))).+((x7053.>>(2))))))
      val x7063 = x7052;
      x7052 = (x7063.^((((((x7051._2).hashCode()).+(-1640531527)).+((x7063.<<(6)))).+((x7063.>>(2))))))
      val x7073 = x7052;
      x7052 = (x7073.^((((((x7051._3).hashCode()).+(-1640531527)).+((x7073.<<(6)))).+((x7073.>>(2))))))
      val x7083 = x7052;
      x7083
    }
    override def cmp(x7085 : SEntry4_SSSL , x7086 : SEntry4_SSSL) = {
      var x7087: Int = 0;
      if(((x7085._1).==((x7086._1)))) {
        if(((x7085._2).==((x7086._2)))) {
          if(((x7085._3).==((x7086._3)))) {
            x7087 = 0
          } else {
            x7087 = 1
          }
        } else {
          x7087 = 1
        }
      } else {
        x7087 = 1
      }
      val x7104 = x7087;
      x7104
    }
  }
   object SEntry6_SSSSSL_Idx12345 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x6823 : SEntry6_SSSSSL) = {
      var x6824: Int = 0;
      val x6825 = x6824;
      x6824 = (x6825.^((((((x6823._1).hashCode()).+(-1640531527)).+((x6825.<<(6)))).+((x6825.>>(2))))))
      val x6835 = x6824;
      x6824 = (x6835.^((((((x6823._2).hashCode()).+(-1640531527)).+((x6835.<<(6)))).+((x6835.>>(2))))))
      val x6845 = x6824;
      x6824 = (x6845.^((((((x6823._3).hashCode()).+(-1640531527)).+((x6845.<<(6)))).+((x6845.>>(2))))))
      val x6855 = x6824;
      x6824 = (x6855.^((((((x6823._4).hashCode()).+(-1640531527)).+((x6855.<<(6)))).+((x6855.>>(2))))))
      val x6865 = x6824;
      x6824 = (x6865.^((((((x6823._5).hashCode()).+(-1640531527)).+((x6865.<<(6)))).+((x6865.>>(2))))))
      val x6875 = x6824;
      x6875
    }
    override def cmp(x6877 : SEntry6_SSSSSL , x6878 : SEntry6_SSSSSL) = {
      var x6879: Int = 0;
      if(((x6877._1).==((x6878._1)))) {
        if(((x6877._2).==((x6878._2)))) {
          if(((x6877._3).==((x6878._3)))) {
            if(((x6877._4).==((x6878._4)))) {
              if(((x6877._5).==((x6878._5)))) {
                x6879 = 0
              } else {
                x6879 = 1
              }
            } else {
              x6879 = 1
            }
          } else {
            x6879 = 1
          }
        } else {
          x6879 = 1
        }
      } else {
        x6879 = 1
      }
      val x6906 = x6879;
      x6906
    }
  }
   object SEntry3_SSL_Idx12 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6717 : SEntry3_SSL) = {
      var x6718: Int = 0;
      val x6719 = x6718;
      x6718 = (x6719.^((((((x6717._1).hashCode()).+(-1640531527)).+((x6719.<<(6)))).+((x6719.>>(2))))))
      val x6729 = x6718;
      x6718 = (x6729.^((((((x6717._2).hashCode()).+(-1640531527)).+((x6729.<<(6)))).+((x6729.>>(2))))))
      val x6739 = x6718;
      x6739
    }
    override def cmp(x6741 : SEntry3_SSL , x6742 : SEntry3_SSL) = {
      var x6743: Int = 0;
      if(((x6741._1).==((x6742._1)))) {
        if(((x6741._2).==((x6742._2)))) {
          x6743 = 0
        } else {
          x6743 = 1
        }
      } else {
        x6743 = 1
      }
      val x6755 = x6743;
      x6755
    }
  }
   object SEntry4_SSSL_Idx3 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x7107 : SEntry4_SSSL) = {
      var x7108: Int = 0;
      val x7109 = x7108;
      x7108 = (x7109.^((((((x7107._3).hashCode()).+(-1640531527)).+((x7109.<<(6)))).+((x7109.>>(2))))))
      val x7119 = x7108;
      x7119
    }
    override def cmp(x7121 : SEntry4_SSSL , x7122 : SEntry4_SSSL) = {
      var x7123: Int = 0;
      if(((x7121._3).==((x7122._3)))) {
        x7123 = 0
      } else {
        x7123 = 1
      }
      val x7130 = x7123;
      x7130
    }
  }
   object SEntry4_SSSL_Idx1 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x7139 : SEntry4_SSSL) = {
      var x7140: Int = 0;
      val x7141 = x7140;
      x7140 = (x7141.^((((((x7139._1).hashCode()).+(-1640531527)).+((x7141.<<(6)))).+((x7141.>>(2))))))
      val x7151 = x7140;
      x7151
    }
    override def cmp(x7153 : SEntry4_SSSL , x7154 : SEntry4_SSSL) = {
      var x7155: Int = 0;
      if(((x7153._1).==((x7154._1)))) {
        x7155 = 0
      } else {
        x7155 = 1
      }
      val x7162 = x7155;
      x7162
    }
  }
   object SEntry3_SSL_Idx2 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6758 : SEntry3_SSL) = {
      var x6759: Int = 0;
      val x6760 = x6759;
      x6759 = (x6760.^((((((x6758._2).hashCode()).+(-1640531527)).+((x6760.<<(6)))).+((x6760.>>(2))))))
      val x6770 = x6759;
      x6770
    }
    override def cmp(x6772 : SEntry3_SSL , x6773 : SEntry3_SSL) = {
      var x6774: Int = 0;
      if(((x6772._2).==((x6773._2)))) {
        x6774 = 0
      } else {
        x6774 = 1
      }
      val x6781 = x6774;
      x6781
    }
  }
   object SEntry3_SSL_Idx1 extends EntryIdx[SEntry3_SSL] {
    override def hash(x6784 : SEntry3_SSL) = {
      var x6785: Int = 0;
      val x6786 = x6785;
      x6785 = (x6786.^((((((x6784._1).hashCode()).+(-1640531527)).+((x6786.<<(6)))).+((x6786.>>(2))))))
      val x6796 = x6785;
      x6796
    }
    override def cmp(x6798 : SEntry3_SSL , x6799 : SEntry3_SSL) = {
      var x6800: Int = 0;
      if(((x6798._1).==((x6799._1)))) {
        x6800 = 0
      } else {
        x6800 = 1
      }
      val x6807 = x6800;
      x6807
    }
  }
   object SEntry6_SSSSSL_Idx5 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x6909 : SEntry6_SSSSSL) = {
      var x6910: Int = 0;
      val x6911 = x6910;
      x6910 = (x6911.^((((((x6909._5).hashCode()).+(-1640531527)).+((x6911.<<(6)))).+((x6911.>>(2))))))
      val x6921 = x6910;
      x6921
    }
    override def cmp(x6923 : SEntry6_SSSSSL , x6924 : SEntry6_SSSSSL) = {
      var x6925: Int = 0;
      if(((x6923._5).==((x6924._5)))) {
        x6925 = 0
      } else {
        x6925 = 1
      }
      val x6932 = x6925;
      x6932
    }
  }
   object SEntry7_SSSSSSL_Idx123456 extends EntryIdx[SEntry7_SSSSSSL] {
    override def hash(x6945 : SEntry7_SSSSSSL) = {
      var x6946: Int = 0;
      val x6947 = x6946;
      x6946 = (x6947.^((((((x6945._1).hashCode()).+(-1640531527)).+((x6947.<<(6)))).+((x6947.>>(2))))))
      val x6957 = x6946;
      x6946 = (x6957.^((((((x6945._2).hashCode()).+(-1640531527)).+((x6957.<<(6)))).+((x6957.>>(2))))))
      val x6967 = x6946;
      x6946 = (x6967.^((((((x6945._3).hashCode()).+(-1640531527)).+((x6967.<<(6)))).+((x6967.>>(2))))))
      val x6977 = x6946;
      x6946 = (x6977.^((((((x6945._4).hashCode()).+(-1640531527)).+((x6977.<<(6)))).+((x6977.>>(2))))))
      val x6987 = x6946;
      x6946 = (x6987.^((((((x6945._5).hashCode()).+(-1640531527)).+((x6987.<<(6)))).+((x6987.>>(2))))))
      val x6997 = x6946;
      x6946 = (x6997.^((((((x6945._6).hashCode()).+(-1640531527)).+((x6997.<<(6)))).+((x6997.>>(2))))))
      val x7007 = x6946;
      x7007
    }
    override def cmp(x7009 : SEntry7_SSSSSSL , x7010 : SEntry7_SSSSSSL) = {
      var x7011: Int = 0;
      if(((x7009._1).==((x7010._1)))) {
        if(((x7009._2).==((x7010._2)))) {
          if(((x7009._3).==((x7010._3)))) {
            if(((x7009._4).==((x7010._4)))) {
              if(((x7009._5).==((x7010._5)))) {
                if(((x7009._6).==((x7010._6)))) {
                  x7011 = 0
                } else {
                  x7011 = 1
                }
              } else {
                x7011 = 1
              }
            } else {
              x7011 = 1
            }
          } else {
            x7011 = 1
          }
        } else {
          x7011 = 1
        }
      } else {
        x7011 = 1
      }
      val x7043 = x7011;
      x7043
    }
  }
  
  val x6811 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS12_mPERSON2 = new Store[SEntry3_SSL](3, x6811);
  val COUNT_mKNOWS12_mPERSON2Idx0 = COUNT_mKNOWS12_mPERSON2.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mPERSON2Idx1 = COUNT_mKNOWS12_mPERSON2.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mPERSON2Idx2 = COUNT_mKNOWS12_mPERSON2.index(2, IHash, false, -1)
  val x6818 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mKNOWS23 = new Store[SEntry3_SSL](2, x6818);
  val COUNT_mKNOWS23Idx0 = COUNT_mKNOWS23.index(0, IHash, true, -1)
  val COUNT_mKNOWS23Idx1 = COUNT_mKNOWS23.index(1, IHash, false, -1)
  val x6936 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345, SEntry6_SSSSSL_Idx5)
  val COUNT_mKNOWS12 = new Store[SEntry6_SSSSSL](2, x6936);
  val COUNT_mKNOWS12Idx0 = COUNT_mKNOWS12.index(0, IHash, true, -1)
  val COUNT_mKNOWS12Idx1 = COUNT_mKNOWS12.index(1, IHash, false, -1)
  val x6940 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mPERSON1 = new Store[SEntry3_SSL](2, x6940);
  val COUNT_mPERSON1Idx0 = COUNT_mPERSON1.index(0, IHash, true, -1)
  val COUNT_mPERSON1Idx1 = COUNT_mPERSON1.index(1, IHash, false, -1)
  val x7047 = Array[EntryIdx[SEntry7_SSSSSSL]](SEntry7_SSSSSSL_Idx123456)
  val COUNT = new Store[SEntry7_SSSSSSL](1, x7047);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  val x7134 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mPERSON2 = new Store[SEntry4_SSSL](2, x7134);
  val COUNT_mPERSON2Idx0 = COUNT_mPERSON2.index(0, IHash, true, -1)
  val COUNT_mPERSON2Idx1 = COUNT_mPERSON2.index(1, IHash, false, -1)
  val x7166 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx1)
  val COUNT_mMESSAGE1 = new Store[SEntry4_SSSL](2, x7166);
  val COUNT_mMESSAGE1Idx0 = COUNT_mMESSAGE1.index(0, IHash, true, -1)
  val COUNT_mMESSAGE1Idx1 = COUNT_mMESSAGE1.index(1, IHash, false, -1)
  
  
  
  val x8096 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8184 = SEntry3_SSL(null, null, -2147483648L);
  val x7846 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8445 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9133 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8255 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7627 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9259 = SEntry3_SSL(null, null, -2147483648L);
  val x9352 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8428 = SEntry3_SSL(null, null, -2147483648L);
  val x8180 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x7650 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7691 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x7630 = SEntry3_SSL(null, null, -2147483648L);
  val x7820 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7624 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8344 = SEntry3_SSL(null, null, -2147483648L);
  val x8790 = SEntry3_SSL(null, null, -2147483648L);
  val x7826 = SEntry3_SSL(null, null, -2147483648L);
  val x8882 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8719 = SEntry3_SSL(null, null, -2147483648L);
  val x8042 = SEntry3_SSL(null, null, -2147483648L);
  val x8702 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9262 = SEntry3_SSL(null, null, -2147483648L);
  val x8808 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8728 = SEntry3_SSL(null, null, -2147483648L);
  val x9094 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9103 = SEntry3_SSL(null, null, -2147483648L);
  val x7719 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x9072 = SEntry3_SSL(null, null, -2147483648L);
  val x8764 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9069 = SEntry3_SSL(null, null, -2147483648L);
  val x9293 = SEntry3_SSL(null, null, -2147483648L);
  val x9160 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x7917 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8738 = SEntry3_SSL(null, null, -2147483648L);
  val x8367 = SEntry3_SSL(null, null, -2147483648L);
  val x8402 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9075 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x9265 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7660 = SEntry3_SSL(null, null, -2147483648L);
  val x8705 = SEntry3_SSL(null, null, -2147483648L);
  val x9324 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8517 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8023 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x8377 = SEntry3_SSL(null, null, -2147483648L);
  val x7856 = SEntry3_SSL(null, null, -2147483648L);
  val x9284 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7823 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8199 = SEntry3_SSL(null, null, -2147483648L);
  val x8058 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8216 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8341 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8699 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x7888 = SEntry7_SSSSSSL(null, null, null, null, null, null, -2147483648L);
  val x8338 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x8027 = SEntry3_SSL(null, null, -2147483648L);
  val x8358 = SEntry3_SSL(null, null, -2147483648L);
  def onAddMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x7624._1_=(message_m_creatorid)
      val x18023 = COUNT_mMESSAGE1Idx1.sliceRes(x7624);
      if((x18023.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7624, ({ x24: SEntry4_SSSL => {
            x7650._3_=(message_m_creatorid)
            val x18019 = COUNT_mPERSON2Idx1.sliceRes(x7650);
            if((x18019.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x7650, ({ x29: SEntry4_SSSL => {
                  x7691._1_=(message_m_creatorid)
                  x7691._2_=((x24._2))
                  x7691._3_=((x24._3))
                  x7691._4_=(message_m_messageid)
                  x7691._5_=((x29._1))
                  x7691._6_=((x29._2))
                  x7691._7_=(((x24._4).*((x29._4))))
                  val x7692 = x7691._7;
                  if((x7692.==(0L))) {
                  } else {
                    val x13031 = COUNTIdx0.get(x7691);
                    if((x13031.==(null))) {
                      COUNT.unsafeInsert(x7691)
                    } else {
                      x13031._7 +=(x7692)
                      if(((x13031._7).==(0L))) {
                        COUNT.delete(x13031)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18019)
            }
            ()
          }
        }), x18023)
      }
      x7627._1_=(message_m_creatorid)
      val x18061 = COUNT_mMESSAGE1Idx1.sliceRes(x7627);
      if((x18061.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7627, ({ x53: SEntry4_SSSL => {
            x7660._2_=(message_m_creatorid)
            val x18057 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x7660);
            if((x18057.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x7660, ({ x58: SEntry3_SSL => {
                  x7719._1_=(message_m_creatorid)
                  x7719._2_=((x53._2))
                  x7719._3_=((x53._3))
                  x7719._4_=(message_m_messageid)
                  x7719._5_=((x58._1))
                  x7719._6_=(((x53._4).*((x58._3))))
                  val x7720 = x7719._6;
                  if((x7720.==(0L))) {
                  } else {
                    val x13064 = COUNT_mKNOWS12Idx0.get(x7719);
                    if((x13064.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x7719)
                    } else {
                      x13064._6 +=(x7720)
                      if(((x13064._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13064)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18057)
            }
            ()
          }
        }), x18061)
      }
      x7630._1_=(message_m_messageid)
      x7630._2_=(message_m_creatorid)
      x7630._3_=(1L)
      val x7631 = x7630._3;
      if((x7631.==(0L))) {
      } else {
        val x13083 = COUNT_mPERSON1Idx0.get(x7630);
        if((x13083.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x7630)
        } else {
          x13083._3 +=(x7631)
          if(((x13083._3).==(0L))) {
            COUNT_mPERSON1.delete(x13083)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x7820._1_=(message_m_creatorid)
      val x18117 = COUNT_mMESSAGE1Idx1.sliceRes(x7820);
      if((x18117.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7820, ({ x110: SEntry4_SSSL => {
            x7846._3_=(message_m_creatorid)
            val x18113 = COUNT_mPERSON2Idx1.sliceRes(x7846);
            if((x18113.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x7846, ({ x115: SEntry4_SSSL => {
                  x7888._1_=(message_m_creatorid)
                  x7888._2_=((x110._2))
                  x7888._3_=((x110._3))
                  x7888._4_=(message_m_messageid)
                  x7888._5_=((x115._1))
                  x7888._6_=((x115._2))
                  x7888._7_=(((x110._4).*(((x115._4).unary_-))))
                  val x7889 = x7888._7;
                  if((x7889.==(0L))) {
                  } else {
                    val x13204 = COUNTIdx0.get(x7888);
                    if((x13204.==(null))) {
                      COUNT.unsafeInsert(x7888)
                    } else {
                      x13204._7 +=(x7889)
                      if(((x13204._7).==(0L))) {
                        COUNT.delete(x13204)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18113)
            }
            ()
          }
        }), x18117)
      }
      x7823._1_=(message_m_creatorid)
      val x18156 = COUNT_mMESSAGE1Idx1.sliceRes(x7823);
      if((x18156.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x7823, ({ x140: SEntry4_SSSL => {
            x7856._2_=(message_m_creatorid)
            val x18152 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x7856);
            if((x18152.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x7856, ({ x145: SEntry3_SSL => {
                  x7917._1_=(message_m_creatorid)
                  x7917._2_=((x140._2))
                  x7917._3_=((x140._3))
                  x7917._4_=(message_m_messageid)
                  x7917._5_=((x145._1))
                  x7917._6_=(((x140._4).*(((x145._3).unary_-))))
                  val x7918 = x7917._6;
                  if((x7918.==(0L))) {
                  } else {
                    val x13238 = COUNT_mKNOWS12Idx0.get(x7917);
                    if((x13238.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x7917)
                    } else {
                      x13238._6 +=(x7918)
                      if(((x13238._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13238)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18152)
            }
            ()
          }
        }), x18156)
      }
      x7826._1_=(message_m_messageid)
      x7826._2_=(message_m_creatorid)
      x7826._3_=(-1L)
      val x7827 = x7826._3;
      if((x7827.==(0L))) {
      } else {
        val x13257 = COUNT_mPERSON1Idx0.get(x7826);
        if((x13257.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x7826)
        } else {
          x13257._3 +=(x7827)
          if(((x13257._3).==(0L))) {
            COUNT_mPERSON1.delete(x13257)
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
        x8023._5_=(knows1_k_personid2)
        val x18207 = COUNT_mKNOWS12Idx1.sliceRes(x8023);
        if((x18207.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x8023, ({ x191: SEntry6_SSSSSL => {
              val x8051 = x191._1;
              val x199 = if((x8051.!=(knows1_k_personid1))) {
              (x191._6)
              } else {
              0L
              };
              x8058._1_=(x8051)
              x8058._2_=((x191._2))
              x8058._3_=((x191._3))
              x8058._4_=((x191._4))
              x8058._5_=(knows1_k_personid1)
              x8058._6_=(knows1_k_personid2)
              x8058._7_=(x199)
              val x8059 = x8058._7;
              if((x8059.==(0L))) {
              } else {
                val x13379 = COUNTIdx0.get(x8058);
                if((x13379.==(null))) {
                  COUNT.unsafeInsert(x8058)
                } else {
                  x13379._7 +=(x8059)
                  if(((x13379._7).==(0L))) {
                    COUNT.delete(x13379)
                  } else {
                  }
                }
              }
            
            }
          }), x18207)
        }
      } else {
      }
      x8027._1_=(knows1_k_personid1)
      x8027._2_=(knows1_k_personid2)
      x8027._3_=((if(x189) 1L else 0L))
      val x8028 = x8027._3;
      if((x8028.==(0L))) {
      } else {
        val x13397 = COUNT_mKNOWS23Idx0.get(x8027);
        if((x13397.==(null))) {
          COUNT_mKNOWS23.unsafeInsert(x8027)
        } else {
          x13397._3 +=(x8028)
          if(((x13397._3).==(0L))) {
            COUNT_mKNOWS23.delete(x13397)
          } else {
          }
        }
      }
      if(x189) {
        x8042._1_=(knows1_k_personid2)
        val x18251 = COUNT_mKNOWS12_mPERSON2Idx2.sliceRes(x8042);
        if((x18251.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mPERSON2Idx2.sliceResMapNoUpd(x8042, ({ x233: SEntry3_SSL => {
              val x8092 = x233._2;
              val x238 = if((x8092.!=(knows1_k_personid1))) {
              (x233._3)
              } else {
              0L
              };
              x8096._1_=(knows1_k_personid1)
              x8096._2_=(knows1_k_personid2)
              x8096._3_=(x8092)
              x8096._4_=(x238)
              val x8097 = x8096._4;
              if((x8097.==(0L))) {
              } else {
                val x13423 = COUNT_mPERSON2Idx0.get(x8096);
                if((x13423.==(null))) {
                  COUNT_mPERSON2.unsafeInsert(x8096)
                } else {
                  x13423._4 +=(x8097)
                  if(((x13423._4).==(0L))) {
                    COUNT_mPERSON2.delete(x13423)
                  } else {
                  }
                }
              }
            
            }
          }), x18251)
        }
      } else {
      }
    
    }
  
  }
  def onDelKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x262 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x262) {
        x8180._5_=(knows1_k_personid2)
        val x18288 = COUNT_mKNOWS12Idx1.sliceRes(x8180);
        if((x18288.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x8180, ({ x264: SEntry6_SSSSSL => {
              val x8208 = x264._1;
              if((x8208.!=(knows1_k_personid1))) {
                x8216._1_=(x8208)
                x8216._2_=((x264._2))
                x8216._3_=((x264._3))
                x8216._4_=((x264._4))
                x8216._5_=(knows1_k_personid1)
                x8216._6_=(knows1_k_personid2)
                x8216._7_=(((x264._6).unary_-))
                val x8217 = x8216._7;
                if((x8217.==(0L))) {
                } else {
                  val x13538 = COUNTIdx0.get(x8216);
                  if((x13538.==(null))) {
                    COUNT.unsafeInsert(x8216)
                  } else {
                    x13538._7 +=(x8217)
                    if(((x13538._7).==(0L))) {
                      COUNT.delete(x13538)
                    } else {
                    }
                  }
                }
              } else {
              }
              ()
            }
          }), x18288)
        }
      } else {
      }
      if(x262) {
        x8184._1_=(knows1_k_personid1)
        x8184._2_=(knows1_k_personid2)
        x8184._3_=(-1L)
        val x8185 = x8184._3;
        if((x8185.==(0L))) {
        } else {
          val x13556 = COUNT_mKNOWS23Idx0.get(x8184);
          if((x13556.==(null))) {
            COUNT_mKNOWS23.unsafeInsert(x8184)
          } else {
            x13556._3 +=(x8185)
            if(((x13556._3).==(0L))) {
              COUNT_mKNOWS23.delete(x13556)
            } else {
            }
          }
        }
      } else {
      }
      if(x262) {
        x8199._1_=(knows1_k_personid2)
        val x18333 = COUNT_mKNOWS12_mPERSON2Idx2.sliceRes(x8199);
        if((x18333.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mPERSON2Idx2.sliceResMapNoUpd(x8199, ({ x306: SEntry3_SSL => {
              val x8250 = x306._2;
              if((x8250.!=(knows1_k_personid1))) {
                x8255._1_=(knows1_k_personid1)
                x8255._2_=(knows1_k_personid2)
                x8255._3_=(x8250)
                x8255._4_=(((x306._3).unary_-))
                val x8256 = x8255._4;
                if((x8256.==(0L))) {
                } else {
                  val x13583 = COUNT_mPERSON2Idx0.get(x8255);
                  if((x13583.==(null))) {
                    COUNT_mPERSON2.unsafeInsert(x8255)
                  } else {
                    x13583._4 +=(x8256)
                    if(((x13583._4).==(0L))) {
                      COUNT_mPERSON2.delete(x13583)
                    } else {
                    }
                  }
                }
              } else {
              }
              ()
            }
          }), x18333)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x8338._1_=(knows2_k_personid2)
      val x18384 = COUNT_mMESSAGE1Idx1.sliceRes(x8338);
      if((x18384.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8338, ({ x335: SEntry4_SSSL => {
            x8367._2_=(knows2_k_personid2)
            val x18380 = COUNT_mPERSON1Idx1.sliceRes(x8367);
            if((x18380.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8367, ({ x340: SEntry3_SSL => {
                  x8428._2_=(knows2_k_personid1)
                  val x18376 = COUNT_mKNOWS23Idx1.sliceRes(x8428);
                  if((x18376.isEmpty)) {
                  } else {
                    COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8428, ({ x344: SEntry3_SSL => {
                        val x8511 = x344._1;
                        val x349 = if((knows2_k_personid2.!=(x8511))) {
                        (x344._3)
                        } else {
                        0L
                        };
                        x8517._1_=(knows2_k_personid2)
                        x8517._2_=((x335._2))
                        x8517._3_=((x335._3))
                        x8517._4_=((x340._1))
                        x8517._5_=(x8511)
                        x8517._6_=(knows2_k_personid1)
                        x8517._7_=(((x335._4).*(((x340._3).*(x349)))))
                        val x8518 = x8517._7;
                        if((x8518.==(0L))) {
                        } else {
                          val x13706 = COUNTIdx0.get(x8517);
                          if((x13706.==(null))) {
                            COUNT.unsafeInsert(x8517)
                          } else {
                            x13706._7 +=(x8518)
                            if(((x13706._7).==(0L))) {
                              COUNT.delete(x13706)
                            } else {
                            }
                          }
                        }
                      
                      }
                    }), x18376)
                  }
                  ()
                }
              }), x18380)
            }
            ()
          }
        }), x18384)
      }
      x8341._1_=(knows2_k_personid2)
      val x18422 = COUNT_mMESSAGE1Idx1.sliceRes(x8341);
      if((x18422.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8341, ({ x373: SEntry4_SSSL => {
            x8377._2_=(knows2_k_personid2)
            val x18418 = COUNT_mPERSON1Idx1.sliceRes(x8377);
            if((x18418.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8377, ({ x378: SEntry3_SSL => {
                  x8445._1_=(knows2_k_personid2)
                  x8445._2_=((x373._2))
                  x8445._3_=((x373._3))
                  x8445._4_=((x378._1))
                  x8445._5_=(knows2_k_personid1)
                  x8445._6_=(((x373._4).*((x378._3))))
                  val x8446 = x8445._6;
                  if((x8446.==(0L))) {
                  } else {
                    val x13740 = COUNT_mKNOWS12Idx0.get(x8445);
                    if((x13740.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x8445)
                    } else {
                      x13740._6 +=(x8446)
                      if(((x13740._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13740)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18418)
            }
            ()
          }
        }), x18422)
      }
      x8344._1_=(knows2_k_personid1)
      x8344._2_=(knows2_k_personid2)
      x8344._3_=(1L)
      val x8345 = x8344._3;
      if((x8345.==(0L))) {
      } else {
        val x13759 = COUNT_mKNOWS12_mPERSON2Idx0.get(x8344);
        if((x13759.==(null))) {
          COUNT_mKNOWS12_mPERSON2.unsafeInsert(x8344)
        } else {
          x13759._3 +=(x8345)
          if(((x13759._3).==(0L))) {
            COUNT_mKNOWS12_mPERSON2.delete(x13759)
          } else {
          }
        }
      }
      x8358._2_=(knows2_k_personid1)
      val x18464 = COUNT_mKNOWS23Idx1.sliceRes(x8358);
      if((x18464.isEmpty)) {
      } else {
        COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8358, ({ x415: SEntry3_SSL => {
            val x8398 = x415._1;
            val x420 = if((knows2_k_personid2.!=(x8398))) {
            (x415._3)
            } else {
            0L
            };
            x8402._1_=(x8398)
            x8402._2_=(knows2_k_personid1)
            x8402._3_=(knows2_k_personid2)
            x8402._4_=(x420)
            val x8403 = x8402._4;
            if((x8403.==(0L))) {
            } else {
              val x13785 = COUNT_mPERSON2Idx0.get(x8402);
              if((x13785.==(null))) {
                COUNT_mPERSON2.unsafeInsert(x8402)
              } else {
                x13785._4 +=(x8403)
                if(((x13785._4).==(0L))) {
                  COUNT_mPERSON2.delete(x13785)
                } else {
                }
              }
            }
          
          }
        }), x18464)
      }
    
    }
  
  }
  def onDelKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x8699._1_=(knows2_k_personid2)
      val x18516 = COUNT_mMESSAGE1Idx1.sliceRes(x8699);
      if((x18516.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8699, ({ x443: SEntry4_SSSL => {
            x8728._2_=(knows2_k_personid2)
            val x18512 = COUNT_mPERSON1Idx1.sliceRes(x8728);
            if((x18512.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8728, ({ x448: SEntry3_SSL => {
                  x8790._2_=(knows2_k_personid1)
                  val x18508 = COUNT_mKNOWS23Idx1.sliceRes(x8790);
                  if((x18508.isEmpty)) {
                  } else {
                    COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8790, ({ x452: SEntry3_SSL => {
                        val x8875 = x452._1;
                        if((knows2_k_personid2.!=(x8875))) {
                          x8882._1_=(knows2_k_personid2)
                          x8882._2_=((x443._2))
                          x8882._3_=((x443._3))
                          x8882._4_=((x448._1))
                          x8882._5_=(x8875)
                          x8882._6_=(knows2_k_personid1)
                          x8882._7_=(((x443._4).*(((x448._3).*(((x452._3).unary_-))))))
                          val x8883 = x8882._7;
                          if((x8883.==(0L))) {
                          } else {
                            val x13949 = COUNTIdx0.get(x8882);
                            if((x13949.==(null))) {
                              COUNT.unsafeInsert(x8882)
                            } else {
                              x13949._7 +=(x8883)
                              if(((x13949._7).==(0L))) {
                                COUNT.delete(x13949)
                              } else {
                              }
                            }
                          }
                        } else {
                        }
                        ()
                      }
                    }), x18508)
                  }
                  ()
                }
              }), x18512)
            }
            ()
          }
        }), x18516)
      }
      x8702._1_=(knows2_k_personid2)
      val x18555 = COUNT_mMESSAGE1Idx1.sliceRes(x8702);
      if((x18555.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x8702, ({ x481: SEntry4_SSSL => {
            x8738._2_=(knows2_k_personid2)
            val x18551 = COUNT_mPERSON1Idx1.sliceRes(x8738);
            if((x18551.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x8738, ({ x486: SEntry3_SSL => {
                  x8808._1_=(knows2_k_personid2)
                  x8808._2_=((x481._2))
                  x8808._3_=((x481._3))
                  x8808._4_=((x486._1))
                  x8808._5_=(knows2_k_personid1)
                  x8808._6_=(((x481._4).*(((x486._3).unary_-))))
                  val x8809 = x8808._6;
                  if((x8809.==(0L))) {
                  } else {
                    val x13984 = COUNT_mKNOWS12Idx0.get(x8808);
                    if((x13984.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x8808)
                    } else {
                      x13984._6 +=(x8809)
                      if(((x13984._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x13984)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18551)
            }
            ()
          }
        }), x18555)
      }
      x8705._1_=(knows2_k_personid1)
      x8705._2_=(knows2_k_personid2)
      x8705._3_=(-1L)
      val x8706 = x8705._3;
      if((x8706.==(0L))) {
      } else {
        val x14003 = COUNT_mKNOWS12_mPERSON2Idx0.get(x8705);
        if((x14003.==(null))) {
          COUNT_mKNOWS12_mPERSON2.unsafeInsert(x8705)
        } else {
          x14003._3 +=(x8706)
          if(((x14003._3).==(0L))) {
            COUNT_mKNOWS12_mPERSON2.delete(x14003)
          } else {
          }
        }
      }
      x8719._2_=(knows2_k_personid1)
      val x18598 = COUNT_mKNOWS23Idx1.sliceRes(x8719);
      if((x18598.isEmpty)) {
      } else {
        COUNT_mKNOWS23Idx1.sliceResMapNoUpd(x8719, ({ x524: SEntry3_SSL => {
            val x8759 = x524._1;
            if((knows2_k_personid2.!=(x8759))) {
              x8764._1_=(x8759)
              x8764._2_=(knows2_k_personid1)
              x8764._3_=(knows2_k_personid2)
              x8764._4_=(((x524._3).unary_-))
              val x8765 = x8764._4;
              if((x8765.==(0L))) {
              } else {
                val x14030 = COUNT_mPERSON2Idx0.get(x8764);
                if((x14030.==(null))) {
                  COUNT_mPERSON2.unsafeInsert(x8764)
                } else {
                  x14030._4 +=(x8765)
                  if(((x14030._4).==(0L))) {
                    COUNT_mPERSON2.delete(x14030)
                  } else {
                  }
                }
              }
            } else {
            }
            ()
          }
        }), x18598)
      }
    
    }
  
  }
  def onAddPERSON(person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x9069._2_=(person_p_personid)
      val x18637 = COUNT_mPERSON1Idx1.sliceRes(x9069);
      if((x18637.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9069, ({ x558: SEntry3_SSL => {
            x9094._3_=(person_p_personid)
            val x18633 = COUNT_mPERSON2Idx1.sliceRes(x9094);
            if((x18633.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x9094, ({ x562: SEntry4_SSSL => {
                  x9133._1_=(person_p_personid)
                  x9133._2_=(person_p_firstname)
                  x9133._3_=(person_p_lastname)
                  x9133._4_=((x558._1))
                  x9133._5_=((x562._1))
                  x9133._6_=((x562._2))
                  x9133._7_=(((x558._3).*((x562._4))))
                  val x9134 = x9133._7;
                  if((x9134.==(0L))) {
                  } else {
                    val x14188 = COUNTIdx0.get(x9133);
                    if((x14188.==(null))) {
                      COUNT.unsafeInsert(x9133)
                    } else {
                      x14188._7 +=(x9134)
                      if(((x14188._7).==(0L))) {
                        COUNT.delete(x14188)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18633)
            }
            ()
          }
        }), x18637)
      }
      x9072._2_=(person_p_personid)
      val x18674 = COUNT_mPERSON1Idx1.sliceRes(x9072);
      if((x18674.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9072, ({ x586: SEntry3_SSL => {
            x9103._2_=(person_p_personid)
            val x18670 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x9103);
            if((x18670.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x9103, ({ x590: SEntry3_SSL => {
                  x9160._1_=(person_p_personid)
                  x9160._2_=(person_p_firstname)
                  x9160._3_=(person_p_lastname)
                  x9160._4_=((x586._1))
                  x9160._5_=((x590._1))
                  x9160._6_=(((x586._3).*((x590._3))))
                  val x9161 = x9160._6;
                  if((x9161.==(0L))) {
                  } else {
                    val x14220 = COUNT_mKNOWS12Idx0.get(x9160);
                    if((x14220.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x9160)
                    } else {
                      x14220._6 +=(x9161)
                      if(((x14220._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x14220)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18670)
            }
            ()
          }
        }), x18674)
      }
      x9075._1_=(person_p_personid)
      x9075._2_=(person_p_firstname)
      x9075._3_=(person_p_lastname)
      x9075._4_=(1L)
      val x9076 = x9075._4;
      if((x9076.==(0L))) {
      } else {
        val x14240 = COUNT_mMESSAGE1Idx0.get(x9075);
        if((x14240.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x9075)
        } else {
          x14240._4 +=(x9076)
          if(((x14240._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x14240)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelPERSON(person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x9259._2_=(person_p_personid)
      val x18730 = COUNT_mPERSON1Idx1.sliceRes(x9259);
      if((x18730.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9259, ({ x638: SEntry3_SSL => {
            x9284._3_=(person_p_personid)
            val x18726 = COUNT_mPERSON2Idx1.sliceRes(x9284);
            if((x18726.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x9284, ({ x642: SEntry4_SSSL => {
                  x9324._1_=(person_p_personid)
                  x9324._2_=(person_p_firstname)
                  x9324._3_=(person_p_lastname)
                  x9324._4_=((x638._1))
                  x9324._5_=((x642._1))
                  x9324._6_=((x642._2))
                  x9324._7_=(((x638._3).*(((x642._4).unary_-))))
                  val x9325 = x9324._7;
                  if((x9325.==(0L))) {
                  } else {
                    val x14359 = COUNTIdx0.get(x9324);
                    if((x14359.==(null))) {
                      COUNT.unsafeInsert(x9324)
                    } else {
                      x14359._7 +=(x9325)
                      if(((x14359._7).==(0L))) {
                        COUNT.delete(x14359)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18726)
            }
            ()
          }
        }), x18730)
      }
      x9262._2_=(person_p_personid)
      val x18768 = COUNT_mPERSON1Idx1.sliceRes(x9262);
      if((x18768.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x9262, ({ x667: SEntry3_SSL => {
            x9293._2_=(person_p_personid)
            val x18764 = COUNT_mKNOWS12_mPERSON2Idx1.sliceRes(x9293);
            if((x18764.isEmpty)) {
            } else {
              COUNT_mKNOWS12_mPERSON2Idx1.sliceResMapNoUpd(x9293, ({ x671: SEntry3_SSL => {
                  x9352._1_=(person_p_personid)
                  x9352._2_=(person_p_firstname)
                  x9352._3_=(person_p_lastname)
                  x9352._4_=((x667._1))
                  x9352._5_=((x671._1))
                  x9352._6_=(((x667._3).*(((x671._3).unary_-))))
                  val x9353 = x9352._6;
                  if((x9353.==(0L))) {
                  } else {
                    val x14392 = COUNT_mKNOWS12Idx0.get(x9352);
                    if((x14392.==(null))) {
                      COUNT_mKNOWS12.unsafeInsert(x9352)
                    } else {
                      x14392._6 +=(x9353)
                      if(((x14392._6).==(0L))) {
                        COUNT_mKNOWS12.delete(x14392)
                      } else {
                      }
                    }
                  }
                
                }
              }), x18764)
            }
            ()
          }
        }), x18768)
      }
      x9265._1_=(person_p_personid)
      x9265._2_=(person_p_firstname)
      x9265._3_=(person_p_lastname)
      x9265._4_=(-1L)
      val x9266 = x9265._4;
      if((x9266.==(0L))) {
      } else {
        val x14412 = COUNT_mMESSAGE1Idx0.get(x9265);
        if((x14412.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x9265)
        } else {
          x14412._4 +=(x9266)
          if(((x14412._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x14412)
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
    case TupleEvent(TupleInsert, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10)
    case TupleEvent(TupleDelete, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10)
    case StreamInit(timeout) => 
      
      onSystemReady();
      t0 = System.nanoTime;
      if (timeout > 0) t1 = t0 + timeout * 1000000L
    case EndOfStream | GetSnapshot(_) => 
      t1 = System.nanoTime; 
       sender ! (StreamStat(t1 - t0, tN, tS), List({ val COUNT_node_mres = new scala.collection.mutable.HashMap[(String, String, String, String, String, String),Long](); COUNT.foreach{e => COUNT_node_mres += (((e._1, e._2, e._3, e._4, e._5, e._6),e._7)) }; COUNT_node_mres.toMap }))
  }
}