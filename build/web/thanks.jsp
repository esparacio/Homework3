<%-- 
  Document   : thanks
  Created on : Oct 14, 2015, 2:14:58 PM
  Author     : (c) Elena Sparacio and Jamie Utt
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:import url="/includes/header.html"/>
  <body>
    <h1>Future Value Calculator</h1>

    <table>
        <tr>
            <td><label class="box">Investment Amount:</label> </td>
            <td class="gouda"> <span class="value">${user.IACurrency}</span><br></td>
    </tr>
    <tr>
        <td><label class="box">Yearly Interest Rate:</label></td>
        <td class="gouda"><span class="value">${user.yearlyRate}</span><br></td>
    </tr>
    <tr>
        <td><label class="box">Number of Years:</label></td>
        <td class="gouda"><span class="value">${user.numYears}</span><br></td>
    </tr>
    <tr>
        <td><label class="box">Future Value:</label></td>
        <td class="gouda"><span class="value">${user.FVCurrency}</span></td>
    </tr>
    
        <%@ taglib uri="/WEB-INF/elon.tld" prefix="cf" %>
        <tr>
        <th class="years">Year</th>
        <th class="ftvalue">Value</th>
      </tr>  
        <cf:currency>
      <tr>
          <td class="years">${years}</td>
          <td>${importantValues}</td>
      </tr>
         </cf:currency>


    </table>
        <a href ="index.jsp"> Return to Calculator </a>
     <c:import url="/includes/footer.html"/>
  </body>
</html>

