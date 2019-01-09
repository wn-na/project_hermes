<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Waybilltest</title>

    <h1>운송장 추가 테스트 페이지</h1>
  </head>
  <body>
    <table border="1">
    <form action="waybill_createprocess.php" method="GET">
      <tr><p> <td><div style="text-align:center">Waybill </td><td><input type="text" name="Waybill" placeholder="운송장번호"></td></p></tr>
      <p> <td><div style="text-align:center">Sender</td><td><input type="text" name="Sender" placeholder="보내는사람"></td></p></tr>
      <p> <td><div style="text-align:center">Receiver</td><td><input type="text" name="Receiver" placeholder="받는사람"></td></p></tr>
      <p><td><div style="text-align:center">ReceiverID</td><td><input type="text" name="ReceiverID" placeholder="ReceiverID"></td></p></tr>
      <p><td><div style="text-align:center">Driver</td><td><input type="text" name="Driver" placeholder="Driver"></td></p></tr>
      <p><td><div style="text-align:center">DriverID</td><td><input type="text" name="DriverID" placeholder="DriverID"></td></p></tr>
      <p><td><div style="text-align:center">상품</td><td><input type="text" name="object" placeholder="DriverID"></td></p></tr>
      </table>
      <p><input type="submit"></p>
    </form>
  </body>
</html>
