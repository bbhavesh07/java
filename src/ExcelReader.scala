/*
import java.io.{File, FileInputStream}
import org.apache.poi.ss.usermodel.{Cell, DateUtil, Row}
import org.apache.poi.xssf.usermodel.{XSSFSheet, XSSFWorkbook}


object ExcelReader{

  def unusedSlices(): Unit = {
    val excelName: String = "C:\\Actimize\\svn\\fraud_framework\\MyWork\\PI16\\profiles cleanup\\Final_Slices_Analysis.xlsx"
    val file = new FileInputStream(new File(excelName))
    val workbook = new XSSFWorkbook(file)

    val entityProfileSheet = workbook.getSheet("FF_entityProfile")

    // print(entityProfileSheet)

    var usedSlices:List[List[String]] = List();

    for (i <- 0 until entityProfileSheet.getLastRowNum)
      if (i != 0) {
        val row = entityProfileSheet.getRow(i);
        if (row != null) {
          if (row.getCell(3) != null && !row.getCell(3).getRichStringCellValue.getString.isEmpty){
            usedSlices +: row.getCell(3).getRichStringCellValue.getString.split(',').toList
          }
        }
      }
    print(usedSlices)
  }


  def main(args: Array[String]): Unit = {
    unusedSlices()
  }
}*/

object solution {
  def solve(s: String,t: String) :String = {
    var i = 0
    for(c <- t){
      i = s.indexOf(c, i)
      if(i == -1) {
        return "NO"
      }
    }
    return "YES"
  }
  def main(args: Array[String]): Unit = {
    val in = scala.io.StdIn
    val n = in.readInt()
    for (_ <- 0 until n) {
      val s = in.readLine()
      val t = in.readLine()
      println(solve(s, t))
    }
  }
}
