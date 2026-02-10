package d260209_01;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Main3 {
	public static void main(String[] args) {
		//String[] ips = new String[16];
		String[] ips = {"172.16.15.53","172.16.15.54","172.16.15.55","172.16.15.56",
				"172.16.15.57","172.16.15.58","172.16.15.59","172.16.15.60",
				"172.16.15.65","172.16.15.66","172.16.15.67","172.16.15.68",
				"172.16.15.73","172.16.15.74","172.16.15.75","172.16.15.76"};
		Frame f = new Frame();
		f.setBounds(0,0,400,300);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		Button[] btn = new Button[ips.length];
		for (int i = 0; i < ips.length; i++) {
			btn[i] = new Button(ips[i]);
			f.add(btn[i]);
			btn[i].setBackground(Color.RED);			
		}
		f.revalidate(); f.repaint();
		
	}
}
