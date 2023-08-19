package playground;

import java.util.Scanner;

public class Calender {

	private int getMaxDayOfMonth(int month, int year) {

		// 윤년 포함
		if (month <= 7 && month >= 3 || month == 1) {
			if (month % 2 == 0) {
				return 30;
			} else {
				return 31;
			}
		} else if (month > 7 && month <= 12) {
			if (month % 2 == 0) {
				return 31;
			} else {
				return 30;
			}
		} else if (month == 2) {
			if (year % 4 == 0 && (year != 100 || year % 400 == 0)) {
				return 29;
			} else {
				return 28;
			}
		}
		return -1;
	}

	public void printCalender(int year, int month) {
		System.out.printf("%n %10d년 %d월 %n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		int maxDay = getMaxDayOfMonth(month, year);
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		Calender calender = new Calender();

		System.out.print("년 입력: ");
		int year = kb.nextInt();

		System.out.print("월 입력: ");
		int month = kb.nextInt();

		if (calender.getMaxDayOfMonth(month, year) == -1) {
			System.out.println("1 ~ 12 사이 숫자를 입력해주세요.");
		} else {
			calender.printCalender(year, month);
		}

		kb.close();
	}

}
