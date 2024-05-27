package codingMay;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input:");
		int num = sc.nextInt();
		int rev = 0;
		int orignal = num;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		if (orignal == rev) {
			System.out.println(orignal + " number is palindrom:");
		} else {
			System.out.println(rev + " number is not palindrom");
		}
	}
}
