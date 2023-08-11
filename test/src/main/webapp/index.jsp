<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">

	<head>
		<script type="text/javaScript" language="javascript" defer="defer">
		    function fn_list() {
		    	console.log("list");
		       	document.listForm.action = "<c:url value='/list.do'/>";
		       	document.listForm.submit();
		    }
		    
		    function fn_update() {
		    	console.log("update");
		       	//document.updateFrom.action = "<c:url value='/update.do'/>";
		       	//document.updateFrom.submit();
		    }
		</script>
</head>
	
	<body>	
		<form>
			<div class="update">
	            <button id="update" onclick="fn_list()">수정</button>
	        </div>
		</form>	  
	</body>		
</html>