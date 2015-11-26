package com.xeiam.xchange.service.polling.params;

public interface ParamPaging extends QueryParams {

  void setPageLength(Integer pageLength);

  Integer getPageLength();

  /** 0-based page number */
  void setPageNumber(Integer pageNumber);

  /** 0-based page number */
  Integer getPageNumber();
}
