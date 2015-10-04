import scala.io._
import scala.actors._
import Actor._


//Page object
object Page {

  //get raw content
  def getContent(url: String) = Source.fromURL(url).mkString

  //get links as a list
  def getLinks(url: String): List[String] = {
    val content = getContent(url)
    val linkReg = "<a[^>]* href=\"([^\"]*)\"".r

    linkReg.findAllIn(content).toList

  }

  //get links count
  def getLinksCount(url: String): Int = {
    val links = getLinks(url)
    links.length
  }

}



//list of urls
val urls = List("http://www.cnn.com", "https://www.google.com/", "https://www.twitter.com/", "http://www.amazon.com/")


//get content
def getPageLinks() = {

  for(url <- urls) {
    val num = Page.getLinksCount(url)
    println(num);
  }
}

getPageLinks()

