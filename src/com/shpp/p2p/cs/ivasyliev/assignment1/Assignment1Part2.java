package com.shpp.p2p.cs.ivasyliev.assignment1;

/**
 * Карел був найнятий, щоб вибудувати стрункі ряди камінчиків.
 *
 * | xxx xxx xxx |
 * |xx xxx xxx xx|
 * |x   x   x   x|
 * |1       1   1|
 * |1   1        |
 * |        1   1|
 * |    1        |
 * |>   1       1|
 * … кожен “стовп” (якщо уявити що ми дивимось на карту зверху та бачимо якусь будівлю із колонами що “намальовані” біперами)
 * повинен стати цілісним і містити п’ять (для наведеного прикладу) камінчиків (біперів).
 * Вам варто врахувати, що фінальне положення і напрямок погляду Карела не важливе, але тим не менш, потрібно враховувати наступне:
 * - Карел стартує в південно-західному куті і дивиться на схід, і у нього повно біперів у рюкзаку;
 * - Колони завжди знаходяться на 1му, 5му, 9му рядку і т.д., остання колона буде впритул до краю рівня, відстань між колонами завжди однакова;
 * - Колон може бути багато, а не 4 як в прикладі. Може, наприклад, бути всього одна колона (світ розміром 1х8);
 * - Верх колони відзначений стіною, і не варто розраховувати, що всі колони мають висоту п’ять, і не варто думати, що всі колони мають однакову висоту, проте стартують завжди з “підлоги” на одному рівні;
 * - Не можна класти біпери там, де вони вже лежать.
 */
public class Assignment1Part2 extends VassBassKarel {

    @Override
    public void run() throws Exception {
        //Karel builds the first column, then tries to move on to the next one
        buildColumn();
        while (frontIsClear()) {
            for (int s = 0; s < 4; s++) move();
            buildColumn();
        }
    }

    /**
     * Makes Karel build a column until he hits the wall.
     * Then he returns to the base of the column.
     */
    private void buildColumn() throws Exception {
        turnLeft();
        putBeeperAndMove();
    }

    /**
     * If there is no beeper in the cell where Karel is standing, he puts it on.
     *
     * Then he looks forward and if he does not see the wall, he moves one cell and repeats this action,
     * otherwise he goes to the base of column
     */
    private void putBeeperAndMove() throws Exception {
        if (noBeepersPresent()) putBeeper();
        if (frontIsClear()) {
            move();
            putBeeperAndMove();
        } else {
            goBack();
        }
    }

    /**
     * Karel turns around and moves forward until he hits the wall.
     * Then he turns left.
     */
    private void goBack() throws Exception {
        turnAround();
        while (frontIsClear()) move();
        turnLeft();
    }
}
