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

@WebServlet("/LoginStore")
public class LoginStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customer_email=request.getParameter("slEmail");
		String customer_pwd=request.getParameter("slPwd");
		String empty="";
		boolean check_inserted_data=true;
		
		if (customer_email==null || customer_email.equals(empty)) {check_inserted_data=false;}
		if (customer_pwd==null || customer_pwd.equals(empty)) {check_inserted_data=false;}
		
		if (check_inserted_data==true) {
			Configuration con = new Configuration().configure().addAnnotatedClass(Store.class);
			SessionFactory sf = con.buildSessionFactory();
			Session hib_session = sf.openSession();		
			
			Store check_existance=null;
			Transaction tx = hib_session.beginTransaction();
			check_existance = (Store) hib_session.get(Store.class, customer_email);
			tx.commit();
			sf.close();
			
			if (check_existance!=null) {
				if (customer_pwd.equals(check_existance.getSpassword())) {
					HttpSession session=request.getSession();
					session.setAttribute("ses_store",check_existance);
					response.sendRedirect("menu_creator.jsp");
				}
				else {
					//redirect back to index page
				}
			}
		}
	}

}
