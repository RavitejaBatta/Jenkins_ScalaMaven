import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Spec_Test extends AnyFlatSpec with Matchers {

  it should "match" in {
    assert(10 == MyUtil.divide(30, 3))
  }

  it should "match2" in {
    assert(15 == MyUtil.divide(30, 2))
  }

}
