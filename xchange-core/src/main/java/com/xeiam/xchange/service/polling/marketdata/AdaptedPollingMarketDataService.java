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

/**
 * @deprecated Wraps {@link PollingMarketDataService} as {@link MarketDataService}
 */
@Deprecated
public class AdaptedPollingMarketDataService extends BasePollingExchangeService implements OrderBookService, TickerService, TradesService {

  private PollingMarketDataService pollingMarketDataService;

  public AdaptedPollingMarketDataService(Exchange exchange, PollingMarketDataService pollingMarketDataService) {

    super(exchange);
    this.pollingMarketDataService = pollingMarketDataService;
  }

  @Override
  public OrderBook getOrderBook(QueryParams params) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    return pollingMarketDataService.getOrderBook(((ParamCurrencyPair)params).getCurrencyPair());
  }

  @Override
  public QueryParams createOrderBookParams() {

    return new DefaultParamCurrencyPair();
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    return pollingMarketDataService.getTicker(currencyPair);
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
