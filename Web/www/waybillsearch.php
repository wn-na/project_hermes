<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Search</title>
    <div id="logo">
    <h2><img src="logo.jpg" width=50%, height=50%> </h2><h1> 운송장 조회</h1>
    </div>
    <script type="text/javascript">

function realtimeClock() {
  document.rtcForm.rtcInput.value = getTimeStamp();
  setTimeout("realtimeClock()", 1000);
}


function getTimeStamp() { // 24시간제
  var d = new Date();

  var s =
    leadingZeros(d.getFullYear(), 4) + '-' +
    leadingZeros(d.getMonth() + 1, 2) + '-' +
    leadingZeros(d.getDate(), 2) + ' ' +

    leadingZeros(d.getHours(), 2) + ':' +
    leadingZeros(d.getMinutes(), 2) + ':' +
    leadingZeros(d.getSeconds(), 2);

  return s;
}


function leadingZeros(n, digits) {
  var zero = '';
  n = n.toString();

  if (n.length < digits) {
    for (i = 0; i < digits - n.length; i++)
      zero += '0';
  }
  return zero + n;
}

</script>
    <style>
    body{
      background-color: #F6F6F6;
      margin-left: 80px;
      margin-right: 80px;
      margin-top : 0px;
    }
    h1 {
      background-color : white;
     font-size:45px;
     text-align: center;
     border-bottom:1px solid #eeeeee;
     margin:0;
     padding:20px;
     padding-top:50px;
     font-family: "돋움", sans-serif;
    }
    h2{
    	 background-color : white;
     font-size:45px;
     text-align: center;
     border-bottom:1px solid #eeeeee;
     margin:0;
     padding:20px;
     padding-top:30px;
     font-family: "돋움", sans-serif;
    }
    table {
      width: 100%;
      border-top: 3px solid #444444;
      border-left: 2px solid #ffffff;
      border-right: 2px solid #ffffff;
      border-bottom: 1px solid #c1c1c1;
      border-collapse: collapse;
    }
    th {
      border-bottom: 1px solid #c1c1c1;

      padding: 10px;
    }
    td{
      border-bottom: 1px solid #c1c1c1;
      border : 1px solid #c1c1c1;
      padding: 10px;
    }

	#logo{
		display : grid;
		grid-template-columns: 1fr 1fr;
	}

    #menu {
      background-color : white;
      margin-top : 0;
      padding-left: 10px;
      text-align: right;
      font-size : 13px;
      padding:20px;
      border-bottom:1px solid #eeeeee;
    }

    #grid{
      background-color : white;
      display: grid;

      grid-template-columns: 150px 1fr;
    }
    #waybill{
      table-layout: center;
      padding-top : 20px;
      background-color : white;
      padding-bottom: 50px;
      padding-left:50px;
      padding-right:50px;
    }
    #showTime{
      background-color : white;
      margin-top : 0;
      padding-left: 10px;
      text-align: center;
      font-size : 20px;
      padding:20px;
    }
    #submenu{
      font-size : 20px;
      color : #0079c3;
      font-weight: bold;
      margin-left: 15px;
    }
    <style type="text/css">
   a:link { color:black; text-decoration: none;}
   a:visited { color: black; text-decoration: none;}
   a:hover { color: black; text-decoration: none;}
   a {text-decoration:none}
  </style>

    </style>
  </head>

<body onload="realtimeClock()">
  <div id="menu">
    <a href = "waybillsearch.php">운송장 입력</a>
  &emsp;&emsp;
  <a href = "about.html">About Hermes</a>
 </div>
 <div id="showTime">
<?php
echo "현재 시간";

?>
<form name="rtcForm">
<input style="text-align:center" type="text" name="rtcInput" size="20" readonly="readonly" />
</form>

 </div>

<div id="waybill">
<div id="submenu">
  기사 정보
</div>
<table>
  <form action="waybillsearchweb_process.php" method="GET">
  <tr><p> <td><div style="text-align:center">운송장번호</td><td><input type="int" name="waybill" placeholder="운송장번호"></td></p></tr>
  </table>
<p><input style="text-align=right" type="submit"></p>
</form>
</div>
</body>
</html>
