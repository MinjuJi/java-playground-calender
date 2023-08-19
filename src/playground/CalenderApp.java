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