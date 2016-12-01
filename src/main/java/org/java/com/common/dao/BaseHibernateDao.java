package org.java.com.common.dao;

import java.util.List;
import java.util.Map;

public interface BaseHibernateDao<T> {
	/**
	 * �������
	 * 
	 * @param t
	 * 
	 */
	public void save(T t);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * 
	 */
	public void delete(int id);

	/**
	 * ���¶���
	 * 
	 * @param t
	 * 
	 */
	public void update(T t);

	/**
	 * ����id��ѯ����
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public T getObjectByid(int id);

	/**
	 * ��ѯ���ж���
	 * 
	 * @return
	 */
	public List<T> getObjectALL();

	/**
	 * ����һ��id��ѯһ�����
	 * 
	 * @param ids
	 * 
	 * @return
	 */
	public List<T> getObjectByids(int ids);
	/**
	 * ͨ��SQL��ѯ,�������������ֱ�ӷ���
	 * 
	 * @param queryString
	 *            ��ѯ�ַ���
	 * @param params
	 *            ����
	 * @return
	 */
	public List<Object> findSqlObject(String queryString, Object[] params);

	/**
	 * ͨ��SQL��ѯ,�������������ֱ�ӷ���
	 * 
	 * @param queryString
	 *            ��ѯ�ַ���
	 * @param params
	 *            ����
	 * @return Object[]
	 */
	public List<Object[]> find_sql(String queryString, Object[] params);

	/**
	 * ͨ��SQL��ѯ���������ת����Map����������Ϊ��(�������з��ؽ�����Ĵ洢���̻��ѯ���)
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> find_sql_toMap(String queryString,
			Object[] params);

	/**
	 * ͨ��SQLִ���޷��ؽ������䣬ִ���޸ġ�ɾ������ӵ�(�������޽��������SQL��䣬�������ڴ洢����)
	 * 
	 * @param queryString
	 * @param params
	 */
	public void executeSql(String queryString, Object[] params);

	/**
	 * ͨ��SQLִ���޷��ؽ���Ĵ洢����(�����ڴ洢����)
	 * 
	 * @param queryString
	 * @param params
	 */
	public void executeVoidProcedureSql(final String queryString,
			final Object[] params) throws Exception;

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
			final Object[] params);

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
			final String sql, final Object[] params);
}
