<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$boxnum=$_GET['boxID'];
$sql="SELECT * FROM boxidentity WHERE boxnum = '$boxnum'";
$result=mysqli_query($conn, $sql);
while ($row = mysqli_fetch_array($result)){
  echo $row[HomeUser];
  echo '/';
}
?>
