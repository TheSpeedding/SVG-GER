package svgger.util;

import java.util.ArrayList;

/** Copy of array list with new constructor suiting SVG-GER needs.
 * A grammar uses left-recursion to parse parameters, so something like this is needed.
 */
public class SvggerList<T> extends ArrayList<T> {
    /** Initializes an empty list. */
    public SvggerList() { }

    /**
     * Initializes a list with given item.
     * @param item First item in the list.
     */
    public SvggerList(T item) {
        add(item);
    }

    /**
     * Initializes a list containing of other list and a new item.
     * @param other List to copy.
     * @param item Item to append.
     */
    public SvggerList(SvggerList other, T item) {
        for (var x : other) add((T)x);
        add(item);
    }
}
