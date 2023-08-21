package scheduler;

public class DeadLinedEvent extends Event {
	private MyDate deadline;

	public DeadLinedEvent(String title, MyDate date) {
		super(title);
		deadline = date;
	}

	public String toString() {
		return title + " ~" + deadline.toString() + "까지";
	}

	public boolean isRelevant(MyDate date) { // date <= deadLine
		return deadline.compareTo(date) >= 0;
	}
	
	public MyDate getRepresentativeDate() {
		return deadline;
	}
}
