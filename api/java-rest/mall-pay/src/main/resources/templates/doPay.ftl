<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QrCode生成画面</title>
</head>

<script src="/static/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="/static/jquery.qrcode.min.js"  type="text/javascript"></script>
<body>

<div id="qrcode">

</div>
</body>
<script>
    $("#qrcode").qrcode({
        width:64,
        height:64,
        text:"aa"
    })
</script>
</html>