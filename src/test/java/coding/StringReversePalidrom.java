package coding;

import java.util.Scanner;

public class StringReversePalidrom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the userinput: ");
		String userinput = sc.nextLine();
		String rev = "";
		String oring = userinput;
		int len = userinput.length();
		for (int i = len - 1; i >= 0; i--) {
			rev = rev + userinput.charAt(i);
		}
		if (oring.equalsIgnoreCase(rev)) {
			System.out.println(oring + " is parlindrome");
		} else {
			System.out.println(rev + " is not palindrome");
		}
	}
}
