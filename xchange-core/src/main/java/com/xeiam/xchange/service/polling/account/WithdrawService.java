package com.xeiam.xchange.service.polling.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.Currency;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to withdraw funds.</li>
 * </ul>
 */
public interface WithdrawService extends AccountService {

  /**
   * Withdraw funds from this account. Allows to withdraw digital currency funds from the exchange account to an external address
   *
   * @param currency The currency to withdraw
   * @param amount The amount to withdraw
   * @param address The destination address
   * @return A transaction ID if available
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
   String withdrawFunds(Currency currency, BigDecimal amount, String address)
      throws ExchangeException, NotYetImplementedForExchangeException, IOException;
}
