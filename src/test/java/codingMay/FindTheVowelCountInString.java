package codingMay;

import java.util.Scanner;

public class FindTheVowelCountInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string:");
		String input = sc.nextLine().toLowerCase();
		String vowel = "aeiouAEIOU";
		int count = 0;
		for (char c : input.toCharArray()) {
			if (vowel.indexOf(c) != -1) {
				count++;
				System.out.println(c);
			}
		}System.out.println(count);
	}
}