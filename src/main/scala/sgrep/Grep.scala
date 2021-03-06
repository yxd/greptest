package sgrep

import java.io.File

class Grep (val word: String) {
  
  def exec(dir: File) {
    println(visit(dir).mkString("\n"));
  }
  
  /**
   * Search word in the files in dir directory recursively
   * @param file the input file or directory
   * 
   */
  def visit(file: File): List[String]  = {
    if(file == null) {
      List.empty
    } else if(file.isDirectory()) {
      val list = file.listFiles()
      if(list != null && list.size > 0)
        file.listFiles().foldLeft(List[String]()) ( _ ++ visit(_) )
      else
        List.empty
    } else if(file.isFile() && file.canRead() && grepFile(file)) {
      List(file.getAbsolutePath)
    } else {
      List.empty
    } 
  }
  
  /**
   * Search word in a file
   * @param file the input file
   * @return true if the file contains the word, false otherwise
   */
  def grepFile(file: File): Boolean = {
    try {
      scala.io.Source.fromFile(file)
        .getLines
        .flatMap(_.split("\\W+"))
        .exists { this.word == _ }
    } catch {
      case e: Exception => false
    }
  }

}
