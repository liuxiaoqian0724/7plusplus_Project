	var times ='0,'
	$(".time_table td").click(function() {
			var $this = $(this);
			if ($this.find("img").attr("src") == "images/icon/ok.png") {
				$this.find("img").attr("src", "images/icon/error.png");
			} else {
				$this.find("img").attr("src", "images/icon/ok.png");
			}
			var ids = '';
			$("td img[src='images/icon/ok.png']").each(function() {
				ids += $(this).closest("td").data('id') + ",";
			});
			times = ids;
		});
		
		//地点选择
		init_city_select($("#citySelect"));
		
		//学科添加
		function addSub(obj) {
			var btn = $(obj);
			btn.attr("disabled", true);
			var sub = btn.html().substr(0, 2);
			var allSub = $('#subject').val();
			allSub = allSub + sub + ';';
			$('#subject').val(allSub);
		}
		

		//年级添加
		function addGra(obj){
			var str = $(obj);
			str.attr("disabled", true);
			var gra= str.html().substr(0, 3);
			var allGra = $('#grade').val();
			allGra = allGra + gra + ';';
			$('#grade').val(allGra);
		}
		function check(){
			var subject = $("#subject").val();
			var place = $("#citySelect").val();
			var min = $("#min").val();
			var grade = $("#grade").val();
			var error = $("#error-msg");
			var experience = $("#experience").val();
			var options=$("#teachAge option:selected").val()
			var success = $("#success").val();
			var rules = $("#rules");
			var principle = $("#principles");
			if(((subject!="")&&(place!="")&&(min!="")&&(grade!="")&&(experience!="")&&(success!="")&&(teachAge!=""))==false){
				error.html("请仔细检查您的信息是否填写完整！！")
				return false;
			}else if(!rules.prop('checked')){
				error.html("发布信息前您必须同意此网站发布准则！！");
				return false;
			}else if(!principle.prop('checked')){
				error.html("发布信息前您必须同意此网站相关规定！！");
				return false;
			}else{
				error.html("");
				return true;
			}
		}
		function submitMessage() {
			if (check()) {
				var info = {
					"course":$("#subject").val(),
					"price":$("#min").val(),
					"address":$("#citySelect").val(),
					"teacherAge":$("#teachAge option:selected").val(),
					"grade":$("#grade").val(),
					"experience":$("#experience").val(),
					"successCase":$("#success").val(),
					"times":times.substr(0,times.length-1)
				}
				$.ajax({
					type : "post",
					url : "sendMessage/send",
					data : JSON.stringify(info),
					datatype : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data == "ok") {
							window.location.href = "sendstaused.jsp"
						}else {
							window.location.href = "index.jsp"
						}
					}
				});
			}
		}