<%--
  Class Name : EgovMainView.jsp
  Description : 메인화면
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성

    author   : 실행환경개발팀 JJY
    since    : 2011.08.31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/'/>css/base.css">
	<link rel="stylesheet" href="<c:url value='/'/>css/layout.css">
	<link rel="stylesheet" href="<c:url value='/'/>css/component.css">
	<link rel="stylesheet" href="<c:url value='/'/>css/page.css">
	<script src="<c:url value='/'/>js/jquery-1.11.2.min.js"></script>
	<script src="<c:url value='/'/>js/ui.js"></script>
	
	<script type="text/javascript">	
		$(document).ready(function () {
			
	       /*$('#select').on('click', function () {
	            $.ajax({
	                type : 'POST',
	                url : '/selectBoard',
	                contentType : 'application/json; charset=utf-8',
	                data: JSON.stringify(data),
	        		error : function(error) {
	        			console.log("error");
	        		},
	        		success : function(data) {
	        			console.log("success");
	        		}
	            })
	        })*/	        
	        
	        /* 상세 */
	        $('a[name^="selectBoard"]').on('click', function(){
	        	var aName = this.getAttribute('name');				//$('a[name^="selectBoard"]').attr('name')
	        	var id = aName.substr(aName.length - 1, 1)			//선택한 대상의 게시글 id	        	
	        	$('#boardId').attr('value', id);	
	        	$('#mainForm').attr('action', "/detailBoard").submit();
	        });
	       
	        /* 더보가 */
	        $('a[id^="more"]').on('click', function(){
	        	var aId = this.getAttribute('id');				//$('a[name^="selectBoard"]').attr('name')
	        	var id = aId.substr(aId.length - 1, 1)			//선택한 대상의 게시글 id	        	
	        	
	        	if(id == "B") {		//공지사항
	        		$('#mainForm').attr('action', "/selectBoardPost")
	        	}	        	
	        	$('#mainForm').submit();	
	        });
	    });

	</script>
	
