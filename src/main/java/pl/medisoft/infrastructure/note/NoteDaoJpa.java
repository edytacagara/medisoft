/*
 * The GNU GPL License 
 * Copyright (c) 2015-2016 IT Students of 5th year 
 * at the University of Maria Curie-Sklodowska in Lublin 
 */
package pl.medisoft.infrastructure.note;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import pl.medisoft.domain.note.Note;
import pl.medisoft.infrastructure.BasicDaoJpa;

/**
 *
 * @author Mariusz Batyra
 */
public class NoteDaoJpa extends BasicDaoJpa implements NoteDao {

    private static final String FIND_USER_NOTES = "select note from Note note "
            + " where note.user.id = :userId and note.deleted is null"
            + " order by note.id asc";
    
    private static final String NEXT_VAL = "select NOTES_ID_SEQ.nextval  from dual";
    
    @Override
    public List<Note> findUserNotes(Long userId) {
        return getEntityManager().createQuery(FIND_USER_NOTES)
                .setParameter("userId", userId).getResultList();
    }

    @Override
    public void deleteNote(Note note) {
        getEntityManager().getTransaction().begin();
        note.setDeleted(1L);
        note.setLastModify(new Date());
        getEntityManager().getTransaction().commit();
    }

    @Override
    public boolean updateNote(Note note) {
        try {
            getEntityManager().getTransaction().begin();
            note.setLastModify(new Date());
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean createNote(Note note) {
        try {
            getEntityManager().getTransaction().begin();
            note.setId(getNextValueSeq());
            note.setIssueDate(new Date());
            getEntityManager().persist(note);
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Long getNextValueSeq() {
        final BigDecimal result = (BigDecimal) getEntityManager().createNativeQuery(NEXT_VAL)
                .getSingleResult();
        return result.longValue();
    }
    
}
