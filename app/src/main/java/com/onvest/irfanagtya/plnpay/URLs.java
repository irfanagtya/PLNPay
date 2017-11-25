package com.onvest.irfanagtya.plnpay;

/**
 * Created by raika on 11/21/2017.
 */

public class URLs {

    private static final String ROOT_URL = "http://192.168.100.5/plnpay/api.php?apicall=";

    public static final String URL_REGISTER = ROOT_URL + "signup";
    public static final String URL_LOGIN= ROOT_URL + "login";
    public static final String URL_ADD_IDPEL= ROOT_URL + "addidpel";
    public static final String URL_GET_IDPEL= ROOT_URL + "getidpel";
    public static final String URL_REQUEST_TRANSAKSI= ROOT_URL + "requesttransaksi";

}