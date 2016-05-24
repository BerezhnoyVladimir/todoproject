package ru.javarush.todolist.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javarush.todolist.model.Todo;

import java.util.List;

@Repository
public class TodoDAOImpl implements TodoDAO{
    private static final Logger logger = LoggerFactory.getLogger(TodoDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(todo);
        logger.info("Todo saved successfully, Todo Details="+todo);
    }

    @Override
    public void updateTodo(Todo todo) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(todo);
        logger.info("Todo updated successfully, Todo Details="+todo);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Todo> listTodos() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Todo> todoList = session.createQuery("from Todo").list();
        for(Todo todo : todoList){
            logger.info("Todo List::"+todo);
        }
        return todoList;
    }

    @Override
    public Todo getTodoById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Todo todo = (Todo) session.load(Todo.class, new Integer(id));
        logger.info("Todo loaded successfully, todo details="+todo);
        return todo;
    }

    @Override
    public void removeTodo(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Todo todo = (Todo) session.load(Todo.class, new Integer(id));
        if(null != todo){
            session.delete(todo);
        }
        logger.info("Todo deleted successfully, todo details="+todo);
    }
}
