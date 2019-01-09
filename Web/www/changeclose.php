<?php
include "config.php";

$closeflag=$_GET['BOXnumb'];


$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "
  UPDATE boxidentity
    SET
      Driver = '0',
      HomeUser= '0'
    WHERE
      boxnum = '$closeflag'
";
$result = mysqli_query($conn, $sql);
echo "True/";
?>
