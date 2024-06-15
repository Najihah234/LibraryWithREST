package dbUtil;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import Model.Material;
import Model.Payment;
import Model.Room;
import Model.Slot;
import Model.StudentMaterial;
import Model.StudentRoom;
import Model.User;

public class HibernateSF {
	
	static SessionFactory sf = null;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getCurrentSession() {
		
		if(sf == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Material.class);
			config.addAnnotatedClass(Room.class);
			config.addAnnotatedClass(Slot.class);
			config.addAnnotatedClass(StudentMaterial.class);
			config.addAnnotatedClass(StudentRoom.class);
			config.addAnnotatedClass(Payment.class);


			sf = config.buildSessionFactory();

		}
		
		return sf;
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
