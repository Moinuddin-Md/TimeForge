<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ include file="/templates/home/navbar.jsp" %>
<html>
 <body onload='makeActive("datewise")'>
  <div class='dvv'>
     <label class='hdu'>Report of date ${date}</label>
  </div>
  <div class='container'>
   <div class='card mx-auto'>
     <div class='card-body'>
      <c:if test='${tlist=="[]"}'>
       <div class="dvv">
         <label style='color:red;font-size:2vw'>No reports available</label>         
       </div>
      </c:if> 
      <c:if test='${tlist!="[]"}'>
      <div class='table scrollit'>
       <table class='table table-hover'>
        <thead>
         <tr>
          <th>S.No</th><th>Emp Id</th><th>Out Time</th><th>In Time</th><th>Total Time</th><th>Date</th>
         </tr> 
        </thead>
        <tbody>
        <c:set value="0" var="sn"></c:set>
        <c:forEach var="timeinfo" items="${tlist}">
           <tr style='color:${timeinfo.intime=="Not in yet"?"red":"green"}'> 
         	<td>${sn=sn+1}</td>
         	<td>${timeinfo.eid}</td>
         	<td>${timeinfo.outtime}</td>
         	<td>${timeinfo.intime}</td>
         	<td>${timeinfo.totaltime}</td>
         	<td>${timeinfo.date}</td>
           </tr>
        </c:forEach>
        </tbody>
       </table>
      </div>
      </c:if>
     </div>
   </div> 
  </div>
  <div style='text-align: center;margin-top:10px'>
   <input type='button' value='Back' onclick='history.back()' class='btr' style='background-color:orange'>
  </div>
 </body>
</html>