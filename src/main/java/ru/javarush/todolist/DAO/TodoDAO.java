package ru.javarush.todolist.DAO;

import ru.javarush.todolist.model.Todo;

import java.util.List;

public interface TodoDAO {
    public void addTodo(Todo todo);
    public void updateTodo(Todo todo);
    public List<Todo> listTodos();
    public Todo getTodoById(int id);
    public void removeTodo(int id);

}