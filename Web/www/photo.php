<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Photo</title>

     <script type="text/javascript">

function realtimeClock() {
  document.rtcForm.rtcInput.value = getTimeStamp();
  setTimeout("realtimeClock()", 1000);
}


function getTimeStamp() { // 24시간제
  var d = new Date();

  var s =
    leadingZeros(d.getFullYear(), 4) + '-' +
    leadingZeros(d.getMonth() + 1, 2) + '-' +
    leadingZeros(d.getDate(), 2) + ' ' +

    leadingZeros(d.getHours(), 2) + ':' +
    leadingZeros(d.getMinutes(), 2) + ':' +
    leadingZeros(d.getSeconds(), 2);

  return s;
}


function leadingZeros(n, digits) {
  var zero = '';
  n = n.toString();

  if (n.length < digits) {
    for (i = 0; i < digits - n.length; i++)
      zero += '0';
  }
  return zero + n;
}

</script>
    <style>
    h1 {
      background-color : white;
     font-size:100px;
     text-align: center;
     margin:0;
     padding:20px;
     padding-top:50px;
     font-family: "돋움", sans-serif;
    }
    p {
    text-align: center;
    font-size:50px;
	
    }
    #errorcode{
		color:#ff0000;
		text-align: center;
		font-size:45px;
		padding-bottom:50px;	
    }
      #showTime{
      	font-size:50px;
      text-align: center;
      padding-bottom:50px;
      border-bottom:5px solid #1b1b1b;
    }
    </style>
     
  </head>
  <body onload="realtimeClock()">
  <div id="errorcode">ERROR : 현재 카메라가 작동하고 있지 않습니다.</div></br>

     <div id="showTime"> 현재시간  <form name="rtcForm">
<input style="text-align:center;font-size:50pt" type="text" name="rtcInput" readonly="readonly" />
</form>
     
    </div>

    
    
    <p>
      가장 최근에 촬영된 사진입니다.</br>
      2018-06-09 18:26:55
    </p>
    <p>
    <img src="2018-05-28-18-26-55.bmp" width=80% height=80%>
  </p>





  </body>
