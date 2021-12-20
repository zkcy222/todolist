package com.example.todolistserver.controller;

import com.example.todolistserver.entity.Todolist;
import com.example.todolistserver.service.TodolistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Todolist)表控制层
 *
 * @author makejava
 * @since 2021-11-29 10:23:06
 */
@RestController
@CrossOrigin
@RequestMapping("todolist")
public class TodolistController {
    /**
     * 服务对象
     */
    @Resource
    private TodolistService todolistService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Todolist selectOne(String id) {
        return this.todolistService.queryById(id);
    }

    @GetMapping("selectAll")
    public List<Todolist> selectAll() {
        return this.todolistService.queryAll();
    }

    @PostMapping("addOne")
    public Todolist insertOne(Todolist todolist) {
        return this.todolistService.insert(todolist);
    }

    @GetMapping("deleteOne")
    public boolean deleteOne(String id) {
        return this.todolistService.deleteById(id);
    }

    @GetMapping("editOne")
    public Todolist editOne(Todolist todolist) {
        return this.todolistService.update(todolist);
    }

    @GetMapping("checkOne")
    public boolean checkOne(String id) {
        return this.todolistService.checkOne(id);
    }

}