package com.alephreach.todolist.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShowGroupViewModel extends ViewModel {

    // TODO: add the group repository

    private MutableLiveData<String> mText;

    public ShowGroupViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}