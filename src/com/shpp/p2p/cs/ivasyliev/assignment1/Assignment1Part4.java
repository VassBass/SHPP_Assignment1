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
        // Karel puts the beeper to the first cell
        putBeeper();
        // Then he's trying to do next step
        tryToStep();
        say("Bee-boo-doo-bee-dap!");
    }

    /**
     * Karel checks is front is clear.
     * If front is clear, he's doing {@link #step()} and then repeats this action.
     * Otherwise, he checks that are next row is exist.
     * If next row is exists he's going to the next row and repeats this action.
     * If next row is NOT exists - mission is complete!
     *
     * @see #step()
     * @see #goToNextRow()
     */
    private void tryToStep() throws Exception {
        if (frontIsClear()) {
            step();
            tryToStep();
        } else {
            if ((facingEast() && leftIsClear()) || (facingWest() && rightIsClear())) {
                goToNextRow();
                tryToStep();
            }
        }
    }

    /**
     * Karel looks in the cell where he is standing,
     * and if he does not see the beeper - he moves forward and puts the beeper in the next cell,
     * otherwise - only moves forward.
     * @throws Exception if Kernel hits a wall (try not to do this, it hurts)
     */
    private void step() throws Exception {
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
    private void goToNextRow() throws Exception {
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
