package com.xeiam.xchange.service.polling.params;

import com.xeiam.xchange.currency.CurrencyPair;

public interface ParamCurrencyPair extends QueryParams {

  void setCurrencyPair(CurrencyPair pair);

  CurrencyPair getCurrencyPair();
}
