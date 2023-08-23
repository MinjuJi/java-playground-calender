package scheduler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {

	private ArrayList<Event> events = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);

	private void processCommand() {

		while (true) {

			System.out.println("\n************<<번호 입력>>***************");
			System.out.println("1 = 이벤트 추가");
			System.out.println("2 = 현재 입려된 모든 이벤트 보기");
			System.out.println("3 = 입력한 날짜에 해당되는 이벤트 보기");
			System.out.println("4 = 현재 입력된 이벤트를 날짜 기준 오름차순 정렬");
			System.out.println("5 = 입력한 문자열과 동일한 title 삭제");
			System.out.println("6 = 종료");
			System.out.println("**************************************");

			String command = kb.next();

			if (command.equals("1")) { // 이벤트 추가

				System.out.println("\n********<<번호 입력>>********");
				System.out.println(" 7 = 하루짜리 스케줄 추가");
				System.out.println(" 8 = 기간이 있는 스케줄 추가");
				System.out.println(" 9 = 데드라인이 있는 스케줄 추가");
				System.out.println("***************************");

				String type = kb.next();

				if (type.equalsIgnoreCase("7"))
					handleAddOneDayEvent();
				else if (type.equalsIgnoreCase("8")) {
					handleAddDurationEvent();
				} else if (type.equalsIgnoreCase("9")) {
					handleAddDeadLinedEvent();
				}

			} else if (command.equals("2")) { // 현재 입력된 모든 이벤트 화면에 출력

				handleList();

			} else if (command.equals("3")) { // 입력한 날짜에 해당되는 이벤트를 화면에 출력

				handleShow();

			} else if (command.equals("4")) { // 날짜순 오름차순 정렬
				Collections.sort(events);

			} else if (command.equals("5")) { // 입력한 문자열에 해당되는 이벤트를 리스트에서 삭제
				handleRemove();
			} else if (command.equals("6")) { // 프로그램 종료
				break;
			}
		}
		kb.close();
	}

	private void handleRemove() {

		System.out.println("삭제할 title을 입력해주세요: ");
		kb.nextLine();
		String str = kb.nextLine();

// 데이터가 리스트에 Event 타입으로 저장되어 있으므로 입력값(String 타입)과 타입을 맞추기 위해서 Event 클래스에 String 타입으로 title을 반환하는 함수 작성

		// 방법1: for문
//		for (int i = 0; i < events.size(); i++) {
//			if (events.get(i).title().equals(str)) {
//				events.remove(i);
//				break;
//			}
//		}

		// 방법 2: Enhanced for문
		for (Event tmp : events) {
			if (tmp.title().equals(str)) {
				events.remove(tmp);
				System.out.println("이벤트가 삭제되었습니다.");
				return;
			}
		}
		System.out.println("해당하는 이벤트를 찾을 수 없습니다.");

	}

	private void handleShow() {
		System.out.print("yyyy/mm/dd: ");
		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString);

		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).isRelevant(theDate))
				System.out.println(events.get(i).toString());
		}
	}
	// 초기: Event 클래스에 isRelevant 메소드가 없고, OneDay, Duration, DeadLined 클래스에 isRelevant 메소드 구현되어 있다.
	// 따라서 Event 클래스 타입의 배열인 "events[i].isRelevant" 사용 시 오류로 표시함.
	// 이때 간단한 해결책은 Event 클래스에 isRelevant 메소드를 아무렇게나 만들면 해결된다(여기서는 추상 메소드로 설정함).
	// 왜냐하면 프로그램 실행시 dynamic binding으로 인해 events[i]의 각 칸에 있는 OneDay, Duration, DeadLined 클래스 객체의 isRelevant 메소드가 실행되기 때문이다.
	// Event 클래스에 isRelevant 메소드는 오류를 해결하기 위해 형식적으로 만들어진 것일 뿐 해당 프로그램에서는 실행되지 않는다.
	// 반면, "events[i].toString()"은 왜 오류로 표시되지 않냐고 묻는다면 toString()메소드는 Object 클래스의 메소드이기 때문이다.
	// "events[i].toString()" 실행하면 Object 클래스의 toString()가 실행되지 않고 OneDay, Duration, DeadLined 클래스 객체의 toString()이 실행된다(dynamic binding).
	// 다시 돌아와서 Event 클래스의 isRelevant 메소드가 한 번도 실행되지 않을텐데 아무렇게나 작성하는 것은 좋은 코드가 아니다.
	// 따라서 이런 상황에서 추상 메소드를 이용한다!!
	// Event 클래스에 "public abstract boolean isRelevant();" 추상메소드를 생성한다.
	// OneDay, Duration, DeadLined 클래스의 isRelevant()에서 구현(오버라이딩)한 것이라 할 수 있다.

	private MyDate parseDateString(String dateString) {
		String[] tokens = dateString.split("/");

		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		MyDate tmp = new MyDate(year, month, day);

		return tmp;
	}

	private void handleList() {

		for (int i = 0; i < events.size(); i++)
			System.out.println((i + 1) + ". " + events.get(i).toString());

	}

	private void handleAddDeadLinedEvent() {
		System.out.print("yyyy/mm/dd: ");
		String deadLinedDate = kb.next();
		kb.nextLine();
		System.out.print("title: ");
		String title = kb.nextLine();

		MyDate deadline = parseDateString(deadLinedDate);

		DeadLinedEvent ev = new DeadLinedEvent(title, deadline);
		addEvent(ev);

	}

	private void handleAddDurationEvent() {
		System.out.print("yyyy/mm/dd 시작일: ");
		String biginDate = kb.next();
		System.out.print("yyyy/mm/dd 종료일: ");
		String endDate = kb.next();

		MyDate bigin = parseDateString(biginDate);
		MyDate end = parseDateString(endDate);

		if (bigin.compareTo(end) > 0) {
			System.out.println("시작일보다 종료일이 뒤에 있어야 합니다.");
			return;
		}

		kb.nextLine();
		System.out.print("title: ");
		String title = kb.nextLine();

		DurationEvent ev = new DurationEvent(title, bigin, end);
		addEvent(ev);
	}

	private void handleAddOneDayEvent() {
		System.out.print("yyyy/mm/dd: ");
		String dateString = kb.next();
		kb.nextLine();
		System.out.print("title: ");
		String title = kb.nextLine();

		MyDate date = parseDateString(dateString);

		OneDayEvent ev = new OneDayEvent(title, date);
		addEvent(ev);
	}

	private void addEvent(Event ev) {
		events.add(ev);
		System.out.println("\n이벤트가 추가되었습니다.");
	}

	private void saveEventsToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("schedule.txt"));

			for (Event tmp : events) {
				bw.write(tmp.toString());
				bw.newLine(); // 다음 줄로 넘어가기
			}
			bw.close();
			System.out.println("이벤트 데이터가 파일에 저장되었습니다.");
		} catch (IOException e) {
			System.out.println("파일 저장 중 오류가 발생했습니다.");
		}

	}

	private void loadEventsFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("schedule.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				Event ev = parseEventsString(line);

				if (ev != null)
					events.add(ev);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("현재 이벤트가 저장된 파일이 생성되지 않았습니다.");
		} catch (Exception e) {
			System.out.println("파일 불러오기 중 오류가 발생했습니다.");
		}
	}

	private Event parseEventsString(String line) {

		String[] tokens = line.split("\\s*:\\s*~|\\s*~\\s*|\\s*:\\s");

		if (tokens[0].equals("[OneDay]")) {
			String title = tokens[1];
			MyDate date = parseDateString(tokens[2]);
			return new OneDayEvent(title, date);

		} else if (tokens[0].equals("[Duration]")) {
			String title = tokens[1];
			MyDate bigin = parseDateString(tokens[2]);
			MyDate end = parseDateString(tokens[3]);
			return new DurationEvent(title, bigin, end);

		} else if (tokens[0].equals("[DeadLine]")) {
			String title = tokens[1];
			MyDate deadline = parseDateString(tokens[2]);
			return new DeadLinedEvent(title, deadline);
		}

		return null;
	}

	public static void main(String[] args) {
		Scheduler app = new Scheduler();

		app.loadEventsFromFile();
		app.processCommand();
		app.saveEventsToFile();
	}

}
