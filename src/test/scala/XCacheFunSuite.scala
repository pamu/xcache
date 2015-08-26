import java.util

import com.pamu_nagarjuna.xcache.XCache
import org.scalatest.FunSuite

/**
 * Created by pnagarjuna on 26/08/15.
 */
class XCacheFunSuite extends FunSuite {
  test("testing capacity") {
    val cache = new XCache[String, String](10000)
  }

  test("testing get/put operation on int Cache") {
    val cache = new XCache[Int, Int](1000)
    cache put(1, 2)
    assert(cache.get(1) == 2)
  }

  test("testing get/put operation with string types") {
    val cache = new XCache[String, String](1000)
    val emailStr = "myemail@gmail.com"
    cache put("email", emailStr)
    assert(cache.get("email") == emailStr)
  }

  test("testing get/put operation with object type") {
    import java.util.ArrayList
    val list = new util.ArrayList[Int]()
    val cache = new XCache[String, ArrayList[Int]](1000)
    val str = "prices"
    list add 100
    list add 200
    list add 300
    cache put(str, list)
    assert(cache.get(str).hashCode() == list.hashCode())
  }
}
