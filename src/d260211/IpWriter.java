package d260211;

public class IpWriter implements BeforeListener{

	@Override
	public void beforeOnEvent() {
		System.out.println("ip기록 작업!!");
	}

}