package com.shpp.p2p.cs.ivasyliev.assignment1;

/**
 * У цьому завданні Карелу доручили створити “шахівницю” за допомогою біпера в прямокутному
 * (про всяк випадок будь-ласка загугліть що таке прямокутник 😃 ) пустому Світі (фінальне положення і напрямок Карела не важливі).
 *
 * Вам явно потрібно буде переконатися, що ваш код вирішує завдання з світами відмінними від 8х8, наприклад, 3х5 і т.д.
 * Важливо, щоб один з поставлених біперів знаходився у південно-західному куті карти.
 *
 * Карел починає завжди з південно-західного кута, дивлячись на схід, + також передбачається, що світ чистий від біперів і стін.
 *
 * Не забувайте, що рівні також можуть бути 1 квадратик в ширину або навпаки: всього 1 квадратик у висоту.
 * Це завдання можна вирішувати різними способами, і одні істотно легше ніж інші.
 *
 * По суті, немає нічого страшного в тому, що Карел ходитиме по тим доріжкам, де вже ходив — не намагайтеся вигадувати якийсь “оптимізований” алгоритм.
 */
public class Assignment1Part4 extends VassBassKarel {

    @Override
    public void run() throws Exception {
        moveToStartCell();
        // Karel puts the beeper to the first cell
        putBeeper();
        // Then he's trying to do next step
        tryToStep();
        say("Bee-boo-doo-bee-dap!");
    }

    /**
     * Karel moves to cell in south-west and turns to east
     */
    public void moveToStartCell() throws Exception {
        turnToWest();
        while (frontIsClear()) move();
        turnLeft();
        while (frontIsClear()) move();
        turnLeft();
    }

    public void tryToStep() throws Exception {
        // Check if Karel can go forward
        if (frontIsClear()) {
            // If he can - he's doing a step and repeats this action
            step();
            tryToStep();
        } else {
            // If he can't - he checks that are next row is exist
            if ((facingEast() && leftIsClear()) || (facingWest() && rightIsClear())) {
                // If exist - he's going to the next row and repeats this action
                goToNextRow();
                tryToStep();
            }
            // If the next row does not exist - the mission is complete!
        }
    }

    /**
     * Karel looks in the cell where he is standing,
     * and if he does not see the beeper - he moves forward and puts the beeper in the next cell,
     * otherwise - only moves forward.
     * @throws Exception if Kernel hits a wall (try not to do this, it hurts)
     */
    public void step() throws Exception {
        if (beepersPresent()) {
            move();
        } else {
            move();
            putBeeper();
        }
    }

    /**
     * Karel looks in the cell where he is standing,
     * and if he does not see the beeper - he moves to the next row and puts the beeper in the next cell,
     * otherwise - only moves to the next row.
     * @throws Exception if Kernel hits a wall (try not to do this, it hurts)
     */
    public void goToNextRow() throws Exception {
        if (facingEast()) {
            turnLeft();
            step();
            turnLeft();
        } else if (facingWest()) {
            turnRight();
            step();
            turnRight();
        }
    }
}
