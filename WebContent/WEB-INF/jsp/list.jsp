<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layui.css">
</head>
          

<body>

<div class="demoTable">
    搜索书本：
    <div class="layui-inline">
        <input class="layui-input" name="bookName" id="bookName"   placeholder="按书名" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="useruv"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>




<script>  
  
layui.use('table', function(){
    var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        ,url:'${pageContext.request.contextPath}/book/list'
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'id', width:120, title: 'ID', sort: true}  
            ,{field:'bookName', width:180, title: '书名'}  
            ,{field:'bookAuthor', width:120, title: '作者'}  
           ,{field:'publisher', width:100, title: '出版社'}  
            ,{field:'right', title: '操作', width:250,toolbar:"#barDemo"}
        ]]
        ,id: 'testReload'
        ,page: true
        ,limit:5   //默认十条数据一页  
        ,limits:[5,7,10]  //数据分页条  
       
    });
    
    var $ = layui.$, active = {
            reload: function(){
                var bookName = $('#bookName');

                table.reload('testReload', {
                    where: {
                    	bookName: bookName.val()
                    }
                });
            }
        };
    //监听表格复选框选择
    table.on('checkbox(useruv)', function(obj){
        console.log(obj)
    });

  //监听工具条
    table.on('tool(useruv)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                console.log(data);
                $.ajax({
                    url: '${pageContext.request.contextPath}/book/delete',
                    type: "POST",
                    data:{"id":data.id},
                    dataType: "json",
                    success: function(data){

                        if(data.state==1){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    }

                });
            });
        } else if(obj.event === 'edit'){

            layer.prompt({
                formType: 2
                ,title: '修改 ID 为 ['+ data.id +'] 的书名'
                ,value: data.bookName
            }, function(value, index){
                EidtUv(data,value,index,obj);
               


            });



        }
    });

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    function  EidtUv(data,value,index,obj) {
        $.ajax({
            url: '${pageContext.request.contextPath}/book/update',
            type: "POST",
            data:{"id":data.id,"bookName":value},
            dataType: "json",
            success: function(data){

                if(data.state==1){

                    layer.close(index);
                    //同步更新表格和缓存对应的值
                    obj.update({
                    	bookName: value
                    });
                    layer.msg("修改成功", {icon: 6});
                }else{
                    layer.msg("修改失败", {icon: 5});
                }
            }

        });
    }


});

    





</script>  



</body>
</html>