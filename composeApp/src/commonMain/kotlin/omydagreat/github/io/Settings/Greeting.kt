package omydagreat.github.io.Settings

import omydagreat.github.io.getPlatform

/**
 * A class that provides a greeting message.
 */
class Greeting {
  private val platform = getPlatform()

  /**
   * Returns a greeting message that includes the platform name.
   *
   * @return A greeting message string.
   */
  fun greet(): String {
    return "( ･ω･)ﾉ ${platform.name}"
  }
}
