package sgrep

import java.io.File

class Grep (val word: String, val dir: File) {
  
  def exec() {
    visit(dir);
  }
  
  /**
   * Search word in the files in dir directory recursively
   * @param file the input file or directory
   * 
   */
  private def visit(file: File): Unit = {
    if(file.isDirectory()) {
      file.listFiles().foreach { visit(_) }
    } else if(file.isFile() && file.canRead()) {
      if(grepFile(file)) {
        output(file)
      }
    } 
  }
  
  /**
   * Search word in a file
   * @param file the input file
   * @return true if the file contains the word, false otherwise
   */
  private def grepFile(file: File): Boolean = {
    try {
      scala.io.Source.fromFile(file)
        .getLines
        .flatMap(_.split("\\W+"))
        .exists { this.word == _ }
    } catch {
      case e: Exception => false
    }
  }

    
  private def output(file: File): Unit = {
    println(file.getAbsolutePath)
  }
  
}