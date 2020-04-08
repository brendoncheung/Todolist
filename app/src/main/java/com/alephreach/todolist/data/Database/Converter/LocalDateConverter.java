package com.alephreach.todolist.data.Database.Converter;

import androidx.room.TypeConverter;

import java.time.LocalDate;

public class LocalDateConverter {

    @TypeConverter
    public String toDateString (LocalDate dateTime) {
        return dateTime.toString();
    }

    @TypeConverter
    public LocalDate toDateTime (String s) {
        return LocalDate.parse(s);
    }
}
