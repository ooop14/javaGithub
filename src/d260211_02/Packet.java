package d260211_02;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class Packet implements Serializable{
	
	private static final long serialVersionUID = 3051882397596541198L;
	
	final static int LOGIN=1;
	final static int MESSAGE=2;
	final static int LOGIN_STATE=3;
	final static int size=2*1024;
	
	protected int protocolType; 
	private byte[] packet; 
	
	String id;
	String password;
	String message;
	String result;
	
	public Packet() {
		packet = new byte[2*1024];
	}
	
	public int getProtocolType() {
		return protocolType;
	}
	public void setProtocolType(int protocolType) {
		this.protocolType = protocolType;
		//바이트배열에 자동으로 프로토콜 타입이 입력되도록 처리
		//packet[0]=(byte)protocolType;
		//위와 같이 처리할 경우 2가지의 처리가 중복되므로 순수 함수처리에 영향이 있음
	}
	public byte[] getPacket() {
		/*
		//프로토콜타입을 배열로 변경
		packet[0]=(byte)protocolType;
		//타입에 따른 데이터 배열 변경
		byte[] bmessage=message.getBytes(StandardCharsets.UTF_8);
		System.arraycopy(bmessage, 0,packet, 1, message.length()); 
		*/
		//위의 코드는 메시지 보내는 것에 대해서 바이트배열로 만들었지만 여러가지 형태의 프로토콜 타입이 있을 경우 switch case문으로 처리
		packet[0]=(byte)protocolType;
		switch(protocolType) {
		case LOGIN: 
			byte[] id=getId().getBytes(StandardCharsets.UTF_8);		
			System.arraycopy(id, 0, packet, 1, id.length); 
			byte[] pass=getPassword().getBytes(StandardCharsets.UTF_8);
			System.arraycopy(pass, 0, packet, 20+1, pass.length);
			break;
		case MESSAGE: 
			byte[] bmessage=message.getBytes(StandardCharsets.UTF_8);
			System.arraycopy(bmessage, 0,packet, 1, bmessage.length);
			break;
		default: break;
		}
		return packet;
	}
	public void setPacket(byte[] packet) {
		//packet에 있는 내용을 packet배열에 저장을 하고 그 내용을 분석해서 각각의 맴버변수(필드)에 값을 넣어줌 
		this.packet = packet;		
		protocolType=packet[0];
		switch(protocolType) {
		case LOGIN: 
			id=new String(packet, 1, 20, StandardCharsets.UTF_8).trim();
			password=new String(packet, 21, 40, StandardCharsets.UTF_8).trim();
			break;
		case MESSAGE: 
			message=new String(packet,1,packet.length).trim();
			break;
		default: break;
		}
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		//byte[] bmessage=message.getBytes(StandardCharsets.UTF_8);
		//System.arraycopy(bmessage, 0,packet, 1, message.length()); 
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}	
}