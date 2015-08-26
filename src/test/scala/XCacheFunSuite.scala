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
    val list = new java.util.ArrayList[Int]()
    val cache = new XCache[String, ArrayList[Int]](1000)
    val str = "prices"
    list add 100
    list add 200
    list add 300
    cache put(str, list)
    assert(cache.get(str).hashCode() == list.hashCode())
  }

  test("testing cache size") {
    val cache = new XCache[Int, Int](1000)
    for(i <- 0 to 1000) cache put(i, i)
    assert(cache.getCache.size() == 1000)
  }

  test("testing cache size overflow") {
    val cache = new XCache[Int, Int](100)
    for(i <- 0 to 1000) cache put(i, i)
    assert(cache.getCache.size() == 100)
  }

  test("testing LRU behaviour") {
    val cache = new XCache[Int, Int](5)
    for(i <- 1 to 5) cache put(i, i)
    cache put(10, 10)
    cache put(20, 20)
    assert(cache.get(1) == 0)
  }

  test("Time taken per get/put operation in nanoseconds") {
    val million = 1000000
    val cache = new XCache[Int, Int](million)
    val start = System.nanoTime()
    var i = 0
    while (i < million) {
      cache put(i, i)
      i += 1
    }
    val stop = System.nanoTime()

    println(s"Time taken for put operation ${(stop - start) / million} nanoseconds")

    val startGet = System.nanoTime()
    var ig = 0
    while (ig < million) {
      cache get ig
      ig += 1
    }
    val stopGet = System.nanoTime()

    println(s"Time taken for get operation ${(stopGet - startGet) / million} nanoseconds")

    assert((stop - start)  > 0 && (stopGet - startGet) > 0)
  }
}
