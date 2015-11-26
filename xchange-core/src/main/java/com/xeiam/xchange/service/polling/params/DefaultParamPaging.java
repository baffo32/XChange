package com.xeiam.xchange.service.polling.params;

/**
 * Common implementation of {@link ParamPaging} interface
 */
public class DefaultParamPaging implements ParamPaging {

  private Integer pageLength;
  private Integer pageNumber;

  public DefaultParamPaging() {
  }

  public DefaultParamPaging(Integer pageLength) {
    this(pageLength, 0);
  }

  public DefaultParamPaging(Integer pageLength, Integer pageNumber) {

    this.pageLength = pageLength;
    this.pageNumber = pageNumber;
  }

  @Override
  public Integer getPageLength() {

    return pageLength;
  }

  @Override
  public void setPageLength(Integer pageLength) {

    this.pageLength = pageLength;
  }

  @Override
  public Integer getPageNumber() {

    return pageNumber;
  }

  @Override
  public void setPageNumber(Integer pageNumber) {

    this.pageNumber = pageNumber;
  }
}
