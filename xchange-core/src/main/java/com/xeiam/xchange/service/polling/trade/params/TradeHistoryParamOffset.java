package com.xeiam.xchange.service.polling.trade.params;

@Deprecated
public interface TradeHistoryParamOffset extends TradeHistoryParams {

  void setOffset(Long offset);

  Long getOffset();
}
