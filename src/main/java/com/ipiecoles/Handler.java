package com.ipiecoles;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.io.IOException;


//                                             Input,       Output
public class Handler implements RequestHandler<BitcoinData, BitcoinOutput> {

    //USER : geeks
    //MDP : ipi-mdd-324

    @Override
    public BitcoinOutput handleRequest(BitcoinData bitcoinData, Context context) {

        Bitcoin bitcoin = new Bitcoin();
        try {
            //Appel ma méthode métier
            BitcoinOutput bitcoinOutput = bitcoin.getBitcoinOutput(bitcoinData);
            //Renvoie de l'objet à API Gateway
            System.out.println(bitcoinOutput.toString());
            return bitcoinOutput;
        } catch (IOException e) {
            //Gère correctement l'exception
            e.printStackTrace();
        }

        return null;
    }
}
