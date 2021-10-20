<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QrCode生成画面</title>
</head>

<script src="https://cdn.bootcss.com/jquery/1.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<body>

<div id="qrcode">

</div>
</body>
<script>
    $("#qrcode").qrcode({
        width:364,
        height:364,
        text:"${codeUrl}"
    })
</script>
</html>