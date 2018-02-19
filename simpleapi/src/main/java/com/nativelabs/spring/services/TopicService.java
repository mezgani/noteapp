package com.nativelabs.spring.services;


import com.nativelabs.spring.domain.Topic;
import com.nativelabs.spring.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Java", "Spring Boot", "Framwork"),
            new Topic("Python","Django", "Framwork"),
            new Topic("Ruby","Rails","Framework")
    ));


    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        topicRepository.delete(id);
    }
}
