package com.nativelabs.spring.controllers;


import com.nativelabs.spring.domain.Note;
import com.nativelabs.spring.domain.Topic;
import com.nativelabs.spring.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired

    @RequestMapping("/topics/{id}/notes")
    public List<Note> getAllNotes() {
        return noteService.getNotes();
    }

    @RequestMapping("/topics/{id}/notes/{name}")
    public Note getNote(@PathVariable String name){
        return noteService.getNote(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/notes")
    public void addNote(@RequestBody Note note, @PathVariable Integer id){
        note.setTopic(new Topic(id, "", ""));
        noteService.addNote(note);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}/notes/{name}")
    public void updateNote(@RequestBody Note note, @PathVariable Integer id){
        noteService.updateNote(note);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}/notes/{name}")
    public void deleteNote(@PathVariable String name){
        noteService.deleteNote(name);
    }

}
