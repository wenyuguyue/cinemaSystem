/*** 
 * 模态框封装 
 */  
$(function () {  
	var arr = document.cookie.split(';');           
    for (var i = 0; i < arr.length; i++) {
        var arr2 = arr[i].split('=');
        var arrTest = arr2[0].trim(); //此处的trim一定要加，个人对这不太理解，之前做项目时候才发现，cookie从第二个开始就会出现空格，你传入的cookie名如果在第一个，就能取出，如果在第二个或者以后，每次取就会有空格，就会匹配不成功              
        if (arrTest == name) {        //当然也可以用正则匹配取cookie，这样更好            
            $("#username").text(arr2[1])
        }
    }
	
	$("#add").click(function () {
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
		});
	$("#add2").click(function () {
		$("#myModalLabel2").text("新增");
		$('#myModal2').modal();
		$.ajax({
			url:"queryCinemaCid.do",
			method:"post",
			dataType:"json",
			success:function(d){
				$.each(d,function(k,v){
					$("#cid2").append("<option value='"+v.cid+"'>"+v.name+"</option>")
				})
			}
		})
		});
	$("#cinema_btn_submit").click(function(){
		$.ajax({
			url:"addCinema.do",
			data:{
				code:$("#code").val(),
				name:$("#name").val(),
				corporation:$("#corporation").val(),
				contact:$("#contact").val(),
				telephone:$("#telephone").val(),
				fax:$("#fax").val(),
				cinemas:$("#cinemas").val(),
				status:$("#status").val(),
				screen_count:$("#screen_count").val()
			},
			method:"post",
			success:function(){
				  $("#simpledatatable").bootstrapTable('refresh');
				  toastr.success("添加成功")
			},
			error:function(){
				toastr.error("error")
			}
		})
	})
	
	$("#cinema_btn_submit2").click(function(){
		$.ajax({
			url:"addMoviehall.do",
			data:{
				code:$("#code2").val(),
				cid:$("#cid2").val(),
				name:$("#name2").val(),
				allrow:$("#allrow2").val(),
				allcol:$("#allcol2").val(),
				hstyle:$("#hstyle2").val(),
				seat_count:$("#seat_count2").val()
			},
			method:"post",
			success:function(){
				  $("#simpledatatable2").bootstrapTable('refresh');
				  toastr.success("添加成功")
			},
			error:function(){
				toastr.error("error")
			}
		})
	})
/*使用bootstrap弹出框确认取消提示框**************************************************************************/	
  window.Modal = function () {  
    var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');  
    var alr = $("#com-alert");  
    var ahtml = alr.html();  

    var _tip = function (options, sec) {  
        alr.html(ahtml);    // 复原  
        alr.find('.ok').hide();  
        alr.find('.cancel').hide();  
        alr.find('.modal-content').width(500);  
        _dialog(options, sec);  
          
        return {  
            on: function (callback) {  
            }  
        };  
    };  
  
    var _alert = function (options) {  
      alr.html(ahtml);  // 复原  
      alr.find('.ok').removeClass('btn-success').addClass('btn-primary');  
      alr.find('.cancel').hide();  
      _dialog(options);  
  
      return {  
        on: function (callback) {  
          if (callback && callback instanceof Function) {  
            alr.find('.ok').click(function () { callback(true) });  
          }  
        }  
      };  
    };  
  
    var _confirm = function (options) {  
      alr.html(ahtml); // 复原  
      alr.find('.ok').removeClass('btn-primary').addClass('btn-success');  
      alr.find('.cancel').show();  
      _dialog(options);  
  
      return {  
        on: function (callback) {  
          if (callback && callback instanceof Function) {  
            alr.find('.ok').click(function () { callback(true) });  
            alr.find('.cancel').click(function () { return; });  
          }  
        }  
      };  
    };  
  
    var _dialog = function (options) {  
      var ops = {  
        msg: "你确定要删除该条信息吗？",  
        title: "操作提示",  
        btnok: "确定",  
        btncl: "取消"  
      };  
  
      $.extend(ops, options);  
  
      var html = alr.html().replace(reg, function (node, key) {  
        return {  
          Title: ops.title,  
          Message: ops.msg,  
          BtnOk: ops.btnok,  
          BtnCancel: ops.btncl  
        }[key];  
      });  
        
      alr.html(html);  
      alr.modal({  
        width: 250,  
        backdrop: 'static'  
      });  
    }  
  
    return {  
      tip: _tip,  
      alert: _alert,  
      confirm: _confirm  
    }   
  }();  
  /*使用bootstrap弹出框确认取消提示框**************************************************************************/	
  //toast设置
  toastr.options = {
      "closeButton": false, //是否显示关闭按钮
      "positionClass": "toast-top-right", //弹出窗的位置
      "showDuration": "300", //显示的动画时间
      "hideDuration": "300", //消失的动画时间
      "timeOut": "3000", //展现时间
      "showEasing": "swing", //显示时的动画缓冲方式
      "hideEasing": "linear", //消失时的动画缓冲方式
      "showMethod": "fadeIn", //显示时的动画方式
      "hideMethod": "fadeOut" //消失时的动画方式
    };

});


