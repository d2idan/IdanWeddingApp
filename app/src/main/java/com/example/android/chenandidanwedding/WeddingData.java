package com.example.android.chenandidanwedding;

/**
 * @author Idan Damri
 */

/**
 * This class represents a wedding data object contains all important data for the wedding.
 */
public class WeddingData {
    private String providerName;
    private String providerPhone;
    private String attraction;
    private String advancedPayment=NO_ADVANCED_PAYMENT_GIVEN;
    private static final String NO_ADVANCED_PAYMENT_GIVEN="0";
    private String balanceDue;

    public WeddingData(String providerName,String providerPhone,String attraction,
                       String balanceDue){
        this.providerName=providerName;
        this.providerPhone=providerPhone;
        this.attraction=attraction;
        this.balanceDue=balanceDue;

    }
    public WeddingData(String providerName,String providerPhone,String attraction
            ,String advancedPayment,String balanceDue){
        this.providerName=providerName;
        this.providerPhone=providerPhone;
        this.attraction=attraction;
        this.advancedPayment=advancedPayment;
        this.balanceDue=balanceDue;

    }
    public String getProviderName(){return providerName;}
    public String getProviderPhone(){return providerPhone;}
    public String getAttraction(){return attraction;}
    public String getAdvancedPayment(){return advancedPayment;}
    public String getBalanceDue(){return balanceDue;}

}
