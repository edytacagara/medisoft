/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.application.user.note;

import java.util.List;
import pl.medisoft.domain.note.Note;
import pl.medisoft.infrastructure.note.NoteDao;
import pl.medisoft.infrastructure.note.NoteDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class NoteBean {
    
    private final NoteDao noteDao = new NoteDaoJpa();
    
    public List<Note> findUserNotes(Long userId) {
        return noteDao.findUserNotes(userId);
    }
    
    public void deleteNote(final Note note) {
        noteDao.deleteNote(note);
    }
    
    public boolean updateNote(final Note note) {
        return noteDao.updateNote(note);
    }
    
    public boolean createNote(final Note note) {
        return noteDao.createNote(note);
    }
    
}
