import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

/**
 * Write a description of class DequeCyclic here.
 *
 * @author (Muhammad Maaz Ahmed 22436686)
 * @version (1.0)
 */
public class DequeCyclic implements Deque
{ 
    private int front;
    private int rear;
    Object[] queue;
    private int currentSize; //number of elements present in queue
    private int maxSize;

    /**
     * create an empty deque 
     */
    public DequeCyclic(int size)
    {
        front=0;
        rear =0;
        maxSize=size;
        currentSize=0;
        queue= new Object[maxSize];

    }

    /**
     * return true iff the deque is empty, false otherwise.
     *
     * 
     * @return  bool
     */
    public boolean isEmpty()
    {
        if(currentSize==0){

            return true;
        }
        return false;
    }

    /**
     * return true iff the deque is Full, false otherwise.
     *
     * 
     * @return  bool
     */
    public boolean isFull()
    {
        if(currentSize==maxSize){

            return true;
        }
        return false;
    }

    /**
     * add object c as the left-most object in the deque, 
     * or throw an Overflow exception if the deque is full.
     */
    public void pushLeft(Object c)
    {

        if(isFull()){
            throw new Overflow("queue is full");
        }else if (front == 0 && rear==0 && currentSize==0){
            queue[0]=c;

        }else if(front ==0){
            front=queue.length-1;
            queue[front]=c;

        }else{
            front--;
            queue[front]=c;

        }
        currentSize++;
    }

    /**
     * add object c as the right-most object in the deque, 
     * or throw an Overflow exception if the deque is full. 
     */
    public void pushRight(Object c)
    {
        if(isFull()){
            throw new Overflow("queue is full");
        }else if (front == 0 && rear==0 && currentSize==0){
            queue[0]=c;

        }
        else{
            rear=(rear+1)%queue.length;
            queue[rear]=c;

        }
        currentSize++;
    }

    /**
     * return the left-most object in the deque,
     * or throw an Underflow exception if the deque is empty.
     * 
     * @return  Object
     */
    public Object peekLeft()
    {

        if(isEmpty()){
            throw new Underflow("queue is empty");
        }
        return queue[front];
    }

    /**
     * return the right-most object in the deque,
     * or throw an Underflow exception if the deque is empty.
     * @return  Object
     */
    public Object peekRight()
    {
        if(isEmpty()){
            throw new Underflow("queue is empty");
        }
        return queue[rear];
    }

    /**
     * remove and return the left-most object in the deque,
     * or throw an Underflow exception if the deque is empty.
     *
     * 
     * @return  Object
     */
    public Object popLeft(){
        Object o= peekLeft();
        if(isEmpty()){
            throw new Underflow("queue is empty");
        }else{
            if(front==maxSize-1){
                front=0;
            }else{
                front++;
            }

        }
        currentSize--;
        return o;
    }

    /**
     * remove and return the right-most object in the deque,
     * or throw an Underflow exception if the deque is empty.
     *
     * 
     * @return  Object
     */
    public Object popRight(){
        Object o= peekRight();
        if(isEmpty()){
            throw new Underflow("queue is empty");
        }else if (rear == 0) {
            rear = maxSize-1;
        }
        else {

            rear--;
        }


        currentSize--;
        return o;
    }

}
