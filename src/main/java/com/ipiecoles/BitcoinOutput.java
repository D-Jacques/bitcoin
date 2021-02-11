package com.ipiecoles;

import java.util.HashMap;
import java.util.Map;

public class BitcoinOutput {
    private Map<String, Double> currencyEquivalent = new HashMap<>();
    private Double bitcoinAmount;

    public BitcoinOutput() {
    }

    public BitcoinOutput(Map<String, Double> currencyEquivalent, Double bitcoinAmount) {
        this.currencyEquivalent = currencyEquivalent;
        this.bitcoinAmount = bitcoinAmount;
    }

    public Map<String, Double> getCurrencyEquivalent() {
        return currencyEquivalent;
    }

    public void setCurrencyEquivalent(Map<String, Double> currencyEquivalent) {
        this.currencyEquivalent = currencyEquivalent;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }
}
