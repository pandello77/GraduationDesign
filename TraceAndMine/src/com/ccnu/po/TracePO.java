package com.ccnu.po;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Trace4")
@Entity
public class TracePO {
	private int primaryKey;
	private int threadID;
	private String threadName;
	private int methodLine;
	private String methodName;
	private int shareMemoryIndex;
	private String shareMemoryValue;
	private Date date;
	private int millisecond;
	private SequencePO sequence;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk",unique=true,nullable=false)
	public int getPrimaryKey() {
		return primaryKey;
	}
	
	@Column(name="thread_id",nullable=false)
	public int getThreadID() {
		return threadID;
	}
	@Column(name="thread_name",length=50,nullable=false)
	public String getThreadName() {
		return threadName;
	}
	@Column(name="method_line",nullable=false)
	public int getMethodLine() {
		return methodLine;
	}
	@Column(name="method_name",length=50,nullable=false)
	public String getMethodName() {
		return methodName;
	}
	@Column(name="memory_index",nullable=false)
	public int getShareMemoryIndex() {
		return shareMemoryIndex;
	}
	@Column(name="memory_value",length=50,nullable=false)
	public String getShareMemoryValue() {
		return shareMemoryValue;
	}
	@Column(name="record_date",columnDefinition="DateTime",nullable=false)
	public Date getDate() {
		return date;
	}
	@Column(name="record_millisecond",columnDefinition="int",nullable=false)
	public int getMillisecond() {
		return millisecond;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JoinColumn(name="sequence_id")
	public SequencePO getSequence() {
		return sequence;
	}
	
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public void setThreadID(int threadID) {
		this.threadID = threadID;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public void setMethodLine(int methodLine) {
		this.methodLine = methodLine;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public void setShareMemoryIndex(int shareMemoryIndex) {
		this.shareMemoryIndex = shareMemoryIndex;
	}
	public void setShareMemoryValue(String shareMemoryValue) {
		this.shareMemoryValue = shareMemoryValue;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setMillisecond(int millisecond) {
		this.millisecond = millisecond;
	}
	
	public void setSequence(SequencePO sequence) {
		this.sequence = sequence;
	}
	public TracePO(){
		
	}
	public TracePO(int primaryKey, int threadID, String threadName,
			int methodLine, String methodName, int shareMemoryIndex,
			String shareMemoryValue, Date date, int millisecond,int sequenceId) {
		super();
		this.primaryKey = primaryKey;
		this.threadID = threadID;
		this.threadName = threadName;
		this.methodLine = methodLine;
		this.methodName = methodName;
		this.shareMemoryIndex = shareMemoryIndex;
		this.shareMemoryValue = shareMemoryValue;
		this.date = date;
		this.millisecond = millisecond;
	}

	

	

	

	
	

}
