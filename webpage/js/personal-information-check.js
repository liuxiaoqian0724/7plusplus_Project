//弹出框水平垂直居中
			(window.onresize = function() {
				var win_height = $(window).height();
				var win_width = $(window).width();
				if(win_width <= 768) {
					$(".tailoring-content").css({
						"top": (win_height - $(".tailoring-content").outerHeight()) / 2,
						"left": 0
					});
				} else {
					$(".tailoring-content").css({
						"top": (win_height - $(".tailoring-content").outerHeight()) / 2,
						"left": (win_width - $(".tailoring-content").outerWidth()) / 2
					});
				}
			})();

			//弹出图片裁剪框
			$("#replaceImg").on("click", function() {
				$(".tailoring-container").toggle();
			});
			//图像上传
			function selectImg(file) {
				if(!file.files || !file.files[0]) {
					return;
				}
				var reader = new FileReader();
				reader.onload = function(evt) {
					var replaceSrc = evt.target.result;
					//更换cropper的图片
					$('#tailoringImg').cropper('replace', replaceSrc, false); //默认false，适应高度，不失真
				}
				reader.readAsDataURL(file.files[0]);
			}
			//cropper图片裁剪
			$('#tailoringImg').cropper({
				aspectRatio: 1 / 1, //默认比例
				preview: '.previewImg', //预览视图
				guides: false, //裁剪框的虚线(九宫格)
				autoCropArea: 0.5, //0-1之间的数值，定义自动剪裁区域的大小，默认0.8
				movable: false, //是否允许移动图片
				dragCrop: true, //是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
				movable: true, //是否允许移动剪裁框
				resizable: true, //是否允许改变裁剪框的大小
				zoomable: false, //是否允许缩放图片大小
				mouseWheelZoom: false, //是否允许通过鼠标滚轮来缩放图片
				touchDragZoom: true, //是否允许通过触摸移动来缩放图片
				rotatable: true, //是否允许旋转图片
				crop: function(e) {
					// 输出结果数据裁剪图像。
				}
			});
			//旋转
			$(".cropper-rotate-btn").on("click", function() {
				$('#tailoringImg').cropper("rotate", 45);
			});
			//复位
			$(".cropper-reset-btn").on("click", function() {
				$('#tailoringImg').cropper("reset");
			});
			//换向
			var flagX = true;
			$(".cropper-scaleX-btn").on("click", function() {
				if(flagX) {
					$('#tailoringImg').cropper("scaleX", -1);
					flagX = false;
				} else {
					$('#tailoringImg').cropper("scaleX", 1);
					flagX = true;
				}
				flagX != flagX;
			});

			//裁剪后的处理
			$("#sureCut").on("click", function() {
				if($("#tailoringImg").attr("src") == null) {
					return false;
				} else {
					var cas = $('#tailoringImg').cropper('getCroppedCanvas'); //获取被裁剪后的canvas
					var base64url = cas.toDataURL('image/png'); //转换为base64地址形式
					$("#finalImg").prop("src", base64url); //显示为图片的形式

					//关闭裁剪框
					closeTailor();
				}
			});
			//关闭裁剪框
			function closeTailor() {
				$(".tailoring-container").toggle();
			}
			//表单验证
			var isName = false;
			var isPersonId = false;
			var isStudentId = false;
			var isSchoolName = false;
			var isAddress = false;
			var isPhoneNum = false;
			var phoneNumReg =/^[1][3,4,5,6,7,8,9][0-9]{9}$/;
			var personIdReg =/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/;
			function checkName() {
				var name = $('#personName').val();
				var personNameError = $('#personNameError');
				if(name == "") {
					isName= false;
					personNameError.html('姓名不能为空！');
				} else {
					isName = true;
					personNameError.html('');
				}
			}
			function checkPersonId() {
				var personId = $('#personId').val();
				var personIdError = $('#personIdError');
				console.log(personId)
				if(personId == "") {
					isPersonId= false;
					personIdError.html('身份证号码不能为空！');
				}else if(personIdReg.test(personId) == false) {
					personIdError.html('身份证号码格式不正确！');
				}else{
					isPersonId = true;
					personIdError.html('');
				}
			}
			function checkPhoneNum() {
				var phoneNum = $('#phoneNum').val();
				var phoneNumError = $('#phoneNumError');
				if(phoneNum == "") {
					isPhoneNum= false;
					phoneNumError.html('手机号码不能为空！');
				}else if(phoneNumReg.test(phoneNum) == false) {
					phoneNumError.html('手机号码格式不正确！');
				}else{
					isPhoneNum = true;
					phoneNumError.html('');
				}
			}
			function checkStudentId() {
				var finaImg = $('#finalImg').href;
				var studentIdError = $('#studentIdError');
				if(finalImg == "") {
					isStudentId= false;
					studentIdError.html('请上传您的学生证照片！');
				} else {
					isStudentId = true;
					studentIdError.html('');
				}
			}
			function checkSchoolName() {
				var schoolName = $('#schoolName').val();
				var schoolError = $('#schoolError');
				if(schoolName == "") {
					isStudentName = false;
					schoolError.html('请选择您的学校！');
				} else {
					isStudentName = true;
					schoolError.html('');
				}
			}
			function checkAddress() {
				var address = $('#address').val();
				var addressError = $('#addressError');
				if(address == "") {
					isAddress = false;
					addressError.html('请您认真填写地址');
				} else {
					isAddress = true;
					addressError.html('');
				}
			}
			function isEmpty(){
				document.getElementById("intro").placeholder="";
				
			}
			function checkAll(){
				var errorMsg = $('#error');
				if(isAddress&&isName&&isPersonId&&isPhoneNum&&isSchoolName&&isStudentId){
					return true;
				}else{
					errorMsg.html('请仔细检查您需要填写的信息是否完整！')
					return false;
				}
			}