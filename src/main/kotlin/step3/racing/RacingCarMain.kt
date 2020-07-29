package step3.racing

import step3.racing.car.Car
import step3.racing.const.HOW_MANY_CAR
import step3.racing.const.HOW_MANY_TURN
import step3.racing.printer.CarPrinter
import step3.racing.printer.CarPrinterImpl
import step3.racing.rule.CarMovementRule
import step3.racing.rule.CarMovementRuleImpl
import step3.racing.mock.ConsoleViewImpl
import step3.racing.mock.View
import step3.turn.Turn
import step3.turn.TurnImpl
import step3.turn.TurnManager

fun main() {
    val setup = GameSetupHelper()
    val rule: CarMovementRule = CarMovementRuleImpl()
    val view: View = ConsoleViewImpl()
    val printer: CarPrinter = CarPrinterImpl(view)
    val cars: List<Car> = setup.askHowManyCars(view.input(HOW_MANY_CAR))
    val turn: Turn = TurnImpl.create(cars, rule, printer)
    val turnManager: TurnManager = setup.askHowManyTurns(view.input(HOW_MANY_TURN), turn)

    RacingCarGame(view, turnManager).startRacing()
}