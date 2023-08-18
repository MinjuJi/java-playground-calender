package playground;

import java.util.Scanner;

public class Calender {

	public static void main(String[] args) {
//		System.out.println("일 월 화 수 목 금 토");
//		System.out.println("--------------------");
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");

		
		// 윤년 제외
		Scanner kb = new Scanner(System.in);
		
		System.out.print("월 입력: ");
		int num = kb.nextInt();
		
		if ( num <= 7 && num >= 3 || num == 1) {
			if(num%2 == 0) {
				System.out.println(30);
			}else {
				System.out.println(31);
			}
		}else if( num > 7 ) {
			if(num%2 == 0) {
				System.out.println(31);
			}else {
				System.out.println(30);
			}
		}else if(num == 2){
			System.out.println(28);
		}else {
			System.out.println("1 ~ 12 사이 숫자를 입력하세요.");
		}
		
			kb.close();
	}

}
