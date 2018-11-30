$(document).ready(function(event){
	var i=0;
	$('.gradeli').click(function(){
		// alert(123);
		$('.gradeli').css('background-color','white');
		$(this).css('background-color','#2894FF');
		// $(this).css('border','1px blue solid');
	})

	$('.patternli').click(function(){
		// alert(123);
		$('.patternli').css('background-color','white');
		$(this).css('background-color','#2894FF');
		// $(this).css('border','1px blue solid');
	})	
	$('.text').click(function(){
		if(i%2==1){
			alert(123);
			$('.text').val('收起');
		}
		i++;
		alert(i);
		$('.hidecase').toggle();
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
