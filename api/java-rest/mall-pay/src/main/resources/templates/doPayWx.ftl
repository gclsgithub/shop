<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QrCode生成画面</title>
</head>

<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<body>

<div id="qrcode"></div>
<div id="orderId" hidden>${orderId}</div>
<div id="returnUrl" hidden>${returnUrl}</div>
</body>
<script>
    $("#qrcode").qrcode({
        width:364,
        height:364,
        text:"${codeUrl}"
    })

    $(function () {
        //定时器
        setInterval(function () {
            console.log('微信支付--开始查询支付状态...')
            $.ajax({
                'url': '/pay/queryByOrderId',
                data: {
                    'orderId': $('#orderId').text()
                },
                success: function (result) {
                    console.log(result)
                    if (result.platformStatus != null
                        && result.platformStatus === 'SUCCESS') {
                        location.href = $('#returnUrl').text()
                    }
                },
                error: function (result) {
                    alert(result)
                }
            })
        }, 20000)
    });
</script>
</html>