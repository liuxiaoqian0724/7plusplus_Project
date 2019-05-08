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


//选择学校的
$(function() {
	$("#schoolName").proschool();
})

//上传头像的功能
$(function() {    
	if($("#personName").val().length != 0 ){
		$("#personName").attr("disabled","false");
	}
	if($("#personId").val().length != 0 ){
		$("#personId").attr("disabled","false");
	}
	if($("#img1 > img")[0].src != 'http://localhost:8080/qinglantutorprj/' ){
		$(("#img1")+"> button").css("display","block");
		$(("#img1")+"> input").css("display","none");
	}
	if($("#img2 > img")[0].src != 'http://localhost:8080/qinglantutorprj/' ){
		$(("#img2")+"> button").css("display","block");
		$(("#img2")+"> input").css("display","none");
	}
	if($("#img3 > img")[0].src != 'http://localhost:8080/qinglantutorprj/' ){
		$(("#img3")+"> button").css("display","block");
		$(("#img3")+"> input").css("display","none");
	}
	if($("#img4 > img")[0].src != 'http://localhost:8080/qinglantutorprj/' ){
		$(("#img4")+"> button").css("display","block");
		$(("#img4")+"> input").css("display","none");
	}
	
//	$("#major > select").get(0).value = 1;
//	alert($("#major > select").find("option:selected").text());
	
	$('#choosePhoto').change(function() {   
		var reader = new FileReader(); 
		reader.readAsDataURL($("#choosePhoto")[0].files[0]);
		reader.onload = function(evt){
			var imgSrc = evt.target.result;
			$('#photo').attr('src', imgSrc);
		};
		
	})  
})
//上传头像传参

//上传四个图片传参
function photosupload(param){
	$(("#"+param)+"> button").css("display","block");
	$(("#"+param)+"> input").css("display","none");
	
	/* file：file控件
     * prvid: 图片预览容器
     */
    var tip = "Expect jpg or png or gif!"; // 设定提示信息
    var filters = {
        "jpeg"  : "/9j/4",
        "gif"   : "R0lGOD",
        "png"   : "iVBORw"
    };
    var file = $("."+param)[0];
    if (window.FileReader) { // html5方案
        for (var i=0, f; f = file.files[i]; i++) {
            var fr = new FileReader();
            fr.onload = function(e) {
                var src = e.target.result;
                if (!validateImg(src)) {
                    alert(tip)
                } else {
                	$("#"+param+">img").attr("src",src);
                }
            }
            fr.readAsDataURL(f);
        }
    } else { // 降级处理
        if ( !/\.jpg$|\.png$|\.gif$/i.test(file.value) ) {
            alert(tip);
        } else {
            showPrvImg(file.value);
        }
    }
    function validateImg(data) {
        var pos = data.indexOf(",") + 1;
        for (var e in filters) {
            if (data.indexOf(filters[e]) === pos) {
                return e;
            }
        }
        return null;
    }
    
    
//	var reader = new FileReader(); 
//	reader.readAsDataURL($("."+param)[0].files[0]);
//	reader.onload = function(evt){
//		var imgSrc = evt.target.result;
//		$("#"+param+">img").attr("src",imgSrc);
//	};
}



//不上传我的照片那个按钮
function photoremove(param){
	var a = "#"+param+"> button";
	var b = "#"+param+"> input";
	$("#"+param+">img").removeAttr("src");
	$(a).css("display","none");
	$(b).css("display","block");
}


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
		studentIdError.html('请上传您的身份证照片！');
	} else {
		isStudentId = true;
		studentIdError.html('');
	}
}
//var i=0;
function checkSchoolName() {
	var schoolName = $('#schoolName').val();
	var schoolError = $('#schoolError');
	if(schoolName == ""/*&& i!=0*/) {
		isSchoolName = false;
		schoolError.html('请选择您的学校！');
	} else {
		isSchoolName = true;
		schoolError.html('');
	}
	//i++;
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
function checkAll(param){
	var errorMsg = $('#error');
	var name = $('#personName').val();
	var personId = $('#personId').val();
	var phoneNum = $('#phoneNum').val();
	var userimg = $("#c2-left-right > img").attr("src");
	var stuimg = $("#finalImg").attr("src");
	var img1 = $("#img1 > img").attr("src");
	var img2 = $("#img2 > img").attr("src");
	var img3 = $("#img3 > img").attr("src");
	var img4 = $("#img4 > img").attr("src");
//	$("#major > select").get(0).value = 1;
//	alert($("#major > select").find("option:selected").text());
	checkPhoneNum();
	checkName();
	checkPersonId();
	if(param == '老师'){
		var schoolName = $('#schoolName').val();
		var address = $('#address').val();
		var grade = $("#grade > select").find("option:selected").text();
		var major = $("#major > select").find("option:selected").text();
		var introduce = $("#intro").val();
		var json = {
			"realName":name,	"idNumber":personId,	"phoneNumber":phoneNum,	"userImg":userimg,
			"stuImg":stuimg,	"img1":img1,	"img2":img2,	"img3":img3,	"img4":img4,
			"school":schoolName,	"address":address,		"grade":grade,		"major":major,
			"introduce":introduce
		};
		checkStudentId();
		checkSchoolName();
		checkAddress();
		if(isAddress&&isName&&isPersonId&&isPhoneNum&&isSchoolName&&isStudentId){
			$.ajax({
				type:"post",
				dataType:"json",
				contentType:"application/json",
				data:JSON.stringify(json),
				url:"inforchange",
				success:function(data){
					alert(data);
					return true;
				},
				error:function(){
					alert("error");
				}
			});
			return true;
		}else{
			errorMsg.html('请仔细检查您需要填写的信息是否完整！')
			return false;
		}
	}else{
		var json = {
				"realName":name,	"idNumber":personId,	"phoneNumber":phoneNum,	"userImg":userimg,
				"stuImg":stuimg,	"img1":img1,	"img2":img2,	"img3":img3,	"img4":img4
			};
			checkStudentId();
			if(isAddress&&isName&&isPersonId&&isPhoneNum&&isSchoolName&&isStudentId){
				$.ajax({
					type:"post",
					dataType:"json",
					contentType:"application/json",
					data:JSON.stringify(json),
					url:"inforchange",
					success:function(data){
						alert("您好！您的信息修改成功！");
						return true;
					},
					error:function(){
						alert("error");
					}
				});
				return true;
			}else{
				errorMsg.html('请仔细检查您需要填写的信息是否完整！')
				return false;
			}
	}
}