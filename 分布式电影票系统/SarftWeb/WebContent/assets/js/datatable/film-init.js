/*******************************************************************************
 * 模态框封装
 */
$(function() {
	var arr = document.cookie.split(';');
	for (var i = 0; i < arr.length; i++) {
		var arr2 = arr[i].split('=');
		var arrTest = arr2[0].trim(); // 此处的trim一定要加，个人对这不太理解，之前做项目时候才发现，cookie从第二个开始就会出现空格，你传入的cookie名如果在第一个，就能取出，如果在第二个或者以后，每次取就会有空格，就会匹配不成功
		if (arrTest == name) { // 当然也可以用正则匹配取cookie，这样更好
			$("#username").text(arr2[1])
		}
	}

	$("#add").click(function() {
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
	});
	$("#add2").click(
			function() {
				$("#myModalLabel2").text("新增");
				$('#myModal2').modal();
				$.ajax({
					url : "queryCinemaCid.do",
					method : "post",
					dataType : "json",
					success : function(d) {
						$.each(d, function(k, v) {
							$("#cid2").append(
									"<option value='" + v.cid + "'>" + v.name
											+ "</option>")
						})
					}
				})
			});
	$("#cinema_btn_submit").click(function() {
		$.ajax({
			url : "addCinema.do",
			data : {
				code : $("#code").val(),
				name : $("#name").val(),
				corporation : $("#corporation").val(),
				contact : $("#contact").val(),
				telephone : $("#telephone").val(),
				fax : $("#fax").val(),
				cinemas : $("#cinemas").val(),
				status : $("#status").val(),
				screen_count : $("#screen_count").val()
			},
			method : "post",
			success : function() {
				$("#simpledatatable").bootstrapTable('refresh');
				toastr.success("添加成功")
			},
			error : function() {
				toastr.error("error")
			}
		})
	})

	$("#cinema_btn_submit2").click(function() {
		$.ajax({
			url : "addMoviehall.do",
			data : {
				code : $("#code2").val(),
				cid : $("#cid2").val(),
				name : $("#name2").val(),
				allrow : $("#allrow2").val(),
				allcol : $("#allcol2").val(),
				hstyle : $("#hstyle2").val(),
				seat_count : $("#seat_count2").val()
			},
			method : "post",
			success : function() {
				$("#simpledatatable2").bootstrapTable('refresh');
				toastr.success("添加成功")
			},
			error : function() {
				toastr.error("error")
			}
		})
	})
	/* 使用bootstrap弹出框确认取消提示框************************************************************************* */
	window.Modal = function() {
		var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
		var alr = $("#com-alert");
		var ahtml = alr.html();

		var _tip = function(options, sec) {
			alr.html(ahtml); // 复原
			alr.find('.ok').hide();
			alr.find('.cancel').hide();
			alr.find('.modal-content').width(500);
			_dialog(options, sec);

			return {
				on : function(callback) {
				}
			};
		};

		var _alert = function(options) {
			alr.html(ahtml); // 复原
			alr.find('.ok').removeClass('btn-success').addClass('btn-primary');
			alr.find('.cancel').hide();
			_dialog(options);

			return {
				on : function(callback) {
					if (callback && callback instanceof Function) {
						alr.find('.ok').click(function() {
							callback(true)
						});
					}
				}
			};
		};

		var _confirm = function(options) {
			alr.html(ahtml); // 复原
			alr.find('.ok').removeClass('btn-primary').addClass('btn-success');
			alr.find('.cancel').show();
			_dialog(options);

			return {
				on : function(callback) {
					if (callback && callback instanceof Function) {
						alr.find('.ok').click(function() {
							callback(true)
						});
						alr.find('.cancel').click(function() {
							return;
						});
					}
				}
			};
		};

		var _dialog = function(options) {
			var ops = {
				msg : "你确定要删除该条信息吗？",
				title : "操作提示",
				btnok : "确定",
				btncl : "取消"
			};

			$.extend(ops, options);

			var html = alr.html().replace(reg, function(node, key) {
				return {
					Title : ops.title,
					Message : ops.msg,
					BtnOk : ops.btnok,
					BtnCancel : ops.btncl
				}[key];
			});

			alr.html(html);
			alr.modal({
				width : 250,
				backdrop : 'static'
			});
		}

		return {
			tip : _tip,
			alert : _alert,
			confirm : _confirm
		}
	}();
	/* 使用bootstrap弹出框确认取消提示框************************************************************************* */
	// toast设置
	toastr.options = {
		"closeButton" : false, // 是否显示关闭按钮
		"positionClass" : "toast-top-right", // 弹出窗的位置
		"showDuration" : "300", // 显示的动画时间
		"hideDuration" : "300", // 消失的动画时间
		"timeOut" : "3000", // 展现时间
		"showEasing" : "swing", // 显示时的动画缓冲方式
		"hideEasing" : "linear", // 消失时的动画缓冲方式
		"showMethod" : "fadeIn", // 显示时的动画方式
		"hideMethod" : "fadeOut" // 消失时的动画方式
	};

});

