<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/09/2024
  Time: 08:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
</head>
<body>
<form action="" method="post">

    <div class="container">
        <label for="username"><b>Username</b></label>
        <input type="text" id="username" placeholder="Enter Username" name="username" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" id="psw" placeholder="Enter Password" name="password" required>

        <button type="submit">OK</button>

    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
    </div>
</form>
</body>
</html>
