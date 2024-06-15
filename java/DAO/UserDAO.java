package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Material;
import Model.User;
import dbUtil.DBConnect;
import dbUtil.HibernateSF;

public class UserDAO {
	
	Connection conn = DBConnect.openConnection();
	
	@Autowired
	static JdbcTemplate jdbct = new JdbcTemplate(getDataSource());
	
	@SuppressWarnings("unchecked")
	public static User getById(String uname, String pass) {
		
		Session session = HibernateSF.getCurrentSession().openSession();
		
		String query = "SELECT * FROM student WHERE matricid = ? AND password = ?" ;
		User u = jdbct.queryForObject(query, new BeanPropertyRowMapper<User>(User.class),uname,pass);
		
		return u;
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
