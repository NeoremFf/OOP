package task07;

import java.io.Serializable;

public class Stat implements Serializable{
	private static final long serialVersionUID = 382140668595516562L;
	private String name = null;
	private String value = null;
	public Stat() {	
		
	}
	public Stat(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String toString() {
		return name + ": " + value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
