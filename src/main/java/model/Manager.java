package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Manager extends Employee {

	public Manager(String name) {
		super(name);
	}
	
	public Manager() {
		super();
	}

}
