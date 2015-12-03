package com.xeiam.xchange.service.polling.marketdata;

import java.io.IOException;
import java.util.Map;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.params.QueryParams;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to poll the latest market {@link Ticker}.</li>
 * </ul>
 */
public interface TickersService extends MarketDataService {

  /**
   * Get one or more tickers representing the current exchange rate
   *
   * @param params The parameters describing the filter. Note that {@link QueryParams} is an empty interface. The exact set of interfaces that are
   *        required or supported by this method is described by the type of object returned from {@link #createTickersParams()} and the javadoc
   *        of the method.
   * @return The tickers, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  Map<CurrencyPair,Ticker> getTickers(QueryParams params)
      throws ExchangeException, NotYetImplementedForExchangeException, IOException;

  /**
   * Create a {@link QueryParams} object specific to this service. The object created by this method may be used to discover supported and
   * required {@link #getTickers(QueryParams)} parameters and should be passed only to that method.
   */
  QueryParams createTickersParams();
}
