package coding;

public class StringReverse {

	public static void main(String[] args) {
		String input="MasumRaza";
		String rev="";
		int len=input.length();
		for(int i=len-1;i>=0;i--) {
			rev=rev+input.charAt(i);
		}
		System.out.println(rev);
	}

}
