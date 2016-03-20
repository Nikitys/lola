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
// ������
private static final String [] authors = {"��������", "�������"};
 public AuthorProcessor() {
 super();
 }
 protected void processRequest(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
 response.setContentType("text/html; charset=UTF-8");
 request.setCharacterEncoding("utf-8");
 // ��������� ��������� �� ������ �������
 String parameter = request.getParameter("author");
 System.out.println(parameter);
 if(parameter == null) {
 // ��������� �� ������, ���� ������� ������ ��� ���������
 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "�� ������ ��� ������");
 return;
 }
 // ��������, ��� ����� ����� ����
 boolean haveBooks = false;
 for(int i = 0; i < authors.length; i++)
 if(parameter.equals(authors[i])){
 haveBooks = true;
 break;
 }
 if(!haveBooks) { // ��������� �� ������, ���� ����� �� ������
 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "����� � �������� " + parameter + " �� ������");
 return;
 }
 // ���������� ������ � ������
 request.getSession().setAttribute("author", parameter);
 // ���������� ������ � Cookie
 Cookie c = new Cookie("book.author", URLEncoder.encode(parameter, "UTF-8"));
 // ��������� ������� ����� Cookie � ��������
 c.setMaxAge(100);
 response.addCookie(c);
 // ��������������� �� �������� ����
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