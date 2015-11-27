package com.xeiam.xchange.service.polling.account;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.exceptions.ExchangeException;
import com.xeiam.xchange.exceptions.NotAvailableFromExchangeException;
import com.xeiam.xchange.exceptions.NotYetImplementedForExchangeException;
import com.xeiam.xchange.service.polling.BasePollingExchangeService;
import com.xeiam.xchange.service.polling.marketdata.*;
import com.xeiam.xchange.service.polling.params.ParamCurrencyPair;
import com.xeiam.xchange.service.polling.params.QueryParams;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @deprecated Wraps {@link AccountService} interfaces as {@link PollingAccountService}
 */
@Deprecated
public class AdaptedAccountService extends BasePollingExchangeService implements PollingAccountService {

  private AccountService accountService;

  public AdaptedAccountService(Exchange exchange, AccountService accountService) {

    super(exchange);
    this.accountService = accountService;
  }

  @Override public AccountInfo getAccountInfo()
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    if (!(accountService instanceof AccountInfoService))
      throw new NotAvailableFromExchangeException();

    AccountInfoService accountInfoService = (AccountInfoService) accountService;

    return accountInfoService.getAccountInfo();
  }

  @Override public String withdrawFunds(String currency, BigDecimal amount, String address)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    if (!(accountService instanceof WithdrawService))
      throw new NotAvailableFromExchangeException();

    WithdrawService withdrawService = (WithdrawService) accountService;

    return withdrawService.withdrawFunds(currency, amount, address).toString();
  }

  @Override public String requestDepositAddress(String currency, String... args)
      throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {

    if (!(accountService instanceof DepositService))
      throw new NotAvailableFromExchangeException();

    if (args.length != 0)
      throw new NotYetImplementedForExchangeException("Arg parsing not implemented for deprecated wrapper.  Upgrade interface or implement!");

    DepositService depositService = (DepositService) accountService;

    return depositService.requestDepositAddress(currency);
  }
}
