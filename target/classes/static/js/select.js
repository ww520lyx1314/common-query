$(function(){
    $("form").find("select").each(function (index,e) {
        var typeCode=$(e).attr("typecode");
        if(typeCode!=null){
            selectCommonLoad(e);
        }

    })
})
function selectCommonLoad(ob) {
    var html = "";
    var value=$(ob).attr("value");
    var typeCode=$(ob).attr("typecode");

    if(typeCode == 'YW_SMDJ' && value==''){
        value = 'C';
    }

    $.ajax({
        url : '/common/dict/list/'+typeCode+'',
        success : function(data) {
            //debugger;
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if( data[i].value==value){
                    html += '<option value="' + data[i].value + '"  selected="selected">' + data[i].name + '</option>'
                }else{
                    html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
                }

            }
            $(ob).append(html);
            $(ob).chosen({
                maxHeight : 200
            });
            //点击事件
            $(ob).on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });

        }
    });
}