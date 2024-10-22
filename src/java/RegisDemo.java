import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisDemo extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		String s1=request.getParameter("un");
		String s2=request.getParameter("up");
	    String s3=request.getParameter("uc");

	
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		try{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
		 Statement st= con.createStatement();
        st.executeUpdate("insert into regis values('"+s1+"','"+s2+"','"+s3+"')");
		out.println("<h1>data insert</h1>");
                response.sendRedirect("login.html");
		 con.close();
		}
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
