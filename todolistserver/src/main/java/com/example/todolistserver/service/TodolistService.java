package com.example.todolistserver.service;

import com.example.todolistserver.entity.Todolist;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * (Todolist)表服务接口
 *
 * @author makejava
 * @since 2021-11-29 10:23:06
 */
public interface TodolistService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Todolist queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Todolist> queryAllByLimit(int offset, int limit);

    List<Todolist> queryAll();

    /**
     * 新增数据
     *
     * @param todolist 实例对象
     * @return 实例对象
     */
    Todolist insert(Todolist todolist);

    /**
     * 修改数据
     *
     * @param todolist 实例对象
     * @return 实例对象
     */
    Todolist update(Todolist todolist);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    boolean checkOne(String id);
}