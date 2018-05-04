package com.serhatturkman.baseactivityandfragmentwithbutterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @BindView(R.id.parent_constraint_layout)
    ConstraintLayout parentConstraintLayout;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.content_template, parentConstraintLayout, true);
        TemplateFragment templateFragment = new TemplateFragment(view);
        linearLayout = templateFragment.getContentLinearLayout();
        templateFragment.title.setText(getTitleText());
    }

    protected abstract String getTitleText();

    protected abstract void fillContent();

    class TemplateFragment{
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.content_linear_layout)
        LinearLayout contentLinearLayout;

        TemplateFragment(View view){
            ButterKnife.bind(this, view);
        }

        public LinearLayout getContentLinearLayout(){
            return contentLinearLayout;
        }
    }
}
