package seleniumPractices;

public class OddEvenFromArray {

	public static void main(String[] args) {
		int ar[] = { 213, 4343, 656565, 87878, 65, 45, 756, 86786, 4345, 89686, 57758, 655653, 33643, 7568, 86786, 434,
				3523 };
		for (int num : ar) {
			if (num % 2 == 0) {
				System.out.println(num + " is even number");
			}
		}
	}
}
