package com.shpp.p2p.cs.ivasyliev.assignment1;

/**
 * Припустимо, Карел живе в квадратному будинку. Карел починає в північно-західному куті свого будинку, і йому потрібно підібрати газетку,
 * яка лежить на порозі його будинку (як у фільмах, ага). Газетка, як і все в світі Карела — це біпер.
 * Після підбору газетки потрібно повернутися в початкове положення.
 *
 * |         |
 * |  xxxxx  |
 * |  x>  x  |
 * |  x    1 |
 * |  x   x  |
 * |  xxxxx  |
 * |         |
 * Це завдання разюче просте і створене, щоб ви якось почали щось кодити.
 * Вам буде корисно знати, що кожна частина світу виглядає прям як на малюнку.
 * Точно такий розмір будинку, двері в тій же позиції і біпер прямо за дверима.
 *
 * Отже, що вам потрібно:
 * -> рушити до газетки
 * -> підібрати її
 * -> повернутися в точку старту
 */
public class Assignment1Part1 extends VassBassKarel {

    @Override
    public void run() throws Exception {
        goPath();
        pickBeeperAndTurnBack();
        goPath();
    }

    /**
     * This causes Karel to move a trajectory between starting point and the location of the newspaper.
     * The direction of the passage depends on the direction of Karel's gaze.
     * @throws Exception if Kernel hits a wall (try not to do this, it hurts)
     */
    private void goPath() throws Exception {
        for (int s = 0; s < 2; s++) move();
        turnRight();
        move();
        turnLeft();
        for (int s = 0; s < 2; s++) move();
    }

    /**
     * What are you saying Karel? Nothing is clear but very interesting.
     */
    private void pickBeeperAndTurnBack() throws Exception {
        say("Bee-boo-boo-bep-bee-bee-boo.");
        if (beepersPresent()) pickBeeper();
        turnAround();
    }
}
