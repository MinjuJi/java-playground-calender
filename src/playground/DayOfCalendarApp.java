// 프로그램: 연도와 월을 입력 받아 [일요일 ~ 월요일] 순의 달력 생성 프로그램 

package playground;

import java.util.Scanner;

public class DayOfCalendarApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("연도 입력 : ");
		int year = sc.nextInt();

		System.out.print("월 입력 : ");
		int month = sc.nextInt();

		DayOfCalendar.prn(year, month);

		sc.close();
	}
}