$('#simpledatatable').bootstrapTable({
	url : 'queryCinema.do',
	method : 'post',
	showButtonText : false, // 显示按钮上面的汉字
	toolbar : '#toolbar', // 这里是表格左上方的按钮组
	toolbarAlign : 'left', // 按钮组方位
	contentType : 'application/x-www-form-urlencoded; charset=UTF-8', // hbuilder连接tomcat用
	search : true, // 显示模糊搜索框
	searchAlign : 'right',
	showRefresh : true,
	pagination : true, // 是否分页
	striped : false, // 隔行换色
	sortable : true, // 允许表格进行排序
	singleSelect : true, // 单行选中，一次只能选择一行
	checkbox:true,
	pageSize : 10, // 默认一页显示多少行
	pageList : [ 5, 15, 25, 50 ], // 可供选择的一页多少行
	clickToSelect : true, // 点击选中
	// onClickCell:onClickCell,//添加点击方法
	//	onClickRow : function(row, $element) {
	//	 // $element是当前tr的jquery对象
	//	 $element.css("background-color", "green");
	//	 console.log(row)
	//	 },// 单击row事件
	onClickCell:onClickCell,//添加点击方法
	sortName : 'px',
	sortOrder : 'desc',
	// showToggle: true,
	detailView : true, // 详情展开
	cardView : false, // 以列表形式展示表格
	showColumns : true, // 可以自定义显示哪些列
	showPaginationSwitch : true, // 显示分页选择
	showExport : true, // 显示文件下载功能
	exportDataType : "all", // 允许的下载方式‘basic'当前页, 'all'全部数据, 'selected'下载选中的行.
	exportTypes : [ 'excel', 'txt' ], // 导出文件类型，加上之后只能下载excel表
	exportOptions : {
		fileName : (new Date().toLocaleDateString()) + '成绩导出',
		ignoreColumn : [ 'haha', 'xixi' ],
	},
	rowStyle : function(row, index) { // 给某一行加样式
		// 这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
		var strclass = "";
		// 本岗级的配额
		var quota = row.quota;
		// 本岗级第几个
		var index = row.index;
		if (row.status == 1) {
			// strclass = 'success'; //还有一个active
		} else if (row.status == 0) {
			strclass = 'info';
		} else {
			strclass = 'danger';
		}
		return {
			classes : strclass
		}
	},
	queryParamsType : '',
	queryParams : function(params) { // 查询字段，每次选择下拉菜单的时候，重新刷新表格就行
		return {
			// 科室/部门/轮次，写在这里
			dname : $('#dname').val(),
			pname : $('#pname').val(),
			px : $('#px').val(),
		}
	},
	onExpandRow : function(index, row, $detail) {
		// 展开行的时候触发方法
		expand(index, row, $detail);
	},
	responseHandler : function(res) {
		if (eval(res.list) != undefined) {
			return eval(res.list);
		} else {
			return res;
		}
	},
	columns : [ {
		field : 'name',
		title : '电影院名称',
		sortable : true,
		align : "center",
	}, { // 序号列
		field : 'corporation', // field必须有，可以乱填，否则报错
		title : '公司名称', // 表头
		sortable : true,
		align : "center"
	}, {
		field : 'contact',
		title : '联系人',
		sortable : true,
		align : "center"
	}, {
		field : 'telephone',
		title : '联系电话',
		sortable : true,
		align : "center"
	}, {
		field : 'fax',
		title : '传真号码',
		forceExport : true,
		sortable : true,
		align : "center"
	}, {
		field : 'cinemas',
		title : '所属院线',
		sortable : true,
		align : "center"
	}, {
		field : 'status',
		title : '当前营业状态',
		sortable : true,
		align : "center",
		editable: {
            type: 'select',
            title: '营业状态',
            source: [{value: 1, text: "正常营业"}, {value: 0, text: "测试"}, {value: 2, text: "禁止营业"}],
            validate: function (v) {
                if (!v) return '您尚未选择';
            }
        }
	}, {
		field : 'screen_count',
		title : '影厅数量',
		sortable : true,
		align : "center"
	}, {
		title : '操作',
		align : 'center',
		formatter : operateFormatter
	// 自定义修改和删除标志 也可以不写
	} ],
	// 这个是表格加载成功后执行的事件
	onLoadSuccess : function(aa,bb,cc) {
	},
	 onEditableSave: function (field, row, oldValue, $el) {
         $.ajax({
             type: "post",
             url: "editCinema.do",
             data: {'code': row.code,'field':field,'value':row[field],'oldvalue':$el},
             dataType:"json",
             success: function (data) {
                 if (data['msg'] == "success") {
                	 toastr.success("编辑成功!"); 
                 }else{
                	 toastr.warning("编辑失败!"); 
                 }
             },
             error: function () {
            	 toastr.error("Error");
             },
             complete: function () {
             }
         });
     }
})

