package edu.knoldus

class Sorting {

  def insertionSort(list: List[Int]): List[Int] = {
    val intArray: Array[Int] = list.toArray
    for ( i <- 1 until intArray.length ) {
      val k = intArray(i)
      var j=i-1
      while ((j> -1) && (intArray(j) > k) ){
        intArray(j+1)=intArray(j)
        j-=1
      }
      intArray(j+1)=k
    }
    val list1: List[Int] = intArray.toList
    list1
  }

  def selectionSort(list: List[Int]): List[Int] = {
    val intArray: Array[Int]=list.toArray
    var temp=0
    for(i <- intArray.indices){
      for(j <- (i + 1).until(intArray.length)){
        if(intArray(i)>intArray(j)){
          temp=intArray(i)
          intArray(i)=intArray(j)
          intArray(j)=temp
        }
      }

    }
    val list2: List[Int] = intArray.toList
    list2
  }

  def bubbleSort(list: List[Int]): List[Int] = {
    val intArray: Array[Int]=list.toArray
    var temp=0
    for(_ <- intArray.indices){
      for(j <-1 to intArray.length){
        if(intArray(j-1)>intArray(j)){
          temp=intArray(j-1)
          intArray(j-1)=intArray(j)
          intArray(j)=temp
        }
      }

    }
    val list3: List[Int] = intArray.toList
    list3
  }


}
