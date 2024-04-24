package com.greedy.algo;

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total_gas = 0, total_cost = 0;
		for (int i = 0; i < gas.length; i++) {
			total_gas += gas[i];
			total_cost += cost[i];
		}
		if (total_gas < total_cost)
			return -1;
		int start = 0;
		int tank_me_gas = 0;
		for (int i = 0; i < gas.length; i++) {
			tank_me_gas += gas[i];
			tank_me_gas -= cost[i];

			if (tank_me_gas < 0) {
				start = i + 1;
				tank_me_gas = 0;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