$('#simpledatatable2').bootstrapTable({
	url : 'queryMoviehall.do',
	method : 'post',
	showButtonText : false, // 显示按钮上面的汉字
	toolbar : '#toolbar2', // 这里是表格左上方的按钮组
	toolbarAlign : 'left', // 按钮组方位
	contentType : 'application/x-www-form-urlencoded; charset=UTF-8', // hbuilder连接tomcat用
	search : true, // 显示模糊搜索框
	searchAlign : 'right',
	showRefresh : true,
	pagination : true, // 是否分页
	striped : false, // 隔行换色
	sortable : true, // 允许表格进行排序
	singleSelect : true, // 单行选中，一次只能选择一行
	checkbox:true,
	pageSize : 10, // 默认一页显示多少行
	pageList : [ 5, 15, 25, 50 ], // 可供选择的一页多少行
	clickToSelect : true, // 点击选中
	onClickCell:onClickCell,//添加点击方法
	sortName : 'px',
	sortOrder : 'desc',
	showToggle: true,
	detailView : true, // 详情展开
	cardView : false, // 以列表形式展示表格
	showColumns : true, // 可以自定义显示哪些列
	showPaginationSwitch : true, // 显示分页选择
	showExport : true, // 显示文件下载功能
	exportDataType : "all", // 允许的下载方式‘basic'当前页, 'all'全部数据, 'selected'下载选中的行.
	exportTypes : [ 'excel', 'txt' ], // 导出文件类型，加上之后只能下载excel表
	exportOptions : {
		fileName : (new Date().toLocaleDateString()) + '成绩导出',
		ignoreColumn : [ 'haha', 'xixi' ],
	},
	queryParamsType : '',
	queryParams : function(params) { // 查询字段，每次选择下拉菜单的时候，重新刷新表格就行
		return {
			// 科室/部门/轮次，写在这里
			dname : $('#dname').val(),
			pname : $('#pname').val(),
			px : $('#px').val(),
		}
	},
	onExpandRow : function(index, row, $detail) {
		// 展开行的时候触发方法
		expand(index, row, $detail);
	},
	responseHandler : function(res) {
		if (eval(res.list) != undefined) {
			return eval(res.list);
		} else {
			return res;
		}
	},
	columns : [ {
		field : 'cinema_name',
		title : '电影院名称',
		sortable : true,
		align : "center"
	}, { // 序号列
		field : 'code', // field必须有，可以乱填，否则报错
		title : '影厅编码', // 表头
		sortable : true,
		align : "center"
	}, {
		field : 'name',
		title : '影厅名称',
		sortable : true,
		align : "center"
	}, {
		field : 'seat_count',
		title : '座位数',
		sortable : true,
		align : "center"
	}, {
		field : 'allrow',
		title : '座位排数',
		forceExport : true,
		sortable : true,
		align : "center"
	}, {
		field : 'allcol',
		title : '座位列数',
		sortable : true,
		align : "center"
	}, {
		field : 'hstyle',
		title : '影厅类型',
		sortable : true,
		align : "center",	
	}, {
		title : '操作',
		align : 'center',
		formatter : operateFormatter2
	// 自定义修改和删除标志 也可以不写
	} ],
	// 这个是表格加载成功后执行的事件
	onLoadSuccess : function(aa,bb,cc) {
	},
	 onEditableSave: function (field, row, oldValue, $el) {
         $.ajax({
             type: "post",
             url: "editCinema.do",
             data: {'code': row.code,'field':field,'value':row[field],'oldvalue':$el},
             dataType:"json",
             success: function (data) {
                 if (data['msg'] == "success") {
                     toastr.success("编辑成功");
                 }else{
                	 toastr.warning("编辑失败");
                 }
             },
             error: function () {
            	 toastr.error("Error");
             },
             complete: function () {
             }
         });
     }
})

