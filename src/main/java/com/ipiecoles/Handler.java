package com.ipiecoles;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

//                                             Input,  Output
public class Handler implements RequestHandler<BitcoinData, GatewayResponse> {

    //USER : geeks
    //MDP : ipi-mdd-324

    @Override
    public GatewayResponse handleRequest(BitcoinData bitcoinData, Context context) {

        System.out.println(bitcoinData.toString());

        Bitcoin bitcoin = new Bitcoin();
        try {
            //Appel ma méthode métier
            BitcoinOutput bitcoinOutput = bitcoin.getBitcoinOutput(bitcoinData);
            //Serialize en JSON l'objet de retour
            Genson genson = new GensonBuilder().useRuntimeType(true).create();
            String body = genson.serialize(bitcoinOutput);
            //Gère les headers
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");
            int statusCode = 200;
            //Renvoie de l'objet à API Gateway
            return new GatewayResponse(body, headers, statusCode);
        } catch (IOException e) {
            //Gère correctement l'exception
            e.printStackTrace();
        }

        return null;
    }
}
