package com.xeiam.xchange.service.polling.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.params.ParamsAll;
import com.xeiam.xchange.service.polling.params.QueryParams;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to deposit funds.</li>
 * </ul>
 */
public interface DepositService extends AccountService {

  /**
   * Request a digital currency address to fund this account. Allows to fund the exchange account with digital currency from an external address
   *
   * @param currency The digital currency that corresponds to the desired deposit address.
   * @return the internal deposit address to send funds to
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  String requestDepositAddress(String currency)
      throws ExchangeException, NotYetImplementedForExchangeException, IOException;
}
