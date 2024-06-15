package Controller;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.MaterialDAO;
import DAO.StudentMaterialDAO;
import Model.Material;
import Model.Payment;
import Model.StudentMaterial;
import Model.User;
import dbUtil.DBConnect;
import dbUtil.HibernateSF;

@Controller
public class StudentMaterialController {

	//global database connection
		Connection conn = DBConnect.openConnection();
		
		//displays list of student material requests in admin page
		@RequestMapping(value = "/materialRequest")
		public String getAll(HttpServletRequest request, ModelMap model) {
			
			List<StudentMaterial> listReq = StudentMaterialDAO.getAll();
			model.addAttribute("listReq",listReq);
			model.addAttribute("mt","details");
			
			return "listBookRequest";
		}
		
	   //displays specific student material requests in admin page
		@RequestMapping(value = "/studentReq")
		
		public String getById(HttpServletRequest request, ModelMap model) {
			
			int smid = Integer.parseInt(request.getParameter("smid"));
			
		StudentMaterial listReq = StudentMaterialDAO.studentBookReq(smid);
		model.addAttribute("listReq",listReq);
		return "updateMaterialRequest";
		}
		
		//update student requests STATUS in admin page
		@RequestMapping(value = "/updateStatus")
		
		public String updateStatus(HttpServletRequest request,  ModelMap model) {
			
			int smid = Integer.parseInt(request.getParameter("smid"));
			String status = request.getParameter("status");
			
			StudentMaterial listReq = StudentMaterialDAO.updateStatus(smid,status);
			return "redirect:/materialRequest";
		}
		
		//add new student material request for student
		@RequestMapping(value = "/addMatReq")
		public String newRequest(HttpServletRequest request, HttpSession sess, ModelMap model) throws ParseException {
			
			User student = (User)sess.getAttribute("user");
			model.addAttribute("sid",student);
			
			int materialid = Integer.parseInt(request.getParameter("materialid"));
			Material m = MaterialDAO.displayById(materialid);
			
			Date date = new Date();
			
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
			Date dt = sp.parse(sp.format(date));
			
			StudentMaterial newSM = new StudentMaterial();
			newSM.setStudent(student);
			newSM.setMaterial(m);
			newSM.setRequestDatetime(dt);
			newSM.setStatus("PENDING");
			
			
			StudentMaterial sm = StudentMaterialDAO.newRequest(newSM);
			
			return "redirect:/material";
		}
		
		//add new student material request for student
		@RequestMapping(value = "/bookReqHistory")
		public String displayReqById(HttpServletRequest request, HttpSession sess, ModelMap model){
			
			User student = (User)sess.getAttribute("user");
			model.addAttribute("sid",student);
			
			List<StudentMaterial> m = StudentMaterialDAO.displayReqById(student.getStudentid());
			model.addAttribute("m",m);
			
			return "bookReqHistory";
		}
		
		//display fine details
		@RequestMapping(value = "/payFines")
		public String payFines(HttpServletRequest request, HttpSession sess, ModelMap model){
			
			User student = (User)sess.getAttribute("user");
			model.addAttribute("sid",student);
			int smid = Integer.parseInt(request.getParameter("smid"));
			
			//getSM
			StudentMaterial sm = StudentMaterialDAO.studentBookReq(smid);
			model.addAttribute("sm",sm);
			
			//get payment date and return date
			Date d = new Date();
			model.addAttribute("date",d);
			
			return "payFines";
		}
		
		//display invoice
		@RequestMapping(value = "/invoice")
		public String invoice(HttpServletRequest request, HttpSession sess, ModelMap model) {
			
			int smid = Integer.parseInt(request.getParameter("smid"));
			
			StudentMaterial listReq = StudentMaterialDAO.studentBookReq(smid);
			model.addAttribute("sm",listReq);
	
			return "invoice";
		}
		
		
		//fine payment
		@RequestMapping(value = "/pay")
		public String pay(HttpServletRequest request, HttpSession sess, ModelMap model){
			
			//update payment status and date in admin part
			//update material request status to completed
			Date date = (Date) request.getAttribute("date");
			int smid = Integer.parseInt(request.getParameter("smid"));
			
			StudentMaterialDAO.pay(smid,date);
			
			return "redirect:/bookReqHistory";
		}

		//display invoice
		@RequestMapping(value = "/deleteRequest")
		public String delete(HttpServletRequest request, HttpSession sess, ModelMap model) {
			
			int smid = Integer.parseInt(request.getParameter("smid"));
			
			StudentMaterialDAO.deleteRequest(smid);
	
			return "redirect:/bookReqHistory";
		}
		
		//admin deletes payment details
		@RequestMapping(value = "/deletePayment")
			public String deletePayment(HttpServletRequest request, ModelMap model) {
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			Session session= HibernateSF.getCurrentSession().openSession();
 			
			Payment m = session.get(Payment.class, pid);
 			Transaction tx = session.beginTransaction();
 			
 			session.delete(m);
 			tx.commit();
 			session.close();
	
			return "redirect:/finesList";
		}
}
