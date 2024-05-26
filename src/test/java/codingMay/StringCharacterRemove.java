package codingMay;

public class StringCharacterRemove {

	public static void main(String[] args) {
		String input="s1s2s@@@!!%%^3S2";
		String rmv=input.replaceAll("[^a-zA-Z]","");
		System.out.println(rmv);
	}
}
