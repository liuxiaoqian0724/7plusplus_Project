function show(d1){
		if(document.getElementById(d1).style.display=='none'){
	 		document.getElementById(d1).style.display='block';  //触动的层如果处于隐藏状态，即显示
			document.getElementById('p2').style.display='block';
			document.getElementById('p1').style.display='none';
	 	}else{
			document.getElementById(d1).style.display='none';  //触动的层如果处于显示状态，即隐藏
	 		document.getElementById('p2').style.display='none';
			document.getElementById('p1').style.display='block';
	   	}
	}
function jump(){
	setTimeout("javascript:location.href='index.html'", 100); 
}
