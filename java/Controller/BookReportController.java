package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Payment;
import Model.StudentMaterial;
import dbUtil.HibernateSF;

@Controller
public class BookReportController {
	
	@RequestMapping("/bookReport")
	public String crud(HttpServletRequest request, HttpSession sess) {
		
		Session session= HibernateSF.getCurrentSession().openSession();
		
		List<StudentMaterial> uList = session.createQuery("from StudentMaterial").list();
		request.setAttribute("uList", uList);
		
		return "report";
	}
	
	//display payment list
	@RequestMapping("/finesList")
	public String payFineAdmin(HttpServletRequest request, HttpSession sess) {
		
		Session session= HibernateSF.getCurrentSession().openSession();
		
		List<Payment> p = session.createQuery("from Payment").list();
		request.setAttribute("p", p);
		
		return "finePaymentList";
	}
	
	
}
