<?php
include "config.php";
session_start();
$boxnum=$_GET['BIdentity'];
$DriverIdentity=$_GET['DrIdentity'];
$WayBillc=$_GET['waybill'];


$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "SELECT * FROM pdata WHERE ReceiverID='$boxnum' and DriverId='$DriverIdentity' and Waybill='$WayBillc' and ReceiveTime IS NULL";

$result = mysqli_query($conn, $sql);
$row = mysqli_fetch_array($result);
$count = mysqli_num_rows($result);

if($count === 1){
  $_SESSION['bnumber']=$row[ReceiverID];
  $_SESSION['DriverID']=$row[DriverId];
  header("location:changesetting.php");
}
else {
  echo "false/";
}
?>
