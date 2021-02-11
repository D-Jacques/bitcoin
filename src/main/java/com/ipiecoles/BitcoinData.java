package com.ipiecoles;

import java.util.List;
import java.util.Objects;

public class BitcoinData {
    private Double bitcoinAmount;
    //à sérializer et déserializer
    private List<String> currencyList;

    public BitcoinData() {
    }

    public BitcoinData(Double bitcoinAmount, List<String> currencyList) {
        this.bitcoinAmount = bitcoinAmount;
        this.currencyList = currencyList;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<String> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "BitcoinData{" +
                "bitcoinAmount=" + bitcoinAmount +
                ", currencyList=" + currencyList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitcoinData that = (BitcoinData) o;
        return bitcoinAmount.equals(that.bitcoinAmount) &&
                currencyList.equals(that.currencyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bitcoinAmount, currencyList);
    }

}
