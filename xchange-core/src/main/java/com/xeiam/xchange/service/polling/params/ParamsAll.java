package com.xeiam.xchange.service.polling.params;

import java.util.Date;

import com.xeiam.xchange.currency.CurrencyPair;

/**
 * Generic {@link QueryParams} implementation that implements all the interfaces in the hierarchy and can be safely (without getting
 * exceptions, if that all the required fields are non-null) passed to any polling service implementation which accepts an interface in this package.
 */
public class ParamsAll
    implements ParamsTimeSpan, ParamCurrencyPair, ParamId, ParamPaging, ParamsIdSpan, ParamOffset {

  private Integer pageLength;
  private Integer pageNumber;
  private String startId;
  private String endId;
  private Date startTime;
  private Date endTime;
  private Long offset;
  private CurrencyPair pair;

  @Override
  public void setPageLength(Integer count) {

    this.pageLength = count;
  }

  @Override
  public Integer getPageLength() {

    return pageLength;
  }

  @Override
  public String getId() {

    return startId.toString();
  }

  @Override
  public void setId(String id) {

    startId = id;
  }

  @Override
  public Long getStartId() {

    return new Long(startId);
  }

  @Override
  public void setEndId(Long endId) {

    this.endId = endId.toString();
  }

  @Override
  public Long getEndId() {

    return new Long(endId);
  }

  @Override
  public void setStartId(Long from) {

    startId = from.toString();
  }

  @Override
  public void setEndTime(Date to) {

    endTime = to;
  }

  @Override
  public Date getEndTime() {

    return endTime;
  }

  @Override
  public boolean extendsToEnd() {

    return false;
  }

  @Override
  public void setStartTime(Date startTime) {

    this.startTime = startTime;
  }

  @Override
  public Date getStartTime() {

    return startTime;
  }

  @Override
  public boolean extendsToStart() {

    return false;
  }

  @Override
  public void setOffset(Long offset) {

    this.offset = offset;
  }

  @Override
  public Long getOffset() {

    if (offset != null || pageLength == null || pageNumber == null)
      return offset;
    else
      return (long) pageLength * pageNumber;
  }

  @Override
  public Integer getPageNumber() {

    return pageNumber;
  }

  @Override
  public void setPageNumber(Integer pageNumber) {

    this.pageNumber = pageNumber;
  }

  @Override
  public CurrencyPair getCurrencyPair() {

    return pair;
  }

  @Override
  public void setCurrencyPair(CurrencyPair pair) {

    this.pair = pair;
  }
}
