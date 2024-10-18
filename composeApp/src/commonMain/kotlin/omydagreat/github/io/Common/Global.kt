package omydagreat.github.io.Common

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import omydagreat.github.io.Common.Util.ThemeType

object Global {
  var currentScreen by mutableStateOf<Screen>(Screen.Home)
  var isLightMode by mutableStateOf<Boolean>(true)
  var themeType by mutableStateOf<ThemeType>(ThemeType.Mint)
  val theme
    get() = themeType.lightColor.takeIf { isLightMode } ?: themeType.darkColor

  fun toggleTheme() {
    isLightMode = !isLightMode
  }
}

@Stable
val Color.Companion.Mint: Color
  get() = hsv(103f, 0.22f, 0.99f)
