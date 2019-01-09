<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$Typeu = $_GET['Type'];

if($Typeu === '0'){
$sql = "
  INSERT INTO puser
    (Name, ID, PW, Email, PhoneNum, boxnumber, boxpassword, TYPE)
    VALUES(
      '{$_GET['name']}',
      '{$_GET['id']}',
      '{$_GET['password']}',
      '{$_GET['email']}',
      '{$_GET['phone']}',
      '{$_GET['boxnumber']}',
      '{$_GET['boxcvc']}',
      '{$_GET['Type']}'
      )";
      if (mysqli_query($conn, $sql)) {
          echo "True/";
      } else {
          echo "False/";
      }
}
else if($Typeu=== '1'){
  $sql = "
    INSERT INTO puser
      (Name, ID, PW, Email, PhoneNum, boxnumber, boxpassword, TYPE, POSTCOMPANY, Didentity )
      VALUES(
        '{$_GET['name']}',
        '{$_GET['id']}',
        '{$_GET['password']}',
        '{$_GET['email']}',
        '{$_GET['phone']}',
        '{$_GET['boxnumber']}',
        '{$_GET['boxcvc']}',
        '{$_GET['Type']}',
        '{$_GET['PostCompany']}',
        '{$_GET['PostIdentity']}'
        )";
        if (mysqli_query($conn, $sql)) {
            echo "True/";
        } else {
            echo "False/";
        }
}
?>
