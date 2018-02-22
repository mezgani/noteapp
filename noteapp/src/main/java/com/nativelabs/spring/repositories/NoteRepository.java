package com.nativelabs.spring.repositories;

import com.nativelabs.spring.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    //public Topic getTopicById(Integer id);

    // getAllTopics();
        // getTopic(String id);
        // updateTopic(Topic topic, String id);
        // deleteTopic(String id);
}