<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard - Contact Application </title>
        <link href="static/css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                font-family: Arial, Helvetica, Geneva, sans-serif;
                font-size: 18px;
                color: "green";
            }
            .error{
                color: #FF0000;
            }
            .success{
                color: #0000FF;
            }
        </style>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="static/images/bg.jpg">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="include/menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <h1>Admin Dashboard</h1>
                    todo - admin options in this page
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
