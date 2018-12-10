
$(document).ready(function(){
	var a = new Array();
	$('#spe3').click(function(){
			// alert("123");
		$('.title-condition').remove();

	})
	var mycars=new Array()
	//添加子元素并保存
	$('.con-li').click(function(enent){
		var content=$(this).html();
		for(var i=0;i<mycars.length;i++){
 			if(content==mycars[i]){	//已经选过这个选项了
 				// alert("Y");
 				break;
 			}else{
 				// alert("N");
 				continue;
 			}
		}
		if(i>=mycars.length){
			var $element=$("<li class='title-condition'>"+content+"&nbsp;"+"<i class='icon1 ion-close'></i></li>");
		}
		$(".title-ul").prepend($element);
		mycars.push(content);
		// a.push(content);
		// // $.session.set('conditions', a);
		// sessionStorage.setItem('conditions', a);
		// alert(sessionStorage.getItem("conditions")[1]);
	})
	$(".icon1").click(function(event){
		// alert(123);
		// alert($(this).parent().attr('class'));
		$(this).parent().remove();
	})
	var i=0;
	$('#more').click(function(){
		if(i%2==1){
			$('#more').html('更多'+'<i class="icon11 icon-angle-down"></i>'); 
		}else{
			$('#more').html('收起'+'<i class="icon11 icon-angle-up"></i>')
		}
		i++;
		$('.hide-con-content').toggle();
	})
	var j=0;
	$('#more1').click(function(){
		if(i%2==1){
			$('#more1').html('更多'+'<i class="icon11 icon-angle-down"></i>'); 
		}else{
			$('#more1').html('收起'+'<i class="icon11 icon-angle-up"></i>');
		}
		i++;
		$('.hide-con-content1').toggle();
	})
})
