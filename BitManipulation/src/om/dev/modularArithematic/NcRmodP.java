package om.dev.modularArithematic;

public class NcRmodP {
	public static int nCr(int n, int r) {
		return AddSubMulDiv.multm(AddSubMulDiv.multm(fact(n), AddSubMulDiv.inverse(fact(n - r))),
				AddSubMulDiv.inverse(fact(r)));
	}

	public static int fact(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res = AddSubMulDiv.multm(res, i);
		}
		return res;
	}

	public static void main(String[] args) {
		// System.out.println(fact(5));
		System.out.println(nCr(5000, 100));
	}
}
