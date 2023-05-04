package com.shpp.p2p.cs.ivasyliev.assignment1;

/**
 * Завдання на рішення алгоритмічних проблем:
 * запрограмуйте, будь ласка, Карела на пошук центру південної смуги
 * (він на ній з’являється з самого початку)
 *
 * |     |
 * |     |
 * |     |
 * |     |
 * |> 1  |
 * … тут одиницею відзначено місце, куди Карелу потрібно буде поставити біпер.
 * Фінальний вигляд рівня повинен бути з єдиним біпером по центру південної смуги.
 * Карелу можна розкидати додаткові біпери, але йому потрібно підібрати їх перед тим, як він вважатиме, що завдання виконане.
 * У рішенні проблеми варто розраховувати на такі факти про світ:
 * - Карел починає в південно-західному куті і дивиться на схід, у нього повно біперів в рюкзаку;
 * - В світі немає ні біперів, ні стін;
 * - Світ може не бути квадратним, але він, принаймні, настільки високий, наскільки широкий.
 *
 * Ваша програма, в принципі, може допускати таке:
 * - Якщо ширина світу непарна, то Карелу потрібно покласти біпер в центральну клітинку,
 *      інакше ж потрібно покласти в одну з двох центральних осередків;
 * - Не важливо, куди дивиться Карел після того, як він закінчить свій забіг.
 */
public class Assignment1Part3 extends VassBassKarel {

    @Override
    public void run() throws Exception {
        //moveToStartPoint();

        putBeeper();
        if (frontIsClear()) {
            move();
//            altStep();
            step();
        }

        //say("Beep-boop-boop-beeeeeee!");
    }

    public void step() throws Exception {
        if (beepersPresent()) {
            pickBeeper();
            turnAround();
            if (frontIsClear()) {
                move();
                if (noBeepersPresent()) {
                    putBeeper();
                    if (frontIsClear()) move();
                    step();
                }
            } else {
                putBeeper();
            }
        } else {
            if (frontIsClear()) {
                move();
                step();
            } else {
                putBeeper();
                turnAround();
                if (frontIsClear()) {
                    move();
                    step();
                }
            }
        }
    }

    public void altStep() throws Exception {
        if (frontIsClear()) {
            if (noBeepersPresent()) {
                move();
                altStep();
            } else {
                turnLeft();
                if (leftIsClear()) {
                    turnLeft();
                    pickBeeper();
                    move();
                    if (noBeepersPresent()){
                        putBeeper();
                        if (frontIsClear()) {
                            move();
                            altStep();
                        }
                    }
                }
            }
        } else {
            if (noBeepersPresent()) {
                turnLeft();
                if (leftIsClear()) {
                    turnLeft();
                    putBeeper();
                    move();
                    if (noBeepersPresent()) {
                        altStep();
                    } else {
                        pickBeeper();
                    }
                }
            } else {
                turnLeft();
                if (leftIsClear()) {
                    turnLeft();
                    pickBeeper();
                    move();
                    if (noBeepersPresent()) {
                        putBeeper();
                        if (frontIsClear()) {
                            move();
                            altStep();
                        }
                    }
                }
            }
        }
    }

    public void moveToStartPoint() throws Exception {
        turnToWest();
        while (frontIsClear()) move();
        turnLeft();
        while (frontIsClear()) move();
        turnLeft();
    }
}
