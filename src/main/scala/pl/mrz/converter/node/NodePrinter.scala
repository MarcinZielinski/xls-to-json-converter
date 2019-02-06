package pl.mrz.converter.node

import com.github.plokhotnyuk.jsoniter_scala.core.{WriterConfig, writeToString}

object NodePrinter {
  def printToOut(list: List[Node]): Unit =
    println(nodesToJson(list))

  private[node] def nodesToJson(list: List[Node]): String =
    writeToString(list, WriterConfig(indentionStep = 1))
}
