package com.ipiecoles;

import com.owlike.genson.Genson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Bitcoin {

    public BitcoinOutput getBitcoinOutput(BitcoinData bitcoinData) throws IOException{
        //Renvoi de l'url avec les types de currency demandés

        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=";

        for(Integer i=0;i < bitcoinData.getCurrencyList().size();i++){
            if(i==bitcoinData.getCurrencyList().size()-1){
                url += bitcoinData.getCurrencyList().get(i);
            } else {
                url += bitcoinData.getCurrencyList().get(i)+",";
            }
        }

        return getBitcoin(bitcoinData, this.getPageContents(url));

                //getEphemeride(date, this.getPageContents("https://raw.githubusercontent.com/theofidry/ephemeris/master/src/ephemeris.json"));
    }

    public BitcoinOutput getBitcoin(BitcoinData bitcoinData, String courtBC){

        Genson genson = new Genson();
        Map<String, Object> map = genson.deserialize(courtBC, Map.class);

        BitcoinOutput bitcoinOutput = new BitcoinOutput();
        for (String curency:bitcoinData.getCurrencyList()) {
            Double taux = Double.parseDouble(map.get(curency).toString());
            bitcoinOutput.setBitcoinAmount(bitcoinData.getBitcoinAmount());
            bitcoinOutput.getCurrencyEquivalent().put(curency,bitcoinData.getBitcoinAmount()*taux);
        }

        return bitcoinOutput;

    }

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();
    }

}
