package com.ipiecoles;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BitcoinTest {

    @Test
    public void testGetBitcoin() throws IOException {
        //Given

        //
        Bitcoin bitcoin = new Bitcoin();
        Double amount = 4.0;
        String currencyList = "EUR,USD";
        String courtBC = "{\"EUR\":10.00,\"USD\":5.00}";

        BitcoinData bitcoinData = new BitcoinData(amount, currencyList);

        //When

        //Resultat de la request
        BitcoinOutput data = bitcoin.getBitcoin(bitcoinData, courtBC);


        //Then
        Assertions.assertThat(data.getBitcoinAmount()).isEqualTo(4.0);
        Assertions.assertThat(data.getCurrenciesEquivalent().get("EUR")).isEqualTo(40.0);
        Assertions.assertThat(data.getCurrenciesEquivalent().get("USD")).isEqualTo(20.0);

    }

    @Test
    public void testGetBitcoinOutput() throws IOException {
        //Given
        Bitcoin bitcoin = new Bitcoin();
        Double amount = 4.0;
        String currencyList = "EUR,USD,AOA,ZZZ";

        BitcoinData bitcoinData = new BitcoinData(amount, currencyList);

        //When

        //Resultat de la request
        BitcoinOutput data = bitcoin.getBitcoinOutput(bitcoinData);


        //Then

        Assertions.assertThat(data.getBitcoinAmount()).isEqualTo(4.0);
        Assertions.assertThat(data.getCurrenciesEquivalent()).containsKeys("EUR", "USD", "AOA");
        Assertions.assertThat(data.getCurrenciesEquivalent().get("EUR")).isGreaterThan(0.0);
        Assertions.assertThat(data.getCurrenciesEquivalent().get("USD")).isGreaterThan(0.0);
        Assertions.assertThat(data.getCurrenciesEquivalent().get("AOA")).isGreaterThan(0.0);


    }

}
