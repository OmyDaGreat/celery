package omydagreat.github.io.Stocks

import kotlinx.serialization.Serializable

/**
 * Data class representing the response for a stock query.
 *
 * @property data The stock data.
 * @property status The status of the response.
 */
@Serializable
data class StockResponse(
  val data: StockData,
  val status: Status
) {
  /**
   * Provides a human-readable string representation of the StockResponse.
   *
   * @return A formatted string containing the stock response details.
   */
  override fun toString(): String {
    return """
      Stock Information:
      - Symbol: ${data.symbol}
      - Exchange: ${data.summaryData.exchange.label} (${data.summaryData.exchange.value})
      - Sector: ${data.summaryData.sector.label} (${data.summaryData.sector.value})
      - Industry: ${data.summaryData.industry.label} (${data.summaryData.industry.value})
      - 1 Year Target: ${data.summaryData.oneYrTarget.label} (${data.summaryData.oneYrTarget.value})
      - Today's High/Low: ${data.summaryData.todayHighLow.label} (${data.summaryData.todayHighLow.value})
      - Share Volume: ${data.summaryData.shareVolume.label} (${data.summaryData.shareVolume.value})
      - Average Volume: ${data.summaryData.averageVolume.label} (${data.summaryData.averageVolume.value})
      - Previous Close: ${data.summaryData.previousClose.label} (${data.summaryData.previousClose.value})
      - 52 Week High/Low: ${data.summaryData.fiftyTwoWeekHighLow.label} (${data.summaryData.fiftyTwoWeekHighLow.value})
      - Market Cap: ${data.summaryData.marketCap.label} (${data.summaryData.marketCap.value})
      - P/E Ratio: ${data.summaryData.peRatio.label} (${data.summaryData.peRatio.value})
      - Forward P/E 1 Year: ${data.summaryData.forwardPE1Yr.label} (${data.summaryData.forwardPE1Yr.value})
      - Earnings Per Share: ${data.summaryData.earningsPerShare.label} (${data.summaryData.earningsPerShare.value})
      - Annualized Dividend: ${data.summaryData.annualizedDividend.label} (${data.summaryData.annualizedDividend.value})
      - Ex-Dividend Date: ${data.summaryData.exDividendDate.label} (${data.summaryData.exDividendDate.value})
      - Dividend Payment Date: ${data.summaryData.dividendPaymentDate.label} (${data.summaryData.dividendPaymentDate.value})
      - Yield: ${data.summaryData.yield.label} (${data.summaryData.yield.value})
      - Bid: ${data.bidAsk?.`Bid * Size`?.label} (${data.bidAsk?.`Bid * Size`?.value})
      - Ask: ${data.bidAsk?.`Ask * Size`?.label} (${data.bidAsk?.`Ask * Size`?.value})
      - Status Code: ${status.rCode}
    """.trimIndent()
  }
}

/**
 * Data class representing the stock data.
 *
 * @property symbol The stock symbol.
 * @property summaryData The summary data of the stock.
 * @property bidAsk The bid and ask data of the stock.
 */
@Serializable
data class StockData(
  val symbol: String,
  val summaryData: SummaryData,
  val bidAsk: BidAskData?
)

/**
 * Data class representing the summary data of a stock.
 *
 * @property exchange The exchange information.
 * @property sector The sector information.
 * @property industry The industry information.
 * @property oneYrTarget The one year target information.
 * @property todayHighLow The high and low prices for today.
 * @property shareVolume The share volume information.
 * @property averageVolume The average volume information.
 * @property previousClose The previous close price.
 * @property fiftyTwoWeekHighLow The 52-week high and low prices.
 * @property marketCap The market capitalization.
 * @property peRatio The price-to-earnings ratio.
 * @property forwardPE1Yr The forward price-to-earnings ratio for one year.
 * @property earningsPerShare The earnings per share.
 * @property annualizedDividend The annualized dividend.
 * @property exDividendDate The ex-dividend date.
 * @property dividendPaymentDate The dividend payment date.
 * @property yield The yield information.
 */
@Serializable
data class SummaryData(
  val exchange: InfoLabelValue,
  val sector: InfoLabelValue,
  val industry: InfoLabelValue,
  val oneYrTarget: InfoLabelValue,
  val todayHighLow: InfoLabelValue,
  val shareVolume: InfoLabelValue,
  val averageVolume: InfoLabelValue,
  val previousClose: InfoLabelValue,
  val fiftyTwoWeekHighLow: InfoLabelValue,
  val marketCap: InfoLabelValue,
  val peRatio: InfoLabelValue,
  val forwardPE1Yr: InfoLabelValue,
  val earningsPerShare: InfoLabelValue,
  val annualizedDividend: InfoLabelValue,
  val exDividendDate: InfoLabelValue,
  val dividendPaymentDate: InfoLabelValue,
  val yield: InfoLabelValue
)

/**
 * Data class representing the bid and ask data of a stock.
 *
 * @property `Bid * Size` The bid size information.
 * @property `Ask * Size` The ask size information.
 */
@Serializable
data class BidAskData(
  val `Bid * Size`: InfoLabelValue,
  val `Ask * Size`: InfoLabelValue
)

/**
 * Data class representing a label and value pair.
 *
 * @property label The label of the information.
 * @property value The value of the information.
 */
@Serializable
data class InfoLabelValue(
  val label: String,
  val value: String
)

/**
 * Data class representing the status of a response.
 *
 * @property rCode The response code.
 */
@Serializable
data class Status(
  val rCode: Int
)
