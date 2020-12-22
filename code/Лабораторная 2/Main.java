package task02;

import java.util.Random;

public class Main {
	//final Random random = new Random();
	public static void main(String[] args) {
		Random random = new Random();
		int num1 = random.nextInt(10001);
		int num2 = random.nextInt(10001);
		gcdTable(num1, num2, gcd(num1, num2));
	}
	public static void gcdTable(int firstNum, int secondNum, int gcd) {
		String leftAlignFormat = "| %-10d | %-10d | %-9d |%n";

		System.out.format("+------------+------------+-----------+%n");
		System.out.format("| First num  | Second num | GCD       |%n");
		System.out.format("+------------+------------+-----------+%n");		
		System.out.format(leftAlignFormat, firstNum, secondNum, gcd);
		System.out.format("+------------+------------+-----------+%n");
	}
	public static int gcd(int firstNum, int secondNum) {
		int lowest = firstNum;
		if(secondNum < firstNum) lowest = secondNum;
		for(int i = lowest-1; i > 0; i--) {
			if(firstNum%i == 0 && secondNum%i == 0) return i;
		}
		return 1;
	}
}
