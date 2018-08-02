package Area

class Area {

  def area(shape: String, first: Int, second: Int, f:(Int,Int) => Int): String = {

    if (first<0 || second < 0) "Invalid Parameters" else {
      shape match {
        case "rectangle" => s"Area of $shape is ${f(first, second)}"
        case "rhombus" => s"Area of $shape is ${f(first,second)}"
        case "parallelogram" => s"Area of $shape is ${f(first, second)}"
        case _ => s"Not defined yet for $shape"
      }

    }
  }
  /* object AreaOFShapes extends App{

    val add = new Area
    //println(add.area("square",5,4,(a,b)=> a*b))
  } */




}
