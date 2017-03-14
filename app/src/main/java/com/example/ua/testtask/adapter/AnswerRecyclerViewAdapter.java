package com.example.ua.testtask.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ua.testtask.R;
import com.example.ua.testtask.domain.Answer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class AnswerRecyclerViewAdapter extends RecyclerView.Adapter<AnswerRecyclerViewAdapter.AnswerViewHolder> {

    private List<Answer> answerList;

    public AnswerRecyclerViewAdapter(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
        return new AnswerViewHolder(LayoutInflater.from(container.getContext())
                .inflate(R.layout.details_answers, container, false));
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        holder.tv_answer.setText(answerList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return answerList.size();
    }

    /**
     *
     */
    public class AnswerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_answer)
        TextView tv_answer;

        public AnswerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
