

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tcon
 */
@WebServlet("/tcon")
public class tcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] Accessories={};
		Accessories=request.getParameterValues("access");
		String tshirtAccessories="";
		String tshirtTagLine=request.getParameter("tagline");
		String tshirtOption=request.getParameter("pocket");
		String tcolor=request.getParameter("Tshirtcolor");
		out.println("<html>");
		out.println("<head><title>T-shirt</title></head>");
		out.println("<body>");
		try {
            Statement stmt;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt","root","ankit");
            if (conn != null) {
            	stmt= conn.createStatement();
            	String qu;
            	if(tshirtAccessories!=null && tshirtTagLine!=null && tshirtOption!=null && tcolor!=null){
            		for(String option:Accessories){
            			tshirtAccessories=tshirtAccessories+" "+option;
            		}
            		qu="insert into Tshirt (tagline,accessories,color,opt) values('"+tshirtTagLine+"','"+tshirtAccessories+"','"+tcolor+"','"+tshirtOption+"');";
            		int i=stmt.executeUpdate(qu);
            		System.out.println(i);
            	}
            	qu="select * from Tshirt;";
            	ResultSet rs =stmt.executeQuery(qu);
            	out.println("<table border=2>");
        		out.println("<tr>");
        		out.print("<td>OrderNo</td>");
        		out.print("<td>T-shirt Accessories</td>");
        		out.print("<td>T-shirt tag-line</td>");
        		out.print("<td>T-shirt type</td>");
        		out.print("<td>T-shirt color</td>");
        		out.println("</tr>");
        		
        		while(rs.next()){
        		out.println("<tr>");
            		out.print("<td>"+rs.getInt(1)+"</td>");
            		out.print("<td>"+rs.getString(2)+"</td>");
            		out.print("<td>"+rs.getString(3)+"</td>");
            		out.print("<td>"+rs.getString(4)+"</td>");
            		out.print("<td>"+rs.getString(5)+"</td>");
            		out.println("</tr>");
        		}
        		out.println("</table>");
        		out.println("<a href=\"tshirt.jsp\">click here</a>");
        		out.println("</body></html>");
            }
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}

	
