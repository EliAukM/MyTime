package com.whx.mytime;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountDownAdapter.OnItemClickListener {

    private RecyclerView mRecycleListView;
    private List<TimeDownBean> mTimeDownBeanList;
    private CountDownAdapter mCountDownAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 1; i < 80; i++) {
            TimeDownBean timeDownBean = new TimeDownBean(55 * 1000 * i, "测试内容" + i);
            mTimeDownBeanList.add(timeDownBean);
        }
        for (int i = 1; i < 10; i++) {
            TimeDownBean timeDownBean = new TimeDownBean(0, "没有倒计时测试内容" + i);
            mTimeDownBeanList.add(timeDownBean);
        }
    }

    private void initView() {
        mRecycleListView = (RecyclerView) findViewById(R.id.recycle_list_view);
        mTimeDownBeanList = new ArrayList<>();
        mCountDownAdapter = new CountDownAdapter(this, mTimeDownBeanList);
        mCountDownAdapter.setItemClickListener(this);
        mRecycleListView.setHasFixedSize(true);
        mRecycleListView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        ((SimpleItemAnimator) mRecycleListView.getItemAnimator()).setSupportsChangeAnimations(false);
        mRecycleListView.setAdapter(mCountDownAdapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
    }
}
