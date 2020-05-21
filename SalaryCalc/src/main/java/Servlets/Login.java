package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Other.FileReaderClass;

@WebServlet("/login")
public class Login extends HttpServlet { //Класс для проверки введеных логина и пароля 
	private static final long serialVersionUID = 1L;
	public static String login, password;
	public static int sessionId;
	public static int selectedId;
	public static boolean succesLoading;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        getServletContext().getRequestDispatcher("/WEB-INF/views/login.html").forward(request, response);
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!succesLoading) {
			FileReaderClass.main(); //проверка загрузки 
			succesLoading = true;
		}
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter wr = response.getWriter();
        //Получение значений логина и пароля с формы HTML-страницы
        login = request.getParameter("login"); 
        password = request.getParameter("password");
        /*
         * Выполнение метода проверки введенных данных
         * Если данные правильные, то пользователя перенаправляет на страницу калькулятора
         * Иначе пользователю выводится ошибка
         */
        if(checkLogAndPass()) {
        	if(FileReaderClass.usersObj.get(Integer.valueOf(login)).getRole() == 1) { //проверка роли пользователя
        	response.sendRedirect("calcManager"); //Перенаправление на страницу калькулятора для менеджера (Бухгалтера)
        	} else response.sendRedirect("calc"); //Перенаправление на страницу калькулятора для обычного работника
	}else
        	/*
    		 * Вывод страницы при неверных данных
    		 */
        	wr.println("<html>" +
        			"			<head>" + 
        			"				<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">" +  
        			"               <title>Неверный логин или пароль</title>" +
        			"			</head>" +
        			"			<body>" + 
        			"       		<form class=\"form-horizontal\" action=\"login\">" +
        			"                   <h2 class=\"w3-text-teal\">Неверный логин или пароль</h2>" +
        			"					<p><button class=\"w3-btn w3-teal\">Повторить</button></p>" + 
        			"       		</form>" +
        			"			</body>" +
        			"		</html>");
	}
	
	public static boolean checkLogAndPass() throws IOException {//Метод проверки введенных логина и пароля
	    /*
	     * Цикл для проверки введенных данных
	     */
	    for(int i=0; i<FileReaderClass.usersObj.size(); i++){ 
	    	if(login.equals(String.valueOf(FileReaderClass.usersObj.get(i).getId())) && password.equals(FileReaderClass.usersObj.get(i).getPassword())) {
	    		sessionId=i; // номер сессии равен Id пользователя
	    		return true;
	    	}	
	    }
		return false; 
	}
}

