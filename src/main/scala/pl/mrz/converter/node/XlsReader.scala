package pl.mrz.converter.node

import java.io.File
import org.apache.poi.ss.usermodel.{CellType, WorkbookFactory}
import scala.util.Try
import scala.collection.JavaConverters._

object XlsReader {

  def parseXlsToReadObjectList(file: File): Either[Throwable, List[ReadObject]] = {
    Try(WorkbookFactory.create(file))
      .map { workbook =>
        workbook.close()
        workbook.getSheetAt(0)
      }
      .map(_.rowIterator()
        .asScala
        .drop(1)
        .map(row => row.cellIterator()
          .asScala
          .zipWithIndex
          .filter(_._1.getCellType == CellType.STRING)
          .map {
            case (cell, depth) => (cell.getStringCellValue, depth)
          }
          .find {
            case (cell, _) => cell.nonEmpty
          }
          .map {
            case (cell, depth) =>
              ReadObject(row.getCell(row.getLastCellNum - 1).getNumericCellValue.toInt, depth, cell)
          }
        )
        .filter(_.isDefined)
        .map(_.get)
        .toList
      )
      .toEither
  }
}
