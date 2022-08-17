package br.com.legalizzr.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.legalizzr.agenda.database.dao.AlunoDAO;
import br.com.legalizzr.agenda.model.Aluno;
import br.com.legalizzr.agenda.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunoTask extends AsyncTask<Void, Void, List<Aluno>> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void[] objects) {
        List<Aluno> todosAlunos = dao.todos();
        return todosAlunos;
    }

    @Override
    protected void onPostExecute(List<Aluno> todosAlunos) {
        super.onPostExecute(todosAlunos);
    }
}
