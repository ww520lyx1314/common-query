$(function(){
    $("#echart").click(function(){
        var index =layer.open({
            type : 2,
            title : '查询结果',
            maxmin : true,
            shadeClose : false, // 点击遮罩关闭层
            area : [ '1200px', '600px' ],
            content : '/cardreperson/queryCustomCondition/toEchart' // iframe的url
            ,success:function (index, layero) {
                $(":focus").blur();
            }
        });
    })
})