package coding;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = 12321;
		int o = num;
		int rev = 0;
		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		if (o == rev) {
			System.out.println(o + " num is palindrome");
		} else {
			System.out.println(rev + " num is not palindrome");
		}
	}

}
