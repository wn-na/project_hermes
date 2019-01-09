<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Search</title>
    <div id="logo">
    <h2><img src="logo.jpg" width=50%, height=50%> </h2><h1> 배송 목록 조회</h1>
    </div>

    <style>
    body{
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


    #menu {
      background-color : white;
      margin-top : 0;
      padding-left: 10px;
      text-align: center;
      font-size : 20px;
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
<?php
include "config.php";
$DID=$_GET['DIdentity'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "SELECT * FROM pdata WHERE DriverId='$DID' and ReceiveTime is NULL";

$result = mysqli_query($conn, $sql);
$count = mysqli_num_rows($result);
?>
<body>
  <div id="menu">
    내 기사 번호 = <?=$DID ?>

  </div>
   <div id = "waybill">
     <div id="submenu">
     조회결과
       </br>
     </div>

<table>
  <tr>
    <td><div style="text-align:center"> 운송장번호 </td></div>
    <td><div style="text-align:center"> 보낸 시간 </td></div>
    <td><div style="text-align:center"> 보낸 사람 </td></div>
    <td><div style="text-align:center"> 받은 사람 </td></div>
    <td><div style="text-align:center"> 택배 기사 </td></div>
    <td><div style="text-align:center"> 상품 명 </td></div>
  </tr>
<?php for($x = 0; $x < $count; $x++){
$row = mysqli_fetch_array($result)
  ?>
    <tr>
      <td><div style="text-align:center"><?=
      $row[Waybill]?></div></td>
      <td><div style="text-align:center"><?=
      $row[SendTime]?></div></td>
      <td><div style="text-align:center"><?=
      $row[Sender]?></div></td>
      <td><div style="text-align:center"><?=
      $row[Receiver]?></div></td>
      <td><div style="text-align:center"><?=
      $row[Driver]?></div></td>
      <td><div style="text-align:center"><?=
      $row[SendObject]?></div></td>
    </tr>
<?php }?>
</table>
</div>
</body>
