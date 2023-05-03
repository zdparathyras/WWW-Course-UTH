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

@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customer_fname=request.getParameter("fname");
		String customer_lname=request.getParameter("lname");
		String customer_age=request.getParameter("age");
		String customer_address=request.getParameter("formated_address");
		String customer_adm_area=request.getParameter("perifereia");
		String customer_phone=request.getParameter("phone");
		String customer_buzzer=request.getParameter("buzzer");
		String customer_floor=request.getParameter("floor");
		String customer_email=request.getParameter("email");
		String customer_password=request.getParameter("pwd");	
		String empty="";
		boolean check_inserted_data=true;
		
		if (customer_fname==null || customer_fname.equals(empty)) {check_inserted_data=false;}
		if (customer_lname==null || customer_lname.equals(empty)) {check_inserted_data=false;}
		if (customer_age==null || customer_age.equals(empty)) {check_inserted_data=false;}
		if (customer_address==null || customer_address.equals(empty)) {check_inserted_data=false;}
		if (customer_adm_area==null || customer_adm_area.equals(empty)) {check_inserted_data=false;}
		if (customer_phone==null || customer_phone.equals(empty)) {check_inserted_data=false;}
		if (customer_buzzer==null || customer_buzzer.equals(empty)) {check_inserted_data=false;}
		if (customer_floor==null || customer_floor.equals(empty)) {check_inserted_data=false;}
		if (customer_email==null || customer_email.equals(empty)) {check_inserted_data=false;}
		if (customer_password==null || customer_password.equals(empty)) {check_inserted_data=false;}
		
		if (check_inserted_data==true) {
			Configuration con = new Configuration().configure().addAnnotatedClass(Customer.class);
			SessionFactory sf = con.buildSessionFactory();
			Session hib_session = sf.openSession();		
			
			Customer check_existance=null;
			Transaction tx = hib_session.beginTransaction();
			var myquery = "from Customer where email = ";
			myquery += "'" + customer_email + "'";
			check_existance = hib_session.createQuery(myquery,Customer.class).uniqueResult();
			//check_existance = (Customer) hib_session.get(Customer.class, customer_email);
			tx.commit();
				
			if (check_existance==null) {
				int age=Integer.parseInt(customer_age);
				Customer new_customer= new Customer();
				new_customer.setFname(customer_fname);
				new_customer.setLname(customer_lname);
				new_customer.setAge(age);
				new_customer.setAddress(customer_address);
				new_customer.setAdm_area(customer_adm_area);
				new_customer.setTel_number(customer_phone);
				new_customer.setBuzzer(customer_buzzer);
				new_customer.setFloor(customer_floor);
				new_customer.setEmail(customer_email);
				new_customer.setCpassword(customer_password);
				
				tx = hib_session.beginTransaction();
				hib_session.save(new_customer);
				tx.commit();
				sf.close();
				
				HttpSession session=request.getSession();
				session.setAttribute("ses_customer",new_customer);
				response.sendRedirect("choose_deli_or_dine.html");
				
			}
			else {
				sf.close();
			}	
		}	
	}
}
