	// Implements algebraic operations and the square root function without using 
	// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
	// Math.sqrt. All the functions in this class operate on int values and
	// return int values.

	public class Algebra {
		public static void main(String args[]) {
			
			System.out.println(plus(2,3));   // 2 + 3
			System.out.println(minus(7,2));  // 7 - 2
			System.out.println(minus(2,7));  // 2 - 7
			System.out.println(times(3,4));  // 3 * 4
			System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
			System.out.println(pow(5,3));      // 5^3
			System.out.println(pow(3,5));      // 3^5
			System.out.println(div(12,3));   // 12 / 3    
			System.out.println(div(5,5));    // 5 / 5  
			System.out.println(div(25,7));   // 25 / 7
			System.out.println(mod(25,7));   // 25 % 7
			System.out.println(mod(120,6));  // 120 % 6    
			System.out.println(sqrt(36));
			System.out.println(sqrt(263169));
			System.out.println(sqrt(76123));
			
		}  

		// Returns x1 + x2
		public static int plus(int x1, int x2) {
			int sum = x1;
			while (x2 > 0){
				sum ++;
				x2 --;
			}
			while (x2 < 0){
				sum --;
				x2 ++;
			}
			return sum;
		}

		// Returns x1 - x2
		public static int minus(int x1, int x2) {
			int sum = x1;
			while (x2 > 0){
				sum --;
				x2 --;
			}
			while (x2 < 0){
				sum ++;
				x2 ++;
			}
			return sum;
		}
		
		// returns the absolute value of x
		public static int abs(int x) {
			if (x < 0) {
				return minus(0, x);
			}
			else {
				return x;
			}
		}
		// Returns x1 * x2
		public static int times(int x1, int x2) {

			if (x1 == 0 || x2 == 0) { //handle the case where one of the numbers is 0
				return 0;
			}

			int x1Abs = abs(x1);  
			int x2Abs = abs(x2);   
			int result = 0;

			for (int i = 0; i < x2Abs; i++) {
				result = plus(result, x1Abs); 
			}
		
			if ((x1 < 0) != (x2 < 0)) {
				result = minus(0, result); // flip sign if one of the numbers is minus
			}
		
			return result;
		}
		
		// Returns x^n (for n >= 0)
		public static int pow(int x, int n) {
			int powCalc = x;
			if (n == 0) {
				return 1;
			}
			for (int i = 1; i < n;  i++) {
				powCalc = times(powCalc, x);
			}
			return powCalc;
		}

		// Returns the integer part of x1 / x2 
		public static int div(int x1, int x2) {
			if (x2 == 0) { 
				System.out.println("Error: Division by zero. Returning -1.");
				return (-1); // division by 0
			}

			if (x1 == 0) {
				return 0; 
			}
		
			int divCalc = 0; 
			int x1Abs = abs(x1);
			int x2Abs = abs(x2);

			while (x1Abs >= x2Abs) {
				x1Abs = minus(x1Abs, x2Abs);
				divCalc++;
			}
			if ((x1 < 0) != (x2 < 0)) {
				divCalc = minus(0, divCalc); // flip sign if one of the numbers is minus
			}
			return divCalc;
		}

		// Returns x1 % x2
		public static int mod(int x1, int x2) {
			if (x2 == 0) { 
				System.out.println("Error: Division by zero. Returning -1.");
				return (-1); // division by 0
			}
			
			int x1Abs = abs(x1);
			int x2Abs = abs(x2);
			int divCalc = div(x1Abs, x2Abs);
			int modCalc = minus(x1Abs, times(divCalc, x2Abs));
			
			if ((x1 < 0) != (x2 < 0)) {			
				modCalc = minus(0, modCalc);  // flip sign if one of the numbers is minus
			}
		
			return modCalc;
		}	

		// Returns the integer part of sqrt(x) 
		public static int sqrt(int x) {
			if (x < 0) {
				System.out.println("Error: Division by zero. Returning -1.");
				return (-1);
			}
			
			if (x == 0 || x == 1) {
				return x;
			}
			int L = 0, H = x;
			int g = 0;
			int prevG = 0;

			while (L <= H) {
				g = div(plus(L, H),2);

				int squareOfG = pow(g, 2);

				if (squareOfG == x) {
					return g;  
				} else if (squareOfG < x) {
					prevG = g;
					L = plus(g, 1);  
				} else {
					H = minus(g, 1);  
				}
			}

			return prevG;  
		}
		
	}