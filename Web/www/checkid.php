<?php
include "config.php";
$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

  $id=$_GET['id'];

  $sql= "SELECT * FROM puser WHERE ID= '$id'";
    $result = mysqli_query($conn, $sql);
  $count = mysqli_num_rows($result);

  if($id == ''){
    echo 'False/';
  }
  else{
    if($count == 0){
      echo 'True/';
    }
    else{
        echo'False/';
    }
  }
?>
