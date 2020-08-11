import java.util.Arrays;

public class MaxToy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int payAmt = 25; 
		int cost[] = {1, 10, 5, 3, 0}; 
		int costLen = cost.length; 
		  
		System.out.print( maxToys(cost, costLen, payAmt));
	}

	
	
	private static int maxToys(int[] cost, int costLen, int payAmt) {
		int count = 0, sum = 0; 	  
	     
	    Arrays.sort(cost); 
	    for (int i = 0; i < costLen; i++)     { 
	  
	          
	        if (sum +cost[i] <= payAmt)  
	        { 
	            sum = sum + cost[i];
	             
	            count++; 
	        } 
	    } 
	    return count; 		
		
	}

}
