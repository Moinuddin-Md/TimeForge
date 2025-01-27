<%@ include file="/templates/home/navbar.jsp" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
 <body onload="makeActive('emp')">
 <form action="choose-date" method="post">
  <div class='dv'>
   <label class='hdu'>View reports employee wise</label>
  </div>
  <div class='dv'>
   <select name="name" id="name" class='la' onchange="checkEmployee(this)">
   	 <option value="-1">Select Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	   <option>${emp.name}(${emp.eid})</option>
   	 </c:forEach>
   </select>
  </div>
  <div class='dv'>
   <button disabled id='bt' class='btn btn-primary'>Submit</button>
  </div>
  <div class='dvv' id='msg'>
  </div> 
 </form> 
 </body>
</html>