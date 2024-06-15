package Controller;


import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.UserDAO;
import Model.User;
import dbUtil.DBConnect;
import dbUtil.HibernateSF;

@Controller
public class AuthenticateController {
	
	//global database connection
	Connection conn = DBConnect.openConnection();
	
	
	@RequestMapping(value = "/loginPage")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/SignUp")
	public String signup() {
		return "signUp";
	}
	
	@RequestMapping(value = "/adminDash")
	public String adminDash() {
		return "adminDashboard";
	}
	
	@RequestMapping(value = "/auth")
	public String connect(HttpServletRequest request, Model model){
		
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		if(username.equals("admin") || password.equals("masterkey")) {
			
			User u = new User(0, "admin", "masterkey", "null", "null", "null", "admin");
			
			//Create Session
			HttpSession sess = request.getSession();
			sess.setAttribute("user", u);

			return "adminDashboard";
			
			
		}else {
			String data;
			
			try{
				User user = UserDAO.getById(username,password);
				
				//create Session
				HttpSession sess = request.getSession();
				sess.setAttribute("user", user);
				
				//add attribute
				model.addAttribute("user",user);
				request.setAttribute("test", user);
				
				data = "redirect:/material";
				
				
            }catch(Exception ex){
             model.addAttribute("errorMsg",ex);
               data = "redirect:/loginPage";
            }
			
			
			return data;
				
		}
	}
	
	//Get Profile
	@RequestMapping("/profile")
	public String getProfile(HttpSession sess, Model mod) {
		
		Session session = HibernateSF.getCurrentSession().openSession();
		User student = (User)sess.getAttribute("user");//use after using login
		
		mod.addAttribute("student",student);
		
		return "profile";
	}
	
	//@ResponseBody()
	@SuppressWarnings("unchecked")
	@RequestMapping("/register")
	public String userAdded(Model mod, HttpServletRequest request) {
		
		Session session= HibernateSF.getCurrentSession().openSession();
		User u = new User();
		String email = request.getParameter("email");
		String message = "Email Already Exists";
		request.setAttribute("message", message);
		List<User> uList = session.createQuery("from User").list();
		boolean exists=false;
		for(int i=0; i<uList.size();i++)
		{
			if(uList.get(i).getEmail().equals(email))
			{
			  exists =true;
			 
			}
		}
		if(exists)
			return "signUp";
		else
		{
			
		u.setMatricid(request.getParameter("matricid"));
		u.setPassword(request.getParameter("password"));
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setEmail(request.getParameter("email"));
		u.setRole("student");
		
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		}
		
		HttpSession sess = request.getSession();
		sess.setAttribute("user", u);
		
		return "redirect:/material";
	}


}
