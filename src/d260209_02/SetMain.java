package d260209_02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		//순서가 없고 중복 안됨
		Set<String> set = new HashSet<String>();
		set.add("apple");
		set.add("mange");
		set.add("apple");
		set.add("kiwi");
		System.out.println(set);
		//입력,출력,수정,삭제,전체삭제
		set.forEach(s->{
			System.out.println(s);
		});
		
		//포함되어 있는지 확인
		System.out.println(set.contains("apple"));
		
		//이터레이터 이용 출력
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(String s:set) {
			System.out.println(s);
		}
		//수정은 해당 객체를 찾은 후 삭제하고 add한다.
		//별도의 수정이 존재하지 않음
		
		//삭제
		//set.remove()
		//set.removeAll()
		
	}

}
