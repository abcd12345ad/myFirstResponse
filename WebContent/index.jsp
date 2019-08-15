<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传文件</title>
</head>
<body>
<form action="UpServlet" enctype="multipart/form-data" method="post">
		username:<input type="text" id="name" name="name" onblur=" mykeyup()"/><br>
		file:<input type="file" id="file" name="file"/>
		<input type="submit" value="上传"/>
	</form>
</body>
<script type="text/javascript">
	var httpreq;
   function createXMLHttpRequest(){
	   if(XMLHttpRequest){
		   httpreq=new XMLHttpRequest();
	   }else{
		   httpreq = new ActiveXObject("Microsoft.XMLHTTP");
	   }
   }
	function mykeyup(){
		var name=document.getElementById("name").value;
		createXMLHttpRequest();
		
		httpreq.open("post","checkname?name="+name,true);
		
		httpreq.onreadystatechange = checknameCallback;
		httpreq.send();
	}
	
	function checknameCallback(){
		if(httpreq.readyState==4){
			if(httpreq.status==200){
				var text=httpreq.responseText;
				alert(typeof(text));
				alert(text);
			}
		}
	}
</script>
</html>