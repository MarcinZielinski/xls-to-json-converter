package pl.mrz.converter

import java.io.File

import pl.mrz.converter.node.{NodeConverter, NodePrinter, XlsReader}

object Application extends App {
  override def main(args: Array[String]): Unit = {
    XlsReader.parseXlsToReadObjectList(new File(getClass.getResource("test1.xlsx").toURI))
      .map(NodeConverter.convertToNodeList)
      .foreach(NodePrinter.printToOut)
  }
}
