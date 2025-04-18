<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My JavaWeb</title>
</head>
<body>
	<h1>我的 JavaWeb 網頁</h1>
	<h2>Servlet 應用</h2>
	<ol>
		<li>   <%-- 絕對路徑 --%>
			<a href="http://localhost:8080/JavaWeb/hello">HelloServlet</a>(使用Model 0 [只用Servlet或JSP])
		</li>
		<li>   <%-- 像上面那樣寫有點冗長, 只要在相同網域的話前面可以省略 --%>
			<a href="/JavaWeb/lottery">LotteryServlet</a>(使用Model 1 [Servlet+JSP])   
		</li>  <%-- 改變子網站名稱可以到properties-web project settings修改, 但改過後記得重開Eclipse、Servers、Project clean(有點麻煩) --%>
	</ol>
	
</body>
</html>