package com.why.Evaluation.dao;

/**
 * dao层的公有接口
 * @author K550J
 *
 * @param <E>
 */
public interface Exam_BaseDao<E> {
	
	/**
	 * 新增对象并返回其id
	 * @param e
	 * @return
	 */
	public Integer add(E e);
	
	/**
	 * 通过id获取对象
	 * @param id
	 * @return
	 */
	public E getById(Integer id);
	
	
	/**
	 * 通过id删除对象
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
	
	/**
	 * 修改对象
	 * @param e
	 * @return
	 */
	public boolean update(E e);
	
}
