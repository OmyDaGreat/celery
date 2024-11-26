package omydagreat.github.io.screens.stock

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a stock with its associated data, message, and status.
 *
 * @property data The detailed data of the stock.
 * @property message An optional message related to the stock.
 * @property status The status of the stock data retrieval.
 */
@Serializable
data class Stock(
  val data: Data? = null, val message: String? = null, val status: Status? = null
) {
  /**
   * Provides a detailed and formatted string representation of the Stock object.
   *
   * @return A string representation of the Stock object.
   */
  override fun toString(): String {
    return buildString {
      appendLine("Stock Information:")
      data?.let {
        appendLine("Symbol: ${it.symbol}")
        appendLine("Exchange: ${it.summaryData.exchange.value}")
        appendLine("Sector: ${it.summaryData.sector.value}")
        appendLine("Industry: ${it.summaryData.industry.value}")
        appendLine("One Year Target: ${it.summaryData.oneYrTarget.value}")
        appendLine("Today's High/Low: ${it.summaryData.todayHighLow.value}")
        appendLine("Share Volume: ${it.summaryData.shareVolume.value}")
        appendLine("Average Volume: ${it.summaryData.averageVolume.value}")
        appendLine("Previous Close: ${it.summaryData.previousClose.value}")
        appendLine("52 Week High/Low: ${it.summaryData.fiftyTwoWeekHighLow.value}")
        appendLine("Market Cap: ${it.summaryData.marketCap.value}")
        appendLine("P/E Ratio: ${it.summaryData.peRatio.value}")
        appendLine("Forward P/E 1 Year: ${it.summaryData.forwardPE1Yr.value}")
        appendLine("Earnings Per Share: ${it.summaryData.earningsPerShare.value}")
        appendLine("Annualized Dividend: ${it.summaryData.annualizedDividend.value}")
        appendLine("Ex-Dividend Date: ${it.summaryData.exDividendDate.value}")
        appendLine("Dividend Payment Date: ${it.summaryData.dividendPaymentDate.value}")
        appendLine("Yield: ${it.summaryData.yield.value}")
        appendLine("Bid Size: ${it.bidAsk.bidSize.value}")
        appendLine("Ask Size: ${it.bidAsk.askSize.value}")
      } ?: appendLine("No data available")
      appendLine("Message: ${message ?: "No message"}")
      appendLine("Status: ${status?.rCode ?: "N/A"} - ${status?.developerMessage ?: "No developer message"}")
    }
  }
}

/**
 * Represents the detailed data of a stock.
 *
 * @property symbol The stock symbol.
 * @property summaryData The summary data of the stock.
 * @property assetClass The asset class of the stock.
 * @property additionalData Additional data related to the stock.
 * @property bidAsk The bid and ask size of the stock.
 */
@Serializable
data class Data(
  val symbol: String,
  val summaryData: SummaryData,
  val assetClass: String,
  val additionalData: String? = null,
  val bidAsk: BidAsk
)

/**
 * Represents the summary data of a stock.
 *
 * @property exchange The exchange where the stock is listed.
 * @property sector The sector of the stock.
 * @property industry The industry of the stock.
 * @property oneYrTarget The one-year target price of the stock.
 * @property todayHighLow Today's high and low prices of the stock.
 * @property shareVolume The share volume of the stock.
 * @property averageVolume The average volume of the stock.
 * @property previousClose The previous close price of the stock.
 * @property fiftyTwoWeekHighLow The 52-week high and low prices of the stock.
 * @property marketCap The market capitalization of the stock.
 * @property peRatio The P/E ratio of the stock.
 * @property forwardPE1Yr The forward P/E ratio for one year.
 * @property earningsPerShare The earnings per share of the stock.
 * @property annualizedDividend The annualized dividend of the stock.
 * @property exDividendDate The ex-dividend date of the stock.
 * @property dividendPaymentDate The dividend payment date of the stock.
 * @property yield The yield of the stock.
 */
@Serializable
data class SummaryData(
  @SerialName("Exchange") val exchange: LabelValue,
  @SerialName("Sector") val sector: LabelValue,
  @SerialName("Industry") val industry: LabelValue,
  @SerialName("OneYrTarget") val oneYrTarget: LabelValue,
  @SerialName("TodayHighLow") val todayHighLow: LabelValue,
  @SerialName("ShareVolume") val shareVolume: LabelValue,
  @SerialName("AverageVolume") val averageVolume: LabelValue,
  @SerialName("PreviousClose") val previousClose: LabelValue,
  @SerialName("FiftTwoWeekHighLow") val fiftyTwoWeekHighLow: LabelValue,
  @SerialName("MarketCap") val marketCap: LabelValue,
  @SerialName("PERatio") val peRatio: LabelValueNum,
  @SerialName("ForwardPE1Yr") val forwardPE1Yr: LabelValue,
  @SerialName("EarningsPerShare") val earningsPerShare: LabelValue,
  @SerialName("AnnualizedDividend") val annualizedDividend: LabelValue,
  @SerialName("ExDividendDate") val exDividendDate: LabelValue,
  @SerialName("DividendPaymentDate") val dividendPaymentDate: LabelValue,
  @SerialName("Yield") val yield: LabelValue
)

/**
 * Represents a label and value pair.
 *
 * @property label The label of the value.
 * @property value The value associated with the label.
 */
@Serializable
data class LabelValue(
  val label: String, val value: String
)

/**
 * Represents a label and numeric value pair.
 *
 * @property label The label of the value.
 * @property value The numeric value associated with the label.
 */
@Serializable
data class LabelValueNum(
  val label: String, val value: Double
)

/**
 * Represents the bid and ask size of a stock.
 *
 * @property bidSize The bid size of the stock.
 * @property askSize The ask size of the stock.
 */
@Serializable
data class BidAsk(
  @SerialName("Bid * Size") val bidSize: LabelValue, @SerialName("Ask * Size") val askSize: LabelValue
)

/**
 * Represents the status of the stock data retrieval.
 *
 * @property rCode The response code indicating the status of the request.
 * @property bCodeMessage A list of error messages, if any.
 * @property developerMessage An optional message for developers.
 */
@Serializable
data class Status(
  val rCode: Int, val bCodeMessage: List<ErrorMessage>? = null, val developerMessage: String? = null
)

/**
 * Represents an error message with a code and description.
 *
 * @property code The error code.
 * @property errorMessage The description of the error.
 */
@Serializable
data class ErrorMessage(
  val code: Int, val errorMessage: String
)
