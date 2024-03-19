 class Node<T> {
    public Node<T> prev;
    public T val;
    public Node<T> next;
}


class DLList<T> {
public Node<T> first;
public Node<T> last;
public int length;
public int size()
{
return length;
}
// Constructor that generates an empty list
public DLList()
{
length = 0;
first = null;
last = null;
}
// Constructor that generates a list with a single element
public DLList(T e)
{
length = 1;
first = new Node<T>();
first.val = e;
last = first;
}
// Constructor that generates a list with two elements
public DLList(T e, T e2)
{
length = 2;
first = new Node<T>();
first.val = e;
last = new Node<T>();
last.val = e2;
first.next = last;
last.prev = first;
}
// Method that allows to display a DLList; use liberally to test your
// functions!
public String toString()
{
String res = "[";
Node<T> it = first;
if(it != null)
{
res += it.val;
it = it.next;
while(it != null)
{
res += ", " + it.val;
it = it.next;
}
}
return res + "]";
}
// QUESTION 1
public void push_back(T x)
{
// Your code goes here
Node<T> newNode = new Node<T>();
    newNode.val = x;
    if (length == 0) {
        first = newNode;
        last = newNode;
    } else {
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
    }
    length++;
}
// QUESTION 2
public void push_front(T x)
{
// Your code goes here
Node<T> newNode = new Node<T>();
    newNode.val = x;
    if (length == 0) {
        first = newNode;
        last = newNode;
    } else {
        newNode.next = first;
        first.prev = newNode;
        first = newNode;
    }
    length++;
}
// QUESTION 3
public T pop_front()
{
// Your code goes here
if (length == 0) {
    throw new RuntimeException("List is empty");
}
T val = first.val;
if (length == 1) {
    first = null;
    last = null;
} else {
    first = first.next;
    first.prev = null;
}
length--;
// The next line should be replaced by something sensible once you're done!
return val;
}
// QUESTION 4
public void concatenate(DLList<T> xs)
{
// Your code goes here
if (length == 0) {
    first = xs.first;
    last = xs.last;
    length = xs.length;
} else if (xs.length > 0) {
    if (last != null) {
        last.next = xs.first;
        xs.first.prev = last;
    }
    last = xs.last;
    length += xs.length;
}
}
// QUESTION 5
public T get(int idx)
{
// Your code goes here
if (idx < 0 || idx >= length) {
    throw new IndexOutOfBoundsException("Index out of bounds");
}
Node<T> it = first;
for (int i = 0; i < idx; i++) {
    it = it.next;
}
// The next line should be replaced by something sensible once you're done!
return it.val;
}
// QUESTION 6
public void insertAt(int idx, T x)
{
    if (idx < 0 || idx > length) {
        throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if (idx == 0) {
        push_front(x);
    } else if (idx == length) {
        push_back(x);
    } else {
        Node<T> newNode = new Node<T>();
        newNode.val = x;
        Node<T> it = first;
        for (int i = 0; i < idx - 1; i++) {
            it = it.next;
        }
        newNode.prev = it;
        newNode.next = it.next;
        it.next.prev = newNode;
        it.next = newNode;
        length++;
    }
}
// QUESTION 7
public void reverse(){
    if (length <= 1) {
        return;
    }
    Node<T> it = first;
    first = last;
    last = it;
    while (it != null) {
        Node<T> temp = it.prev;
        it.prev = it.next;
        it.next = temp;
        it = it.prev;
    }
}
}