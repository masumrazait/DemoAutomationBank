package codingMay;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input:");
		int num = sc.nextInt();
		int rev = 0;
		int orign = num;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		if (orign == rev) {
			System.out.println(orign + " number is palindrom");
		} else {
			System.out.println(rev + " number is not palindrom");
		}
	}
}
