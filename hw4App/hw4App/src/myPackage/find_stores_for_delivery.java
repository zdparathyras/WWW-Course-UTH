package myPackage;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/find_stores_for_delivery")
public class find_stores_for_delivery extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Store.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		
		List<Store> allStores = new ArrayList<Store>();
		hib_session.beginTransaction();
		allStores = hib_session.createQuery("from Store", Store.class).getResultList();
		hib_session.getTransaction().commit();
		sf.close();
		
		request.setAttribute("stores", allStores);
		request.getRequestDispatcher("pickStoreDelivery.jsp").forward(request, response);
	}

}
