package ru.javarush.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javarush.todolist.model.Todo;
import ru.javarush.todolist.service.TodoService;

import java.util.List;


@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired(required=true)
    @Qualifier(value="todoService")
    public void setPersonService(TodoService ts){
        this.todoService = ts;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String listAllTodos(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("listTodos", this.todoService.listTodos());
        return "todolist";
    }

    @RequestMapping(value = "/completed", method = RequestMethod.GET)
    public String listCompletedTodos(Model model) {
        model.addAttribute("todo", new Todo());
        List<Todo> listComleted =new ManagedList<Todo>();
        for (Todo todo : this.todoService.listTodos()) {
            if (todo.getIsDone()) {
                listComleted.add(todo);
            }
        }
        model.addAttribute("listTodos", listComleted);
        return "todolist";
    }

    @RequestMapping(value = "/incompleted", method = RequestMethod.GET)
    public String listIncompletedTodos(Model model) {
        model.addAttribute("todo", new Todo());
        List<Todo> listComleted =new ManagedList<Todo>();
        for (Todo todo : this.todoService.listTodos()) {
            if (!todo.getIsDone()) {
                listComleted.add(todo);
            }
        }
        model.addAttribute("listTodos", listComleted);
        return "todolist";
    }

    @RequestMapping(value= "/todo/add", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute("todo") Todo t){

        if(t.getId() == 0){
            this.todoService.addTodo(t);
        }else{
            this.todoService.updateTodo(t);
        }
        return "redirect:/todos";

    }

    @RequestMapping("/remove/{id}")
    public String removeTodo(@PathVariable("id") int id){

        this.todoService.removeTodo(id);
        return "redirect:/todos";
    }

    @RequestMapping("/edit/{id}")
    public String editTodo(@PathVariable("id") int id, Model model){
        model.addAttribute("todo", this.todoService.getTodoById(id));
        model.addAttribute("listTodos", this.todoService.listTodos());
        return "todolist";
    }

}