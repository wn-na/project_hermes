<?php
include "config.php";
$openflag=$_GET['BOXnumb'];
$ID=$_GET['usercode'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "
  UPDATE boxidentity
    SET
    Driver = '$ID'
  WHERE
    boxnum = '$openflag'
";

$result = mysqli_query($conn, $sql);
echo "True";
?>
