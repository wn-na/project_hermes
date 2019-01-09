<?php
include "config.php";
$DID=$_GET['DIdentity'];
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "SELECT * FROM pdata WHERE DriverId='$DID' and ReceiveTime IS NULL";

$result = mysqli_query($conn, $sql);


while ($row = mysqli_fetch_array($result)){
  if($row[8] == 0) printf("false/NULL/");
    else {
    printf("true");
    echo "/$row[7]/";
    }
    printf("%s/%s/%s/%s/%s/",$row[0],$row[6],$row[3],$row[2],$row[4]);
 }
echo "return";
?>
