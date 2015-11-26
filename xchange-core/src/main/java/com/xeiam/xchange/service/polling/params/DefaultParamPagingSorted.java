package com.xeiam.xchange.service.polling.params;

public class DefaultParamPagingSorted extends DefaultParamPaging implements ParamsSorted {

  private Order order = Order.asc;

  public DefaultParamPagingSorted(Integer pageLength) {
    super(pageLength);
  }

  public DefaultParamPagingSorted(Integer pageLength, Order order) {
    super(pageLength);
    this.order = order;
  }

  @Override
  public Order getOrder() {
    return order;
  }

  @Override
  public void setOrder(Order order) {
    this.order = order;
  }
}
