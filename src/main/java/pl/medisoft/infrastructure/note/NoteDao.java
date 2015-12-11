/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.note;

import java.util.List;
import pl.medisoft.domain.note.Note;

/**
 *
 * @author Mariusz Batyra
 */
public interface NoteDao {
 
    List<Note> findUserNotes(final Long userId);
    
    void deleteNote(final Note note);
 
    boolean updateNote(final Note note);
    
    boolean createNote(final Note note);
    
    Long getNextValueSeq();
    
}