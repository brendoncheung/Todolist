package com.alephreach.todolist.ui.ShowGroups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alephreach.todolist.R;
import com.alephreach.todolist.ui.di.Component.DaggerPresentationComponent;
import com.alephreach.todolist.ui.di.Component.PresentationComponent;
import com.alephreach.todolist.ui.di.Module.ContextModule;

import javax.inject.Inject;

public class ShowGroupFragment extends Fragment {

    private ShowGroupViewModel mShowGroupViewModel;
    private RecyclerView mRecyclerView;
    private ShowGroupAdaptor mShowGroupAdaptor;

    @Inject
    public ShowGroupViewModelFactory mShowGroupViewModelFactory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_group, container, false);
        configureDaggerInjector();

        mShowGroupViewModel = new ViewModelProvider(requireActivity(), mShowGroupViewModelFactory).get(ShowGroupViewModel.class);

        configureLiveData();
        configureView(root);
        configureViewRecyclerView();
        return root;
    }

    private void configureView(View view) {
        mRecyclerView = view.findViewById(R.id.group_recycler_view);
    }

    private void configureViewRecyclerView() {
        mShowGroupAdaptor = new ShowGroupAdaptor();
        mRecyclerView.setAdapter(mShowGroupAdaptor);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void configureDaggerInjector() {
        PresentationComponent component = DaggerPresentationComponent.builder()
                .contextModule(new ContextModule(requireContext()))
                .build();
        component.inject(this);
    }

    private void configureLiveData() {
        mShowGroupViewModel.loadAllGroup();
        mShowGroupViewModel.getAllGroups().observe(getViewLifecycleOwner(), groups -> {
            mShowGroupAdaptor.bindData(groups);
        });

    }
}
