// A Class called LinkedList that has one attribute which is an object of Node class.
// Zachary Leali
// 9/9/2020

/**
 * LinkedList is a class to create a linked list of Node objects
 * @see <a href="Node.html#section">Node</a>
 * @see <a href="S1_Computus_Hard.html#section">S1_Computus_Hard</a>
 * @see <a href="S1_Computus_Hard_Test.html#section">S1_Computus_Hard_Test</a>
 * @see <a href="S1ComputusHardJUnitTest.html#section">S1ComputusHardJUnitTest</a>
 * @author Zach Leali
 */
public class LinkedList
{
    /** Instance variable referencing a Node class object */
    Node headPointer; // the headPointer is a pointer to the first Node in the linked list.

    // This method has three parameters one of which is the current linked list.
    // addNode(...) adds a Node to the current linked list and then returns the updated linked list.
    /**
     * Adds a node to the end of the current linked list
     * @param list          A reference to a LinkedList object
     * @param m             The month of Easter
     * @param d             The day of Easter
     * @return              The updated linked list with the new node added to the end
     */
    public LinkedList addNode(LinkedList list, String m, int d)
    {
        Node new_node = new Node();
        new_node.setMonth(m);
        new_node.setDay(d);
        new_node.nextPointer = null;
        if(list.headPointer == null)
        {
            list.headPointer = new_node;
        }
        else
        {
            Node lastNode = list.headPointer;
            while(lastNode.nextPointer != null)
            {
                lastNode = lastNode.nextPointer;
            }
            lastNode.nextPointer = new_node;

        }
        return list;
    }

    // Class method that prints out the linked list's nodes and their three attributes one node at a time.
    /**
     * A method to print out the linked list to console one node at a time
     * @param list          A reference a LinkedList object
     */
    public void printList(LinkedList list)
    {
        Node current_node = list.headPointer;
        while(current_node != null)
        {
            System.out.println(current_node.getMonth() + " " + current_node.getDay() + " - " + current_node.getEasterDayCount());
            current_node = current_node.nextPointer;
        }
    }
}
