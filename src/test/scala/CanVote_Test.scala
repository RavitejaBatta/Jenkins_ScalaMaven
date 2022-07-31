
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CanVote_Test extends AnyFlatSpec with Matchers{

  it should "Vote" in {
    assert(true == MyUtil.canVote(20))
  }

  it should "Vote2" in {
    assert(false == MyUtil.canVote(15))
  }
}
