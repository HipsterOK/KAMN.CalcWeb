package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Other.Calculator;
import Other.FileReaderClass;

@WebServlet("/calc")
public class Calc extends HttpServlet { //Сервлет для страницы калькулятора обычного работника
	private static final long serialVersionUID = 1L;
	public static int month;
	public static String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	         
		  Login.selectedId = Login.sessionId; //контроль Id сессии
			
		  	/*атрибуты для вывода на экран*/
	        request.setAttribute("name", FileReaderClass.usersObj.get(Login.selectedId).getName());
	         
	        getServletContext().getRequestDispatcher("/WEB-INF/views/calc.jsp").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
        //Получение значений логина и пароля с формы HTML-страницы
        month = Integer.valueOf(request.getParameter("selectMonth")); 
        Calculator.main(Login.selectedId, month);
        response.sendRedirect("result");
        
        Login.selectedId = Login.sessionId;
	}
}