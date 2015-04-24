package com.ccnu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.po.SequencePO;
import com.ccnu.util.HibernateUtil;

public class SequenceDao extends DAOSupport<SequencePO>{

	public int getMaxSeqID() {
		Session session = HibernateUtil.currentSession();
		Object o = session.createQuery(
				"select max(a.primaryKey) from SequencePO a ").uniqueResult();
		if (session != null) {
			HibernateUtil.closeSession();
		}
		if (o == null)
			return 0;
		else
			return (Integer) o;
	}
	/**
	 * 查找状态为正确执行的
	 * @return
	 * @throws Exception
	 */
	public List<SequencePO> getTrue(String name) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();	
		String hql = "from "+name+"  table where table.status=true";
		try {
			org.hibernate.Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<SequencePO> list = query.list();
			if(!list.isEmpty()){
				return list;
				}
			else
				return null;
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {	
			tx.commit();
			if(session!=null)
			{
			HibernateUtil.closeSession();
			}
		}
		return null;
	}
	/**
	 * 查找状态为错误执行的
	 * @return
	 * @throws Exception
	 */
	public List<SequencePO> getFalse(String name) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();	
		String hql = "from "+name+"  table where table.status=false";
		try {
			org.hibernate.Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<SequencePO> list = query.list();
			if(!list.isEmpty()){
				return list;
				}
			else
				return null;
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {	
			tx.commit();
			if(session!=null)
			{
			HibernateUtil.closeSession();
			}
		}
		return null;
	}
	/**
	 * 删除记录
	 * @throws Exception
	 */
	public boolean deleteAll() throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		   try {
		    Query query = session.createSQLQuery("TRUNCATE sequence4");
		    query.executeUpdate();
		    tx.commit();
		   } catch (HibernateException e) {
		    tx.rollback();
		    e.printStackTrace();
		   }finally {
				if (session != null) {
					HibernateUtil.closeSession();// 鍏抽棴session
				}
			}
			return tx.wasCommitted() ? true : false;
		

	}
}
