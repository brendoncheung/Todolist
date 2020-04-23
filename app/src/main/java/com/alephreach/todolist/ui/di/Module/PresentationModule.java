package com.alephreach.todolist.ui.di.Module;

import com.alephreach.todolist.domain.Repositories.GroupRepository;
import com.alephreach.todolist.ui.ShowGroups.ShowGroupViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    ShowGroupViewModelFactory provideShowGroupViewModelFactory(GroupRepository repository) {
        return new ShowGroupViewModelFactory(repository);
    }

}
