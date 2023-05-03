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

@WebServlet("/RegisterStore")
public class RegisterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_name=request.getParameter("store_name");
		String manager_fname=request.getParameter("fname");
		String manager_lname=request.getParameter("lname");
		String store_address=request.getParameter("formated_address");
		String store_adm_area=request.getParameter("perifereia");
		String store_phone=request.getParameter("sPhone");
		String store_email=request.getParameter("sEmail");
		String store_password=request.getParameter("sPwd");
		String store_reserve=request.getParameter("reservation");
		String store_category=request.getParameter("category");
		String store_minutes=request.getParameter("time");	
		String store_minimum=request.getParameter("cost");	
		String empty="";
		boolean check_inserted_data=true;
		
		if (store_name==null || store_name.equals(empty)) {check_inserted_data=false;}
		if (manager_fname==null || manager_fname.equals(empty)) {check_inserted_data=false;}
		if (manager_lname==null || manager_lname.equals(empty)) {check_inserted_data=false;}
		if (store_address==null || store_address.equals(empty)) {check_inserted_data=false;}
		if (store_adm_area==null || store_adm_area.equals(empty)) {check_inserted_data=false;}
		if (store_phone==null || store_phone.equals(empty)) {check_inserted_data=false;}
		if (store_email==null || store_email.equals(empty)) {check_inserted_data=false;}
		if (store_password==null || store_password.equals(empty)) {check_inserted_data=false;}
		if (store_reserve==null || store_reserve.equals(empty)) {check_inserted_data=false;}
		if (store_category==null || store_category.equals(empty)) {check_inserted_data=false;}
		if (store_minutes==null || store_minutes.equals(empty)) {check_inserted_data=false;}
		if (store_minimum==null || store_minimum.equals(empty)) {check_inserted_data=false;}
		
		if (check_inserted_data==true) {
			Configuration con = new Configuration().configure().addAnnotatedClass(Store.class);
			SessionFactory sf = con.buildSessionFactory();
			Session hib_session = sf.openSession();
			
			Store check_existance=null;
			Transaction tx = hib_session.beginTransaction();
			check_existance = (Store) hib_session.get(Store.class, store_email);
			tx.commit();
			
			if (check_existance==null) {
				Store new_store= new Store();
				new_store.setSname(store_name);
				new_store.setManager_fname(manager_fname);
				new_store.setManager_lname(manager_lname);
				new_store.setAddress(store_address);
				new_store.setAdm_area(store_adm_area);
				new_store.setSphone(store_phone);
				new_store.setEmail(store_email);
				new_store.setSpassword(store_password);
				new_store.setMinutes(Integer.parseInt(store_minutes));
				new_store.setMinimun(Integer.parseInt(store_minimum));
				if (store_reserve.equals("ΝΑΙ")) {new_store.setReservations(true);} else {new_store.setReservations(false);}
				new_store.setCategory(store_category);
				
				tx = hib_session.beginTransaction();
				hib_session.save(new_store);
				tx.commit();
				sf.close();
				
				HttpSession session=request.getSession();
				session.setAttribute("ses_store",new_store);
				response.sendRedirect("menu_creator.jsp");
			}
			else {
				sf.close();
			}
		}
		
	}


}
