<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);


$sql = "
  INSERT INTO pdata
    (Waybill, Sender, Receiver, ReceiverID, Driver, DriverID, SendObject, SendTime)
    VALUES(
      '{$_GET['Waybill']}',
      '{$_GET['Sender']}',
      '{$_GET['Receiver']}',
      '{$_GET['ReceiverID']}',
      '{$_GET['Driver']}',
      '{$_GET['DriverID']}',
      '{$_GET['object']}',
      NOW()
      )";
if (mysqli_query($conn, $sql)) {
  echo "True/";
  }
else {
  echo "False/";
}
?>
