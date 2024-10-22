import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LoginDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{  
		String s1=request.getParameter("u1");
		String s2=request.getParameter("u2");
		
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from regis where UNAME='"+s1+"' AND UPASS='"+s2+"'");
		if(rs.next()){
		     response.sendRedirect("MenuDemo.html");
			 
		}
		else{
			out.println("invalid username and password");

		}
		 con.close();
		//out.println("<h1>data insert</h1>");
		}
		//out.println("<h1>data insert</h1>");

		catch(Exception e){
		out.println(e);
		
		}
		//out.println("<h1>Name="+s1+"</h1>");
		//out.println("<h1>Sername="+s2+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}		
	
}