package pl.mrz.converter.node

import scala.collection.mutable.ListBuffer

object NodeConverter {
  def convertToNodeList(objects: List[ReadObject]): List[Node] = {
    val readObjectsList: ListBuffer[ReadObject] = ListBuffer() ++= objects

    def getChildrenOfDepth(depth: Int): List[Node] = {
      val nodesOfTheSameDepth = ListBuffer[Node]()
      var currentReadObject = popFirstElement

      while (currentReadObject.isDefined && currentReadObject.get.depth == depth) {
        nodesOfTheSameDepth += Node(currentReadObject.get.id, currentReadObject.get.content, getChildrenOfDepth(depth + 1))
        currentReadObject = popFirstElement
      }
      appendToListBeginning(currentReadObject)
      nodesOfTheSameDepth.toList
    }

    def popFirstElement: Option[ReadObject] = {
      val firstReadObject = readObjectsList.headOption
      firstReadObject.foreach(_ => readObjectsList.remove(0))
      firstReadObject
    }

    def appendToListBeginning(currentReadObject: Option[ReadObject]): Unit =
      currentReadObject.foreach(readObjectsList.prepend(_))

    getChildrenOfDepth(0)
  }
}
