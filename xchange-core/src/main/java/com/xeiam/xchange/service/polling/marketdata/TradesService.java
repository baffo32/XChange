package com.xeiam.xchange.service.polling.marketdata;

import java.io.IOException;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.params.QueryParams;
import com.xeiam.xchange.service.polling.params.ParamsAll;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to poll {@link Trades} performed on the exchange.</li>
 * </ul>
 */
public interface TradesService extends MarketDataService {

  /**
   * Get the trades performed by the exchange.
   *
   * @param params The parameters describing the filter. Note that {@link QueryParams} is an empty interface. The exact set of interfaces that are
   *        required or supported by this method is described by the type of object returned from {@link #createTradesParams()} and the javadoc
   *        of the method.
   * @return Trades as returned by the exchange API
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   * @see #createTradesParams()
   */
  Trades getTrades(QueryParams params) throws NotYetImplementedForExchangeException, IOException;

  /**
   * Create a {@link QueryParams} object specific to this service. The object created by this method may be used to discover supported and
   * required {@link #getTrades(QueryParams)} parameters and should be passed only to that method.
   */
  QueryParams createTradesParams();
}

