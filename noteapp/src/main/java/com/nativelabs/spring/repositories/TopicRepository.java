package com.nativelabs.spring.repositories;

import com.nativelabs.spring.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

        // getAllTopics();
        // getTopic(String id);
        // updateTopic(Topic topic, String id);
        // deleteTopic(String id);
}