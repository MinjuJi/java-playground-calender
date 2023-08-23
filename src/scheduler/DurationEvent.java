package scheduler;

public class DurationEvent extends Event {
	private MyDate begin;
	private MyDate end;

	public DurationEvent(String title, MyDate b, MyDate e) {
		super(title);
		begin = b;
		end = e;
	}

	public String toString() {
		return "[Duration] : " + title + " : " + begin.toString() + " ~ " + end.toString();
	}

	public boolean isRelevant(MyDate date) { // begin <= date <= end
		return begin.compareTo(date) <= 0 && end.compareTo(date) >= 0;
	}
	
	public MyDate getRepresentativeDate() {
		return end;
	}
}
