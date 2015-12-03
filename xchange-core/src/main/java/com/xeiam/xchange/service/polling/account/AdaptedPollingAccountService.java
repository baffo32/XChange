package com.xeiam.xchange.service.polling.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.Currency;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.BasePollingExchangeService;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @deprecated Wraps {@link PollingAccountService} as {@link AccountService}
 */
@Deprecated
public class AdaptedPollingAccountService extends BasePollingExchangeService implements AccountInfoService, DepositService, WithdrawService {

  private PollingAccountService pollingAccountService;

  public AdaptedPollingAccountService(Exchange exchange, PollingAccountService pollingAccountService) {

    super(exchange);
    this.pollingAccountService = pollingAccountService;
  }

  @Override public AccountInfo getAccountInfo() throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    return pollingAccountService.getAccountInfo();
  }

  @Override public String requestDepositAddress(Currency currency) throws ExchangeException, NotAvailableFromExchangeException,
      NotYetImplementedForExchangeException, IOException {

    return pollingAccountService.requestDepositAddress(currency);
  }

  @Override public String withdrawFunds(Currency currency, BigDecimal amount, String address)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    return pollingAccountService.requestDepositAddress(currency);
  }
}
