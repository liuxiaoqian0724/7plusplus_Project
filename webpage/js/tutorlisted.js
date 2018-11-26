// $(document).ready(function(enent){
// 	$('.con-li').click(function(){
// 		// alert(123);
// 		// alert(this.html());
// 		var $condition=$("<li class='title-condition'> &nbsp;<a href=''><i class='icon1 ion-close'></i></a></li>");
// 		$('.title-ul').append($condition);
// 	})
// })

$(document).ready(function(){

				$('#spe3').click(function(){
					// alert("123");
					$('.title-condition').remove();

				})
				// $('.con-li').click(function(event){
				// 	var $content=this.innerHTML;
				// 	// alert($content);
				// 	var $condition=$("<li class='title-condition'> &nbsp;<a href='' class='aa'></a><i class='icon1 ion-close'></i></li>");
				// 	$('.title-ul').append($condition);
				// 	$('.aa').html($content);
				// })
				var search = document.getElementById("partInput");
				  search.onfocus = function(){
				      search.value="";
				  }
})
