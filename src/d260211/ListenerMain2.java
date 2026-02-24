package d260211;

//나의 작업을 전후로 이벤트를 발생시키고 싶은 경우
public class ListenerMain2 {

	public static void main(String[] args) {
			/*
			MyWork2 mywork=new MyWork2();
			IpWriter ip=new IpWriter();
			LogWriter log=new LogWriter();
			mywork.addBeforeListener(ip);
			mywork.addAfterListener(log);
			mywork.work();
			*/
		/*
		 BeforeListener bl=new BeforeListener(); //우측이 인터페이스므로 new를 사용할 수 없다.
		 */
		 
		MyWork2 mywork=new MyWork2();
		mywork.addBeforeListener(new BeforeListener() {
			@Override
			public void beforeOnEvent() {
				System.out.println("IP주소 기록하기 작업!!");				
			}
		});
		mywork.addAfterListener(new AfterListener() {
					@Override
			public void afterOnEvent() {
				System.out.println("로그기록하기 작업!!");				
			}
		});
		mywork.work();
	}

}