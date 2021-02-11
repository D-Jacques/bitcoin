package com.ipiecoles;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class BitcoinTest {

    @Test
    public void testGetBitcoin(){
        //Given

        //
        Bitcoin bitcoin = new Bitcoin();
        Double amount = 4.0;
        List<String> currencyList = new ArrayList<>();
        currencyList.add("EUR");
        currencyList.add("USD");
        String courtBC = "{\"EUR\":10.00,\"USD\":5.00}";

        BitcoinData bitcoinData = new BitcoinData(amount, currencyList);

        //When

        //Resultat de la request
        BitcoinOutput data = bitcoin.getBitcoin(bitcoinData);

        //Then


//        {
//            "bitcoinAmount": 3,
//                "currencyList": "EUR,USD"
//        }


//        {
//            "bitcoinAmount":3.0,
//                "currenciesEquivalent":{
//                    "EUR":8962.74,
//                    "USD":10225.14
//        }
//        }

        Assertions.assertThat(data.getBitcoinAmount()).isEqualTo(4.0);
        Assertions.assertThat(data.getCurrencyEquivalent().get("EUR")).isEqualTo(40.0);
        Assertions.assertThat(data.getCurrencyEquivalent().get("USD")).isEqualTo(20.0);



    }

}
