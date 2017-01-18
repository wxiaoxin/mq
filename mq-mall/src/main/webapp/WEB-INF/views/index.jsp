<%
    String path = request.getContextPath();
    request.setAttribute("path", path);
%>
<%@ page contentType="text/html; utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单消息队列测试页</title>
</head>
<body>

<div>

    <p>
        <label for="itemNameIn">商品名称:</label>
        <input type="text" id="itemNameIn" placeholder="商品名称">
    </p>

    <p>
        <label for="itemNumberIn">商品个数:</label>
        <input type="number" id="itemNumberIn" placeholder="商品个数">
    </p>

    <p>
        <label for="price">商品价格:</label>
        <input type="text" id="price" placeholder="商品价格">
    </p>

    <button id="sendOrderMsgBtn" onclick="sendOrderMsg()">发送订单队列消息</button>

</div>

<script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>

<script>

    function sendOrderMsg() {

        var itemName = $("#itemNameIn").val();
        var itemNumber = $("#itemNumberIn").val();
        var price = $("#price").val();

        console.log(itemName);
        console.log(itemNumber);
        console.log(price);

        $.ajax({
            url: "${path}/order",
            type: "post",
            dataType: "json",
            data: {
                "itemName": itemName,
                "itemNumber": itemNumber,
                "price": price
            },
            success: function (response) {
                if (response.flag) {
                    alert(response.msg);
                } else {
                    alert("发送订单消息失败");
                }
            },
            error: function () {
                alert("请求失败");
            }
        })

    }

</script>

</body>
</html>
