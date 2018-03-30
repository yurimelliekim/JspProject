<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/style.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
	
</style>
</head>
<body>
	<header id="header">
		<div class="root-container">
			<h1 id="logo">
			<img alt="뉴렉처 온라인" src="../../images/logo.png">
		</h1>

		<section>
			<h1 class="hidden">헤더</h1>
			<nav class="hor-menu main-menu first-pad-none">
				<h1 class="hidden">메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<section>
				<h1 class="hidden">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend class="hidden">검색필드</legend>
						<label>과정검색</label> <input type="text" /> 
						<input class="btn btn-img btn-search" type="submit" value="검색" />
					</fieldset>
				</form>
			</section>

			<nav class="hor-menu member-menu first-pad-none">
				<h1>회원 메뉴</h1>
				<ul>
					<li>HOME</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</nav>

			<nav class="hor-menu member-menu first-pad-none">
				<h1>간편 메뉴</h1>
				<ul>
					<li><img alt="마이페이지" src="../../images/txt-mypage.png"></li>
					<li><img alt="고객센터" src="../../images/txt-customer.png"></li>
				</ul>
			</nav>
		</section>
		</div>
	</header>
	
	<!-- ----------visual 시작------------------------------------------------------ -->
	<div id="visual">
		<div class="root-container">
		
		</div>
	</div>

	<div id="body">
		<div class="root-container clear-fix">
			<!-- ----------aside 시작------------------------------------------------------ -->
			<aside id="aside">
			<h1>고객센터</h1>
				<nav>
				<h1>고객센터 메뉴</h1>
				
				<ul>
					<li>공지사항</li>
					<li>1:1고객문의</li>
					<li>학습안내</li>
				</ul>
			</nav>
			<nav>
				<h1>추천사이트</h1>
				<ul>
					<li>앤서이즈</li>
					<li>W3C</li>
					<li>마이크로소프트</li>
				</ul>
			</nav>

			</aside>
			<!-- ----------main 시작------------------------------------------------------ -->
			<main id="main">
			<section>
				<h1 class="title">공지사항</h1>

				<section>
					<h1>경로</h1>

					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</section>
				<section>
					<h1>공지사항 검색 폼</h1>
					<form>
						<label>검색어</label><input type="text" /> <input
							class="btn btn-text btn-default" type="submit" value="검색" />
					</form>
				</section>

				<section>
					<h1>공지사항 검색 목록</h1>

					<table border="1">
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
						<%
						String sql = "SELECT * FROM NOTICE";
						
						Class.forName("oracle.jdbc.driver.OracleDriver");
						
						String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
						Connection con = DriverManager.getConnection(url,"c##sist","dclass");
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);
						
						String id;
						String title;
						String writer_id;
						%>

						<%while(rs.next()){ 
						id = rs.getString("ID");
						title = rs.getString("TITLE");
						writer_id = rs.getString("WRITER_ID");%>
						<tr>
							<td>6</td>
							<td><a href=""><sapn class="color-notice"><%=title %></sapn></a></td>
							<td><%=writer_id %></td>
							<td>2017-12-18</td>
							<td>59</td>
						</tr>
						<% }%>

						<%
						rs.close();
						st.close();
						con.close(); 
						%>


					</table>
				</section>
				<div>1/1 pages</div>

				<div>
					<a href="reg" class="button btn-text default-button">글쓰기 버튼</a> <a
						href="reg" class="btn btn-text cancel-button">테스트</a>
				</div>

				<div>이전1다음</div>
			</section>
			</main>
		<!-- <div style="clear:left;"></div> -->
		</div>
</div>
	<footer id="footer">
		<div class="root-container">
			<!-- 회사정보
	주소서울특별시 마포구 토정로35길 11, 5층 266호(용강동, 인우빌딩)관리자메일admin@newlecture.com사업자 등록번호132-18-46763 통신 판매업 신고제 2013-서울강동-0969 호 상호뉴렉처대표박용우전화번호070-4206-4084 [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를 이용해주시기 바랍니다]
	Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
		</div>
	</footer>
</body>
</html>