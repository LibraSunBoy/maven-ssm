<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html class="x-admin-sm">

    <head>
        <meta charset="UTF-8">
        <title>欢迎页面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
        <link rel="stylesheet" href="<%=basePath %>/css/font.css">
        <link rel="stylesheet" href="<%=basePath %>/css/xadmin.css">
        <script src="<%=basePath %>/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="<%=basePath %>/js/xadmin.js"></script>
        <script type="text/javascript" src="<%=basePath %>/js/dateform.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
                <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
            </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="account" placeholder="请输入用户名" autocomplete="off" class="layui-input"></div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                        <i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table" lay-data="{url:'<%=basePath %>/user/list',method:'get',page:true,limit:20,toolbar: '#toolbarDemo',id:'test'}">
                                <thead>
                                    <tr>
                                        <th lay-data="{type:'checkbox',width:80}">ID</th>
                                        <th lay-data="{field:'id',width:80, sort: true}">ID</th>
                                        <th lay-data="{field:'account'}">用户名</th>
                                        <th lay-data="{field:'role', edit: 'text'}">角色</th>
                                        <th lay-data="{field:'status', templet: '#status'}">状态</th>
                                        <th lay-data="{field:'createDate', templet: function(d){return layui.laytpl.toDateString(d.createDate)}}">创建时间</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/html" id="toolbarDemo">
        <div class = "layui-btn-container" >
            <button class = "layui-btn layui-btn-sm" lay-event = "getCheckData" > 获取选中行数据 </button>
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button >
            <button class = "layui-btn layui-btn-sm" lay-event = "isAll" > 验证是否全选</button>
        </div >
    </script>
    <script type="text/html" id="status">
        {{#  if(d.status == 1){ }}
        可用
        {{#  } else { }}
        禁用
        {{#  } }}
    </script>
    <script>
        layui.use('table',function() {
            var table = layui.table;

            //监听单元格编辑
            table.on('edit(test)',
            function(obj) {
                var value = obj.value //得到修改后的值
                ,
                data = obj.data //得到所在行所有键值
                ,
                field = obj.field; //得到字段
                layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
            });

            //头工具栏事件
            table.on('toolbar(test)',
            function(obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;
                };
            });
        });
    </script>

<%--    <script>var _hmt = _hmt || []; (function() {--%>
<%--            var hm = document.createElement("script");--%>
<%--            hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";--%>
<%--            var s = document.getElementsByTagName("script")[0];--%>
<%--            s.parentNode.insertBefore(hm, s);--%>
<%--        })();</script>--%>

</html>
