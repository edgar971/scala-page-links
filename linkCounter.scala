import scala.io._
import scala.actors._
import Actor._


//Page object
object Page {

  //get raw content as text.
  def getContent(url: String) = Source.fromURL(url).mkString

  //get links as a list. Returns a list of strings.
  def getLinks(url: String): List[String] = {

    //get the page content
    val content = this.getContent(url)

    //regular expression to find links
    val linkReg = "<a[^>]* href=\"([^\"]*)\"".r

    //get matches and create a list
    linkReg.findAllIn(content).toList

  }

  //get links count as an int.
  def getLinksCount(url: String): Int = {
    val links = this.getLinks(url)
    links.length
  }

}

//list of urls
val urls = List("http://www.cnn.com", "https://www.google.com/", "https://www.twitter.com/", "http://www.amazon.com/")

//get content
def getPageLinks() = {
  //for each url in list
  for(url <- urls) {

    //get the number of links
    val num = Page.getLinksCount(url)

    //print the results
    println(num);
  }
}

//call the function
getPageLinks()

