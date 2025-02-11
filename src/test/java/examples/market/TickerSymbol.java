package examples.market;

import com.binance.connector.client.impl.SpotClientImpl;
import examples.PrivateConfig;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TickerSymbol {
    private TickerSymbol() {
    }

    private static final Logger logger = LoggerFactory.getLogger(TickerSymbol.class);
    public static void main(String[] args) {
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();

        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);

        parameters.put("symbol", "BNBUSDT");
        String result = client.createMarket().tickerSymbol(parameters);
        logger.info(result);
        parameters.clear();

        ArrayList<String> symbols = new ArrayList<>();
        symbols.add("BTCUSDT");
        symbols.add("BNBUSDT");
        parameters.put("symbols", symbols);
        result = client.createMarket().tickerSymbol(parameters);
        logger.info(result);
    }
}
