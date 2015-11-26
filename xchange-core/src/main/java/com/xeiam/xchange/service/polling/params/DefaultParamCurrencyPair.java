package com.xeiam.xchange.service.polling.params;

import com.xeiam.xchange.currency.CurrencyPair;

public class DefaultParamCurrencyPair implements ParamCurrencyPair {

  private CurrencyPair pair;

  public DefaultParamCurrencyPair() {
  }

  public DefaultParamCurrencyPair(CurrencyPair pair) {
    this.pair = pair;
  }

  @Override
  public void setCurrencyPair(CurrencyPair pair) {

    this.pair = pair;
  }

  @Override
  public CurrencyPair getCurrencyPair() {

    return pair;
  }
}
