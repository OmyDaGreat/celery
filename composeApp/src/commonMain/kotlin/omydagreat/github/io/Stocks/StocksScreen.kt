package omydagreat.github.io.Stocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import omydagreat.github.io.Common.Global

@Composable
fun StocksScreen(onNavigate: () -> Unit) {
  var stockInfo by remember { mutableStateOf("Loading...") }
  val coroutineScope = rememberCoroutineScope()

  LaunchedEffect(Unit) {
    coroutineScope.launch {
      stockInfo = fetchStockSummary()
    }
  }

  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "Stock Information", style = MaterialTheme.typography.h4, color = Global.theme.onBackground)
      Spacer(modifier = Modifier.height(16.dp))
      Text(text = stockInfo)
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { onNavigate() }) {
        Text("Go to Home")
      }
    }
  }
}
