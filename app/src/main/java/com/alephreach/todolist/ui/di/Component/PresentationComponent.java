package com.alephreach.todolist.ui.di.Component;

import com.alephreach.todolist.MainActivity;
import com.alephreach.todolist.ui.di.Module.DataModule;
import com.alephreach.todolist.ui.di.Module.DomainModule;
import com.alephreach.todolist.ui.di.Module.PresentationModule;
import com.alephreach.todolist.ui.ShowGroups.ShowGroupFragment;

import dagger.Component;

@Component(modules = {DomainModule.class, DataModule.class, PresentationModule.class})
public interface PresentationComponent {
    void inject(ShowGroupFragment fragment);
    void inject(MainActivity mainActivity);
}
