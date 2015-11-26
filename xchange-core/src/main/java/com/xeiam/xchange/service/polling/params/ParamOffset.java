package com.xeiam.xchange.service.polling.params;

public interface ParamOffset extends QueryParams {

  void setOffset(Long offset);

  Long getOffset();
}
