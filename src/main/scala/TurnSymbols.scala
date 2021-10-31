package rubikcube

import cats.kernel.Group
// 回転記号を表す
//ref: https://tribox.com/3x3x3/solution/notation/
object TurnSymbols:
  enum TurnSymbols:
    case U, Ud, U2, Uw, F, Fd, F2, Fw, R, Rd, R2, Rw, D, Dd, D2, Dw, B, Bd, B2,
    Bw, L, Ld, L2, Lw, M, Md, E, Ed, S, Sd, X, Xd, Y, Yd, Z, Zd

//ルービックキューブの操作を表す
case class Turn(tls: Vector[TurnSymbols.TurnSymbols])

object TurnGroupInstance extends Group[Turn]:
  override def inverse(a: Turn): Turn = Turn(
    a.tls.reverse.flatMap(Vector.fill(3)(_))
  ) //turnsynbolは同じturnsynbolを3回行うと操作前に戻る
  override def empty: Turn = Turn(Vector.empty)
  override def combine(x: Turn, y: Turn): Turn = Turn(x.tls ++ y.tls)
