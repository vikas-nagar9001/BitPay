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
<link rel="stylesheet" href="css/wallet.css" />
<link rel="stylesheet" href="css/TransactionDetailsPopUp.css" />



<link rel="stylesheet" href="css/colors/default.css" id="colorSkinCSS">

</head>

<%
HttpSession session1 = request.getSession(false);
try {
	String email = (String) session1.getAttribute("email");
	String name = (String) session.getAttribute("entryName");

	@SuppressWarnings("unchecked")
	ArrayList<String[]> walletHistory = (ArrayList<String[]>) session.getAttribute("walletHistory");

	if (session1 != null && email != null) {
		double walletFunds = (double) session1.getAttribute("walletFunds");
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
									<button type="button" class="refreshbutton"
										onclick="window.location.href='WalletEntry';">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-arrow-repeat"
											viewBox="0 0 16 16">
                                              <path
												d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                                                <path
												fill-rule="evenodd"
												d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"></path>
                                                </svg>
										Refresh
									</button>
								</li>

								<!----------refesh button-------------------->

								<li><a class="CHATBOX_open nav-link-notify" href="#"> <img
										src="img/icon/msg.svg" alt>
								</a></li>
								<li><a class="bell_notification_clicker nav-link-notify"
									href="#"> <img src="img/icon/bell.svg" alt>

								</a></li>

								<div class="Menu_NOtification_Wrap">
									<div class="notification_Header"
										style="display: flex; align-items: center; justify-content: space-between;">
										<h4>Notifications</h4>
										<button type="button" class="refreshicon"
											onclick="window.location.href='WalletEntry';">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-arrow-repeat"
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
												of ₹<%=notificationAmount%></p>
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
										<a href="crypto_wallet.jsp#" class="btn_1 green">See More</a>
									</div>
								</div>
							</div>
							</li>
						</div>
						<div class="profile_info d-flex align-items-center">
							<div class="profile_thumb mr_20">
								<img src="img/transfer/4.png" alt="#">
							</div>
							<div class="author_name">
								<h4 class="f_s_15 f_w_500 mb-0"><%=name%></h4>
								<p class="f_s_12 f_w_400">Manager</p>
							</div>
							<div class="profile_info_iner">
								<div class="profile_author_name">
									<p>Manager</p>
									<h5><%=name%></h5>
								</div>
								<div class="profile_info_details">
									<a href="crypto_wallet.jsp#">My Profile </a> <a
										href="crypto_wallet.jsp#">Settings</a> <a href="LogoutServlet">Log
										Out </a>
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
				<div class="walletBalanceCard">
					<div class="svgwrapper">
						<svg viewBox="0 0 24 26" fill="none"
							xmlns="http://www.w3.org/2000/svg">
                            <rect x="0.539915" y="6.28937" width="21"
								height="4" rx="1.5"
								transform="rotate(-4.77865 0.539915 6.28937)" fill="#7D6B9D"
								stroke="black"></rect>
                            <circle cx="11.5" cy="5.5" r="4.5"
								fill="#E7E037" stroke="#F9FD50" stroke-width="2">
                            </circle>
                            <path
								d="M2.12011 6.64507C7.75028 6.98651 12.7643 6.94947 21.935 6.58499C22.789 6.55105 23.5 7.23329 23.5 8.08585V24C23.5 24.8284 22.8284 25.5 22 25.5H2C1.17157 25.5 0.5 24.8284 0.5 24V8.15475C0.5 7.2846 1.24157 6.59179 2.12011 6.64507Z"
								fill="#BF8AEB" stroke="black"></path>
                            <path
								d="M16 13.5H23.5V18.5H16C14.6193 18.5 13.5 17.3807 13.5 16C13.5 14.6193 14.6193 13.5 16 13.5Z"
								fill="#BF8AEB" stroke="black"></path>
                        </svg>
					</div>

					<div class="balancewrapper">
						<span class="balanceHeading">Wallet balance</span>
						<p class="balance">
							<span id="currency">₹</span><%=walletFunds%>
						</p>
					</div>

					<a href="javascript:void(0)" class="addmoney" id="add-money-btn">
						<span class="plussign">+</span> Add Money
					</a>
				</div>



				<div class="row">


					<div class="col-lg-12">
						<div class="white_card card_height_100 mb_30">
							<div class="white_card_header">
								<div class="white_box_tittle list_header mb-0">
									<h4>Recent Transactions</h4>
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
										<!-- <div class="add_button ms-2">
                                            <a href="crypto_wallet.jsp#" data-bs-toggle="modal"
                                                data-bs-target="#addcategory" class="btn_1">Add New</a>
                                        </div> -->
									</div>
								</div>
							</div>
							<div class="white_card_body">
								<div class="QA_section">
									<div class="QA_table mb_30">

										<table class="table lms_table_active3 "  data-ordering="false" >
											<thead>
												<tr>

													<th scope="col">Name</th>
													<th scope="col">Transaction ID</th>

													<th scope="col">Time</th>
													<th scope="col">Status</th>
													<th scope="col">Amount</th>
												</tr>
											</thead>
											<tbody>
												<%
												for (int i = walletHistory.size() - 1; i >= 0; i--) {
													String transactionId = walletHistory.get(i)[0];
													String Name = walletHistory.get(i)[1]; //added by or user name which add fund
													String amount = walletHistory.get(i)[2];
													String status = walletHistory.get(i)[3];
													String time = walletHistory.get(i)[4];
													String note = walletHistory.get(i)[5];

													//badge 
													String badge = null;
													if (status.equalsIgnoreCase("success")) {
														badge = "success";
													}
													if (status.equalsIgnoreCase("failed")) {
														badge = "danger";
													}
													if (status.equalsIgnoreCase("pending")) {
														badge = "warning";
													}
												%>
												<tr
													onclick="showPopup('<%=transactionId%>', '<%=Name%>', '<%=amount%>', '<%=time%>', '<%=status%>', '<%=note%>')">
													<td>
														<div class="trade d-flex align-items-center">
															<img src="img/currency/1.svg" alt> <span
																class="ms-3"><%=Name%></span>
														</div>
													</td>

													<td><%=transactionId%></td>
													<td><%=time%></td>
													<td><a href="crypto_wallet.jsp#"
														class="badge bg-<%=badge%>"><%=status%>
															</h6> </a></td>
													<td><%=amount%></td>
												</tr>

												<%
												}
												%>

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

		<!-------Transaction Detail view pop up------------->
		<!-- Overlay and Popup -->

		<!-- Detail view popup -->
		<div class="overlay" style="display: none;"></div>
		<div class="popup" style="display: none;">
			<div class="popup-left">
				<a href="#" class="company-logo"> <img src="img/mini_logo.png"
					alt="Company Logo">
				</a>
				<h2>Bit Pay</h2>
				<h1 id="popup-amount">₹0.00</h1>
				<p id="popup-time">Date</p>
			</div>
			<div class="popup-right">
				<div class="popup-header">
					<h3>Transaction Details</h3>
					<span class="close-btn-transaction">&times;</span>
				</div>
				<div class="popup-body">
					<div class="detail-item">
						<span>Payment Amount</span> <span id="popup-payment">₹0.0</span>
					</div>
					<div class="detail-item">
						<span>Fee</span> <span id="popup-account">₹0.0</span>
					</div>
					<div class="detail-item total">
						<span>Total Amount</span> <span id="popup-total">₹0.0</span>
					</div>
					<hr>
					<div class="detail-item detail-block">
						<span>Added By</span> <span id="popup-name" class="detail-value">Name</span>
					</div>
					<div class="detail-item detail-block">
						<span>Transaction ID</span> <span id="popup-transaction-id"
							class="detail-value">Transaction ID</span>
					</div>
					<div class="detail-item detail-block">
						<span>Note</span> <span id="popup-note" class="detail-value">Note</span>
					</div>
					<div class="detail-item detail-block">
						<span>Status</span> <span id="popup-status"
							class="detail-value completed">Completed &#x2714;</span>
					</div>
				</div>
			</div>
		</div>
		<script>
			document
					.querySelector('.close-btn-transaction')
					.addEventListener(
							'click',
							function() {
								document.querySelector('.popup').style.display = 'none';
							});
			function showPopup(transactionId, name, amount, time, status, note) {
				document.querySelector('.overlay').style.display = '';
				document.querySelector('.popup').style.display = '';

				// Update popup content with the clicked row's data
				document.getElementById('popup-amount').textContent = '₹'
						+ amount;
				document.getElementById('popup-time').textContent = time;
				document.getElementById('popup-payment').textContent = '₹'
						+ amount;

				document.getElementById('popup-total').textContent = '₹'
						+ amount;
				document.getElementById('popup-name').textContent = name;
				document.getElementById('popup-transaction-id').textContent = transactionId;
				document.getElementById('popup-note').textContent = note;
				document.getElementById('popup-status').textContent = status;
			}
		</script>

		<!-------Transaction Detail view pop up------------->



		<!--------------------------- add fund form ---------------------->

	 <!-- Add Funds Form -->
    <div class="funds-container" id="funds-form" style="display: none;">
        <form id="credit-card-section" onsubmit="return initiatePayment(event);">
            <div class="funds-card">
                <h3 style="margin-left: 95%;">
                    <a href="javascript:void(0)" id="add-money-close-btn">x</a>
                </h3>
                <div class="funds-header">
                    <h2>Add Funds</h2>
                </div>
                <div class="funds-amount">
                    <input type="number" id="addFundAmount" name="addFundAmount" placeholder="Enter Amount" required>
                </div>
                <button type="submit" class="submit-btn">Add Funds</button>
            </div>
        </form>
    </div>

    <!-- Button to open Add Funds form -->
    <button onclick="openAddFundsForm()">Add Funds</button>

    <script>
        // Function to open the Add Funds form
       

        // Function to initiate the payment using Razorpay
        function initiatePayment(event) {
            event.preventDefault(); // Prevent form submission

            const amount = document.getElementById("addFundAmount").value;

            // Validate amount
            if (!amount || amount <= 0) {
                alert("Please enter a valid amount.");
                return false;
            }

            // Razorpay options
            const options = {
                "key": "rzp_test_qpUAs39kazCw0o", // Replace with your Razorpay API Key
                "amount": amount * 100, // Convert amount to paise
                "currency": "INR",
                "name": "Bit Pay",
                "description": "Add Funds",
                "handler": function(response) {
                    alert("Payment successful! Payment ID: " + response.razorpay_payment_id);
                },
                "prefill": {
                    "name": "Customer Name",
                    "email": "customer@example.com"
                },
                "theme": {
                    "color": "#0d6efd"
                }
            };

            // Create Razorpay instance and open the payment window
            const rzp = new Razorpay(options);
            rzp.open();
        }

       
    </script>
	</div>

		<!--------------------------- add fund form end ---------------------->



		<!--------------------------- funds success failed pop up ---------------------->
		<%
		String error = request.getParameter("error");
		String addFundStatus = request.getParameter("addFundStatus");
		String transactionId = request.getParameter("transactionId");
		%>
		s
		<!-- Success Popup -->
		<div id="success-popup" class="funds-popup">
			<a href="WalletEntry" class="close-btn"
				onclick="closePopup('success-popup')">x</a>
			<div class="popup-content success">
				<div class="funds-icon">&#10003;</div>
				<!-- Success Icon (Checkmark) -->
				<h2>Success!</h2>
				<p>Funds Added Successfully In Your Account</p>
				<h5>
					Transaction Id<br><%=transactionId%></h5>
				<a href="WalletEntry" onclick="closePopup('success-popup')"
					class="popup-button success-button">OKAY</a>
			</div>
		</div>

		<!-- Error Popup -->
		<div id="error-popup" class="funds-popup">
			<a href="WalletEntry" class="close-btn"
				onclick="closePopup('error-popup')">x</a>
			<div class="popup-content error">
				<div class="funds-icon">&#10007;</div>
				<!-- Error Icon (Cross) -->
				<h2>Sorry :(</h2>
				<p><%=error%><br>Something went wrong, please try again!!
				</p>

				<h5>
					Transaction Id<br><%=transactionId%></h5>
				<a href="WalletEntry" onclick="closePopup('error-popup')"
					class="popup-button error-button">TRY AGAIN</a>
			</div>
		</div>


		<%
		if (error != null && !error.isEmpty() && addFundStatus.equals("success")) {
		%>
		<script>
			// Show success popup
			document.getElementById('success-popup').classList.add('show');
		</script>
		<%
		} else if (error != null && !error.isEmpty() && addFundStatus.equals("failed")) {
		%>
		<script>
			// Show error popup
			document.getElementById('error-popup').classList.add('show');
		</script>
		<%
		}
		%>

		<script>
			// Function to close the pop-up
			function closePopup(popupId) {
				document.getElementById(popupId).classList.remove('show');
			}
		</script>




		<!--------------------------- funds success failed pop up end ---------------------->

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
					<li><a href="crypto_wallet.jsp#">
							<div class="member_thumb">
								<img src="img/staf/1.png" alt>
							</div>
					</a></li>
					<li><a href="crypto_wallet.jsp#">
							<div class="member_thumb">
								<img src="img/staf/2.png" alt>
							</div>
					</a></li>
					<li><a href="crypto_wallet.jsp#">
							<div class="member_thumb">
								<img src="img/staf/3.png" alt>
							</div>
					</a></li>
					<li><a href="crypto_wallet.jsp#">
							<div class="member_thumb">
								<img src="img/staf/4.png" alt>
							</div>
					</a></li>
					<li><a href="crypto_wallet.jsp#">
							<div class="member_thumb">
								<img src="img/staf/5.png" alt>
							</div>
					</a></li>
					<li><a href="crypto_wallet.jsp#">
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
		<a title="Go to Top" href="crypto_wallet.jsp#"> <i
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
			String currentPage = "wallet.jsp";
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
		<a href="CloseToast?toastId=<%=toastId%>&currentPage=<%=currentPage%>"
			onclick="closeToast();" class="toast-close">×</a>
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

	<script src="js/dashboard_init.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/wallet.js"></script>



	<!-- funds succes failed Popup -->

	<style>
/* funds success failed pop up */

/* success failed popup */
.funds-popup {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	text-align: center;
	padding: 20px;
	display: none; /* Hidden initially */
	animation: fadeIn 0.5s ease-in-out;
	z-index: 9999; /* Ensure popup appears above other content */
}

.popup-content {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.success {
	color: #28a745;
}

.error {
	color: #dc3545;
}

.funds-icon {
	font-size: 50px;
	margin-bottom: 20px;
}

/* Styles for the Success and Error pop-ups only */
#success-popup h2, #error-popup h2 {
	margin-bottom: 10px;
}

#success-popup p, #error-popup p {
	margin-bottom: 20px;
}

.popup-button {
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	color: white;
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s ease;
}

.success-button {
	background-color: #28a745;
}

.success-button:hover {
	background-color: #218838;
}

.error-button {
	background-color: #dc3545;
}

.error-button:hover {
	background-color: #c82333;
}

.close-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	font-size: 20px;
	cursor: pointer;
	color: #333;
}

.close-btn:hover {
	color: #000;
}

@
keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}

/* Displaying the popup */
#success-popup.show, #error-popup.show {
	display: block;
}
</style>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

</body>
<%
} else {
response.sendRedirect("login.jsp");
}
} catch (NullPointerException e) {
System.out.println("Exception user direct access wallet.jsp redirecting to wallent entry " + e);
response.sendRedirect("WalletEntry");
}
%>
</html>