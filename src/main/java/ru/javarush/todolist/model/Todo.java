package ru.javarush.todolist.model;
import javax.persistence.*;

@Entity
@Table(name="test")
public class Todo {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String title;

    private boolean isDone;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public Todo() {
    }

    @Override
    public String toString() {
        return "id: " + id + ", title: " + title+ ", " + "isDone: " + isDone;
    }
}
