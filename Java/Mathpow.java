class Mathpow {

	// Naive iterative solution to calculate pow(x, n)
	public static long power(int x, int n)
	{
		// Initialize result by 1
		long pow = 1L;

		// Multiply x for n times
		for (int i = 0; i < n; i++) {
			pow = pow * x;
		}

		return pow;
	}

	/* Program to test function power */
	public static void main(String[] args)
	{
		float x = 2;
		int n = 3;
		System.out.printf("%f", power(x, y));
	}
};
