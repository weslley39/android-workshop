package io.redspark.gestta;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.redspark.gestta.adapters.ViewPagerAdapter;
import io.redspark.gestta.fragments.DashboardFragment;
import io.redspark.gestta.fragments.RequestFragment;
import io.redspark.gestta.fragments.TaskFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_view_pager) protected ViewPager mViewPager;
    @BindView(R.id.activity_main_tab_layout) protected TabLayout mTabLayout;
    @BindView(R.id.activity_main_toolbar) protected Toolbar mToolbar;

    private ViewPagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        setupPageViewAdapter();
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupPageViewAdapter() {
        pageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(DashboardFragment.newInstance(), getString(R.string.activity_main_tab_dashboard));
        pageAdapter.addFragment(TaskFragment.newInstance(), getString(R.string.activity_main_tab_task));
        pageAdapter.addFragment(RequestFragment.newInstance(), getString(R.string.activity_main_tab_request));
        mViewPager.setAdapter(pageAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_main_logout:
                Intent goToLogin = new Intent(this, LoginActivity.class);
                goToLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(goToLogin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
