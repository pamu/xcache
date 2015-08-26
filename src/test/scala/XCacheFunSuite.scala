import com.pamu_nagarjuna.xcache.XCache
import org.scalatest.FunSuite

/**
 * Created by pnagarjuna on 26/08/15.
 */
class XCacheFunSuite extends FunSuite {
  test("testing get operation on Cache") {
    val cache = new XCache[Int, Int](1000)
    cache put(1, 2)
    assert(cache.get(1) == 2)
  }
}
