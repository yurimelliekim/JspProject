<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="ctx" value="${pageContext.request.servletContext.contextPath}"></c:set>
	<main>
	<h2 class="main title">회원가입 폼</h2>
	
	<div class="breadcrumb" style="margin-top: -20px;">
		<h3 class="hidden">경로</h3>
		<img src="${ctx}/resource/images/member/step2.png" alt="회원가입 1단계" />
	</div>
	
	<form id="form1" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend class="hidden">회원정보</legend>
			<table class="table margin-top first">
				<tbody>
					<tr>
						<th><label>사진</label></th>
						<td colspan="3" class="text-align-left indent"
							style="height: 60px;"><input id="photo-file-button"
							type="file" name="file" class="hidden" /> <img id="photo"
							src="../resource/images/profile.png"
							style="width: 50px; height: 50px; border: 1px solid #595959; border-radius: 25px; box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.15);" />
							<input class="btn-text btn-default" type="button"
							id="photo-button" value="사진선택" /></td>
					</tr>
					<tr>
						<th><label>아이디</label></th>
						<td colspan="3" class="text-align-left indent"><input
							id="id-text" type="text" name="id" class="width-half"
							required="required" value="" placeholder="영문과 숫자 6~20자 이내"
							pattern="^\w{6,20}$" /> <input class="btn-text btn-default"
							type="button" id="id-check-button" value="중복확인" /></td>
					</tr>
					<tr>
						<th><label>비밀번호</label></th>
						<td colspan="3" class="text-align-left indent"><input
							type="password" name="pwd" class="" required
							placeholder="8자 이상(단 대문자,소문자,특수기호,숫자 모두 1이상씩 포함)"
							pattern="^^(?=(.*\d){2})(?=.*[a-zA-Z])(?=.*[!@#$%])[0-9a-zA-Z!@#$%]{8,}$" />
						</td>
					</tr>
					<tr>
						<th><label>비밀번호 확인</label></th>
						<td colspan="3" class="text-align-left indent"><input class=""
							name="pwd2" type="password" required /></td>
					</tr>
					<tr>
						<th><label>이름</label></th>
						<td colspan="3" class="text-align-left indent"><input
							class="width-half" name="name" type="text" value=""
							required="required" /></td>
					</tr>
					<!-- <tr>
	                     <th><label>필명</label></th>
	                     <td colspan="3" class="text-align-left indent"><input class="width-half" name="nicname" type="text" /></td>
	                  </tr> -->
					<tr>
						<th><label>성별</label></th>
						<td colspan="3" class="text-align-left indent"><select
							class="width-half" name="gender" required>
								<option value="">선택</option>
								<option value="남성">남성</option>
								<option value="여성">여성</option>
						</select></td>
					</tr>
					<tr>
						<th><label>생년월일</label></th>
						<td colspan="3" class="text-align-left indent"><input
							name="birthday" type="date" class="width-half" required
							placeholder="예) 2000-02-17" value="" /> <!-- <input name="y" type="text" class="width-small margin-hor" style="margin-left:0px;" />년
	                        <input name="m" type="text" class="width-small margin-hor" />월
	                        <input name="d" type="text" class="width-small margin-hor" />일 -->
							<input type="radio" name="isLunar" value="0" class="vertical-middle margin-hor" />양력 
							<input type="radio" name="isLunar" value="1" class="vertical-middle margin-hor" />음력
						</td>
					</tr>
					<tr>
						<th><label>핸드폰번호</label></th>
						<td colspan="3" class="text-align-left indent"><input
							name="phone" type="text" class="width-half"
							pattern="^01[016789]-\d{3,4}-\d{4}$"
							placeholder="예) 010-1111-2222" required value="${member.phone}" /></td>
					</tr>
					<tr>
						<th><label>이메일</label></th>
						<td colspan="3" class="text-align-left indent"><input
							name="email" type="email" class="width-half" required
							placeholder="예) user@newlecture.com" value="${member.email}" /></td>
					</tr>
					<tr>
	
						<th colspan="1" class="text-align-right">다음 계산 결과는?<img src="" /></th>
						<td colspan="3" class="text-align-left indent"><input
							type="text" name="checker" class="width-half" required
							placeholder="왼쪽 계산식의 결과를 입력하세요." /></td>
					</tr>
	
					<tr>
						<td colspan="4"><input id="submit-Button" type="submit"
							name="btn" value="확인" style="height: 30px; margin: 20px;"
							class="btn-text btn-default" /></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
	</main>
	<script>
		window.addEventListener("load",function(){
			
			var idCheckButton = document.querySelector("#id-check-button");
			var idText = document.getElementById("id-text");
			var submitButton = document.querySelector("#submit-Button");
			var photoButton = document.querySelector("#photo-button");
			var photoFileButton = document.querySelector("#photo-file-button");
			var photo = document.querySelector("#photo");
			
			var idChecked = false;
			
			
			photoButton.onclick = function(e){
	
				var event = new MouseEvent("click",{
					view:window,
					bubbles:true,
					cancelable:true
					
				});
				
				photoFileButton.dispatchEvent(event);
			};
			
			photoFileButton.onchange = function(e){
				
				var file = photoFileButton.files[0];
				
				var info = "name : "+file.name;
				info += "size : "+file.size;
				info += "type : "+file.type;
				
				var typeParts = file.type.split("/");
				
				if(typeParts[0] !="image")
					alert("지원되는 파일 형식이 아닙니다.");
				
				var reader = new FileReader();
				reader.onload = function(evt){
					photo.src = evt.target.result;	
				};
				reader.readAsDataURL(file);
				
				//var data1 : urlencoded
				//var data = "name=newlec&type=a";
				
				//data2 : multipart
				//var data = new formdata();
				
				
				var request = new XMLHttpRequest();
				request.onload = function() {

				};
				request.open("POST", "idcheck?id=" + memberId, true);
				request.send();
				
				/* for(var key in files[0])
					alert(key); */
			};
			
			idText.onchange = function(e){
				idCheked = false;
			};

			idCheckButton.onclick = function(){
                var memberId = idText.value;
				if(memberId == ""){
					alert("ID를 입력해주세요.")
					return;
			}
			
			var request = new XMLHttpRequest();
			request.onreadystatechange = function() {

				if (request.readyState != 4)
					return;

				var member = JSON.parse(request.responseText);
				
				if (member == null){
					alert("사용 가능한 ID입니다.");
					idChecked = true;
				}
				else
					alert("이미 " + member.name + "님이 사용중입니다.");
			};
			request.open("GET", "idcheck?id=" + memberId, true);
			request.send();

		};
		
		submitButton.onclick = function(){
			if(!idChecked){
				alert("중복확인을 하지 않았습니다.")
				e.preventDefault();
				return;
			}
		}

	});
	</script>