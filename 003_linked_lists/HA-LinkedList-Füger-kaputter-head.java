
package lektion_003_lists;

public class LinkedList<T> {
	// Eine Referenz / Pointer auf die erste Node unserer Liste
	public ListNode<T> head;
	
	//****** Implementieren Sie die fehlenden Methoden: ********
	
	public void printList() {
        ListNode<T> act = head;


        while (act != null) {
            System.out.println(act.data);
            act = act.next;
        }
    }

    public ListNode<T> find(T value) { 
        while (head != null){
            if(head.data == value){
                break;
            }
            head = head.next;
        }
        return head; 
    };

    public ListNode<T> insert(T value, ListNode<T> after) { return null; };
    public ListNode<T> remove(ListNode<T> node) { return null; };
    public ListNode<T> move(T value, T afterValue) { return null; };
}
}
