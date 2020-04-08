package com.alephreach.todolist.data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.alephreach.todolist.data.Database.Converter.LocalDateConverter;
import com.alephreach.todolist.data.Database.Dao.GroupDao;
import com.alephreach.todolist.domain.Entities.Group;

@Database(entities = {Group.class}, version = 1, exportSchema = false)
@TypeConverters({LocalDateConverter.class})
public abstract class TodoDatabase extends RoomDatabase {
    public abstract GroupDao mGroupDao();

}
