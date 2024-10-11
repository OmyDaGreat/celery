package omydagreat.github.io.Stocks

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * Creates a common HTTP client with JSON content negotiation.
 *
 * @return An instance of [HttpClient] configured with JSON content negotiation.
 */
fun createHttpClientCommon() = HttpClient {
  install(ContentNegotiation) {
    json(Json {
      prettyPrint = true
      isLenient = true
      ignoreUnknownKeys = true
    })
  }
}

/**
 * Fetches the stock summary for a given stock from a NASDAQ API.
 *
 * The API can be found [here](https://rapidapi.com/banikhp13tu/api/nasdaq-stock-summary)
 *
 * @param stock The stock asset symbol (e.g., "MSFT" for Microsoft).
 * @return A [StockResponse] object containing the stock summary.
 * @throws Exception if the HTTP request fails.
 */
suspend fun fetchStockSummary(stock: String): StockResponse {
  val client = createHttpClientCommon()
  val response: HttpResponse = client.get("https://nasdaq-stock-summary.p.rapidapi.com/api/quote/$stock/summary?assetclass=stocks") {
    headers {
      append("x-rapidapi-key", "78dbdb9dd1msh2d5c5f88cb48d0ap19380fjsna5c30f3e04c6")
      append("x-rapidapi-host", "nasdaq-stock-summary.p.rapidapi.com")
      append("Content-Type", "application/json")
      append("Host", "api.nasdaq.com")
    }
  }
  val responseBody = response.bodyAsText()
  return Json.decodeFromString(responseBody)
}
