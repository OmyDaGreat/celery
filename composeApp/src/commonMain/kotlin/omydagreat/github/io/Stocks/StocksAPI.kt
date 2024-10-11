package omydagreat.github.io.Stocks

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createHttpClientCommon() = HttpClient {
  install(ContentNegotiation) {
    json(Json {
      prettyPrint = true
      isLenient = true
      ignoreUnknownKeys = true
    })
  }
}

suspend fun fetchStockSummary(): String {
  val client = createHttpClientCommon()
  val response: HttpResponse = client.get("https://nasdaq-stock-summary.p.rapidapi.com/api/quote/MSFT/summary?assetclass=stocks") {
    headers {
      append("x-rapidapi-key", "78dbdb9dd1msh2d5c5f88cb48d0ap19380fjsna5c30f3e04c6")
      append("x-rapidapi-host", "nasdaq-stock-summary.p.rapidapi.com")
      append("Content-Type", "application/json")
      append("Host", "api.nasdaq.com")
    }
  }
  return response.bodyAsText()
}
