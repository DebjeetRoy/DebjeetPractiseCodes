package om.dev.bitManipulation;

public class XORqueries {
	public static int[] xorQueries(int[] arr, int[][] queries) {
		// You can code here
		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			// for(int j=0; queries[i].length; j++){
			int first = queries[i][0];
			int second = queries[i][1];

			int res = 0;
			while (first <= second) {
				res = res ^ arr[first];
				ans[i] = res;
				first++;
			}
			// }
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 9, 11 };
		int[][] queries = { { 0, 2 }, { 1, 3 } };

		int[] res = xorQueries(arr, queries);

		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}
}
