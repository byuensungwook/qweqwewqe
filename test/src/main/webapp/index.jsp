<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<form name="frm"> 
 <table border="1" style="text-align:left;width:800px;height:300px">
<tr>
<td>아이디</td>
<td><input type="text" name="memberId" size="30"></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name="memberPwd" size="30"></td>
</tr>
<tr>
<td>비밀번호 확인</td>
<td><input type="password" name="memberPwd2" size="30"></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="memberName" size="30"></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="email" name="memberEmail" size="30"></td>
</tr>
<tr>
<td>성별</td>
<td>
<input type="radio" name ="memberGender" value="M" checked>남
<input type="radio" name ="memberGender" value="F">여
</td>
</tr>
<tr>
<td>지역</td>
<td><select name="memberAddr" style="width:100px;height:25px">
    <option value="전주">전주</option>
    <option value="대전">대전</option>
    <option value="서울">서울</option>
    </select>
</td>
</tr>
<tr>
<td>연락처</td>
<td>
<input type="text" name="memberPhone" size="30">
</td>
</tr>
<tr>
<td>주민번호</td>
<td><input type="number" name="memberJumin" size="30">    
</td>
</tr>
 
<tr>
<td>취미</td>
<td>
<input type="checkbox" name ="memberHobby" value="축구" checked>축구
<input type="checkbox" name ="memberHobby" value="농구">농구
<input type="checkbox" name ="memberHobby" value="야구">야구
</td>
</tr>
 
<tr>
<td>확인</td>
<td>
<input type="button" value="확인" onclick="check();"> 
<input type="reset" value="리셋"> 
</td>
</tr>
 </table>
 </form>
