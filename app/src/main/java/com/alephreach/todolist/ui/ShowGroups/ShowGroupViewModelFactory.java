package com.alephreach.todolist.ui.ShowGroups;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alephreach.todolist.domain.Repositories.GroupRepository;

import javax.inject.Inject;

public class ShowGroupViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    public GroupRepository mGroupRepository;

    public ShowGroupViewModelFactory(GroupRepository groupRepository) {
        mGroupRepository = groupRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ShowGroupViewModel(mGroupRepository);
    }
}
