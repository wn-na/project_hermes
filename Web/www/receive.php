<?php
include "config.php";
$waybill=$_GET['waybill'];
$boxID=$_GET['boxID'];
$UserID=$_GET['UserID'];
$product=$_GET['product'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "
  UPDATE pdata
    SET
      ReceiveTime = NOW()
    WHERE
      Waybill = '$waybill'
";
$result = mysqli_query($conn, $sql);
mysqli_close($conn);

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "
  INSERT INTO savelog ( boxnumber, UserID, Time, Log)
    VALUES(
      '$boxID',
      '$UserID',
      NOW(),
      '$product'
  );
";
mysqli_query($conn, $sql);
mysqli_close($conn);

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "
  UPDATE boxidentity
    SET
      Driver = '0',
      HomeUser= '0'
    WHERE
      boxnum = '$boxID'
";
mysqli_query($conn, $sql);

echo "True/";
?>
