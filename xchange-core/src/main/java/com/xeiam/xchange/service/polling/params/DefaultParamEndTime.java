package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Common implementation of {@link ParamEndTime}.
 */
public class DefaultParamEndTime implements ParamEndTime {

  private Date endTime;
  private final boolean extendsToEnd;

  public DefaultParamEndTime(boolean extendsToEnd) {

    this.extendsToEnd = extendsToEnd;
  }

  public DefaultParamEndTime(boolean extendsToEnd, Date endTime) {

    this.extendsToEnd = extendsToEnd;
    this.endTime = endTime;
  }

  @Override
  public void setEndTime(Date time) {

    endTime = time;
  }

  @Override
  public Date getEndTime() {

    return endTime;
  }

  @Override
  public boolean extendsToEnd() {

    return extendsToEnd;
  }
}
