package coding;

public class EvenLetterPrintFromString {

	public static void main(String[] args) {

		String input = "MasumRaza".toUpperCase();
		// for printing odd letter
		// for (int i = 0; i < input.length(); i += 2) {

		// printing even letter
		for (int i = 1; i < input.length(); i += 2) {
			System.out.print(input.charAt(i));
		}
	}
}
