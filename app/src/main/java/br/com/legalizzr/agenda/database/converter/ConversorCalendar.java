package br.com.legalizzr.agenda.database.converter;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class ConversorCalendar {

    @TypeConverter
    public Long parLong(Calendar valor) {
        if (valor != null) {
            return valor.getTimeInMillis();
        }
        return null;
    }

    @TypeConverter
    public Calendar paraCalendar(Long valor) {
        var momentoAtual = Calendar.getInstance();
        if (valor != null) {
            momentoAtual.setTimeInMillis(valor);
        }
        return momentoAtual;
    }

}
