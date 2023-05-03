package myPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/StoreFood")
public class StoreFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_name=request.getParameter("store_name");
		String food_name=request.getParameter("fname");
		String food_catg=request.getParameter("fcatg");
		String food_cost=request.getParameter("fcost");
		String empty="";
		boolean check_inserted_data=true;
		
		if (store_name==null || store_name.equals(empty)) {check_inserted_data=false;}
		if (food_name==null || food_name.equals(empty)) {check_inserted_data=false;}
		if (food_catg==null || food_catg.equals(empty)) {check_inserted_data=false;}
		if (food_cost==null || food_cost.equals(empty)) {check_inserted_data=false;}
		
		
		if (check_inserted_data==true) {
			Configuration con = new Configuration().configure().addAnnotatedClass(food.class);
			SessionFactory sf = con.buildSessionFactory();
			Session hib_session = sf.openSession();
			
			food check_existance=null;
			Transaction tx = hib_session.beginTransaction();
			check_existance = (food) hib_session.get(food.class, food_name);
			tx.commit();
			
			if (check_existance==null) {
				food new_food= new food();
				new_food.setSname(store_name);
				new_food.setName(food_name);
				new_food.setCategory(food_catg);
				Double num = Double.parseDouble(food_cost);  
				new_food.setCost(num);
				
				tx = hib_session.beginTransaction();
				hib_session.save(new_food);
				tx.commit();
				sf.close();
				
			}
			else {
				sf.close();
			}
		}
	}
}
