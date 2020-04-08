package com.alephreach.todolist.ui.di.Module;

import android.content.Context;

import androidx.room.Room;

import com.alephreach.todolist.data.Database.Dao.GroupDao;
import com.alephreach.todolist.data.Database.TodoDatabase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class DataModule {

    @Provides
    TodoDatabase provideTodoDatabase(Context context) {
        return Room.databaseBuilder(context, TodoDatabase.class, "database-name").build();
    }

    @Provides
    GroupDao provideGroupDao(TodoDatabase todoDatabase) {
        return todoDatabase.mGroupDao();
    }

}





