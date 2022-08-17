package br.com.legalizzr.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.legalizzr.agenda.asynctask.BuscaAlunoTask;
import br.com.legalizzr.agenda.asynctask.RemoveAlunoTask;
import br.com.legalizzr.agenda.database.AgendaDatabase;
import br.com.legalizzr.agenda.database.dao.AlunoDAO;
import br.com.legalizzr.agenda.model.Aluno;
import br.com.legalizzr.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        dao = AgendaDatabase.getInstance(context).getAlunoDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        new BuscaAlunoTask(dao, adapter).execute();
    }

    private void remove(Aluno aluno) {
        new RemoveAlunoTask(dao, adapter, aluno).execute();
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}