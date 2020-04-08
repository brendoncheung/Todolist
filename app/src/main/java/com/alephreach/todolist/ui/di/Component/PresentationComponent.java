package com.alephreach.todolist.ui.di.Component;

import com.alephreach.todolist.ui.di.Module.DataModule;
import com.alephreach.todolist.ui.di.Module.DomainModule;
import com.alephreach.todolist.ui.home.ShowGroupFragment;

import dagger.Component;

@Component(modules = {DomainModule.class, DataModule.class})
public interface PresentationComponent {
    void inject(ShowGroupFragment fragment);
}
