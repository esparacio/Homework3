<%-- 
  Document   : index
  Created on : Oct 14, 2015, 2:14:58 PM
  Author     : (c) Elena Sparacio and Jamie Utt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:import url="/includes/header.html"/>
  <body>
    <h1>Future Value Calculator</h1>
    <section>
      <form action="calculate" method="post">
        <input type="hidden" name="action" value="add"> 
        <p><i>${message}</i></p>
        <p><label>Investment Amount </label><input name="investAmount" type="text" value="${investAmount}" /></p>
        <p><label>Yearly Interest Rate </label><input name="yearlyRate" type="text" value="${yearlyRate}" /></p>
        <p><label>Number of Years </label><input name="numYears" type="number" value="${user.numYears}" placeholder="Integer Number of Years" /></p>
        <p><input class= "butt" type="submit" value="Calculate"></p>
      </form>
    </section>
        <c:import url="/includes/footer.html"/>
  </body>
</html>  