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
   * <p/>
   * If you are calling this method for single exchange, known at the development time, you may pass an object of specific *TradesParam class
   * that is nested in that exchange's marketdata service.
   * <p/>
   * If, however, you are fetching trades from many exchanges using the same code, you will find it useful to create the parameter object
   * with {@link #createTradesParams()} and check which parameters are required or supported using the instanceof operator. See subinterfaces of
   * {@link QueryParams}. Note that whether an interface is required or supported will vary from exchange to exchange, and it's described only
   * through the javadoc.
   * <p/>
   * There is also an implementation of all the common interfaces, {@link ParamsAll} , that,
   * with all properties set non-null, should work with any exchange.  Of course, each exchange may ignore some of the properties.
   * <p/>
   * Some exchanges allow extra parameters, not covered by any common interface. To access them, you will have to use the object returned by
   * {@link #createTradesParams()} and cast it to the exchange-specific type.
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
   * @see ParamsAll
   */
  Trades getTrades(QueryParams params) throws NotYetImplementedForExchangeException, IOException;

  /**
   * Create a {@link QueryParams} object specific to this exchange. The object created by this method may be used to discover supported and
   * required {@link #getTrades(QueryParams)} parameters and should be passed only to the method in the same class as the createTradesParams
   * that created the object.
   */
  QueryParams createTradesParams();
}

