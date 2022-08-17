package br.com.legalizzr.agenda.database;

import static br.com.legalizzr.agenda.database.AgendaMigrations.TODAS_MIGRATIONS;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.legalizzr.agenda.database.converter.ConversorCalendar;
import br.com.legalizzr.agenda.database.converter.ConversorTipoTeleone;
import br.com.legalizzr.agenda.database.dao.AlunoDAO;
import br.com.legalizzr.agenda.database.dao.TelefoneDAO;
import br.com.legalizzr.agenda.model.Aluno;
import br.com.legalizzr.agenda.model.Telefone;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTeleone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";

    public abstract AlunoDAO getAlunoDAO();

    public abstract TelefoneDAO getTelefoneDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }
}
