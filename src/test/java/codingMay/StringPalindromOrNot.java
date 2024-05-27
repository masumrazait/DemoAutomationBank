package codingMay;

public class StringPalindromOrNot {

	public static void main(String[] args) {
		String input = "jahaj";
		int len = input.length();
		String rev = "";
		String orignal = input;
		for (int i = len - 1; i>=0; i--) {
			rev = rev + input.charAt(i);
		}
		if(orignal.equalsIgnoreCase(rev)) {
			System.out.println(orignal+" String is palindrom");
			
		}else {
			System.out.println(rev+" String is not palindrom");
		}
	}

}
