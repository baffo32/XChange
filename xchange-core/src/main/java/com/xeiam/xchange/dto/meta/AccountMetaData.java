package com.xeiam.xchange.dto.meta;

import java.math.BigDecimal;
import java.util.*;

import com.xeiam.xchange.dto.account.Wallet;

/**
 * <p>
 * DTO representing account metadata
 * </p>
 * <p>
 * Account metadata is anything particular associated with the user's login
 * </p>
 */
public final class AccountMetaData {

  /**
   * The name on the account
   */
  private final String username;

  /**
   * The current fee this account must pay as a fraction of the value of each trade.  Null if there is no such fee.
   */
  private final BigDecimal tradingFee;

  /**
   * The wallet ids owned by this account
   */
  private final Collection<String> walletIds;

  // TODO some exchanges may benefit by a WalletMetaData class giving extra information for each wallet (more)
  // If so, check the exchanges to see if the data they provide maps better to having WalletData inside AccountMetaData or inside Wallet itself
  // (that is, does the equivalent of getWallets() return such data, or is it rather the equivalent of getAccountMetaData() ?)

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(String... walletIds) {

    this(null, (BigDecimal)null, walletIds);
  }

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(Collection<String> walletIds) {

    this(null, (BigDecimal)null, walletIds);
  }

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(String username, String... walletIds) {

    this(username, null, walletIds);
  }

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(String username, Collection<String> walletIds) {

    this(username, null, walletIds);
  }

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(String username, Map<String,Wallet> wallets) {

    this(username, null, wallets.keySet());
  }

  /**
   * Constructs an {@link AccountMetaData}.
   *
   * @param username the user name.
   * @param tradingFee the trading fee.
   * @param walletIds the user's wallets
   */
  public AccountMetaData(String username, BigDecimal tradingFee, Collection<String> walletIds) {

    this.username = username;
    this.tradingFee = tradingFee;

    if (walletIds.size() == 0) {
      this.walletIds = Collections.emptyList();
    } else if (walletIds.size() == 1) {
      String walletId = walletIds.iterator().next();
      this.walletIds = Collections.singletonList(walletId);
    } else {
      Set<String> idSet = new HashSet<String>();
      for (String walletId : walletIds) {
        if (idSet.contains(walletId))
          throw new IllegalArgumentException("duplicate wallet IDs passed to AccountMetaData");
        idSet.add(walletId);
      }
      this.walletIds = new ArrayList<String>(idSet);
    }

  }

  /**
   * @see #AccountMetaData(String,BigDecimal,Collection)
   */
  public AccountMetaData(String username, BigDecimal tradingFee, String... walletIds) {

    this(username, tradingFee, Arrays.asList(walletIds));
  }

  /**
   * Gets all wallet IDs in this account
   */
  public Collection<String> getWalletIds() {

    return Collections.unmodifiableCollection(walletIds);
  }

  /**
   * Gets wallet ID for accounts which don't use multiple wallets
   */
  public String getWalletId() {

    if (walletIds.size() > 1)
      throw new UnsupportedOperationException(walletIds.size() + " wallets in account");
    else if (walletIds.size() == 1)
      return walletIds.iterator().next();
    else
      return null;
  }

  /**
   * @return The user name
   */
  public String getUsername() {

    return username;
  }

  /**
   * Returns the current trading fee
   *
   * @return The trading fee
   */
  public BigDecimal getTradingFee() {

    return tradingFee;
  }

  @Override
  public boolean equals(Object object) {

    if (object == this)
      return true;
    if (!(object instanceof AccountMetaData))
      return false;

    AccountMetaData accountMetaData = (AccountMetaData) object;

    return Objects.equals(username, accountMetaData.username) &&
        Objects.equals(tradingFee, accountMetaData.tradingFee) &&
        Objects.equals(walletIds, accountMetaData.walletIds);
  }

  @Override
  public String toString() {

    return "AccountInfo [username=" + username + ", tradingFee=" + tradingFee + ", walletIds=" + walletIds + "]";
  }
}
