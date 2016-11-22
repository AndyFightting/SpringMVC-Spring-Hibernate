<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
    <h3>编辑用户</h3>  
    <form action="/SSH/user/updateUser" name="userForm" method="post">  
        <input type="hidden" name="id" value="${user.id }">  
        姓名：<input type="text" name="name" value="${user.name}">  
        密码：<input type="text" name="password" value="${user.password}">  
        <input type="submit" value="编辑" >  
    </form>  
</body>  
</html>