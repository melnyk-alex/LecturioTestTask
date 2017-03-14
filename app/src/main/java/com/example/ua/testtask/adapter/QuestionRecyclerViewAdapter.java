package com.example.ua.testtask.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ua.testtask.R;
import com.example.ua.testtask.activity.AnswerDetailActivity;
import com.example.ua.testtask.domain.Question;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<QuestionRecyclerViewAdapter.QuestionViewHolder> {

    private List<Question> questionList;
    private Context context;

    public QuestionRecyclerViewAdapter(Context context, List<Question> questionsList) {
        this.questionList = questionsList;
        this.context = context;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
        return new QuestionViewHolder(LayoutInflater.from(container.getContext())
                .inflate(R.layout.details_question, container, false));
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        final int index = position;

        holder.tv_question.setText(questionList.get(position).getTitle());
        holder.question_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAnswerDetailActivity(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    /**
     *
     * @param position
     */
    private void toAnswerDetailActivity(int position){
        Intent intent = new Intent(context, AnswerDetailActivity.class);
        intent.putExtra(context.getString(R.string.IK_QUERSTION), questionList.get(position));
        context.startActivity(intent);
    }

    /**
     *
     */
    class QuestionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_question)
        TextView tv_question;
        @BindView(R.id.question_container)
        LinearLayout question_container;

        public QuestionViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
