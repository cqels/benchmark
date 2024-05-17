package ddbt.gen
    
import ddbt.lib._
import akka.actor.Actor
import ddbt.lib.store._


object Rsnb_q2_0_003 {
  import Helper._

  

  def execute(args: Array[String], f: List[Any] => Unit) = 
    bench(args, (dataset: String, parallelMode: Int, timeout: Long, batchSize: Int) => run[Rsnb_q2_0_003](
      Seq(
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.message.window.csv"),new Adaptor.CSV("MESSAGE","string,string,string,string,string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.knows1.window.csv"),new Adaptor.CSV("KNOWS1","string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.knows2.window.csv"),new Adaptor.CSV("KNOWS2","string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.tag.window.csv"),new Adaptor.CSV("TAG","string,string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.messagetag.window.csv"),new Adaptor.CSV("MESSAGE_TAG","string,string,string,string","\\Q|\\E", "insert"),Split())
      ), 
      parallelMode, timeout, batchSize), f)

  def main(args: Array[String]) {

    val argMap = parseArgs(args)
    
    execute(args, (res: List[Any]) => {
      if (!argMap.contains("noOutput")) {
        println("<snap>")
        println("<COUNT>\n" + M3Map.toStr(res(0), List("K1_K_PERSONID1", "K1_K_PERSONID2", "K2_K_PERSONID2", "TAG_T_TAGID", "MESSAGE_M_MESSAGEID"))+"\n" + "</COUNT>\n")
        println("</snap>")
      }
    })
  }  
}
class Rsnb_q2_0_003Base {
  import Rsnb_q2_0_003._
  import ddbt.lib.Functions._

