package scheduler;

public abstract class Event implements Comparable {
	public String title;

	public Event(String title) {
		this.title = title;
	}

	public abstract boolean isRelevant(MyDate date);

	public abstract MyDate getRepresentativeDate();

	public int compareTo(Object other) {
		MyDate mine = getRepresentativeDate();
		MyDate yours = ((Event) other).getRepresentativeDate();
// '(Event) other'는 Object타입의 other 객체를 Event 클래스로 형변환하여 getRepresentativeDate() 메서드를 호출하기 위함
		return  mine.compareTo(yours);
	}
	
	public String title() {
		return title;
	}

}
