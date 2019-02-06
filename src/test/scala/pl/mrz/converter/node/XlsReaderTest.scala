package pl.mrz.converter.node

import java.io.{File, FileNotFoundException}

import org.scalatest.{GivenWhenThen, Matchers, WordSpec}

class XlsReaderTest extends WordSpec with Matchers with GivenWhenThen {
  "XlsReader" should {
    "transform xls into read objects" in {
      Given("xls file")
      val file = new File(getClass.getResource("xls-reader-test.xlsx").toURI)

      When("parse method invoked on that file")
      val result = XlsReader.parseXlsToReadObjectList(file)

      Then("returned read object list should be correct")
      result.right.get shouldEqual List(ReadObject(1, 0, "A"), ReadObject(2, 1, "AA"), ReadObject(3, 0, "B"))
    }

    "return FileNotFoundException when no file is present" in {
      Given("invalid file")
      val invalidFile = new File("")

      When("parse method invoked on that file")
      val result = XlsReader.parseXlsToReadObjectList(invalidFile)

      Then("exception should be returned")
      result.left.get shouldBe a [FileNotFoundException]
    }
  }
}
