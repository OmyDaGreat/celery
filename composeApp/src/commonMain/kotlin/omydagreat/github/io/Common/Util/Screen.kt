package omydagreat.github.io.Common.Util

/**
 * Represents different screens in the application.
 *
 * @property route The route associated with the screen.
 */
sealed class Screen(private val route: String) {

  /**
   * Represents the Home screen.
   */
  data object Home : Screen("home")

  /**
   * Represents the Details screen.
   */
  data object Details : Screen("details")

  /**
   * Represents the Stocks screen.
   */
  data object Stocks : Screen("stocks")
}
