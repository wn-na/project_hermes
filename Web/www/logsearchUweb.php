<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Search</title>
        <div id="logo">
    <h2><img src="logo.jpg" width=50%, height=50%> </h2><h1> 로그 조회</h1>
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
    #warning{
    	color:#e34a00;
    }
    #error{
    	color:#820000;}

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
$UsrID = $_GET['userid'];


$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
  $sql="SELECT * FROM savelog WHERE UserID = '$UsrID'";

$result = mysqli_query($conn, $sql);
$count = mysqli_num_rows($result);
?>
<body>
  <div id="menu">
    검색 ID = <?= $UsrID?>

  </div>
   <div id = "waybill">
     <div id="submenu">
     조회결과
       </br>
     </div>

<table>
  <tr>
    <td><div style="text-align:center"> 보관함 번호 </td></div>
    <td><div style="text-align:center"> UserID </td></div>
    <td><div style="text-align:center"> Time </td></div>
    <td><div style="text-align:center"> Log </td></div>
  </tr>
<?php for($x = 0; $x < $count; $x++){
$row = mysqli_fetch_array($result);
  if($row[Code]=="ERR002" || $row[Code]=="ERR009"){
  ?>
    <tr>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#ff0000'>$row[boxnumber]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#ff0000'>$row[UserID]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#ff0000'>$row[Time]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#ff0000'>$row[Log]</div>";?></div></td>
    </tr>
  <?php }
  else if($row[Code]=="POS03" || $row[Code]=="ERR001" || $row[Code]=="HOM03"){
      ?>
       <tr>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#2020d8'>$row[boxnumber]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#2020d8'>$row[UserID]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#2020d8'>$row[Time]</div>";?></div></td>
      <td><div style="text-align:center"><?php
      echo "<div style = 'color:#2020d8'>$row[Log]</div>";?></div></td>
    </tr>
   <?php }
   else{?>
     <tr>
      <td><div style="text-align:center"><?=
      $row[boxnumber]?></div></td>
      <td><div style="text-align:center"><?=
      $row[UserID]?></div></td>
      <td><div style="text-align:center"><?=
      $row[Time]?></div></td>
      <td><div style="text-align:center"><?=
      $row[Log]?></div></td>
    </tr>
    <?php }?>
<?php }?>
</table>
</div>
</body>
