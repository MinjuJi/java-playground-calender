// 프로그램: 연도와 월을 입력 받아 [월요일 ~ 일요일] 순의 달력 생성 프로그램 
// 가정: 1년 1월 1일은 일요일 

package playground;

import java.util.Scanner;

public class scheduleApp {

	public static void main(String[] args) {

		System.out.println("+-----------+");
		System.out.printf("1 = %-5s%n","일정 등록");
		System.out.printf("2 = %-5s%n","일정 검색");
		System.out.printf("3 = %-5s%n","달력 보기");
		System.out.printf("4 = %-5s%n","도움말");
		System.out.printf("5 = %-6s%n","종료");
		System.out.println("+-----------+");
		
		Scanner kb = new Scanner(System.in);

		while (true) {

			System.out.print("명령을 입력하세요: ");
			int input = kb.nextInt();
			
			switch(input) {
			case 1:
//				add();
				break;
			case 2:
//				search();
				break;
			case 3:
				print(kb);
				break;
			case 4:
//				help();
				break;
			case 5:
//				exit();
				break;
			}

		}
	}

	private static void print(Scanner kb) {
		System.out.print("연도 입력 :");
		int year = kb.nextInt();

		System.out.print("월 입력 :");
		int month = kb.nextInt();

		CalendarMethod.print(year, month);
		System.out.println("\n");		
	}
}