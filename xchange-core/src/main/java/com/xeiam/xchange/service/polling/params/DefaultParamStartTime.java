package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Common implementation of {@link ParamStartTime}.
 */
public class DefaultParamStartTime implements ParamStartTime {

  private Date startTime;
  private final boolean extendsToStart;

  public DefaultParamStartTime(boolean extendsToStart) {

    this.extendsToStart = extendsToStart;
  }

  public DefaultParamStartTime(boolean extendsToStart, Date startTime) {

    this.extendsToStart = extendsToStart;
    this.startTime = startTime;
  }

  @Override
  public void setStartTime(Date time) {

    startTime = time;
  }

  @Override
  public Date getStartTime() {

    return startTime;
  }

  @Override
  public boolean extendsToStart() {

    return extendsToStart;
  }
}
