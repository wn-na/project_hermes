<?php
include "config.php";

$bill = $_GET['Waybill'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "SELECT * FROM pdata WHERE Waybill = $bill";
$result = mysqli_query($conn, $sql);
$row = mysqli_fetch_array($result);
if($row[0]){
  echo "True/";
  for($i=0; $i<8; $i++){
    echo "$row[$i]/";
  }
    if($row[8])
      echo "$row[8]/";
    else
      echo "NULL/";
} else {
  echo "False/";
}

?>
