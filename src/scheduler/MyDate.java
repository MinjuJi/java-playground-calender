package scheduler;

public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}

	public String toString() {
		return year + "/" + month + "/" + day;
	}

	public int compareTo(MyDate other) {
		if (year < other.year || year == other.year && month < other.month
				|| year == other.year && month == other.month && day < other.day) // 입력한 날짜보다 작은 이벤트
			return -1;
		else if (year > other.year || year == other.year && month > other.month
				|| year == other.year && month == other.month && day > other.day) // 입력한 날짜보다 큰 이벤트
			return 1;
		else
			return 0; // 입력한 날짜와 같은 이벤트
	}
}
