package playground;

import java.util.Scanner;

public class Calender {

	private int getMaxDayOfMonth(int month) {

		// 윤년 제외
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
			return 28;
		}
		return -1;
	}

	public void printCalender(int year, int month) {
		System.out.println("\n" + "     " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		int maxDay = getMaxDayOfMonth(month);
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
		String PROMPT = "cal> ";

		System.out.print("월 입력: ");
		System.out.print(PROMPT);
		int month = kb.nextInt();

		if (calender.getMaxDayOfMonth(month) == -1) {
			System.out.println("1 ~ 12 사이 숫자를 입력해주세요.");
		} else {
			calender.printCalender(2023, month);
		}

		kb.close();
	}

}
