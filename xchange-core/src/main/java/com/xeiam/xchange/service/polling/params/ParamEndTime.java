package com.xeiam.xchange.service.polling.params;

import java.util.Date;

/**
 * Parameter type with an end timestamp.
 */
public interface ParamEndTime extends QueryParams {

  void setEndTime(Date endTime);

  Date getEndTime();

  // Whether the returned data will always extend to the end time
  boolean extendsToEnd();

}
