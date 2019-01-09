<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "
  INSERT INTO savelog
    (boxnumber, UserID, Code, Time, Log)
    VALUES(
      '{$_GET['boxnumber']}',
      '{$_GET['UserID']}',
      '{$_GET['Code']}',
      '{$_GET['Time']}',
      '{$_GET['Log']}'
      )";
if($result = mysqli_query($conn, $sql)) {
  echo "True/";
}
else {
  echo "False/";
}

?>
