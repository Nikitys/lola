package edu.etu.web6;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AuthorProcessor extends HttpServlet {
private static final long serialVersionUID = 1L;
// Авторы
private static final String [] authors = {"Булгаков", "Пелевин"};
 public AuthorProcessor() {
 super();
 }
 protected void processRequest(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
 response.setContentType("text/html; charset=UTF-8");
 request.setCharacterEncoding("utf-8");
 // Получение параметра из строки запроса
 String parameter = request.getParameter("author");
 System.out.println(parameter);
 if(parameter == null) {
 // Сообщение об ошибке, если сервлет вызван без параметра
 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Не задано имя автора");
 return;
 }
 // Проверка, что такой автор есть
 boolean haveBooks = false;
 for(int i = 0; i < authors.length; i++)
 if(parameter.equals(authors[i])){
 haveBooks = true;
 break;
 }
 if(!haveBooks) { // Сообщение об ошибке, если автор не найден
 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Автор с фамилией " + parameter + " не найден");
 return;
 }
 // Сохранение автора в сессии
 request.getSession().setAttribute("author", parameter);
 // Сохранение автора в Cookie
 Cookie c = new Cookie("book.author", URLEncoder.encode(parameter, "UTF-8"));
 // Установка времени жизни Cookie в секундах
 c.setMaxAge(100);
 response.addCookie(c);
 // Перенаправление на страницу книг
 response.sendRedirect(response.encodeRedirectURL(request.getContextPath() +
"/AskAutorName.jsp"));
 }
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}
}