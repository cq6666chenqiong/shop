/**
 * Created by taoxiangshan on 2017/10/17.
 */
(function ($) {
    var indenter = 15;
    $.fn.loadTreeTable = function loadData(options) {
        var checkedNode  = new Map();
        var opts = $.extend({}, options);
        var selector = this.selector;
        var tbody = $(selector + " tbody");
        var parmaInput = $("#"+options.parmaName);
        tbody.html("");
        var url = opts.url.indexOf("?")!=-1?(opts.url+"&") :(opts.url+"?");

        $.ajax({
            url: contextPath + url + "dt=" + new Date().getTime(),
            type: 'Post',
            success: function (result) {
                var level = 0;
                //表格信息
                $.each(result, function (index, value) {
                    addRow(selector, tbody, value, opts,level);
                    if (value.children && value.children.length > 0) {//如果有子节点
                        addChildRow(selector, tbody, value.children, opts,level+1);
                    }
                });
                $(selector).treetable({
                    expandable: options.expandable
                });
                if(options.expandable){
                    $(selector).treetable('expandAll');
                }
                $(selector+" tbody tr").click(function () {  //点击事件，复选框
                    if(options.checkBox){
                        var checked = $("#checkbox"+ $(this).attr("data-tt-id")).attr("checked");
                        rowClick(selector,$(this),!checked);
                    }else{
                        $(selector+" tbody tr").each(function () {
                            $(this).removeClass("selected");
                        });
                        $(this).addClass("selected");
                        if(parmaInput) {
                            parmaInput.val($(this).attr("data-tt-id"));
                        }
                    }
                });

            }
        });

        /***
         * 点击行
         * @param row
         */
        function rowClick(selector,row,checked) {
            var trCheckBox = $("#checkbox"+ row.attr("data-tt-id"));
            if(trCheckBox){
                trCheckBox.attr("checked",checked);
                if(parmaInput){
                    setInputValue(row,checked);
                }
                $(selector+" tbody tr").each(function () {
                    if($(this).attr("data-tt-parent-id")==row.attr("data-tt-id")){
                        rowClick(selector,$(this),checked);
                    }
                });
            }
        }

        /**
         * 设置值
         */
        function setInputValue(row,checked) {
            if(parmaInput && row.attr("data-tt-parent-id")!=''){
                if(checked){
                    if(!checkedNode.containsKey(row.attr("data-tt-id"))){
                        checkedNode.put(row.attr("data-tt-id"),row);
                    }
                    parmaInput.val(checkedNode.keys().join(","));
                }else{
                    if(checkedNode.containsKey(row.attr("data-tt-id"))){
                        checkedNode.remove(row.attr("data-tt-id"));
                    }
                    parmaInput.val(checkedNode.keys().join(","));
                }
            }
        }

        /**
         * 获取行
         * @param selector
         * @param value
         * @returns {*|HTMLElement}
         */
        function addRow(selector, tbody, value, opts,level) {
            var row = $("<tr data-tt-id ='" + value.id + "' data-tt-parent-id='" + (value.id == value.parentId ? "" : value.parentId) + "' data-text='" + value.text +"'></tr>");
            if(value['checked']){
                checkedNode.put(row.attr('data-tt-id'),row);
            }
            var tbHead = $(selector).children('thead'); //获取table对象下的thead
            var tbHeadTh = tbHead.find('tr th'); //获取thead下的tr下的th
            var start = true;
            tbHeadTh.each(function () {//遍历thead的tr下的th
                var valueName = $(this).attr("column");

                if (valueName) {
                    if (value[valueName]) {
                        if (opts.checkBox && start) {
                            row.append($("<td>" + getCheckBox(value, level) + "</td>"));
                        }else if(start){
                            row.append($("<td><label style='margin: 0 0 0 "+ (level*indenter)+"px;'><i class='" +value.icon +"  font-blue-steel '></i>" + value[valueName] + "</label></td>"));
                        } else {
                            row.append($("<td><label >" + value[valueName] + "</label></td>"));
                        }
                        start = false;
                    } else {
                        row.append($("<td></td>"));
                    }
                }
            });
            tbody.append(row);
        }

        /**
         * 添加子节点
         * @param selector
         * @param children
         */
        function addChildRow(selector, tbody, childrens, opts,level) {
            for (var i = 0; i < childrens.length; i++) {
                var childRow = childrens[i];
                addRow(selector, tbody, childRow, opts,level);
                if (childRow.children && childRow.children.length > 0) {//如果有子节点
                    addChildRow(selector, tbody, childRow.children, opts,level+1);
                }
            }
        }

        /**
         * 获取checkbox
         * @param row
         * @returns {string}
         */
        function getCheckBox(row,level) {
            var checked = row.checked?"checked='checked'":"";
            var checkBoxValue ="<label style='margin: 0 0 0 "+ (level*indenter)+"px;'>"
                +"<input  type='checkbox' class='icheck' id='checkbox"+ row.id +"' value='"+ row.id +"' "+ checked +" parentId='"+ row.parentId +"' "+" >"
                + "<span><i class='" +row.icon +"  font-blue-steel'></i>"+row.text+"</span>"
                +"</label>";

            return checkBoxValue;
        }
    }



    /**
     * 获取复选框的值
     * @returns {string}
     */
    $.fn.getCheckedNodes = function getCheckedNodes() {
        var checkedIds = "";
        $(this.selector).find('input[type="checkbox"]:checked').each(function () {
            if($(this).attr("parentId")!=$(this).attr("value")){
                checkedIds = checkedIds + $(this).attr("value")+","
            }
        });
        if(checkedIds && checkedIds.length>1){
            checkedIds = checkedIds.substr(0,checkedIds.length-1);
        }
        return checkedIds;
    }

    /**
     * 获取单选
     * @returns {Object}
     */
    $.fn.getSingleSelectedNode = function getSingleSelectedNode() {
        var checkNode = new Object();
        if($(this.selector +" .selected").length >0){
            $(this.selector +" .selected").each(function () {
                checkNode.id =  $(this).attr("data-tt-id");
                checkNode.text =   $(this).attr("data-text");
                checkNode.parentId =  $(this).attr("data-tt-parent-id");
                return checkNode;
            })
        }
        return checkNode;
    }
})(jQuery);