$('#simpledatatable').bootstrapTable({
	url : 'queryFilm.do',
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
	checkbox : true,
	pageSize : 10, // 默认一页显示多少行
	pageList : [ 5, 15, 25, 50 ], // 可供选择的一页多少行
	clickToSelect : true, // 点击选中
	onClickCell:onClickCell,// 添加点击方法
	// onClickRow : function(row, $element) {
	// // $element是当前tr的jquery对象
	// $element.css("background-color", "green");
	// console.log(row)
	// },// 单击row事件
	onClickCell : onClickCell,// 添加点击方法
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
	queryParamsType : '',
	queryParams : function(params) { // 查询字段，每次选择下拉菜单的时候，重新刷新表格就行
		return {
			// 科室/部门/轮次，写在这里
			selectfp : $('#selectfp').val()
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
	columns : [
	{
		field : 'business_date',
		title : '营业日期',
		sortable : true,
		align : "center"
	}, { // 序号列
		field : 'screen_code', // field必须有，可以乱填，否则报错
		title : '影厅编码', // 表头
		sortable : true,
		align : "center"
	}, {
		field : 'film_code',
		title : '影片编码',
		sortable : true,
		align : "center"
	}, {
		field : 'film_name',
		title : '影片名称',
		sortable : true,
		align : "center"
	}, {
		field : 'session_code',
		title : '场次编码',
		sortable : true,
		align : "center"
	}, {
		field : 'session_datetime',
		title : '放映时间',
		sortable : true,
		align : "center",	
		formatter: function (value, row, index) {
             return changeDateFormat(value)
         },
// formatter : function(value, row, index) {
// var datetimeType = "";
// var date = new Date();
// date.setTime(value);
// datetimeType += date.getFullYear(); // 年
// datetimeType += "-" + getMonth(date); // 月
// datetimeType += "-" + getDay(date); // 日
// datetimeType += " " + getHours(date); // 时
// datetimeType += ":" + getMinutes(date); // 分
// datetimeType += ":" + getSeconds(date); // 分
// return datetimeType;
// // 返回 01-12 的月份值
// function getMonth(date) {
// var month = "";
// month = date.getMonth() + 1; // getMonth()得到的月份是0-11
// if (month < 10) {
// month = "0" + month;
// }
// return month;
// }
// // 返回01-30的日期
// function getDay(date) {
// var day = "";
// day = date.getDate();
// if (day < 10) {
// day = "0" + day;
// }
// return day;
// }
// // 返回小时
// function getHours(date) {
// var hours = "";
// hours = date.getHours();
// if (hours < 10) {
// hours = "0" + hours;
// }
// return hours;
// }
// // 返回分
// function getMinutes(date) {
// var minute = "";
// minute = date.getMinutes();
// if (minute < 10) {
// minute = "0" + minute;
// }
// return minute;
// }
// // 返回秒
// function getSeconds(date) {
// var second = "";
// second = date.getSeconds();
// if (second < 10) {
// second = "0" + second;
// }
// return second;
// }
// },
		editable: {
		    type: 'text',
		    clear: false,
		    placement: 'left',
		    title: '请选择日期:',
		    datepicker: {
		        language: 'zh-CN',
		    }
		}
	}, {
		field : 'seat_by_number',
		title : '对号入座标识',
		sortable : true,
		align : "center"
	}, {
		field : 'price',
		title : '标准定价',
		sortable : true,
		align : "center",
	// editable: {
	// type: 'select',
	// title: '营业状态',
	// source: [{value: 1, text: "正常营业"}, {value: 0, text: "测试"}, {value: 2,
	// text: "禁止营业"}],
	// validate: function (v) {
	// if (!v) return '您尚未选择';
	// }
	// }
	}, {
		field : 'lowest_price',
		title : '最低票价',
		sortable : true,
		align : "center"
	}, {
		field : 'valid',
		title : '放映状态',
		sortable : true,
		align : "center",
		formatter: function (value, row, index) {
            var date=new Date()
            console.log(date.getTime()+"******"+row.session_datetime+"**********"+row.valid)
            if(row.valid==0){
            	return "禁止放映";
            }else if(isNaN(row.session_datetime)){
            	var date1=new Date(row.session_datetime)
            	 console.log(date1.getTime()+"******"+row.session_datetime+"**********"+row.valid)          
				if(date1.getTime()>=date.getTime()){
					return "未放映";
				}else{
					return "已放映";
				}
            }else if(row.session_datetime>date.getTime()){
            	return "未放映";
            }else{
            	return "已放映";
            }      
        }
	}, {
		title : '操作',
		align : 'center',
		formatter : operateFormatter
	// 自定义修改和删除标志 也可以不写
	} ],
	// 这个是表格加载成功后执行的事件
	onLoadSuccess : function(aa, bb, cc) {
	},
	onEditableSave : function(field, row, oldValue, $el) {
		$.ajax({
			type : "post",
			url : "editFilmPlan.do",
			data : {
				'fpid' : row.fpid,
				'field' : field,
				'value' : row[field],
				'oldvalue' : $el
			},
			dataType : "json",
			success : function(data) {
				if (data['msg'] == "success") {
					toastr.success("编辑成功!");
				} else {
					toastr.warning("编辑失败!");
				}
			},
			error : function() {
				toastr.error("Error");
			},
			complete : function() {
			}
		});
	}
})
// 点击变色的方法
  $(document).on('click','tr',function(){
    $(this).addClass('selected').siblings().removeClass('selected');
  })
// 点击某行的时候获取整行的数据
  var rowData = 0;
  function onClickCell (field, value, row, $element){
    rowData = row;
    console.log(rowData);
  }

// 显示编辑列
function operateFormatter(value, row, index) {
	return [
			// '<a class="like" href="javascript:void(0)" title="Update"
			// onclick="edit(this)">',
			// '<i class="glyphicon glyphicon-edit"></i>',
			// '</a> ',
			'<a class="remove" href="javascript:void(0)" title="Remove" onclick="remove(\''
					+ row.fpid + '\')">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

function remove(fpid) {
	console.log(code)
	var index = $("#simpledatatable").bootstrapTable("getData").length;
	Modal.confirm({
		message : "确认要删除选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "post",
			url : "deleteFilmPlan.do",
			data : {
				"fpid" : fpid
			},
			success : function(data, status) {
				if (status == "success") {
					toastr.success("删除成功");
					$("#simpledatatable").bootstrapTable('refresh');
				} else {
					toastr.warning("删除失败");
				}
			},
			error : function() {
				toastr.error('Error');
			},
			complete : function() {
			}
		});
	});
}


function expand(index, row, $detail) {
	var cur_table = $detail.html('<table></table>').find('table');
	$(cur_table).append(
			"<tr><td rowspan='4'><img src='" + row.film_cover
					+ "'/></td></tr><tr><td>" + row.film_name
					+ "</td></tr><tr><td>" + row.film_name
					+ "</td></tr><tr><td>" + row.film_name + "</td></tr>")
}


// 修改——转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval) {
    if (cellval != null) {
        var d = new Date(cellval);
        var times=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
        return times;
    } else {
        return cellval;
    }
}

function reload(){
	$("#simpledatatable").bootstrapTable('refresh');
}