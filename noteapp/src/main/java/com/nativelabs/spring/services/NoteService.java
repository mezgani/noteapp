package com.nativelabs.spring.services;

import com.nativelabs.spring.domain.Note;
import com.nativelabs.spring.domain.Topic;
import com.nativelabs.spring.repositories.NoteRepository;
import com.nativelabs.spring.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TopicRepository topicRepository;


    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public List<Note> getNotesByTopic(Integer id){
        List<Note> notes = new ArrayList<>();
        for (Note note: this.getNotes())  {
            if(id.equals(note.getTopic().getId())){
                notes.add(note);
            }
        }
        return notes;
    }

    public Note getNote(Integer id) {
        return noteRepository.findOne(id);
    }

    public void addNote(Note note, Integer id){

        Topic topic = topicRepository.findOne(id);
        note.setTopic(topic);
        note.setCreateDate(new Timestamp(new Date().getTime()));
        note.setUpdateDate(new Timestamp(new Date().getTime()));
        noteRepository.save(note);
    }

    public void updateNote(Note note, Integer id){

        note.setUpdateDate(new Timestamp(new Date().getTime()));
        noteRepository.save(note);
    }

    public void deleteNote(Integer id){
        noteRepository.delete(id);
    }
}
