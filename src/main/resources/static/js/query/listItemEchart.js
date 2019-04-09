$(function(){
    var columnsArray = [];
    var tableText = window.localStorage.getItem('tableText');
    var tables="";
    if(tableText!=null&&tableText!=""){
        tables=tableText.split(",");
	}
    columnsArray.push({
        field : '',
        title: '序号',
        width:30,
        halign: 'center',
    });
    for(var i=0;i<tables.length;i++){
        var field=tables[i].split("-")[0].substring(tables[i].split("-")[0].indexOf(".")+1,tables[i].split("-")[0].length);
        var title=tables[i].split("-")[1];
        columnsArray.push({
            field : field,
            title:  title,
            width:30,
            halign: 'center'
        });
    }
    refreshTable(columnsArray);
    $("#addList").click(function(){
    	var tmplId = window.localStorage.getItem('tmplId',tmplId);
    	if(tmplId == null || tmplId == '' || tmplId == 'undefined'){
    		tmplId = '';
    	}
        var index =layer.open({
            type : 2,
            title : '列表项',
            maxmin : true,
            shadeClose : false, // 点击遮罩关闭层
            area : [ '800px', '630px' ],
            content : '/item/toEchart?tmplId=' + tmplId // iframe的url
            	,btn: ['保存']
	        ,yes: function(index, layero){
	        	saveListItem(layero);
				layer.close(index);
	        }
            ,success:function (index, layero) {
                $(":focus").blur();
            }
        });
    })
})
function saveListItem(layero){
	var objSpanKeys = $(layero).find("iframe")[0].contentWindow.document.getElementById('selectedItem').getElementsByClassName('spanKey');
	var objSpanNames = $(layero).find("iframe")[0].contentWindow.document.getElementById('selectedItem').getElementsByClassName('spanName');
	var columnsArray = [];
	var tableListItem = '';
	var tableText = ''
	var len = objSpanKeys.length;
    columnsArray.push({
        field : '',
        title: '序号',
        width:30,
        halign: 'center',
    });
	for(var i = 0; i<len; i++){
		var property = objSpanKeys[i].innerHTML;
		var value = objSpanNames[i].innerHTML;
		columnsArray.push({
			"title" : value,
			"field" : property.substring(value.indexOf("."),value.length),
		});
		if(i >= (len - 1)){
			tableListItem = tableListItem + property;
		}else{
			tableListItem = tableListItem + property + ',';
		}
		
		if(i >= (len - 1)){
			tableText += property+"-"+value;
		}else{
			tableText += property+"-"+value + ',';
		}
	}
	window.localStorage.setItem('tableListItem',tableListItem);
	window.localStorage.setItem('tableText',tableText);
	//alert(window.localStorage.getItem('tableListItem'));
	refreshTable(columnsArray);
}

function refreshTable(columnsArray){
		$("#tableListItem",window.parent.document).bootstrapTable('destroy').bootstrapTable({
	        ajaxOptions: {
	            async: false // 如果设置为异步，需要等请求成功后才会生成下面的tr和td，就无法在td中添加按钮
	        },
	        iconSize : 'outline',
	        toolbar : '#exampleToolbar',
	        striped : true, // 设置为true会有隔行变色效果
	        dataType : "json", // 服务器返回的数据类型
	        pagination : false, // 设置为true会在底部显示分页条
	        singleSelect : false, // 设置为true将禁止多选
	        pageSize : 10, // 如果设置了分页，每页数据条数
	        pageNumber : 1, // 如果设置了分布，首页页码
	        showColumns : false, // 是否显示内容下拉框（选择显示的列）
	        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
			columns:columnsArray,
			formatNoMatches: function(){
				return "";
			}
		});
}

