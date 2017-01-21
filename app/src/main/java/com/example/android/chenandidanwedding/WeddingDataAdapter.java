package com.example.android.chenandidanwedding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WeddingDataAdapter extends ArrayAdapter {

    private Context context;

    public WeddingDataAdapter(Activity context, ArrayList<WeddingData> data){
        super(context,0,data);
        this.context=context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        /*
        *Check if the existing view is being reused, otherwise inflate the view
         */
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }
        /**
         *Get the {@link WeddingData} object located at this position in the list
         */
        final WeddingData weddingData = (WeddingData) getItem(position);

        /**
         * point to an item view in the list
         * and set the text to the correct value
         */

        TextView providerNameView=(TextView)listItemView.findViewById(R.id.provider_name);
        providerNameView.setText(weddingData.getProviderName());

        TextView providerPhone = (TextView)listItemView.findViewById(R.id.provider_phone);
        providerPhone.setText(weddingData.getProviderPhone());

        TextView attraction = (TextView)listItemView.findViewById(R.id.attraction);
        attraction.setText(weddingData.getAttraction());

        TextView advancedPaymentText=(TextView)listItemView.findViewById(R.id.advanced_payment_text);
        TextView advancedPayment = (TextView)listItemView.findViewById(R.id.advanced_payment);

        /**
         * getting country currency symbol
         */
            String countryCurrency=getContext().getResources().getString(R.string.ILS);

        /**
         * if advanced payment had been given, set the correct value and make the {@link TextView} visible
         * else make the {@link TextView invisible}
         */
        if(hasGivenAdvancedPayment(weddingData.getAdvancedPayment())){
            String text=countryCurrency + weddingData.getAdvancedPayment();
            advancedPayment.setText(text);
            advancedPayment.setVisibility(View.VISIBLE);
            advancedPaymentText.setVisibility(View.VISIBLE);
        }else {
            advancedPayment.setVisibility(View.GONE);
            advancedPaymentText.setVisibility(View.GONE);
        }

        TextView balanceDue = (TextView)listItemView.findViewById(R.id.balance_due);
        balanceDue.setText(countryCurrency + weddingData.getBalanceDue());

        /**
         * point to the linear layout contains the private text views.
         * if position is even set the color of the linear layout to bright blue
         * else set the color of the linear layout to dark blue
         */
        LinearLayout linearLayout=(LinearLayout)listItemView.findViewById(R.id.colored_linear_layout);
        if(position%2==0)
            linearLayout.setBackgroundResource(R.color.bright_blue);
        else
            linearLayout.setBackgroundResource(R.color.dark_blue);

        /**
         * point to the {@link ImageView} in the listItemView
         */
        ImageView phoneImageView = (ImageView)linearLayout.findViewById(R.id.phone_image);

        /**
         * opens a call dialog to the provider phone number if pressed on the {@link ImageView}
         */

        phoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=weddingData.getProviderPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phone,null));
                context.startActivity(intent);
            }

        });


        return listItemView;

    }

    /**
     *check whether or not advanced payment had been given.
     * @param advancedPayment indicator that tells us if an advanced payment had been given
     * @return true if advancedPayment is not 0, false otherwise.
     */
    private static boolean hasGivenAdvancedPayment(String advancedPayment){
        return ( !advancedPayment.equals("0") );
    }

}
