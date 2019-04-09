$(function(){
    $("#tableDb").click(function(){
        var index =layer.open({
            type : 2,
            title : '查询结果',
            maxmin : true,
            shadeClose : false, // 点击遮罩关闭层
            area : [ '1100px', '600px' ],
            content : '/cardreperson/queryCustomCondition/toTableDB' // iframe的url
            ,success:function (index, layero) {
                $(":focus").blur();
            }
        });
    })
})