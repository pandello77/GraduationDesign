<%@ page language="java"
	import="java.util.*,com.ccnu.dao.SequenceDao,com.ccnu.po.SequencePO"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>T&M.</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="Trace Programs and Mine the Sequence ">

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.useso.com/css?family=Source+Code+Pro:200,300,400,500,600,700,900'
	rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript" src="js/jquery.min.js">	</script>
<script type="text/javascript" src="js/other.js"></script>



</head>

<body>
	<!--body-->
	<div id="home" class="banner">
	
		<div class="container">
			<div class="top-header">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo.png" alt="" /> </a>
				</div>
				<div class="top-menu">
					<span class="menu"> </span> ByJaneCao
				</div>
				
				<div class="clearfix"></div>
			</div>
			<div class="banner-info" id="default_welcome">
				<h1>Trace &Mine</h1>
				<h3>基于序列模式的并行程序轨迹挖掘及分析</h3>
				<h3>（以读者写者问题为例）</h3>
				<a class="downarrow scroll" href="#service"><span> </span> </a>
			</div>
			<div class="banner-info" hidden id="trace">
				<jsp:include page="trace.jsp" flush="true"/> 
				<a class="downarrow scroll" href="#service"><span> </span> </a>
			</div>

			<div class="banner-info" hidden id="mine">
				<jsp:include page="mine.jsp" flush="true"/> 
				<a class="downarrow scroll" href="#service"><span> </span> </a>
			</div>
			<div class="banner-info" hidden id="find">
				<div class="dataShow">
					<div id="button_area">
						<input type="button" name="some_name" value="开始"
							onclick="doStart()" > <input type="button" name="some_name"
							value="重设" onclick="doReset()" >
					</div>
				</div>
				<a class="downarrow scroll" href="#service"><span> </span> </a>
			</div>
		</div>

	</div>
	<!---->
	<div id="service" class="service">
		<div class="container">
			<div class="service-head">
				<h3>Experiment</h3>
				<h4>WHAT WE HAVE DONE?</h4>
			</div>
			<div class="service-grids">
				<div class="col-md-4 service-grid">
					<a href="#home">
					<img src="images/pic3.png" alt="" onclick="doTrace()"/></a>
					<h3>Trace</h3>
					<h4>use aspectJ monitor the status of programs</h4>
				</div>
				<div class="col-md-4 service-grid">
					<a href="#home">
					<img src="images/pic1.png" alt="" onclick="doMine()" /></a>
					<h3>Mine</h3>
					<h4>find sequences pattern from the SEQUENCES</h4>
				</div>
				<div class="col-md-4 service-grid">
					<a href="#home">
					<img src="images/pic2.png" alt="" onclick="doFind()" /></a>
					<h3>Find Interest</h3>
					<h4>when the target sequence to our view...</h4>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	
	<!---fotter-->
	<div class="fotter">
		<p>
			Copyright &copy; 2015.CCNU All rights reserved.<a target="_blank"
				href="http://www.ccnu.edu.cn">JaneCao</a>
		</p>
	</div>
	<!---->

	<a href="#home" id="toTop" class="scroll" style="display: block;">
		<span id="toTopHover" style="opacity: 1;"> </span> </a>

</body>
</html>
