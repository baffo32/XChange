package com.xeiam.xchange.service.polling.account;

import java.io.IOException;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.dto.account.Wallet;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.params.QueryParams;

/**
 * <p>
 * Interface to provide the following to {@link Exchange}:
 * </p>
 * <ul>
 * <li>Standard method to poll an authenticated user's {@link Wallet}.</li>
 * </ul>
 */
public interface WalletsService extends AccountService {

  /**
   * Get one or more wallets
   *
   * @param params The parameters describing the filter. Note that {@link QueryParams} is an empty interface. The exact set of interfaces that are
   *        required or supported by this method is described by the type of object returned from {@link #createWalletsParams()} and the javadoc
   *        of the method.
   * @return the wallets, null if some sort of error occurred. Implementers should log the error.
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the request or response
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the requested function or data, but it has not yet been
   *         implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  Wallet getWallets(QueryParams params) throws ExchangeException, NotYetImplementedForExchangeException, IOException;

  /**
   * Create a {@link QueryParams} object specific to this service. The object created by this method may be used to discover supported and
   * required {@link #getWallets(QueryParams)} parameters and should be passed only to that method.
   */
  QueryParams createWalletsParams();
}
