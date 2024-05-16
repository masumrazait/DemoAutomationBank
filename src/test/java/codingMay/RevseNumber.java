package codingMay;

import java.util.Scanner;

public class RevseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word:");
		String input = sc.nextLine();
		String rev = "";
		int len = input.length();
		for (int i = len-1; i >= 0; i--) {
			rev = rev + input.charAt(i);
		}
		System.out.println(rev);
	}

}
