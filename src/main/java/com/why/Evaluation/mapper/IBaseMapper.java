package com.why.Evaluation.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;


/**
 * Dao的共有接口
 * @author K550J
 *
 * @param <T>:dto对象
 * @param <E>:example对象
 */
public interface IBaseMapper<T,E> {
	
	/**
	 * 计算总记录数
	 * @param e
	 * @return
	 */
    int countByExample(E e);

    /**
     * 通过example规则删除记录
     * @param e
     * @return
     */
    int deleteByExample(E e);

    /**
     * 通过主键删除记录
     * @param Id
     * @return
     */
    int deleteByPrimaryKey(Integer Id);

    /**
     * 插入新记录
     * @param t
     * @return
     */
    int insert(T t);
    
    /**
     * 插入新记录(只插入不为null的字段,不会影响有默认值的字段)
     * @param t
     * @return
     */
    int insertSelective(T t);

    /**
     * 通过example规则查询多条记录
     * @param e
     * @return
     */
    List<T> selectByExample(E e);

    /**
     * 通过主键查询一条记录
     * @param Id
     * @return
     */
    T selectByPrimaryKey(Integer Id);
    
    /**
     * 通过example规则更新记录()
     * @param t
     * @param e
     * @return
     */
    int updateByExampleSelective(@Param("record") T t, @Param("example") E e);

    /**
     * 通过example规则更新记录
     * @param t
     * @param e
     * @return
     */
    int updateByExample(@Param("record") T t, @Param("example") E e);

    /**
     * 通过example规则更新记录(只更新非空的字段)
     * @param t
     * @param e
     * @return
     */
    int updateByPrimaryKeySelective(T t);
    
    /**
     * 通过主键更新记录
     * @param t
     * @return
     */
    int updateByPrimaryKey(T t);

}
