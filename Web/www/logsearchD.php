<?php
include "config.php";
  $BoxID = $_GET['boxnum'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
  $sql="SELECT * FROM savelog WHERE boxnumber = '$BoxID'";

  $result = mysqli_query($conn, $sql);

  mysqli_stmt_execute($result);

While($row = mysqli_fetch_array($result)){
    if(isset($row)){
      printf("True/");
    }
    else {
      printf("False/");
    }
      echo "$row[1]/";
      echo "$row[2]/";
      echo "$row[3]/";
      echo "$row[4]/";
      echo '<br>';
   }


  ?>
