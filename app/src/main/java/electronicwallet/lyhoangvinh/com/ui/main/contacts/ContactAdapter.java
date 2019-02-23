package electronicwallet.lyhoangvinh.com.ui.main.contacts;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import electronicwallet.lyhoangvinh.com.R;
import electronicwallet.lyhoangvinh.com.base.adapter.BaseAdapter;
import electronicwallet.lyhoangvinh.com.base.adapter.BaseViewHolder;
import electronicwallet.lyhoangvinh.com.local.model.MyContact;

public class ContactAdapter extends BaseAdapter<MyContact, ContactAdapter.ContactViewHolder> {

    public ContactAdapter(@NonNull List<MyContact> data) {
        super(data);
    }

    @Override
    public int getItemLayoutResource() {
        return R.layout.item_contact;
    }

    @Override
    public ContactViewHolder createViewHolder(View v) {
        return new ContactViewHolder(v);
    }

    @Override
    protected void onBindViewHolder(ContactViewHolder holder, @NonNull MyContact dto, int position) {
        holder.tvName.setText(dto.getName());
        holder.tvPhoneNumber.setText(dto.getNumber());
    }

    class ContactViewHolder extends BaseViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvPhoneNumber)
        TextView tvPhoneNumber;

        public ContactViewHolder(View itemView) {
            super(itemView);
        }
    }
}
