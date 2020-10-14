package com.example.rxjavawithcleancode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.rxjavawithcleancode.basevm.BaseVm;

public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseVm> extends AppCompatActivity {
    protected T viewModel;
    protected B binding;

    /**
     * ViewModel must be initialized before bindView() is called
     *
     * @param layout layout for the activity
     */
    public final void bindView(int layout) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.setContentView(this, layout);
    }

    public abstract void bindViewModel();

    @Override
    protected void onStart() {
        super.onStart();
        bindViewModel();
    }

}
