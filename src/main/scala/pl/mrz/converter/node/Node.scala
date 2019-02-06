package pl.mrz.converter.node

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import com.github.plokhotnyuk.jsoniter_scala.macros.{CodecMakerConfig, JsonCodecMaker}

case class Node(id: Int, name: String, nodes: List[Node])

object Node {
  implicit val codec: JsonValueCodec[List[Node]] = JsonCodecMaker.make[List[Node]](CodecMakerConfig(allowRecursiveTypes = true))
}