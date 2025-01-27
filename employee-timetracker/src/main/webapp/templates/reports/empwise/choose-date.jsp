<%@page import="java.time.LocalDate"%>
<%@ include file="/templates/home/navbar.jsp" %>
<html>
  <body onload="makeActive('emp')">
  <div class='dvv'>
    <label class='lahu'>View date wise report of  </label><span style='font-size:2vw;margin-left:1vw'>${name}</span>
  </div>
   <table class='ta'>
    <tr>
     <td class='pd'>
      <form action='curdate'>
       <input type="hidden" name='eid' value='${eid}'>
       <table class='cdta'>
        <tr>
         <td>Current date</td>
         <td align="right"><button class='cdbt'>GO</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
    <tr>
     <td class='pd'>
      <form action='anydate'>
       <input type="hidden" name='eid' value='${eid}'>
       <table class='cdta'>
        <tr>
         <td>Any date</td>
         <td><input type='date' class='tb' max="${cdate}" name='date' style='width:15vw' required></td>
         <td align="right"><button class='cdbt'>GO</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
    <tr>
     <td class='pd'>
      <form action="date-between">
       <input type="hidden" name='eid' value='${eid}'>
       <table class='cdta'>
        <tr>
         <td>Date between&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td><input type='date' class='tb' id='date1' max="${cdate}" name="date1" style='width:15vw' required></td>
         <td><input type='date' class='tb' id='date2' max="${cdate}" name="date2" style='width:15vw' required></td>
         <td align="right"><button class='cdbt' onclick='return compareDate()'>GO</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
   </table>
 </body>
</html>