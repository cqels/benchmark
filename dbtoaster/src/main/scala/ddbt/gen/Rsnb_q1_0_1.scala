package ddbt.gen
    
import ddbt.lib._
import akka.actor.Actor
import ddbt.lib.store._


object Rsnb_q1_0_1 {
  import Helper._

  

  def execute(args: Array[String], f: List[Any] => Unit) = 
    bench(args, (dataset: String, parallelMode: Int, timeout: Long, batchSize: Int) => run[Rsnb_q1_0_1](
      Seq(
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_1/ouput/dbtoaster.message.window.csv"),new Adaptor.CSV("MESSAGE","string,string,string,string,string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_1/ouput/dbtoaster.person.window.csv"),new Adaptor.CSV("PERSON","string,string,string,string,string,string,string,string,string,string,string,string,string","\\Q|\\E", "insert"),Split()),
        (new java.io.FileInputStream("/root/benchmark/dbtoaster/dbtoaster_data/snb_0_1/ouput/dbtoaster.knows.window.csv"),new Adaptor.CSV("KNOWS","string,string,string,string,string","\\Q|\\E", "insert"),Split())
      ), 
      parallelMode, timeout, batchSize), f)

  def main(args: Array[String]) {

    val argMap = parseArgs(args)
    
    execute(args, (res: List[Any]) => {
      if (!argMap.contains("noOutput")) {
        println("<snap>")
        println("<COUNT>\n" + M3Map.toStr(res(0), List("PERSON_P_PERSONID", "PERSON_P_FIRSTNAME", "PERSON_P_LASTNAME", "MESSAGE_M_MESSAGEID", "KNOWS_K_PERSONID1"))+"\n" + "</COUNT>\n")
        println("</snap>")
      }
    })
  }  
}
class Rsnb_q1_0_1Base {
  import Rsnb_q1_0_1._
  import ddbt.lib.Functions._

