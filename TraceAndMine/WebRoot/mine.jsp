<%@ page language="java"
	import="java.util.*,com.ccnu.dao.SequenceDao,com.ccnu.po.SequencePO,
	com.ccnu.demo.Main,com.ccnu.algo.datastructures.SequentialPattern"
	pageEncoding="UTF-8"%>
<div class="dataShow">
	<div id="button_area">
		<div id="true_min_support">
			minSup √<input type="text" name="min_t">
		</div>
		<div id="false_min_support">
			minSup ×<input type="text" name="min_f">
		</div>
		<input type="button" name="some_name" value="开始" onclick="doclick_Mine()">
	</div>

	
	<!-- TT -->
	<div class="show_border"  display="none">
		<%
			Main m = new Main();
			List<String> t_list=m.getTrueSeqs();
		%>
		<div class="show_title">RightSeqs</div>
		<div id="mine_show_f">
			<%
				for (int i=0;i<t_list.size();i++) {
			%>
			<div class="dataDetail">
				<% if(i%2>0){%>
				<p class="t"><%=t_list.get(i)%></p>
				<% }else{%>
				<p><%=t_list.get(i)%></p>
				<%} %>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<!--  FF-->
	<div class="show_border"  display="none">
		<%
			
			List<String> f_list=m.getFalseSeqs();
		%>
		<div class="show_title">WrongSeqs</div>
		<div id="mine_show_f">
			<%
				for (int i=0;i<f_list.size();i++) {
			%>
			<div class="dataDetail">
			<% if(i%2>0){%>
				<p class="f"><%=f_list.get(i)%></p>
				<% }else{%>
				<p ><%=f_list.get(i)%></p>
				<%} %>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="show_border" >
		<%
		String sup_t = request.getParameter("min_t");
		String sup_f = request.getParameter("min_f");
		//double d_t=Double.parseDouble(sup_t);
		//double d_f=Double.parseDouble(sup_f);
		System.out.println(sup_t+""+sup_f);
		
			List<String> r_list=m.getResult();
		%>
		<div class="show_title">ResultShow</div>
		<div id="mine_show_r">
			<%
				for (int i = 0; i < r_list.size(); i++) {
			%>
			<div class="dataDetail">
				<p class="r"><%=r_list.get(i)%></p>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
