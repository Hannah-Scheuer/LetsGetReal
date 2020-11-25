public class RationalNumber extends Number {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    int gcf = gcd(nume, deno);
    if (deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else if (deno<0){
      numerator = -1 * nume;
      denominator = -1 * deno;
    }
    else{
      numerator = nume;
      denominator = deno;
    }
  }

  public double getValue(){
    return numerator / (double) denominator;
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
    other.reduce();
    reduce();
    return numerator==other.getNumerator() && denominator==other.getDenominator();
  }

  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    reduce();
    if (denominator==1){
      return String.valueOf(numerator);
    }
    else if (numerator==0){
      return "0";
    }
    return numerator+"/"+denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */

  private static int gcd(int a, int b){
    int big = Math.max(a,b);
    int small = Math.min(a,b);
    if (a==0 || b==0){
      return 1;
    }
    if (Math.abs(a)>Math.abs(b)){
      big = Math.abs(a);
      small= Math.abs(b);
    }
    else{
      big = Math.abs(b);
      small = Math.abs(a);
    }
    int rem = 1;
    while (rem!=0){
      rem = big % small;
      if (rem!=0){
        big = small;
        small = rem;
      }
    }
    return small;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcf = gcd(numerator, denominator);
    numerator = numerator / gcf;
    denominator = denominator / gcf;
    if (denominator==0){
      numerator = 0;
      denominator = 1;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber hello = new RationalNumber(numerator*other.getNumerator(), denominator*other.getDenominator());
    hello.reduce();
    return hello;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber one = new RationalNumber(numerator*other.getDenominator(), denominator*other.getDenominator());
    RationalNumber two = new RationalNumber(other.getNumerator()*denominator, denominator*other.getDenominator());
    RationalNumber three = new RationalNumber(one.getNumerator()+two.getNumerator(), one.getDenominator());
    three.reduce();
    return three;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber one = new RationalNumber(numerator*other.getDenominator(), denominator*other.getDenominator());
    RationalNumber two = new RationalNumber(other.getNumerator()*denominator, denominator*other.getDenominator());
    RationalNumber three = new RationalNumber(one.getNumerator()-two.getNumerator(), one.getDenominator());
    three.reduce();
    return three;
  }
}
