package com.xeiam.xchange.service.polling.params;

/**
 * {@link QueryParams} with no parameters, or in which all parameters are optional
 */
public interface ParamsZero extends QueryParams {

  final public static QueryParams PARAMS_ZERO = new ParamsZero() {};
}
