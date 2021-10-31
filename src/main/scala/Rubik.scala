package rubikcube

import rubikcube.Color.Color
import rubikcube.TurnSymbols.TurnSymbols

// ルービックキューブの1つ1つのパネルを表す
case class Panel(pos: Int, color: Color)

// ルービックキューブの面を表す
// | p1 | p2 | p3 |
// | p4 | p5 | p6 |
// | p7 | p8 | p9 |
case class Face(
    p1: Panel,
    p2: Panel,
    p3: Panel,
    p4: Panel,
    p5: Panel,
    p6: Panel,
    p7: Panel,
    p8: Panel,
    p9: Panel
)

// ルービックキューブを表す
//           | f5 |
// | f1 | f2 | f3 | f4 |
//           | f6 |
case class Rubik(
    f1: Face,
    f2: Face,
    f3: Face,
    f4: Face,
    f5: Face,
    f6: Face
):
  def execute(ts: TurnSymbols): Rubik = RubikExecutor.rubicExecutor(this, ts)
  def graphicView(): Unit = {
    val red = "\u001b[00;31m"
    val green = "\u001b[00;32m"
    val yellow = "\u001b[00;33m"
    val blue = "\u001b[00;34m"
    val orenge = "\u001b[38;5;208m"
    val white = "\u001b[00;37m"
    val end = "\u001b[00m" 

    def toUnixColor(color: Color): String = {
      color match
        case Color.Blue => blue
        case Color.Green => green
        case Color.Orange => orenge
        case Color.Red => red
        case Color.White => white
        case Color.Yellow => yellow
    }
    val str = {
      s"""|               ${toUnixColor(this.f5.p1.color)}■ ${toUnixColor(this.f5.p2.color)}■ ${toUnixColor(this.f5.p3.color)}■
          |               ${toUnixColor(this.f5.p4.color)}■ ${toUnixColor(this.f5.p5.color)}■ ${toUnixColor(this.f5.p6.color)}■
          |               ${toUnixColor(this.f5.p7.color)}■ ${toUnixColor(this.f5.p8.color)}■ ${toUnixColor(this.f5.p9.color)}■
          | ${toUnixColor(this.f1.p1.color)}■ ${toUnixColor(this.f1.p2.color)}■ ${toUnixColor(this.f1.p3.color)}■  ${toUnixColor(this.f2.p1.color)}■ ${toUnixColor(this.f2.p2.color)}■ ${toUnixColor(this.f2.p3.color)}■  ${toUnixColor(this.f3.p1.color)}■ ${toUnixColor(this.f3.p2.color)}■ ${toUnixColor(this.f3.p3.color)}■  ${toUnixColor(this.f4.p1.color)}■ ${toUnixColor(this.f4.p2.color)}■ ${toUnixColor(this.f4.p3.color)}■ 
          | ${toUnixColor(this.f1.p4.color)}■ ${toUnixColor(this.f1.p5.color)}■ ${toUnixColor(this.f1.p6.color)}■  ${toUnixColor(this.f2.p4.color)}■ ${toUnixColor(this.f2.p5.color)}■ ${toUnixColor(this.f2.p6.color)}■  ${toUnixColor(this.f3.p4.color)}■ ${toUnixColor(this.f3.p5.color)}■ ${toUnixColor(this.f3.p6.color)}■  ${toUnixColor(this.f4.p4.color)}■ ${toUnixColor(this.f4.p5.color)}■ ${toUnixColor(this.f4.p6.color)}■ 
          | ${toUnixColor(this.f1.p7.color)}■ ${toUnixColor(this.f1.p8.color)}■ ${toUnixColor(this.f1.p9.color)}■  ${toUnixColor(this.f2.p7.color)}■ ${toUnixColor(this.f2.p8.color)}■ ${toUnixColor(this.f2.p9.color)}■  ${toUnixColor(this.f3.p7.color)}■ ${toUnixColor(this.f3.p8.color)}■ ${toUnixColor(this.f3.p9.color)}■  ${toUnixColor(this.f4.p7.color)}■ ${toUnixColor(this.f4.p8.color)}■ ${toUnixColor(this.f4.p9.color)}■ 
          |               ${toUnixColor(this.f6.p1.color)}■ ${toUnixColor(this.f6.p2.color)}■ ${toUnixColor(this.f6.p3.color)}■
          |               ${toUnixColor(this.f6.p4.color)}■ ${toUnixColor(this.f6.p5.color)}■ ${toUnixColor(this.f6.p6.color)}■
          |               ${toUnixColor(this.f6.p7.color)}■ ${toUnixColor(this.f6.p8.color)}■ ${toUnixColor(this.f6.p9.color)}■
          |""".stripMargin
    }
    println(str + end)
  }

