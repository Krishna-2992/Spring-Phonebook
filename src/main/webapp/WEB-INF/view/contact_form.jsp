<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Form - Contact Application </title>
        <link href="static/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
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
                    <h3>Contact Form</h3>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                    <f:form action="user_save_contact" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>Name</td>
                                <td><f:input path="name" /> </td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="phone" /> </td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="email" /> </td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><f:textarea path="address" /> </td>
                            </tr>
                            <tr>
                                <td>Remark</td>
                                <td><f:textarea path="remark" /> </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <button>Save</button>
                                </td>
                            </tr>
                        </table>
                    </f:form>
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