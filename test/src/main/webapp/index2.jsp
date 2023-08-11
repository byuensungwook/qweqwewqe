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
		       	//document.listForm.action = "<c:url value='/list.do'/>";
		       	//document.listForm.submit();
		    }
		    
		    function fn_update() {
		    	console.log("update");
		       	//document.updateFrom.action = "<c:url value='/update.do'/>";
		       	//document.updateFrom.submit();
		    }
		</script>
</head>
	
	<body>	
		<form:form modelAttribute="MemberDto" id="updateForm" name="updateForm" method="post">
			<input type="hidden" name="_method" value="updateForm">
		    <div class="wrapper">
		        <div class="name">
		            <input id="name"  type="text" placeholder="이름을 입력해 주세요.">
		            <div id="nameError" class="error"></div>
		        </div>
		        <div class="password">
		            <input id="password" type="password" placeholder="비밀번호를 입력해 주세요.">
		            <div id="passwordError" class="error"></div>
		        </div>
		        <div class="passwordCheck">
		            <input id="passwordCheck" type="password" placeholder="비밀번호를 다시 입력해 주세요.">
		            <div id="passwordCheckError" class="error"></div>
		        </div>
		        <div class="email">
		            <input id="email" type="text" placeholder="이메일을 입력해 주세요.">
		            <div id="emailError" class="error"></div>
		        </div>        
		        <div class="phone">
		            <input id="phone1" type="text" size="1" maxlength="3" oninput="changePhone1()"> -
		            <input id="phone2" type="text" size="3" maxlength="4" oninput="changePhone2()"> -
		            <input id="phone3" type="text" size="3" maxlength="4" oninput="changePhone3()">
		
		        </div>
		        <div class="gender">
		            <input id="gender_man" type="radio" name="gender">남성  
		            <input id="gender_woman" type="radio" name="gender">여성
		            <div id="genderError" class="error"></div>
		        </div>
   		        <div class="update">
		            <button id="update" onclick="fn_update()">수정</button>
		        </div>
		   </div>
		</form:form>
		 
		<form:form modelAttribute="MemberDto" id="selectForm" name="selectForm" method="post"> 
			<input type="hidden" name="_method" value="select">
	        <!-- List -->
        	<div id="table">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블">
        			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
        			<colgroup>
        				<col width="40"/>
        				<col width="100"/>
        				<col width="150"/>
        				<col width="80"/>
        				<col width="?"/>
        				<col width="60"/>
        			</colgroup>
        			<tr>
        				<th align="center">No</th>
        				<th align="center">이름</th>
        				<th align="center">비밀번호</th>
        				<th align="center">나이</th>
        				<th align="center">성별</th>
        				<th align="center">생년월이</th>
        			</tr>
        			<c:forEach var="result" items="${list}" varStatus="status">
            			<tr>
            				<td align="center" class="listtd"><c:out value="${nm}"/></td>
            				<td align="center" class="listtd"><c:out value="${pw}"/></td>
            				<td align="center" class="listtd"><c:out value="${age}"/></td>
            				<td align="center" class="listtd"><c:out value="${sex}"/></td>
            				<td align="center" class="listtd"><c:out value="${birth}}"/></td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
	        <div class="select">
	            <button id="select" onclick="fn_list()">조회</button>
	        </div>
	    </form:form>
	</body>
</html>