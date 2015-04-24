package com.ccnu.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.po.SequencePO;
import com.ccnu.po.TracePO;
import com.ccnu.util.HibernateUtil;

public class TraceDao extends DAOSupport<TracePO> {
	/**
	 * 查找所有的
	 * 
	 * @return
	 * @throws Exception
	 */

	public int getMaxSeqID() {
		Session session = HibernateUtil.currentSession();
		Object o = session.createQuery(
				"select max(a.sequenceID) from TracePO a ").uniqueResult();
		if (session != null) {
			HibernateUtil.closeSession();
		}
		if (o == null)
			return 0;
		else
			return (Integer) o;
	}
	
	public List<TracePO> getBySequenceId(SequencePO s) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		String querySentence = "from TracePO t where t.sequence=?";
		try {
			org.hibernate.Query query = session.createQuery(querySentence);
			query.setParameter(0,s);
			@SuppressWarnings("unchecked")
			List<TracePO> list = query.list();
			if (!list.isEmpty()) {
				return list;
			}
		} catch (Exception e) {
			return null;
		} finally {
			tx.commit();
			if(session!=null)
			{
			HibernateUtil.closeSession();// 关闭session
			}
		}
		return null;
	}

	public boolean deleteAll() throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		   try {
		    Query query1 = session.createSQLQuery("TRUNCATE trace4");
		    query1.executeUpdate();
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
