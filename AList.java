import java.util.Iterator;

public class AList<E> implements IList<E>
{
    private Object[] items;
    private int capacity;
    private int sz;
    public AList()
    {
        this(10);
    }
    public AList(int capacity)
    {
        this.capacity = capacity;
        sz = 0;
        items = new Object[capacity];
    }
    /**
     * @param newItem new item to be added to the end
     * of the list.
     */
    public void add(E newItem) {
        if (sz >= capacity){
            resizeArray();
        }
        items[sz] = newItem;
        sz++;

    }
    /**
     * @param k The index at which the new item is
     * to be inserted
     * @param newItem new item to be added at k
     */
    public void add(int k, E newItem)
    {
        if (k >= capacity){
            resizeArray();
        }
        shiftArray(1, k); //Includes sz ++
        items[k] = newItem;


    }
    /**
     * @param k the index
     * @throws IndexOutOfBoundsException if a nonexistent index
     * is passed to this method
     * @return the item at index k  in this list.
     */
    public E get(int k)
    {
        return (E) items[k];
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
        Object oldValue =  items[k];
        items[k] = newValue;
        return (E) oldValue;
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
        int i = 0;
        while (i <= sz){
            if (items[i].equals(o)){
                return true;
            }
            i++;
        }
        return false;
    }
    /**
     * This returns the number of items stored in this list.
     * @return the number of items in this list
     */
    public int size()
    {
        return sz;
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
        IList<E> newList = new AList<>(endIndex-startIndex);
        int i = 0;
        while (i <= endIndex-startIndex){
            newList.add((E) items[i+startIndex]);
            i++;
        }
        return newList;
    }
    public Iterator<E> iterator()
    {
        return new Navigator<E>();
    }

    //Functions borrowed from AStack
    class Navigator<T> implements Iterator<T>
    {
        private int loc;
        public Navigator()
        {
            loc = -1;
        }
        public boolean hasNext()
        {
            return !(loc+2 > sz);

        }
        @SuppressWarnings("unchecked")
        public T next()
        {
            loc++;                 //go to next
            return (T)items[loc];  //grab next
        }
    }

    private int resizePolicy(int oldSize) {
        return oldSize < 1000? 2*oldSize: 3*oldSize/2;
    }

    private void resizeArray() {
        //make a bigger array using the resize policy to size it
        Object[] newHouse = new Object[resizePolicy(items.length)];
        //move contents of old array in
        System.arraycopy(items, 0, newHouse, 0, items.length);
        //orphan old array

        items = newHouse;
        capacity = newHouse.length;
    }
    // This one is all mine (not from AStack)
    /**
     * This shifts all values in the array around for adding and deleting
     * @param shift how much to shift
     * @param pos the position in the array to shift at
     * @throws IndexOutOfBoundsException if pos < |shift|  and pos < 0 because you
     * would end up with a negative index and ain't nobody got time for that.
     */
    private void shiftArray(int shift, int pos){
        if (pos-shift < 0){ throw new IndexOutOfBoundsException();}
        if (sz + shift > capacity){
            resizeArray();
        }
        sz += shift;
        if (shift > 0){
            int i = sz-1;
            while (i >= pos) {
                // Shift values over starting at the back so you don't overwrite something
                items[i + shift] = items[i];
                i--;
            }
        }else{
            int i = pos;
            while (i < items.length) {
                // Shift values over starting at pos so you don't overwrite something
                items[i + shift] = items[i];
                i++;
            }
        }

        
    }
    public static void main(String[] args)
    {
        final int TEST  = 20;
        IList<String> theStack = new AList<String>();
        for(int k = 0; k < TEST; k++)
        {
            theStack.add("" + k);
            System.out.print(k + " ");
        }
        System.out.println(theStack.size() == TEST? "PASS":"FAIL");
        System.out.println();
        for(String s: theStack)
        {
            System.out.print(s  + " ");
        }
        System.out.println();

        for(int k = 0; k < TEST; k++)
        {
            System.out.print(theStack.get(k) + " ");
        }
        theStack.add(10, "dek");
        theStack.add(11, "el");
        theStack.set(12, "doe");
        System.out.println();
        for(int k = 0; k < theStack.size(); k++)
        {
            System.out.print(theStack.get(k) + " ");
        }
        System.out.println();

        IList<String> dozenalNames = theStack.subList(10, 12);
        for(String s: dozenalNames)
        {
            System.out.print(s  + " ");
        }
        System.out.println();
        System.out.println(theStack.contains("19"));
    }
}
