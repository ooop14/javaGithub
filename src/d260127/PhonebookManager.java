package d260127;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhonebookManager {
	private List<Phonebook> pb=new ArrayList<Phonebook>();
	
	public PhonebookManager() {				
		fileload("phonebook.txt");
	}
	
	public boolean filesave(String filename) {
		try {
		BufferedWriter bw
		=new BufferedWriter(new FileWriter(filename));
		int i=0;
		for(Phonebook p:pb) {
		bw.write(
				p.getId() + " " +
				p.getName() + " " +
				p.getHp() + " " +
				p.getEmail()
				);
			if(i!=(pb.size()-1)) {
			bw.newLine();
			}
			i++;
		}
		bw.flush();
		bw.close();
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void fileload(String filename){
		//pb=new Phonebook[100];
		//pb.removeAll(null);
		pb=new ArrayList<Phonebook>();
		//index=0;
		//phonebook.txt파일을 메모리로 로드
		try {
		BufferedReader br
		=new BufferedReader(new FileReader(filename));
		String data="";
		while((data=br.readLine())!=null) {
			insert(
			Integer.parseInt(data.split(" ")[0])
			,data.split(" ")[1]
			,data.split(" ")[2]
			,data.split(" ")[3]
			);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void filesave() {
		
	}
	
	public void insert(int id,String name, String hp, String email) {
		//pb[index]=new Phonebook(id,name, hp, email);
		pb.add(new Phonebook(id,name, hp, email));
		//index=index+1;
	}
	
	public void insert(String name, String hp, String email) {
		//pb[index]=new Phonebook(index+1,name, hp, email);
		pb.add(new Phonebook(pb.size()+1,name, hp, email));
		//index=index+1;
	}

	public void select() {
		/*
		for(int i=0;i<index;i++) {
			if(pb[i].getId()!=0) {
				System.out.println(pb[i]);
			}
		}
		*/
		for(Phonebook p:pb) {
			if(p.getId()!=0) {
				System.out.println(p);
			}
		}
		
	}
	public void update(String searchname,Phonebook p) {
		/*
		for(int i=0;i<index;i++) {
			if(searchname.equals(pb[i].getName())) {
				if(p.getName()!=null) {pb[i].setName(p.getName());}				
				if(p.getHp()!=null) {pb[i].setHp(p.getHp());}				
				if(p.getEmail()!=null) {pb[i].setEmail(p.getEmail());}
				return;
			}
		}
		*/
		for(Phonebook _p:pb) {
			if(searchname.equals(_p.getName())) {
				if(p.getName()!=null) {_p.setName(p.getName());}				
				if(p.getHp()!=null) {_p.setHp(p.getHp());}				
				if(p.getEmail()!=null) {_p.setEmail(p.getEmail());}
				return;
			}
		}
	}

	public void delete(String name) {
		/*
		for(int i=0;i<index;i++) {
			if(pb[i].getName().equals(name)) {
				pb[i].setId(0); 
			}
		}
		*/
		//첫번째 방법
		/*
		for(int i=0;i<pb.size();i++) {
			Phonebook p=pb.get(i);
			if(p.getName().equals(name)) {
				pb.remove(i);
				break;  // or return;
			}
		}
		*/
		
		//두번째 방법
		/*
		for(Phonebook p:pb) {
			if(p.getName().equals(name)) {
				pb.remove(pb.indexOf(p));
				break; 
			}
		}
		*/
		
		//세번째 방법(이트레이터)
		Iterator<Phonebook> it=pb.iterator();
		while(it.hasNext()) {
			Phonebook p=it.next();
			if(p.getName().equals(name)) {
				it.remove();
				break;
			}
		}
		
		/*
		for(Phonebook p:pb) {
			if(p.getName().equals(name)) {
				//p.remove();
				pb.remove(0);
			}
		}
		*/
	}
	
	public Phonebook selectByName(String name) {
		int i=0;
		for(Phonebook p:pb) {
			if(p.getName().equals(name)) {
				//System.out.println(p);
				return p;
			}
			i++;			
		}
		
		if(pb.size()==i) {
			//System.out.println("전화번호부가 존재하지 않습니다.");
			return null;
		}
		
		return null;
	}
	
	//찾는 사람이 배열에 존재하는 여부 확인하는 함수
	public boolean isExist(String searchname) {
		for(Phonebook p:pb) {
			if(p.getName().equals(searchname)) {
				return true;
			}
		}
		return false;
	}
	
	public Phonebook getPhonebookByName(String name) {
		int i=0;
		for(Phonebook p:pb) {
			if(p.getName().equals(name)) {
				return new Phonebook(p.getName(),p.getHp(),p.getEmail());
				//BeanUtils.copyProperties(); //spring 객체
						
			}
		}
		
		return null;
	}

	public List<Phonebook> getList() {
		return pb;
	}

	
}
