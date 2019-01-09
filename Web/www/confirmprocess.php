<?php
include "config.php";
$NAME=$_GET['Name'];
$DIdentity=$_GET['Didentity'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "SELECT * FROM drivercheck WHERE DName = '$NAME' and Didentity = '$DIdentity'";
$result=mysqli_query($conn, $sql);
$count = mysqli_num_rows($result);
$row = mysqli_fetch_array($result);

if($count == 1){
  echo "True/";
}
else{
  echo "False/";
}

 ?>
