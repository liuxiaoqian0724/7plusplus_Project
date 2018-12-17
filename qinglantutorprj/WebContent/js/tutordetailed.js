$(document).ready(function(event){
	$('.gradeli').click(function(){
		$('.gradeli').css('background-color','#f9f9f9');
		$(this).css('background-color','#81C7D4');
		// $(this).css('border','1px blue solid');
	})

	$('.patternli').click(function(){
		// alert(123);
		$('.patternli').css('background-color','#f9f9f9');
		$(this).css('background-color','#81C7D4');
		// $(this).css('border','1px blue solid');
	})	
	$('.btn').click(function(){
		$(this).css('background-color','#33A6B8');
		$('.btn').css('background-color','#56c9db');
	})	
	$('.comment-condition').click(function(){
		$('.comment-condition').css('color','black');
		$(this).css('color','#56c9db');
	})	
	
	var i=0;
	$('.text').click(function(){
		if(i%2==1){
			$('.text').html('查看更多'); 
		}else{
			$('.text').html('收起');
			$('#ii').attr('class','icon icon-angle-up');
		}
		i++;
		$('.hidecase').toggle();
	})

	$('.img-thumbnail').click(function(event){
		$('.img-thumbnail').css("border","1px white solid");
		$(this).css("border","2px #56c9db solid");
		$('.img-rounded').attr('src',$(this).attr("data-image"));
	})
});

	// $('.page1').click(function(event){
	// 	alert(123);
	// 	$(this).css('background-color','#0072E3');
	// })
	// $("li[name='page2']").click(function(event){
	// 	alert(1);
	// 	// $('page1').css('background-color','#2894FF');
	// 	$(this).attr("class","active");
	// })
