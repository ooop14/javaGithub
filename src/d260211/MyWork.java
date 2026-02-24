package d260211;

public class MyWork {
	private MyListener myevent; // 리스너는 인터페이스로 작성

	public void work() {
		System.out.println("나의 작업 실행");
		// 동반되는 작업
		// 동반되는 작업은 있을 수도 없을 수도 있음
		// 있을 경우는 리스너를 등록/리스너를 add할 떄 동반되는 작업 수행
		if (myevent != null) {
			myevent.onEvent();
		}

	}

	// 리스너를 추가할 set or add 함수 작성
	/*
	 * public void setMyListener(MyListener myevent) { this.myevent = myevent; }
	 */
	public void addMyListener(MyListener myevent) {
		this.myevent = myevent;
	}
}
