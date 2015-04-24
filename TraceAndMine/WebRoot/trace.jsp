<%@ page language="java"
	import="java.util.*,com.ccnu.dao.SequenceDao,com.ccnu.po.SequencePO"
	pageEncoding="UTF-8"%>
	
		<div class="dataShow">
				<%
	SequenceDao d=new SequenceDao();
List<SequencePO> allSeq=d.getAll("SequencePO");
%>
					<div id="button_area">
						<input type="button" name="some_name" value="开始"
							onclick="doStart()"> <input type="button"
							name="some_name" value="重设" onclick="doReset()">
					</div>
					<div class="show_border">
						<div class="show_title">TraceShow</div>
						<div id="trace_show">
						<div class="dataDetail">
						<span>序号</span>
						<span>线程名称</span>
						<span>ind</span>
						<span>val</span>
						</div>
							<%
							if(allSeq!=null){
								for(int i=0;i<allSeq.size();i++){
																																						for(int j=0;j<allSeq.get(i).getTraceList().size();j++){
							%>
							<div class="dataDetail">
								<span> <%=allSeq.get(i).getPrimaryKey()%></span> <span> <%=allSeq.get(i).getTraceList().get(j).getThreadName()%>
								</span> <span> <%=allSeq.get(i).getTraceList().get(j).getShareMemoryIndex()%>
								</span> <span> <%=allSeq.get(i).getTraceList().get(j).getShareMemoryValue()%>
								</span>
							</div>
							<%
								}}}
							%>
						</div>
					</div>

					<div class="show_border">
						<div class="show_title">ResultShow</div>
						<div id="result_show">
						<div class="dataDetail">
						<span>序号</span>
						<span>状态</span>
						</div>
							<%if(allSeq!=null){
								for(int i=0;i<allSeq.size();i++){
							%>
							<div class="dataDetail">
								<span> <%=allSeq.get(i).getPrimaryKey()%></span>
								<%
									if(allSeq.get(i).getStatus()==true){
								%>
								<span class="trueSpan"> <%=allSeq.get(i).getStatus()%></span>
								<%
									}else{
								%>
								<span class="falseSpan"> <%=allSeq.get(i).getStatus()%></span>
								<%
									}
								%>
							</div>
							<%
								}}
							%>
						</div>
					</div>
				</div>