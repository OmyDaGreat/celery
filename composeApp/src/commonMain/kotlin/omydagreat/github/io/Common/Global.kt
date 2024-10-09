package omydagreat.github.io.Common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object Global {
  var currentScreen by mutableStateOf<Screen>(Screen.Home)
}
