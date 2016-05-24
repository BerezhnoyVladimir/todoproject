package ru.javarush.todolist.service;

import org.springframework.transaction.annotation.Transactional;
import ru.javarush.todolist.model.Todo;

import java.util.List;

public interface TodoService {
    public void addTodo(Todo todo);
    public void updateTodo(Todo todo);
    public List<Todo> listTodos();
    public Todo getTodoById(int id);
    public void removeTodo(int id);
    public void completeTodo(int id);

}
