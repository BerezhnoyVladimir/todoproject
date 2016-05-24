package ru.javarush.todolist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.todolist.DAO.TodoDAO;
import ru.javarush.todolist.model.Todo;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoDAO todoDAO;

    public void setTodoDAO(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    @Transactional
    public void addTodo(Todo todo) {
        this.todoDAO.addTodo(todo);
    }

    @Override
    @Transactional
    public void updateTodo(Todo todo) {
        this.todoDAO.updateTodo(todo);
    }

    @Override
    @Transactional
    public List<Todo> listTodos() {
        return this.todoDAO.listTodos();
    }

    @Override
    @Transactional
    public Todo getTodoById(int id) {
        return this.todoDAO.getTodoById(id);
    }

    @Override
    @Transactional
    public void removeTodo(int id) {
        this.todoDAO.removeTodo(id);
    }

    @Override
    @Transactional
    public void completeTodo(int id) {
        Todo todo = this.todoDAO.getTodoById(id);
        todo.setIsDone(true);
        this.todoDAO.updateTodo(todo);
    }

}
