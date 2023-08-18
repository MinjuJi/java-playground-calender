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
		return -1;
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		Calender calender = new Calender();

		System.out.print("반복 횟수 입력: ");
		int repeat = kb.nextInt();

		for (int i = 0; i < repeat; i++) {

			System.out.print("월 입력: ");
			int month = kb.nextInt();

			if (calender.getMaxDayOfMonth(month) == -1) {
				System.out.println("1 ~ 12 사이 숫자를 입력해주세요.");
			} else {
				int maxDay = calender.getMaxDayOfMonth(month);
				System.out.println(maxDay + " ");
			}

		}
		kb.close();
	}

}
