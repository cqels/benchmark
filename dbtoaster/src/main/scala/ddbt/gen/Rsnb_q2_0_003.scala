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
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_003/ouput/dbtoaster.tag.window.csv"),new Adaptor.CSV("TAG","string,string,string,string","\\Q|\\E", "insert"),Split()),
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
    override def hash(x17129 : SEntry4_SSSL) = {
      var x17130: Int = 0;
      val x17131 = x17130;
      x17130 = (x17131.^((((((x17129._2).hashCode()).+(-1640531527)).+((x17131.<<(6)))).+((x17131.>>(2))))))
      val x17141 = x17130;
      x17141
    }
    override def cmp(x17143 : SEntry4_SSSL , x17144 : SEntry4_SSSL) = {
      var x17145: Int = 0;
      if(((x17143._2).==((x17144._2)))) {
        x17145 = 0
      } else {
        x17145 = 1
      }
      val x17152 = x17145;
      x17152
    }
  }
   object SEntry3_SSL_Idx12 extends EntryIdx[SEntry3_SSL] {
    override def hash(x16930 : SEntry3_SSL) = {
      var x16931: Int = 0;
      val x16932 = x16931;
      x16931 = (x16932.^((((((x16930._1).hashCode()).+(-1640531527)).+((x16932.<<(6)))).+((x16932.>>(2))))))
      val x16942 = x16931;
      x16931 = (x16942.^((((((x16930._2).hashCode()).+(-1640531527)).+((x16942.<<(6)))).+((x16942.>>(2))))))
      val x16952 = x16931;
      x16952
    }
    override def cmp(x16954 : SEntry3_SSL , x16955 : SEntry3_SSL) = {
      var x16956: Int = 0;
      if(((x16954._1).==((x16955._1)))) {
        if(((x16954._2).==((x16955._2)))) {
          x16956 = 0
        } else {
          x16956 = 1
        }
      } else {
        x16956 = 1
      }
      val x16968 = x16956;
      x16968
    }
  }
   object SEntry6_SSSSSL_Idx12345 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x16812 : SEntry6_SSSSSL) = {
      var x16813: Int = 0;
      val x16814 = x16813;
      x16813 = (x16814.^((((((x16812._1).hashCode()).+(-1640531527)).+((x16814.<<(6)))).+((x16814.>>(2))))))
      val x16824 = x16813;
      x16813 = (x16824.^((((((x16812._2).hashCode()).+(-1640531527)).+((x16824.<<(6)))).+((x16824.>>(2))))))
      val x16834 = x16813;
      x16813 = (x16834.^((((((x16812._3).hashCode()).+(-1640531527)).+((x16834.<<(6)))).+((x16834.>>(2))))))
      val x16844 = x16813;
      x16813 = (x16844.^((((((x16812._4).hashCode()).+(-1640531527)).+((x16844.<<(6)))).+((x16844.>>(2))))))
      val x16854 = x16813;
      x16813 = (x16854.^((((((x16812._5).hashCode()).+(-1640531527)).+((x16854.<<(6)))).+((x16854.>>(2))))))
      val x16864 = x16813;
      x16864
    }
    override def cmp(x16866 : SEntry6_SSSSSL , x16867 : SEntry6_SSSSSL) = {
      var x16868: Int = 0;
      if(((x16866._1).==((x16867._1)))) {
        if(((x16866._2).==((x16867._2)))) {
          if(((x16866._3).==((x16867._3)))) {
            if(((x16866._4).==((x16867._4)))) {
              if(((x16866._5).==((x16867._5)))) {
                x16868 = 0
              } else {
                x16868 = 1
              }
            } else {
              x16868 = 1
            }
          } else {
            x16868 = 1
          }
        } else {
          x16868 = 1
        }
      } else {
        x16868 = 1
      }
      val x16895 = x16868;
      x16895
    }
  }
   object SEntry4_SSSL_Idx123 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17073 : SEntry4_SSSL) = {
      var x17074: Int = 0;
      val x17075 = x17074;
      x17074 = (x17075.^((((((x17073._1).hashCode()).+(-1640531527)).+((x17075.<<(6)))).+((x17075.>>(2))))))
      val x17085 = x17074;
      x17074 = (x17085.^((((((x17073._2).hashCode()).+(-1640531527)).+((x17085.<<(6)))).+((x17085.>>(2))))))
      val x17095 = x17074;
      x17074 = (x17095.^((((((x17073._3).hashCode()).+(-1640531527)).+((x17095.<<(6)))).+((x17095.>>(2))))))
      val x17105 = x17074;
      x17105
    }
    override def cmp(x17107 : SEntry4_SSSL , x17108 : SEntry4_SSSL) = {
      var x17109: Int = 0;
      if(((x17107._1).==((x17108._1)))) {
        if(((x17107._2).==((x17108._2)))) {
          if(((x17107._3).==((x17108._3)))) {
            x17109 = 0
          } else {
            x17109 = 1
          }
        } else {
          x17109 = 1
        }
      } else {
        x17109 = 1
      }
      val x17126 = x17109;
      x17126
    }
  }
   object SEntry2_SL_Idx1 extends EntryIdx[SEntry2_SL] {
    override def hash(x17227 : SEntry2_SL) = {
      var x17228: Int = 0;
      val x17229 = x17228;
      x17228 = (x17229.^((((((x17227._1).hashCode()).+(-1640531527)).+((x17229.<<(6)))).+((x17229.>>(2))))))
      val x17239 = x17228;
      x17239
    }
    override def cmp(x17241 : SEntry2_SL , x17242 : SEntry2_SL) = {
      var x17243: Int = 0;
      if(((x17241._1).==((x17242._1)))) {
        x17243 = 0
      } else {
        x17243 = 1
      }
      val x17250 = x17243;
      x17250
    }
  }
   object SEntry4_SSSL_Idx3 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17155 : SEntry4_SSSL) = {
      var x17156: Int = 0;
      val x17157 = x17156;
      x17156 = (x17157.^((((((x17155._3).hashCode()).+(-1640531527)).+((x17157.<<(6)))).+((x17157.>>(2))))))
      val x17167 = x17156;
      x17167
    }
    override def cmp(x17169 : SEntry4_SSSL , x17170 : SEntry4_SSSL) = {
      var x17171: Int = 0;
      if(((x17169._3).==((x17170._3)))) {
        x17171 = 0
      } else {
        x17171 = 1
      }
      val x17178 = x17171;
      x17178
    }
  }
   object SEntry5_SSSSL_Idx1 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16748 : SEntry5_SSSSL) = {
      var x16749: Int = 0;
      val x16750 = x16749;
      x16749 = (x16750.^((((((x16748._1).hashCode()).+(-1640531527)).+((x16750.<<(6)))).+((x16750.>>(2))))))
      val x16760 = x16749;
      x16760
    }
    override def cmp(x16762 : SEntry5_SSSSL , x16763 : SEntry5_SSSSL) = {
      var x16764: Int = 0;
      if(((x16762._1).==((x16763._1)))) {
        x16764 = 0
      } else {
        x16764 = 1
      }
      val x16771 = x16764;
      x16771
    }
  }
   object SEntry5_SSSSL_Idx3 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16780 : SEntry5_SSSSL) = {
      var x16781: Int = 0;
      val x16782 = x16781;
      x16781 = (x16782.^((((((x16780._3).hashCode()).+(-1640531527)).+((x16782.<<(6)))).+((x16782.>>(2))))))
      val x16792 = x16781;
      x16792
    }
    override def cmp(x16794 : SEntry5_SSSSL , x16795 : SEntry5_SSSSL) = {
      var x16796: Int = 0;
      if(((x16794._3).==((x16795._3)))) {
        x16796 = 0
      } else {
        x16796 = 1
      }
      val x16803 = x16796;
      x16803
    }
  }
   object SEntry4_SSSL_Idx1 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x17194 : SEntry4_SSSL) = {
      var x17195: Int = 0;
      val x17196 = x17195;
      x17195 = (x17196.^((((((x17194._1).hashCode()).+(-1640531527)).+((x17196.<<(6)))).+((x17196.>>(2))))))
      val x17206 = x17195;
      x17206
    }
    override def cmp(x17208 : SEntry4_SSSL , x17209 : SEntry4_SSSL) = {
      var x17210: Int = 0;
      if(((x17208._1).==((x17209._1)))) {
        x17210 = 0
      } else {
        x17210 = 1
      }
      val x17217 = x17210;
      x17217
    }
  }
   object SEntry3_SSL_Idx2 extends EntryIdx[SEntry3_SSL] {
    override def hash(x16971 : SEntry3_SSL) = {
      var x16972: Int = 0;
      val x16973 = x16972;
      x16972 = (x16973.^((((((x16971._2).hashCode()).+(-1640531527)).+((x16973.<<(6)))).+((x16973.>>(2))))))
      val x16983 = x16972;
      x16983
    }
    override def cmp(x16985 : SEntry3_SSL , x16986 : SEntry3_SSL) = {
      var x16987: Int = 0;
      if(((x16985._2).==((x16986._2)))) {
        x16987 = 0
      } else {
        x16987 = 1
      }
      val x16994 = x16987;
      x16994
    }
  }
   object SEntry5_SSSSL_Idx2 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x17030 : SEntry5_SSSSL) = {
      var x17031: Int = 0;
      val x17032 = x17031;
      x17031 = (x17032.^((((((x17030._2).hashCode()).+(-1640531527)).+((x17032.<<(6)))).+((x17032.>>(2))))))
      val x17042 = x17031;
      x17042
    }
    override def cmp(x17044 : SEntry5_SSSSL , x17045 : SEntry5_SSSSL) = {
      var x17046: Int = 0;
      if(((x17044._2).==((x17045._2)))) {
        x17046 = 0
      } else {
        x17046 = 1
      }
      val x17053 = x17046;
      x17053
    }
  }
   object SEntry5_SSSSL_Idx1234 extends EntryIdx[SEntry5_SSSSL] {
    override def hash(x16677 : SEntry5_SSSSL) = {
      var x16678: Int = 0;
      val x16679 = x16678;
      x16678 = (x16679.^((((((x16677._1).hashCode()).+(-1640531527)).+((x16679.<<(6)))).+((x16679.>>(2))))))
      val x16689 = x16678;
      x16678 = (x16689.^((((((x16677._2).hashCode()).+(-1640531527)).+((x16689.<<(6)))).+((x16689.>>(2))))))
      val x16699 = x16678;
      x16678 = (x16699.^((((((x16677._3).hashCode()).+(-1640531527)).+((x16699.<<(6)))).+((x16699.>>(2))))))
      val x16709 = x16678;
      x16678 = (x16709.^((((((x16677._4).hashCode()).+(-1640531527)).+((x16709.<<(6)))).+((x16709.>>(2))))))
      val x16719 = x16678;
      x16719
    }
    override def cmp(x16721 : SEntry5_SSSSL , x16722 : SEntry5_SSSSL) = {
      var x16723: Int = 0;
      if(((x16721._1).==((x16722._1)))) {
        if(((x16721._2).==((x16722._2)))) {
          if(((x16721._3).==((x16722._3)))) {
            if(((x16721._4).==((x16722._4)))) {
              x16723 = 0
            } else {
              x16723 = 1
            }
          } else {
            x16723 = 1
          }
        } else {
          x16723 = 1
        }
      } else {
        x16723 = 1
      }
      val x16745 = x16723;
      x16745
    }
  }
   object SEntry6_SSSSSL_Idx2 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x16898 : SEntry6_SSSSSL) = {
      var x16899: Int = 0;
      val x16900 = x16899;
      x16899 = (x16900.^((((((x16898._2).hashCode()).+(-1640531527)).+((x16900.<<(6)))).+((x16900.>>(2))))))
      val x16910 = x16899;
      x16910
    }
    override def cmp(x16912 : SEntry6_SSSSSL , x16913 : SEntry6_SSSSSL) = {
      var x16914: Int = 0;
      if(((x16912._2).==((x16913._2)))) {
        x16914 = 0
      } else {
        x16914 = 1
      }
      val x16921 = x16914;
      x16921
    }
  }
   object SEntry3_SSL_Idx1 extends EntryIdx[SEntry3_SSL] {
    override def hash(x16997 : SEntry3_SSL) = {
      var x16998: Int = 0;
      val x16999 = x16998;
      x16998 = (x16999.^((((((x16997._1).hashCode()).+(-1640531527)).+((x16999.<<(6)))).+((x16999.>>(2))))))
      val x17009 = x16998;
      x17009
    }
    override def cmp(x17011 : SEntry3_SSL , x17012 : SEntry3_SSL) = {
      var x17013: Int = 0;
      if(((x17011._1).==((x17012._1)))) {
        x17013 = 0
      } else {
        x17013 = 1
      }
      val x17020 = x17013;
      x17020
    }
  }
  
  val x16775 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx1)
  val COUNT_mMESSAGE_TAG1 = new Store[SEntry5_SSSSL](2, x16775);
  val COUNT_mMESSAGE_TAG1Idx0 = COUNT_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mMESSAGE_TAG1Idx1 = COUNT_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val x16807 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx3)
  val COUNT_mKNOWS12 = new Store[SEntry5_SSSSL](2, x16807);
  val COUNT_mKNOWS12Idx0 = COUNT_mKNOWS12.index(0, IHash, true, -1)
  val COUNT_mKNOWS12Idx1 = COUNT_mKNOWS12.index(1, IHash, false, -1)
  val x16925 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345, SEntry6_SSSSSL_Idx2)
  val COUNT_mTAG1 = new Store[SEntry6_SSSSSL](2, x16925);
  val COUNT_mTAG1Idx0 = COUNT_mTAG1.index(0, IHash, true, -1)
  val COUNT_mTAG1Idx1 = COUNT_mTAG1.index(1, IHash, false, -1)
  val x17024 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2 = new Store[SEntry3_SSL](3, x17024);
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2 = COUNT_mKNOWS21_mTAG1_mMESSAGE2.index(2, IHash, false, -1)
  val x17057 = Array[EntryIdx[SEntry5_SSSSL]](SEntry5_SSSSL_Idx1234, SEntry5_SSSSL_Idx2, SEntry5_SSSSL_Idx3)
  val COUNT_mKNOWS12_mTAG1 = new Store[SEntry5_SSSSL](3, x17057);
  val COUNT_mKNOWS12_mTAG1Idx0 = COUNT_mKNOWS12_mTAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mTAG1Idx1 = COUNT_mKNOWS12_mTAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mTAG1Idx2 = COUNT_mKNOWS12_mTAG1.index(2, IHash, false, -1)
  val x17062 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS12_mMESSAGE3 = new Store[SEntry3_SSL](3, x17062);
  val COUNT_mKNOWS12_mMESSAGE3Idx0 = COUNT_mKNOWS12_mMESSAGE3.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mMESSAGE3Idx1 = COUNT_mKNOWS12_mMESSAGE3.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mMESSAGE3Idx2 = COUNT_mKNOWS12_mMESSAGE3.index(2, IHash, false, -1)
  val x17069 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345)
  val COUNT = new Store[SEntry6_SSSSSL](1, x17069);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  val x17182 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx2, SEntry4_SSSL_Idx3)
  val COUNT_mKNOWS21_mTAG1 = new Store[SEntry4_SSSL](3, x17182);
  val COUNT_mKNOWS21_mTAG1Idx0 = COUNT_mKNOWS21_mTAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mTAG1Idx1 = COUNT_mKNOWS21_mTAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mTAG1Idx2 = COUNT_mKNOWS21_mTAG1.index(2, IHash, false, -1)
  val x17189 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mMESSAGE2 = new Store[SEntry3_SSL](2, x17189);
  val COUNT_mMESSAGE2Idx0 = COUNT_mMESSAGE2.index(0, IHash, true, -1)
  val COUNT_mMESSAGE2Idx1 = COUNT_mMESSAGE2.index(1, IHash, false, -1)
  val x17221 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx2, SEntry4_SSSL_Idx1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1 = new Store[SEntry4_SSSL](3, x17221);
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx0 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx1 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS12_mMESSAGE_TAG1Idx2 = COUNT_mKNOWS12_mMESSAGE_TAG1.index(2, IHash, false, -1)
  val x17254 = Array[EntryIdx[SEntry2_SL]](SEntry2_SL_Idx1)
  val COUNT_mMESSAGE_TAG2 = new Store[SEntry2_SL](1, x17254);
  val COUNT_mMESSAGE_TAG2Idx0 = COUNT_mMESSAGE_TAG2.index(0, IHash, true, -1)
  val x17257 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mKNOWS22 = new Store[SEntry3_SSL](2, x17257);
  val COUNT_mKNOWS22Idx0 = COUNT_mKNOWS22.index(0, IHash, true, -1)
  val COUNT_mKNOWS22Idx1 = COUNT_mKNOWS22.index(1, IHash, false, -1)
  val x17263 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mMESSAGE3 = new Store[SEntry4_SSSL](2, x17263);
  val COUNT_mMESSAGE3Idx0 = COUNT_mMESSAGE3.index(0, IHash, true, -1)
  val COUNT_mMESSAGE3Idx1 = COUNT_mMESSAGE3.index(1, IHash, false, -1)
  val x17267 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx3)
  val COUNT_mKNOWS21 = new Store[SEntry4_SSSL](2, x17267);
  val COUNT_mKNOWS21Idx0 = COUNT_mKNOWS21.index(0, IHash, true, -1)
  val COUNT_mKNOWS21Idx1 = COUNT_mKNOWS21.index(1, IHash, false, -1)
  val x17271 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2, SEntry3_SSL_Idx1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1 = new Store[SEntry3_SSL](3, x17271);
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx0 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(0, IHash, true, -1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx1 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(1, IHash, false, -1)
  val COUNT_mKNOWS21_mMESSAGE_TAG1Idx2 = COUNT_mKNOWS21_mMESSAGE_TAG1.index(2, IHash, false, -1)
  
  
  
  val x20709 = SEntry3_SSL(null, null, -2147483648L);
  val x18213 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19767 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19401 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20279 = SEntry3_SSL(null, null, -2147483648L);
  val x17917 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21574 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18164 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20484 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17886 = SEntry3_SSL(null, null, -2147483648L);
  val x21194 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18536 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21236 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19907 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21637 = SEntry2_SL(null, -2147483648L);
  val x21175 = SEntry2_SL(null, -2147483648L);
  val x19664 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20692 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20173 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21152 = SEntry3_SSL(null, null, -2147483648L);
  val x18540 = SEntry3_SSL(null, null, -2147483648L);
  val x21230 = SEntry2_SL(null, -2147483648L);
  val x20191 = SEntry3_SSL(null, null, -2147483648L);
  val x21600 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19638 = SEntry3_SSL(null, null, -2147483648L);
  val x19156 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18651 = SEntry3_SSL(null, null, -2147483648L);
  val x20720 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18895 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18532 = SEntry3_SSL(null, null, -2147483648L);
  val x19141 = SEntry3_SSL(null, null, -2147483648L);
  val x21169 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19738 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20935 = SEntry3_SSL(null, null, -2147483648L);
  val x19405 = SEntry3_SSL(null, null, -2147483648L);
  val x18505 = SEntry3_SSL(null, null, -2147483648L);
  val x21155 = SEntry3_SSL(null, null, -2147483648L);
  val x19214 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21146 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20202 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20912 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17977 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20686 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x20915 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17941 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18684 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17909 = SEntry3_SSL(null, null, -2147483648L);
  val x20150 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20741 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18501 = SEntry3_SSL(null, null, -2147483648L);
  val x19164 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18703 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18598 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19661 = SEntry3_SSL(null, null, -2147483648L);
  val x20259 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18842 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18528 = SEntry3_SSL(null, null, -2147483648L);
  val x19507 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17882 = SEntry3_SSL(null, null, -2147483648L);
  val x19258 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17913 = SEntry3_SSL(null, null, -2147483648L);
  val x19955 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x17931 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21617 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21256 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19423 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18630 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18520 = SEntry3_SSL(null, null, -2147483648L);
  val x19655 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20182 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20179 = SEntry3_SSL(null, null, -2147483648L);
  val x18550 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18663 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19483 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19804 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18264 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21644 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19673 = SEntry3_SSL(null, null, -2147483648L);
  val x21577 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20289 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21318 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x17921 = SEntry3_SSL(null, null, -2147483648L);
  val x21560 = SEntry3_SSL(null, null, -2147483648L);
  val x19235 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x18040 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20918 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19386 = SEntry3_SSL(null, null, -2147483648L);
  val x21665 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x17998 = SEntry3_SSL(null, null, -2147483648L);
  val x21291 = SEntry2_SL(null, -2147483648L);
  val x18619 = SEntry3_SSL(null, null, -2147483648L);
  val x19635 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19641 = SEntry3_SSL(null, null, -2147483648L);
  val x17878 = SEntry3_SSL(null, null, -2147483648L);
  val x20763 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19137 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19758 = SEntry3_SSL(null, null, -2147483648L);
  val x21610 = SEntry2_SL(null, -2147483648L);
  val x20159 = SEntry3_SSL(null, null, -2147483648L);
  val x19160 = SEntry3_SSL(null, null, -2147483648L);
  val x21729 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18791 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x17905 = SEntry3_SSL(null, null, -2147483648L);
  val x21707 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x18524 = SEntry3_SSL(null, null, -2147483648L);
  val x18497 = SEntry3_SSL(null, null, -2147483648L);
  val x20689 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x19177 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18008 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20153 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20695 = SEntry2_SL(null, -2147483648L);
  val x21772 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21554 = SEntry3_SSL(null, null, -2147483648L);
  val x17901 = SEntry3_SSL(null, null, -2147483648L);
  val x21359 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21027 = SEntry3_SSL(null, null, -2147483648L);
  val x19788 = SEntry3_SSL(null, null, -2147483648L);
  val x20223 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20434 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20947 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21149 = SEntry3_SSL(null, null, -2147483648L);
  val x21700 = SEntry2_SL(null, -2147483648L);
  val x18561 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20992 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19382 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19703 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21172 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20176 = SEntry3_SSL(null, null, -2147483648L);
  val x18079 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x20327 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x21557 = SEntry3_SSL(null, null, -2147483648L);
  val x20921 = SEntry2_SL(null, -2147483648L);
  val x19409 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x20310 = SEntry3_SSL(null, null, -2147483648L);
  val x21297 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19658 = SEntry3_SSL(null, null, -2147483648L);
  val x21580 = SEntry2_SL(null, -2147483648L);
  val x19683 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21551 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x21204 = SEntry2_SL(null, -2147483648L);
  val x18061 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21586 = SEntry3_SSL(null, null, -2147483648L);
  val x21180 = SEntry3_SSL(null, null, -2147483648L);
  val x20156 = SEntry3_SSL(null, null, -2147483648L);
  val x20969 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x20797 = SEntry3_SSL(null, null, -2147483648L);
  val x19461 = SEntry5_SSSSL(null, null, null, null, -2147483648L);
  val x19632 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x21210 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x18029 = SEntry3_SSL(null, null, -2147483648L);
  def onAddMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      val x31 = message_m_c_replyof.==("\\N");
      if(x31) {
        x17878._2_=(message_m_messageid)
        val x40225 = COUNT_mMESSAGE2Idx1.sliceRes(x17878);
        if((x40225.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17878, ({ x33: SEntry3_SSL => {
              x17931._3_=(message_m_creatorid)
              val x40221 = COUNT_mMESSAGE3Idx1.sliceRes(x17931);
              if((x40221.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x17931, ({ x37: SEntry4_SSSL => {
                    x18079._1_=((x37._1))
                    x18079._2_=((x37._2))
                    x18079._3_=(message_m_creatorid)
                    x18079._4_=((x33._1))
                    x18079._5_=(message_m_messageid)
                    x18079._6_=(((x33._3).*((x37._4))))
                    val x18080 = x18079._6;
                    if((x18080.==(0L))) {
                    } else {
                      val x29296 = COUNTIdx0.get(x18079);
                      if((x29296.==(null))) {
                        COUNT.unsafeInsert(x18079)
                      } else {
                        x29296._6 +=(x18080)
                        if(((x29296._6).==(0L))) {
                          COUNT.delete(x29296)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40221)
              }
              ()
            }
          }), x40225)
        }
      } else {
      }
      if(x31) {
        x17882._2_=(message_m_messageid)
        val x40251 = COUNT_mMESSAGE2Idx1.sliceRes(x17882);
        if((x40251.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17882, ({ x62: SEntry3_SSL => {
              x17941._1_=((x62._1))
              x17941._2_=(message_m_messageid)
              x17941._3_=(message_m_creatorid)
              x17941._4_=((x62._3))
              val x17942 = x17941._4;
              if((x17942.==(0L))) {
              } else {
                val x29321 = COUNT_mKNOWS21Idx0.get(x17941);
                if((x29321.==(null))) {
                  COUNT_mKNOWS21.unsafeInsert(x17941)
                } else {
                  x29321._4 +=(x17942)
                  if(((x29321._4).==(0L))) {
                    COUNT_mKNOWS21.delete(x29321)
                  } else {
                  }
                }
              }
            
            }
          }), x40251)
        }
      } else {
      }
      x17886._1_=(message_m_messageid)
      x17886._2_=(message_m_creatorid)
      x17886._3_=((if(x31) 1L else 0L))
      val x17887 = x17886._3;
      if((x17887.==(0L))) {
      } else {
        val x29340 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx0.get(x17886);
        if((x29340.==(null))) {
          COUNT_mKNOWS21_mMESSAGE_TAG1.unsafeInsert(x17886)
        } else {
          x29340._3 +=(x17887)
          if(((x29340._3).==(0L))) {
            COUNT_mKNOWS21_mMESSAGE_TAG1.delete(x29340)
          } else {
          }
        }
      }
      if(x31) {
        x17901._1_=(message_m_messageid)
        val x40293 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17901);
        if((x40293.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17901, ({ x98: SEntry3_SSL => {
              x17977._1_=(message_m_messageid)
              x17977._2_=((x98._2))
              x17977._3_=(message_m_creatorid)
              x17977._4_=((x98._3))
              val x17978 = x17977._4;
              if((x17978.==(0L))) {
              } else {
                val x29365 = COUNT_mKNOWS21_mTAG1Idx0.get(x17977);
                if((x29365.==(null))) {
                  COUNT_mKNOWS21_mTAG1.unsafeInsert(x17977)
                } else {
                  x29365._4 +=(x17978)
                  if(((x29365._4).==(0L))) {
                    COUNT_mKNOWS21_mTAG1.delete(x29365)
                  } else {
                  }
                }
              }
            
            }
          }), x40293)
        }
      } else {
      }
      if(x31) {
        x17905._2_=(message_m_messageid)
        val x40330 = COUNT_mMESSAGE2Idx1.sliceRes(x17905);
        if((x40330.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x17905, ({ x119: SEntry3_SSL => {
              x17998._2_=(message_m_creatorid)
              val x40326 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x17998);
              if((x40326.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x17998, ({ x123: SEntry3_SSL => {
                    x18164._1_=((x119._1))
                    x18164._2_=(message_m_messageid)
                    x18164._3_=((x123._1))
                    x18164._4_=(message_m_creatorid)
                    x18164._5_=(((x119._3).*((x123._3))))
                    val x18165 = x18164._5;
                    if((x18165.==(0L))) {
                    } else {
                      val x29398 = COUNT_mKNOWS12Idx0.get(x18164);
                      if((x29398.==(null))) {
                        COUNT_mKNOWS12.unsafeInsert(x18164)
                      } else {
                        x29398._5 +=(x18165)
                        if(((x29398._5).==(0L))) {
                          COUNT_mKNOWS12.delete(x29398)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40326)
              }
              ()
            }
          }), x40330)
        }
      } else {
      }
      if(x31) {
        x17909._2_=(message_m_creatorid)
        val x40356 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x17909);
        if((x40356.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x17909, ({ x147: SEntry3_SSL => {
              x18008._1_=(message_m_messageid)
              x18008._2_=((x147._1))
              x18008._3_=(message_m_creatorid)
              x18008._4_=((x147._3))
              val x18009 = x18008._4;
              if((x18009.==(0L))) {
              } else {
                val x29424 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x18008);
                if((x29424.==(null))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x18008)
                } else {
                  x29424._4 +=(x18009)
                  if(((x29424._4).==(0L))) {
                    COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x29424)
                  } else {
                  }
                }
              }
            
            }
          }), x40356)
        }
      } else {
      }
      if(x31) {
        x17913._1_=(message_m_messageid)
        val x40393 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17913);
        if((x40393.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17913, ({ x168: SEntry3_SSL => {
              x18029._2_=(message_m_creatorid)
              val x40389 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18029);
              if((x40389.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18029, ({ x172: SEntry3_SSL => {
                    x18213._1_=(message_m_messageid)
                    x18213._2_=((x168._2))
                    x18213._3_=((x172._1))
                    x18213._4_=(message_m_creatorid)
                    x18213._5_=(((x168._3).*((x172._3))))
                    val x18214 = x18213._5;
                    if((x18214.==(0L))) {
                    } else {
                      val x29457 = COUNT_mKNOWS12_mTAG1Idx0.get(x18213);
                      if((x29457.==(null))) {
                        COUNT_mKNOWS12_mTAG1.unsafeInsert(x18213)
                      } else {
                        x29457._5 +=(x18214)
                        if(((x29457._5).==(0L))) {
                          COUNT_mKNOWS12_mTAG1.delete(x29457)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40389)
              }
              ()
            }
          }), x40393)
        }
      } else {
      }
      if(x31) {
        x17917._3_=(message_m_creatorid)
        val x40421 = COUNT_mMESSAGE3Idx1.sliceRes(x17917);
        if((x40421.isEmpty)) {
        } else {
          COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x17917, ({ x196: SEntry4_SSSL => {
              x18040._1_=(message_m_messageid)
              x18040._2_=((x196._1))
              x18040._3_=((x196._2))
              x18040._4_=(message_m_creatorid)
              x18040._5_=((x196._4))
              val x18041 = x18040._5;
              if((x18041.==(0L))) {
              } else {
                val x29486 = COUNT_mMESSAGE_TAG1Idx0.get(x18040);
                if((x29486.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x18040)
                } else {
                  x29486._5 +=(x18041)
                  if(((x29486._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x29486)
                  } else {
                  }
                }
              }
            
            }
          }), x40421)
        }
      } else {
      }
      if(x31) {
        x17921._1_=(message_m_messageid)
        val x40460 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x17921);
        if((x40460.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x17921, ({ x218: SEntry3_SSL => {
              x18061._3_=(message_m_creatorid)
              val x40456 = COUNT_mMESSAGE3Idx1.sliceRes(x18061);
              if((x40456.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18061, ({ x222: SEntry4_SSSL => {
                    x18264._1_=(message_m_messageid)
                    x18264._2_=((x218._2))
                    x18264._3_=((x222._1))
                    x18264._4_=((x222._2))
                    x18264._5_=(message_m_creatorid)
                    x18264._6_=(((x218._3).*((x222._4))))
                    val x18265 = x18264._6;
                    if((x18265.==(0L))) {
                    } else {
                      val x29520 = COUNT_mTAG1Idx0.get(x18264);
                      if((x29520.==(null))) {
                        COUNT_mTAG1.unsafeInsert(x18264)
                      } else {
                        x29520._6 +=(x18265)
                        if(((x29520._6).==(0L))) {
                          COUNT_mTAG1.delete(x29520)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40456)
              }
              ()
            }
          }), x40460)
        }
      } else {
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      val x261 = message_m_c_replyof.==("\\N");
      if(x261) {
        x18497._2_=(message_m_messageid)
        val x40501 = COUNT_mMESSAGE2Idx1.sliceRes(x18497);
        if((x40501.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18497, ({ x263: SEntry3_SSL => {
              x18550._3_=(message_m_creatorid)
              val x40497 = COUNT_mMESSAGE3Idx1.sliceRes(x18550);
              if((x40497.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18550, ({ x267: SEntry4_SSSL => {
                    x18703._1_=((x267._1))
                    x18703._2_=((x267._2))
                    x18703._3_=(message_m_creatorid)
                    x18703._4_=((x263._1))
                    x18703._5_=(message_m_messageid)
                    x18703._6_=(((x263._3).*(((x267._4).unary_-))))
                    val x18704 = x18703._6;
                    if((x18704.==(0L))) {
                    } else {
                      val x29817 = COUNTIdx0.get(x18703);
                      if((x29817.==(null))) {
                        COUNT.unsafeInsert(x18703)
                      } else {
                        x29817._6 +=(x18704)
                        if(((x29817._6).==(0L))) {
                          COUNT.delete(x29817)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40497)
              }
              ()
            }
          }), x40501)
        }
      } else {
      }
      if(x261) {
        x18501._2_=(message_m_messageid)
        val x40528 = COUNT_mMESSAGE2Idx1.sliceRes(x18501);
        if((x40528.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18501, ({ x293: SEntry3_SSL => {
              x18561._1_=((x293._1))
              x18561._2_=(message_m_messageid)
              x18561._3_=(message_m_creatorid)
              x18561._4_=(((x293._3).unary_-))
              val x18562 = x18561._4;
              if((x18562.==(0L))) {
              } else {
                val x29843 = COUNT_mKNOWS21Idx0.get(x18561);
                if((x29843.==(null))) {
                  COUNT_mKNOWS21.unsafeInsert(x18561)
                } else {
                  x29843._4 +=(x18562)
                  if(((x29843._4).==(0L))) {
                    COUNT_mKNOWS21.delete(x29843)
                  } else {
                  }
                }
              }
            
            }
          }), x40528)
        }
      } else {
      }
      if(x261) {
        x18505._1_=(message_m_messageid)
        x18505._2_=(message_m_creatorid)
        x18505._3_=(-1L)
        val x18506 = x18505._3;
        if((x18506.==(0L))) {
        } else {
          val x29862 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx0.get(x18505);
          if((x29862.==(null))) {
            COUNT_mKNOWS21_mMESSAGE_TAG1.unsafeInsert(x18505)
          } else {
            x29862._3 +=(x18506)
            if(((x29862._3).==(0L))) {
              COUNT_mKNOWS21_mMESSAGE_TAG1.delete(x29862)
            } else {
            }
          }
        }
      } else {
      }
      if(x261) {
        x18520._1_=(message_m_messageid)
        val x40571 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18520);
        if((x40571.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18520, ({ x330: SEntry3_SSL => {
              x18598._1_=(message_m_messageid)
              x18598._2_=((x330._2))
              x18598._3_=(message_m_creatorid)
              x18598._4_=(((x330._3).unary_-))
              val x18599 = x18598._4;
              if((x18599.==(0L))) {
              } else {
                val x29888 = COUNT_mKNOWS21_mTAG1Idx0.get(x18598);
                if((x29888.==(null))) {
                  COUNT_mKNOWS21_mTAG1.unsafeInsert(x18598)
                } else {
                  x29888._4 +=(x18599)
                  if(((x29888._4).==(0L))) {
                    COUNT_mKNOWS21_mTAG1.delete(x29888)
                  } else {
                  }
                }
              }
            
            }
          }), x40571)
        }
      } else {
      }
      if(x261) {
        x18524._2_=(message_m_messageid)
        val x40609 = COUNT_mMESSAGE2Idx1.sliceRes(x18524);
        if((x40609.isEmpty)) {
        } else {
          COUNT_mMESSAGE2Idx1.sliceResMapNoUpd(x18524, ({ x352: SEntry3_SSL => {
              x18619._2_=(message_m_creatorid)
              val x40605 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18619);
              if((x40605.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18619, ({ x356: SEntry3_SSL => {
                    x18791._1_=((x352._1))
                    x18791._2_=(message_m_messageid)
                    x18791._3_=((x356._1))
                    x18791._4_=(message_m_creatorid)
                    x18791._5_=(((x352._3).*(((x356._3).unary_-))))
                    val x18792 = x18791._5;
                    if((x18792.==(0L))) {
                    } else {
                      val x29922 = COUNT_mKNOWS12Idx0.get(x18791);
                      if((x29922.==(null))) {
                        COUNT_mKNOWS12.unsafeInsert(x18791)
                      } else {
                        x29922._5 +=(x18792)
                        if(((x29922._5).==(0L))) {
                          COUNT_mKNOWS12.delete(x29922)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40605)
              }
              ()
            }
          }), x40609)
        }
      } else {
      }
      if(x261) {
        x18528._2_=(message_m_creatorid)
        val x40636 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18528);
        if((x40636.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18528, ({ x381: SEntry3_SSL => {
              x18630._1_=(message_m_messageid)
              x18630._2_=((x381._1))
              x18630._3_=(message_m_creatorid)
              x18630._4_=(((x381._3).unary_-))
              val x18631 = x18630._4;
              if((x18631.==(0L))) {
              } else {
                val x29949 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x18630);
                if((x29949.==(null))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x18630)
                } else {
                  x29949._4 +=(x18631)
                  if(((x29949._4).==(0L))) {
                    COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x29949)
                  } else {
                  }
                }
              }
            
            }
          }), x40636)
        }
      } else {
      }
      if(x261) {
        x18532._1_=(message_m_messageid)
        val x40674 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18532);
        if((x40674.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18532, ({ x403: SEntry3_SSL => {
              x18651._2_=(message_m_creatorid)
              val x40670 = COUNT_mKNOWS12_mMESSAGE3Idx1.sliceRes(x18651);
              if((x40670.isEmpty)) {
              } else {
                COUNT_mKNOWS12_mMESSAGE3Idx1.sliceResMapNoUpd(x18651, ({ x407: SEntry3_SSL => {
                    x18842._1_=(message_m_messageid)
                    x18842._2_=((x403._2))
                    x18842._3_=((x407._1))
                    x18842._4_=(message_m_creatorid)
                    x18842._5_=(((x403._3).*(((x407._3).unary_-))))
                    val x18843 = x18842._5;
                    if((x18843.==(0L))) {
                    } else {
                      val x29983 = COUNT_mKNOWS12_mTAG1Idx0.get(x18842);
                      if((x29983.==(null))) {
                        COUNT_mKNOWS12_mTAG1.unsafeInsert(x18842)
                      } else {
                        x29983._5 +=(x18843)
                        if(((x29983._5).==(0L))) {
                          COUNT_mKNOWS12_mTAG1.delete(x29983)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40670)
              }
              ()
            }
          }), x40674)
        }
      } else {
      }
      if(x261) {
        x18536._3_=(message_m_creatorid)
        val x40703 = COUNT_mMESSAGE3Idx1.sliceRes(x18536);
        if((x40703.isEmpty)) {
        } else {
          COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18536, ({ x432: SEntry4_SSSL => {
              x18663._1_=(message_m_messageid)
              x18663._2_=((x432._1))
              x18663._3_=((x432._2))
              x18663._4_=(message_m_creatorid)
              x18663._5_=(((x432._4).unary_-))
              val x18664 = x18663._5;
              if((x18664.==(0L))) {
              } else {
                val x30013 = COUNT_mMESSAGE_TAG1Idx0.get(x18663);
                if((x30013.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x18663)
                } else {
                  x30013._5 +=(x18664)
                  if(((x30013._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30013)
                  } else {
                  }
                }
              }
            
            }
          }), x40703)
        }
      } else {
      }
      if(x261) {
        x18540._1_=(message_m_messageid)
        val x40743 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceRes(x18540);
        if((x40743.isEmpty)) {
        } else {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx2.sliceResMapNoUpd(x18540, ({ x455: SEntry3_SSL => {
              x18684._3_=(message_m_creatorid)
              val x40739 = COUNT_mMESSAGE3Idx1.sliceRes(x18684);
              if((x40739.isEmpty)) {
              } else {
                COUNT_mMESSAGE3Idx1.sliceResMapNoUpd(x18684, ({ x459: SEntry4_SSSL => {
                    x18895._1_=(message_m_messageid)
                    x18895._2_=((x455._2))
                    x18895._3_=((x459._1))
                    x18895._4_=((x459._2))
                    x18895._5_=(message_m_creatorid)
                    x18895._6_=(((x455._3).*(((x459._4).unary_-))))
                    val x18896 = x18895._6;
                    if((x18896.==(0L))) {
                    } else {
                      val x30048 = COUNT_mTAG1Idx0.get(x18895);
                      if((x30048.==(null))) {
                        COUNT_mTAG1.unsafeInsert(x18895)
                      } else {
                        x30048._6 +=(x18896)
                        if(((x30048._6).==(0L))) {
                          COUNT_mTAG1.delete(x30048)
                        } else {
                        }
                      }
                    }
                  
                  }
                }), x40739)
              }
              ()
            }
          }), x40743)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x491 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x491) {
        x19137._3_=(knows1_k_personid2)
        val x40775 = COUNT_mKNOWS12Idx1.sliceRes(x19137);
        if((x40775.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x19137, ({ x493: SEntry5_SSSSL => {
              x19177._1_=(knows1_k_personid1)
              x19177._2_=(knows1_k_personid2)
              x19177._3_=((x493._4))
              x19177._4_=((x493._1))
              x19177._5_=((x493._2))
              x19177._6_=((x493._5))
              val x19178 = x19177._6;
              if((x19178.==(0L))) {
              } else {
                val x30348 = COUNTIdx0.get(x19177);
                if((x30348.==(null))) {
                  COUNT.unsafeInsert(x19177)
                } else {
                  x30348._6 +=(x19178)
                  if(((x30348._6).==(0L))) {
                    COUNT.delete(x30348)
                  } else {
                  }
                }
              }
            
            }
          }), x40775)
        }
      } else {
      }
      x19141._1_=(knows1_k_personid1)
      x19141._2_=(knows1_k_personid2)
      x19141._3_=((if(x491) 1L else 0L))
      val x19142 = x19141._3;
      if((x19142.==(0L))) {
      } else {
        val x30366 = COUNT_mKNOWS22Idx0.get(x19141);
        if((x30366.==(null))) {
          COUNT_mKNOWS22.unsafeInsert(x19141)
        } else {
          x30366._3 +=(x19142)
          if(((x30366._3).==(0L))) {
            COUNT_mKNOWS22.delete(x30366)
          } else {
          }
        }
      }
      if(x491) {
        x19156._2_=(knows1_k_personid2)
        val x40819 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceRes(x19156);
        if((x40819.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19156, ({ x531: SEntry4_SSSL => {
              x19214._1_=((x531._1))
              x19214._2_=(knows1_k_personid1)
              x19214._3_=(knows1_k_personid2)
              x19214._4_=((x531._3))
              x19214._5_=((x531._4))
              val x19215 = x19214._5;
              if((x19215.==(0L))) {
              } else {
                val x30392 = COUNT_mMESSAGE_TAG1Idx0.get(x19214);
                if((x30392.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x19214)
                } else {
                  x30392._5 +=(x19215)
                  if(((x30392._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30392)
                  } else {
                  }
                }
              }
            
            }
          }), x40819)
        }
      } else {
      }
      if(x491) {
        x19160._1_=(knows1_k_personid2)
        val x40845 = COUNT_mKNOWS12_mMESSAGE3Idx2.sliceRes(x19160);
        if((x40845.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx2.sliceResMapNoUpd(x19160, ({ x553: SEntry3_SSL => {
              x19235._1_=(knows1_k_personid1)
              x19235._2_=(knows1_k_personid2)
              x19235._3_=((x553._2))
              x19235._4_=((x553._3))
              val x19236 = x19235._4;
              if((x19236.==(0L))) {
              } else {
                val x30417 = COUNT_mMESSAGE3Idx0.get(x19235);
                if((x30417.==(null))) {
                  COUNT_mMESSAGE3.unsafeInsert(x19235)
                } else {
                  x30417._4 +=(x19236)
                  if(((x30417._4).==(0L))) {
                    COUNT_mMESSAGE3.delete(x30417)
                  } else {
                  }
                }
              }
            
            }
          }), x40845)
        }
      } else {
      }
      if(x491) {
        x19164._3_=(knows1_k_personid2)
        val x40875 = COUNT_mKNOWS12_mTAG1Idx2.sliceRes(x19164);
        if((x40875.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mTAG1Idx2.sliceResMapNoUpd(x19164, ({ x574: SEntry5_SSSSL => {
              x19258._1_=((x574._1))
              x19258._2_=((x574._2))
              x19258._3_=(knows1_k_personid1)
              x19258._4_=(knows1_k_personid2)
              x19258._5_=((x574._4))
              x19258._6_=((x574._5))
              val x19259 = x19258._6;
              if((x19259.==(0L))) {
              } else {
                val x30446 = COUNT_mTAG1Idx0.get(x19258);
                if((x30446.==(null))) {
                  COUNT_mTAG1.unsafeInsert(x19258)
                } else {
                  x30446._6 +=(x19259)
                  if(((x30446._6).==(0L))) {
                    COUNT_mTAG1.delete(x30446)
                  } else {
                  }
                }
              }
            
            }
          }), x40875)
        }
      } else {
      }
    
    }
  
  }
  def onDelKNOWS1(knows1_k_op_time:String, knows1_k_op:String, knows1_k_explicitlydeleted:String, knows1_k_personid1:String, knows1_k_personid2:String) {
    {
      val x602 = (Upreg_match(preg1, knows1_k_personid1)).==(1L);
      if(x602) {
        x19382._3_=(knows1_k_personid2)
        val x40908 = COUNT_mKNOWS12Idx1.sliceRes(x19382);
        if((x40908.isEmpty)) {
        } else {
          COUNT_mKNOWS12Idx1.sliceResMapNoUpd(x19382, ({ x604: SEntry5_SSSSL => {
              x19423._1_=(knows1_k_personid1)
              x19423._2_=(knows1_k_personid2)
              x19423._3_=((x604._4))
              x19423._4_=((x604._1))
              x19423._5_=((x604._2))
              x19423._6_=(((x604._5).unary_-))
              val x19424 = x19423._6;
              if((x19424.==(0L))) {
              } else {
                val x30607 = COUNTIdx0.get(x19423);
                if((x30607.==(null))) {
                  COUNT.unsafeInsert(x19423)
                } else {
                  x30607._6 +=(x19424)
                  if(((x30607._6).==(0L))) {
                    COUNT.delete(x30607)
                  } else {
                  }
                }
              }
            
            }
          }), x40908)
        }
      } else {
      }
      if(x602) {
        x19386._1_=(knows1_k_personid1)
        x19386._2_=(knows1_k_personid2)
        x19386._3_=(-1L)
        val x19387 = x19386._3;
        if((x19387.==(0L))) {
        } else {
          val x30625 = COUNT_mKNOWS22Idx0.get(x19386);
          if((x30625.==(null))) {
            COUNT_mKNOWS22.unsafeInsert(x19386)
          } else {
            x30625._3 +=(x19387)
            if(((x30625._3).==(0L))) {
              COUNT_mKNOWS22.delete(x30625)
            } else {
            }
          }
        }
      } else {
      }
      if(x602) {
        x19401._2_=(knows1_k_personid2)
        val x40953 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceRes(x19401);
        if((x40953.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19401, ({ x643: SEntry4_SSSL => {
              x19461._1_=((x643._1))
              x19461._2_=(knows1_k_personid1)
              x19461._3_=(knows1_k_personid2)
              x19461._4_=((x643._3))
              x19461._5_=(((x643._4).unary_-))
              val x19462 = x19461._5;
              if((x19462.==(0L))) {
              } else {
                val x30652 = COUNT_mMESSAGE_TAG1Idx0.get(x19461);
                if((x30652.==(null))) {
                  COUNT_mMESSAGE_TAG1.unsafeInsert(x19461)
                } else {
                  x30652._5 +=(x19462)
                  if(((x30652._5).==(0L))) {
                    COUNT_mMESSAGE_TAG1.delete(x30652)
                  } else {
                  }
                }
              }
            
            }
          }), x40953)
        }
      } else {
      }
      if(x602) {
        x19405._1_=(knows1_k_personid2)
        val x40980 = COUNT_mKNOWS12_mMESSAGE3Idx2.sliceRes(x19405);
        if((x40980.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mMESSAGE3Idx2.sliceResMapNoUpd(x19405, ({ x666: SEntry3_SSL => {
              x19483._1_=(knows1_k_personid1)
              x19483._2_=(knows1_k_personid2)
              x19483._3_=((x666._2))
              x19483._4_=(((x666._3).unary_-))
              val x19484 = x19483._4;
              if((x19484.==(0L))) {
              } else {
                val x30678 = COUNT_mMESSAGE3Idx0.get(x19483);
                if((x30678.==(null))) {
                  COUNT_mMESSAGE3.unsafeInsert(x19483)
                } else {
                  x30678._4 +=(x19484)
                  if(((x30678._4).==(0L))) {
                    COUNT_mMESSAGE3.delete(x30678)
                  } else {
                  }
                }
              }
            
            }
          }), x40980)
        }
      } else {
      }
      if(x602) {
        x19409._3_=(knows1_k_personid2)
        val x41011 = COUNT_mKNOWS12_mTAG1Idx2.sliceRes(x19409);
        if((x41011.isEmpty)) {
        } else {
          COUNT_mKNOWS12_mTAG1Idx2.sliceResMapNoUpd(x19409, ({ x688: SEntry5_SSSSL => {
              x19507._1_=((x688._1))
              x19507._2_=((x688._2))
              x19507._3_=(knows1_k_personid1)
              x19507._4_=(knows1_k_personid2)
              x19507._5_=((x688._4))
              x19507._6_=(((x688._5).unary_-))
              val x19508 = x19507._6;
              if((x19508.==(0L))) {
              } else {
                val x30708 = COUNT_mTAG1Idx0.get(x19507);
                if((x30708.==(null))) {
                  COUNT_mTAG1.unsafeInsert(x19507)
                } else {
                  x30708._6 +=(x19508)
                  if(((x30708._6).==(0L))) {
                    COUNT_mTAG1.delete(x30708)
                  } else {
                  }
                }
              }
            
            }
          }), x41011)
        }
      } else {
      }
    
    }
  
  }
  def onAddKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x19632._3_=(knows2_k_personid2)
      val x41049 = COUNT_mKNOWS21Idx1.sliceRes(x19632);
      if((x41049.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x19632, ({ x717: SEntry4_SSSL => {
            x19673._2_=(knows2_k_personid1)
            val x41045 = COUNT_mKNOWS22Idx1.sliceRes(x19673);
            if((x41045.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19673, ({ x722: SEntry3_SSL => {
                  x19804._1_=((x722._1))
                  x19804._2_=(knows2_k_personid1)
                  x19804._3_=(knows2_k_personid2)
                  x19804._4_=((x717._1))
                  x19804._5_=((x717._2))
                  x19804._6_=(((x717._4).*((x722._3))))
                  val x19805 = x19804._6;
                  if((x19805.==(0L))) {
                  } else {
                    val x30874 = COUNTIdx0.get(x19804);
                    if((x30874.==(null))) {
                      COUNT.unsafeInsert(x19804)
                    } else {
                      x30874._6 +=(x19805)
                      if(((x30874._6).==(0L))) {
                        COUNT.delete(x30874)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41045)
            }
            ()
          }
        }), x41049)
      }
      x19635._3_=(knows2_k_personid2)
      val x41076 = COUNT_mKNOWS21Idx1.sliceRes(x19635);
      if((x41076.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x19635, ({ x745: SEntry4_SSSL => {
            x19683._1_=((x745._1))
            x19683._2_=((x745._2))
            x19683._3_=(knows2_k_personid1)
            x19683._4_=(knows2_k_personid2)
            x19683._5_=((x745._4))
            val x19684 = x19683._5;
            if((x19684.==(0L))) {
            } else {
              val x30900 = COUNT_mKNOWS12Idx0.get(x19683);
              if((x30900.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x19683)
              } else {
                x30900._5 +=(x19684)
                if(((x30900._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x30900)
                } else {
                }
              }
            }
          
          }
        }), x41076)
      }
      x19638._2_=(knows2_k_personid2)
      val x41101 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x19638);
      if((x41101.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19638, ({ x766: SEntry3_SSL => {
            x19703._1_=((x766._1))
            x19703._2_=(knows2_k_personid1)
            x19703._3_=(knows2_k_personid2)
            x19703._4_=((x766._3))
            val x19704 = x19703._4;
            if((x19704.==(0L))) {
            } else {
              val x30924 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x19703);
              if((x30924.==(null))) {
                COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x19703)
              } else {
                x30924._4 +=(x19704)
                if(((x30924._4).==(0L))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x30924)
                } else {
                }
              }
            }
          
          }
        }), x41101)
      }
      x19641._1_=(knows2_k_personid1)
      x19641._2_=(knows2_k_personid2)
      x19641._3_=(1L)
      val x19642 = x19641._3;
      if((x19642.==(0L))) {
      } else {
        val x30943 = COUNT_mKNOWS12_mMESSAGE3Idx0.get(x19641);
        if((x30943.==(null))) {
          COUNT_mKNOWS12_mMESSAGE3.unsafeInsert(x19641)
        } else {
          x30943._3 +=(x19642)
          if(((x30943._3).==(0L))) {
            COUNT_mKNOWS12_mMESSAGE3.delete(x30943)
          } else {
          }
        }
      }
      x19655._3_=(knows2_k_personid2)
      val x41143 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x19655);
      if((x41143.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x19655, ({ x800: SEntry4_SSSL => {
            x19738._1_=((x800._1))
            x19738._2_=((x800._2))
            x19738._3_=(knows2_k_personid1)
            x19738._4_=(knows2_k_personid2)
            x19738._5_=((x800._4))
            val x19739 = x19738._5;
            if((x19739.==(0L))) {
            } else {
              val x30969 = COUNT_mKNOWS12_mTAG1Idx0.get(x19738);
              if((x30969.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x19738)
              } else {
                x30969._5 +=(x19739)
                if(((x30969._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x30969)
                } else {
                }
              }
            }
          
          }
        }), x41143)
      }
      x19658._2_=(knows2_k_personid2)
      val x41179 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x19658);
      if((x41179.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x19658, ({ x821: SEntry3_SSL => {
            x19758._2_=(knows2_k_personid1)
            val x41175 = COUNT_mKNOWS22Idx1.sliceRes(x19758);
            if((x41175.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19758, ({ x825: SEntry3_SSL => {
                  x19907._1_=((x821._1))
                  x19907._2_=((x825._1))
                  x19907._3_=(knows2_k_personid1)
                  x19907._4_=(knows2_k_personid2)
                  x19907._5_=(((x821._3).*((x825._3))))
                  val x19908 = x19907._5;
                  if((x19908.==(0L))) {
                  } else {
                    val x31001 = COUNT_mMESSAGE_TAG1Idx0.get(x19907);
                    if((x31001.==(null))) {
                      COUNT_mMESSAGE_TAG1.unsafeInsert(x19907)
                    } else {
                      x31001._5 +=(x19908)
                      if(((x31001._5).==(0L))) {
                        COUNT_mMESSAGE_TAG1.delete(x31001)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41175)
            }
            ()
          }
        }), x41179)
      }
      x19661._2_=(knows2_k_personid1)
      val x41204 = COUNT_mKNOWS22Idx1.sliceRes(x19661);
      if((x41204.isEmpty)) {
      } else {
        COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19661, ({ x848: SEntry3_SSL => {
            x19767._1_=((x848._1))
            x19767._2_=(knows2_k_personid1)
            x19767._3_=(knows2_k_personid2)
            x19767._4_=((x848._3))
            val x19768 = x19767._4;
            if((x19768.==(0L))) {
            } else {
              val x31026 = COUNT_mMESSAGE3Idx0.get(x19767);
              if((x31026.==(null))) {
                COUNT_mMESSAGE3.unsafeInsert(x19767)
              } else {
                x31026._4 +=(x19768)
                if(((x31026._4).==(0L))) {
                  COUNT_mMESSAGE3.delete(x31026)
                } else {
                }
              }
            }
          
          }
        }), x41204)
      }
      x19664._3_=(knows2_k_personid2)
      val x41242 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x19664);
      if((x41242.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x19664, ({ x868: SEntry4_SSSL => {
            x19788._2_=(knows2_k_personid1)
            val x41238 = COUNT_mKNOWS22Idx1.sliceRes(x19788);
            if((x41238.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x19788, ({ x873: SEntry3_SSL => {
                  x19955._1_=((x868._1))
                  x19955._2_=((x868._2))
                  x19955._3_=((x873._1))
                  x19955._4_=(knows2_k_personid1)
                  x19955._5_=(knows2_k_personid2)
                  x19955._6_=(((x868._4).*((x873._3))))
                  val x19956 = x19955._6;
                  if((x19956.==(0L))) {
                  } else {
                    val x31059 = COUNT_mTAG1Idx0.get(x19955);
                    if((x31059.==(null))) {
                      COUNT_mTAG1.unsafeInsert(x19955)
                    } else {
                      x31059._6 +=(x19956)
                      if(((x31059._6).==(0L))) {
                        COUNT_mTAG1.delete(x31059)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41238)
            }
            ()
          }
        }), x41242)
      }
    
    }
  
  }
  def onDelKNOWS2(knows2_k_op_time:String, knows2_k_op:String, knows2_k_explicitlydeleted:String, knows2_k_personid1:String, knows2_k_personid2:String) {
    {
      x20150._3_=(knows2_k_personid2)
      val x41281 = COUNT_mKNOWS21Idx1.sliceRes(x20150);
      if((x41281.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x20150, ({ x901: SEntry4_SSSL => {
            x20191._2_=(knows2_k_personid1)
            val x41277 = COUNT_mKNOWS22Idx1.sliceRes(x20191);
            if((x41277.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20191, ({ x906: SEntry3_SSL => {
                  x20327._1_=((x906._1))
                  x20327._2_=(knows2_k_personid1)
                  x20327._3_=(knows2_k_personid2)
                  x20327._4_=((x901._1))
                  x20327._5_=((x901._2))
                  x20327._6_=(((x901._4).*(((x906._3).unary_-))))
                  val x20328 = x20327._6;
                  if((x20328.==(0L))) {
                  } else {
                    val x31313 = COUNTIdx0.get(x20327);
                    if((x31313.==(null))) {
                      COUNT.unsafeInsert(x20327)
                    } else {
                      x31313._6 +=(x20328)
                      if(((x31313._6).==(0L))) {
                        COUNT.delete(x31313)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41277)
            }
            ()
          }
        }), x41281)
      }
      x20153._3_=(knows2_k_personid2)
      val x41309 = COUNT_mKNOWS21Idx1.sliceRes(x20153);
      if((x41309.isEmpty)) {
      } else {
        COUNT_mKNOWS21Idx1.sliceResMapNoUpd(x20153, ({ x930: SEntry4_SSSL => {
            x20202._1_=((x930._1))
            x20202._2_=((x930._2))
            x20202._3_=(knows2_k_personid1)
            x20202._4_=(knows2_k_personid2)
            x20202._5_=(((x930._4).unary_-))
            val x20203 = x20202._5;
            if((x20203.==(0L))) {
            } else {
              val x31340 = COUNT_mKNOWS12Idx0.get(x20202);
              if((x31340.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20202)
              } else {
                x31340._5 +=(x20203)
                if(((x31340._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x31340)
                } else {
                }
              }
            }
          
          }
        }), x41309)
      }
      x20156._2_=(knows2_k_personid2)
      val x41335 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x20156);
      if((x41335.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x20156, ({ x952: SEntry3_SSL => {
            x20223._1_=((x952._1))
            x20223._2_=(knows2_k_personid1)
            x20223._3_=(knows2_k_personid2)
            x20223._4_=(((x952._3).unary_-))
            val x20224 = x20223._4;
            if((x20224.==(0L))) {
            } else {
              val x31365 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx0.get(x20223);
              if((x31365.==(null))) {
                COUNT_mKNOWS12_mMESSAGE_TAG1.unsafeInsert(x20223)
              } else {
                x31365._4 +=(x20224)
                if(((x31365._4).==(0L))) {
                  COUNT_mKNOWS12_mMESSAGE_TAG1.delete(x31365)
                } else {
                }
              }
            }
          
          }
        }), x41335)
      }
      x20159._1_=(knows2_k_personid1)
      x20159._2_=(knows2_k_personid2)
      x20159._3_=(-1L)
      val x20160 = x20159._3;
      if((x20160.==(0L))) {
      } else {
        val x31384 = COUNT_mKNOWS12_mMESSAGE3Idx0.get(x20159);
        if((x31384.==(null))) {
          COUNT_mKNOWS12_mMESSAGE3.unsafeInsert(x20159)
        } else {
          x31384._3 +=(x20160)
          if(((x31384._3).==(0L))) {
            COUNT_mKNOWS12_mMESSAGE3.delete(x31384)
          } else {
          }
        }
      }
      x20173._3_=(knows2_k_personid2)
      val x41378 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x20173);
      if((x41378.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x20173, ({ x987: SEntry4_SSSL => {
            x20259._1_=((x987._1))
            x20259._2_=((x987._2))
            x20259._3_=(knows2_k_personid1)
            x20259._4_=(knows2_k_personid2)
            x20259._5_=(((x987._4).unary_-))
            val x20260 = x20259._5;
            if((x20260.==(0L))) {
            } else {
              val x31411 = COUNT_mKNOWS12_mTAG1Idx0.get(x20259);
              if((x31411.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x20259)
              } else {
                x31411._5 +=(x20260)
                if(((x31411._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x31411)
                } else {
                }
              }
            }
          
          }
        }), x41378)
      }
      x20176._2_=(knows2_k_personid2)
      val x41415 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceRes(x20176);
      if((x41415.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x20176, ({ x1009: SEntry3_SSL => {
            x20279._2_=(knows2_k_personid1)
            val x41411 = COUNT_mKNOWS22Idx1.sliceRes(x20279);
            if((x41411.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20279, ({ x1013: SEntry3_SSL => {
                  x20434._1_=((x1009._1))
                  x20434._2_=((x1013._1))
                  x20434._3_=(knows2_k_personid1)
                  x20434._4_=(knows2_k_personid2)
                  x20434._5_=(((x1009._3).*(((x1013._3).unary_-))))
                  val x20435 = x20434._5;
                  if((x20435.==(0L))) {
                  } else {
                    val x31444 = COUNT_mMESSAGE_TAG1Idx0.get(x20434);
                    if((x31444.==(null))) {
                      COUNT_mMESSAGE_TAG1.unsafeInsert(x20434)
                    } else {
                      x31444._5 +=(x20435)
                      if(((x31444._5).==(0L))) {
                        COUNT_mMESSAGE_TAG1.delete(x31444)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41411)
            }
            ()
          }
        }), x41415)
      }
      x20179._2_=(knows2_k_personid1)
      val x41441 = COUNT_mKNOWS22Idx1.sliceRes(x20179);
      if((x41441.isEmpty)) {
      } else {
        COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20179, ({ x1037: SEntry3_SSL => {
            x20289._1_=((x1037._1))
            x20289._2_=(knows2_k_personid1)
            x20289._3_=(knows2_k_personid2)
            x20289._4_=(((x1037._3).unary_-))
            val x20290 = x20289._4;
            if((x20290.==(0L))) {
            } else {
              val x31470 = COUNT_mMESSAGE3Idx0.get(x20289);
              if((x31470.==(null))) {
                COUNT_mMESSAGE3.unsafeInsert(x20289)
              } else {
                x31470._4 +=(x20290)
                if(((x31470._4).==(0L))) {
                  COUNT_mMESSAGE3.delete(x31470)
                } else {
                }
              }
            }
          
          }
        }), x41441)
      }
      x20182._3_=(knows2_k_personid2)
      val x41480 = COUNT_mKNOWS21_mTAG1Idx2.sliceRes(x20182);
      if((x41480.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx2.sliceResMapNoUpd(x20182, ({ x1058: SEntry4_SSSL => {
            x20310._2_=(knows2_k_personid1)
            val x41476 = COUNT_mKNOWS22Idx1.sliceRes(x20310);
            if((x41476.isEmpty)) {
            } else {
              COUNT_mKNOWS22Idx1.sliceResMapNoUpd(x20310, ({ x1063: SEntry3_SSL => {
                  x20484._1_=((x1058._1))
                  x20484._2_=((x1058._2))
                  x20484._3_=((x1063._1))
                  x20484._4_=(knows2_k_personid1)
                  x20484._5_=(knows2_k_personid2)
                  x20484._6_=(((x1058._4).*(((x1063._3).unary_-))))
                  val x20485 = x20484._6;
                  if((x20485.==(0L))) {
                  } else {
                    val x31504 = COUNT_mTAG1Idx0.get(x20484);
                    if((x31504.==(null))) {
                      COUNT_mTAG1.unsafeInsert(x20484)
                    } else {
                      x31504._6 +=(x20485)
                      if(((x31504._6).==(0L))) {
                        COUNT_mTAG1.delete(x31504)
                      } else {
                      }
                    }
                  }
                
                }
              }), x41476)
            }
            ()
          }
        }), x41480)
      }
    
    }
  
  }
  def onAddTAG(tag_t_tagid:String, tag_t_name:String, tag_t_url:String, tag_t_tagclassid:String) {
    {
      x20686._2_=(tag_t_tagid)
      val x41510 = COUNT_mTAG1Idx1.sliceRes(x20686);
      if((x41510.isEmpty)) {
      } else {
        COUNT_mTAG1Idx1.sliceResMapNoUpd(x20686, ({ x1091: SEntry6_SSSSSL => {
            x20720._1_=((x1091._3))
            x20720._2_=((x1091._4))
            x20720._3_=((x1091._5))
            x20720._4_=(tag_t_tagid)
            x20720._5_=((x1091._1))
            x20720._6_=((x1091._6))
            val x20721 = x20720._6;
            if((x20721.==(0L))) {
            } else {
              val x31760 = COUNTIdx0.get(x20720);
              if((x31760.==(null))) {
                COUNT.unsafeInsert(x20720)
              } else {
                x31760._6 +=(x20721)
                if(((x31760._6).==(0L))) {
                  COUNT.delete(x31760)
                } else {
                }
              }
            }
          
          }
        }), x41510)
      }
      x20689._2_=(tag_t_tagid)
      val x41536 = COUNT_mKNOWS21_mTAG1Idx1.sliceRes(x20689);
      if((x41536.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx1.sliceResMapNoUpd(x20689, ({ x1114: SEntry4_SSSL => {
            x20741._1_=(tag_t_tagid)
            x20741._2_=((x1114._1))
            x20741._3_=((x1114._3))
            x20741._4_=((x1114._4))
            val x20742 = x20741._4;
            if((x20742.==(0L))) {
            } else {
              val x31784 = COUNT_mKNOWS21Idx0.get(x20741);
              if((x31784.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x20741)
              } else {
                x31784._4 +=(x20742)
                if(((x31784._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x31784)
                } else {
                }
              }
            }
          
          }
        }), x41536)
      }
      x20692._2_=(tag_t_tagid)
      val x41564 = COUNT_mKNOWS12_mTAG1Idx1.sliceRes(x20692);
      if((x41564.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mTAG1Idx1.sliceResMapNoUpd(x20692, ({ x1135: SEntry5_SSSSL => {
            x20763._1_=(tag_t_tagid)
            x20763._2_=((x1135._1))
            x20763._3_=((x1135._3))
            x20763._4_=((x1135._4))
            x20763._5_=((x1135._5))
            val x20764 = x20763._5;
            if((x20764.==(0L))) {
            } else {
              val x31811 = COUNT_mKNOWS12Idx0.get(x20763);
              if((x31811.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20763)
              } else {
                x31811._5 +=(x20764)
                if(((x31811._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x31811)
                } else {
                }
              }
            }
          
          }
        }), x41564)
      }
      x20695._1_=(tag_t_tagid)
      x20695._2_=(1L)
      val x20696 = x20695._2;
      if((x20696.==(0L))) {
      } else {
        val x31828 = COUNT_mMESSAGE_TAG2Idx0.get(x20695);
        if((x31828.==(null))) {
          COUNT_mMESSAGE_TAG2.unsafeInsert(x20695)
        } else {
          x31828._2 +=(x20696)
          if(((x31828._2).==(0L))) {
            COUNT_mMESSAGE_TAG2.delete(x31828)
          } else {
          }
        }
      }
      x20709._2_=(tag_t_tagid)
      val x41602 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceRes(x20709);
      if((x41602.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceResMapNoUpd(x20709, ({ x1171: SEntry3_SSL => {
            x20797._1_=(tag_t_tagid)
            x20797._2_=((x1171._1))
            x20797._3_=((x1171._3))
            val x20798 = x20797._3;
            if((x20798.==(0L))) {
            } else {
              val x31849 = COUNT_mMESSAGE2Idx0.get(x20797);
              if((x31849.==(null))) {
                COUNT_mMESSAGE2.unsafeInsert(x20797)
              } else {
                x31849._3 +=(x20798)
                if(((x31849._3).==(0L))) {
                  COUNT_mMESSAGE2.delete(x31849)
                } else {
                }
              }
            }
          
          }
        }), x41602)
      }
    
    }
  
  }
  def onDelTAG(tag_t_tagid:String, tag_t_name:String, tag_t_url:String, tag_t_tagclassid:String) {
    {
      x20912._2_=(tag_t_tagid)
      val x41633 = COUNT_mTAG1Idx1.sliceRes(x20912);
      if((x41633.isEmpty)) {
      } else {
        COUNT_mTAG1Idx1.sliceResMapNoUpd(x20912, ({ x1195: SEntry6_SSSSSL => {
            x20947._1_=((x1195._3))
            x20947._2_=((x1195._4))
            x20947._3_=((x1195._5))
            x20947._4_=(tag_t_tagid)
            x20947._5_=((x1195._1))
            x20947._6_=(((x1195._6).unary_-))
            val x20948 = x20947._6;
            if((x20948.==(0L))) {
            } else {
              val x31997 = COUNTIdx0.get(x20947);
              if((x31997.==(null))) {
                COUNT.unsafeInsert(x20947)
              } else {
                x31997._6 +=(x20948)
                if(((x31997._6).==(0L))) {
                  COUNT.delete(x31997)
                } else {
                }
              }
            }
          
          }
        }), x41633)
      }
      x20915._2_=(tag_t_tagid)
      val x41660 = COUNT_mKNOWS21_mTAG1Idx1.sliceRes(x20915);
      if((x41660.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1Idx1.sliceResMapNoUpd(x20915, ({ x1219: SEntry4_SSSL => {
            x20969._1_=(tag_t_tagid)
            x20969._2_=((x1219._1))
            x20969._3_=((x1219._3))
            x20969._4_=(((x1219._4).unary_-))
            val x20970 = x20969._4;
            if((x20970.==(0L))) {
            } else {
              val x32022 = COUNT_mKNOWS21Idx0.get(x20969);
              if((x32022.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x20969)
              } else {
                x32022._4 +=(x20970)
                if(((x32022._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32022)
                } else {
                }
              }
            }
          
          }
        }), x41660)
      }
      x20918._2_=(tag_t_tagid)
      val x41689 = COUNT_mKNOWS12_mTAG1Idx1.sliceRes(x20918);
      if((x41689.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mTAG1Idx1.sliceResMapNoUpd(x20918, ({ x1241: SEntry5_SSSSL => {
            x20992._1_=(tag_t_tagid)
            x20992._2_=((x1241._1))
            x20992._3_=((x1241._3))
            x20992._4_=((x1241._4))
            x20992._5_=(((x1241._5).unary_-))
            val x20993 = x20992._5;
            if((x20993.==(0L))) {
            } else {
              val x32050 = COUNT_mKNOWS12Idx0.get(x20992);
              if((x32050.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x20992)
              } else {
                x32050._5 +=(x20993)
                if(((x32050._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32050)
                } else {
                }
              }
            }
          
          }
        }), x41689)
      }
      x20921._1_=(tag_t_tagid)
      x20921._2_=(-1L)
      val x20922 = x20921._2;
      if((x20922.==(0L))) {
      } else {
        val x32067 = COUNT_mMESSAGE_TAG2Idx0.get(x20921);
        if((x32067.==(null))) {
          COUNT_mMESSAGE_TAG2.unsafeInsert(x20921)
        } else {
          x32067._2 +=(x20922)
          if(((x32067._2).==(0L))) {
            COUNT_mMESSAGE_TAG2.delete(x32067)
          } else {
          }
        }
      }
      x20935._2_=(tag_t_tagid)
      val x41728 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceRes(x20935);
      if((x41728.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx1.sliceResMapNoUpd(x20935, ({ x1278: SEntry3_SSL => {
            x21027._1_=(tag_t_tagid)
            x21027._2_=((x1278._1))
            x21027._3_=(((x1278._3).unary_-))
            val x21028 = x21027._3;
            if((x21028.==(0L))) {
            } else {
              val x32089 = COUNT_mMESSAGE2Idx0.get(x21027);
              if((x32089.==(null))) {
                COUNT_mMESSAGE2.unsafeInsert(x21027)
              } else {
                x32089._3 +=(x21028)
                if(((x32089._3).==(0L))) {
                  COUNT_mMESSAGE2.delete(x32089)
                } else {
                }
              }
            }
          
          }
        }), x41728)
      }
    
    }
  
  }
  def onAddMESSAGE_TAG(message_tag_k_op_time:String, message_tag_k_op:String, message_tag_mt_messageid:String, message_tag_mt_tagid:String) {
    {
      x21146._1_=(message_tag_mt_messageid)
      val x41763 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21146);
      if((x41763.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21146, ({ x1303: SEntry5_SSSSL => {
            x21204._1_=(message_tag_mt_tagid)
            val x32231 = COUNT_mMESSAGE_TAG2Idx0.get(x21204);
            val x1312 = if((x32231.==(null))) {
            0L
            } else {
            (x32231._2)
            };
            x21210._1_=((x1303._2))
            x21210._2_=((x1303._3))
            x21210._3_=((x1303._4))
            x21210._4_=(message_tag_mt_tagid)
            x21210._5_=(message_tag_mt_messageid)
            x21210._6_=(((x1303._5).*(x1312)))
            val x21211 = x21210._6;
            if((x21211.==(0L))) {
            } else {
              val x32245 = COUNTIdx0.get(x21210);
              if((x32245.==(null))) {
                COUNT.unsafeInsert(x21210)
              } else {
                x32245._6 +=(x21211)
                if(((x32245._6).==(0L))) {
                  COUNT.delete(x32245)
                } else {
                }
              }
            }
          
          }
        }), x41763)
      }
      x21149._1_=(message_tag_mt_messageid)
      val x41794 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21149);
      if((x41794.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21149, ({ x1331: SEntry3_SSL => {
            x21230._1_=(message_tag_mt_tagid)
            val x32262 = COUNT_mMESSAGE_TAG2Idx0.get(x21230);
            val x1338 = if((x32262.==(null))) {
            0L
            } else {
            (x32262._2)
            };
            x21236._1_=(message_tag_mt_tagid)
            x21236._2_=(message_tag_mt_messageid)
            x21236._3_=((x1331._2))
            x21236._4_=(((x1331._3).*(x1338)))
            val x21237 = x21236._4;
            if((x21237.==(0L))) {
            } else {
              val x32274 = COUNT_mKNOWS21Idx0.get(x21236);
              if((x32274.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x21236)
              } else {
                x32274._4 +=(x21237)
                if(((x32274._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32274)
                } else {
                }
              }
            }
          
          }
        }), x41794)
      }
      x21152._1_=(message_tag_mt_messageid)
      val x41819 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21152);
      if((x41819.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21152, ({ x1357: SEntry3_SSL => {
            x21256._1_=(message_tag_mt_messageid)
            x21256._2_=(message_tag_mt_tagid)
            x21256._3_=((x1357._2))
            x21256._4_=((x1357._3))
            val x21257 = x21256._4;
            if((x21257.==(0L))) {
            } else {
              val x32298 = COUNT_mKNOWS21_mTAG1Idx0.get(x21256);
              if((x32298.==(null))) {
                COUNT_mKNOWS21_mTAG1.unsafeInsert(x21256)
              } else {
                x32298._4 +=(x21257)
                if(((x32298._4).==(0L))) {
                  COUNT_mKNOWS21_mTAG1.delete(x32298)
                } else {
                }
              }
            }
          
          }
        }), x41819)
      }
      x21155._1_=(message_tag_mt_messageid)
      x21155._2_=(message_tag_mt_tagid)
      x21155._3_=(1L)
      val x21156 = x21155._3;
      if((x21156.==(0L))) {
      } else {
        val x32317 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0.get(x21155);
        if((x32317.==(null))) {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2.unsafeInsert(x21155)
        } else {
          x32317._3 +=(x21156)
          if(((x32317._3).==(0L))) {
            COUNT_mKNOWS21_mTAG1_mMESSAGE2.delete(x32317)
          } else {
          }
        }
      }
      x21169._1_=(message_tag_mt_messageid)
      val x41867 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21169);
      if((x41867.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21169, ({ x1391: SEntry4_SSSL => {
            x21291._1_=(message_tag_mt_tagid)
            val x32336 = COUNT_mMESSAGE_TAG2Idx0.get(x21291);
            val x1399 = if((x32336.==(null))) {
            0L
            } else {
            (x32336._2)
            };
            x21297._1_=(message_tag_mt_tagid)
            x21297._2_=(message_tag_mt_messageid)
            x21297._3_=((x1391._2))
            x21297._4_=((x1391._3))
            x21297._5_=(((x1391._4).*(x1399)))
            val x21298 = x21297._5;
            if((x21298.==(0L))) {
            } else {
              val x32349 = COUNT_mKNOWS12Idx0.get(x21297);
              if((x32349.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x21297)
              } else {
                x32349._5 +=(x21298)
                if(((x32349._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32349)
                } else {
                }
              }
            }
          
          }
        }), x41867)
      }
      x21172._1_=(message_tag_mt_messageid)
      val x41894 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21172);
      if((x41894.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21172, ({ x1418: SEntry4_SSSL => {
            x21318._1_=(message_tag_mt_messageid)
            x21318._2_=(message_tag_mt_tagid)
            x21318._3_=((x1418._2))
            x21318._4_=((x1418._3))
            x21318._5_=((x1418._4))
            val x21319 = x21318._5;
            if((x21319.==(0L))) {
            } else {
              val x32375 = COUNT_mKNOWS12_mTAG1Idx0.get(x21318);
              if((x32375.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x21318)
              } else {
                x32375._5 +=(x21319)
                if(((x32375._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x32375)
                } else {
                }
              }
            }
          
          }
        }), x41894)
      }
      x21175._1_=(message_tag_mt_tagid)
      val x32389 = COUNT_mMESSAGE_TAG2Idx0.get(x21175);
      val x1442 = if((x32389.==(null))) {
      0L
      } else {
      (x32389._2)
      };
      x21180._1_=(message_tag_mt_tagid)
      x21180._2_=(message_tag_mt_messageid)
      x21180._3_=(x1442)
      val x21181 = x21180._3;
      if((x21181.==(0L))) {
      } else {
        val x32399 = COUNT_mMESSAGE2Idx0.get(x21180);
        if((x32399.==(null))) {
          COUNT_mMESSAGE2.unsafeInsert(x21180)
        } else {
          x32399._3 +=(x21181)
          if(((x32399._3).==(0L))) {
            COUNT_mMESSAGE2.delete(x32399)
          } else {
          }
        }
      }
      x21194._1_=(message_tag_mt_messageid)
      val x41943 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21194);
      if((x41943.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21194, ({ x1458: SEntry5_SSSSL => {
            x21359._1_=(message_tag_mt_messageid)
            x21359._2_=(message_tag_mt_tagid)
            x21359._3_=((x1458._2))
            x21359._4_=((x1458._3))
            x21359._5_=((x1458._4))
            x21359._6_=((x1458._5))
            val x21360 = x21359._6;
            if((x21360.==(0L))) {
            } else {
              val x32426 = COUNT_mTAG1Idx0.get(x21359);
              if((x32426.==(null))) {
                COUNT_mTAG1.unsafeInsert(x21359)
              } else {
                x32426._6 +=(x21360)
                if(((x32426._6).==(0L))) {
                  COUNT_mTAG1.delete(x32426)
                } else {
                }
              }
            }
          
          }
        }), x41943)
      }
    
    }
  
  }
  def onDelMESSAGE_TAG(message_tag_k_op_time:String, message_tag_k_op:String, message_tag_mt_messageid:String, message_tag_mt_tagid:String) {
    {
      x21551._1_=(message_tag_mt_messageid)
      val x41979 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21551);
      if((x41979.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21551, ({ x1484: SEntry5_SSSSL => {
            x21610._1_=(message_tag_mt_tagid)
            val x32661 = COUNT_mMESSAGE_TAG2Idx0.get(x21610);
            val x1493 = if((x32661.==(null))) {
            0L
            } else {
            (x32661._2)
            };
            x21617._1_=((x1484._2))
            x21617._2_=((x1484._3))
            x21617._3_=((x1484._4))
            x21617._4_=(message_tag_mt_tagid)
            x21617._5_=(message_tag_mt_messageid)
            x21617._6_=(((x1484._5).*((x1493.unary_-))))
            val x21618 = x21617._6;
            if((x21618.==(0L))) {
            } else {
              val x32676 = COUNTIdx0.get(x21617);
              if((x32676.==(null))) {
                COUNT.unsafeInsert(x21617)
              } else {
                x32676._6 +=(x21618)
                if(((x32676._6).==(0L))) {
                  COUNT.delete(x32676)
                } else {
                }
              }
            }
          
          }
        }), x41979)
      }
      x21554._1_=(message_tag_mt_messageid)
      val x42011 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21554);
      if((x42011.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21554, ({ x1513: SEntry3_SSL => {
            x21637._1_=(message_tag_mt_tagid)
            val x32693 = COUNT_mMESSAGE_TAG2Idx0.get(x21637);
            val x1520 = if((x32693.==(null))) {
            0L
            } else {
            (x32693._2)
            };
            x21644._1_=(message_tag_mt_tagid)
            x21644._2_=(message_tag_mt_messageid)
            x21644._3_=((x1513._2))
            x21644._4_=(((x1513._3).*((x1520.unary_-))))
            val x21645 = x21644._4;
            if((x21645.==(0L))) {
            } else {
              val x32706 = COUNT_mKNOWS21Idx0.get(x21644);
              if((x32706.==(null))) {
                COUNT_mKNOWS21.unsafeInsert(x21644)
              } else {
                x32706._4 +=(x21645)
                if(((x32706._4).==(0L))) {
                  COUNT_mKNOWS21.delete(x32706)
                } else {
                }
              }
            }
          
          }
        }), x42011)
      }
      x21557._1_=(message_tag_mt_messageid)
      val x42037 = COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceRes(x21557);
      if((x42037.isEmpty)) {
      } else {
        COUNT_mKNOWS21_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21557, ({ x1540: SEntry3_SSL => {
            x21665._1_=(message_tag_mt_messageid)
            x21665._2_=(message_tag_mt_tagid)
            x21665._3_=((x1540._2))
            x21665._4_=(((x1540._3).unary_-))
            val x21666 = x21665._4;
            if((x21666.==(0L))) {
            } else {
              val x32731 = COUNT_mKNOWS21_mTAG1Idx0.get(x21665);
              if((x32731.==(null))) {
                COUNT_mKNOWS21_mTAG1.unsafeInsert(x21665)
              } else {
                x32731._4 +=(x21666)
                if(((x32731._4).==(0L))) {
                  COUNT_mKNOWS21_mTAG1.delete(x32731)
                } else {
                }
              }
            }
          
          }
        }), x42037)
      }
      x21560._1_=(message_tag_mt_messageid)
      x21560._2_=(message_tag_mt_tagid)
      x21560._3_=(-1L)
      val x21561 = x21560._3;
      if((x21561.==(0L))) {
      } else {
        val x32750 = COUNT_mKNOWS21_mTAG1_mMESSAGE2Idx0.get(x21560);
        if((x32750.==(null))) {
          COUNT_mKNOWS21_mTAG1_mMESSAGE2.unsafeInsert(x21560)
        } else {
          x32750._3 +=(x21561)
          if(((x32750._3).==(0L))) {
            COUNT_mKNOWS21_mTAG1_mMESSAGE2.delete(x32750)
          } else {
          }
        }
      }
      x21574._1_=(message_tag_mt_messageid)
      val x42086 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21574);
      if((x42086.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21574, ({ x1575: SEntry4_SSSL => {
            x21700._1_=(message_tag_mt_tagid)
            val x32769 = COUNT_mMESSAGE_TAG2Idx0.get(x21700);
            val x1583 = if((x32769.==(null))) {
            0L
            } else {
            (x32769._2)
            };
            x21707._1_=(message_tag_mt_tagid)
            x21707._2_=(message_tag_mt_messageid)
            x21707._3_=((x1575._2))
            x21707._4_=((x1575._3))
            x21707._5_=(((x1575._4).*((x1583.unary_-))))
            val x21708 = x21707._5;
            if((x21708.==(0L))) {
            } else {
              val x32783 = COUNT_mKNOWS12Idx0.get(x21707);
              if((x32783.==(null))) {
                COUNT_mKNOWS12.unsafeInsert(x21707)
              } else {
                x32783._5 +=(x21708)
                if(((x32783._5).==(0L))) {
                  COUNT_mKNOWS12.delete(x32783)
                } else {
                }
              }
            }
          
          }
        }), x42086)
      }
      x21577._1_=(message_tag_mt_messageid)
      val x42114 = COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceRes(x21577);
      if((x42114.isEmpty)) {
      } else {
        COUNT_mKNOWS12_mMESSAGE_TAG1Idx2.sliceResMapNoUpd(x21577, ({ x1603: SEntry4_SSSL => {
            x21729._1_=(message_tag_mt_messageid)
            x21729._2_=(message_tag_mt_tagid)
            x21729._3_=((x1603._2))
            x21729._4_=((x1603._3))
            x21729._5_=(((x1603._4).unary_-))
            val x21730 = x21729._5;
            if((x21730.==(0L))) {
            } else {
              val x32810 = COUNT_mKNOWS12_mTAG1Idx0.get(x21729);
              if((x32810.==(null))) {
                COUNT_mKNOWS12_mTAG1.unsafeInsert(x21729)
              } else {
                x32810._5 +=(x21730)
                if(((x32810._5).==(0L))) {
                  COUNT_mKNOWS12_mTAG1.delete(x32810)
                } else {
                }
              }
            }
          
          }
        }), x42114)
      }
      x21580._1_=(message_tag_mt_tagid)
      val x32824 = COUNT_mMESSAGE_TAG2Idx0.get(x21580);
      val x1628 = if((x32824.==(null))) {
      0L
      } else {
      (x32824._2)
      };
      x21586._1_=(message_tag_mt_tagid)
      x21586._2_=(message_tag_mt_messageid)
      x21586._3_=((x1628.unary_-))
      val x21587 = x21586._3;
      if((x21587.==(0L))) {
      } else {
        val x32835 = COUNT_mMESSAGE2Idx0.get(x21586);
        if((x32835.==(null))) {
          COUNT_mMESSAGE2.unsafeInsert(x21586)
        } else {
          x32835._3 +=(x21587)
          if(((x32835._3).==(0L))) {
            COUNT_mMESSAGE2.delete(x32835)
          } else {
          }
        }
      }
      x21600._1_=(message_tag_mt_messageid)
      val x42165 = COUNT_mMESSAGE_TAG1Idx1.sliceRes(x21600);
      if((x42165.isEmpty)) {
      } else {
        COUNT_mMESSAGE_TAG1Idx1.sliceResMapNoUpd(x21600, ({ x1645: SEntry5_SSSSL => {
            x21772._1_=(message_tag_mt_messageid)
            x21772._2_=(message_tag_mt_tagid)
            x21772._3_=((x1645._2))
            x21772._4_=((x1645._3))
            x21772._5_=((x1645._4))
            x21772._6_=(((x1645._5).unary_-))
            val x21773 = x21772._6;
            if((x21773.==(0L))) {
            } else {
              val x32863 = COUNT_mTAG1Idx0.get(x21772);
              if((x32863.==(null))) {
                COUNT_mTAG1.unsafeInsert(x21772)
              } else {
                x32863._6 +=(x21773)
                if(((x32863._6).==(0L))) {
                  COUNT_mTAG1.delete(x32863)
                } else {
                }
              }
            }
          
          }
        }), x42165)
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
    case TupleEvent(TupleInsert, "TAG", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddTAG(v0,v1,v2,v3)
    case TupleEvent(TupleDelete, "TAG", List(v0:String,v1:String,v2:String,v3:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelTAG(v0,v1,v2,v3)
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