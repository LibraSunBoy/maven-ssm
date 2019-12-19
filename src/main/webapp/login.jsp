<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>后台登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="<%=basePath %>/css/font.css">
    <link rel="stylesheet" href="<%=basePath %>/css/login.css">
    <link rel="stylesheet" href="<%=basePath %>/css/xadmin.css"/>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="<%=basePath %>/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

    <div class="login layui-anim layui-anim-up">
        <div class="message">管理登录</div>
        <div id="darkbannerwrap"></div>

        <form id="login" class="layui-form">
            <input name="account" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="pwd" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input id="commit" value="登录"  style="width:100%;" type="button">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {

            $("#commit").click(function () {
                $.ajax({
                    url: "<%=basePath %>/user/login",
                    type: "post",
                    //.serialize() 当提交多条表单数据时，我们可以采用当表单进行序列化的方式简化原有的操作
                    data: $("#login").serialize(),
                    dataType: "json",
                    success: function (result) {
                        console.info(result);
                        if (result.code == 200) {
                            sessionStorage.setItem("USER",result.data.account);
                            sessionStorage.setItem("ROLE",result.data.role);
                            location.href='jsp/index.jsp';
                        } else {
                            alert(result.msg);
                        }
                    }
                })
            })

            // layui.use('form', function(){
            //   var form = layui.form;
            //   // layer.msg('玩命卖萌中', function(){
            //   //   //关闭后的操作
            //   //   });
            //   //监听提交
            //   form.on('submit(login)', function(data){
            //     // alert(888)
            //     layer.msg(JSON.stringify(data.field),function(){
            //         location.href='jsp/index.jsp'
            //     });
            //     return false;
            //   });
            // });
        })
    </script>
<%--    <!-- 底部结束 -->--%>
<%--    <script>--%>
<%--    //百度统计可去掉--%>
<%--    var _hmt = _hmt || [];--%>
<%--    (function() {--%>
<%--      var hm = document.createElement("script");--%>
<%--      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";--%>
<%--      var s = document.getElementsByTagName("script")[0];--%>
<%--      s.parentNode.insertBefore(hm, s);--%>
<%--    })();--%>
<%--    </script>--%>
</body>
</html>
