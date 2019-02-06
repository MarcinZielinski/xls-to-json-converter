package pl.mrz.converter.node

import org.scalatest.{GivenWhenThen, Matchers, WordSpec}

class NodeConverterTest extends WordSpec with Matchers with GivenWhenThen {


  "NodeConverter" should {
    "convert list of ReadObjects into list of Nodes" in {
      Given("list of ReadObjects")
      val list = List(ReadObject(1, 0, "A"), ReadObject(2, 1, "AA"), ReadObject(3, 0, "B"))

      When("convert method invoked on that list")
      val res = NodeConverter.convertToNodeList(list)

      Then("result should be properly nested list of nodes")
      res shouldBe List(Node(1, "A", List(Node(2, "AA", Nil))), Node(3, "B", List()))
    }
  }
}
