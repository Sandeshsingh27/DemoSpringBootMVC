<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome

    <form action="addAlien" method="post">
        Enter your id: <input type="text" name="aid"><br>
        Enter your name: <input type="text" name="aname"><br>
        <input type="submit" value="submit"><br>
    </form>
    <hr>
    <form action="getAlien">
        Enter your id: <input type="text" name="aid"><br>
        <input type="submit" value="submit"><br>
    </form>
    
    <hr>
    <form action="getAlienByName">
        Enter your name: <input type="text" name="aname"><br>
        <input type="submit" value="submit"><br>
    </form>
</body>
</html>
