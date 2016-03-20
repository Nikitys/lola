<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding=
"UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Введите имя автора</title>
</head>
<body>
<form METHOD=GET action="AuthorProcessor">
Введите ФИО автора книги <br>
<INPUT TYPE=TEXT NAME="author"
<%
// Выбор всех Cookie
Cookie [] c = request.getCookies();
if(c != null)
for(int i = 0; i < c.length; i++)
if("book.author".equals(c[i].getName())) {
// Запись значения в поле ввода, если найден Cookie
out.print(" value='" + URLDecoder.decode(c[i].getValue(), "UTF-8") + "' ");
break;
}
%>
> <br>
<INPUT TYPE=SUBMIT value="Ввод">
</form>
</body>
</html>