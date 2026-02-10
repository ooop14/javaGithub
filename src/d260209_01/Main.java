package d260209_01;

import java.util.ArrayList;
import java.util.List;

//컬렉션(수집) 프레임워크(구조)
//자바에서 데이터를 수집하는 구조
//소문자로 된 형은 기본형(int float char .../한 개의 데이터)
//대문자로 된 형은 클래스형(String Scanner .../데이터의 모음)
//컬렉션 프레임워크는 클래스형의 데이터를 저장하기 위한 클래스
public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//위의 코드에서 <>안의 string은 형,해당 형을 리스트로 저장한다.
		list.add(new String("Apple"));
		list.add(new String("Orange"));
		list.add(new String("Mango"));
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.indexOf("Mango"));
		System.out.println(list.get(list.indexOf("Mango")));

	}

}
