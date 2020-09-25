package math.gcd;

public class Solution {
	public static void main(String[] args) {
		Rational p = new Rational(1, 2);
		Rational q = new Rational(3, 10);
		System.out.println("p = " + p); // p = 1/4
		System.out.println("q = " + q); // q = 3/4
		System.out.println("p + q = " + p.plus(q)); // p + q = 1
		System.out.println("p * -q = " + p.times(q.negate())); // p * -q = -3/16 
		
		Rational x = new Rational(1, 2);
		Rational y = new Rational(2, 3);
		Rational z = new Rational(3, 5);
		
		RationalSet a, b, c;
		a = new RationalSet();
		a.insert(x); a.insert(y);
		b = new RationalSet(a);
		b.insert(z);
		System.out.println("A = " + a); // {1/2, 2/3}
		System.out.println("B = " + b); // {1/2, 2/3, 3/5}
		System.out.println("A * B = " + a.intersection(b)); // {1/2, 2/3}
		System.out.println("A + B = " + a.union(b)); // {1/2, 2/3, 3/5}
		System.out.println("A - B = " + a.subtract(b)); // {}
		System.out.println("B - A = " + b.subtract(a)); // {3/5}
		System.out.println("A < B ? " + a.isSubsetOf(b)); // true 
		System.out.println("A < B ? " + b.isSupersetOf(a)); // true
		System.out.println("A = B ? " + b.isEqual(a)); // false
	}
}
