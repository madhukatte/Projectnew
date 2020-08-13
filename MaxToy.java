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

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		int payAmt = stdin.nextInt();
		int toycost[] = { 5, 1, 3, 2, 8 };
		int costLen = toycost.length;
		// Available toys
		int availableToys[] = new int[toycost.length];
		for (int i = 0; i < availableToys.length; i++) {
			availableToys[i] = stdin.nextInt();
		}

		// Map<Integer, Integer> toysAvailableMap =
		System.out.print("maxtoys purchased--" + maxToys(toycost, costLen, payAmt, buildMap(availableToys)));
	}

	private static Map buildMap(int[] toyCost) {

		Map<Integer, Integer> createMap = new HashMap<>();

		for (int i = 0; i < toyCost.length; i++) {

			createMap.put(Integer.valueOf(i), Integer.valueOf(toyCost[i]));

		}
		Map<Integer, Integer> sortedMap = (Map<Integer, Integer>) createMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return sortedMap;
	}

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
