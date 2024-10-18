package omydagreat.github.io.Stocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import omydagreat.github.io.Common.Util.Body1
import omydagreat.github.io.Common.Util.Body2
import omydagreat.github.io.Common.Util.Heading4

/**
 * Composable function that displays stock information.
 *
 * @param onNavigate A lambda function that is called when the "Go to Home" button is clicked.
 */
@Composable
fun StocksScreen(onNavigate: () -> Unit) {
  // State to hold the stock information
  var stockInfo by remember { mutableStateOf("Loading...") }
  val coroutineScope = rememberCoroutineScope()

  // Fetch stock information when the composable is first launched
  LaunchedEffect(Unit) {
    coroutineScope.launch {
      stockInfo = fetchStockSummary("AAPL").toString()
    }
  }

  // Main UI layout
  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      // Display the title
      Heading4("Stock Information")
      Spacer(modifier = Modifier.height(16.dp))
      // Display the stock information
      Body1(text = stockInfo)
      Spacer(modifier = Modifier.height(16.dp))
      // Button to navigate back to the home screen
      Button(onClick = { onNavigate() }) {
        Body2("Go to Home")
      }
    }
  }
}