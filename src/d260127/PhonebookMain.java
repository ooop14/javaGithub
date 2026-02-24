package d260127;

import java.util.ArrayList;
import java.util.List;

public class PhonebookMain {

	public static void main(String[] args) {
		List<Phonebook> pb = new ArrayList<Phonebook>();
		PhonebookManager pm = new PhonebookManager(pb);
		
		//PhonebookManager pm = new PhonebookManager();
		//pm.setPb(pb);
		//최종 객체
		PhonebookFrame frame = new PhonebookFrame(pm);

	}

}
