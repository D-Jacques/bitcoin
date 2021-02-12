package com.ipiecoles;

import java.util.List;
import java.util.Objects;

public class BitcoinData {
    private Double bitcoinAmount;
    //à sérializer et déserializer
    private String currencyList;

    public BitcoinData() {
    }

    public BitcoinData(Double bitcoinAmount, String currencyList) {
        this.bitcoinAmount = bitcoinAmount;
        this.currencyList = currencyList;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

    public String getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(String currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "BitcoinData{" +
                "bitcoinAmount=" + bitcoinAmount +
                ", currencyList='" + currencyList + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitcoinData that = (BitcoinData) o;
        return Objects.equals(bitcoinAmount, that.bitcoinAmount) && Objects.equals(currencyList, that.currencyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bitcoinAmount, currencyList);
    }
}
