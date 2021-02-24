package com.ipiecoles;

import java.util.HashMap;
import java.util.Map;

public class BitcoinOutput {
    private Map<String, Double> currenciesEquivalent = new HashMap<>();
    private Double bitcoinAmount;

    public BitcoinOutput() {
    }

    public BitcoinOutput(Map<String, Double> currenciesEquivalent, Double bitcoinAmount) {
        this.currenciesEquivalent = currenciesEquivalent;
        this.bitcoinAmount = bitcoinAmount;
    }

    public Map<String, Double> getCurrenciesEquivalent() {
        return currenciesEquivalent;
    }

    public void setCurrenciesEquivalent(Map<String, Double> currenciesEquivalent) {
        this.currenciesEquivalent = currenciesEquivalent;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

    @Override
    public String toString() {
        String mapCurrencies = "";
        for(Map.Entry<String, Double> iterator: currenciesEquivalent.entrySet()){
            mapCurrencies += "\""+iterator.getKey() + "\":" + iterator.getValue()+",";
        }
        return "{" + "\"bitcoinAmount\":"+bitcoinAmount+","
                +"\"currenciesEquivalent\":{"+mapCurrencies+
                    "}"+
                '}';
    }
}
