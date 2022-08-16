package br.com.legalizzr.agenda.database.converter;

import androidx.room.TypeConverter;

import br.com.legalizzr.agenda.model.TipoTelefone;

public class ConversorTipoTeleone {

    @TypeConverter
    public String paraString(TipoTelefone tipo) {
        return tipo.name();
    }

    @TypeConverter
    public TipoTelefone paraTipoTeleone(String valor) {
        if (valor != null) {
            return TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }
}
