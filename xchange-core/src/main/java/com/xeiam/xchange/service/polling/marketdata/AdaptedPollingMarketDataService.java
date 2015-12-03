package com.xeiam.xchange.service.polling.marketdata;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.BasePollingExchangeService;
import com.xeiam.xchange.service.polling.params.DefaultParamCurrencyPair;
import com.xeiam.xchange.service.polling.params.ParamCurrencyPair;
import com.xeiam.xchange.service.polling.params.QueryParams;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @deprecated Wraps {@link PollingMarketDataService} as {@link MarketDataService}
 */
@Deprecated
public class AdaptedPollingMarketDataService extends BasePollingExchangeService implements OrderBookService, TickersService, TradesService {

  private PollingMarketDataService pollingMarketDataService;

  public AdaptedPollingMarketDataService(Exchange exchange, PollingMarketDataService pollingMarketDataService) {

    super(exchange);
    this.pollingMarketDataService = pollingMarketDataService;
  }

  @Override
  public Map<CurrencyPair,OrderBook> getOrderBooks(QueryParams params) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    CurrencyPair currencyPair = ((ParamCurrencyPair) params).getCurrencyPair();
    return Collections.singletonMap(currencyPair, pollingMarketDataService.getOrderBook(currencyPair));
  }

  @Override
  public QueryParams createOrderBooksParams() {

    return new DefaultParamCurrencyPair();
  }

  @Override
  public Map<CurrencyPair,Ticker> getTickers(QueryParams params) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    CurrencyPair currencyPair = ((ParamCurrencyPair) params).getCurrencyPair();
    return Collections.singletonMap(currencyPair, pollingMarketDataService.getTicker(currencyPair));
  }

  @Override
  public QueryParams createTickersParams() {

    return new DefaultParamCurrencyPair();
  }

  @Override
  public Trades getTrades(QueryParams params) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    return pollingMarketDataService.getTrades(((ParamCurrencyPair)params).getCurrencyPair());
  }

  @Override
  public QueryParams createTradesParams() {

    return new DefaultParamCurrencyPair();
  }
}
