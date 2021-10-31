package rubikcube

import rubikcube.RubicLens.*
import rubikcube.TurnSymbols._
import monocle.syntax.all.*

//face4を正面とするrubiccubeの操作を行う
//todo: executeってなんか副作用がありそうだし、良い命名を考える
object RubikExecutor:
  def rubicExecutor(rubik: Rubik, ts: TurnSymbols): Rubik = ts match 
      case TurnSymbols.R => turnR(rubik)
      case _ => ??? //ここに他の回転も実装する 


  def turnR(rubik: Rubik): Rubik =
    rubik
      .focus(_.f3.p9)
      .replace((_face6 ^|-> _panel9) get rubik)
      .focus(_.f3.p6)
      .replace((_face6 ^|-> _panel6) get rubik)
      .focus(_.f3.p3)
      .replace((_face6 ^|-> _panel3) get rubik)
      .focus(_.f5.p9)
      .replace((_face3 ^|-> _panel9) get rubik)
      .focus(_.f5.p6)
      .replace((_face3 ^|-> _panel6) get rubik)
      .focus(_.f5.p3)
      .replace((_face3 ^|-> _panel3) get rubik)
      .focus(_.f1.p1)
      .replace((_face5 ^|-> _panel9) get rubik)
      .focus(_.f1.p4)
      .replace((_face5 ^|-> _panel6) get rubik)
      .focus(_.f1.p7)
      .replace((_face5 ^|-> _panel3) get rubik)
      .focus(_.f6.p9)
      .replace((_face1 ^|-> _panel1) get rubik)
      .focus(_.f6.p6)
      .replace((_face1 ^|-> _panel4) get rubik)
      .focus(_.f6.p3)
      .replace((_face1 ^|-> _panel7) get rubik)
      .focus(_.f4.p7)
      .replace((_face4 ^|-> _panel9) get rubik)
      .focus(_.f4.p4)
      .replace((_face4 ^|-> _panel8) get rubik)
      .focus(_.f4.p1)
      .replace((_face4 ^|-> _panel7) get rubik)
      .focus(_.f4.p2)
      .replace((_face4 ^|-> _panel4) get rubik)
      .focus(_.f4.p3)
      .replace((_face4 ^|-> _panel1) get rubik)
      .focus(_.f4.p6)
      .replace((_face4 ^|-> _panel2) get rubik)
      .focus(_.f4.p9)
      .replace((_face4 ^|-> _panel3) get rubik)
      .focus(_.f4.p8)
      .replace((_face4 ^|-> _panel6) get rubik)