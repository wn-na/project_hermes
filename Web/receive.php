<?php
include "config.php"
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
      '$product"가 도착했습니다"'
  );
";
mysqli_query($conn);
echo "True/";
?>
