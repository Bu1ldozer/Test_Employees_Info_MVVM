package com.halushchak.testemployeesinfo.converters;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.halushchak.testemployeesinfo.data.pojo.Specialty;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    @TypeConverter
    public String listSpecialityToString(List<Specialty> specialties) {
        return new Gson().toJson(specialties);
    }

    @TypeConverter
    public List<Specialty> stringToListSpecialty(String specialitiesAsString) {
        Gson gson = new Gson();
        ArrayList objects = gson.fromJson(specialitiesAsString, ArrayList.class);
        ArrayList<Specialty> specialties = new ArrayList<>();
        for (Object o : objects) {
            specialties.add(gson.fromJson(o.toString(), Specialty.class));
        }
        return specialties;
    }
}