object Rubik:
// factoryで作成するルビっくキューブのmap
//                                         |37, G|38, G|39, G|
//                                         |40, G|41, G|42, G|
//                                         |43, G|44, G|45, G|
// |1 , Y|2 , Y|3 , Y| |10, R|11, R|12, R| |19, W|20, W|21, W| |28, O|29, O|30, O|
// |4 , Y|5 , Y|6 , Y| |13, R|14, R|15, R| |22, W|23, W|24, W| |31, O|32, O|33, O|
// |7 , Y|8 , Y|9 , Y| |16, R|17, R|18, R| |25, W|26, W|27, W| |34, O|35, O|36, O|
//                                         |46, B|47, B|48, B|
//                                         |49, B|50, B|51, B|
//                                         |52, B|53, B|54, B|
  def factory(): Rubik =
    Rubik(
      f1 = Face(
        p1 = Panel(1, Color.Yellow),
        p2 = Panel(2, Color.Yellow),
        p3 = Panel(3, Color.Yellow),
        p4 = Panel(4, Color.Yellow),
        p5 = Panel(5, Color.Yellow),
        p6 = Panel(6, Color.Yellow),
        p7 = Panel(7, Color.Yellow),
        p8 = Panel(8, Color.Yellow),
        p9 = Panel(9, Color.Yellow)
      ),
      f2 = Face(
        p1 = Panel(10, Color.Red),
        p2 = Panel(11, Color.Red),
        p3 = Panel(12, Color.Red),
        p4 = Panel(13, Color.Red),
        p5 = Panel(14, Color.Red),
        p6 = Panel(15, Color.Red),
        p7 = Panel(16, Color.Red),
        p8 = Panel(17, Color.Red),
        p9 = Panel(18, Color.Red)
      ),
      f3 = Face(
        p1 = Panel(19, Color.White),
        p2 = Panel(20, Color.White),
        p3 = Panel(21, Color.White),
        p4 = Panel(22, Color.White),
        p5 = Panel(23, Color.White),
        p6 = Panel(24, Color.White),
        p7 = Panel(25, Color.White),
        p8 = Panel(26, Color.White),
        p9 = Panel(27, Color.White)
      ),
      f4 = Face(
        p1 = Panel(28, Color.Orange),
        p2 = Panel(29, Color.Orange),
        p3 = Panel(30, Color.Orange),
        p4 = Panel(31, Color.Orange),
        p5 = Panel(32, Color.Orange),
        p6 = Panel(33, Color.Orange),
        p7 = Panel(34, Color.Orange),
        p8 = Panel(35, Color.Orange),
        p9 = Panel(36, Color.Orange)
      ),
      f5 = Face(
        p1 = Panel(37, Color.Green),
        p2 = Panel(38, Color.Green),
        p3 = Panel(39, Color.Green),
        p4 = Panel(40, Color.Green),
        p5 = Panel(41, Color.Green),
        p6 = Panel(42, Color.Green),
        p7 = Panel(43, Color.Green),
        p8 = Panel(44, Color.Green),
        p9 = Panel(45, Color.Green)
      ),
      f6 = Face(
        p1 = Panel(46, Color.Blue),
        p2 = Panel(47, Color.Blue),
        p3 = Panel(48, Color.Blue),
        p4 = Panel(49, Color.Blue),
        p5 = Panel(50, Color.Blue),
        p6 = Panel(51, Color.Blue),
        p7 = Panel(52, Color.Blue),
        p8 = Panel(53, Color.Blue),
        p9 = Panel(54, Color.Blue)
      )
    )