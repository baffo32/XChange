package com.xeiam.xchange.service.polling.trade.params;

@Deprecated
public interface TradeHistoryParamTransactionId extends TradeHistoryParams {
  void setTransactionId(String txId);

  String getTransactionId();
}
