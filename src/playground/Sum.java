package playground;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		System.out.println("두 수를 입력하세요.");
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();
		
		System.out.print(num1 + " " + num2);
		System.out.println("\n두 수의 합은 " + (num1 + num2) + "입니다.");

		kb.close();
	}

}
