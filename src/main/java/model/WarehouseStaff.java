package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("W")
public class WarehouseStaff extends Employee {

	public WarehouseStaff(String name) {
		super(name);
	}

}
