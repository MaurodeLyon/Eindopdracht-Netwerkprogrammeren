package recursion;

public class Optellen {

	public static void main(String[] args) {
		startTellen(10);
	}

	private static void startTellen(int tot) {
		int cijfer = 0;
		telOp(cijfer, tot);
	}

	private static int telOp(int cijfer, int tot) {
		System.out.println(cijfer);
		if (cijfer == tot) {
			return cijfer;
		} else {
			return telOp(cijfer += 1, tot);
		}

	}
}
