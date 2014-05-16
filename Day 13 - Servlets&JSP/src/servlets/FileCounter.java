package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dao.FileDao;

/**
 * Servlet implementation class FileCounter
 */
@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 int count;
	 private FileDao dao;
	 private DBManager db;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileCounter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() throws ServletException {
    
    	dao = new FileDao();
        
        try {
          count = dao.getCount();
        } catch (Exception e) {
          getServletContext().log("An exception occurred in FileCounter", e);
          throw new ServletException("An exception occurred in FileCounter"
              + e.getMessage());
        }
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    	      HttpServletResponse response) throws ServletException, IOException {
    	    // Set a cookie for the user, so that the counter does not increate
    	    // every time the user press refresh
    	    HttpSession session = request.getSession(true);
    	    // Set the session valid for 5 secs
    	    session.setMaxInactiveInterval(5);
    	    response.setContentType("text/plain");
    	    PrintWriter out = response.getWriter();
    	    if (session.isNew()) {
    	      count++;
    	    }
    	    out.println("This site has been accessed " + count + " times.");
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		db = new DBManager();
		db.connectToDatabase();
 	    String interogation = "";
 	    String insertString = "";
 	     
 	    insertString = "INSERT INTO departament (idDepartament , denumireDepartament) VALUES ("+request.getParameter("id") +",'" +request.getParameter("denumire")+"')";
 	    System.out.println(insertString);
 	    db.insertInTable(insertString);
 	    
 	    
 	    ResultSet result = db.selectfromTable("select * from departament");
 	    
 	    try {
				while(result.next()){
				     //Retrieve by column name
				     int id  = result.getInt("idDepartament");
				     String denumire = result.getString("denumireDepartament");
				  
				     interogation += "Entry: "+id +" , " +denumire;
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
 	    
 	   System.out.println(interogation);
	}
	
	public void destroy() {
	    super.destroy();
	    try {
	      dao.save(count);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}
