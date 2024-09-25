package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.model.Contact;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<Contact> contacts;
    private LayoutInflater inflater;

    public ContactAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contact_item, parent, false);
        }

        ImageView contactImage = convertView.findViewById(R.id.contactImage);
        TextView contactName = convertView.findViewById(R.id.contactName);
        TextView contactPh = convertView.findViewById(R.id.contactph);

        Contact contact = (Contact) getItem(position);

        contactName.setText(contact.getName());
        contactPh.setText(contact.getPh());
        contactImage.setImageResource(contact.getImageResId());

        return convertView;
    }
}
