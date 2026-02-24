package d260211;

public class MyWork2 {
	
	private BeforeListener beforeListener;
	private AfterListener afterListener;
	
	public void work() {
		//사전이벤트
		if(beforeListener!=null) beforeListener.beforeOnEvent(); //접속한 ip 기록
		
		System.out.println("로그인!!");
		
		//사후이벤트
		if(afterListener!=null) afterListener.afterOnEvent(); // 접속한 시간 기록
	}
	
	public void addBeforeListener(BeforeListener beforeListener) {
		this.beforeListener=beforeListener;
	}
	
	public void addAfterListener(AfterListener afterListener) {
		this.afterListener=afterListener;
	}

}