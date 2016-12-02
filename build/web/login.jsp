<%-- 
    Document   : inscription
    Created on : 2016-11-29, 20:49:21
    Author     : soixa
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Login Membre</h1>  
       <form:form method="post" action="login.do" modelAttribute="membre">    
        <table >    
         <tr>    
          <td>Username : </td>   
          <td><form:input path="username"  /></td>  
         </tr>    
         <tr>    
          <td>Password :</td>    
          <td><form:input path="password" /></td>  
         </tr>         
         <tr>    
          <td></td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    