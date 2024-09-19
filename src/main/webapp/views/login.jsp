<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        form {border: 3px solid #f1f1f1;}

        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }

        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        .container {
            padding: 16px;
        }

        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <h2>LOGIN </h2>

<%--    <form action="/MVC/login" method="post">--%>
<%--        <c:if test = "${alterMsg != null}"> <h3 class="alter alter danger"> ${alterMsg}</h3> </c:if>--%>
<%--        <label for="fname">User name:</label><br>--%>
<%--        <input type="text" id="fname" name="username" value="" required><br>--%>
<%--        <label for="lname">Password:</label><br>--%>
<%--        <input type="text" id="lname" name="password" value="" required><br>--%>
<%--        <input type="submit" value="Login"><br>--%>
<%--        <input type="checkbox" checked = "checked" name="remember" > Remember me--%>
<%--    </form>--%>
    <form action="/MVC/login" method="post">

        <div class="imgcontainer">
            <img src="img_avatar2.png" alt="Avatar" class="avatar">
        </div>

        <c:if test = "${alterMsg != null}"> <h3 class="alter alter danger"> ${alertMsg}</h3> </c:if>

        <div class="container">
            <label for="username"><b>Username</b></label>
            <input type="text" id="username" placeholder="Enter Username" name="username" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" id="psw" placeholder="Enter Password" name="password" required>

            <button type="submit">Login</button>
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</body>
</html>
