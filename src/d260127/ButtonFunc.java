package d260127;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFunc implements ActionListener {
	PhonebookFrame f;
	java.util.List<Phonebook> datas;
	
	public ButtonFunc(PhonebookFrame phonebookFrame, java.util.List<Phonebook> list) {
		this.f=phonebookFrame;
		this.datas=list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.setVisible();
		f.getListBox().removeAll();
		String header=new String("아이디 이름 전화번호                                ");
		f.getListBox().add(header);
		for(Phonebook p:datas) {
		f.getListBox().add(p.getId()+ " " + p.getName() + " " + p.getHp());
		}
		f.getListBox().setVisible(true);
		f.revalidate();
		f.repaint();
		//list.setVisible(false);
		

	}

}