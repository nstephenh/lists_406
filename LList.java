import javax.swing.*;
import java.util.Iterator;

public class LList<E> implements IList<E>
{

    private Link<E> start;
    public LList()
    {
        start = null;
    }
    /**
     * @param newItem new item to be added to the end
     * of the list.
     */
    public void add(E newItem)
    {
        System.out.println(size());
        if (size()==0) {
            start = new Link<>(newItem, null);
            return;
        }
        add(size(), newItem);
    }
    /**
     * @param k The index at which the new item is
     * to be inserted
     * @param newItem new item to be added to the end
     * of the list.
     */
    public void add(int k, E newItem)
    {
        if (k==0) {
            start = new Link<>(newItem, start);
            return;
        }
        Link<E> useMe = start;
        for(int i = 0; i < k-1; i++){
            useMe = useMe.getNext();
        }
        useMe.setNext(new Link<E>(newItem, useMe.getNext()));
    }
    /**
     * @param k is the index
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * @return the item at index k  in this list.
     */
    public E get(int k)
    {
        Link<E> currentLink = start;
        for(int j = 0; j <= k; j++) {
            //System.out.print(currentLink);
            try {
                currentLink = currentLink.getNext();
            }catch(NullPointerException done){
                return currentLink.getDatum();
            }
        }
        return null;
    }
    /**
     * This method sets the item at index k to have value newValue.
     * @param k an index
     * @return the object evicted in this process
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * 
     */
    public E set(int k, E newValue)
    {
        return null;
    }
    /**
     * This rifles the list for the object <code>o</code>
     * @param o the item we are seeking
     * @return true if an object equal to <code> is</code>
     * found. Equality is established via <code>E</code>'s
     * <code>equals</code> method.
     */
    public boolean contains(Object o)
    {
        return false;
    }
    /**
     * This returns the number of items stored in this list.
     * @return the number of items in this list
     */
    public int size()
    {
        int i = 0;
        Link<E> currentLink = start;
        while (true){
            try {
                currentLink = currentLink.getNext();
            }catch(NullPointerException done){
                return i;
            }
            i++;
        }
    }
    /**
     * This creates a new list containing all entries starting
     * at <code>startIndex</code> and ending at <code>endIndex</code>.
     * @param startIndex the index our sublist starts with 
     * @param endIndex the index our sublist ends with 
     * @return the indicated sublist
     * @throws IndexOutOfBoundsException either index is out
     * of bounds.
     */
    public IList<E> subList(int startIndex, int endIndex) 
    {
        return null;
    }
    public Iterator<E> iterator()
    {
        return null;
    }

    public static void main(String[] args) {
        final int TEST = 20;
        IList<String> theStack = new LList<String>();
        for (int k = 0; k < TEST; k++) {
            theStack.add("" + k);
            System.out.print(k + " ");
        }
        /*System.out.println(theStack.size());
        System.out.println(theStack.size() == TEST ? "PASS" : "FAIL");
        for (int k = 0; k < 2; k++) {
            System.out.print(theStack.get(k) + " ");
        }*/
        /*System.out.println();
        for (String s : theStack) {
            System.out.print(s + " ");
        }
        System.out.println();


        theStack.add(10, "dek");
        theStack.add(11, "el");
        theStack.set(12, "doe");
        System.out.println();
        for (int k = 0; k < theStack.size(); k++) {
            System.out.print(theStack.get(k) + " ");
        }
        System.out.println();

        IList<String> dozenalNames = theStack.subList(10, 12);
        for (String s : dozenalNames) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(theStack.contains("19"));*/
    }
}
//Link from LStack
class Link<T>
{
    private T datum;
    private Link<T> next;
    public Link(T datum, Link<T> next)
    {
        this.datum = datum;
        this.next = next;
    }
    public Link(T datum)
    {
        this(datum, null);
    }
    public T getDatum()
    {
        return datum;
    }
    public void setNext(Link<T> nexte){
        next = nexte;
    }
    public Link<T> getNext()
    {
        return next;
    }
    public String toSting(){
        return datum.toString() + " , " + next.toString();
    }
}