  case class SEntry3_SSL(var _1: String, var _2: String, var _3: Long) extends Entry(3) {def this() = this(null, null, -2147483648L) ; def copy = SEntry3_SSL(_1, _2, _3); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry3_SSL]; _1 = that._1;_2 = that._2;_3 = that._3} }
  case class SEntry6_SSSSSL(var _1: String, var _2: String, var _3: String, var _4: String, var _5: String, var _6: Long) extends Entry(6) {def this() = this(null, null, null, null, null, -2147483648L) ; def copy = SEntry6_SSSSSL(_1, _2, _3, _4, _5, _6); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry6_SSSSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4;_5 = that._5;_6 = that._6} }
  case class SEntry4_SSSL(var _1: String, var _2: String, var _3: String, var _4: Long) extends Entry(4) {def this() = this(null, null, null, -2147483648L) ; def copy = SEntry4_SSSL(_1, _2, _3, _4); override def copyFrom(e: Entry) = { val that = e.asInstanceOf[SEntry4_SSSL]; _1 = that._1;_2 = that._2;_3 = that._3;_4 = that._4} }
   object SEntry3_SSL_Idx12 extends EntryIdx[SEntry3_SSL] {
    override def hash(x2992 : SEntry3_SSL) = {
      var x2993: Int = 0;
      val x2994 = x2993;
      x2993 = (x2994.^((((((x2992._1).hashCode()).+(-1640531527)).+((x2994.<<(6)))).+((x2994.>>(2))))))
      val x3004 = x2993;
      x2993 = (x3004.^((((((x2992._2).hashCode()).+(-1640531527)).+((x3004.<<(6)))).+((x3004.>>(2))))))
      val x3014 = x2993;
      x3014
    }
    override def cmp(x3016 : SEntry3_SSL , x3017 : SEntry3_SSL) = {
      var x3018: Int = 0;
      if(((x3016._1).==((x3017._1)))) {
        if(((x3016._2).==((x3017._2)))) {
          x3018 = 0
        } else {
          x3018 = 1
        }
      } else {
        x3018 = 1
      }
      val x3030 = x3018;
      x3030
    }
  }
   object SEntry4_SSSL_Idx123 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x2904 : SEntry4_SSSL) = {
      var x2905: Int = 0;
      val x2906 = x2905;
      x2905 = (x2906.^((((((x2904._1).hashCode()).+(-1640531527)).+((x2906.<<(6)))).+((x2906.>>(2))))))
      val x2916 = x2905;
      x2905 = (x2916.^((((((x2904._2).hashCode()).+(-1640531527)).+((x2916.<<(6)))).+((x2916.>>(2))))))
      val x2926 = x2905;
      x2905 = (x2926.^((((((x2904._3).hashCode()).+(-1640531527)).+((x2926.<<(6)))).+((x2926.>>(2))))))
      val x2936 = x2905;
      x2936
    }
    override def cmp(x2938 : SEntry4_SSSL , x2939 : SEntry4_SSSL) = {
      var x2940: Int = 0;
      if(((x2938._1).==((x2939._1)))) {
        if(((x2938._2).==((x2939._2)))) {
          if(((x2938._3).==((x2939._3)))) {
            x2940 = 0
          } else {
            x2940 = 1
          }
        } else {
          x2940 = 1
        }
      } else {
        x2940 = 1
      }
      val x2957 = x2940;
      x2957
    }
  }
   object SEntry6_SSSSSL_Idx12345 extends EntryIdx[SEntry6_SSSSSL] {
    override def hash(x2813 : SEntry6_SSSSSL) = {
      var x2814: Int = 0;
      val x2815 = x2814;
      x2814 = (x2815.^((((((x2813._1).hashCode()).+(-1640531527)).+((x2815.<<(6)))).+((x2815.>>(2))))))
      val x2825 = x2814;
      x2814 = (x2825.^((((((x2813._2).hashCode()).+(-1640531527)).+((x2825.<<(6)))).+((x2825.>>(2))))))
      val x2835 = x2814;
      x2814 = (x2835.^((((((x2813._3).hashCode()).+(-1640531527)).+((x2835.<<(6)))).+((x2835.>>(2))))))
      val x2845 = x2814;
      x2814 = (x2845.^((((((x2813._4).hashCode()).+(-1640531527)).+((x2845.<<(6)))).+((x2845.>>(2))))))
      val x2855 = x2814;
      x2814 = (x2855.^((((((x2813._5).hashCode()).+(-1640531527)).+((x2855.<<(6)))).+((x2855.>>(2))))))
      val x2865 = x2814;
      x2865
    }
    override def cmp(x2867 : SEntry6_SSSSSL , x2868 : SEntry6_SSSSSL) = {
      var x2869: Int = 0;
      if(((x2867._1).==((x2868._1)))) {
        if(((x2867._2).==((x2868._2)))) {
          if(((x2867._3).==((x2868._3)))) {
            if(((x2867._4).==((x2868._4)))) {
              if(((x2867._5).==((x2868._5)))) {
                x2869 = 0
              } else {
                x2869 = 1
              }
            } else {
              x2869 = 1
            }
          } else {
            x2869 = 1
          }
        } else {
          x2869 = 1
        }
      } else {
        x2869 = 1
      }
      val x2896 = x2869;
      x2896
    }
  }
   object SEntry4_SSSL_Idx1 extends EntryIdx[SEntry4_SSSL] {
    override def hash(x2960 : SEntry4_SSSL) = {
      var x2961: Int = 0;
      val x2962 = x2961;
      x2961 = (x2962.^((((((x2960._1).hashCode()).+(-1640531527)).+((x2962.<<(6)))).+((x2962.>>(2))))))
      val x2972 = x2961;
      x2972
    }
    override def cmp(x2974 : SEntry4_SSSL , x2975 : SEntry4_SSSL) = {
      var x2976: Int = 0;
      if(((x2974._1).==((x2975._1)))) {
        x2976 = 0
      } else {
        x2976 = 1
      }
      val x2983 = x2976;
      x2983
    }
  }
   object SEntry3_SSL_Idx2 extends EntryIdx[SEntry3_SSL] {
    override def hash(x3033 : SEntry3_SSL) = {
      var x3034: Int = 0;
      val x3035 = x3034;
      x3034 = (x3035.^((((((x3033._2).hashCode()).+(-1640531527)).+((x3035.<<(6)))).+((x3035.>>(2))))))
      val x3045 = x3034;
      x3045
    }
    override def cmp(x3047 : SEntry3_SSL , x3048 : SEntry3_SSL) = {
      var x3049: Int = 0;
      if(((x3047._2).==((x3048._2)))) {
        x3049 = 0
      } else {
        x3049 = 1
      }
      val x3056 = x3049;
      x3056
    }
  }
  
  val x2900 = Array[EntryIdx[SEntry6_SSSSSL]](SEntry6_SSSSSL_Idx12345)
  val COUNT = new Store[SEntry6_SSSSSL](1, x2900);
  val COUNTIdx0 = COUNT.index(0, IHash, true, -1)
  val x2987 = Array[EntryIdx[SEntry4_SSSL]](SEntry4_SSSL_Idx123, SEntry4_SSSL_Idx1)
  val COUNT_mMESSAGE1 = new Store[SEntry4_SSSL](2, x2987);
  val COUNT_mMESSAGE1Idx0 = COUNT_mMESSAGE1.index(0, IHash, true, -1)
  val COUNT_mMESSAGE1Idx1 = COUNT_mMESSAGE1.index(1, IHash, false, -1)
  val x3060 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mPERSON1 = new Store[SEntry3_SSL](2, x3060);
  val COUNT_mPERSON1Idx0 = COUNT_mPERSON1.index(0, IHash, true, -1)
  val COUNT_mPERSON1Idx1 = COUNT_mPERSON1.index(1, IHash, false, -1)
  val x3064 = Array[EntryIdx[SEntry3_SSL]](SEntry3_SSL_Idx12, SEntry3_SSL_Idx2)
  val COUNT_mPERSON2 = new Store[SEntry3_SSL](2, x3064);
  val COUNT_mPERSON2Idx0 = COUNT_mPERSON2.index(0, IHash, true, -1)
  val COUNT_mPERSON2Idx1 = COUNT_mPERSON2.index(1, IHash, false, -1)
  
  
  
  val x3449 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x3825 = SEntry3_SSL(null, null, -2147483648L);
  val x3347 = SEntry3_SSL(null, null, -2147483648L);
  val x3701 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x3970 = SEntry3_SSL(null, null, -2147483648L);
  val x3503 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3822 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x3598 = SEntry3_SSL(null, null, -2147483648L);
  val x3950 = SEntry3_SSL(null, null, -2147483648L);
  val x3576 = SEntry3_SSL(null, null, -2147483648L);
  val x3472 = SEntry3_SSL(null, null, -2147483648L);
  val x3324 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x3327 = SEntry3_SSL(null, null, -2147483648L);
  val x3452 = SEntry3_SSL(null, null, -2147483648L);
  val x3579 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x3875 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3698 = SEntry3_SSL(null, null, -2147483648L);
  val x3627 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3750 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3377 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3947 = SEntry4_SSSL(null, null, null, -2147483648L);
  val x4001 = SEntry6_SSSSSL(null, null, null, null, null, -2147483648L);
  val x3845 = SEntry3_SSL(null, null, -2147483648L);
  val x3720 = SEntry3_SSL(null, null, -2147483648L);
  def onAddMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x3324._1_=(message_m_creatorid)
      val x7996 = COUNT_mMESSAGE1Idx1.sliceRes(x3324);
      if((x7996.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x3324, ({ x21: SEntry4_SSSL => {
            x3347._2_=(message_m_creatorid)
            val x7992 = COUNT_mPERSON2Idx1.sliceRes(x3347);
            if((x7992.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x3347, ({ x26: SEntry3_SSL => {
                  x3377._1_=(message_m_creatorid)
                  x3377._2_=((x21._2))
                  x3377._3_=((x21._3))
                  x3377._4_=(message_m_messageid)
                  x3377._5_=((x26._1))
                  x3377._6_=(((x21._4).*((x26._3))))
                  val x3378 = x3377._6;
                  if((x3378.==(0L))) {
                  } else {
                    val x5754 = COUNTIdx0.get(x3377);
                    if((x5754.==(null))) {
                      COUNT.unsafeInsert(x3377)
                    } else {
                      x5754._6 +=(x3378)
                      if(((x5754._6).==(0L))) {
                        COUNT.delete(x5754)
                      } else {
                      }
                    }
                  }
                
                }
              }), x7992)
            }
            ()
          }
        }), x7996)
      }
      x3327._1_=(message_m_messageid)
      x3327._2_=(message_m_creatorid)
      x3327._3_=(1L)
      val x3328 = x3327._3;
      if((x3328.==(0L))) {
      } else {
        val x5772 = COUNT_mPERSON1Idx0.get(x3327);
        if((x5772.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x3327)
        } else {
          x5772._3 +=(x3328)
          if(((x5772._3).==(0L))) {
            COUNT_mPERSON1.delete(x5772)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelMESSAGE(message_m_op_time:String, message_m_op:String, message_m_explicitlydeleted:String, message_m_messageid:String, message_m_ps_imagefile:String, message_m_locationip:String, message_m_browserused:String, message_m_ps_language:String, message_m_content:String, message_m_length:String, message_m_creatorid:String, message_m_locationid:String, message_m_ps_forumid:String, message_m_c_parentpostid:String, message_m_c_replyof:String) {
    {
      x3449._1_=(message_m_creatorid)
      val x8050 = COUNT_mMESSAGE1Idx1.sliceRes(x3449);
      if((x8050.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x3449, ({ x78: SEntry4_SSSL => {
            x3472._2_=(message_m_creatorid)
            val x8046 = COUNT_mPERSON2Idx1.sliceRes(x3472);
            if((x8046.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x3472, ({ x83: SEntry3_SSL => {
                  x3503._1_=(message_m_creatorid)
                  x3503._2_=((x78._2))
                  x3503._3_=((x78._3))
                  x3503._4_=(message_m_messageid)
                  x3503._5_=((x83._1))
                  x3503._6_=(((x78._4).*(((x83._3).unary_-))))
                  val x3504 = x3503._6;
                  if((x3504.==(0L))) {
                  } else {
                    val x5855 = COUNTIdx0.get(x3503);
                    if((x5855.==(null))) {
                      COUNT.unsafeInsert(x3503)
                    } else {
                      x5855._6 +=(x3504)
                      if(((x5855._6).==(0L))) {
                        COUNT.delete(x5855)
                      } else {
                      }
                    }
                  }
                
                }
              }), x8046)
            }
            ()
          }
        }), x8050)
      }
      x3452._1_=(message_m_messageid)
      x3452._2_=(message_m_creatorid)
      x3452._3_=(-1L)
      val x3453 = x3452._3;
      if((x3453.==(0L))) {
      } else {
        val x5873 = COUNT_mPERSON1Idx0.get(x3452);
        if((x5873.==(null))) {
          COUNT_mPERSON1.unsafeInsert(x3452)
        } else {
          x5873._3 +=(x3453)
          if(((x5873._3).==(0L))) {
            COUNT_mPERSON1.delete(x5873)
          } else {
          }
        }
      }
    
    }
  
  }
  def onAddPERSON(person_p_op_time:String, person_p_op:String, person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x3576._2_=(person_p_personid)
      val x8102 = COUNT_mPERSON1Idx1.sliceRes(x3576);
      if((x8102.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x3576, ({ x134: SEntry3_SSL => {
            x3598._2_=(person_p_personid)
            val x8098 = COUNT_mPERSON2Idx1.sliceRes(x3598);
            if((x8098.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x3598, ({ x138: SEntry3_SSL => {
                  x3627._1_=(person_p_personid)
                  x3627._2_=(person_p_firstname)
                  x3627._3_=(person_p_lastname)
                  x3627._4_=((x134._1))
                  x3627._5_=((x138._1))
                  x3627._6_=(((x134._3).*((x138._3))))
                  val x3628 = x3627._6;
                  if((x3628.==(0L))) {
                  } else {
                    val x5955 = COUNTIdx0.get(x3627);
                    if((x5955.==(null))) {
                      COUNT.unsafeInsert(x3627)
                    } else {
                      x5955._6 +=(x3628)
                      if(((x5955._6).==(0L))) {
                        COUNT.delete(x5955)
                      } else {
                      }
                    }
                  }
                
                }
              }), x8098)
            }
            ()
          }
        }), x8102)
      }
      x3579._1_=(person_p_personid)
      x3579._2_=(person_p_firstname)
      x3579._3_=(person_p_lastname)
      x3579._4_=(1L)
      val x3580 = x3579._4;
      if((x3580.==(0L))) {
      } else {
        val x5974 = COUNT_mMESSAGE1Idx0.get(x3579);
        if((x5974.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x3579)
        } else {
          x5974._4 +=(x3580)
          if(((x5974._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x5974)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelPERSON(person_p_op_time:String, person_p_op:String, person_p_explicitlydeleted:String, person_p_personid:String, person_p_firstname:String, person_p_lastname:String, person_p_gender:String, person_p_birthday:String, person_p_locationip:String, person_p_browserused:String, person_p_placeid:String, person_p_language:String, person_p_email:String) {
    {
      x3698._2_=(person_p_personid)
      val x8156 = COUNT_mPERSON1Idx1.sliceRes(x3698);
      if((x8156.isEmpty)) {
      } else {
        COUNT_mPERSON1Idx1.sliceResMapNoUpd(x3698, ({ x188: SEntry3_SSL => {
            x3720._2_=(person_p_personid)
            val x8152 = COUNT_mPERSON2Idx1.sliceRes(x3720);
            if((x8152.isEmpty)) {
            } else {
              COUNT_mPERSON2Idx1.sliceResMapNoUpd(x3720, ({ x192: SEntry3_SSL => {
                  x3750._1_=(person_p_personid)
                  x3750._2_=(person_p_firstname)
                  x3750._3_=(person_p_lastname)
                  x3750._4_=((x188._1))
                  x3750._5_=((x192._1))
                  x3750._6_=(((x188._3).*(((x192._3).unary_-))))
                  val x3751 = x3750._6;
                  if((x3751.==(0L))) {
                  } else {
                    val x6056 = COUNTIdx0.get(x3750);
                    if((x6056.==(null))) {
                      COUNT.unsafeInsert(x3750)
                    } else {
                      x6056._6 +=(x3751)
                      if(((x6056._6).==(0L))) {
                        COUNT.delete(x6056)
                      } else {
                      }
                    }
                  }
                
                }
              }), x8152)
            }
            ()
          }
        }), x8156)
      }
      x3701._1_=(person_p_personid)
      x3701._2_=(person_p_firstname)
      x3701._3_=(person_p_lastname)
      x3701._4_=(-1L)
      val x3702 = x3701._4;
      if((x3702.==(0L))) {
      } else {
        val x6075 = COUNT_mMESSAGE1Idx0.get(x3701);
        if((x6075.==(null))) {
          COUNT_mMESSAGE1.unsafeInsert(x3701)
        } else {
          x6075._4 +=(x3702)
          if(((x6075._4).==(0L))) {
            COUNT_mMESSAGE1.delete(x6075)
          } else {
          }
        }
      }
    
    }
  
  }
  def onAddKNOWS(knows_k_op_time:String, knows_p_op:String, knows_k_explicitlydeleted:String, knows_k_personid1:String, knows_k_personid2:String) {
    {
      x3822._1_=(knows_k_personid2)
      val x8210 = COUNT_mMESSAGE1Idx1.sliceRes(x3822);
      if((x8210.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x3822, ({ x235: SEntry4_SSSL => {
            x3845._2_=(knows_k_personid2)
            val x8206 = COUNT_mPERSON1Idx1.sliceRes(x3845);
            if((x8206.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x3845, ({ x240: SEntry3_SSL => {
                  x3875._1_=(knows_k_personid2)
                  x3875._2_=((x235._2))
                  x3875._3_=((x235._3))
                  x3875._4_=((x240._1))
                  x3875._5_=(knows_k_personid1)
                  x3875._6_=(((x235._4).*((x240._3))))
                  val x3876 = x3875._6;
                  if((x3876.==(0L))) {
                  } else {
                    val x6158 = COUNTIdx0.get(x3875);
                    if((x6158.==(null))) {
                      COUNT.unsafeInsert(x3875)
                    } else {
                      x6158._6 +=(x3876)
                      if(((x6158._6).==(0L))) {
                        COUNT.delete(x6158)
                      } else {
                      }
                    }
                  }
                
                }
              }), x8206)
            }
            ()
          }
        }), x8210)
      }
      x3825._1_=(knows_k_personid1)
      x3825._2_=(knows_k_personid2)
      x3825._3_=(1L)
      val x3826 = x3825._3;
      if((x3826.==(0L))) {
      } else {
        val x6176 = COUNT_mPERSON2Idx0.get(x3825);
        if((x6176.==(null))) {
          COUNT_mPERSON2.unsafeInsert(x3825)
        } else {
          x6176._3 +=(x3826)
          if(((x6176._3).==(0L))) {
            COUNT_mPERSON2.delete(x6176)
          } else {
          }
        }
      }
    
    }
  
  }
  def onDelKNOWS(knows_k_op_time:String, knows_p_op:String, knows_k_explicitlydeleted:String, knows_k_personid1:String, knows_k_personid2:String) {
    {
      x3947._1_=(knows_k_personid2)
      val x8264 = COUNT_mMESSAGE1Idx1.sliceRes(x3947);
      if((x8264.isEmpty)) {
      } else {
        COUNT_mMESSAGE1Idx1.sliceResMapNoUpd(x3947, ({ x282: SEntry4_SSSL => {
            x3970._2_=(knows_k_personid2)
            val x8260 = COUNT_mPERSON1Idx1.sliceRes(x3970);
            if((x8260.isEmpty)) {
            } else {
              COUNT_mPERSON1Idx1.sliceResMapNoUpd(x3970, ({ x287: SEntry3_SSL => {
                  x4001._1_=(knows_k_personid2)
                  x4001._2_=((x282._2))
                  x4001._3_=((x282._3))
                  x4001._4_=((x287._1))
                  x4001._5_=(knows_k_personid1)
                  x4001._6_=(((x282._4).*(((x287._3).unary_-))))
                  val x4002 = x4001._6;
                  if((x4002.==(0L))) {
                  } else {
                    val x6259 = COUNTIdx0.get(x4001);
                    if((x6259.==(null))) {
                      COUNT.unsafeInsert(x4001)
                    } else {
                      x6259._6 +=(x4002)
                      if(((x6259._6).==(0L))) {
                        COUNT.delete(x6259)
                      } else {
                      }
                    }
                  }
                
                }
              }), x8260)
            }
            ()
          }
        }), x8264)
      }
      x3950._1_=(knows_k_personid1)
      x3950._2_=(knows_k_personid2)
      x3950._3_=(-1L)
      val x3951 = x3950._3;
      if((x3951.==(0L))) {
      } else {
        val x6277 = COUNT_mPERSON2Idx0.get(x3950);
        if((x6277.==(null))) {
          COUNT_mPERSON2.unsafeInsert(x3950)
        } else {
          x6277._3 +=(x3951)
          if(((x6277._3).==(0L))) {
            COUNT_mPERSON2.delete(x6277)
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

class Rsnb_q1_0_1 extends Rsnb_q1_0_1Base with Actor {
  import ddbt.lib.Messages._
  import ddbt.lib.Functions._
  import Rsnb_q1_0_1._
  
  var t0 = 0L; var t1 = 0L; var tN = 0L; var tS = 0L

  

  

  def receive_skip: Receive = { 
    case EndOfStream | GetSnapshot(_) => 
       sender ! (StreamStat(t1 - t0, tN, tS), null)
    case _ => tS += 1L
  }

  def receive = {
    case TupleEvent(TupleInsert, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String,v13:String,v14:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddMESSAGE(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14)
    case TupleEvent(TupleDelete, "MESSAGE", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String,v13:String,v14:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelMESSAGE(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14)
    case TupleEvent(TupleInsert, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12)
    case TupleEvent(TupleDelete, "PERSON", List(v0:String,v1:String,v2:String,v3:String,v4:String,v5:String,v6:String,v7:String,v8:String,v9:String,v10:String,v11:String,v12:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelPERSON(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12)
    case TupleEvent(TupleInsert, "KNOWS", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onAddKNOWS(v0,v1,v2,v3,v4)
    case TupleEvent(TupleDelete, "KNOWS", List(v0:String,v1:String,v2:String,v3:String,v4:String)) => if (t1 > 0 && (tN & 127) == 0) { val t = System.nanoTime; if (t > t1) { t1 = t; tS = 1L; context.become(receive_skip) } }; tN += 1L; onDelKNOWS(v0,v1,v2,v3,v4)
    case StreamInit(timeout) => 
      
      onSystemReady();
      t0 = System.nanoTime;
      if (timeout > 0) t1 = t0 + timeout * 1000000L
    case EndOfStream | GetSnapshot(_) => 
      t1 = System.nanoTime; 
       sender ! (StreamStat(t1 - t0, tN, tS), List({ val COUNT_node_mres = new scala.collection.mutable.HashMap[(String, String, String, String, String),Long](); COUNT.foreach{e => COUNT_node_mres += (((e._1, e._2, e._3, e._4, e._5),e._6)) }; COUNT_node_mres.toMap }))
  }
}