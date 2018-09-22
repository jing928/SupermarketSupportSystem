package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="emp_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("E")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
	//@SequenceGenerator(name = "IdGenerator", sequenceName = "id", initialValue = 100, allocationSize = 1)
	private int id;
	@Column(nullable = false)
	private String name;

	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
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

}
