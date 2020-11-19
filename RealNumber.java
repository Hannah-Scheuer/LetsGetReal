public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  /*
  *Return the sum of this and the other
  */
  public RealNumber add(RealNumber other){
     //other can be ANY RealNumber, including a RationalNumber
     //or other subclasses of RealNumber (that aren't written yet)
     return null;
  }

  /*
  *Return the product of this and the other
  */
  public RealNumber multiply(RealNumber other){
        return null;
  }

  /*
  *Return the this divided by the other
  */
  public RealNumber divide(RealNumber other){
        return null;
  }

  /*
  *Return the this minus the other
  */
  public RealNumber subtract(RealNumber other){
    return null;
  }


  public double getValue(){
    return value;
  }

  public boolean equals(RealNumber other){
     return true;
   }

  public String toString(){
    return ""+value;
  }
}
