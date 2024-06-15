package DAO;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Material;
import Model.StudentMaterial;
import Model.User;
import dbUtil.DBConnect;
import dbUtil.HibernateSF;

public class MaterialDAO {
	
	Connection conn = DBConnect.openConnection();
	
	@Autowired
	static JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
	
	//display material
	@SuppressWarnings( { "unchecked" } )
	public static List<Material> display() {
		
		Session session = HibernateSF.getCurrentSession().openSession();
		
		List<Material> mat = (List<Material>)session.createQuery("from Material").list();
		return mat;
	    
	}
	
	
	
	//display specific material
	public static Material displayById(int materialid) {
		
		Session session = HibernateSF.getCurrentSession().openSession();
		
		Material mat = session.get(Material.class, materialid);
		
		return mat;
	}
	
	//apply material request
		public static Material applyMatReq(int materialid) {
			
			Session session = HibernateSF.getCurrentSession().openSession();
			
			Material mat = session.get(Material.class, materialid);
			
			return mat;
		}
		
	//search title
		@SuppressWarnings("deprecation")
		public static List<Material> search(String searched) {
			
			Session session = HibernateSF.getCurrentSession().openSession();
			
			Query query = session.createQuery("FROM Material WHERE title like :searchField");
			query.setParameter("searchField","%"+searched+"%");
			List<Material> result = query.list();
			
			return result;
		}
		
		//update detail material
         public static Material updateMaterial(int materialid,int isbn, String title,String author,String publisher, String version, String description) {
			
			Session session= HibernateSF.getCurrentSession().openSession();
			
			Material m = session.get(Material.class, materialid);
			Transaction tx = session.beginTransaction();
			
			m.setIsbn(isbn);
			m.setTitle(title);
			m.setAuthor(author);
			m.setPublisher(publisher);
			m.setVersion(version);
			m.setDescription(description);
			
			session.update(m);
			tx.commit();
			session.close();
			
			return m;
		
		}
         
         public static Material deleteMaterial(int materialid) {
 			
 			Session session= HibernateSF.getCurrentSession().openSession();
 			
 			Material m = session.get(Material.class, materialid);
 			Transaction tx = session.beginTransaction();
 			
 			session.delete(m);
 			tx.commit();
 			session.close();
 			
 			return m;
 		
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
