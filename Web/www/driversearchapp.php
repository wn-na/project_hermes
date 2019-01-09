<?php
include "config.php";
  session_start();
  $Driver=$_GET['Driver'];
  $DriverID=$_GET['DriverID'];
//앱에서 기사 이름과 사번 받아오기

$conn = mysqli_connect($db_host,$db_user, $db_pass, $db_name);
$sql = "SELECT * FROM puser WHERE Name = '$Driver' and Didentity = '$DriverID'";
$result = mysqli_query($conn,$sql);
$row = mysqli_fetch_array($result);
?>
<body>
      <?= $row[Name]?>/<?= $row[POSTCOMPANY]?>/<?= $row[PhoneNum]?>/<?= $row[Didentity]?>/

</body>
</html>
