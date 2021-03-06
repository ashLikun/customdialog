package com.ashlikun.customdialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.ashlikun.numberprogressbar.NumberProgressBar;

/**
 * 作者　　: 李坤
 * 创建时间: 2017/7/7 17:35
 * 邮箱　　：496546144@qq.com
 * <p>
 * 方法功能：加载精度对话框
 */

public class DialogProgress extends BaseDialog {
    private Context context;
    private NumberProgressBar progressBar;
    private TextView titleView;

    public DialogProgress(Context context) {
        this(context, R.style.Dialog_Progress);
    }

    public DialogProgress(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.base_dialog_progress;
    }

    @Override
    protected void initView() {
        setCancelable(false);
        progressBar = f(R.id.progressBar);
        titleView = f(R.id.title);
    }

    public DialogProgress setProgress(int progress) {
        progressBar.setProgress((int) (progress * (Math.round(getMaxValus() / 100.0))));
        return this;
    }

    public DialogProgress setTitleText(String title) {
        if (TextUtils.isEmpty(title)) {
            titleView.setVisibility(View.GONE);
        } else {
            titleView.setText(title);
        }
        return this;
    }

    /**
     * 获取最大尺度
     */
    public int getMaxValus() {
        return progressBar.getMax();
    }

    /**
     * 设置最大尺度
     */
    public DialogProgress getMaxValus(int max) {
        progressBar.setMax(max);
        return this;
    }

    /**
     * 获取当前尺度
     */
    public int getProgress() {
        return progressBar.getProgress();
    }
}
