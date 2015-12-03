package com.xeiam.xchange.service.polling.params;

/**
 * Root interface for all interfaces used as parameter types for service requests
 * <p/>
 * If you are calling a service method for single exchange, known at the development time, you may pass an object of specific *Param class
 * that is nested in that exchange's service implementation class.
 * <p/>
 * If, however, you are fetching from many exchanges using the same code, you will find it useful to create the parameter object
 * with the <code>create*Params()</code> method of the service and check which parameters are required or supported using the instanceof operator.
 * See subinterfaces of {@link QueryParams}. Note that whether an interface is required or supported will vary from exchange to exchange, and it's
 * described only through the javadoc.
 * <p/>
 * There is also an implementation of all the common interfaces, {@link ParamsAll} , that, with all properties set non-null, should work with any
 * exchange.  Of course, each exchange may ignore some of the properties.
 * <p/>
 * Some service implementations allow extra parameters, not covered by any common interface. To access them, you will have to use the objects returned
 * by their <code>create*Params()</code> method and cast it to the service-specific type.
 */
public interface QueryParams {
}
