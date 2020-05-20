package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Other.Calculator;
import Other.FileReaderClass;

@WebServlet("/result")
public class Result extends HttpServlet { //Сервлет для страницы результата
	private static final long serialVersionUID = 1L;
	public static int month;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
		  
			/*атрибуты для вывода на экран*/
		    request.setAttribute("name", FileReaderClass.usersObj.get(Login.selectedId).getName()); 
	        request.setAttribute("zp", Calculator.zp);
	        if(FileReaderClass.usersObj.get(Login.sessionId).getRole()==0) {
	        	request.setAttribute("mesyac", Calc.monthName[Calc.month]);
	        } else request.setAttribute("mesyac", CalcManager.monthName[CalcManager.monthMan]);
	        request.setAttribute("oklad", FileReaderClass.usersObj.get(Login.selectedId).getOklad());
	        request.setAttribute("name", FileReaderClass.usersObj.get(Login.selectedId).getName());
	        request.setAttribute("roleName", FileReaderClass.usersObj.get(Login.selectedId).getRoleName());
	        request.setAttribute("workTime", FileReaderClass.usersObj.get(Login.selectedId).getWorkTime(Calc.month));
	        request.setAttribute("workTimeHours", FileReaderClass.usersObj.get(Login.selectedId).getWorkTimeHours(Calc.month));
	        request.setAttribute("premia", FileReaderClass.usersObj.get(Login.selectedId).getPrem());
	        request.setAttribute("nalog", Calculator.nalog);
	        request.setAttribute("nacislen", Calculator.nacislen);
	        request.setAttribute("finalZp", Calculator.finalZp);
	        request.setAttribute("nalog1", Calculator.nalog1);
	        request.setAttribute("nalog2", Calculator.nalog2);
	        request.setAttribute("nalog3", Calculator.nalog3);
	        request.setAttribute("nalog4", Calculator.nalog4);
	        
	        
	        Login.selectedId = Login.sessionId;
	        getServletContext().getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter wr = response.getWriter();

        month = Integer.valueOf(request.getParameter("selectMonth")); 
        Calculator.main(Login.selectedId, month);
        response.sendRedirect("result");
        Login.selectedId = Login.sessionId;
	}
}