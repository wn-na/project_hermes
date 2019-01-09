<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$boxnumber=$_GET['boxidentity'];
$boxcvcn = $_GET['cvc'];

$sql = "SELECT * FROM boxidentity WHERE boxnum = '$boxnumber' and boxcvc = '$boxcvcn'";
$result = mysqli_query($conn, $sql);
$row = mysqli_fetch_array($result);
$count = mysqli_num_rows($result);

if($count == 1)
{
  echo "True/";
}
else{
  echo "False/";
}
 ?>
