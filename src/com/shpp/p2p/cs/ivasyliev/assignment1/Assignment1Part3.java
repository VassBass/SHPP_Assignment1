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

    /**
     * IMPORTANT!
     * If your world width is > 22 set actions_limit > 1000
     * If your world width is > 33 set actions_limit > 2000
     * I tested this Karel in world with max width 33 cells.
     *
     *  Karel first puts a beeper, then checks if the front is clear.
     *  If it's clear, he moves one cell and doing method "step".
     *
     * @see #step()
     */
    @Override
    public void run() throws Exception {
        putBeeper();
        if (frontIsClear()) {
            move();
            step();
        }
    }

    /**
     * Karel checks if beeper is present in cell where he stands.
     * If beeper is present, he narrows the path between beepers.
     * Otherwise, he tries to go next.
     */
    private void step() throws Exception {
        if (beepersPresent()) {
            searchNarrowing();
        } else {
            searchTheEnd();
        }
    }

    /**
     * Karel turns around and checks is front is clear.
     * If front is NOT clear - mission is complete!
     * If front is clear, he picks beeper, moves one cell and checks if beeper is present.
     * If beeper is NOT present, he puts beeper, tries to move front and repeat method "step",
     * otherwise - he is in the middle.
     *
     * @see #step()
     */
    private void searchNarrowing() throws Exception {
        turnAround();
        if (frontIsClear()) {
            pickBeeper();
            move();
            if (noBeepersPresent()) {
                putBeeper();
                if (frontIsClear()) move();
                step();
            }
        }
    }

    /**
     * Karel checks is front is clear.
     * If front is clear, he moves one cell and repeat method "step".
     * If front is NOT clear, he puts beeper, turns around and check is front is clear now.
     * If front is NOT clear - mission is complete!
     * Otherwise, he moves one cell and repeat method "step"
     *
     * @see #step()
     */
    private void searchTheEnd() throws Exception {
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
