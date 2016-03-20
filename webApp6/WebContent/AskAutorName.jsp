<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Отфильтрованный список книг</title>
</head>
<body>
<h1>Список книг</h1>
<table border='1'>
<tr>
<td><b>Автор книги</b></td>
<td><b>Название книги</b></td>
<td><b>Прочитал</b></td>
</tr>
<% if("Булгаков".equals((String)session.getAttribute("author"))) {%>
<tr>
<td>Булгаков</td>
<td>Мастер и Маргарита</td>
<td>Да</td>
</tr>
<% }
if("Пелевин".equals((String)session.getAttribute("author")))
{%>
<tr>
<td>Пелевин</td>
<td>Чапаев и пустота</td>
<td>Нет</td>
</tr>
<% } %>
</table>
</body>
</html>