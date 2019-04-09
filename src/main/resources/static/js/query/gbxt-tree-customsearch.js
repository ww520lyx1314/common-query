var leftWidthx = 300;
$(function() {
	autoCalcW();
    getTreeData();
    getTreeDataMb();
});
function getTreeDataMb() {
    $.ajax({
        type : "GET",
        url : "/cardreperson/queryCustomCondition/treeDataMb",
        success : function(tree) {
            loadTreeMb(tree);
        }
    });
}
function loadTreeMb(tree) {
    $('#mb').jstree({
        'core' : {
            'data' : tree,
            "check_callback": true,"check_callback": true,
        },
        "plugins" : [ "search" ],

    });
    $('#mb').jstree().open_all();
}
$('#mb').on("changed.jstree", function(e, data) {
    if(data!=null){
        if(data.selected[0]!='-1'){
            $('#nowSelect').val("");
            $('#nowSelect').val(data.selected[0]);
            $('#mbName').val("");
            if(data.node!=null){
                $('#mbName').val(data.node.text);
            }
        }else{
            $('#nowSelect').val("");
            $('#mbName').val("");
        }
    }
    $('#table').bootstrapTable("refresh",{
        query: {tplId: data.selected[0]}
    })
    if(data!=null){
        if(data.selected[0]!='-1'&&data.selected[0]!=null&&data.selected[0]!=''){
            $("#searchSql").click();
        }
    }
})

function getTreeData() {
    $.ajax({
        type : "GET",
        url : "/cardreperson/queryCustomCondition/treeData",
        success : function(tree) {
            loadTree(tree);
        }
    });
}
function loadTree(tree) {
    $('#customConditionTree').jstree({
        'core' : {
            'data' : tree,
            "check_callback": true,"check_callback": true,
        },
        "plugins" : [ "search" ],

    });
    $('#customConditionTree').jstree().open_all();
}
$('#customConditionTree').on("changed.jstree", function(e, data) {
    var node = data.node;
    var tree = data.instance;
    if (data.selected == -1) {

    } else {
        if(!tree.is_parent(node)){
            debugger;
            var param={};//为了传入bootstrap table 的数据
            param.id=uuid();
            param.startFlag = 0; //左侧括号
            param.fieldName = node.original.t.key;
            param.fieldText = node.original.t.name;
            param.coidid = node.original.t.id;
            //标记此值是什么样子的input
            param.firstValueDataType=node.original.t.datatype;
            param.secondValueDataType=node.original.t.datatype;
            param.endFlag=0;//右侧括号
            param.relation = 0;//逻辑向后
            param.dataRefArray = node.original.t.dataRefArray;

            if(node.original.t.code){
                param.dmm = node.original.t.code;
            }
            if(node.original.t.dataRefArray!=null&&node.original.t.dataRefArray.length>0){
                param.dataref = node.original.t.dataRefArray[0].enname;
            }
            //如果是需要查询后台的  则需先ajax取到相应数据
            if(node.original.t.datatype=='select'){
                var data = window.localStorage.getItem('search_dict_'+node.original.t.code);
                if(data){
                    param.selectValueData = JSON.parse(data);
                    addRow(param);
                }else{
                    $.get('/common/dict/list/'+node.original.t.code+'',{}, function(data){
                        //将下拉选的数据放入此属性用于bootstrap拼接使用
                        window.localStorage.setItem('search_dict_'+node.original.t.code,JSON.stringify(data));
                        param.selectValueData = data;
                        addRow(param);
                    })
                }
            }else{
                addRow(param);
            }
        }
    }
});


function addRow(rowObj){
    var insertRow = rowObj;
    // $.each(insertRow, function(name, value){
    //     insertRow[name] = '';
    // });
    var datas = $('#table').bootstrapTable("getData");
    var insertIndex = datas.length;
    var params = {index:insertIndex, row:insertRow};
    $('#table').bootstrapTable('insertRow', params);
    // $('#table').bootstrapTable('getOptions').data.splice(insertIndex, 0, insertRow);
    //阻止所有的数据冒泡
    $(".myedit").bind("click",function(event){
        event.stopPropagation();
    });
}



function showIconForTree(treeId, treeNode) {
	return !treeNode.isParent;
};
function refreshTree(){
	$.getJSON(ctx+"/sys/office/treeData", function(data) {
        $.fn.zTree.init($("#customConditionTree"), setting, data).expandAll(true);
		
        var zTree = $.fn.zTree.getZTreeObj("officeTree");
        var node = zTree.getNodeByParam('id', data[0].id);//获取id为1的点  
        zTree.selectNode(node);//选择点  
        zTree.setting.callback.onClick(null, zTree.setting.treeId, node);//调用事件
    }); 
}
function autoCalcW(){
	/*main高度计算*/
	var mainHeight = $(window).height()-90;
	$("#main").css("height",$(window).height() - 10).css('width',$(document).width());
	$("#left").css("height",$(window).height());
	/*$("#right").css("width",$(window).width() - 200 - 20);*/
	$("#right").css("width",$(document).width() - leftWidthx -12 - 3);
	/*
	$("#refreshContent").height = $(document).width() - 300 - 20 - 20;
	$("#refreshContent").width = $(document).width() - 300 - 20 - 20;*/
	/*右侧滑窗高度*/
	$(".model-ron").css("max-height",mainHeight);
	$("#Modal .modal-body").css({"max-height":mainHeight,"height":mainHeight-150});
	
}

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}

