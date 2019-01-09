<?php
include "config.php";
session_start();
$boxnum=$_GET['BIdentity'];
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "SELECT * FROM pdata WHERE ReceiverID='$boxnum'";

$result = mysqli_query($conn, $sql);

mysqli_stmt_execute($result);

while ($row = mysqli_fetch_array($result)){
  if($row[9] == 1) printf("False/NULL/");
    else {
    printf("True");
    echo "/$row[0]/";
    }
    printf("%s/%s/%s/%s/%s/",$row[7],$row[1],$row[2],$row[4],$row[6]);


    echo '<br>';

 }

?>
