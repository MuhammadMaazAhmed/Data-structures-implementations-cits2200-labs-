import CITS2200.Stack;
import CITS2200.Underflow;
import CITS2200.Overflow;
/**
 * Abstract class STackBlock - write a description of the class here
 *
 * @author (Muhammad Maaz Ahmed-22436686)
 * @version (1.0 21-3-2020)
 */
public abstract class StackBlock implements Stack
{
    // instance variables - replace the example below with your own
    private int top;
    private Object[] stack;
    private int maxStackSize;

    public StackBlock(int stackSize){
        if( stackSize<1){
            throw new IllegalArgumentException("stack size must be great the");
        }
        maxStackSize=stackSize;
        stack= new Object[maxStackSize];
        int top=0;

    }

    public boolean isEmpty(){
        if (top==0){
            return true;
        }else{
            return false;
        }

    }

    public boolean isFull(){
        if(top==maxStackSize-1){
            return true;
        }else
        {return false;
        }

    }

    public void push(Object o){
        if(isFull()){
            throw new Overflow("stack is full");
        }else{
            stack[top]=o;
            top++;
        }

    }
/**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Object examine(){
        if(isEmpty()){
            throw new Underflow("stack is empty");
        }
        return stack[top-1];
    }
    
    public Object pop(){
        Object o=examine();
        top--;
        return o;
    }
   
}
