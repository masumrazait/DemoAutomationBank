package coding;

public class LeapYear {

	public static void main(String[] args) {
		int arr[] = { 2012, 2023, 2024, 2019, 2016, 2026, 2018, 2032 };
		for (int year : arr) {
			if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
				System.out.println(year + " year is leap");
			} else {
				System.out.println(year + " year is common");
			}
		}
	}
}
