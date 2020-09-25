package math.gcd;

public class Rational {

	private final int num;
	private final int den;
	
	//construct a rational number
	public Rational(Rational b) {
		num = b.num;
		den = b.den;
		
	}
	public Rational(int numerator, int denominator) {
		if (denominator == 0)
		denominator = 1;
		
		if (denominator <0)
		{
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		
		
		if (numerator != 0)
	      {
	         int common = gcd (numerator, denominator);

	         numerator = numerator / common;
	         denominator = denominator / common;
	      }
		
		this.num = numerator;
		this.den = denominator;
	}
	
	//return gcd (|m|, |n|)
	private static int gcd(int m, int n) {
		m = Math.abs(m);
		n = Math.abs(n);
		return (n == 0) ? m : gcd(n, m%n);
	}

	//return a new rational number (this + b)
	public Rational plus(Rational b) {
		int commonDen = this.den * b.den;
	    int num1 = this.num * b.den;
	    int num2 = b.num * this.den;
	    int sum = num1 + num2;
		
		return new Rational (sum, commonDen);
	}
	
	//return a new rational number ( this)
	public Rational negate() {
		
		return new Rational (-num, den);
	}
	
	//return a new rational number (this b)
	public Rational minus(Rational b) {
		int commonDen = this.den * b.den;
	    int numerator1 = this.num * b.den;
	    int numerator2 = b.num * this.den;
	    int difference = numerator1 - numerator2;

	    return new Rational (difference, commonDen);
	}
	
	//return a new rational number (this * b)
	public Rational times(Rational b) {
		int numer = this.num * b.num;
	    int denom = this.den * b.den;

	    return new Rational (numer, denom);
	}
	
	//return a new rational number (1 / this)
	public Rational reciprocal() {
		
		return new Rational (den, num);
	}
	//return a new rational number (this / b)
	public Rational divides(Rational b) {
		
		return times (b.reciprocal());
	}
		
	//return a string representation of a rational number: 2/3
	public String toString() {
		String result;

	      if (num == 0)
	         result = "0";
	      else
	         if (den == 1)
	            result = num + "";
	         else
	            result = num + "/" + den;
	    
	      return result;
	}
	//return true if two rational numbers are the same
	public boolean equals(Object otherObject) {
		if (otherObject == null || !this.getClass().isAssignableFrom(otherObject.getClass())) 
		{
			return false;
		}

		final Rational other = (Rational) otherObject;
		return this.num == other.num && this.den == other.den;
		
	}
		
	//return a hashcode
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.num;
		result = prime * result + this.den;
		
		return result;
	}
}