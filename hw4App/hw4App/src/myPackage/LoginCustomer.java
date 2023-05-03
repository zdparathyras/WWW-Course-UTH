package myPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@WebServlet("/LoginCustomer")
public class LoginCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customer_email=request.getParameter("cEmail");
		String customer_pwd=request.getParameter("cPwd");
		String empty="";
		boolean check_inserted_data=true;
		
		if (customer_email==null || customer_email.equals(empty)) {check_inserted_data=false;}
		if (customer_pwd==null || customer_pwd.equals(empty)) {check_inserted_data=false;}
		
		if (check_inserted_data==true) {
			Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class);
			SessionFactory sf = con.buildSessionFactory();
			Session hib_session = sf.openSession();		
			
			Customer check_existance=null;
			Transaction tx = hib_session.beginTransaction();
			check_existance = (Customer) hib_session.get(Customer.class, customer_email);
			tx.commit();
			sf.close();
			
			if (check_existance!=null) {
				if (customer_pwd.equals(check_existance.getCpassword())) {
					
					HttpSession session=request.getSession();
					session.setAttribute("ses_customer",check_existance);
					response.sendRedirect("choose_deli_or_dine.html");
				}
				else {
					//redirect back to index page
				}
			}
		}
		
	}


}
