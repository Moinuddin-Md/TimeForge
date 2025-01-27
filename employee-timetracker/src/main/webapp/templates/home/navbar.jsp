<%@ page isELIgnored="false" %>
<html>
 <head>
  <script src='/employee-timetracker/JS/script.js'></script>
  <link href='/employee-timetracker/CSS/style.css' rel='stylesheet'>
  <link href='/employee-timetracker/CSS/bootstrap.min.css' rel='stylesheet'>
 </head>
 <body bgcolor='cyan'>
   <hr style='border:2px solid green'>
    <nav class='navbar navbar-expand navbar-light bg-light'>
     <ul class='nav nav-pills mx-auto'>
      <li><a id="home" class='nav-link lau' href='/employee-timetracker'>Home</a>
      <li><a id='add' class='nav-link lau' href='/employee-timetracker/employee/add'>Add employee</a>
      <li><a id='out' class='nav-link lau' href='/employee-timetracker/time/out/employee-list'>Time Out</a>
      <li><a id='in' class='nav-link lau' href='/employee-timetracker/time/in/employee-list'>Time In</a>
      <li><a id='datewise' class='nav-link lau' href='/employee-timetracker/reports/datewise/choose'>Date wise report</a>
      <li><a id='emp' class='nav-link lau' href='/employee-timetracker/time/empwise/report/choose-employee'>Employee wise report</a>
     </ul>
    </nav>
   <hr style='border:2px solid green'>
 </body>
</html>