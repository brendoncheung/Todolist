package com.alephreach.todolist.ui.di.Module;

import android.provider.ContactsContract;

import com.alephreach.todolist.data.Database.Dao.GroupDao;
import com.alephreach.todolist.data.Repositories.GroupRepositoryImpl;
import com.alephreach.todolist.domain.Repositories.GroupRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DataModule.class})
public class DomainModule {

    @Provides
    GroupRepository provideGroupRepository(GroupDao dao) {
        return new GroupRepositoryImpl(dao);
    }
}
