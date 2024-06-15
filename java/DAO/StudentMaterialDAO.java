package DAO;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Model.Material;
import Model.Payment;
import Model.StudentMaterial;
import Model.StudentRoom;
import dbUtil.DBConnect;
import dbUtil.HibernateSF;

public class StudentMaterialDAO {
	
	Connection conn = DBConnect.openConnection();
	
	@Autowired
	static JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
	
	//get material from id
		@SuppressWarnings( { "unchecked" } )
		public static List<StudentMaterial> getAll() {
			
			Session session = HibernateSF.getCurrentSession().openSession();
			
			List<StudentMaterial> mat = (List<StudentMaterial>)session.createQuery("from StudentMaterial").list();
			return mat;
		    
		}
	
	//display material request based on id - admin
		public static StudentMaterial studentBookReq(int smid) {
				
			Session session = HibernateSF.getCurrentSession().openSession();
			
			StudentMaterial sm = session.get(StudentMaterial.class, smid);
			
			return sm;
		}
		
		//update student material request - admin
		@SuppressWarnings( { "unchecked" } )
		public static StudentMaterial updateStatus(int smid, String status) {
			
			Session session= HibernateSF.getCurrentSession().openSession();
			
			StudentMaterial sm = session.get(StudentMaterial.class, smid);
			
			Date rn = new Date();
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 14);
			Date returnDate = cal.getTime();

			Transaction tx = session.beginTransaction();
			
			
			sm.setStatus(status);
			
			//if admin approves a request, 14 days after will be set as the return date
			if(status.equals("APPROVED")) {
				sm.setApprovedDatetime(rn);
				sm.setReturnDatetime(returnDate);
			}
			
			if(status.equals("OVERDUE")) {
				Payment p =  new Payment();
				p.setSmid(sm);
				p.setStatus("OVERDUE");
				
				session.save(p);
			}
			
			
			session.update(sm);
			tx.commit();
			session.close();
			
			return sm;
		    
		}
		
		//add new student material request for student - student
		public static StudentMaterial newRequest(StudentMaterial newSM) {
			
			Session session= HibernateSF.getCurrentSession().openSession();
			
			session.beginTransaction();
			session.save(newSM);
			session.getTransaction().commit();
			session.close();
		
			return newSM;
		    
		}
		
		//add new student material request for student - student
		@SuppressWarnings({ "unchecked", "rawtypes"})
		public static List<StudentMaterial> displayReqById(int sid) {
			
		Session session= HibernateSF.getCurrentSession().openSession();
		
		Query query = session.createQuery("FROM StudentMaterial a WHERE a.student.studentid =" + sid);
		
		List<StudentMaterial> result = query.list();
		    	
			return result;    
		}
		
		
		//fine payment
		public static void pay(int smid, Date date) {
			
		Session session= HibernateSF.getCurrentSession().openSession();
		
		//get appropriate data
		StudentMaterial sm = session.get(StudentMaterial.class, smid);
		Query query = session.createQuery("FROM Payment p WHERE p.sm.smid =" + smid);
		Payment payment = (Payment) query.uniqueResult();
		
		Transaction tx = session.beginTransaction();
		
		payment.setStatus("PAID");
		payment.setPaymentDatetime(date);
		sm.setStatus("COMPLETED");
		sm.setReturnDatetime(date);
		
		//update payment status and date in admin part
		session.update(payment);
		
		//update material request status to completed
		session.update(sm);
		
		tx.commit();
		session.close();
		 
		}
		
		//add new student material request for student - student
		public static void deleteRequest(int smid) {
			
			Session session= HibernateSF.getCurrentSession().openSession();
 			
 			StudentMaterial m = session.get(StudentMaterial.class, smid);
 			Transaction tx = session.beginTransaction();
 			
 			session.delete(m);
 			tx.commit();
 			session.close();
		    	
		}
		
		public static DataSource getDataSource() {
			
			String dbURL = "jdbc:mysql://localhost:3306/library";
			String username = "root";
			String password = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			
			DataSource ds = new DriverManagerDataSource(dbURL,username,password);
			return ds;
		}

}
