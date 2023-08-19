package playground;

public class CalenderMethod {

	// 윤년 판별 함수
	private static boolean isLeapYear(int year) {
		boolean leap = false;

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			leap = true;
		}

		return leap;
	}

	// 해당 월의 일수를 반환하는 함수(해당 월의 마지막 날짜 반환)
	private static int getDate(int year, int month) {
		int tmp = 0;

		if (isLeapYear(year)) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				tmp = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				tmp = 30;
				break;
			case 2:
				tmp = 29;
				break;
			default:
				return -1;
			}
		} else {
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				tmp = 31;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				tmp = 30;
			} else if (month == 2) {
				tmp = 28;
			} else {
				return -1;
			}
		}
		return tmp;
	}

	// 해당 월의 첫번째 요일을 정수로 반환하는 함수
	private static int getDayOfWeek(int year, int month) {
		int sum = 0;
		int dayOfWeek = 0;

		// 서기 1년 1월 1일 ~ (year - 1)년 12월 31일까지 일수
		for (int i = 1; i < year; i++) {
			for (int j = 1; j <= 12; j++) {
				sum += getDate(i, j);
			}
		}

		// year년 1월 1일 ~ year년 (month-1)월 31일까지 일수
		for (int k = 1; k < month; k++) {
			sum += getDate(year, k);
		}

		// year년 month월 1일 일수 추
		sum += 1;

		// 서기 1년 1월 1일은 일요일라고 가정
		// 해당 달 1일의 요일(일0월1화2수3목4금5토6)
		dayOfWeek = sum % 7;

		return dayOfWeek;
	}

	// 연도와 월을 입력하면 달력을 출력하는 함수
	public static void print(int year, int month) {
		if (getDate(year, month) != -1) {

			System.out.printf("\t\t%8d년 %2d월\n\n", year, month);
			System.out.printf("월\t화\t수\t목\t금\t토\t일\n");

			int start = getDayOfWeek(year, month) - 1;
			int last = getDate(year, month);

			// start = 월0화1수2목3금4토5
			if (start != -1) {
				for (int i = 1; i <= start; i++) {
					System.out.print("\t");
				}

				for (int i = 1; i <= last; i++) {
					System.out.print(i + "\t");
					start++;
					if (start % 7 == 0) {
						System.out.println();
					}
				}
			}
			// start = 일-1
			else if (start == -1) {
				start = 6;

				for (int i = 1; i <= start; i++) {
					System.out.print("\t");
				}

				for (int i = 1; i <= last; i++) {
					System.out.print(i + "\t");
					start++;
					if (start % 7 == 0) {
						System.out.println();
					}
				}
			}
		} else {
			System.out.println("월 입력 시 1 ~ 12 사이 정수로 입력해주세요");
		}
	}
}
