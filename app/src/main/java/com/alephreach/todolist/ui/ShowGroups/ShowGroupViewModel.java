package com.alephreach.todolist.ui.ShowGroups;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alephreach.todolist.domain.Entities.Group;
import com.alephreach.todolist.domain.Repositories.GroupRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ShowGroupViewModel extends ViewModel {

    // TODO: add the group repository

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private final GroupRepository mGroupRepository;

    private MutableLiveData<List<Group>> mGroups = new MutableLiveData<>();

    public ShowGroupViewModel(GroupRepository groupRepository) {
        mGroupRepository = groupRepository;
    }

    public LiveData<List<Group>> getAllGroups() {
        return mGroups;
    }

    public void loadAllGroup() {
        mCompositeDisposable.add(
                mGroupRepository.getAllGroups()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(s -> System.out.println("asdasd"))
                .subscribe(groups -> mGroups.setValue(groups)));

        mCompositeDisposable.add(
                mGroupRepository.getItemsByGroup(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(items -> {



                    Log.d("Fragment", String.valueOf(items.mItems.size()));
                    },
                        e -> {
                    Log.d("Fragment", e.toString());
                    }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.dispose();
    }
}