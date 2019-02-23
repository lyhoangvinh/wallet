package electronicwallet.lyhoangvinh.com.ui.main.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import electronicwallet.lyhoangvinh.com.R;
import electronicwallet.lyhoangvinh.com.base.fragment.BaseSwipeRecyclerViewFragment;
import electronicwallet.lyhoangvinh.com.utils.NavigatorHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ContactsFragment extends BaseSwipeRecyclerViewFragment<ContactAdapter, ContactsView, ContactsPresenter> implements ContactsView {

    @BindView(R.id.edtSearch)
    EditText edtSearch;

    @Inject
    NavigatorHelper navigatorHelper;

    @Override
    protected int getLayout() {
        return R.layout.fragment_contacts;
    }

    @Override
    public boolean isEvenbus() {
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initialize(View view, Context ctx) {
        super.initialize(view, ctx);
        RxTextView.textChanges(edtSearch).debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(charSequence -> {
                    if (TextUtils.isEmpty(charSequence.toString())) {
                        refreshWithUi(300);
                    } else {
                        getPresenter().search(charSequence.toString());
                    }
                });
    }

    @OnClick(R.id.imvBack)
    public void back() {
        onBackPressed();
    }

    @NonNull
    @Override
    protected ContactAdapter createAdapter() {
        return getPresenter().getAdapter();
    }

    @Override
    public boolean onBackPressed() {
        navigatorHelper.navigatePhoneNumberFragment();
        return true;
    }
}
