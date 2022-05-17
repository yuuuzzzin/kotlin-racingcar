package car.domain

import car.domain.vo.Name
import car.domain.vo.Position

class Car(
    val name: Name,
    position: Position
) {
    var position: Position = position
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase()
        }
    }

    fun isWinner(winnerPosition: Position): Boolean = position == winnerPosition
}