package com.example.todolistserver.service.impl;

import com.example.todolistserver.entity.Todolist;
import com.example.todolistserver.dao.TodolistDao;
import com.example.todolistserver.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Todolist)表服务实现类
 *
 * @author makejava
 * @since 2021-11-29 10:23:06
 */
@Service("todolistService")
public class TodolistServiceImpl implements TodolistService {
    @Resource
    private TodolistDao todolistDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Todolist queryById(String id) {
        return this.todolistDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Todolist> queryAllByLimit(int offset, int limit) {
        return this.todolistDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Todolist> queryAll() {
        Todolist todolist = new Todolist();
        todolist.setIfdelete(false);
        return this.todolistDao.queryAll(todolist);
    }

    /**
     * 新增数据
     *
     * @param todolist 实例对象
     * @return 实例对象
     */
    @Override
    public Todolist insert(Todolist todolist) {
        System.out.println("TodolistService.insertOne()");
        this.todolistDao.insert(todolist);
        return todolist;
    }

    /**
     * 修改数据
     *
     * @param todolist 实例对象
     * @return 实例对象
     */
    @Override
    public Todolist update(Todolist todolist) {
        this.todolistDao.update(todolist);
        return this.queryById(todolist.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        Todolist todo = this.todolistDao.queryById(id);
        todo.setIfdelete(true);
        this.todolistDao.update(todo);
        return true;
//       this.todolistDao.deleteById(id);
//       return true;
    }


    @Override
    public boolean checkOne(String id) {
        Todolist todo = this.todolistDao.queryById(id);
        todo.setDone(!todo.getDone());
        this.todolistDao.update(todo);
        return true;
    }
}