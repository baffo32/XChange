package com.xeiam.xchange.service.polling.marketdata;

import java.io.IOException;

import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;

/**
 * @deprecated Implement individual interfaces in this package separately.
 */
@Deprecated
public interface PollingMarketDataService extends MarketDataService {

  /**
   * <p>
   * Get a ticker representing the current exchange rate
   * </p>
   * 
   * @param CurrencyPair currencyPair (e.g. BTC/USD)
   * @return The Ticker, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotAvailableFromExchangeException - Indication that the exchange does not support the requested function or data
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  Ticker getTicker(CurrencyPair currencyPair, Object... args)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException;

  /**
   * <p>
   * Get an order book representing the current offered exchange rates (market depth)
   * </p>
   * 
   * @param CurrencyPair currencyPair (e.g. BTC/USD)
   * @param args Optional arguments. Exchange-specific
   * @return The OrderBook, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotAvailableFromExchangeException - Indication that the exchange does not support the requested function or data
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  OrderBook getOrderBook(CurrencyPair currencyPair, Object... args)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException;

  /**
   * <p>
   * Get the trades recently performed by the exchange
   * </p>
   * 
   * @param CurrencyPair currencyPair (e.g. BTC/USD)
   * @param args Optional arguments. Exchange-specific
   * @return The Trades, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotAvailableFromExchangeException - Indication that the exchange does not support the requested function or data
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  Trades getTrades(CurrencyPair currencyPair, Object... args)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException;

}
