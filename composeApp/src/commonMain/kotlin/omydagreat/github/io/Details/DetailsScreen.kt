package omydagreat.github.io.Details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import omydagreat.github.io.Common.Global
import omydagreat.github.io.Common.ThemeType
import omydagreat.github.io.Common.Util.*

@Composable
fun DetailsScreen(onNavigate: () -> Unit) {
  var expanded by remember { mutableStateOf(false) }
  val themes = ThemeType.entries.toTypedArray()

  Box(
    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Heading4(text = "This is the Details Screen")
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { onNavigate() }) {
        Body2("Go to Home")
      }
      Spacer(modifier = Modifier.height(16.dp))
      Button(onClick = { Global.toggleTheme() }) {
        Body2("Toggle ${"Light".takeIf { !Global.theme.isLightMode } ?: "Dark"} Mode")
      }
      Spacer(modifier = Modifier.height(16.dp))
      Box {
        Button(onClick = { expanded = true }) {
          Body2("Select Theme")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
          themes.forEach { themeType ->
            DropdownMenuItem(onClick = {
              Global.theme = themeType
              expanded = false
            }) {
              Body2(text = themeType.name)
            }
          }
        }
      }
    }
  }
}
