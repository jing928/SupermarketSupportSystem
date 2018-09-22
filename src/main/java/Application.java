import java.util.List;

import org.hibernate.Session;
import model.*;
import utility.HibernateUtil;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.save(new Employee("Jing"));
		session.save(new Manager("Jin"));
		session.save(new SalesStaff("Addd"));

		List<Object[]> emps = session.createNativeQuery("SELECT * FROM employee").list();
		
		for (Object[] objects : emps) {
			Integer id = (Integer) objects[1];
			String name = (String) objects[2];
			String type = (String) objects[0];
			System.out.println("Employee[" + id + "," + name + "," + type + "]");
		}

		session.close();

		HibernateUtil.shutdown();
	}

}
