package com.ccnu.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.util.HibernateUtil;

public class DAOSupport<T> {
	private Class<T> entityClass;  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  DAOSupport(){
		 Type sType = getClass().getGenericSuperclass();
		 Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
		 entityClass = (Class) generics[0];	 
	 }
	 
	
	/**
	 * ���һ����¼
	 * @param po
	 * @throws Exception
	 */
	public boolean add(T po) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(po);
			session.save(po);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.closeSession();// 关闭session
			}
		}
		return tx.wasCommitted() ? true : false;
	}
	/**
	 * ɾ���ض���һ����¼
	 * @param po
	 * @throws Exception
	 */
	public boolean delete(T po) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(po);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.closeSession();// 关闭session
			}
		}
		return tx.wasCommitted() ? true : false;

	}
	
	/**
	 * �޸�һ����¼
	 * @param po
	 * @throws Exception
	 */
	public boolean modify(T po) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(po);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateUtil.closeSession();// 关闭session
			}
		}
		return tx.wasCommitted() ? true : false;
	}
	/**
	 * �������е�
	 * @return
	 * @throws Exception
	 */
	public List<T> getAll(String name) throws Exception {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();	
		String hql = "from "+name;
		try {
			org.hibernate.Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<T> list = query.list();
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
	 * 根据id查找
	 * @return
	 * @throws Exception
	 */
	public T findById(int id)throws Exception{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			T res = (T)session.get(entityClass,id);
			return res;
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		finally {
			tx.commit();
			if(session!=null)
			{
			HibernateUtil.closeSession();// 关闭session
			}
		}
		return null;
		
	}
}
