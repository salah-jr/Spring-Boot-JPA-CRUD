package com.salah.springmysql.course;

import com.salah.springmysql.topic.Topic;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "incrementor")
    private int id;

    private String name;
    private String description;

    @ManyToOne(targetEntity=Topic.class)
    @JoinColumn(name = "topicId", nullable = false)
    private Topic topic;

    public Course() {
    }

    public Course(int id, String name, String description, int topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}