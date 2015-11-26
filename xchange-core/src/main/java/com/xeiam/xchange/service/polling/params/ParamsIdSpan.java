package com.xeiam.xchange.service.polling.params;

public interface ParamsIdSpan extends QueryParams {

  void setStartId(Long startId);

  Long getStartId();

  void setEndId(Long endId);

  Long getEndId();
}
