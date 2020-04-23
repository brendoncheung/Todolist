package com.alephreach.todolist;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.alephreach.todolist.domain.Entities.Item;
import com.alephreach.todolist.domain.Repositories.ItemRepository;
import com.alephreach.todolist.ui.di.Component.DaggerPresentationComponent;
import com.alephreach.todolist.ui.di.Component.PresentationComponent;
import com.alephreach.todolist.ui.di.Module.ContextModule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // read this: https://developer.android.com/guide/navigation/navigation-ui

    private AppBarConfiguration mAppBarConfiguration;
    private FloatingActionButton mFloatingActionButton;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private NavController mNavController;
    private Toolbar mToolbar;

    @Inject
    ItemRepository mItemRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureView();
        setSupportActionBar(mToolbar);
        configureFAB();
        configureNavigation();

        configureDaggerInjector();
    }

    private void configureView() {
        mToolbar = findViewById(R.id.toolbar);
        mFloatingActionButton = findViewById(R.id.fab);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    private void configureNavigation() {
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(mDrawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(mNavigationView, mNavController);
    }

    private void configureFAB() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                mItemRepository.insertItem(new Item("Orange", 2))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show(),
                                e -> e.printStackTrace());


            }
        });
    }

    private void configureDaggerInjector() {
        PresentationComponent component = DaggerPresentationComponent.builder().contextModule(new ContextModule(this)).build();
        component.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
