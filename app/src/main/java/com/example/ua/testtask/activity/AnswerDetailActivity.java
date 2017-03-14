package com.example.ua.testtask.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ua.testtask.R;
import com.example.ua.testtask.adapter.AnswerRecyclerViewAdapter;
import com.example.ua.testtask.domain.Question;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class AnswerDetailActivity extends AppCompatActivity {

    @BindView(R.id.rv_answers)
    RecyclerView rvAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_detail);
        ButterKnife.bind(this);

        Question question = getIntent().getParcelableExtra(getString(R.string.IK_QUERSTION));

        rvAnswers.setLayoutManager(new LinearLayoutManager(this));
        rvAnswers.setAdapter(new AnswerRecyclerViewAdapter(question.getAnswers()));
    }
}
