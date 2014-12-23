package sgrep

import java.io.File

class Grep (val word: String, val dir: File) {
  
  def exec() {
    println(visit(dir).mkString("\n"));
  }
  
  /**
   * Search word in the files in dir directory recursively
   * @param file the input file or directory
   * 
   */
  def visit(file: File): Array[String]  = {
    if(file.isDirectory()) {
      file.listFiles().foldLeft(Array[String]()) ( _ ++ visit(_) )
    } else if(file.isFile() && file.canRead() && grepFile(file)) {
      Array(file.getAbsolutePath)
    } else {
      Array()
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