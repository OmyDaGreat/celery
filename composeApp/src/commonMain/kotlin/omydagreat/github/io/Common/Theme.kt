package omydagreat.github.io.Common

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

enum class ThemeType(val lightColor: Colors, val darkColor: Colors, var isLightMode: Boolean = true) {
  Mint(
    lightColors(background = Color.Mint, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.Mint)
  ),
  Plain(
    lightColors(background = Color.White, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.White)
  );

  val colors: Colors
    get() = lightColor.takeIf { isLightMode } ?: darkColor
}
