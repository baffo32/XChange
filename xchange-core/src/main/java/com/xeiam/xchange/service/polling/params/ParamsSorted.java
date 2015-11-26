package com.xeiam.xchange.service.polling.params;

public interface ParamsSorted extends QueryParams {

  Order getOrder();

  void setOrder(Order order);

  enum Order {
    asc, desc
  }
}
