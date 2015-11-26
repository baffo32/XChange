package com.xeiam.xchange.service.polling.trade.params;

@Deprecated
public interface TradeHistoryParamsSorted extends TradeHistoryParams {

  Order getOrder();

  void setOrder(Order order);

  enum Order {
    asc, desc
  }
}
