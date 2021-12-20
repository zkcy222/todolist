package com.example.todolistserver.dao;

import com.example.todolistserver.entity.Todolist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Todolist)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-29 10:23:06
 */
public interface TodolistDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Todolist queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Todolist> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param todolist 实例对象
     * @return 对象列表
     */
    List<Todolist> queryAll(Todolist todolist);

    /**
     * 新增数据
     *
     * @param todolist 实例对象
     * @return 影响行数
     */
    int insert(Todolist todolist);

    /**
     * 修改数据
     *
     * @param todolist 实例对象
     * @return 影响行数
     */
    int update(Todolist todolist);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
}