  case class SEntry5_SSSSL(var _1: String, var _2: String, var _3: String, var _4: String, var _5: Long) extends Entry(5) {def this() = this(null, null, null, null, -2147483648L) ; def copy = SEntry5_SSSSL(_1, _2, _3, _4, _5); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry5_SSSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4;_5 = that._5} }
  case class SEntry3_SSL(var _1: String, var _2: String, var _3: Long) extends Entry(3) {def this() = this(null, null, -2147483648L) ; def copy = SEntry3_SSL(_1, _2, _3); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry3_SSL]; _1 = that._1;_2 = that._2;_3 = that._3} }
  case class SEntry6_SSSSSL(var _1: String, var _2: String, var _3: String, var _4: String, var _5: String, var _6: Long) extends Entry(6) {def this() = this(null, null, null, null, null, -2147483648L) ; def copy = SEntry6_SSSSSL(_1, _2, _3, _4, _5, _6); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry6_SSSSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4;_5 = that._5;_6 = that._6} }
  case class SEntry4_SSSL(var _1: String, var _2: String, var _3: String, var _4: Long) extends Entry(4) {def this() = this(null, null, null, -2147483648L) ; def copy = SEntry4_SSSL(_1, _2, _3, _4); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry4_SSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4} }
  case class SEntry2_SL(var _1: String, var _2: Long) extends Entry(2) {def this() = this(null, -2147483648L) ; def copy = SEntry2_SL(_1, _2); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry2_SL]; _1 = that._1;_2 = that._2} }
   object SEntry4_SSSL_Idx2 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17133 : SEntry4_SSSL) = {
      var x17134: Int = 0;
      val x17135 = x17134;
      x17134 = (x17135.^((((((x17133._2).hashCode()).+(-1640531527)).+((x17135.<<(6)))).+((x17135.>>(2))))))
      val x17145 = x17134;
      x17145
    }
    override def cmp(x17147 : SEntry4_SSSL , x17148 : SEntry4_SSSL) = {
      var x17149: Int = 0;
      if(((x17147._2).==((x17148._2)))) {
        x17149 = 0
      } else {
        x17149 = 1
      }
      val x17156 = x17149;
      x17156
    }
  }
   object SEntry3_SSL_Idx12 extends EntryIdx[SEntry3_SSL] {
    override def hash(x16934 : SEntry3_SSL) = {
      var x16935: Int = 0;
      val x16936 = x16935;
      x16935 = (x16936.^((((((x16934._1).hashCode()).+(-1640531527)).+((x16936.<<(6)))).+((x16936.>>(2))))))
      val x16946 = x16935;
      x16935 = (x16946.^((((((x16934._2).hashCode()).+(-1640531527)).+((x16946.<<(6)))).+((x16946.>>(2))))))
      val x16956 = x16935;
      x16956
    }
    override def cmp(x16958 : SEntry3_SSL , x16959 : SEntry3_SSL) = {
      var x16960: Int = 0;
      if(((x16958._1).==((x16959._1)))) {
        if(((x16958._2).==((x16959._2)))) {
          x16960 = 0
        } else {
          x16960 = 1
        }
      } else {
        x16960 = 1
      }
      val x16972 = x16960;
      x16972
    }
  }
   object SEntry6_SSSSSL_Idx12345 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x16816 : SEntry6_SSSSSL) = {
      var x16817: Int = 0;
      val x16818 = x16817;
      x16817 = (x16818.^((((((x16816._1).hashCode()).+(-1640531527)).+((x16818.<<(6)))).+((x16818.>>(2))))))
      val x16828 = x16817;
      x16817 = (x16828.^((((((x16816._2).hashCode()).+(-1640531527)).+((x16828.<<(6)))).+((x16828.>>(2))))))
      val x16838 = x16817;
      x16817 = (x16838.^((((((x16816._3).hashCode()).+(-1640531527)).+((x16838.<<(6)))).+((x16838.>>(2))))))
      val x16848 = x16817;
      x16817 = (x16848.^((((((x16816._4).hashCode()).+(-1640531527)).+((x16848.<<(6)))).+((x16848.>>(2))))))
      val x16858 = x16817;
      x16817 = (x16858.^((((((x16816._5).hashCode()).+(-1640531527)).+((x16858.<<(6)))).+((x16858.>>(2))))))
      val x16868 = x16817;
      x16868
    }
    override def cmp(x16870 : SEntry6_SSSSSL , x16871 : SEntry6_SSSSSL) = {
      var x16872: Int = 0;
      if(((x16870._1).==((x16871._1)))) {
        if(((x16870._2).==((x16871._2)))) {
          if(((x16870._3).==((x16871._3)))) {
            if(((x16870._4).==((x16871._4)))) {
              if(((x16870._5).==((x16871._5)))) {
                x16872 = 0
              } else {
                x16872 = 1
              }
            } else {
              x16872 = 1
            }
          } else {
            x16872 = 1
          }
        } else {
          x16872 = 1
        }
      } else {
        x16872 = 1
      }
      val x16899 = x16872;
      x16899
    }
  }
   object SEntry4_SSSL_Idx123 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17077 : SEntry4_SSSL) = {
      var x17078: Int = 0;
      val x17079 = x17078;
      x17078 = (x17079.^((((((x17077._1).hashCode()).+(-1640531527)).+((x17079.<<(6)))).+((x17079.>>(2))))))
      val x17089 = x17078;
      x17078 = (x17089.^((((((x17077._2).hashCode()).+(-1640531527)).+((x17089.<<(6)))).+((x17089.>>(2))))))
      val x17099 = x17078;
      x17078 = (x17099.^((((((x17077._3).hashCode()).+(-1640531527)).+((x17099.<<(6)))).+((x17099.>>(2))))))
      val x17109 = x17078;
      x17109
    }
    override def cmp(x17111 : SEntry4_SSSL , x17112 : SEntry4_SSSL) = {
      var x17113: Int = 0;
      if(((x17111._1).==((x17112._1)))) {
        if(((x17111._2).==((x17112._2)))) {
          if(((x17111._3).==((x17112._3)))) {
            x17113 = 0
          } else {
            x17113 = 1
          }
        } else {
          x17113 = 1
        }
      } else {
        x17113 = 1
      }
      val x17130 = x17113;
      x17130
    }
  }
   object SEntry2_SL_Idx1 extends EntryIdx[SEntry2_SL] {
    override def hash(x17231 : SEntry2_SL) = {
      var x17232: Int = 0;
      val x17233 = x17232;
      x17232 = (x17233.^((((((x17231._1).hashCode()).+(-1640531527)).+((x17233.<<(6)))).+((x17233.>>(2))))))
      val x17243 = x17232;
      x17243
    }
    override def cmp(x17245 : SEntry2_SL , x17246 : SEntry2_SL) = {
      var x17247: Int = 0;
      if(((x17245._1).==((x17246._1)))) {
        x17247 = 0
      } else {
        x17247 = 1
      }
      val x17254 = x17247;
      x17254
    }
  }
   object SEntry4_SSSL_Idx3 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17159 : SEntry4_SSSL) = {
      var x17160: Int = 0;
      val x17161 = x17160;
      x17160 = (x17161.^((((((x17159._3).hashCode()).+(-1640531527)).+((x17161.<<(6)))).+((x17161.>>(2))))))
      val x17171 = x17160;
      x17171
    }
    override def cmp(x17173 : SEntry4_SSSL , x17174 : SEntry4_SSSL) = {
      var x17175: Int = 0;
      if(((x17173._3).==((x17174._3)))) {
        x17175 = 0
      } else {
        x17175 = 1
      }
      val x17182 = x17175;
      x17182
    }
  }
   object SEntry5_SSSSL_Idx1 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16752 : SEntry5_SSSSL) = {
      var x16753: Int = 0;
      val x16754 = x16753;
      x16753 = (x16754.^((((((x16752._1).hashCode()).+(-1640531527)).+((x16754.<<(6)))).+((x16754.>>(2))))))
      val x16764 = x16753;
      x16764
    }
    override def cmp(x16766 : SEntry5_SSSSL , x16767 : SEntry5_SSSSL) = {
      var x16768: Int = 0;
      if(((x16766._1).==((x16767._1)))) {
        x16768 = 0
      } else {
        x16768 = 1
      }
      val x16775 = x16768;
      x16775
    }
  }
   object SEntry5_SSSSL_Idx3 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16784 : SEntry5_SSSSL) = {
      var x16785: Int = 0;
      val x16786 = x16785;
      x16785 = (x16786.^((((((x16784._3).hashCode()).+(-1640531527)).+((x16786.<<(6)))).+((x16786.>>(2))))))
      val x16796 = x16785;
      x16796
    }
    override def cmp(x16798 : SEntry5_SSSSL , x16799 : SEntry5_SSSSL) = {
      var x16800: Int = 0;
      if(((x16798._3).==((x16799._3)))) {
        x16800 = 0
      } else {
        x16800 = 1
      }
      val x16807 = x16800;
      x16807
    }
  }
   object SEntry4_SSSL_Idx1 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17198 : SEntry4_SSSL) = {
      var x17199: Int = 0;
      val x17200 = x17199;
      x17199 = (x17200.^((((((x17198._1).hashCode()).+(-1640531527)).+((x17200.<<(6)))).+((x17200.>>(2))))))
      val x17210 = x17199;
      x17210
    }
    override def cmp(x17212 : SEntry4_SSSL , x17213 : SEntry4_SSSL) = {
      var x17214: Int = 0;
      if(((x17212._1).==((x17213._1)))) {
        x17214 = 0
      } else {
        x17214 = 1
      }
      val x17221 = x17214;
      x17221
    }
  }
   object SEntry3_SSL_Idx2 extends EntryIdx[SEntry3_SSL] {
    override def hash(x16975 : SEntry3_SSL) = {
      var x16976: Int = 0;
      val x16977 = x16976;
      x16976 = (x16977.^((((((x16975._2).hashCode()).+(-1640531527)).+((x16977.<<(6)))).+((x16977.>>(2))))))
      val x16987 = x16976;
      x16987
    }
    override def cmp(x16989 : SEntry3_SSL , x16990 : SEntry3_SSL) = {
      var x16991: Int = 0;
      if(((x16989._2).==((x16990._2)))) {
        x16991 = 0
      } else {
        x16991 = 1
      }
      val x16998 = x16991;
      x16998
    }
  }
   object SEntry5_SSSSL_Idx2 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x17034 : SEntry5_SSSSL) = {
      var x17035: Int = 0;
      val x17036 = x17035;
      x17035 = (x17036.^((((((x17034._2).hashCode()).+(-1640531527)).+((x17036.<<(6)))).+((x17036.>>(2))))))
      val x17046 = x17035;
      x17046
    }
    override def cmp(x17048 : SEntry5_SSSSL , x17049 : SEntry5_SSSSL) = {
      var x17050: Int = 0;
      if(((x17048._2).==((x17049._2)))) {
        x17050 = 0
      } else {
        x17050 = 1
      }
      val x17057 = x17050;
      x17057
    }
  }
   object SEntry5_SSSSL_Idx1234 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16681 : SEntry5_SSSSL) = {
      var x16682: Int = 0;
      val x16683 = x16682;
      x16682 = (x16683.^((((((x16681._1).hashCode()).+(-1640531527)).+((x16683.<<(6)))).+((x16683.>>(2))))))
      val x16693 = x16682;
      x16682 = (x16693.^((((((x16681._2).hashCode()).+(-1640531527)).+((x16693.<<(6)))).+((x16693.>>(2))))))
      val x16703 = x16682;
      x16682 = (x16703.^((((((x16681._3).hashCode()).+(-1640531527)).+((x16703.<<(6)))).+((x16703.>>(2))))))
      val x16713 = x16682;
      x16682 = (x16713.^((((((x16681._4).hashCode()).+(-1640531527)).+((x16713.<<(6)))).+((x16713.>>(2))))))
      val x16723 = x16682;
      x16723
    }
    override def cmp(x16725 : SEntry5_SSSSL , x16726 : SEntry5_SSSSL) = {
      var x16727: Int = 0;
      if(((x16725._1).==((x16726._1)))) {
        if(((x16725._2).==((x16726._2)))) {
          if(((x16725._3).==((x16726._3)))) {
            if(((x16725._4).==((x16726._4)))) {
              x16727 = 0
            } else {
              x16727 = 1
            }
          } else {
            x16727 = 1
          }
        } else {
          x16727 = 1
        }
      } else {
        x16727 = 1
      }
      val x16749 = x16727;
      x16749
    }
  }
   object SEntry6_SSSSSL_Idx2 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x16902 : SEntry6_SSSSSL) = {
      var x16903: Int = 0;
      val x16904 = x16903;
      x16903 = (x16904.^((((((x16902._2).hashCode()).+(-1640531527)).+((x16904.<<(6)))).+((x16904.>>(2))))))
      val x16914 = x16903;
      x16914
    }
    override def cmp(x16916 : SEntry6_SSSSSL , x16917 : SEntry6_SSSSSL) = {
      var x16918: Int = 0;
      if(((x16916._2).==((x16917._2)))) {
        x16918 = 0
      } else {
        x16918 = 1
      }
      val x16925 = x16918;
      x16925
    }
  }
   object SEntry3_SSL_Idx1 extends EntryIdx[SEntry3_SSL] {
    override def hash(x17001 : SEntry3_SSL) = {
      var x17002: Int = 0;
      val x17003 = x17002;
      x17002 = (x17003.^((((((x17001._1).hashCode()).+(-1640531527)).+((x17003.<<(6)))).+((x17003.>>(2))))))
      val x17013 = x17002;
      x17013
    }
    override def cmp(x17015 : SEntry3_SSL , x17016 : SEntry3_SSL) = {
      var x17017: Int = 0;
      if(((x17015._1).==((x17016._1)))) {
        x17017 = 0
      } else {
        x17017 = 1
      }
      val x17024 = x17017;
      x17024
    }
  }
  
  val x16779 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx1)
  val COUNT_mMESSAGE_TAG1 = new Store[SEntry5_SSSSL](2, x16779);
  val COUNT_mMESSAGE_TAG1Idx0 = COUNT_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mMESSAGE_TAG1Idx1 = COUNT_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val x16811 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx3)
  val COUNT_mKNOWS12 = new Store[SEntry5_SSSSL](2, x16811);
  val COUNT_mKNOWS12Idx0 = COUNT_mKNOWS12.index(0, IHash, true, -1)
  val COUNT_mKNOWS12Idx1 = COUNT_mKNOWS12.index(1, IHash, false, -1)
  val x16929 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345, SEntry6_SSSSSL_Idx2)
  val COUNT_mTAG1 = new Store[SEntry6_SSSSSL](2, x16929);
  val COUNT_mTAG1Idx0 = COUNT_mTAG1.index(0, IHash, true, -1)
  val COUNT_mTAG1Idx1 = COUNT_mTAG1.index(1, IHash, false, -1)
  val x17028 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2 = new Store[SEntry3_SSL](3, x17028);
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(2, IHash, false, -1)
  val x17061 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx2, SEntry5_SSSSL_Idx3)
  val COUNT_mKNOWS12_mTAG1 = new Store[SEntry5_SSSSL](3, x17061);
  val COUNT_mKNOWS12_mTAG1Idx0 = COUNT_mKNOWS12_mTAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mTAG1Idx1 = COUNT_mKNOWS12_mTAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mTAG1Idx2 = COUNT_mKNOWS12_mTAG1.index(2, IHash, false, -1)
  val x17066 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS12_mMESSAGE3 = new Store[SEntry3_SSL](3, x17066);
  val COUNT_mKNOWS12_mMESSAGE3Idx0 = COUNT_mKNOWS12_mMESSAGE3.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mMESSAGE3Idx1 = COUNT_mKNOWS12_mMESSAGE3.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mMESSAGE3Idx2 = COUNT_mKNOWS12_mMESSAGE3.index(2, IHash, false, -1)
  val x17073 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345)
  val COUNT = new Store[SEntry6_SSSSSL](1, x17073);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  val x17186 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx2, SEntry4_SSSL_Idx3)
  val COUNT_mKNOWS21_mTAG1 = new Store[SEntry4_SSSL](3, x17186);
  val COUNT_mKNOWS21_mTAG1Idx0 = COUNT_mKNOWS21_mTAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mTAG1Idx1 = COUNT_mKNOWS21_mTAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mTAG1Idx2 = COUNT_mKNOWS21_mTAG1.index(2, IHash, false, -1)
  val x17193 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mMESSAGE2 = new Store[SEntry3_SSL](2, x17193);
  val COUNT_mMESSAGE2Idx0 = COUNT_mMESSAGE2.index(0, IHash, true, -1)
  val COUNT_mMESSAGE2Idx1 = COUNT_mMESSAGE2.index(1, IHash, false, -1)
  val x17225 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx2, SEntry4_SSSL_Idx1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1 = new Store[SEntry4_SSSL](3, x17225);
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx0 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx1 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx2 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(2, IHash, false, -1)
  val x17258 = Array[EntryIdx[SEntry2_SL]](SEntry2_SL_Idx1)
  val COUNT_mMESSAGE_TAG2 = new Store[SEntry2_SL](1, x17258);
  val COUNT_mMESSAGE_TAG2Idx0 = COUNT_mMESSAGE_TAG2.index(0, IHash, true, -1)
  val x17261 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mKNOWS22 = new Store[SEntry3_SSL](2, x17261);
  val COUNT_mKNOWS22Idx0 = COUNT_mKNOWS22.index(0, IHash, true, -1)
  val COUNT_mKNOWS22Idx1 = COUNT_mKNOWS22.index(1, IHash, false, -1)
  val x17267 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mMESSAGE3 = new Store[SEntry4_SSSL](2, x17267);
  val COUNT_mMESSAGE3Idx0 = COUNT_mMESSAGE3.index(0, IHash, true, -1)
  val COUNT_mMESSAGE3Idx1 = COUNT_mMESSAGE3.index(1, IHash, false, -1)
  val x17271 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mKNOWS21 = new Store[SEntry4_SSSL](2, x17271);
  val COUNT_mKNOWS21Idx0 = COUNT_mKNOWS21.index(0, IHash, true, -1)
  val COUNT_mKNOWS21Idx1 = COUNT_mKNOWS21.index(1, IHash, false, -1)
  val x17275 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1 = new Store[SEntry3_SSL](3, x17275);
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx0 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx1 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx2 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(2, IHash, false, -1)
  
  
  
  val x21578 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20922 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18846 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20195 = SEntry3_SSL(null, null, -2147483648L);
  val x19639 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17917 = SEntry3_SSL(null, null, -2147483648L);
  val x19911 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21621 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x19413 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18012 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19662 = SEntry3_SSL(null, null, -2147483648L);
  val x17886 = SEntry3_SSL(null, null, -2147483648L);
  val x18536 = SEntry3_SSL(null, null, -2147483648L);
  val x21648 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21153 = SEntry3_SSL(null, null, -2147483648L);
  val x19659 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18899 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18795 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21558 = SEntry3_SSL(null, null, -2147483648L);
  val x18540 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18565 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19168 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21159 = SEntry3_SSL(null, null, -2147483648L);
  val x19707 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21584 = SEntry2_SL(null, -2147483648L);
  val x18634 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19677 = SEntry3_SSL(null, null, -2147483648L);
  val x19487 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21198 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18532 = SEntry3_SSL(null, null, -2147483648L);
  val x21322 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19141 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20180 = SEntry3_SSL(null, null, -2147483648L);
  val x18268 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18509 = SEntry3_SSL(null, null, -2147483648L);
  val x19262 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x19405 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18002 = SEntry3_SSL(null, null, -2147483648L);
  val x18505 = SEntry3_SSL(null, null, -2147483648L);
  val x20227 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19642 = SEntry3_SSL(null, null, -2147483648L);
  val x19742 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18083 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x19390 = SEntry3_SSL(null, null, -2147483648L);
  val x21214 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21150 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20160 = SEntry3_SSL(null, null, -2147483648L);
  val x18602 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17909 = SEntry3_SSL(null, null, -2147483648L);
  val x19808 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21641 = SEntry2_SL(null, -2147483648L);
  val x18501 = SEntry3_SSL(null, null, -2147483648L);
  val x19164 = SEntry3_SSL(null, null, -2147483648L);
  val x21184 = SEntry3_SSL(null, null, -2147483648L);
  val x21179 = SEntry2_SL(null, -2147483648L);
  val x20693 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18554 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20154 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20996 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18667 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19218 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18217 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19636 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18528 = SEntry3_SSL(null, null, -2147483648L);
  val x17882 = SEntry3_SSL(null, null, -2147483648L);
  val x20263 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20925 = SEntry2_SL(null, -2147483648L);
  val x17913 = SEntry3_SSL(null, null, -2147483648L);
  val x18168 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20690 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x20696 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19239 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19762 = SEntry3_SSL(null, null, -2147483648L);
  val x19665 = SEntry3_SSL(null, null, -2147483648L);
  val x20939 = SEntry3_SSL(null, null, -2147483648L);
  val x20724 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x19687 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20206 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21240 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21564 = SEntry3_SSL(null, null, -2147483648L);
  val x21156 = SEntry3_SSL(null, null, -2147483648L);
  val x17945 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21711 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21561 = SEntry3_SSL(null, null, -2147483648L);
  val x17921 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20488 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x20919 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18623 = SEntry3_SSL(null, null, -2147483648L);
  val x20186 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18688 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19465 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19386 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21604 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20177 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18033 = SEntry3_SSL(null, null, -2147483648L);
  val x21363 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21301 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20314 = SEntry3_SSL(null, null, -2147483648L);
  val x20713 = SEntry3_SSL(null, null, -2147483648L);
  val x19160 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17905 = SEntry3_SSL(null, null, -2147483648L);
  val x19511 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x19145 = SEntry3_SSL(null, null, -2147483648L);
  val x18524 = SEntry3_SSL(null, null, -2147483648L);
  val x20438 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20699 = SEntry2_SL(null, -2147483648L);
  val x20293 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20157 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19181 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21173 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20973 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21260 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19645 = SEntry3_SSL(null, null, -2147483648L);
  val x20163 = SEntry3_SSL(null, null, -2147483648L);
  val x17890 = SEntry3_SSL(null, null, -2147483648L);
  val x20951 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17935 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21295 = SEntry2_SL(null, -2147483648L);
  val x19792 = SEntry3_SSL(null, null, -2147483648L);
  val x20283 = SEntry3_SSL(null, null, -2147483648L);
  val x18065 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21776 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21234 = SEntry2_SL(null, -2147483648L);
  val x21208 = SEntry2_SL(null, -2147483648L);
  val x20767 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20183 = SEntry3_SSL(null, null, -2147483648L);
  val x19959 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21555 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21176 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17925 = SEntry3_SSL(null, null, -2147483648L);
  val x20331 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21614 = SEntry2_SL(null, -2147483648L);
  val x19668 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19409 = SEntry3_SSL(null, null, -2147483648L);
  val x19427 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21581 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17981 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18707 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21590 = SEntry3_SSL(null, null, -2147483648L);
  val x21733 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21669 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20801 = SEntry3_SSL(null, null, -2147483648L);
  val x18044 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20745 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21031 = SEntry3_SSL(null, null, -2147483648L);
  val x18544 = SEntry3_SSL(null, null, -2147483648L);
  val x21704 = SEntry2_SL(null, -2147483648L);
  val x18655 = SEntry3_SSL(null, null, -2147483648L);
  val x19771 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20916 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  def onAddMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      val x31 = message_m_c_replyof.==("\\N");
      if(x31) {
        x17882._2_=(message_m_messageid)
        val x40229 = COUNT_mMESSAGE2Idx1.sliceRes(x17882);
        if((x40229.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17882, ({ x33: SEntry3_SSL => {
              x17935._3_=(message_m_creatorid)
              val x40225 = COUNT_mMESSAGE3Idx1.sliceRes(x17935);
              if((x40225.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x17935, ({ x37: SEntry4_SSSL => {
                    x18083._1_=((x37._1))
                    x18083._2_=((x37._2))
                    x18083._3_=(message_m_creatorid)
                    x18083._4_=((x33._1))
                    x18083._5_=(message_m_messageid)
                    x18083._6_=(((x33._3).*((x37._4))))
                    val x18084 = x18083._6;
                    if((x18084.==(0L))) {
                    } else {
                      val x29300 = COUNTIdx0.get(x18083);
                      if((x29300.==(null))) {
                        COUNT.unsafeInsert(x18083)
                      } else {
                        x29300._6 +=(x18084)
                        if(((x29300._6).==(0L))) {
                          COUNT.delete(x29300)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40225)
              }
              ()
            }
          }), x40229)
        }
      } else {
      }
      if(x31) {
        x17886._2_=(message_m_messageid)
        val x40255 = COUNT_mMESSAGE2Idx1.sliceRes(x17886);
        if((x40255.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17886, ({ x62: SEntry3_SSL => {
              x17945._1_=((x62._1))
              x17945._2_=(message_m_messageid)
              x17945._3_=(message_m_creatorid)
              x17945._4_=((x62._3))
              val x17946 = x17945._4;
              if((x17946.==(0L))) {
              } else {
                val x29325 = COUNT_mKNOWS21Idx0.get(x17945);
                if((x29325.==(null))) {
                  COUNT_mKNOWS21.unsafeInsert(x17945)
                } else {
                  x29325._4 +=(x17946)
                  if(((x29325._4).==(0L))) {
                    COUNT_mKNOWS21.delete(x29325)
                  } else {
                  }
                }
              }
            
            }
          }), x40255)
        }
      } else {
      }
      x17890._1_=(message_m_messageid)
      x17890._2_=(message_m_creatorid)
      x17890._3_=((if(x31) 1L else 0L))
      val x17891 = x17890._3;
      if((x17891.==(0L))) {
      } else {
        val x29344 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx0.get(x17890);
        if((x29344.==(null))) {
          COUNT_mKNOWS21_mMESSAGE_TAG1.unsafeInsert(x17890)
        } else {
          x29344._3 +=(x17891)
          if(((x29344._3).==(0L))) {
            COUNT_mKNOWS21_mMESSAGE_TAG1.delete(x29344)
          } else {
          }
        }
      }
      if(x31) {
        x17905._1_=(message_m_messageid)
        val x40297 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17905);
        if((x40297.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17905, ({ x98: SEntry3_SSL => {
              x17981._1_=(message_m_messageid)
              x17981._2_=((x98._2))
              x17981._3_=(message_m_creatorid)
              x17981._4_=((x98._3))
              val x17982 = x17981._4;
              if((x17982.==(0L))) {
              } else {
                val x29369 = COUNT_mKNOWS21_mTAG1Idx0.get(x17981);
                if((x29369.==(null))) {
                  COUNT_mKNOWS21_mTAG1.unsafeInsert(x17981)
                } else {
                  x29369._4 +=(x17982)
                  if(((x29369._4).==(0L))) {
                    COUNT_mKNOWS21_mTAG1.delete(x29369)
                  } else {
                  }
                }
              }
            
            }
          }), x40297)
        }
      } else {
      }
      if(x31) {
        x17909._2_=(message_m_messageid)
        val x40334 = COUNT_mMESSAGE2Idx1.sliceRes(x17909);
        if((x40334.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17909, ({ x119: SEntry3_SSL => {
              x18002._2_=(message_m_creatorid)
              val x40330 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18002);
              if((x40330.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18002, ({ x123: SEntry3_SSL => {
                    x18168._1_=((x119._1))
                    x18168._2_=(message_m_messageid)
                    x18168._3_=((x123._1))
                    x18168._4_=(message_m_creatorid)
                    x18168._5_=(((x119._3).*((x123._3))))
                    val x18169 = x18168._5;
                    if((x18169.==(0L))) {
                    } else {
                      val x29402 = COUNT_mKNOWS12Idx0.get(x18168);
                      if((x29402.==(null))) {
                        COUNT_mKNOWS12.unsafeInsert(x18168)
                      } else {
                        x29402._5 +=(x18169)
                        if(((x29402._5).==(0L))) {
                          COUNT_mKNOWS12.delete(x29402)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40330)
              }
              ()
            }
          }), x40334)
        }
      } else {
      }
      if(x31) {
        x17913._2_=(message_m_creatorid)
        val x40360 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x17913);
        if((x40360.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x17913, ({ x147: SEntry3_SSL => {
              x18012._1_=(message_m_messageid)
              x18012._2_=((x147._1))
              x18012._3_=(message_m_creatorid)
              x18012._4_=((x147._3))
              val x18013 = x18012._4;
              if((x18013.==(0L))) {
              } else {
                val x29428 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x18012);
                if((x29428.==(null))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x18012)
                } else {
                  x29428._4 +=(x18013)
                  if(((x29428._4).==(0L))) {
                    COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x29428)
                  } else {
                  }
                }
              }
            
            }
          }), x40360)
        }
      } else {
      }
      if(x31) {
        x17917._1_=(message_m_messageid)
        val x40397 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17917);
        if((x40397.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17917, ({ x168: SEntry3_SSL => {
              x18033._2_=(message_m_creatorid)
              val x40393 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18033);
              if((x40393.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18033, ({ x172: SEntry3_SSL => {
                    x18217._1_=(message_m_messageid)
                    x18217._2_=((x168._2))
                    x18217._3_=((x172._1))
                    x18217._4_=(message_m_creatorid)
                    x18217._5_=(((x168._3).*((x172._3))))
                    val x18218 = x18217._5;
                    if((x18218.==(0L))) {
                    } else {
                      val x29461 = COUNT_mKNOWS12_mTAG1Idx0.get(x18217);
                      if((x29461.==(null))) {
                        COUNT_mKNOWS12_mTAG1.unsafeInsert(x18217)
                      } else {
                        x29461._5 +=(x18218)
                        if(((x29461._5).==(0L))) {
                          COUNT_mKNOWS12_mTAG1.delete(x29461)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40393)
              }
              ()
            }
          }), x40397)
        }
      } else {
      }
      if(x31) {
        x17921._3_=(message_m_creatorid)
        val x40425 = COUNT_mMESSAGE3Idx1.sliceRes(x17921);
        if((x40425.isEmpty)) {
        } else {
          COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x17921, ({ x196: SEntry4_SSSL => {
              x18044._1_=(message_m_messageid)
              x18044._2_=((x196._1))
              x18044._3_=((x196._2))
              x18044._4_=(message_m_creatorid)
              x18044._5_=((x196._4))
              val x18045 = x18044._5;
              if((x18045.==(0L))) {
              } else {
                val x29490 = COUNT_mMESSAGE_TAG1Idx0.get(x18044);
                if((x29490.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x18044)
                } else {
                  x29490._5 +=(x18045)
                  if(((x29490._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x29490)
                  } else {
                  }
                }
              }
            
            }
          }), x40425)
        }
      } else {
      }
      if(x31) {
        x17925._1_=(message_m_messageid)
        val x40464 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17925);
        if((x40464.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17925, ({ x218: SEntry3_SSL => {
              x18065._3_=(message_m_creatorid)
              val x40460 = COUNT_mMESSAGE3Idx1.sliceRes(x18065);
              if((x40460.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18065, ({ x222: SEntry4_SSSL => {
                    x18268._1_=(message_m_messageid)
                    x18268._2_=((x218._2))
                    x18268._3_=((x222._1))
                    x18268._4_=((x222._2))
                    x18268._5_=(message_m_creatorid)
                    x18268._6_=(((x218._3).*((x222._4))))
                    val x18269 = x18268._6;
                    if((x18269.==(0L))) {
                    } else {
                      val x29524 = COUNT_mTAG1Idx0.get(x18268);
                      if((x29524.==(null))) {
                        COUNT_mTAG1.unsafeInsert(x18268)
                      } else {
                        x29524._6 +=(x18269)
                        if(((x29524._6).==(0L))) {
                          COUNT_mTAG1.delete(x29524)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40460)
              }
              ()
            }
          }), x40464)
        }
      } else {
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      val x261 = message_m_c_replyof.==("\\N");
      if(x261) {
        x18501._2_=(message_m_messageid)
        val x40505 = COUNT_mMESSAGE2Idx1.sliceRes(x18501);
        if((x40505.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18501, ({ x263: SEntry3_SSL => {
              x18554._3_=(message_m_creatorid)
              val x40501 = COUNT_mMESSAGE3Idx1.sliceRes(x18554);
              if((x40501.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18554, ({ x267: SEntry4_SSSL => {
                    x18707._1_=((x267._1))
                    x18707._2_=((x267._2))
                    x18707._3_=(message_m_creatorid)
                    x18707._4_=((x263._1))
                    x18707._5_=(message_m_messageid)
                    x18707._6_=(((x263._3).*(((x267._4).unary_-))))
                    val x18708 = x18707._6;
                    if((x18708.==(0L))) {
                    } else {
                      val x29821 = COUNTIdx0.get(x18707);
                      if((x29821.==(null))) {
                        COUNT.unsafeInsert(x18707)
                      } else {
                        x29821._6 +=(x18708)
                        if(((x29821._6).==(0L))) {
                          COUNT.delete(x29821)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40501)
              }
              ()
            }
          }), x40505)
        }
      } else {
      }
      if(x261) {
        x18505._2_=(message_m_messageid)
        val x40532 = COUNT_mMESSAGE2Idx1.sliceRes(x18505);
        if((x40532.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18505, ({ x293: SEntry3_SSL => {
              x18565._1_=((x293._1))
              x18565._2_=(message_m_messageid)
              x18565._3_=(message_m_creatorid)
              x18565._4_=(((x293._3).unary_-))
              val x18566 = x18565._4;
              if((x18566.==(0L))) {
              } else {
                val x29847 = COUNT_mKNOWS21Idx0.get(x18565);
                if((x29847.==(null))) {
                  COUNT_mKNOWS21.unsafeInsert(x18565)
                } else {
                  x29847._4 +=(x18566)
                  if(((x29847._4).==(0L))) {
                    COUNT_mKNOWS21.delete(x29847)
                  } else {
                  }
                }
              }
            
            }
          }), x40532)
        }
      } else {
      }
      if(x261) {
        x18509._1_=(message_m_messageid)
        x18509._2_=(message_m_creatorid)
        x18509._3_=(-1L)
        val x18510 = x18509._3;
        if((x18510.==(0L))) {
        } else {
          val x29866 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx0.get(x18509);
          if((x29866.==(null))) {
            COUNT_mKNOWS21_mMESSAGE_TAG1.unsafeInsert(x18509)
          } else {
            x29866._3 +=(x18510)
            if(((x29866._3).==(0L))) {
              COUNT_mKNOWS21_mMESSAGE_TAG1.delete(x29866)
            } else {
            }
          }
        }
      } else {
      }
      if(x261) {
        x18524._1_=(message_m_messageid)
        val x40575 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18524);
        if((x40575.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18524, ({ x330: SEntry3_SSL => {
              x18602._1_=(message_m_messageid)
              x18602._2_=((x330._2))
              x18602._3_=(message_m_creatorid)
              x18602._4_=(((x330._3).unary_-))
              val x18603 = x18602._4;
              if((x18603.==(0L))) {
              } else {
                val x29892 = COUNT_mKNOWS21_mTAG1Idx0.get(x18602);
                if((x29892.==(null))) {
                  COUNT_mKNOWS21_mTAG1.unsafeInsert(x18602)
                } else {
                  x29892._4 +=(x18603)
                  if(((x29892._4).==(0L))) {
                    COUNT_mKNOWS21_mTAG1.delete(x29892)
                  } else {
                  }
                }
              }
            
            }
          }), x40575)
        }
      } else {
      }
      if(x261) {
        x18528._2_=(message_m_messageid)
        val x40613 = COUNT_mMESSAGE2Idx1.sliceRes(x18528);
        if((x40613.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18528, ({ x352: SEntry3_SSL => {
              x18623._2_=(message_m_creatorid)
              val x40609 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18623);
              if((x40609.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18623, ({ x356: SEntry3_SSL => {
                    x18795._1_=((x352._1))
                    x18795._2_=(message_m_messageid)
                    x18795._3_=((x356._1))
                    x18795._4_=(message_m_creatorid)
                    x18795._5_=(((x352._3).*(((x356._3).unary_-))))
                    val x18796 = x18795._5;
                    if((x18796.==(0L))) {
                    } else {
                      val x29926 = COUNT_mKNOWS12Idx0.get(x18795);
                      if((x29926.==(null))) {
                        COUNT_mKNOWS12.unsafeInsert(x18795)
                      } else {
                        x29926._5 +=(x18796)
                        if(((x29926._5).==(0L))) {
                          COUNT_mKNOWS12.delete(x29926)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40609)
              }
              ()
            }
          }), x40613)
        }
      } else {
      }
      if(x261) {
        x18532._2_=(message_m_creatorid)
        val x40640 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18532);
        if((x40640.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18532, ({ x381: SEntry3_SSL => {
              x18634._1_=(message_m_messageid)
              x18634._2_=((x381._1))
              x18634._3_=(message_m_creatorid)
              x18634._4_=(((x381._3).unary_-))
              val x18635 = x18634._4;
              if((x18635.==(0L))) {
              } else {
                val x29953 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x18634);
                if((x29953.==(null))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x18634)
                } else {
                  x29953._4 +=(x18635)
                  if(((x29953._4).==(0L))) {
                    COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x29953)
                  } else {
                  }
                }
              }
            
            }
          }), x40640)
        }
      } else {
      }
      if(x261) {
        x18536._1_=(message_m_messageid)
        val x40678 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18536);
        if((x40678.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18536, ({ x403: SEntry3_SSL => {
              x18655._2_=(message_m_creatorid)
              val x40674 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18655);
              if((x40674.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18655, ({ x407: SEntry3_SSL => {
                    x18846._1_=(message_m_messageid)
                    x18846._2_=((x403._2))
                    x18846._3_=((x407._1))
                    x18846._4_=(message_m_creatorid)
                    x18846._5_=(((x403._3).*(((x407._3).unary_-))))
                    val x18847 = x18846._5;
                    if((x18847.==(0L))) {
                    } else {
                      val x29987 = COUNT_mKNOWS12_mTAG1Idx0.get(x18846);
                      if((x29987.==(null))) {
                        COUNT_mKNOWS12_mTAG1.unsafeInsert(x18846)
                      } else {
                        x29987._5 +=(x18847)
                        if(((x29987._5).==(0L))) {
                          COUNT_mKNOWS12_mTAG1.delete(x29987)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40674)
              }
              ()
            }
          }), x40678)
        }
      } else {
      }
      if(x261) {
        x18540._3_=(message_m_creatorid)
        val x40707 = COUNT_mMESSAGE3Idx1.sliceRes(x18540);
        if((x40707.isEmpty)) {
        } else {
          COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18540, ({ x432: SEntry4_SSSL => {
              x18667._1_=(message_m_messageid)
              x18667._2_=((x432._1))
              x18667._3_=((x432._2))
              x18667._4_=(message_m_creatorid)
              x18667._5_=(((x432._4).unary_-))
              val x18668 = x18667._5;
              if((x18668.==(0L))) {
              } else {
                val x30017 = COUNT_mMESSAGE_TAG1Idx0.get(x18667);
                if((x30017.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x18667)
                } else {
                  x30017._5 +=(x18668)
                  if(((x30017._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30017)
                  } else {
                  }
                }
              }
            
            }
          }), x40707)
        }
      } else {
      }
      if(x261) {
        x18544._1_=(message_m_messageid)
        val x40747 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18544);
        if((x40747.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18544, ({ x455: SEntry3_SSL => {
              x18688._3_=(message_m_creatorid)
              val x40743 = COUNT_mMESSAGE3Idx1.sliceRes(x18688);
              if((x40743.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18688, ({ x459: SEntry4_SSSL => {
                    x18899._1_=(message_m_messageid)
                    x18899._2_=((x455._2))
                    x18899._3_=((x459._1))
                    x18899._4_=((x459._2))
                    x18899._5_=(message_m_creatorid)
                    x18899._6_=(((x455._3).*(((x459._4).unary_-))))
                    val x18900 = x18899._6;
                    if((x18900.==(0L))) {
                    } else {
                      val x30052 = COUNT_mTAG1Idx0.get(x18899);
                      if((x30052.==(null))) {
                        COUNT_mTAG1.unsafeInsert(x18899)
                      } else {
                        x30052._6 +=(x18900)
                        if(((x30052._6).==(0L))) {
                          COUNT_mTAG1.delete(x30052)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40743)
              }
              ()
            }
          }), x40747)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x491 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x491) {
        x19141._3_=(knows1_k_personid2)
        val x40779 = COUNT_mKNOWS12Idx1.sliceRes(x19141);
        if((x40779.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x19141, ({ x493: SEntry5_SSSSL => {
              x19181._1_=(knows1_k_personid1)
              x19181._2_=(knows1_k_personid2)
              x19181._3_=((x493._4))
              x19181._4_=((x493._1))
              x19181._5_=((x493._2))
              x19181._6_=((x493._5))
              val x19182 = x19181._6;
              if((x19182.==(0L))) {
              } else {
                val x30352 = COUNTIdx0.get(x19181);
                if((x30352.==(null))) {
                  COUNT.unsafeInsert(x19181)
                } else {
                  x30352._6 +=(x19182)
                  if(((x30352._6).==(0L))) {
                    COUNT.delete(x30352)
                  } else {
                  }
                }
              }
            
            }
          }), x40779)
        }
      } else {
      }
      x19145._1_=(knows1_k_personid1)
      x19145._2_=(knows1_k_personid2)
      x19145._3_=((if(x491) 1L else 0L))
      val x19146 = x19145._3;
      if((x19146.==(0L))) {
      } else {
        val x30370 = COUNT_mKNOWS22Idx0.get(x19145);
        if((x30370.==(null))) {
          COUNT_mKNOWS22.unsafeInsert(x19145)
        } else {
          x30370._3 +=(x19146)
          if(((x30370._3).==(0L))) {
            COUNT_mKNOWS22.delete(x30370)
          } else {
          }
        }
      }
      if(x491) {
        x19160._2_=(knows1_k_personid2)
        val x40823 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceRes(x19160);
        if((x40823.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19160, ({ x531: SEntry4_SSSL => {
              x19218._1_=((x531._1))
              x19218._2_=(knows1_k_personid1)
              x19218._3_=(knows1_k_personid2)
              x19218._4_=((x531._3))
              x19218._5_=((x531._4))
              val x19219 = x19218._5;
              if((x19219.==(0L))) {
              } else {
                val x30396 = COUNT_mMESSAGE_TAG1Idx0.get(x19218);
                if((x30396.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x19218)
                } else {
                  x30396._5 +=(x19219)
                  if(((x30396._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30396)
                  } else {
                  }
                }
              }
            
            }
          }), x40823)
        }
      } else {
      }
      if(x491) {
        x19164._1_=(knows1_k_personid2)
        val x40849 = COUNT_mKNOWS12_mMESSAGE3Idx2.sliceRes(x19164);
        if((x40849.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx2.sliceResMapNoUpd(x19164, ({ x553: SEntry3_SSL => {
              x19239._1_=(knows1_k_personid1)
              x19239._2_=(knows1_k_personid2)
              x19239._3_=((x553._2))
              x19239._4_=((x553._3))
              val x19240 = x19239._4;
              if((x19240.==(0L))) {
              } else {
                val x30421 = COUNT_mMESSAGE3Idx0.get(x19239);
                if((x30421.==(null))) {
                  COUNT_mMESSAGE3.unsafeInsert(x19239)
                } else {
                  x30421._4 +=(x19240)
                  if(((x30421._4).==(0L))) {
                    COUNT_mMESSAGE3.delete(x30421)
                  } else {
                  }
                }
              }
            
            }
          }), x40849)
        }
      } else {
      }
      if(x491) {
        x19168._3_=(knows1_k_personid2)
        val x40879 = COUNT_mKNOWS12_mTAG1Idx2.sliceRes(x19168);
        if((x40879.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mTAG1Idx2.sliceResMapNoUpd(x19168, ({ x574: SEntry5_SSSSL => {
              x19262._1_=((x574._1))
              x19262._2_=((x574._2))
              x19262._3_=(knows1_k_personid1)
              x19262._4_=(knows1_k_personid2)
              x19262._5_=((x574._4))
              x19262._6_=((x574._5))
              val x19263 = x19262._6;
              if((x19263.==(0L))) {
              } else {
                val x30450 = COUNT_mTAG1Idx0.get(x19262);
                if((x30450.==(null))) {
                  COUNT_mTAG1.unsafeInsert(x19262)
                } else {
                  x30450._6 +=(x19263)
                  if(((x30450._6).==(0L))) {
                    COUNT_mTAG1.delete(x30450)
                  } else {
                  }
                }
              }
            
            }
          }), x40879)
        }
      } else {
      }
    
    }
  
  }
  def onDelKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x602 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x602) {
        x19386._3_=(knows1_k_personid2)
        val x40912 = COUNT_mKNOWS12Idx1.sliceRes(x19386);
        if((x40912.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x19386, ({ x604: SEntry5_SSSSL => {
              x19427._1_=(knows1_k_personid1)
              x19427._2_=(knows1_k_personid2)
              x19427._3_=((x604._4))
              x19427._4_=((x604._1))
              x19427._5_=((x604._2))
              x19427._6_=(((x604._5).unary_-))
              val x19428 = x19427._6;
              if((x19428.==(0L))) {
              } else {
                val x30611 = COUNTIdx0.get(x19427);
                if((x30611.==(null))) {
                  COUNT.unsafeInsert(x19427)
                } else {
                  x30611._6 +=(x19428)
                  if(((x30611._6).==(0L))) {
                    COUNT.delete(x30611)
                  } else {
                  }
                }
              }
            
            }
          }), x40912)
        }
      } else {
      }
      if(x602) {
        x19390._1_=(knows1_k_personid1)
        x19390._2_=(knows1_k_personid2)
        x19390._3_=(-1L)
        val x19391 = x19390._3;
        if((x19391.==(0L))) {
        } else {
          val x30629 = COUNT_mKNOWS22Idx0.get(x19390);
          if((x30629.==(null))) {
            COUNT_mKNOWS22.unsafeInsert(x19390)
          } else {
            x30629._3 +=(x19391)
            if(((x30629._3).==(0L))) {
              COUNT_mKNOWS22.delete(x30629)
            } else {
            }
          }
        }
      } else {
      }
      if(x602) {
        x19405._2_=(knows1_k_personid2)
        val x40957 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceRes(x19405);
        if((x40957.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19405, ({ x643: SEntry4_SSSL => {
              x19465._1_=((x643._1))
              x19465._2_=(knows1_k_personid1)
              x19465._3_=(knows1_k_personid2)
              x19465._4_=((x643._3))
              x19465._5_=(((x643._4).unary_-))
              val x19466 = x19465._5;
              if((x19466.==(0L))) {
              } else {
                val x30656 = COUNT_mMESSAGE_TAG1Idx0.get(x19465);
                if((x30656.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x19465)
                } else {
                  x30656._5 +=(x19466)
                  if(((x30656._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30656)
                  } else {
                  }
                }
              }
            
            }
          }), x40957)
        }
      } else {
      }
      if(x602) {
        x19409._1_=(knows1_k_personid2)
        val x40984 = COUNT_mKNOWS12_mMESSAGE3Idx2.sliceRes(x19409);
        if((x40984.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx2.sliceResMapNoUpd(x19409, ({ x666: SEntry3_SSL => {
              x19487._1_=(knows1_k_personid1)
              x19487._2_=(knows1_k_personid2)
              x19487._3_=((x666._2))
              x19487._4_=(((x666._3).unary_-))
              val x19488 = x19487._4;
              if((x19488.==(0L))) {
              } else {
                val x30682 = COUNT_mMESSAGE3Idx0.get(x19487);
                if((x30682.==(null))) {
                  COUNT_mMESSAGE3.unsafeInsert(x19487)
                } else {
                  x30682._4 +=(x19488)
                  if(((x30682._4).==(0L))) {
                    COUNT_mMESSAGE3.delete(x30682)
                  } else {
                  }
                }
              }
            
            }
          }), x40984)
        }
      } else {
      }
      if(x602) {
        x19413._3_=(knows1_k_personid2)
        val x41015 = COUNT_mKNOWS12_mTAG1Idx2.sliceRes(x19413);
        if((x41015.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mTAG1Idx2.sliceResMapNoUpd(x19413, ({ x688: SEntry5_SSSSL => {
              x19511._1_=((x688._1))
              x19511._2_=((x688._2))
              x19511._3_=(knows1_k_personid1)
              x19511._4_=(knows1_k_personid2)
              x19511._5_=((x688._4))
              x19511._6_=(((x688._5).unary_-))
              val x19512 = x19511._6;
              if((x19512.==(0L))) {
              } else {
                val x30712 = COUNT_mTAG1Idx0.get(x19511);
                if((x30712.==(null))) {
                  COUNT_mTAG1.unsafeInsert(x19511)
                } else {
                  x30712._6 +=(x19512)
                  if(((x30712._6).==(0L))) {
                    COUNT_mTAG1.delete(x30712)
                  } else {
                  }
                }
              }
            
            }
          }), x41015)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x19636._3_=(knows2_k_personid2)
      val x41053 = COUNT_mKNOWS21Idx1.sliceRes(x19636);
      if((x41053.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x19636, ({ x717: SEntry4_SSSL => {
            x19677._2_=(knows2_k_personid1)
            val x41049 = COUNT_mKNOWS22Idx1.sliceRes(x19677);
            if((x41049.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19677, ({ x722: SEntry3_SSL => {
                  x19808._1_=((x722._1))
                  x19808._2_=(knows2_k_personid1)
                  x19808._3_=(knows2_k_personid2)
                  x19808._4_=((x717._1))
                  x19808._5_=((x717._2))
                  x19808._6_=(((x717._4).*((x722._3))))
                  val x19809 = x19808._6;
                  if((x19809.==(0L))) {
                  } else {
                    val x30878 = COUNTIdx0.get(x19808);
                    if((x30878.==(null))) {
                      COUNT.unsafeInsert(x19808)
                    } else {
                      x30878._6 +=(x19809)
                      if(((x30878._6).==(0L))) {
                        COUNT.delete(x30878)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41049)
            }
            ()
          }
        }), x41053)
      }
      x19639._3_=(knows2_k_personid2)
      val x41080 = COUNT_mKNOWS21Idx1.sliceRes(x19639);
      if((x41080.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x19639, ({ x745: SEntry4_SSSL => {
            x19687._1_=((x745._1))
            x19687._2_=((x745._2))
            x19687._3_=(knows2_k_personid1)
            x19687._4_=(knows2_k_personid2)
            x19687._5_=((x745._4))
            val x19688 = x19687._5;
            if((x19688.==(0L))) {
            } else {
              val x30904 = COUNT_mKNOWS12Idx0.get(x19687);
              if((x30904.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x19687)
              } else {
                x30904._5 +=(x19688)
                if(((x30904._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x30904)
                } else {
                }
              }
            }
          
          }
        }), x41080)
      }
      x19642._2_=(knows2_k_personid2)
      val x41105 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x19642);
      if((x41105.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19642, ({ x766: SEntry3_SSL => {
            x19707._1_=((x766._1))
            x19707._2_=(knows2_k_personid1)
            x19707._3_=(knows2_k_personid2)
            x19707._4_=((x766._3))
            val x19708 = x19707._4;
            if((x19708.==(0L))) {
            } else {
              val x30928 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x19707);
              if((x30928.==(null))) {
                COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x19707)
              } else {
                x30928._4 +=(x19708)
                if(((x30928._4).==(0L))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x30928)
                } else {
                }
              }
            }
          
          }
        }), x41105)
      }
      x19645._1_=(knows2_k_personid1)
      x19645._2_=(knows2_k_personid2)
      x19645._3_=(1L)
      val x19646 = x19645._3;
      if((x19646.==(0L))) {
      } else {
        val x30947 = COUNT_mKNOWS12_mMESSAGE3Idx0.get(x19645);
        if((x30947.==(null))) {
          COUNT_mKNOWS12_mMESSAGE3.unsafeInsert(x19645)
        } else {
          x30947._3 +=(x19646)
          if(((x30947._3).==(0L))) {
            COUNT_mKNOWS12_mMESSAGE3.delete(x30947)
          } else {
          }
        }
      }
      x19659._3_=(knows2_k_personid2)
      val x41147 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x19659);
      if((x41147.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x19659, ({ x800: SEntry4_SSSL => {
            x19742._1_=((x800._1))
            x19742._2_=((x800._2))
            x19742._3_=(knows2_k_personid1)
            x19742._4_=(knows2_k_personid2)
            x19742._5_=((x800._4))
            val x19743 = x19742._5;
            if((x19743.==(0L))) {
            } else {
              val x30973 = COUNT_mKNOWS12_mTAG1Idx0.get(x19742);
              if((x30973.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x19742)
              } else {
                x30973._5 +=(x19743)
                if(((x30973._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x30973)
                } else {
                }
              }
            }
          
          }
        }), x41147)
      }
      x19662._2_=(knows2_k_personid2)
      val x41183 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x19662);
      if((x41183.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19662, ({ x821: SEntry3_SSL => {
            x19762._2_=(knows2_k_personid1)
            val x41179 = COUNT_mKNOWS22Idx1.sliceRes(x19762);
            if((x41179.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19762, ({ x825: SEntry3_SSL => {
                  x19911._1_=((x821._1))
                  x19911._2_=((x825._1))
                  x19911._3_=(knows2_k_personid1)
                  x19911._4_=(knows2_k_personid2)
                  x19911._5_=(((x821._3).*((x825._3))))
                  val x19912 = x19911._5;
                  if((x19912.==(0L))) {
                  } else {
                    val x31005 = COUNT_mMESSAGE_TAG1Idx0.get(x19911);
                    if((x31005.==(null))) {
                      COUNT_mMESSAGE_TAG1.unsafeInsert(x19911)
                    } else {
                      x31005._5 +=(x19912)
                      if(((x31005._5).==(0L))) {
                        COUNT_mMESSAGE_TAG1.delete(x31005)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41179)
            }
            ()
          }
        }), x41183)
      }
      x19665._2_=(knows2_k_personid1)
      val x41208 = COUNT_mKNOWS22Idx1.sliceRes(x19665);
      if((x41208.isEmpty)) {
      } else {
        COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19665, ({ x848: SEntry3_SSL => {
            x19771._1_=((x848._1))
            x19771._2_=(knows2_k_personid1)
            x19771._3_=(knows2_k_personid2)
            x19771._4_=((x848._3))
            val x19772 = x19771._4;
            if((x19772.==(0L))) {
            } else {
              val x31030 = COUNT_mMESSAGE3Idx0.get(x19771);
              if((x31030.==(null))) {
                COUNT_mMESSAGE3.unsafeInsert(x19771)
              } else {
                x31030._4 +=(x19772)
                if(((x31030._4).==(0L))) {
                  COUNT_mMESSAGE3.delete(x31030)
                } else {
                }
              }
            }
          
          }
        }), x41208)
      }
      x19668._3_=(knows2_k_personid2)
      val x41246 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x19668);
      if((x41246.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x19668, ({ x868: SEntry4_SSSL => {
            x19792._2_=(knows2_k_personid1)
            val x41242 = COUNT_mKNOWS22Idx1.sliceRes(x19792);
            if((x41242.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19792, ({ x873: SEntry3_SSL => {
                  x19959._1_=((x868._1))
                  x19959._2_=((x868._2))
                  x19959._3_=((x873._1))
                  x19959._4_=(knows2_k_personid1)
                  x19959._5_=(knows2_k_personid2)
                  x19959._6_=(((x868._4).*((x873._3))))
                  val x19960 = x19959._6;
                  if((x19960.==(0L))) {
                  } else {
                    val x31063 = COUNT_mTAG1Idx0.get(x19959);
                    if((x31063.==(null))) {
                      COUNT_mTAG1.unsafeInsert(x19959)
                    } else {
                      x31063._6 +=(x19960)
                      if(((x31063._6).==(0L))) {
                        COUNT_mTAG1.delete(x31063)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41242)
            }
            ()
          }
        }), x41246)
      }
    
    }
  
  }
  def onDelKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x20154._3_=(knows2_k_personid2)
      val x41285 = COUNT_mKNOWS21Idx1.sliceRes(x20154);
      if((x41285.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x20154, ({ x901: SEntry4_SSSL => {
            x20195._2_=(knows2_k_personid1)
            val x41281 = COUNT_mKNOWS22Idx1.sliceRes(x20195);
            if((x41281.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20195, ({ x906: SEntry3_SSL => {
                  x20331._1_=((x906._1))
                  x20331._2_=(knows2_k_personid1)
                  x20331._3_=(knows2_k_personid2)
                  x20331._4_=((x901._1))
                  x20331._5_=((x901._2))
                  x20331._6_=(((x901._4).*(((x906._3).unary_-))))
                  val x20332 = x20331._6;
                  if((x20332.==(0L))) {
                  } else {
                    val x31317 = COUNTIdx0.get(x20331);
                    if((x31317.==(null))) {
                      COUNT.unsafeInsert(x20331)
                    } else {
                      x31317._6 +=(x20332)
                      if(((x31317._6).==(0L))) {
                        COUNT.delete(x31317)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41281)
            }
            ()
          }
        }), x41285)
      }
      x20157._3_=(knows2_k_personid2)
      val x41313 = COUNT_mKNOWS21Idx1.sliceRes(x20157);
      if((x41313.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x20157, ({ x930: SEntry4_SSSL => {
            x20206._1_=((x930._1))
            x20206._2_=((x930._2))
            x20206._3_=(knows2_k_personid1)
            x20206._4_=(knows2_k_personid2)
            x20206._5_=(((x930._4).unary_-))
            val x20207 = x20206._5;
            if((x20207.==(0L))) {
            } else {
              val x31344 = COUNT_mKNOWS12Idx0.get(x20206);
              if((x31344.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20206)
              } else {
                x31344._5 +=(x20207)
                if(((x31344._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x31344)
                } else {
                }
              }
            }
          
          }
        }), x41313)
      }
      x20160._2_=(knows2_k_personid2)
      val x41339 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x20160);
      if((x41339.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x20160, ({ x952: SEntry3_SSL => {
            x20227._1_=((x952._1))
            x20227._2_=(knows2_k_personid1)
            x20227._3_=(knows2_k_personid2)
            x20227._4_=(((x952._3).unary_-))
            val x20228 = x20227._4;
            if((x20228.==(0L))) {
            } else {
              val x31369 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x20227);
              if((x31369.==(null))) {
                COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x20227)
              } else {
                x31369._4 +=(x20228)
                if(((x31369._4).==(0L))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x31369)
                } else {
                }
              }
            }
          
          }
        }), x41339)
      }
      x20163._1_=(knows2_k_personid1)
      x20163._2_=(knows2_k_personid2)
      x20163._3_=(-1L)
      val x20164 = x20163._3;
      if((x20164.==(0L))) {
      } else {
        val x31388 = COUNT_mKNOWS12_mMESSAGE3Idx0.get(x20163);
        if((x31388.==(null))) {
          COUNT_mKNOWS12_mMESSAGE3.unsafeInsert(x20163)
        } else {
          x31388._3 +=(x20164)
          if(((x31388._3).==(0L))) {
            COUNT_mKNOWS12_mMESSAGE3.delete(x31388)
          } else {
          }
        }
      }
      x20177._3_=(knows2_k_personid2)
      val x41382 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x20177);
      if((x41382.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x20177, ({ x987: SEntry4_SSSL => {
            x20263._1_=((x987._1))
            x20263._2_=((x987._2))
            x20263._3_=(knows2_k_personid1)
            x20263._4_=(knows2_k_personid2)
            x20263._5_=(((x987._4).unary_-))
            val x20264 = x20263._5;
            if((x20264.==(0L))) {
            } else {
              val x31415 = COUNT_mKNOWS12_mTAG1Idx0.get(x20263);
              if((x31415.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x20263)
              } else {
                x31415._5 +=(x20264)
                if(((x31415._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x31415)
                } else {
                }
              }
            }
          
          }
        }), x41382)
      }
      x20180._2_=(knows2_k_personid2)
      val x41419 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x20180);
      if((x41419.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x20180, ({ x1009: SEntry3_SSL => {
            x20283._2_=(knows2_k_personid1)
            val x41415 = COUNT_mKNOWS22Idx1.sliceRes(x20283);
            if((x41415.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20283, ({ x1013: SEntry3_SSL => {
                  x20438._1_=((x1009._1))
                  x20438._2_=((x1013._1))
                  x20438._3_=(knows2_k_personid1)
                  x20438._4_=(knows2_k_personid2)
                  x20438._5_=(((x1009._3).*(((x1013._3).unary_-))))
                  val x20439 = x20438._5;
                  if((x20439.==(0L))) {
                  } else {
                    val x31448 = COUNT_mMESSAGE_TAG1Idx0.get(x20438);
                    if((x31448.==(null))) {
                      COUNT_mMESSAGE_TAG1.unsafeInsert(x20438)
                    } else {
                      x31448._5 +=(x20439)
                      if(((x31448._5).==(0L))) {
                        COUNT_mMESSAGE_TAG1.delete(x31448)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41415)
            }
            ()
          }
        }), x41419)
      }
      x20183._2_=(knows2_k_personid1)
      val x41445 = COUNT_mKNOWS22Idx1.sliceRes(x20183);
      if((x41445.isEmpty)) {
      } else {
        COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20183, ({ x1037: SEntry3_SSL => {
            x20293._1_=((x1037._1))
            x20293._2_=(knows2_k_personid1)
            x20293._3_=(knows2_k_personid2)
            x20293._4_=(((x1037._3).unary_-))
            val x20294 = x20293._4;
            if((x20294.==(0L))) {
            } else {
              val x31474 = COUNT_mMESSAGE3Idx0.get(x20293);
              if((x31474.==(null))) {
                COUNT_mMESSAGE3.unsafeInsert(x20293)
              } else {
                x31474._4 +=(x20294)
                if(((x31474._4).==(0L))) {
                  COUNT_mMESSAGE3.delete(x31474)
                } else {
                }
              }
            }
          
          }
        }), x41445)
      }
      x20186._3_=(knows2_k_personid2)
      val x41484 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x20186);
      if((x41484.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x20186, ({ x1058: SEntry4_SSSL => {
            x20314._2_=(knows2_k_personid1)
            val x41480 = COUNT_mKNOWS22Idx1.sliceRes(x20314);
            if((x41480.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20314, ({ x1063: SEntry3_SSL => {
                  x20488._1_=((x1058._1))
                  x20488._2_=((x1058._2))
                  x20488._3_=((x1063._1))
                  x20488._4_=(knows2_k_personid1)
                  x20488._5_=(knows2_k_personid2)
                  x20488._6_=(((x1058._4).*(((x1063._3).unary_-))))
                  val x20489 = x20488._6;
                  if((x20489.==(0L))) {
                  } else {
                    val x31508 = COUNT_mTAG1Idx0.get(x20488);
                    if((x31508.==(null))) {
                      COUNT_mTAG1.unsafeInsert(x20488)
                    } else {
                      x31508._6 +=(x20489)
                      if(((x31508._6).==(0L))) {
                        COUNT_mTAG1.delete(x31508)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41480)
            }
            ()
          }
        }), x41484)
      }
    
    }
  
  }
  def onAddTAG(tag_t_tag_time:String, tag_t_op:String, tag_t_tagid:String, tag_t_name:String, tag_t_url:String, tag_t_tagclassid:String) {
    {
      x20690._2_=(tag_t_tagid)
      val x41514 = COUNT_mTAG1Idx1.sliceRes(x20690);
      if((x41514.isEmpty)) {
      } else {
        COUNT_mTAG1Idx1.sliceResMapNoUpd(x20690, ({ x1093: SEntry6_SSSSSL => {
            x20724._1_=((x1093._3))
            x20724._2_=((x1093._4))
            x20724._3_=((x1093._5))
            x20724._4_=(tag_t_tagid)
            x20724._5_=((x1093._1))
            x20724._6_=((x1093._6))
            val x20725 = x20724._6;
            if((x20725.==(0L))) {
            } else {
              val x31764 = COUNTIdx0.get(x20724);
              if((x31764.==(null))) {
                COUNT.unsafeInsert(x20724)
              } else {
                x31764._6 +=(x20725)
                if(((x31764._6).==(0L))) {
                  COUNT.delete(x31764)
                } else {
                }
              }
            }
          
          }
        }), x41514)
      }
      x20693._2_=(tag_t_tagid)
      val x41540 = COUNT_mKNOWS21_mTAG1Idx1.sliceRes(x20693);
      if((x41540.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx1.sliceResMapNoUpd(x20693, ({ x1116: SEntry4_SSSL => {
            x20745._1_=(tag_t_tagid)
            x20745._2_=((x1116._1))
            x20745._3_=((x1116._3))
            x20745._4_=((x1116._4))
            val x20746 = x20745._4;
            if((x20746.==(0L))) {
            } else {
              val x31788 = COUNT_mKNOWS21Idx0.get(x20745);
              if((x31788.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x20745)
              } else {
                x31788._4 +=(x20746)
                if(((x31788._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x31788)
                } else {
                }
              }
            }
          
          }
        }), x41540)
      }
      x20696._2_=(tag_t_tagid)
      val x41568 = COUNT_mKNOWS12_mTAG1Idx1.sliceRes(x20696);
      if((x41568.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mTAG1Idx1.sliceResMapNoUpd(x20696, ({ x1137: SEntry5_SSSSL => {
            x20767._1_=(tag_t_tagid)
            x20767._2_=((x1137._1))
            x20767._3_=((x1137._3))
            x20767._4_=((x1137._4))
            x20767._5_=((x1137._5))
            val x20768 = x20767._5;
            if((x20768.==(0L))) {
            } else {
              val x31815 = COUNT_mKNOWS12Idx0.get(x20767);
              if((x31815.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20767)
              } else {
                x31815._5 +=(x20768)
                if(((x31815._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x31815)
                } else {
                }
              }
            }
          
          }
        }), x41568)
      }
      x20699._1_=(tag_t_tagid)
      x20699._2_=(1L)
      val x20700 = x20699._2;
      if((x20700.==(0L))) {
      } else {
        val x31832 = COUNT_mMESSAGE_TAG2Idx0.get(x20699);
        if((x31832.==(null))) {
          COUNT_mMESSAGE_TAG2.unsafeInsert(x20699)
        } else {
          x31832._2 +=(x20700)
          if(((x31832._2).==(0L))) {
            COUNT_mMESSAGE_TAG2.delete(x31832)
          } else {
          }
        }
      }
      x20713._2_=(tag_t_tagid)
      val x41606 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceRes(x20713);
      if((x41606.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceResMapNoUpd(x20713, ({ x1173: SEntry3_SSL => {
            x20801._1_=(tag_t_tagid)
            x20801._2_=((x1173._1))
            x20801._3_=((x1173._3))
            val x20802 = x20801._3;
            if((x20802.==(0L))) {
            } else {
              val x31853 = COUNT_mMESSAGE2Idx0.get(x20801);
              if((x31853.==(null))) {
                COUNT_mMESSAGE2.unsafeInsert(x20801)
              } else {
                x31853._3 +=(x20802)
                if(((x31853._3).==(0L))) {
                  COUNT_mMESSAGE2.delete(x31853)
                } else {
                }
              }
            }
          
          }
        }), x41606)
      }
    
    }
  
  }
  def onDelTAG(tag_t_tag_time:String, tag_t_op:String, tag_t_tagid:String, tag_t_name:String, tag_t_url:String, tag_t_tagclassid:String) {
    {
      x20916._2_=(tag_t_tagid)
      val x41637 = COUNT_mTAG1Idx1.sliceRes(x20916);
      if((x41637.isEmpty)) {
      } else {
        COUNT_mTAG1Idx1.sliceResMapNoUpd(x20916, ({ x1199: SEntry6_SSSSSL => {
            x20951._1_=((x1199._3))
            x20951._2_=((x1199._4))
            x20951._3_=((x1199._5))
            x20951._4_=(tag_t_tagid)
            x20951._5_=((x1199._1))
            x20951._6_=(((x1199._6).unary_-))
            val x20952 = x20951._6;
            if((x20952.==(0L))) {
            } else {
              val x32001 = COUNTIdx0.get(x20951);
              if((x32001.==(null))) {
                COUNT.unsafeInsert(x20951)
              } else {
                x32001._6 +=(x20952)
                if(((x32001._6).==(0L))) {
                  COUNT.delete(x32001)
                } else {
                }
              }
            }
          
          }
        }), x41637)
      }
      x20919._2_=(tag_t_tagid)
      val x41664 = COUNT_mKNOWS21_mTAG1Idx1.sliceRes(x20919);
      if((x41664.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx1.sliceResMapNoUpd(x20919, ({ x1223: SEntry4_SSSL => {
            x20973._1_=(tag_t_tagid)
            x20973._2_=((x1223._1))
            x20973._3_=((x1223._3))
            x20973._4_=(((x1223._4).unary_-))
            val x20974 = x20973._4;
            if((x20974.==(0L))) {
            } else {
              val x32026 = COUNT_mKNOWS21Idx0.get(x20973);
              if((x32026.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x20973)
              } else {
                x32026._4 +=(x20974)
                if(((x32026._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32026)
                } else {
                }
              }
            }
          
          }
        }), x41664)
      }
      x20922._2_=(tag_t_tagid)
      val x41693 = COUNT_mKNOWS12_mTAG1Idx1.sliceRes(x20922);
      if((x41693.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mTAG1Idx1.sliceResMapNoUpd(x20922, ({ x1245: SEntry5_SSSSL => {
            x20996._1_=(tag_t_tagid)
            x20996._2_=((x1245._1))
            x20996._3_=((x1245._3))
            x20996._4_=((x1245._4))
            x20996._5_=(((x1245._5).unary_-))
            val x20997 = x20996._5;
            if((x20997.==(0L))) {
            } else {
              val x32054 = COUNT_mKNOWS12Idx0.get(x20996);
              if((x32054.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20996)
              } else {
                x32054._5 +=(x20997)
                if(((x32054._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32054)
                } else {
                }
              }
            }
          
          }
        }), x41693)
      }
      x20925._1_=(tag_t_tagid)
      x20925._2_=(-1L)
      val x20926 = x20925._2;
      if((x20926.==(0L))) {
      } else {
        val x32071 = COUNT_mMESSAGE_TAG2Idx0.get(x20925);
        if((x32071.==(null))) {
          COUNT_mMESSAGE_TAG2.unsafeInsert(x20925)
        } else {
          x32071._2 +=(x20926)
          if(((x32071._2).==(0L))) {
            COUNT_mMESSAGE_TAG2.delete(x32071)
          } else {
          }
        }
      }
      x20939._2_=(tag_t_tagid)
      val x41732 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceRes(x20939);
      if((x41732.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceResMapNoUpd(x20939, ({ x1282: SEntry3_SSL => {
            x21031._1_=(tag_t_tagid)
            x21031._2_=((x1282._1))
            x21031._3_=(((x1282._3).unary_-))
            val x21032 = x21031._3;
            if((x21032.==(0L))) {
            } else {
              val x32093 = COUNT_mMESSAGE2Idx0.get(x21031);
              if((x32093.==(null))) {
                COUNT_mMESSAGE2.unsafeInsert(x21031)
              } else {
                x32093._3 +=(x21032)
                if(((x32093._3).==(0L))) {
                  COUNT_mMESSAGE2.delete(x32093)
                } else {
                }
              }
            }
          
          }
        }), x41732)
      }
    
    }
  
  }
  def onAddMESSAGE_TAG(message_tag_k_op_time:String, message_tag_k_op:String, message_tag_mt_messageid:String, message_tag_mt_tagid:String) {
    {
      x21150._1_=(message_tag_mt_messageid)
      val x41767 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21150);
      if((x41767.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21150, ({ x1307: SEntry5_SSSSL => {
            x21208._1_=(message_tag_mt_tagid)
            val x32235 = COUNT_mMESSAGE_TAG2Idx0.get(x21208);
            val x1316 = if((x32235.==(null))) {
            0L
            } else {
            (x32235._2)
            };
            x21214._1_=((x1307._2))
            x21214._2_=((x1307._3))
            x21214._3_=((x1307._4))
            x21214._4_=(message_tag_mt_tagid)
            x21214._5_=(message_tag_mt_messageid)
            x21214._6_=(((x1307._5).*(x1316)))
            val x21215 = x21214._6;
            if((x21215.==(0L))) {
            } else {
              val x32249 = COUNTIdx0.get(x21214);
              if((x32249.==(null))) {
                COUNT.unsafeInsert(x21214)
              } else {
                x32249._6 +=(x21215)
                if(((x32249._6).==(0L))) {
                  COUNT.delete(x32249)
                } else {
                }
              }
            }
          
          }
        }), x41767)
      }
      x21153._1_=(message_tag_mt_messageid)
      val x41798 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21153);
      if((x41798.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21153, ({ x1335: SEntry3_SSL => {
            x21234._1_=(message_tag_mt_tagid)
            val x32266 = COUNT_mMESSAGE_TAG2Idx0.get(x21234);
            val x1342 = if((x32266.==(null))) {
            0L
            } else {
            (x32266._2)
            };
            x21240._1_=(message_tag_mt_tagid)
            x21240._2_=(message_tag_mt_messageid)
            x21240._3_=((x1335._2))
            x21240._4_=(((x1335._3).*(x1342)))
            val x21241 = x21240._4;
            if((x21241.==(0L))) {
            } else {
              val x32278 = COUNT_mKNOWS21Idx0.get(x21240);
              if((x32278.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x21240)
              } else {
                x32278._4 +=(x21241)
                if(((x32278._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32278)
                } else {
                }
              }
            }
          
          }
        }), x41798)
      }
      x21156._1_=(message_tag_mt_messageid)
      val x41823 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21156);
      if((x41823.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21156, ({ x1361: SEntry3_SSL => {
            x21260._1_=(message_tag_mt_messageid)
            x21260._2_=(message_tag_mt_tagid)
            x21260._3_=((x1361._2))
            x21260._4_=((x1361._3))
            val x21261 = x21260._4;
            if((x21261.==(0L))) {
            } else {
              val x32302 = COUNT_mKNOWS21_mTAG1Idx0.get(x21260);
              if((x32302.==(null))) {
                COUNT_mKNOWS21_mTAG1.unsafeInsert(x21260)
              } else {
                x32302._4 +=(x21261)
                if(((x32302._4).==(0L))) {
                  COUNT_mKNOWS21_mTAG1.delete(x32302)
                } else {
                }
              }
            }
          
          }
        }), x41823)
      }
      x21159._1_=(message_tag_mt_messageid)
      x21159._2_=(message_tag_mt_tagid)
      x21159._3_=(1L)
      val x21160 = x21159._3;
      if((x21160.==(0L))) {
      } else {
        val x32321 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0.get(x21159);
        if((x32321.==(null))) {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2.unsafeInsert(x21159)
        } else {
          x32321._3 +=(x21160)
          if(((x32321._3).==(0L))) {
            COUNT_mKNOWS21_mTAG1_mMESSAGE2.delete(x32321)
          } else {
          }
        }
      }
      x21173._1_=(message_tag_mt_messageid)
      val x41871 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21173);
      if((x41871.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21173, ({ x1395: SEntry4_SSSL => {
            x21295._1_=(message_tag_mt_tagid)
            val x32340 = COUNT_mMESSAGE_TAG2Idx0.get(x21295);
            val x1403 = if((x32340.==(null))) {
            0L
            } else {
            (x32340._2)
            };
            x21301._1_=(message_tag_mt_tagid)
            x21301._2_=(message_tag_mt_messageid)
            x21301._3_=((x1395._2))
            x21301._4_=((x1395._3))
            x21301._5_=(((x1395._4).*(x1403)))
            val x21302 = x21301._5;
            if((x21302.==(0L))) {
            } else {
              val x32353 = COUNT_mKNOWS12Idx0.get(x21301);
              if((x32353.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x21301)
              } else {
                x32353._5 +=(x21302)
                if(((x32353._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32353)
                } else {
                }
              }
            }
          
          }
        }), x41871)
      }
      x21176._1_=(message_tag_mt_messageid)
      val x41898 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21176);
      if((x41898.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21176, ({ x1422: SEntry4_SSSL => {
            x21322._1_=(message_tag_mt_messageid)
            x21322._2_=(message_tag_mt_tagid)
            x21322._3_=((x1422._2))
            x21322._4_=((x1422._3))
            x21322._5_=((x1422._4))
            val x21323 = x21322._5;
            if((x21323.==(0L))) {
            } else {
              val x32379 = COUNT_mKNOWS12_mTAG1Idx0.get(x21322);
              if((x32379.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x21322)
              } else {
                x32379._5 +=(x21323)
                if(((x32379._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x32379)
                } else {
                }
              }
            }
          
          }
        }), x41898)
      }
      x21179._1_=(message_tag_mt_tagid)
      val x32393 = COUNT_mMESSAGE_TAG2Idx0.get(x21179);
      val x1446 = if((x32393.==(null))) {
      0L
      } else {
      (x32393._2)
      };
      x21184._1_=(message_tag_mt_tagid)
      x21184._2_=(message_tag_mt_messageid)
      x21184._3_=(x1446)
      val x21185 = x21184._3;
      if((x21185.==(0L))) {
      } else {
        val x32403 = COUNT_mMESSAGE2Idx0.get(x21184);
        if((x32403.==(null))) {
          COUNT_mMESSAGE2.unsafeInsert(x21184)
        } else {
          x32403._3 +=(x21185)
          if(((x32403._3).==(0L))) {
            COUNT_mMESSAGE2.delete(x32403)
          } else {
          }
        }
      }
      x21198._1_=(message_tag_mt_messageid)
      val x41947 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21198);
      if((x41947.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21198, ({ x1462: SEntry5_SSSSL => {
            x21363._1_=(message_tag_mt_messageid)
            x21363._2_=(message_tag_mt_tagid)
            x21363._3_=((x1462._2))
            x21363._4_=((x1462._3))
            x21363._5_=((x1462._4))
            x21363._6_=((x1462._5))
            val x21364 = x21363._6;
            if((x21364.==(0L))) {
            } else {
              val x32430 = COUNT_mTAG1Idx0.get(x21363);
              if((x32430.==(null))) {
                COUNT_mTAG1.unsafeInsert(x21363)
              } else {
                x32430._6 +=(x21364)
                if(((x32430._6).==(0L))) {
                  COUNT_mTAG1.delete(x32430)
                } else {
                }
              }
            }
          
          }
        }), x41947)
      }
    
    }
  
  }
  def onDelMESSAGE_TAG(message_tag_k_op_time:String, message_tag_k_op:String, message_tag_mt_messageid:String, message_tag_mt_tagid:String) {
    {
      x21555._1_=(message_tag_mt_messageid)
      val x41983 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21555);
      if((x41983.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21555, ({ x1488: SEntry5_SSSSL => {
            x21614._1_=(message_tag_mt_tagid)
            val x32665 = COUNT_mMESSAGE_TAG2Idx0.get(x21614);
            val x1497 = if((x32665.==(null))) {
            0L
            } else {
            (x32665._2)
            };
            x21621._1_=((x1488._2))
            x21621._2_=((x1488._3))
            x21621._3_=((x1488._4))
            x21621._4_=(message_tag_mt_tagid)
            x21621._5_=(message_tag_mt_messageid)
            x21621._6_=(((x1488._5).*((x1497.unary_-))))
            val x21622 = x21621._6;
            if((x21622.==(0L))) {
            } else {
              val x32680 = COUNTIdx0.get(x21621);
              if((x32680.==(null))) {
                COUNT.unsafeInsert(x21621)
              } else {
                x32680._6 +=(x21622)
                if(((x32680._6).==(0L))) {
                  COUNT.delete(x32680)
                } else {
                }
              }
            }
          
          }
        }), x41983)
      }
      x21558._1_=(message_tag_mt_messageid)
      val x42015 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21558);
      if((x42015.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21558, ({ x1517: SEntry3_SSL => {
            x21641._1_=(message_tag_mt_tagid)
            val x32697 = COUNT_mMESSAGE_TAG2Idx0.get(x21641);
            val x1524 = if((x32697.==(null))) {
            0L
            } else {
            (x32697._2)
            };
            x21648._1_=(message_tag_mt_tagid)
            x21648._2_=(message_tag_mt_messageid)
            x21648._3_=((x1517._2))
            x21648._4_=(((x1517._3).*((x1524.unary_-))))
            val x21649 = x21648._4;
            if((x21649.==(0L))) {
            } else {
              val x32710 = COUNT_mKNOWS21Idx0.get(x21648);
              if((x32710.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x21648)
              } else {
                x32710._4 +=(x21649)
                if(((x32710._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32710)
                } else {
                }
              }
            }
          
          }
        }), x42015)
      }
      x21561._1_=(message_tag_mt_messageid)
      val x42041 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21561);
      if((x42041.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21561, ({ x1544: SEntry3_SSL => {
            x21669._1_=(message_tag_mt_messageid)
            x21669._2_=(message_tag_mt_tagid)
            x21669._3_=((x1544._2))
            x21669._4_=(((x1544._3).unary_-))
            val x21670 = x21669._4;
            if((x21670.==(0L))) {
            } else {
              val x32735 = COUNT_mKNOWS21_mTAG1Idx0.get(x21669);
              if((x32735.==(null))) {
                COUNT_mKNOWS21_mTAG1.unsafeInsert(x21669)
              } else {
                x32735._4 +=(x21670)
                if(((x32735._4).==(0L))) {
                  COUNT_mKNOWS21_mTAG1.delete(x32735)
                } else {
                }
              }
            }
          
          }
        }), x42041)
      }
      x21564._1_=(message_tag_mt_messageid)
      x21564._2_=(message_tag_mt_tagid)
      x21564._3_=(-1L)
      val x21565 = x21564._3;
      if((x21565.==(0L))) {
      } else {
        val x32754 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0.get(x21564);
        if((x32754.==(null))) {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2.unsafeInsert(x21564)
        } else {
          x32754._3 +=(x21565)
          if(((x32754._3).==(0L))) {
            COUNT_mKNOWS21_mTAG1_mMESSAGE2.delete(x32754)
          } else {
          }
        }
      }
      x21578._1_=(message_tag_mt_messageid)
      val x42090 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21578);
      if((x42090.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21578, ({ x1579: SEntry4_SSSL => {
            x21704._1_=(message_tag_mt_tagid)
            val x32773 = COUNT_mMESSAGE_TAG2Idx0.get(x21704);
            val x1587 = if((x32773.==(null))) {
            0L
            } else {
            (x32773._2)
            };
            x21711._1_=(message_tag_mt_tagid)
            x21711._2_=(message_tag_mt_messageid)
            x21711._3_=((x1579._2))
            x21711._4_=((x1579._3))
            x21711._5_=(((x1579._4).*((x1587.unary_-))))
            val x21712 = x21711._5;
            if((x21712.==(0L))) {
            } else {
              val x32787 = COUNT_mKNOWS12Idx0.get(x21711);
              if((x32787.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x21711)
              } else {
                x32787._5 +=(x21712)
                if(((x32787._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32787)
                } else {
                }
              }
            }
          
          }
        }), x42090)
      }
      x21581._1_=(message_tag_mt_messageid)
      val x42118 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21581);
      if((x42118.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21581, ({ x1607: SEntry4_SSSL => {
            x21733._1_=(message_tag_mt_messageid)
            x21733._2_=(message_tag_mt_tagid)
            x21733._3_=((x1607._2))
            x21733._4_=((x1607._3))
            x21733._5_=(((x1607._4).unary_-))
            val x21734 = x21733._5;
            if((x21734.==(0L))) {
            } else {
              val x32814 = COUNT_mKNOWS12_mTAG1Idx0.get(x21733);
              if((x32814.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x21733)
              } else {
                x32814._5 +=(x21734)
                if(((x32814._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x32814)
                } else {
                }
              }
            }
          
          }
        }), x42118)
      }
      x21584._1_=(message_tag_mt_tagid)
      val x32828 = COUNT_mMESSAGE_TAG2Idx0.get(x21584);
      val x1632 = if((x32828.==(null))) {
      0L
      } else {
      (x32828._2)
      };
      x21590._1_=(message_tag_mt_tagid)
      x21590._2_=(message_tag_mt_messageid)
      x21590._3_=((x1632.unary_-))
      val x21591 = x21590._3;
      if((x21591.==(0L))) {
      } else {
        val x32839 = COUNT_mMESSAGE2Idx0.get(x21590);
        if((x32839.==(null))) {
          COUNT_mMESSAGE2.unsafeInsert(x21590)
        } else {
          x32839._3 +=(x21591)
          if(((x32839._3).==(0L))) {
            COUNT_mMESSAGE2.delete(x32839)
          } else {
          }
        }
      }
      x21604._1_=(message_tag_mt_messageid)
      val x42169 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21604);
      if((x42169.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21604, ({ x1649: SEntry5_SSSSL => {
            x21776._1_=(message_tag_mt_messageid)
            x21776._2_=(message_tag_mt_tagid)
            x21776._3_=((x1649._2))
            x21776._4_=((x1649._3))
            x21776._5_=((x1649._4))
            x21776._6_=(((x1649._5).unary_-))
            val x21777 = x21776._6;
            if((x21777.==(0L))) {
            } else {
              val x32867 = COUNT_mTAG1Idx0.get(x21776);
              if((x32867.==(null))) {
                COUNT_mTAG1.unsafeInsert(x21776)
              } else {
                x32867._6 +=(x21777)
                if(((x32867._6).==(0L))) {
                  COUNT_mTAG1.delete(x32867)
                } else {
                }
              }
            }
          
          }
        }), x42169)
      }
    
    }
  
  }
  def onSystemReady() {
    {
    
    }
  
  }

  val preg1 = java.util.regex.Pattern.compile("^.{0,5}$");
}

class Rsnb_q2_0_003 extends Rsnb_q2_0_003Base with Actor {
  import ddbt.lib.Messages._
  import ddbt.lib.Functions._
  import Rsnb_q2_0_003._
  
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
    case TupleEvent(TupleInsert, "TAG", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddTAG(v0,v1,v2,v3,v4,v5)
    case TupleEvent(TupleDelete, "TAG", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelTAG(v0,v1,v2,v3,v4,v5)
    case TupleEvent(TupleInsert, "MESSAGE_TAG", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddMESSAGE_TAG(v0,v1,v2,v3)
    case TupleEvent(TupleDelete, "MESSAGE_TAG", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelMESSAGE_TAG(v0,v1,v2,v3)
    case StreamInit(timeout) => 
      
      onSystemReady();
      t0 = System.nanoTime;
      if (timeout > 0) t1 = t0 + timeout * 1000000L
    case EndOfStream | GetSnapshot(_) => 
      t1 = System.nanoTime; 
       sender ! (StreamStat(t1 - t0, tN, tS), List({ val COUNT_node_mres = new scala.collection.mutable.HashMap[(String, String, String, String, String),Long](); COUNT.foreach{e => COUNT_node_mres += (((e._1, e._2, e._3, e._4, e._5),e._6)) }; COUNT_node_mres.toMap }))
  }
}