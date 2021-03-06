package com.alephreach.todolist.ui.di.Module;

import android.provider.ContactsContract;

import com.alephreach.todolist.data.Database.Dao.GroupDao;
import com.alephreach.todolist.data.Database.Dao.ItemDao;
import com.alephreach.todolist.data.Repositories.GroupRepositoryImpl;
import com.alephreach.todolist.data.Repositories.ItemRepositoryImpl;
import com.alephreach.todolist.domain.Repositories.GroupRepository;
import com.alephreach.todolist.domain.Repositories.ItemRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = {DataModule.class})
public class DomainModule {

    @Provides
    GroupRepository provideGroupRepository(GroupDao dao) {
        return new GroupRepositoryImpl(dao);
    }

    @Provides
    ItemRepository provideItemReposition(ItemDao dao) { return new ItemRepositoryImpl(dao); }

}
