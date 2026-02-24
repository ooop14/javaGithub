package d260211;

public class LogWriter implements AfterListener{

	@Override
	public void afterOnEvent() {
		System.out.println("로그 기록 작업!!");
		
	}

}