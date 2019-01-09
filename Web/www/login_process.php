<?php
include "config.php";
$id=$_GET['id'];
$pass=$_GET['password'];

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);

$sql = "SELECT * FROM puser WHERE ID = '$id' and PW = '$pass'";
$result=mysqli_query($conn, $sql);
$row = mysqli_fetch_array($result);

if(isset($row))
{
  if($row[TYPE]==1)
  echo "True/$row[Name]/$row[TYPE]/$row[boxnumber]/$row[Didentity]/";
  if($row[TYPE]==0)
  echo "True/$row[Name]/$row[TYPE]/$row[boxnumber]/";
}
else{
  echo "False/";
}
 ?>
