package com.nativelabs.spring.repositories;

import com.nativelabs.spring.domain.Note;
import com.nativelabs.spring.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, String> {

        // getAllTopics();
        // getTopic(String id);
        // updateTopic(Topic topic, String id);
        // deleteTopic(String id);
}