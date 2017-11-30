package com.onvest.irfanagtya.plnpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.onvest.irfanagtya.plnpay.model.request.InquiryPaymentRequest;
import com.onvest.irfanagtya.plnpay.model.response.Idpel;
import com.onvest.irfanagtya.plnpay.model.response.IdpelResponse;
import com.onvest.irfanagtya.plnpay.model.response.LoginResponse;
import com.onvest.irfanagtya.plnpay.network.RestService;

import java.math.BigInteger;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    private static final String TAG = PayActivity.class.getSimpleName();

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private TextView dataPayIdpel, dataPayTipe, dataPayName, dataPayAlamat, dataPayJumlah, dataPayTarifDaya;
    private Button nextButton;
    private long tagihan;
    private String channel, merchant;
    private Idpel idCek;
    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Intent intent = getIntent();
        idCek = intent.getParcelableExtra("IDPEL");
        tagihan = intent.getLongExtra("TAGIHAN", 0);

        listView = findViewById(R.id.choosePay);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        listView.setAdapter(listAdapter);

        nextButton = findViewById(R.id.nextButton);
        dataPayIdpel = findViewById(R.id.dataPayIDPel);
        dataPayTipe = findViewById(R.id.dataPayTipe);
        dataPayTarifDaya = findViewById(R.id.dataPayTarifDaya);
        dataPayName = findViewById(R.id.dataPayName);
        dataPayAlamat = findViewById(R.id.dataPayAlamat);
        dataPayJumlah = findViewById(R.id.dataPayJumlah);

        //setting the values to the textviews
        dataPayIdpel.setText(String.valueOf(idCek.getIdpel()));
        dataPayTipe.setText(idCek.getTipe());
        dataPayTarifDaya.setText(idCek.getTarif() + " / " + idCek.getDaya());
        dataPayName.setText(idCek.getNamaLengkap());
        dataPayAlamat.setText(idCek.getAlamat());
        if(idCek.getTipe().equals("Prabayar")) {
            dataPayJumlah.setText("Rp " + String.valueOf(tagihan));
        }else{
            dataPayJumlah.setText("Rp " + String.valueOf(idCek.getTagihan()));
        }

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                channel = listDataHeader.get(groupPosition);
                merchant = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Log.d("Channel", channel);
                Log.d("Merchant", merchant);
                return false;
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inquiryPayment();
            }
        });
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
        listDataChild = new HashMap<>();

        listDataHeader.add("ATM Transfer");
        listDataHeader.add("e-Banking");

        List<String> atm = new ArrayList<>();
        atm.add("OCBC NISP");
        atm.add("Bank Mandiri");

        List<String> ebank = new ArrayList<>();
        ebank.add("NISP Go Mobile");
        ebank.add("Clickpay Mandiri");

        listDataChild.put(listDataHeader.get(0),atm);
        listDataChild.put(listDataHeader.get(1),ebank);
    }

    private void inquiryPayment() {
        Date now = Calendar.getInstance().getTime();
//        if(idCek.getTipe().equals("Prabayar")) {
//            long payment = tagihan;
//        }else{
//            long payment = idCek.getTagihan();
//        }

        final String idpel = String.valueOf(idCek.getIdpel());
//        final String jumlah = String.valueOf(payment);
//        final String channel = channel;
//        final String merchant = merchant;
        final String jam = String.valueOf(now);

//        InquiryPaymentRequest request = new InquiryPaymentRequest(BigInteger.valueOf(idpel), jumlah, channel, merchant, Time.valueOf(jam));
//        restService.signup(new RestService.PlnCallback<LoginResponse>() {
//            @Override
//            public void onSuccess(LoginResponse response) {
//                startActivity(new Intent(PayActivity.this, ProcessActivity.class));
//            }
//
//            @Override
//            public void onError(int errorCode) {
//
//            }
//        }, request);
    }
}
