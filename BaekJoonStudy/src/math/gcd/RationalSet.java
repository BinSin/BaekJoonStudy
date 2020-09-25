package math.gcd;

import java.util.ArrayList;

public class RationalSet { 
	
	private ArrayList<Rational> array;
	
	//construct an empty set 
	public RationalSet() {
		array = new ArrayList<Rational>();
	}
	
	//construct a set with initial elements 
	public RationalSet(Rational... nums) {
		array = new ArrayList<Rational>();
		for(Rational num : nums)
			array.add(num);
	}
	
	//copy constructor 
	public RationalSet(RationalSet s) {
		array = (ArrayList<Rational>)s.array.clone();
	}
	
	//remove all the elements 
	public void empty() {
		array = new ArrayList<Rational>();
	}
	
	//return the number of elements 
	public int count() {
		return array.size();
	}
	
	//insert a number into the set 
	public void insert(Rational num) {
		array.add(num);
	}
	
	//delete the number from the set 
	public void delete(Rational num) {
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).equals(num)) {
				array.remove(i);
				break;
			}
		}
	}
	
	//return true if the number is an element of the set 
	public boolean hasElement(Rational num) {
		for(int i=0; i<array.size(); i++) {
			if(array.get(i).equals(num)) { // num 이 포함되어 있으면 true
				return true;
			}
		}
		return false; // 없으면 false
	}
	
	//return true if "this" is a superset of "s" 
	public boolean isSupersetOf(RationalSet s) {
		for(int i=0; i<s.count(); i++) {
			if(!this.hasElement(s.array.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	//return true if "this" is a subset of "s" 
	public boolean isSubsetOf(RationalSet s) {
		for(int i=0; i<this.count(); i++) {
			if(!s.hasElement(this.array.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	//return true if two sets "this" and "s" are the same 
	public boolean isEqual(RationalSet s) {
		if(this.isSupersetOf(s) && this.isSubsetOf(s))
			return true;
		else
			return false;
	}
	
	//return the union of two sets (this \cup s) 
	public RationalSet union(RationalSet s) {
		RationalSet ratSet = new RationalSet(this);
		for(int i=0; i<s.count(); i++) {
			Rational rat = s.array.get(i);
			if(!this.hasElement(rat)) {
				ratSet.insert(rat);
			}
		}
		
		return ratSet;
	}
	
	//return the intersection of two sets (this \cap s) 
	public RationalSet intersection(RationalSet s) {
		RationalSet ratSet = new RationalSet();
		for(int i=0; i<s.count(); i++) {
			Rational rat = s.array.get(i);
			if(this.hasElement(rat)) {
				ratSet.insert(rat);
			}
		}
		
		return ratSet;
	}
	
	//return the set difference (this \ s) 
	public RationalSet subtract(RationalSet s) {
		RationalSet ratSet = new RationalSet(this);
		for(int i=0; i<s.count(); i++) {
			Rational rat = s.array.get(i);
			if(this.hasElement(rat)) {
				ratSet.delete(rat);
			}
		}
		
		return ratSet;
	}
	
	//return the string of the set in {...} notation // {1/2, 2/3, 3/4}, {} 
	public String toString() {
		String s = "";
		for(int i=0; i<this.count(); i++) {
			s += this.array.get(i).toString();
			if(i != this.count() - 1) s += ", ";
		}
		return "{" + s + "}";
	}
}
