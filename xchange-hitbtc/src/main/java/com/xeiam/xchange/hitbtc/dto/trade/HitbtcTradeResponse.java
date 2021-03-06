package com.xeiam.xchange.hitbtc.dto.trade;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeiam.xchange.hitbtc.dto.HitbtcBaseResponse;

public class HitbtcTradeResponse extends HitbtcBaseResponse {

  private final HitbtcOwnTrade[] trades;

  public HitbtcTradeResponse(@JsonProperty("trades") HitbtcOwnTrade[] trades) {

    this.trades = trades;
  }

  public HitbtcOwnTrade[] getTrades() {

    return trades;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("HitbtcTradeResponse [trades=");
    builder.append(Arrays.toString(trades));
    builder.append("]");
    return builder.toString();
  }
}
