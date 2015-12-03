package com.xeiam.xchange.service.polling.marketdata;

import java.io.IOException;
import java.util.Map;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.params.QueryParams;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to poll an {@link OrderBook} of the market depth.</li>
 * </ul>
 */
public interface OrderBookService extends MarketDataService {

  /**
   * Get one or more order books representing the offered exchange rates (market depth)
   *
   * @param params The parameters describing the filter. Note that {@link QueryParams} is an empty interface. The exact set of interfaces that are
   *        required or supported by this method is described by the type of object returned from {@link #createOrderBooksParams()} and the javadoc
   *        of the method.
   * @return The order books, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   * @see #createOrderBooksParams()
   */
  Map<CurrencyPair,OrderBook> getOrderBooks(QueryParams params)
      throws ExchangeException, NotYetImplementedForExchangeException, IOException;

  /**
   * Create a {@link QueryParams} object specific to this service. The object created by this method may be used to discover supported and
   * required {@link #getOrderBooks(QueryParams)} parameters and should be passed only to that method.
   */
  QueryParams createOrderBooksParams();
}

