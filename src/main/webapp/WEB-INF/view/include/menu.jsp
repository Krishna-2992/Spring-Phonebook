<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@page session="true" %>
<%@ page isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<c:if test="${sessionScope.userId==null}">
    <%-- User is not yet logged in : Guest Menu --%>
    <a href="index">Home</a> | <a href="index">Login</a> | <a href="reg_form">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
    <%-- Admin is logged in : Admin Menu --%>
    <a href="#">Home</a> | <a href="admin_users">User List</a> | <a href="logout">Logout</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
    <%-- General User is logged in : User Menu --%>
    <a href="user_dashboard">Home</a> | <a href="user_contact_form">Add Contact</a> | <a href="user_clist">Contact List</a> | <a href="logout">Logout</a>
</c:if>
