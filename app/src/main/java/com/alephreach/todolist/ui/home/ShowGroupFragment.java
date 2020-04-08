package com.alephreach.todolist.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alephreach.todolist.R;
import com.alephreach.todolist.domain.Entities.Group;
import com.alephreach.todolist.domain.Repositories.GroupRepository;
import com.alephreach.todolist.ui.di.Component.DaggerPresentationComponent;
import com.alephreach.todolist.ui.di.Component.PresentationComponent;
import com.alephreach.todolist.ui.di.Module.ContextModule;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ShowGroupFragment extends Fragment {
    public static String TAG = ShowGroupFragment.class.getSimpleName();

    private ShowGroupViewModel mShowGroupViewModel;

    @Inject
    GroupRepository mGroupRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        configureDaggerInjector();

        mGroupRepository.addGroup(new Group("Hello"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(requireContext(), "done!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


        return root;
    }


    private void configureDaggerInjector() {
        PresentationComponent component = DaggerPresentationComponent.builder()
                .contextModule(new ContextModule(requireContext()))
                .build();
        component.inject(this);
    }
}
