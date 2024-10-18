package omydagreat.github.io.Common.Util

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import omydagreat.github.io.Common.Mint

enum class ThemeType(val lightColor: Colors, val darkColor: Colors) {
  Mint(
    lightColors(background = Color.Mint, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.Mint)
  ),
  Plain(
    lightColors(background = Color.White, onBackground = Color.Black),
    darkColors(background = Color.Black, onBackground = Color.White)
  ),
}
