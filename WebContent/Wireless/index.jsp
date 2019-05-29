<%@page import="team.wireless.dao.UserDao"%>
<%@page import="team.wireless.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>考勤管理系统</title>
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet" type="text/css" />
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="assets/css/ionicons.css" rel="stylesheet" type="text/css">
	<link href="assets/css/simple-line-icons.css" rel="stylesheet" type="text/css">
	<link href="assets/css/jquery.mCustomScrollbar.css" rel="stylesheet">
	<link href="assets/css/style.css" rel="stylesheet">
	<link href="assets/css/responsive.css" rel="stylesheet">
	
	<script type="text/javascript">
		var ws;
		var target="ws://localhost:8080/Wireless/demo";
		function subopen(){
			
			if ('WebSocket'in window) {
				ws = new WebSocket(target);
				alert("Websocket");
			}else if ('MozWebsocket'in window) {
				ws = new MozWebsocket(target);
				alert("MozWebsocket");
			}else{
				alert("不支持websocket");
				return;	
			}
			   
			ws.onmessage = function(event){
				alert("=====\\\\\"+event.data);
			}
			
		} 
		
		
		function sendMessage(){
			ws.send("hello ----- hello");
		}
	  
		subopen();
		sendMessage();
		
		
	</script>
	
</head>

<body>
	<%
		HttpSession session1 = request.getSession();
		String usernum =(String)session1.getAttribute("userNum");
		UserDao dao = new UserDao();
		User user = dao.getUserInfo(usernum, "userNum");
		String name = user.getUserName();
	%>

	<div class="wrapper">
		<!-- header -->
		<header class="main-header">
			<div class="container_header">
				<div class="logo">
					<a href="#" onclick="sendMessage();">
						<span class="logo-default">
							<img src="img/logo.png" class="img-response" height="40" alt="">
						</span>
					</a>
				</div>
				<div class="right_detail">
					<div class="row row d-flex align-items-center min-h pos-md-r">
						<div class="col-xl-5 col-3 search_col ">
							<div class="top_function d-md-flex align-items-md-center">
								<div class="icon_menu">
									<a href="#" class="menu-toggler sidebar-toggler">
										<i class="icon-menu"></i>
									</a>
								</div>
								<div class="search">
									<a id="toggle_res_search" data-toggle="collapse" data-target="#search_form" class="res-only-view collapsed" href="javascript:void(0);"
									    aria-expanded="false">
										<i class=" icon-magnifier"></i>
									</a>
									<form id="search_form" role="search" class="search-form collapse" action="#">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="Search...">
											<button type="button" class="btn" data-target="#search_form" data-toggle="collapse" aria-label="Close">
												<i class="ion-android-search"></i>
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="col-xl-7 col-9 d-flex justify-content-end">
							<div class="right_bar_top d-flex align-items-center">
								<div class="fullscreen-btn">
									<a href="javascript:;">
										<i class="icon-size-fullscreen"></i>
									</a>
								</div>

								<!-- notification_Start -->
								<div class="dropdown dropdown-notification">
									<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" aria-expanded="false">
										<i class="fa fa-bell-o"></i>
										<span class="badge_coun"> 1 </span>
									</a>
									<ul class="dropdown-menu scroll_auto height_fixed" aria-labelledby="dropdownMenu1">
										<li class="bigger">
											<h3>
												<span class="bold">通知</span>
											</h3>
											<span class="notification-label">New 1</span>
										</li>
										<li>
											<ul class="dropdown-menu-list">
											
												<li>
													<a href="javascript:;">
														<span class="time">12 mins</span>
														<span class="details">
															<span class="notification-icon pink">
																<i class="fa fa-heart"></i>
															</span>
															<b>Ravi Patel </b>like your photo. </span>
													</a>
												</li>
											</ul>
										</li>
									</ul>
								</div>
								<!-- notification_End -->
								<!-- DropDown_Inbox -->
								<div class="dropdown dropdown-inbox">
									<ul class="dropdown-menu scroll_auto height_fixed" aria-labelledby="dropdownMenu1">
									</ul>
								</div>
								<!--DropDown_Inbox_End -->
								<!-- Dropdown_User -->
								<div class="dropdown dropdown-user">
									<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" aria-expanded="true">
										<img class="img-circle pro_pic" src="" alt="">
										<span class="username"><%=name %></span>
										<i class="fa fa-angle-down"></i>
									</a>
									<ul class="dropdown-menu dropdown-menu-default">
										<li>
											<a href="#">
												<i class="icon-user"></i> Settings </a>
										</li>
										<li>
											<a href="login.html">
												<i class="icon-logout"></i> Log Out </a>
										</li>
									</ul>
								</div>
								<!-- Dropdown_User_End -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- header_End -->
		<!-- Content_right -->
		<div class="container_full">
			<div class="side_bar scroll_auto">
				<div class="user-panel">
					<div class="user_image">
						<img src="assets/images/product_7.jpg" class="img-circle" alt="User Image">
					</div>
					<div class="info">
						<p>
							管理员<%=name %>
						</p>
					</div>
				</div>
				<ul id="dc_accordion" class="sidebar-menu tree">
					<li>
						<a href="index.html">
							<i class="fa fa-home"></i>
							<span>首页</span>
						</a>
					</li>

					<li class="menu_sub">
						<a href="#">
							<i class="fa fa-calendar"></i>
							<span>日历日程</span>
							<span class="arrow"></span>
						</a>
						<ul class="down_menu">
							<li>
								<a href="calendar_basic.html">日历</a>
							</li>
							<li>
								<a href="calendar_meeting.html">会议日程</a>
							</li>
						</ul>
					</li>
					<li class="menu_sub">
						<a href="#">
							<i class="fa fa-wpforms"></i>
							<span>会议管理</span>
							<span class="arrow"></span>
						</a>
						<ul class="down_menu">
							<li>
								<a href="form-basic-input.html">短信通知</a>
							</li>
							<li class="menu_sub">
								<a href="####">添加会议
									<span class="arrow"></span>
								</a>
								<ul class="down_menu lavel3">
									<li>
										<a href="meeting_add.html">正常会议</a>
									</li>
									<li>
										<a href="form-input-group.html">紧急会议</a>
									</li>
								</ul>
							</li>
							<li class="menu_sub">
								<a href="#">会议资料
									<span class="arrow"></span>
								</a>
								<ul class="down_menu lavel3">
									<li>
										<a href="form-validation-basic.html">发布/上传</a>
									</li>
									<li>
										<a href="form-validation-jquery.html">下载</a>
									</li>

								</ul>
							</li>
						</ul>
					</li>
					<li class="menu_sub">
						<a href="#">
							<i class="icon-grid"></i>
							<span>人员数据</span>
							<span class="arrow"></span>
						</a>
						<ul class="down_menu">

							<li>
								<a href="table-datatable.html">已到人员</a>
							</li>
							
							<li>
								<a href="table-datatable-ajax.html">迟到/早退人员</a>
							</li>
								

						</ul>
					</li>
					<li class="menu_sub">
						<a href="#">
							<i class="fa fa-bar-chart text-aqua"></i>
							<span>数据分析</span>
							<span class="arrow"></span>
						</a>
						<ul class="down_menu">
							<li>
								<a href="flot-chart.html">当天/本周考勤情况</a>
							</li>
							<li>
								<a href="echart.html">未来一周/月考勤预测</a>
							</li>
						</ul>
					</li>
					<li class="menu_sub">
						<a href="#">
							<i class="fa fa-file text-aqua"></i>
							<span>应急定位</span>
							<span class="arrow"></span>
						</a>
						<ul class="down_menu">
							<li>
								<a href="profile.html">User Profile</a>
							</li>
							<li>
								<a href="page-login.html">Sign In</a>
							</li>
							<li>
								<a href="page-register.html">Sign Up</a>
							</li>
							<li>
								<a href="invoice.html">Invoice</a>
							</li>
							<li>
								<a href="page_404.html">404</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="content_wrapper">
				<div class="container-fluid">
					<!-- Site_view_box -->
					
					<!-- Site_view_box_End -->
					<!-- Three_Column -->
					<section class="more_detail_box">
						<div class="row">
							
							<div class="col-lg-6 d-flex align-items-stretch">
								<div class="stats-wrap full_chart card">
									<div class="chart_header">
										<div class="chart_headibg">
											<h3>会议日程</h3>
										</div>
										<div class="tools">
											<a class="fa fa-repeat btn-color box-refresh" href="javascript:;"></a>
											<a class="t-collapse btn-color fa fa-chevron-down" href="javascript:;"></a>
											<a class="t-close btn-color fa fa-times" href="javascript:;"></a>
										</div>
									</div>
									<div class="card_chart">
										<div class="events-nest">
											<div class="drak_blue">
												<h1>24</h1>
												<div class="middle_text">
													<span>3 Meetings</span>
													<p>
														周三
														<i class="fontello-record"></i>April 2019
													</p>
												</div>
											</div>
											<ul>
												<li>
													<h4>
														<span class="counter-up-fast">8</span>:00
														<small>PM</small>
													</h4>
													<p>
														Topic：XXX Meeting
														<i class="ion-ios-copy-outline"></i>
														
													</p>
												</li>
												
												<li>
													<h4>
														<span class="counter-up-fast">9</span>:00
														<small>PM</small>
													</h4>
													<p>
														Topic：XXX Meeting
														<i class="ion-ios-copy-outline"></i>
														
													</p>
												</li>
												<li>
													<h4>
														<span class="counter-up-fast">10</span>:00
														<small>PM</small>
													</h4>
													<p>
														Topic：XXX Meeting
														<i class="ion-ios-copy-outline"></i>
														
													</p>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-stretch">
								<div class="stats-wrap full_chart card">
									<div class="chart_header">
										<div class="chart_headibg">
											<h3>实时签到人员</h3>
										</div>
										<div class="tools">
											<a class="fa fa-repeat btn-color box-refresh" href="javascript:;"></a>
											<a class="t-collapse btn-color fa fa-chevron-down" href="javascript:;"></a>
											<a class="t-close btn-color fa fa-times" href="javascript:;"></a>
										</div>
									</div>
									<div class="card_chart">
										<div class="school-timetable">
											<h5>
												<strong>Topic：XXX Meeting</strong>
											</h5>
											<h6>
												<i class="ion-android-home"></i> 地点
												<span>信息楼105</span>
											</h6>
											<hr>
											<ul>
												<li>
													<img class="img-circle round_small" src="assets/images/img1.jpg" alt="">
													<br><span>Tom</span>
												</li>
												<li>
													<img class="img-circle round_small" src="assets/images/img2.jpg" alt="">
													<br><span>Tom</span>

												</li>
												<li>
													<img class="img-circle round_small" src="assets/images/img3.jpg" alt="">
													<br><span>Tom</span>
												</li>
												<li>
													<img class="img-circle round_small" src="assets/images/img4.jpg" alt="">
													<br><span>Tom</span>
												</li>
											</ul>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
					<!-- Three_Column_End -->
				
					<!-- chart -->
					<div class="chart_section">
						<div class="row">
							
							<div class="col-lg-6">
								<div class="full_chart card">
									<div class="chart_header">
										<div class="chart_headibg">
											<h3>考勤人员数据分析</h3>
										</div>
										<div class="tools">
											<a class="fa fa-repeat btn-color box-refresh" href="javascript:;"></a>
											<a class="t-collapse btn-color fa fa-chevron-down" href="javascript:;"></a>
											<a class="t-close btn-color fa fa-times" href="javascript:;"></a>
										</div>
									</div>
									<div class="card_chart">
										<div id="canvas-holder">
											<canvas id="chartjs_pie"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="full_chart card">
									<div class="chart_header">
										<div class="chart_headibg">
											<h3>会议资料目录</h3>
										</div>
										<div class="tools">
											<a class="fa fa-repeat btn-color box-refresh" href="javascript:;"></a>
											<a class="t-collapse btn-color fa fa-chevron-down" href="javascript:;"></a>
											<a class="t-close btn-color fa fa-times" href="javascript:;"></a>
										</div>
									</div>
									<div class="card_chart">
										<!-- <div id="canvas-holder">
											<canvas id="chartjs_pie"></canvas>
										</div> -->
									</div>
								</div>
							</div>

						</div>
					</div>
				<!-- chart-end -->

					
				</div>
			</div>
		</div>
		<!-- Content_right_End -->
		<!-- Footer -->
		<footer class="footer ptb-20">
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="copy_right">
						<p>
							2019 © 滁州学院信息中心
							
						</p>
					</div>
					<a id="back-to-top" href="#">
						<i class="ion-android-arrow-up"></i>
					</a>
				</div>
			</div>
		</footer>
		<!-- Footer_End -->
	</div>
	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="assets/js/popper.min.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- chart js -->
	<script src="assets/js/Chart.bundle.js"></script>
	<script src="assets/js/utils.js"></script>

	<script src="assets/js/chart.js"></script>
	<script type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="assets/js/custom.js" type="text/javascript"></script>
</body>

</html>
