import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxToy {

	/**Main method max toys program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
        // max amount for purchase
		int payAmt = stdin.nextInt();
		//cost of toys
		int toycost[] = { 5, 1, 3, 2, 8 };
		int costLen = toycost.length;
		// Available toys
		int availableToys[] = new int[toycost.length];
		
		//quantity of each toys initiatized
		for (int i = 0; i < availableToys.length; i++) {
			availableToys[i] = stdin.nextInt();
		}

		
		System.out.print("maxtoys purchased--" + maxToys(toycost, costLen, payAmt, buildMap(availableToys)));
	}

	
	/**
	 * Method to create Map for available toys
	 * @param toyCost
	 * @return
	 */
	private static Map<Integer, Integer> buildMap(int[] toyCost) {

		Map<Integer, Integer> createMap = new HashMap<>();

		for (int i = 0; i < toyCost.length; i++) {

			createMap.put(Integer.valueOf(i), Integer.valueOf(toyCost[i]));

		}
		
		//sorted the Toys quantity 
		Map<Integer, Integer> sortedMap = (Map<Integer, Integer>) createMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return sortedMap;
	}

	
	/**
	 * logic to sort cost of toys  and calculate max purchased toys for specified amount
	 * @param cost
	 * @param costLen
	 * @param payAmt
	 * @param toysAvailableMap
	 * @return
	 */
	private static int maxToys(int[] cost, int costLen, int payAmt, Map<Integer, Integer> toysAvailableMap) {
		int count = 0, sum = 0, tempAmount = 0, quantity = 0, purchasedQuantity = 0, newQuantity;
		Arrays.sort(cost);
		Iterator<Map.Entry<Integer, Integer>> costMapIterator = toysAvailableMap.entrySet().iterator();
		while (costMapIterator.hasNext()) {

			quantity = (Integer) costMapIterator.next().getValue();

			tempAmount = cost[count] * quantity;

			if (sum + tempAmount <= payAmt) {
				purchasedQuantity = purchasedQuantity + quantity;
				

			} else {

				newQuantity = (payAmt - sum) / cost[count];

				tempAmount = cost[count] * newQuantity;

				purchasedQuantity = purchasedQuantity + newQuantity;

			}

			sum = sum + tempAmount;

			if (sum == payAmt || tempAmount == 0) {

				break;

			}
			count++;
		}

		return purchasedQuantity;

	}

}
