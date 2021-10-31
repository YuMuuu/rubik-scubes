package rubikcube

//ルービックキューブのLensの定義
object RubicLens:
  import monocle.Lens

  val _face1 =
    Lens[Rubik, Face](_.f1)(face => r => r.copy(f1 = face))
  val _face2 =
    Lens[Rubik, Face](_.f2)(face => r => r.copy(f2 = face))
  val _face3 =
    Lens[Rubik, Face](_.f3)(face => r => r.copy(f3 = face))
  val _face4 =
    Lens[Rubik, Face](_.f4)(face => r => r.copy(f4 = face))
  val _face5 =
    Lens[Rubik, Face](_.f5)(face => r => r.copy(f5 = face))
  val _face6 =
    Lens[Rubik, Face](_.f6)(face => r => r.copy(f6 = face))

  val _panel1 =
    Lens[Face, Panel](_.p1)(panel => f => f.copy(p1 = panel))
  val _panel2 =
    Lens[Face, Panel](_.p2)(panel => f => f.copy(p2 = panel))
  val _panel3 =
    Lens[Face, Panel](_.p3)(panel => f => f.copy(p3 = panel))
  val _panel4 =
    Lens[Face, Panel](_.p4)(panel => f => f.copy(p4 = panel))
  val _panel5 =
    Lens[Face, Panel](_.p5)(panel => f => f.copy(p5 = panel))
  val _panel6 =
    Lens[Face, Panel](_.p6)(panel => f => f.copy(p6 = panel))
  val _panel7 =
    Lens[Face, Panel](_.p7)(panel => f => f.copy(p7 = panel))
  val _panel8 =
    Lens[Face, Panel](_.p8)(panel => f => f.copy(p8 = panel))
  val _panel9 =
    Lens[Face, Panel](_.p9)(panel => f => f.copy(p9 = panel))
