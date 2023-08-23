package scheduler;

public class OneDayEvent extends Event {
	private MyDate date;

	public OneDayEvent(String title, MyDate date) {
		super(title);
		this.date = date;
	}

	public String toString() {
		return "[OneDay] : " + title + " : " + date.toString();
	}
	
	public boolean isRelevant(MyDate date) {
		return this.date.compareTo(date) == 0;
	}
	public MyDate getRepresentativeDate() {
		return date;
	}
}
