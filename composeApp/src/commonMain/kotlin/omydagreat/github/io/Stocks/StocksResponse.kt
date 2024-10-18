package omydagreat.github.io.Stocks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stock(
  val data: Data? = null,
  val message: String? = null,
  val status: Status
)

@Serializable
data class Data(
  val symbol: String,
  val summaryData: SummaryData,
  val assetClass: String,
  val additionalData: String? = null,
  val bidAsk: BidAsk
)

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
  @SerialName("PERatio") val peRatio: LabelValue,
  @SerialName("ForwardPE1Yr") val forwardPE1Yr: LabelValue,
  @SerialName("EarningsPerShare") val earningsPerShare: LabelValue,
  @SerialName("AnnualizedDividend") val annualizedDividend: LabelValue,
  @SerialName("ExDividendDate") val exDividendDate: LabelValue,
  @SerialName("DividendPaymentDate") val dividendPaymentDate: LabelValue,
  @SerialName("Yield") val yield: LabelValue
)

@Serializable
data class LabelValue(
  val label: String,
  val value: String
)

@Serializable
data class BidAsk(
  @SerialName("Bid * Size") val bidSize: LabelValue,
  @SerialName("Ask * Size") val askSize: LabelValue
)

@Serializable
data class Status(
  val rCode: Int,
  val bCodeMessage: String? = null,
  val developerMessage: String? = null
)
