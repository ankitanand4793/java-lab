

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ITreturns
 */
@WebServlet("/ITreturns")
public class ITreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ITreturns() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
                String gender=request.getParameter("gender");
                int salary=Integer.parseInt(request.getParameter("salary"));
                int deduct=Integer.parseInt(request.getParameter("deduct"));
		int tax=(int) ((salary-deduct)*0.2);
		
        PrintWriter out=response.getWriter();
        File file = new File("1.txt");
        file.createNewFile();
        FileOutputStream fout = new FileOutputStream(file);
        out.println(" "+name+" "+gender+" "+salary+" "deduct+" "+tax);
        fout.write(("hello"+name+gender+salary+deduct+tax).getBytes());
        fout.close();
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
