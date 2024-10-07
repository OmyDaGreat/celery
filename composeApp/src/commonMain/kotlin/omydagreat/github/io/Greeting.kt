package omydagreat.github.io

class Greeting {
  private val platform = getPlatform()

  fun greet(): String {
    return "( ･ω･)ﾉ ${platform.name}"
  }
}
