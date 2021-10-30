package rubikcube

// 回転記号を表す
//ref: https://tribox.com/3x3x3/solution/notation/
object TurnSymbols:
  enum TurnSymbols:
    case U, Ud, U2, Uw, F, Fd, F2, Fw, R, Rd, R2, Rw, D, Dd, D2, Dw, B, Bd, B2,
    Bw, L, Ld, L2, Lw, M, Md, E, Ed, S, Sd, X, Xd, Y, Yd, Z, Zd