<title>경량환경 템플릿 포털사이트</title>
</head>
<body>
	
	<form id="mainForm" method="POST">	
		<input type="hidden" id="boardId" name="id"></input>
		
	    <!-- skip navigation -->
	    <a href="#contents" class="skip_navi">본문 바로가기</a>
	
	    <div class="wrap">
	        <!-- header start -->
		    <c:import url="/sym/mms/EgovHeader.do" />
		    <!-- //header end -->
	
	        <div class="container">
	            <div class="p_main">
	                <div class="visual">
	                    <p>
	                        <span class="t1">표준프레임워크</span>
	                        <span class="t2">경량환경 포털</span>
	                        <span class="t3">표준프레임워크 경량화 포탈에 대한 전반적인 지원을 약속합니다.</span>
	                    </p>
	                </div>    
	                
	                <!-- 게시물 -->
	                <div class="dash_board">
	                    <div class="inner">
	                        <ul class="tab">
	                            <li><a href="" class="cur">공지사항</a></li>
	                            <li><a href="">자유게시판</a></li>
	                            <!-- <li><a href="">묻고 답하기</a></li> -->
	                        </ul>
	
	                        <div class="tab_contents">
	                        
	                        	<!-- 공지사항 -->
	                            <div class="tab_item">
	                                <h2 class="blind">공지사항</h2>
	                                <ul>                                
	                                	<c:if test="${fn:length(boardList) == 0}" >
					                        <li>최신 게시물이 없습니다.</li>
					                    </c:if>                                
	                                	<c:forEach var="boardList" items="${boardList}" varStatus="status">
		                                    <li>   
		                                    	<a name="selectBoard<c:out value="${boardList.id}"/>" href="javascript:void(0)">                                                                             
		                                        	<span class="tit">
		                                            	<c:choose>
		                                            		<c:when test="${fn:length(boardList.title) > 10 }">
		                                            			<c:out value="${fn:substring(boardList.title, 0, 10)}" />...
		                                            		</c:when>
		                                            		<c:otherwise>
		                                            			<c:out value="${boardList.title}"></c:out>
		                                            		</c:otherwise>
		                                            	</c:choose>
		                                            </span>
		                                            <span class="desc">
		                                            	<c:choose>
		                                            		<c:when test="${fn:length(boardList.content) > 100 }">
		                                            			<c:out value="${fn:substring(boardList.content, 0, 100)}" />...
		                                            		</c:when>
		                                            		<c:otherwise>
		                                            			<c:out value="${boardList.content}"></c:out>
		                                            		</c:otherwise>
		                                            	</c:choose>
		                                            </span>
		                                            <span class="dates">
   														<fmt:parseDate value="${boardList.modDate}" pattern="yyyy-MM-dd'T'HH:mm" var="modDate"/>
                										<fmt:formatDate pattern="yyyy-MM-dd" value="${modDate}"/>
		                                            </span>
		                                        </a>
		                                    </li>
	                                    </c:forEach>
	                                </ul>
	                                <a id="moreB" class="more">더보기</a>
	                            </div>
	                        
	                            <!-- 자유게시판 -->
	                            <div class="tab_item">
	                                <h2 class="blind">자유게시판</h2>
	                                <ul>
	                                
	                                	<c:if test="${fn:length(bbsList) == 0}" >
					                        <li>최신 게시물이 없습니다.</li>
					                    </c:if>
					                    
					                    <c:forEach var="result" items="${bbsList}" begin="0" end="2" step="1" varStatus="status">
	                                    <li>
	                                        <a href="<c:url value='/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_BBBBBBBBBBBB'/>">
	                                            <c:if test="${!(result.isExpired=='Y' || result.useAt == 'N')}">
		                                            <span class="tit">
		                                            	<c:choose>
		                                            		<c:when test="${fn:length(result.nttSj) > 51 }">
		                                            			<c:out value="${fn:substring(result.nttSj, 0, 50)}" />...
		                                            		</c:when>
		                                            		<c:otherwise>
		                                            			<c:out value="${result.nttSj }"></c:out>
		                                            		</c:otherwise>
		                                            	</c:choose>
		                                            </span>
		                                            <span class="desc">
		                                            	<c:choose>
		                                            		<c:when test="${fn:length(result.nttCn) > 151 }">
		                                            			<c:out value="${fn:substring(result.nttCn, 0, 150)}" />...
		                                            		</c:when>
		                                            		<c:otherwise>
		                                            			<c:out value="${result.nttCn }"></c:out>
		                                            		</c:otherwise>
		                                            	</c:choose>
		                                            </span>
		                                            <span class="dates">
		                                            	<c:out value="${result.frstRegisterPnttm}"/>
		                                            </span>
	                                            </c:if>
	                                        </a>
	                                    </li>
	                                    </c:forEach>
	                                    
	                                </ul>
	                                <a href="<c:url value='/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_BBBBBBBBBBBB'/>" class="more">더보기</a>
	                            </div>
	
	                            
	
	                            <!-- 묻고답하기 -->
	                            <div class="tab_item">
	                                <h2 class="blind">묻고답하기</h2>
	                                <ul>
	                                    <li>
	                                        <a href="<c:url value='/uss/olh/qna/QnaListInqire.do'/>">
	                                            <span class="tit">전자정부 표준프레임워크 경량환경 포털 묻고답하기입니다.</span>
	                                            <span class="desc">안녕하세요. 전자정부 표준프레임워크 센터입니다. 
	                                                현재 전자정부 표준프레임워크 경량환경 포털 공지
	                                                사항입니다. 안녕하세요. 전자정부 표준프레임워크 
	                                                센터입니다. 현재 전자정부 표준프레임워크...</span>
	                                            <span class="dates">2021-06-30</span>
	                                        </a>
	                                    </li>
	                                    <li>
	                                        <a href="">
	                                            <span class="tit">전자정부 표준프레임워크 경량환경 포털 묻고답하기입니다.</span>
	                                            <span class="desc">안녕하세요. 전자정부 표준프레임워크 센터입니다. 
	                                                현재 전자정부 표준프레임워크 경량환경 포털 공지
	                                                사항입니다. 안녕하세요. 전자정부 표준프레임워크 
	                                                센터입니다. 현재 전자정부 표준프레임워크...</span>
	                                            <span class="dates">2021-06-30</span>
	                                        </a>
	                                    </li>
	                                    <li>
	                                        <a href="">
	                                            <span class="tit">전자정부 표준프레임워크 경량환경 포털 묻고답하기입니다.</span>
	                                            <span class="desc">안녕하세요. 전자정부 표준프레임워크 센터입니다. 
	                                                현재 전자정부 표준프레임워크 경량환경 포털 공지
	                                                사항입니다. 안녕하세요. 전자정부 표준프레임워크 
	                                                센터입니다. 현재 전자정부 표준프레임워크...</span>
	                                            <span class="dates">2021-06-30</span>
	                                        </a>
	                                    </li>
	                                </ul>
	                                <a href="<c:url value='/uss/olh/qna/QnaListInqire.do'/>" class="more">더보기</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <!--// 게시물 -->
	
	                <div class="g_area">
	                    <div class="inner">
	                        <div class="left_col">
	                            <!-- FAQ -->
	                            <div class="faq">
	                                <div class="head">
	                                    <h2>자주하는 질문<span>FAQ</span></h2>
	                                    <p>표준프레임워크 경량화 서비스에 대한 자주하는 질문의 답변들을 볼 수 있습니다.</p>
	                                </div>
	                                
	                                <c:forEach var="result" items="${faqList}" varStatus="status">
	                                <dl>
	                                    <dt><span class="q">Q</span><a href="<c:url value='/uss/olh/faq/FaqListInqire.do' />"><c:out value="${result.qestnSj}"/></a></dt>
	                                    <dd><span class="a">A</span><c:out value="${fn:substring(fn:escapeXml(result.answerCn), 0, 70)}" /></dd>
	                                </dl>
	                                </c:forEach>
	                                
	                                <a href="<c:url value='/uss/olh/faq/FaqListInqire.do' />" class="more">더보기</a>
	                            </div>
	
	                            <!-- 홍보물 -->
	                            <div class="promotion">
	                                <h2>홍보물</h2>
	                                <p><strong>발간자료 / 뉴스기사</strong> 등의 홍보자료를 제공하고 있습니다.</p>
	                                <a href="#LINK" class="more">더보기</a>
	                            </div>
	                        </div>
	                        <div class="right_col">
	                            <!-- 한방에 신청하는 민원 -->
	                            <div class="complaint">
	                                <h2>한방에 신청하는 <span>민원</span></h2>
	                                <ul>
	                                    <li><a href="#LINK" class="tech" onclick="javascript:goMenuPage('2000000'); return false;">기술지원 필요시<br>유지보수 민원</a></li>
	                                    <li><a href="#LINK" class="buy" onclick="javascript:goMenuPage('2000000'); return false;">구매 제품<br>A/S 민원</a></li>
	                                </ul>
	                                <a href="#LINK" class="more" onclick="javascript:goMenuPage('2000000'); return false;">더보기</a>
	                            </div>
	
	                            <!-- 포털 설문 참여 -->
	                            <div class="survey">
	                                <h2>포털 설문 <span>참여</span></h2>
	                                <p>표준프레임워크 경량환경 포털 홈페이지<br>
	                                    이용에 대해서 사용자 여러분들께<br>
	                                    설문조사를 진행합니다.</p>
	                                <a href="<c:url value='/uss/olp/qnn/EgovQustnrRespondInfoManageList.do'/>">참여하기</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	        <!-- footer 시작 -->
		    <c:import url="/sym/mms/EgovFooter.do" />
		    <!-- //footer 끝 -->
	    </div>
    </form>
</body>
</html>