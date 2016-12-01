package org.java.com.common.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

import org.java.com.common.dao.BaseHibernateDao;

@SuppressWarnings("unchecked")
@Transactional
abstract public class BaseHibernateDaoImpl<T> implements BaseHibernateDao<T> {
	private static final Logger log = LogManager.getLogger();
	// ע��sessionfactory
	@Resource
	public SessionFactory sessionFactory;
	private Class clazz;

	// ���췽������ȡT����ʵ����
	public BaseHibernateDaoImpl() {
		ParameterizedType pType = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) pType.getActualTypeArguments()[0];
		log.debug(clazz.getSimpleName());
	}

	/*
	 * ɾ������ (non-Javadoc)
	 * 
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().get(clazz, id));
	}

	/*
	 * ��ѯ���ж��� (non-Javadoc)
	 * 
	 */

	public List<T> getObjectALL() {
		// System.out.println("=====��"+"from"+clazz.getSimpleName());
		// System.out.println("=====��"+"from    "+clazz.getSimpleName());
		// System.out.println("--------------"+clazz.getSimpleName());
		return sessionFactory.getCurrentSession()
				.createQuery("from " + clazz.getSimpleName()).list();
	}

	/*
	 * ����id��ȡ���� (non-Javadoc)
	 * 
	 */
	public T getObjectByid(int id) {
		// TODO Auto-generated method stub
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	/*
	 * ����һ��id��ȡһ����� (non-Javadoc)
	 * 
	 */
	public List<T> getObjectByids(int ids) {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						" from " + clazz.getSimpleName() + " where id in(:ids)")
				.setParameter("ids", ids).list();
	}

	/*
	 * ������� (non-Javadoc)
	 * 
	 */
	public void save(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}

	/**
	 * ͨ��SQL��ѯ,�������������ֱ�ӷ���
	 * 
	 * @param queryString
	 *            ��ѯ�ַ���
	 * @param params
	 *            ����
	 * @return Object
	 */
	public List<Object> findSqlObject(String queryString, Object[] params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(queryString);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<Object> list = query.list();
		return list;
	}
	/**
	 * ͨ��SQL��ѯ,�������������ֱ�ӷ���
	 * 
	 * @param queryString
	 *            ��ѯ�ַ���
	 * @param params
	 *            ����
	 * @return Object[]
	 */
	public List<Object[]> find_sql(String queryString, Object[] params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(queryString);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<Object[]> list = query.list();
		return list;
	}

	/**
	 * ͨ��SQL��ѯ���������ת����Map����������Ϊ��(�������з��ؽ�����Ĵ洢���̻��ѯ���)
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> find_sql_toMap(String queryString,
			Object[] params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(queryString);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<java.util.Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * ͨ��SQLִ���޷��ؽ������䣬ִ���޸ġ�ɾ������ӵ�(�������޽��������SQL��䣬�������ڴ洢����)
	 * 
	 * @param queryString
	 * @param params
	 */
	public void executeSql(String queryString, Object[] params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * ͨ��SQLִ���޷��ؽ���Ĵ洢����(�����ڴ洢����)
	 * 
	 * @param queryString
	 * @param params
	 */
	public void executeVoidProcedureSql(final String queryString,
			final Object[] params) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.doWork(new Work() {
			public void execute(Connection conn) throws SQLException {
				ResultSet rs = null;
				CallableStatement call = conn.prepareCall("{" + queryString
						+ "}");
				if (null != params) {
					for (int i = 0; i < params.length; i++) {
						call.setObject(i + 1, params[i]);
					}
				}
				rs = call.executeQuery();
				call.close();
				rs.close();
			}
		});
	}

	/**
	 * ͨ���洢���̲�ѯ(�������)
	 * 
	 * @param sql
	 *            ��ѯsql
	 * @param params
	 *            ����
	 * @param columnNum
	 *            ���ص�����
	 * @return
	 */
	public List<Map<String, Object>> find_procedure(final String sql,
			final Object[] params) {
		final List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			Session session = sessionFactory.getCurrentSession();
			session.doWork(new Work() {
				public void execute(Connection conn) throws SQLException {
					CallableStatement cs = null;
					ResultSet rs = null;
					cs = conn.prepareCall(sql);
					for (int i = 1; i <= params.length; i++) {
						cs.setObject(i, params[i - 1]);// ���ò���
					}
					rs = cs.executeQuery();
					ResultSetMetaData metaData = rs.getMetaData();
					int colCount = metaData.getColumnCount();
					while (rs.next()) {
						Map<String, Object> map = new HashMap<String, Object>();
						for (int i = 1; i <= colCount; i++) {
							String colName = metaData.getColumnName(i);
							map.put(colName, rs.getObject(colName));
						}
						result.add(map);
					}
					close(cs, rs);
				}
			});
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ͨ���洢���̲�ѯ(������)
	 * 
	 * @param sql
	 *            ��ѯsql
	 * @param params
	 *            ����
	 * @param columnNum
	 *            ���ص�����
	 * @return
	 */
	public List<List<Map<String, Object>>> find_procedure_multi(
			final String sql, final Object[] params) {
		final List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();
		try {
			// conn =
			// SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
			Session session = sessionFactory.getCurrentSession();
			session.doWork(new Work() {
				public void execute(Connection conn) throws SQLException {
					CallableStatement cs = null;
					ResultSet rs = null;
					cs = conn.prepareCall(sql);
					for (int i = 1; i <= params.length; i++) {
						cs.setObject(i, params[i - 1]);
					}
					boolean hadResults = cs.execute();
					ResultSetMetaData metaData = null;
					while (hadResults) {// ���������
						List<Map<String, Object>> rsList = new ArrayList<Map<String, Object>>();// ����װ�ý����������
						rs = cs.getResultSet();// ��ȡ��ǰ�����
						metaData = rs.getMetaData();
						int colCount = metaData.getColumnCount();// ��ȡ��ǰ�����������
						while (rs.next()) {
							Map<String, Object> map = new HashMap<String, Object>();
							for (int i = 1; i <= colCount; i++) {
								String colName = metaData.getColumnName(i);
								map.put(colName, rs.getObject(colName));
							}
							rsList.add(map);
						}
						result.add(rsList);
						close(null, rs);// ������һ�������������ر�
						hadResults = cs.getMoreResults();// �Ƶ���һ�������
					}
					close(cs, rs);
				}
			});
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void close(CallableStatement cs, ResultSet rs) {
		try {
			if (cs != null) {
				cs.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
