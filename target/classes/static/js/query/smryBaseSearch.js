
var prefix = "/cardreperson/queryCustomCondition"
$(function() {
	load();

});

function load() {
    var sqlParams = window.localStorage.getItem('customSearch');
    var strData   = atob(sqlParams);
    var charData  = strData.split('').map(function(x){return x.charCodeAt(0);});
    var binData   = new Uint8Array(charData);
    var data    = pako.inflate(binData);
    var strData   = String.fromCharCode.apply(null, new Uint16Array(data));
    strData = decodeURIComponent(strData);
    mycolumn(strData);

}
function mycolumn(strData) {
    debugger;
    var columnsArray = [];
    var tableListItem = window.localStorage.getItem('tableListItem');
    var tableText = window.localStorage.getItem('tableText');
    columnsArray.push({
        field : 'number',
        title: '序号',
        width:30,
        halign: 'center',
        formatter: function (value, row, index) {
            //return index + 1;
            var pageSize = $('#exampleTable1').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
            var pageNumber = $('#exampleTable1').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
            var num= pageSize * (pageNumber - 1) + index + 1;//返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
            return "<div style='text-align:center; border: 0px;overflow: hidden; text-overflow:ellipsis' title='" + num + "'><nobr>"+num+"</nobr></div>";

        }
    });
    var tables=tableText.split(",");
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

    $('#exampleTable1')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/listSearch", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        sort:params.sort,
                        order:params.order,
                        strData:strData,
                        tableListItem:tableListItem
                    };
                },
                columns : columnsArray
            });
}

function edit(id) {
    var index =layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
        ,closeBtn:false
        ,btn: ['保存', '关闭']
        ,yes: function(index, layero){
            var iframeWin = window[layero.find('iframe')[0]['name']];
            iframeWin.save();
        }
        ,success:function (index, layero) {
            $(":focus").blur();
        }
	});
    layer.full(index);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function reLoad() {
    $('#exampleTable1').bootstrapTable('refresh');
}

function batchRemove() {
    var rows = $('#exampleTable1').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    $('#exampleTable1').bootstrapTable('refresh');
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {

    });
}

