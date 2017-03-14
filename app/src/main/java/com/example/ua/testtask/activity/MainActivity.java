package com.example.ua.testtask.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Toast;

import com.example.ua.testtask.LecturioApplication;
import com.example.ua.testtask.R;
import com.example.ua.testtask.adapter.QuestionRecyclerViewAdapter;
import com.example.ua.testtask.domain.Example;
import com.example.ua.testtask.domain.Question;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sv_search)
    SearchView searchView;
    @BindView(R.id.rv_questions)
    RecyclerView rvQuestions;

    private List<Question> questions;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        searchView.setQueryHint(getString(R.string.query_hint));
        searchView.setIconifiedByDefault(false);

        questions = new ArrayList<>();

        rvQuestions.setLayoutManager(new LinearLayoutManager(this));
        rvQuestions.setAdapter(new QuestionRecyclerViewAdapter(this, questions));
    }

    @OnClick(R.id.btn_search)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                showProgressDialog();
                fetchData();
        }
    }

    /**
     *
     */
    private void fetchData() {
        LecturioApplication.getApi().getData(searchView.getQuery().toString()).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                questions.clear();
                questions.addAll(response.body().getData().getQuestions());

                rvQuestions.getAdapter().notifyDataSetChanged();

                progressDialog.dismiss();
                searchView.clearFocus();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, R.string.error_message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *
     */
    private void showProgressDialog() {
        progressDialog = ProgressDialog.show(this, getString(R.string.dialog_message), "");
    }
}
