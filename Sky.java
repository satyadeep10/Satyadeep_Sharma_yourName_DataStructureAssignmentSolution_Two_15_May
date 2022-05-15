package com.gl.gradedproject2.dsa.gradedassignment;

import java.util.*;
public class Sky 
{
    private static Scanner sc;
    public static int number_of_floors;
    
    
    static class StackImplement
    
    {
    	int a[]=new int[number_of_floors];
        int current_pointer;
        
    	StackImplement ()
    	{
    	 current_pointer=-1;
    	}
   
    	boolean push(int x) 
    	{
    		if (current_pointer >= (number_of_floors - 1)) 
    		{
    			return false;
    		}
    		else 
    		{	
    		a[++current_pointer]=x;
    		return true;
    		}
    	}
    	
    	int pop()
    	{
    		if (current_pointer< 0) 
    	{
    		
    		return 0;
    	}
    	else 
    	{
    		int x = a[current_pointer --];
    		return x;
    	}
      }
    	
    	int peek()
    	{
    		if (current_pointer< 0) 
    	{
    		
    		return 0;
    	}
    	else 
    	{
    		int x = a[current_pointer];
    		return x;
    	}
      }

    	
    	void sortStack() 
    	{
    		for(int i=0;i<=current_pointer;i++) 
    		{
    			for (int j=1;j<=(current_pointer-i);j++)  
    			{
	    			if(a[j-1] > a[j]) 
	    			{
	    				int temp=a[j-1];
	    				a[j-1]=a[j];
	    				a[j]=temp;
	    			}
	    			
    			 }
    		   }
    		
    	}
    	
    	public int[] sortFloorsize(int[] size) 
    	{
    		int k;
    		int j;
    		
    		for(k=0;k<size.length;k++) 
    		{
    			for (j=1;j<(size.length-k);j++)  
    			{
	    			if(size[j-1] > size[j]) 
	    			{
	    				int temp=size[j-1];
	    				size[j-1]=size[j];
	    				size[j]=temp;
	    			}
	    			
    			 }
    		   }
			return size;
    		
    	}

    	
    	void printStack()
    	{

    		for(int i=current_pointer;i>-1;i--)
    		{
    			
    			System.out.print(pop()+" ");
    		}
    	}
    }

	public static void main(String args[])  
	{
        sc = new Scanner(System.in); 
        System.out.println("Enter the total number floors in the building : ");
        
        number_of_floors = sc.nextInt();
        int floor_size[] = new int[number_of_floors];
        try {
        for(int i=0;i<number_of_floors;i++)
        {
            System.out.println("Enter the floor size given on day : "+(i+1));
            int m=sc.nextInt();
            
            if (m < 1) 
            {
            	System.out.println("Floor size with  "+ m + " is not valid value " + "\n");
            	i--;
            }
            
            else 
            {
            floor_size[i]=m;
            }
        } 
        }
        catch (Exception e)
           {
        	System.out.println("Exception is : "+ e);
           }
       
        
        
        StackImplement si = new StackImplement();
        boolean flag;
        System.out.println("The order of construction is as follows ");
        for(int i=0;i<number_of_floors;i++)
        {
        	flag=false;
        	int counter=0;
            int j=number_of_floors;
            System.out.print("Day "+(i+1)+" : ");
            while(j>=1 && floor_size[i]>=floor_size[j-1] && i<= (j-1))
            {
                	flag=true;

                if((j-1)>-1) 
            	{
            	j--;
            	} 
                
            }
            if(flag==true && (j)==i && (j)!=(floor_size.length-1))
            {
            System.out.print(floor_size[i]+" ");
              
            
            if (si.current_pointer > 0)  
            {
            si.sortStack();
            } 
            
            int[] floor_two=new int[number_of_floors-(i+1)];
            
            
            for(int k=0;k<floor_two.length;k++) 
            {
            	floor_two[k]=floor_size[i+1];
            	i++;
            	counter++;
            }
            i=i-counter;
   
            si.sortFloorsize(floor_two);
             
            while((i)<floor_size.length && si.peek()>floor_two[floor_two.length-1] && si.current_pointer>-1 )
                {
                	System.out.print(si.pop()+" ");
                	
                }

           
            }
            
            if(flag==true && (j)==i && (j)==(floor_size.length-1))
            {
            
            	System.out.print(floor_size[i]+" ");
            	//si.push(floor_size[i]);
            
            }
            if(flag==true && (j)!=i && (j)<(floor_size.length-1) && j>=i)
            {
            	si.push(floor_size[i]);
            
            }
            if(flag==true && (j)!=i && (j)==(floor_size.length-1) && j>=i)
            {
            si.push(floor_size[i]);
            
            }
          
            System.out.println("\n");
            
            if(i==(number_of_floors-1)) 
            {
            	si.sortStack();
            	si.printStack();
            }
            
            if(flag==false)
            {
            	
            	System.out.println();
                int x=floor_size[i];
                si.push(x);
                
            }
            
        }
        
    }
}