// 显示编辑列
function operateFormatter(value, row, index) {
	return [
//			'<a class="like" href="javascript:void(0)" title="Update" onclick="edit(this)">',
//			'<i class="glyphicon glyphicon-edit"></i>',
//			'</a> ',
			'<a class="remove" href="javascript:void(0)" title="Remove" onclick="remove(\''+row.code+'\')">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

function operateFormatter2(value, row, index) {
	return [
			'<a class="remove" href="javascript:void(0)" title="Remove" onclick="remove2(\''+row.hno+'\')">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

function onClickCell(field, value, row, $element){
}

function remove(code){
	console.log(code)
	var index=$("#simpledatatable").bootstrapTable("getData").length;
	Modal.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
           if (!e) {
               return;
           }
           $.ajax({
               type: "post",
               url: "deleteCinema.do",
               data: { "code": code },
              success: function (data, status) {
                   if (status == "success") {
                	   toastr.success("删除成功");
                       $("#simpledatatable").bootstrapTable('refresh');
                   }else{
                	   toastr.warning("删除失败");
                   }
               },
               error: function () {
                   toastr.error('Error');
                       },
                       complete: function () {
                       }
                 });
               });

}

function remove2(hno){
	console.log(hno)
	var index=$("#simpledatatable2").bootstrapTable("getData").length;
	Modal.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
           if (!e) {
               return;
           }
           $.ajax({
               type: "post",
               url: "deleteMoviehall.do",
               data: { "hno": hno },
              success: function (data, status) {
            	  if (status == "success") {
               	   toastr.success("删除成功");
                      $("#simpledatatable2").bootstrapTable('refresh');
                  }else{
               	   toastr.warning("删除失败");
                  }
               },
               error: function () {
                   toastr.error('Error');
                       },
                       complete: function () {
                       }
                 });
               });
}
