package d260127;

public class Phonebook {
	int id;
	String name;
	String hp;
	String email;
	
public Phonebook() {}

public Phonebook(int id, String name, String hp, String email) {
	this.id = id;
	this.name = name;
	this.hp = hp;
	this.email = email;
}
public Phonebook(String name, String hp, String email) {
	this.name = name;
	this.hp = hp;
	this.email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getHp() {
	return hp;
}

public void setHp(String hp) {
	this.hp = hp;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Phonebook [id=" + id + ", name=" + name + ", hp=" + hp + ", email=" + email + "]";
}


}
