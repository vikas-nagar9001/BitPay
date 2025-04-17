<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>BitCrypto</title>
<link rel="icon" href="img/mini_logo.png" type="image/png">

<link rel="stylesheet" href="css/bootstrap1.min.css" />

<link rel="stylesheet" href="vendors/themefy_icon/themify-icons.css" />

<link rel="stylesheet" href="vendors/niceselect/css/nice-select.css" />

<link rel="stylesheet" href="vendors/owl_carousel/css/owl.carousel.css" />

<link rel="stylesheet" href="vendors/gijgo/gijgo.min.css" />

<link rel="stylesheet" href="vendors/font_awesome/css/all.min.css" />
<link rel="stylesheet" href="vendors/tagsinput/tagsinput.css" />

<link rel="stylesheet" href="vendors/datepicker/date-picker.css" />
<link rel="stylesheet" href="vendors/vectormap-home/vectormap-2.0.2.css" />

<link rel="stylesheet" href="vendors/scroll/scrollable.css" />

<link rel="stylesheet"
	href="vendors/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="vendors/datatable/css/responsive.dataTables.min.css" />
<link rel="stylesheet"
	href="vendors/datatable/css/buttons.dataTables.min.css" />

<link rel="stylesheet" href="vendors/text_editor/summernote-bs4.css" />

<link rel="stylesheet" href="vendors/morris/morris.css">

<link rel="stylesheet" href="vendors/material_icon/material-icons.css" />

<link rel="stylesheet" href="css/metisMenu.css">

  <link rel="stylesheet" href="css/style1.css" />
    <link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/colors/default.css" id="colorSkinCSS">
</head>

<%
HttpSession session1 = request.getSession(false);

