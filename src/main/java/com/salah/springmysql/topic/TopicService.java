package com.salah.springmysql.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(int id){
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, int id){
        Topic t = topicRepository.findById(id).orElse(null);
        if(t != null){
            t.setName(topic.getName());
            t.setDescription(topic.getDescription());
        }
        topicRepository.save(t);
    }

    public void deleteTopic(int id){
        topicRepository.deleteById(id);
    }

    public void deleteAllTopics() {
        topicRepository.deleteAll();
    }
}
