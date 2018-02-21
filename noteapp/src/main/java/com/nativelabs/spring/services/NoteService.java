package com.nativelabs.spring.services;


import com.nativelabs.spring.domain.Note;
import com.nativelabs.spring.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotes() {
        List<Note> Notes = new ArrayList<>();
        noteRepository.findAll().forEach(Notes::add);
        return Notes;
    }

    public Note getNote(String name) {
        return noteRepository.findOne(name);
    }

    public void addNote(Note course){
        noteRepository.save(course);
    }

    public void updateNote(Note course){
        noteRepository.save(course);
    }

    public void deleteNote(String name){
        noteRepository.delete(name);
    }
}
