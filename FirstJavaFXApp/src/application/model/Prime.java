package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Prime is a Java class that will represent a Prime object, which has been
 * defined as having int a & b.
 * 
 * @author Isabella Talijancic (juu530)
 * UTSA CS 3333 - Project
 * Fall 2022
 */


public class Prime {
	
	// a & b represented as a int
	private int a,b;
	
	/**
	 * Class constructor for the Prime class to initialize a new Prime object with a & b.
	 * 
	 * @param a
	 * @param b
	 */
	
	public Prime(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Setting the prime a variable, takes in int a as a parameter, and returns nothing.
	 * 
	 * @param int a
	 */
	public void setA(int a) {
		this.a = a;
	}
	
	/**
	 * Getting the prime a variable instance, returns a.
	 * 
	 * @return a
	 */
	public int getA() {
		return this.a;
	}
	
	/**
	 * Setting the prime b variable, takes in int b question as a parameter, and returns nothing.
	 * 
	 * @param int b
	 */
	public void setB(int b) {
		this.b = b;
	}
	
	/**
	 * Getting the prime b variable instance, returns b.
	 * 
	 * @return b
	 */
	public int getB() {
		return this.b;
	}
	
	public static int gcdMethod (int a, int b) {
		//checks whether a,b are positive/negative
	    a = ( a > 0) ? a : -a;
	    b = ( b > 0) ? b : -b;

	    while(a != b) {
	        
	      if(a > b) {
	        a -= b;
	      }
	      
	      else {
	        b -= a;
	      }
	    }
	    return a;
	}
	
	public static int lcmMethod (int a, int b) {
		//lcm defined as the largest number between int a & b
	    int lcm = (a > b) ? a : b;

	    while(true) {
	      if( lcm % a == 0 && lcm % b == 0 ) {
	        break;
	      }
	      ++lcm;
	    }
	    return lcm;
	}
	
	public static int primeAMethod (int a) {
		System.out.print("\nPrime Factors of " + a + ": ");
		int i = 2;
        while (a > 1) {
            if (a % i == 0) {
                System.out.print(i + " ");
                a /= i;
                return i;
            }
            else
                i++;
        }
        return i;
	}
	
	public static int primeBMethod (int b) {
		System.out.print("\nPrime Factors of " + b + ": ");
		int i = 2;
        while (b > 1) {
            if (b % i == 0) {
                System.out.print(i + " ");
                b /= i;
            }
            else
                i++;
        }
        return i;
	}
	
	//toString() method
	public String toString() {
		String ret = "Prime Factors of " + this.getA() + ": " + primeAMethod(a);
		ret += "\nPrime Factors of " + this.getB() + ": " + primeBMethod(b);
		ret += "\nGCD(" + this.getA() + "," + this.getB() + "): " + gcdMethod(a,b);
		ret += "\nLCM(" + this.getA() + "," + this.getB() + "): " + lcmMethod(a,b);
		
		return ret;
	}

}
