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
		} else if (month > 7) {
			if (month % 2 == 0) {
				return 31;
			} else {
				return 30;
			}
		} else if (month == 2) {
			return 28;
		}
		return 0;
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		System.out.print("월 입력: ");
		int month = kb.nextInt();
		kb.close();

		if (month < 1 || month > 12) {
			System.out.println("1 ~ 12 사이 숫자를 입력해주세요.");
		} else {
			Calender calender = new Calender();
			int maxDay = calender.getMaxDayOfMonth(month);
			System.out.println(maxDay);
		}

	}

}
