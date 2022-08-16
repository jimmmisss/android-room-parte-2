package br.com.legalizzr.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.legalizzr.agenda.model.Aluno;

@Dao
public interface AlunoDAO {

    @Insert
    Long salva(Aluno aluno);

    @Query("select * from aluno")
    List<Aluno> todos();

    @Delete
    void remove(Aluno aluno);

    @Update
    void edita(Aluno aluno);
}
