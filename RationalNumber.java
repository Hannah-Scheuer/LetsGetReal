public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    numerator = nume;
    denominator = deno;
  }

  public double getValue(){
    return 0.0;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber hello = new RationalNumber(denominator, numerator);
    return hello;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return numerator==other.getNumerator() && denominator==other.getDenominator();
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator+"/"+denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int big =0;
    int small =0;
    if (a>b){
      big = a;
      small= b;
    }
    else{
      big = b;
      small = a;
    }
    int greatest = 0;
    int rem = 1;
    while (rem!=0){
      rem = big % small;
      if (rem==0){
        return small;
      }
      else{
        big = small;
        small = rem;
      }
    }
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    numerator = numerator / gcd(numerator, denominator);
    denominator = denominator / gcd(numerator, denominator);

  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber hello = new RationalNumber(numerator*other.getNumerator(), denominator*other.getDenominator());
    hello = hello.reduce()
    return hello;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return null;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return null;
  }
}
