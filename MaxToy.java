import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxToy {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int payAmt = stdin.nextInt();
		int cost[] = new int[5];
		//Assume 5 toys are available  and cost is initiatilized
		for (int i = 0; i < 5; i++) {
			cost[i] = stdin.nextInt();
		}		
		int costLen = cost.length;
		System.out.print("maxtoys--"+maxToys(cost, costLen, payAmt));
	}

	
	
	
	private static int maxToys(int[] cost, int costLen, int payAmt) {
		int count = 0, sum = 0;
		Arrays.sort(cost);
		for (int i = 0; i < costLen; i++) {
			if (sum + cost[i]  <= payAmt) {
				System.out.println("testing"+cost[i]);
				sum = sum + cost[i];
				count++;
			}
		}
		return count;

	}

}
