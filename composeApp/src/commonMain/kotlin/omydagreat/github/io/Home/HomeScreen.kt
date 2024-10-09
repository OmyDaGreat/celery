package omydagreat.github.io.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import omydagreat.github.io.Common.Global
import omydagreat.github.io.Common.Screen

/**
 * Composable function that represents the Home screen.
 *
 * @param onNavigate A lambda function that is called when the navigate button is clicked.
 */
@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(text = "This is the Home Screen", style = MaterialTheme.typography.h4, color = Global.theme.onBackground)
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { onNavigate(Screen.Details) }) {
        Text("Go to Details")
      }
    }
  }
}
