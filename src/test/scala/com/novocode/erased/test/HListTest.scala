package com.novocode.erased.test

import org.junit.Test
import com.novocode.erased._
import syntax._

class HListTest {
  @Test
  def testHList {
    val l1 = 42 :: "foo" :: Some(1.0) :: "bar" :: HNil
    val l1a = l1.head
    val l1b = l1.tail.head
    val l1c = l1.tail.tail.head
    val l1d = l1.tail.tail.tail.head
    
    println(l1)
    val l2 = l1.drop(Nat._3)
      println(l2)
    val e0: Int = l1(Nat._0)
    val e2a: Option[Double] = l1.apply(Nat._2)
    val e2b: Option[Double] = l1.drop(Nat._2).head

    val x1 = null : l1.type#Tail#Tail#Tail#Head
    val x2 = null : Nat._3#Fold[HList, ({ type L[X <: HList] = X#Tail })#L, l1.type#This]#Head
    val x3: Option[Double] = null : l1.type#Drop[Nat._2]#Head

    implicitly[l1.Length =:= Nat._4]
    implicitly[l2.Length =:= Nat._1]
    
    println((l1.length, l2.length))

    import HList._
    val l3a = "foo" :: 42 :: HNil
    val l3b = true :: "baz" :: Some(1.0) :: HNil
    val l3 = l3a ::: l3b
    println(l3: String :: Int :: Boolean :: String :|: Some[Double])

    val l4 = new HCons(42, new HCons(10.0d, HNil))
    println(l4.getClass)
    println(l4.tail.getClass)
  }
}
