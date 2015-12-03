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
import com.xeiam.xchange.service.polling.params.ParamCurrencyPair;
import com.xeiam.xchange.service.polling.params.QueryParams;

import java.io.IOException;

/**
 * @deprecated Wraps {@link MarketDataService} interfaces as {@link PollingMarketDataService}
 */
@Deprecated
public class AdaptedMarketDataService extends BasePollingExchangeService implements PollingMarketDataService {

  private MarketDataService marketDataService;

  public AdaptedMarketDataService(Exchange exchange, MarketDataService marketDataService) {

    super(exchange);
    this.marketDataService = marketDataService;
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    if (!(marketDataService instanceof TickersService))
      throw new NotAvailableFromExchangeException();

    TickersService tickersService = (TickersService) marketDataService;

    QueryParams tickersParams = tickersService.createTickersParams();
    if (tickersParams instanceof ParamCurrencyPair)
      ((ParamCurrencyPair)tickersParams).setCurrencyPair(currencyPair);

    if (args.length != 0)
      throw new NotYetImplementedForExchangeException("Arg parsing not implemented for deprecated wrapper.  Upgrade interface or implement!");

    return tickersService.getTickers(tickersParams).get(currencyPair);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    if (!(marketDataService instanceof OrderBookService))
      throw new NotAvailableFromExchangeException();

    OrderBookService orderBookService = (OrderBookService) marketDataService;

    QueryParams orderBookParams = orderBookService.createOrderBooksParams();
    if (orderBookParams instanceof ParamCurrencyPair)
      ((ParamCurrencyPair)orderBookParams).setCurrencyPair(currencyPair);

    if (args.length != 0)
      throw new NotYetImplementedForExchangeException("Arg parsing not implemented for deprecated wrapper.  Upgrade interface or implement!");

    return orderBookService.getOrderBooks(orderBookParams).get(currencyPair);
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    if (!(marketDataService instanceof TradesService))
      throw new NotAvailableFromExchangeException();

    TradesService tradesService = (TradesService) marketDataService;

    QueryParams tradesParams = tradesService.createTradesParams();
    if (tradesParams instanceof ParamCurrencyPair)
      ((ParamCurrencyPair)tradesParams).setCurrencyPair(currencyPair);

    if (args.length != 0)
      throw new NotYetImplementedForExchangeException("Arg parsing not implemented for deprecated wrapper.  Upgrade interface or implement!");

    return tradesService.getTrades(tradesParams);
  }
}
