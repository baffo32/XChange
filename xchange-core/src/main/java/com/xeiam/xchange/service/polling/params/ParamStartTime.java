package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Parameter type with a start timestamp.
 */
public interface ParamStartTime extends QueryParams {

  void setStartTime(Date startTime);

  Date getStartTime();

  // Whether the returned data will always extend to the start time
  boolean extendsToStart();

}
