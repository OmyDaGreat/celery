package omydagreat.github.io.Common

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

enum class ThemeType(val lightColor: Colors, val darkColor: Colors) {
  Mint(
    lightColors(background = Color.Mint, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.Mint)
  ),
  Plain(
    lightColors(background = Color.White, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.White)
  );

  var isLightMode by mutableStateOf<Boolean>(true)

  val colors: Colors
    get() = lightColor.takeIf { isLightMode } ?: darkColor
}
