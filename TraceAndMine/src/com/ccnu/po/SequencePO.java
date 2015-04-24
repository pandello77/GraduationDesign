package com.ccnu.po;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;  
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="sequence4")
@Entity
public class SequencePO {
	private int primaryKey;
	private boolean status;
	private List<TracePO> traceList=new ArrayList<TracePO>();//对应的路径跟踪信息
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sequence_id",unique=true,nullable=false)
	public int getPrimaryKey() {
		return primaryKey;
	}
	
	@Column(name="status",columnDefinition="int",nullable=false)
	public boolean getStatus() {
		return status;
	}
	
	@OneToMany(mappedBy="sequence" ,fetch=FetchType.EAGER)	
	@Cascade(value = {CascadeType.ALL})  
	public List<TracePO> getTraceList() {
		return traceList;
	}


	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public void setTraceList(List<TracePO> traceList) {
		this.traceList = traceList;
	}

}
