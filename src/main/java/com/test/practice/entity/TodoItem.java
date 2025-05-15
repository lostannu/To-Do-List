
package com.test.practice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TodoItem {

    @Id
    @GeneratedValue
    private Long id;

    private String task;
    private boolean completed;



    public TodoItem(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

}
