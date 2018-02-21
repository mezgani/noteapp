package com.nativelabs.spring.services;


import com.nativelabs.spring.domain.Topic;
import com.nativelabs.spring.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Topic getTopic(Integer id) {
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, Integer id) {
            topicRepository.save(topic);
    }

    public void deleteTopic(Integer id){
        topicRepository.delete(id);
    }
}
