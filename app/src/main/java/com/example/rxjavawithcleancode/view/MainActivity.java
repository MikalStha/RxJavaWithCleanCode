package com.example.rxjavawithcleancode.view;

import android.os.Bundle;

import com.example.rxjavawithcleancode.R;
import com.example.rxjavawithcleancode.adapter.UserAdapter;
import com.example.rxjavawithcleancode.databinding.ActivityMainBinding;
import com.example.rxjavawithcleancode.domain.model.User;
import com.example.rxjavawithcleancode.vm.UserInfoVm;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserInfoVm userViewModel;
    UserAdapter adapter;
    ActivityMainBinding binding;
   // RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
         binding.title.setText("Hello Sampple App");


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        userViewModel=new UserInfoVm();
        userViewModel.fetchUserInfo();
        setObserver();



      //  userViewModel = ViewModelProviders.of(this).get(UserInfoVm.class);
        /*adapter.setOnItemClickListener(user -> {
            Toast.makeText(getApplicationContext(),"You clicked : ", Toast.LENGTH_SHORT).show();
        });
*/

    }

    private void setObserver() {

        userViewModel.userList.observe(this,userListObs);
    }

    private Observer<List<User>> userListObs = userInfoApi -> {


        adapter = new UserAdapter(userInfoApi);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        System.out.println("data fetched....");

    };
}