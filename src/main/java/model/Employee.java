package model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -2046685092183889089L;

	private String id;
	private String name;

	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
