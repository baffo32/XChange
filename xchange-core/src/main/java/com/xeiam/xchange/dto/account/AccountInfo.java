package com.xeiam.xchange.dto.account;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.xeiam.xchange.dto.meta.AccountMetaData;

/**
 * <p>
 * DTO representing account information
 * </p>
 * <p>
 * Account information is anything particular associated with the user's login
 * </p>
 */
public final class AccountInfo {

  /**
   * Metadata for the account, including the username and trading fee.
   */
  private final AccountMetaData metaData;

  /**
   * The wallets owned by this account
   */
  private final Map<String, Wallet> wallets;


  /**
   * @see #AccountInfo(String,BigDecimal,Collection)
   */
  public AccountInfo(Wallet... wallets) {

    // TODO when refactoring for separate feature interfaces, change this constructor to require at least two wallets
    this(null, (BigDecimal)null, wallets);
  }

  /**
   * @see #AccountInfo(String,BigDecimal,Collection)
   */
  public AccountInfo(Collection<Wallet> wallets) {

    this(null, (BigDecimal)null, wallets);
  }

  /**
   * @see #AccountInfo(String,BigDecimal,Collection)
   */
  public AccountInfo(String username, Wallet... wallets) {

    this(username, null, wallets);
  }

  /**
   * @see #AccountInfo(String,BigDecimal,Collection)
   */
  public AccountInfo(String username, Collection<Wallet> wallets) {

    this(username, null, wallets);
  }

  /**
   * Constructs an {@link AccountInfo}.
   *
   * @param username the user name.
   * @param tradingFee the trading fee.
   * @param wallets the user's wallets
   */
  public AccountInfo(String username, BigDecimal tradingFee, Collection<Wallet> wallets) {

    if (wallets.size() == 0) {
      this.wallets = Collections.emptyMap();
    } else if (wallets.size() == 1) {
      Wallet wallet = wallets.iterator().next();
      this.wallets = Collections.singletonMap(wallet.getId(), wallet);
    } else {
      this.wallets = new HashMap<String,Wallet>();
      for (Wallet wallet : wallets) {
        if (this.wallets.containsKey(wallet.getId()))
          throw new IllegalArgumentException("duplicate wallets passed to AccountInfo");
        this.wallets.put(wallet.getId(), wallet);
      }
    }

    this.metaData = new AccountMetaData(username, tradingFee, this.wallets.keySet());
  }

  /**
   * @see #AccountInfo(String,BigDecimal,Collection)
   */
  public AccountInfo(String username, BigDecimal tradingFee, Wallet... wallets) {

    this(username, tradingFee, Arrays.asList(wallets));
  }

  /**
   * Gets all wallets in this account
   */
  public Map<String,Wallet> getWallets() {

    return Collections.unmodifiableMap(wallets);
  }

  /**
   * Gets wallet for accounts which don't use multiple wallets
   */
  public Wallet getWallet() {

    return getWallet(metaData.getWalletId());
  }

  /**
   * Gets the wallet with a specific id
   */
  public Wallet getWallet(String id) {

    return wallets.get(id);
  }

  /**
   * @return The account metadata, including username and trading fee
   */
  public AccountMetaData getMetaData() {

    return metaData;
  }


  /**
   * @return The user name
   * @deprecated use {@link #getMetaData}
   */
  @Deprecated
  public String getUsername() {

    return metaData.getUsername();
  }

  /**
   * Returns the current trading fee
   *
   * @return The trading fee
   * @deprecated use {@link #getMetaData}
   */
  @Deprecated
  public BigDecimal getTradingFee() {

    return metaData.getTradingFee();
  }

  @Override
  public String toString() {

    return "AccountInfo [metaData=" + metaData + ", wallets=" + wallets + "]";
  }
}
