import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Illustrates the generics/immutability question in Q5(d).
 *
 * The original (non-generic) record-list class could guarantee immutability
 * simply by never exposing a setter and by returning defensive copies.
 * Once it becomes generic (TxnList<T>), T could itself be a MUTABLE object
 * (e.g. a mutable Transaction with public setters, or an array). Even if
 * TxnList never lets you replace an element in the list, callers can still
 * grab a reference to an element via get() and mutate its internal state
 * directly - breaking immutability from "outside" the list, something the
 * original type-specific class may not have been vulnerable to if its
 * single element type was already immutable.
 *
 * Remedy: make T bounded/controlled - e.g. require T to be immutable,
 * or have TxnList store/return defensive copies (clones) of T on both
 * add() and get()), so external code can never hold a mutable reference
 * to the internal state.
 */
public class TxnList<T> {

    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index); // returns the SAME reference - risk if T is mutable
    }

    public List<T> asUnmodifiableList() {
        return Collections.unmodifiableList(items);
    }

    public int size() {
        return items.size();
    }
}
