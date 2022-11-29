package application.model;

import java.util.Scanner;

public class Binomial
{
	
	private int n;
	
	public Binomial(int n) 
	
	{
		
		this.n=n;
	
	}
	
	public void setN(int n) 
	
	{
		
		this.n = n;
	
	}
	
	public int getN() 
	
	{
		
		return this.n;
	}
	
	public static String doMath( int n ) 
	
	{
		String retThis = "";
		
		for( int j = 0; j <= n; j++ )
		{
			//checking to make sure that n is within specified range of 2 and 9. 
			
			if ( n > 1 && n < 10)
				
			{
				
				retThis += ("("+( ( j == 0 || j == n ) ? "" : numbers ( n, j ) ) 
				+ ( ( j == n ) ? "" : "x^" + ( n - j ) ) + ( ( j == 0 ) ? "" : "y^" + j ) + ")" + 
				( ( j != n ) ? " +\n" : "" ) );
			
			}
			
			else
				retThis = "Please Try Again!";
			
		}
			return retThis.toString();
			
		//return ret;
	}
	
	public static int numbers( int n, int j )
	
	{
		
	    int largeInt = 1;
	    
	    for ( int i = 0; i < j; i++ )
	    	
	    {
	    	
	    	int lessThan = n - i;
	    	
	    	int greaterThan = i + 1;
	    	
	    	largeInt = ( largeInt * ( lessThan ) /* + 1 */ ) / ( ( greaterThan ) );
	    	
	    }
	    
	    return largeInt;
	
	}
	
    public static int[] integers( int integer )
    
    {
    	int i;
    	
        int[] number = new int[integer + 1];
        
        for( i = 0; i < number.length; i++ )
        {
        	
            number[i] = calculation( integer, i );
        
        }
        
        return number;
    }
    
    private static int calculation(int rows, int columns)
    {
        if( ( rows + 1 ) == 1 || ( columns + 1 ) == 1 || rows == columns )
        {
        	
        	//System.out.println("\nCalculation has failed!");
        	
            return 1;
        
        }
        
        else
        {
        	
            return calculation( rows - 1, columns - 1 ) + calculation( rows - 1, columns );
        
        }
    }

    public static String binomialTheoremFullExpansion( int[] integer2 )
    {
    	int j;

        String powerExponent = "(x+y)^" + ( integer2.length - 1 ) + " = ";
        
        int powerOfX = integer2.length - 1;
        
        int powerOfY = 0;
        
        for( j = 0; j < integer2.length; j++ )
        {
        	//should add condition that integer2 should be between 2 and 9
        	//if (integer2.length < 2)
        	//{
        		
            if( integer2[j] !=1 )
            {
            	
            	powerExponent += integer2[j];
          
            }
            
            if( powerOfX > 1 ) 
            {
            	
            	powerExponent += "x^" + powerOfX;
           
            }
            
            else if( powerOfX == 1 ) 
            {
            	
            	powerExponent += "x";
         
            }
            
            if( powerOfY > 1) 
            {
            	
            	powerExponent += "y^" + powerOfY;
           
            }
            
            else if( powerOfY ==1 ) 
            {
            	
            	powerExponent += "y";
           
            }
            
            powerExponent += " + ";
            
            powerOfX = powerOfX - 1;
            
            powerOfY = powerOfY + 1;
            
        }
        	//}
        
        return powerExponent.substring( 0,powerExponent.length()-2 );

    }
    
    public static void newConversion(int n) {
    	while (n<1 && n<10) {
    		//do math stuff
    	}
    }
    
    public static void conversion() {


        Scanner scanner = new Scanner(System.in);
        
        //boolean launch = true;
        
        //int userInput;
        
        //System.out.print("Please enter your power variable for the 'n'; remember that input for 'n' should be an integer of n(1<n<10): "); 
        
        int userInput = scanner.nextInt();
        
        //if ( launch == true )
        	
        System.out.println("\nUsing the formula (x + y)^n, the expansion for " + binomialTheoremFullExpansion(integers(userInput)));
        	
        	//System.out.println(binomialTheoremFullExpansion(integers(userInput)));
        	
        	//launch = false;
        	//make try another? Button for below? 
            //System.out.print("Please enter your power variable for the 'n'! ");  power = scanner.nextInt();
      
        
        ///launch = false;
    }
    
    public String toString() {
    	String ret = "n is: " + this.getN();
    	
    	return ret;
    }
}