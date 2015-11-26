package com.xeiam.xchange.service.polling.params;

public interface ParamTransactionId extends QueryParams {
  void setTransactionId(long txId);

  long getTransactionId();
}
