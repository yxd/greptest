package sgrep

import java.io._

object Main {
  
  def main(args: Array[String]) {
    if(args.size != 2) {
      System.err.println("Usage: sgrep [word] [folder]")
      System.exit(-1)
    }
    
    val dir = new File(args(1))
    if(!dir.isDirectory()) {
      System.err.println("Error: " + dir + " is not a directory")
      System.exit(-2)
    }
    
    val grep = new Grep(args(0))
    grep.exec(dir)
    
  }
}