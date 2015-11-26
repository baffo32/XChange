package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Parameters type with start and end timestamps.
 */
public interface ParamsTimeSpan extends ParamStartTime {

  void setEndTime(Date endTime);

  Date getEndTime();

  // Whether the returned data will always extend to the end time
  boolean extendsToEnd();

}
