// 프로그램: 연도와 월을 입력 받아 월요일 ~ 일요일 순의 달력 생성 프로그램 
// 가정: 1년 1월 1일은 일요일 
package playground;

import java.util.Scanner;

public class CalenderApp {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		while (true) {

			System.out.print("[생성]/[종료] 두 개 중 하나 입력: ");
			String input = kb.next();

			if (input.equals("생성")) {
				System.out.print("연도 입력 :");
				int year = kb.nextInt();

				System.out.print("월 입력 :");
				int month = kb.nextInt();

				CalenderMethod.print(year, month);
				System.out.println("\n");

			} else if (input.equals("종료")) {
				break;
			}
		}
		kb.close();
	}
}