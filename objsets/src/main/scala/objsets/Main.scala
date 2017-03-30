package objsets

/**
 * Created by mdaviot on 6/13/16.
 */
object Main extends App {
  // Some help printing the results:
  println("RANKED:")
  GoogleVsApple.trending foreach println
}

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")

  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  val googleTweets: TweetSet = {
    //TODO: keep only google tweets
    //TweetReader.allTweets.filter(tw => tw.text == "android" && tw.text == "Android" && tw.text == "galaxy" && tw.text == "Galaxy" && tw.text == "nexus" && tw.text == "Nexus")
    TweetReader.allTweets.filter(tw => google.exists(tw.text.contains))
  }

  val appleTweets: TweetSet = {
    //TODO: keep only apple tweets
    //TweetReader.allTweets.filter(tw => tw.text == "ios" && tw.text == "iOS" && tw.text == "iphone" && tw.text == "iPhone" && tw.text == "ipad" && tw.text == "iPad")
    TweetReader.allTweets.filter(tw => apple.exists(tw.text.contains))
  }

  val trending: Trending = {
    // TODO: join both sets
    //TODO what is the tweet with highest #retweets?
    googleTweets.union(appleTweets).ascendingByRetweet
  }
}