String email = (String) session1.getAttribute("email");
if (session1 != null && email != null) {
%>
<body class="crm_body_bg">


	<nav class="sidebar dark_sidebar">
		<div class="logo d-flex justify-content-between">
			<a class="large_logo" href="index.jsp"><img
				src="img/logo_white.png" alt></a> <a class="small_logo"
				href="index.jsp"><img src="img/mini_logo.png" alt></a>
			<div class="sidebar_close_icon d-lg-none">
				<i class="ti-close"></i>
			</div>
		</div>
		<ul id="sidebar_menu">
			<li class>
			<li><a href="IndexEntry" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/1.svg" alt>
					</div>


					<div class="nav_title">
						<span>Dashboard</span>
					</div>
			</a></li>
			<li class><a href="WalletEntry" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/2.svg" alt>
					</div>
					<div class="nav_title">
						<span>Wallet</span>
					</div>
			</a></li>
			<li class><a href="SendMoneyEntry" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/3.svg" alt>
					</div>
					<div class="nav_title">
						<span>Send & Request</span>
					</div>
			</a></li>
			<li class><a href="ProfileEntry" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/4.svg" alt>
					</div>
					<div class="nav_title">
						<span>Profile</span>
					</div>
			</a></li>

			<li class><a class="has-arrow" href="#" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/6.svg" alt>
					</div>
					<div class="nav_title">
						<span>Transactions</span>
					</div>
			</a>
				<ul>
					<li><a href="TransactionHistoryEntry">History</a></li>

					<li><a href="RequestEntry">Requests</a></li>


				</ul></li>

			<li class><a class="has-arrow" href="#" aria-expanded="false">
					<div class="nav_icon_small">
						<img src="img/menu-icon/Pages.svg" alt>
					</div>
					<div class="nav_title">
						<span>Pages</span>
					</div>
			</a>
				<ul>
					<li><a href="role_permissions.jsp">Role & Permissions</a></li>

					<li><a href="login.jsp">Login</a></li>
					<li><a href="resister.jsp">Register</a></li>
					<li><a href="error_400.jsp">Error 404</a></li>
					<li><a href="chat.jsp">Chat</a></li>

					<li><a href="forgot_pass.jsp">Forgot Password</a></li>

				</ul></li>


		</ul>
	</nav>
	<section class="main_content dashboard_part large_header_bg">

		<div class="container-fluid g-0">
			<div class="row">
				<div class="col-lg-12 p-0 ">
					<div
						class="header_iner d-flex justify-content-between align-items-center">
						<div class="sidebar_icon d-lg-none">
							<i class="ti-menu"></i>
						</div>
						<div class="line_icon open_miniSide d-none d-lg-block">
							<img src="img/line_img.png" alt>
						</div>
						<div
							class="header_right d-flex justify-content-between align-items-center">
							<div class="header_notification_warp d-flex align-items-center">
								<!----------refesh button-------------------->
								<li>
									<button type="button" class="refreshbutton">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-arrow-repeat"
											viewBox="0 0 16 16">
                                              <path
												d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                                                <path fill-rule="evenodd"
												d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"></path>
                                                </svg>
										Refresh
									</button>
								</li>

								<!----------refesh button-------------------->
								<li><a class="CHATBOX_open nav-link-notify"
									href="#"> <img src="img/icon/msg.svg"
										alt>
								</a></li>
								<li><a class="bell_notification_clicker nav-link-notify"
									href="#"> <img src="img/icon/bell.svg"
										alt>

								</a>

									<div class="Menu_NOtification_Wrap">
										<div class="notification_Header"
											style="display: flex; align-items: center; justify-content: space-between;">
											<h4>Notifications</h4>
											<button type="button" class="refreshicon"
												onclick="window.location.href='IndexEntry';">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-arrow-repeat"
											viewBox="0 0 16 16">
                                              <path
												d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                                                <path
												fill-rule="evenodd"
												d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"></path>
                                                </svg>
												<!-- Font Awesome refresh icon -->
											</button>
										</div>
										<div class="Notification_body">

											<%
											@SuppressWarnings("unchecked")
											ArrayList<String[]> notificationHistory = (ArrayList<String[]>) session.getAttribute("notificationHistory");
											System.out.println(notificationHistory + "size");
											if (notificationHistory != null) {

												for (int i = notificationHistory.size() - 1; i >= 0; i--) {
													String notificationName = notificationHistory.get(i)[0];
													String notificationAmount = notificationHistory.get(i)[1];
													String notificationMessage = notificationHistory.get(i)[2];
													String notificationHeading = notificationHistory.get(i)[3];
													String notificationId = notificationHistory.get(i)[5];

													String currentPage = "index.jsp";
											%>


											<div class="single_notify d-flex align-items-center">
												<div class="notify_thumb">
													<a href="#"><img src="img/staf/2.png" alt></a>
												</div>
												<div class="notify_content">
													<a href="#">
														<h5><%=notificationName%></h5>
													</a>
													<p><%=notificationHeading%>
														of â¹<%=notificationAmount%></p>
													<p>
														Msg :-<%=notificationMessage%></p>
												</div>
											</div>
											<%
											}
											}
											%>
										</div>
										<div class="nofity_footer">
											<div class="submit_button text-center pt_20">
												<a href="role_permissions.jsp#" class="btn_1 green">See
													More</a>
											</div>
										</div>
									</div></li>
							</div>
							<div class="profile_info d-flex align-items-center">
								<div class="profile_thumb mr_20">
									<img src="img/transfer/4.png" alt="#">
								</div>
								<div class="author_name">
									<h4 class="f_s_15 f_w_500 mb-0">Jiue Anderson</h4>
									<p class="f_s_12 f_w_400">Manager</p>
								</div>
								<div class="profile_info_iner">
									<div class="profile_author_name">
										<p>Manager</p>
										<h5>Jiue Anderson</h5>
									</div>
									<div class="profile_info_details">
										<a href="role_permissions.jsp#">My Profile </a> <a
											href="role_permissions.jsp#">Settings</a> <a
											href="role_permissions.jsp#">Log Out </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="main_content_iner overly_inner ">
			<div class="container-fluid p-0 ">

				<div class="row">
					<div class="col-12">
						<div
							class="page_title_box d-flex flex-wrap align-items-center justify-content-between">
							<div class="page_title_left d-flex align-items-center">
								<h3 class="f_s_25 f_w_700 dark_text mr_30">Dashboard</h3>
							</div>
							<div class="page_title_right">
								<div class="page_date_button d-flex align-items-center">
									<img src="img/icon/calender_icon.svg" alt> August 1, 2020
									- August 31, 2020
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="white_card card_height_100 mb_30 pt-4">
							<div class="white_card_body">
								<div class="QA_section">
									<div class="white_box_tittle list_header">
										<h4>Role & Permissions</h4>
										<div class="box_right d-flex lms_block">
											<div class="serach_field_2">
												<div class="search_inner">
													<form Active="#">
														<div class="search_field">
															<input type="text" placeholder="Search content here...">
														</div>
														<button type="submit">
															<i class="ti-search"></i>
														</button>
													</form>
												</div>
											</div>
											<div class="add_button ms-10">
												<a href="role_permissions.jsp#" data-bs-toggle="modal"
													data-bs-target="#addcategory" class="btn_1">search</a>
											</div>
										</div>
									</div>
									<div class="QA_table mb_30">

										<table class="table lms_table_active ">
											<thead>
												<tr>
													<th scope="col">id</th>
													<th scope="col">Admin Role</th>
													<th scope="col">Status</th>
													<th scope="col">Action</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td scope="row"><a href="role_permissions.jsp#"
														class="question_content"> 1 </a></td>
													<td>Super Admin</td>
													<td>
														<div class="checkbox_wrap d-flex align-items-center">
															<label class="form-label lms_checkbox_1" for="course_1">
																<input type="checkbox" id="course_1">
																<div class="slider-check round"></div>
															</label>
														</div>
													</td>
													<td>
														<div class="action_btns d-flex">
															<a href="role_permissions.jsp#" class="action_btn mr_10">
																<i class="far fa-edit"></i>
															</a> <a href="role_permissions.jsp#" class="action_btn">
																<i class="fas fa-trash"></i>
															</a>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="row"><a href="role_permissions.jsp#"
														class="question_content"> 2 </a></th>
													<td>Admin</td>
													<td>
														<div class="checkbox_wrap d-flex align-items-center">
															<label class="form-label lms_checkbox_1" for="course_2">
																<input type="checkbox" id="course_2">
																<div class="slider-check round"></div>
															</label>
														</div>
													</td>
													<td>
														<div class="action_btns d-flex">
															<a href="role_permissions.jsp#" class="action_btn mr_10">
																<i class="far fa-edit"></i>
															</a> <a href="role_permissions.jsp#" class="action_btn">
																<i class="fas fa-trash"></i>
															</a>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="row"><a href="role_permissions.jsp#"
														class="question_content"> 3 </a></th>
													<td>Accountant</td>
													<td>
														<div class="checkbox_wrap d-flex align-items-center">
															<label class="form-label lms_checkbox_1" for="course_3">
																<input type="checkbox" id="course_3">
																<div class="slider-check round"></div>
															</label>
														</div>
													</td>
													<td>
														<div class="action_btns d-flex">
															<a href="role_permissions.jsp#" class="action_btn mr_10">
																<i class="far fa-edit"></i>
															</a> <a href="role_permissions.jsp#" class="action_btn">
																<i class="fas fa-trash"></i>
															</a>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="row"><a href="role_permissions.jsp#"
														class="question_content"> 4 </a></th>
													<td>Operator</td>
													<td>
														<div class="checkbox_wrap d-flex align-items-center">
															<label class="form-label lms_checkbox_1" for="course_4">
																<input type="checkbox" id="course_4">
																<div class="slider-check round"></div>
															</label>
														</div>
													</td>
													<td>
														<div class="action_btns d-flex">
															<a href="role_permissions.jsp#" class="action_btn mr_10">
																<i class="far fa-edit"></i>
															</a> <a href="role_permissions.jsp#" class="action_btn">
																<i class="fas fa-trash"></i>
															</a>
														</div>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer_part">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="footer_iner text-center">
							<p>
								2020 Â© Influence - Designed by <a href="role_permissions.jsp#">
									<i class="ti-heart"></i>
								</a><a href="role_permissions.jsp#"> DashboardPack</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<div class="CHAT_MESSAGE_POPUPBOX">
		<div class="CHAT_POPUP_HEADER">
			<div class="MSEESAGE_CHATBOX_CLOSE">
				<svg width="12" height="12" viewBox="0 0 12 12" fill="none"
					xmlns="http://www.w3.org/2000/svg">
<path
						d="M7.09939 5.98831L11.772 10.661C12.076 10.965 12.076 11.4564 11.772 11.7603C11.468 12.0643 10.9766 12.0643 10.6726 11.7603L5.99994 7.08762L1.32737 11.7603C1.02329 12.0643 0.532002 12.0643 0.228062 11.7603C-0.0760207 11.4564 -0.0760207 10.965 0.228062 10.661L4.90063 5.98831L0.228062 1.3156C-0.0760207 1.01166 -0.0760207 0.520226 0.228062 0.216286C0.379534 0.0646715 0.578697 -0.0114918 0.777717 -0.0114918C0.976738 -0.0114918 1.17576 0.0646715 1.32737 0.216286L5.99994 4.889L10.6726 0.216286C10.8243 0.0646715 11.0233 -0.0114918 11.2223 -0.0114918C11.4213 -0.0114918 11.6203 0.0646715 11.772 0.216286C12.076 0.520226 12.076 1.01166 11.772 1.3156L7.09939 5.98831Z"
						fill="white" />
</svg>
			</div>
			<h3>Chat with us</h3>
			<div class="Chat_Listed_member">
				<ul>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<img src="img/staf/1.png" alt>
							</div>
					</a></li>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<img src="img/staf/2.png" alt>
							</div>
					</a></li>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<img src="img/staf/3.png" alt>
							</div>
					</a></li>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<img src="img/staf/4.png" alt>
							</div>
					</a></li>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<img src="img/staf/5.png" alt>
							</div>
					</a></li>
					<li><a href="role_permissions.jsp#">
							<div class="member_thumb">
								<div class="more_member_count">
									<span>90+</span>
								</div>
							</div>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="CHAT_POPUP_BODY">
			<p class="mesaged_send_date">Sunday, 12 January</p>
			<div class="CHATING_SENDER">
				<div class="SMS_thumb">
					<img src="img/staf/1.png" alt>
				</div>
				<div class="SEND_SMS_VIEW">
					<P>Hi! Welcome . How can I help you?</P>
				</div>
			</div>
			<div class="CHATING_SENDER CHATING_RECEIVEr">
				<div class="SEND_SMS_VIEW">
					<P>Hello</P>
				</div>
				<div class="SMS_thumb">
					<img src="img/staf/1.png" alt>
				</div>
			</div>
		</div>
		<div class="CHAT_POPUP_BOTTOM">
			<div class="chat_input_box d-flex align-items-center">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Write your message" aria-label="Recipient's username"
						aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button class="btn " type="button">

							<svg width="22" height="22" viewBox="0 0 22 22" fill="none"
								xmlns="http://www.w3.org/2000/svg">
<path
									d="M18.7821 3.21895C14.4908 -1.07281 7.50882 -1.07281 3.2183 3.21792C-1.07304 7.50864 -1.07263 14.4908 3.21872 18.7824C7.50882 23.0729 14.4908 23.0729 18.7817 18.7815C23.0726 14.4908 23.0724 7.50906 18.7821 3.21895ZM17.5813 17.5815C13.9525 21.2103 8.04773 21.2108 4.41871 17.5819C0.78907 13.9525 0.789485 8.04714 4.41871 4.41832C8.04752 0.789719 13.9521 0.789304 17.5817 4.41874C21.2105 8.04755 21.2101 13.9529 17.5813 17.5815ZM6.89503 8.02162C6.89503 7.31138 7.47107 6.73534 8.18131 6.73534C8.89135 6.73534 9.46739 7.31117 9.46739 8.02162C9.46739 8.73228 8.89135 9.30811 8.18131 9.30811C7.47107 9.30811 6.89503 8.73228 6.89503 8.02162ZM12.7274 8.02162C12.7274 7.31138 13.3038 6.73534 14.0141 6.73534C14.7241 6.73534 15.3002 7.31117 15.3002 8.02162C15.3002 8.73228 14.7243 9.30811 14.0141 9.30811C13.3038 9.30811 12.7274 8.73228 12.7274 8.02162ZM15.7683 13.2898C14.9712 15.1332 13.1043 16.3243 11.0126 16.3243C8.8758 16.3243 6.99792 15.1272 6.22834 13.2744C6.09642 12.9573 6.24681 12.593 6.56438 12.4611C6.64238 12.4289 6.72328 12.4136 6.80293 12.4136C7.04687 12.4136 7.27836 12.5577 7.37772 12.7973C7.95376 14.1842 9.38048 15.0799 11.0126 15.0799C12.6077 15.0799 14.0261 14.1836 14.626 12.7959C14.7625 12.4804 15.1288 12.335 15.4441 12.4717C15.7594 12.6084 15.9048 12.9745 15.7683 13.2898Z"
									fill="#707DB7" />
</svg>

						</button>
						<button class="btn" type="button">

							<svg width="22" height="22" viewBox="0 0 22 22" fill="none"
								xmlns="http://www.w3.org/2000/svg">
<path
									d="M11 0.289062C4.92455 0.289062 0 5.08402 0 10.9996C0 16.9152 4.92455 21.7101 11 21.7101C17.0755 21.7101 22 16.9145 22 10.9996C22 5.08472 17.0755 0.289062 11 0.289062ZM11 20.3713C5.68423 20.3713 1.375 16.1755 1.375 10.9996C1.375 5.82371 5.68423 1.62788 11 1.62788C16.3158 1.62788 20.625 5.82371 20.625 10.9996C20.625 16.1755 16.3158 20.3713 11 20.3713ZM15.125 10.3302H11.6875V6.98314C11.6875 6.61363 11.3795 6.31373 11 6.31373C10.6205 6.31373 10.3125 6.61363 10.3125 6.98314V10.3302H6.875C6.4955 10.3302 6.1875 10.6301 6.1875 10.9996C6.1875 11.3691 6.4955 11.669 6.875 11.669H10.3125V15.016C10.3125 15.3855 10.6205 15.6854 11 15.6854C11.3795 15.6854 11.6875 15.3855 11.6875 15.016V11.669H15.125C15.5045 11.669 15.8125 11.3691 15.8125 10.9996C15.8125 10.6301 15.5045 10.3302 15.125 10.3302Z"
									fill="#707DB7" />
</svg>

							<input type="file">
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="back-top" style="display: none;">
		<a title="Go to Top" href="role_permissions.jsp#"> <i
			class="ti-angle-up"></i>
		</a>
	</div>

<!-- Toast notification -->
	<%
	@SuppressWarnings("unchecked")
	ArrayList<String[]> toastHistory = (ArrayList<String[]>) session.getAttribute("toastHistory");
	if (toastHistory != null) {
		for (int i = 0; i < toastHistory.size(); i++) {
			String toastName = toastHistory.get(i)[0];
			String toastAmount = toastHistory.get(i)[1];
			String toastHeading = toastHistory.get(i)[2];
			String toastId = toastHistory.get(i)[4];
			String currentPage ="role_permissions.jsp";
	%>
	
	<div class="toast money-received">
		<div class="toast-icon"></div>
		<img
			src="https://plus.unsplash.com/premium_photo-1673967831980-1d377baaded2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Y2F0c3xlbnwwfHwwfHx8MA%3D%3D"
			alt="Profile Picture" class="profile-pic">
		<div class="toast-content">
			<strong><%=toastHeading%></strong>
			<p>
				<%=toastHeading%> ₹<%=toastAmount%> from <%=toastName%></p>
		</div>
	<a href="CloseToast?toastId=<%=toastId%>&currentPage=<%=currentPage %>" 
       onclick="closeToast();"
       class="toast-close">×</a>
	</div>

	
	<%
	}
	}
	%>
	<script src="js/toastnotification.js"></script>
<link rel="stylesheet" href="css/toastnotification.css" />
<!-- Toast notification end -->



	<script src="js/jquery1-3.4.1.min.js"></script>

	<script src="js/popper1.min.js"></script>

	<script src="js/bootstrap1.min.js"></script>

	<script src="js/metisMenu.js"></script>

	<script src="vendors/count_up/jquery.waypoints.min.js"></script>

	<script src="vendors/chartlist/Chart.min.js"></script>

	<script src="vendors/count_up/jquery.counterup.min.js"></script>

	<script src="vendors/niceselect/js/jquery.nice-select.min.js"></script>

	<script src="vendors/owl_carousel/js/owl.carousel.min.js"></script>

	<script src="vendors/datatable/js/jquery.dataTables.min.js"></script>
	<script src="vendors/datatable/js/dataTables.responsive.min.js"></script>
	<script src="vendors/datatable/js/dataTables.buttons.min.js"></script>
	<script src="vendors/datatable/js/buttons.flash.min.js"></script>
	<script src="vendors/datatable/js/jszip.min.js"></script>
	<script src="vendors/datatable/js/pdfmake.min.js"></script>
	<script src="vendors/datatable/js/vfs_fonts.js"></script>
	<script src="vendors/datatable/js/buttons.html5.min.js"></script>
	<script src="vendors/datatable/js/buttons.print.min.js"></script>

	<script src="vendors/datepicker/datepicker.js"></script>
	<script src="vendors/datepicker/datepicker.en.js"></script>
	<script src="vendors/datepicker/datepicker.custom.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="vendors/chartjs/roundedBar.min.js"></script>

	<script src="vendors/progressbar/jquery.barfiller.js"></script>

	<script src="vendors/tagsinput/tagsinput.js"></script>

	<script src="vendors/text_editor/summernote-bs4.js"></script>
	<script src="js/custom.js"></script>
</body>
<%
} else {
response.sendRedirect("login.jsp");
}
%>
</html>
