package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        listView = (ExpandableListView)findViewById(R.id.choosePay);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
    }

    public void activityIDCheck(View view) {
        Intent Intent = new Intent(this, IdCekActivity.class);
        startActivity(Intent);
    }

    public void activityProcess(View view) {
        Intent Intent = new Intent(this, ProcessActivity.class);
        startActivity(Intent);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("ATM Transfer");
        listDataHeader.add("e-Banking");

        List<String> atm = new ArrayList<>();
        atm.add("OCBC NISP");
        atm.add("Bank Mandiri");

        List<String> ebank = new ArrayList<>();
        ebank.add("NISP Go Mobile");
        ebank.add("Clickpay Mandiri");

        listHashMap.put(listDataHeader.get(0),atm);
        listHashMap.put(listDataHeader.get(1),ebank);
    }
}
