<%--
  Created by IntelliJ IDEA.
  User: godol
  Date: 2022/08/28
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Customers</title>

    <link type="text/css" rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/style.css/>
</head>
<body>

    <div id = "wrapper">
        <div id ="header">
            <h2>CRM - Customer Relationship Manager</h2>

        </div>
    </div>

    <div id = "container">
        <div id ="content">
            <input type="button" value="Add Customer" onclick="window.location.href ='showFormForAdd'; return false;" class="add-button">
           <table>
               <tr>
                   <th>First Name</th>
                   <th>Last Name</th>
                   <th>Email</th>
                   <th>Action</th>
               </tr>



               <c:forEach var="tempCustomer" items="${customers}">
                   <c:url var ="updateLink" value="/customer/showFormForUpdate">
                       <c:param name="customerId" value= "${tempCustomer.id}" />
                   </c:url>
                   <tr>
                       <td>${tempCustomer.firstName}</td>
                       <td>${tempCustomer.lastName}</td>
                       <td>${tempCustomer.email}</td>
                       <td><a href="${updateLink}">Update</a> </td>
                   </tr>
               </c:forEach>

           </table>

        </div>
    </div>

</body>
</html>
