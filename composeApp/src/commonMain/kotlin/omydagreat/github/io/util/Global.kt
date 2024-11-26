package omydagreat.github.io.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object Global {
  var theme by mutableStateOf(ThemeType.Mint)

  fun toggleTheme() {
    theme.isLightMode = !theme.isLightMode
  }
}
