package br.com.legalizzr.agenda.asynctask;

import android.os.AsyncTask;

import br.com.legalizzr.agenda.model.Telefone;


abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {

    private final FinalizadaListener listener;

    BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

    void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoFinalizada();
    }

    public interface FinalizadaListener {
        void quandoFinalizada();
    }

}