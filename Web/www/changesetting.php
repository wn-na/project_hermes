<?php
include "config.php";
session_start();

$boxnumber=$_SESSION['bnumber'];
$DriverIDe =$_SESSION['DriverID'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "
  UPDATE boxidentity
    SET
      Driver = '$DriverIDe'
    WHERE
      boxnum = '$boxnumber'
";
$result = mysqli_query($conn, $sql);
echo "True/";
?>
