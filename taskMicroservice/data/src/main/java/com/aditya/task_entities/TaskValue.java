package com.aditya.task_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
public class TaskValue {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String work;
    private String description;

    TaskValue(){

    }

    public TaskValue(Long id, String work, String description) {
        this.id = id;
        this.work = work;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskValue{" +
                "id=" + id +
                ", work='" + work + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskValue taskValue = (TaskValue) o;
        return Objects.equals(id, taskValue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
