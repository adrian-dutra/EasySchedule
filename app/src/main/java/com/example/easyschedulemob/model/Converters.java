package com.example.easyschedulemob.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Converters {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    public static LocalDate fromString(String value) {
        return value == null ? null : LocalDate.parse(value);
    }

    @TypeConverter
    public static String fromLocalDate(LocalDate date) {
        return date == null ? null : date.toString();
    }
}
