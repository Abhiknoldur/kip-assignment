import scala.collection._


class Employee(var efirstName:String,var elastName:String){
  override def hashCode=(efirstName,elastName).##
  override def equals(other:Any)=other match{
    case that:Employee=>this.efirstName==that.efirstName && this.elastName==that.elastName
    case _=>false
  }
}

val p2= new Employee("Abhishek", "Baranwal")
val coll1 = mutable.HashSet(p2)
p2.efirstName ="Abhishek"
coll1 contains p2
coll1.iterator contains p2



class Result(var EngMarks:Int,var MathsMarks:Int){
  //override def hashCode=(EngMarks,MathsMarks).##
  //override def equals(other:Any)=other match {
  def equalValues(other :Any)=other match{
    case that: Result => this.EngMarks == that.EngMarks && this.MathsMarks == that.MathsMarks
    case _ => false
  }
}

val R1=new Result(84,88)
val col=mutable.HashSet(R1)
col contains R1

R1.EngMarks +=10
col contains R1
