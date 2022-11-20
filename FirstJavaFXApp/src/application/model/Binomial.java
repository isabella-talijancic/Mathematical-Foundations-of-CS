package application.model;

import java.util.Scanner;

public class Binomial
{
    public static int[] integers(int integer)
    {
    	int i;
    	
        int[] number = new int[integer+1];
        
        for( i = 0; i < number.length; i++ )
        {
        	
            number[i] = calculation(integer,i);
        
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

        String powerExponent ="(x+y)^"+ ( integer2.length-1 ) + " = ";
        
        int powerOfX = integer2.length - 1;
        
        int powerOfY = 0;
        
        for( j = 0; j < integer2.length; j++ )
        {
        	
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
        
        return powerExponent.substring( 0,powerExponent.length()-2 );

    }

    
    public static void conversion() {


        Scanner scanner = new Scanner(System.in);
        
        boolean launch = true;
        
        int userInput;
        
        System.out.print("Please enter your power variable for the 'n' -- \nremember that input for 'n' should be an integer of n(1<n<10): "); 
        
        userInput = scanner.nextInt();
        
        if ( launch = true )
        	
        {
        	
        	System.out.println("\nUsing the formula (x + y)^n, the expansion is: ");
        	
        	System.out.println(binomialTheoremFullExpansion(integers(userInput)));
        	
        	//launch = false;
        	//make try another? Button for below? 
            //System.out.print("Please enter your power variable for the 'n'! ");  power = scanner.nextInt();
      
        }
        
        ///launch = false;
    }
}