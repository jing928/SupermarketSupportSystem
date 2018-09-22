package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SalesStaff extends Employee {

	public SalesStaff(String name) {
		super(name);
	}

}