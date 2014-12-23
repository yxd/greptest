package sgrep

import org.scalatest.FunSuite
import java.io.File
import scala.io.Source

class GrepSpec extends FunSuite {
  def getTestFile(name: String): File = new File(getClass.getResource(name).toURI)
  
  test("grepFile() should return true if a file contains keyword") {
    val grep = new Grep("keyword");
    assert(grep.grepFile(getTestFile("/file_with_keyword.txt")))
  }
  
  test("grepFile() should return false if a file does not contain keyword") {
    val grep = new Grep("notakeyword");
    assert(!grep.grepFile(getTestFile("/file_with_keyword.txt")))
  }
    
  test("visit() should display file1, file11, file22, but not file2") {
    val root = getTestFile("/testroot").getAbsolutePath
    val grep = new Grep("test");
    val arr = grep.visit(getTestFile("/testroot"));
    
    assert(arr.exists(_.endsWith("file1.txt")))
    assert(arr.exists(_.endsWith("file11.txt")))
    assert(arr.exists(_.endsWith("file22.txt")))
    assert(!arr.exists(_.endsWith("file2.txt")))
  }
  
}