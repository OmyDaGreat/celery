package omydagreat.github.io.Common.Util

import moe.tlaster.precompose.navigation.Navigator

infix fun Navigator.gate(route: String) {
  navigate(route)
}
