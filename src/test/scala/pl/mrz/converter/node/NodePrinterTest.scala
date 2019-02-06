package pl.mrz.converter.node

import org.scalatest.{GivenWhenThen, Matchers, WordSpec}

class NodePrinterTest extends WordSpec with Matchers with GivenWhenThen {
  "NodePrinter" should {
    "return json-stringified case class" in {
      Given("list of nodes")
      val list = List(Node(1, "A", List(Node(2, "AA", Nil))), Node(3, "B", Nil))

      When("list is stringified to json")
      val json = NodePrinter.nodesToJson(list)

      Then("correct json should be formed")
      json shouldEqual """|[
                          | {
                          |  "id": 1,
                          |  "name": "A",
                          |  "nodes": [
                          |   {
                          |    "id": 2,
                          |    "name": "AA"
                          |   }
                          |  ]
                          | },
                          | {
                          |  "id": 3,
                          |  "name": "B"
                          | }
                          |]""".stripMargin
    }
  }
}
