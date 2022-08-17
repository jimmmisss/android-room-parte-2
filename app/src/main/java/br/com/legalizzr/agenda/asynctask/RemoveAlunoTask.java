package br.com.legalizzr.agenda.asynctask;

import android.os.AsyncTask;

import br.com.legalizzr.agenda.database.dao.AlunoDAO;
import br.com.legalizzr.agenda.model.Aluno;
import br.com.legalizzr.agenda.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void, Void, Void> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;
    private final Aluno aluno;

    public RemoveAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter, Aluno aluno) {
        this.dao = dao;
        this.adapter = adapter;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        adapter.remove(aluno);
        super.onPostExecute(aVoid);
    }
}
