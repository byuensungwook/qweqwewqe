<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>index</title>
    <style>
        table {
            width: 100%;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        table th {
            border: 1px solid #444444;
            text-align: center;
            height: 40px;
            background-color: dodgerblue;
            color: cornsilk;
        }
        table td {
            border: 1px solid #444444;
            text-align: center;
        }
    </style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function () {
    		
    		var data = {
                id : 1,
               	name : "test",
               	pw : "test",
               	age : "20",
               	sex : "2",
               	birth : "test",
            }
    		
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
	        $('#a[id^="selectBoard"]').on('click', function(){
	        	console.log($('#a[id^="selectBoard"]').val);  
	        	//$('#board').attr('action', '/detailBoard').submit();
	        });
	    });
    	
    	function fnSelectBoard(idx){
    		 document .getElementById( "board" );\
    		 
    	}
    </script>
</head>
<body>
<div style="text-align: center;">
    <h1>메인화면</h1>
    <form id="board" method="POST">     
    	<input id="boardId" name="id"></input>
    	<table>
		        <c:forEach var="board" items="${boardList}">
		        <tr>
		        	<td>${board.id}</td>
		        	<td>${board.title}</td>
		        	<td><a href="javascript:void(0)" onclick="fnSelectBoard(<c:out value="${board.id}"/>)"><c:out value="${board.content}"/></a></td>
		        </tr>        	   
		        </c:forEach>
	    </table>
	</form>
</div>
</body>
</html>