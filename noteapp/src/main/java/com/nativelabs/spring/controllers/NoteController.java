package com.nativelabs.spring.controllers;


import com.nativelabs.spring.domain.Note;
import com.nativelabs.spring.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/topics/notes")
    public List<Note> getAllNotes() {
        return noteService.getNotes();
    }


    @RequestMapping("/topics/{id}/notes")
    public List<Note> getAllNotesbyTopic(@PathVariable Integer id) {
        return noteService.getNotesByTopic(id);
    }

    @RequestMapping("/topics/notes/{id}")
    public Note getNote(@PathVariable Integer id){
        return noteService.getNote(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/notes")
    public void addNote(@RequestBody Note note, @PathVariable Integer id){
        noteService.addNote(note, id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/notes/{id}")
    public void updateNote(@RequestBody Note note, @PathVariable Integer id){
        noteService.updateNote(note, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/notes/{id}")
    public void deleteNote(@PathVariable Integer id){
        noteService.deleteNote(id);
    }

}
