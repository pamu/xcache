import com.pamu_nagarjuna.xcache.XCache
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

/**
 * Created by pnagarjuna on 26/08/15.
 */
class XCacheWordSpec extends WordSpec with Matchers with MockitoSugar {
  "Calling isEmpty on the XCache" should {
    "return true when instantiated" in {
      val cache  = new XCache[Int, Int](100)
      cache.getCache.isEmpty shouldBe true
    }
  }

  "getting element from empty XCache" should {
    "return null when just instantiated" in {
      val cache = new XCache[String, String](100)
      cache.getCache.get("elem1") shouldBe null
    }
  }

  "getting an element which is least recently used" should {
    "return null" in {
      val cache = new XCache[String, String](3)
      cache put("elem1", "java")
      cache put("elem2", "scala")
      cache put("elem3", "c")

      cache put("elem4", "cpp") //elem4 should knockout elem1 as it is least recently used

      cache.get("elem1") shouldBe null
    }
  }

  "second time getting an element which is least recently used" should {
    "return null" in {
      val cache = new XCache[String, String](3)
      cache put("elem1", "java")
      cache put("elem2", "scala")
      cache put("elem3", "c")

      cache get("elem1")
      cache put("elem4", "cpp")

      cache.get("elem2") shouldBe null
    }
  }
}
