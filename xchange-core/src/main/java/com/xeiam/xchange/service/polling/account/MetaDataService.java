package com.xeiam.xchange.service.polling.account;

import java.io.IOException;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.dto.meta.AccountMetaData;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to poll the {@link AccountMetaData}.</li>
 * </ul>
 */
public interface MetaDataService extends AccountService {

  /**
   * Get account meta data
   *
   * @return The account meta data, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  AccountMetaData getMetaData()
      throws ExchangeException, NotYetImplementedForExchangeException, IOException;
}
