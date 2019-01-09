<?php
include "config.php";
$ID=$_GET['usercode'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "
  SELECT * FROM puser WHERE ID='$ID'";
$result = mysqli_query($conn, $sql);
while ($row = mysqli_fetch_array($result)){
  echo $row[Name];
}
?>
