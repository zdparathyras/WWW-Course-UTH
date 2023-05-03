package myPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/getMenu")
public class getMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String store_name=request.getParameter("cgm");
		System.out.println("getMenu servlet: "+ store_name);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(food.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		String str_query = "from food where sname = ";
		str_query += "'" + store_name + "'";
		List<food> foods = new ArrayList<food>();
		hib_session.beginTransaction();
		foods = hib_session.createQuery(str_query, food.class).getResultList();
		hib_session.getTransaction().commit();
		
		request.setAttribute("foods", foods);
		request.setAttribute("storename", store_name);
		request.getRequestDispatcher("deliveryOrder.jsp").forward(request, response);
		sf.close();
	}

}
