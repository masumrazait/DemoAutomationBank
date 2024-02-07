package seleniumPractices;

public class LeapYearFromArray {

	public static void main(String[] args) {
		int ar[] = { 2022, 2023, 2024, 2020, 2018, 2028, 2026 };
		for (int year : ar) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
				System.out.println(year + " is leap year");
			}
		}
	}
}
