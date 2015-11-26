package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Common implementation of {@link ParamsTimeSpan}.
 */
public class DefaultParamsTimeSpan extends DefaultParamStartTime implements ParamsTimeSpan {

  private final DefaultParamEndTime endTime;

  public DefaultParamsTimeSpan(boolean extendsToExtents) {

    super(extendsToExtents);
    endTime = new DefaultParamEndTime(extendsToExtents);
  }

  public DefaultParamsTimeSpan(boolean extendsToStart, boolean extendsToEnd) {

    super(extendsToStart);
    endTime = new DefaultParamEndTime(extendsToEnd);
  }

  public DefaultParamsTimeSpan(boolean extendsToExtents, Date startTime, Date endTime) {

    super(extendsToExtents, startTime);
    this.endTime = new DefaultParamEndTime(extendsToExtents, endTime);
  }

  public DefaultParamsTimeSpan(boolean extendsToStart, Date startTime, boolean extendsToEnd, Date endTime) {

    super(extendsToStart, startTime);
    this.endTime = new DefaultParamEndTime(extendsToEnd, endTime);
  }

  @Override
  public void setEndTime(Date endTime) {

    this.endTime.setEndTime(endTime);
  }

  @Override
  public Date getEndTime() {

    return endTime.getEndTime();
  }

  @Override
  public boolean extendsToEnd() {

    return endTime.extendsToEnd();
  }
}
