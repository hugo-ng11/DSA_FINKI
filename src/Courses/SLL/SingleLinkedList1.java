package Courses.SLL;
import java.util.Scanner;
class SLLNode1<E>{
    protected E element;
    protected SLLNode1<E> succ;
    public SLLNode1(E elem, SLLNode1<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}
class SLL1<E> extends SLLStarterCode.SLL<E>{
    private SLLNode1<E> first;
    public SLL1() {
        this.first = null;
    }
    public void insertLast(E o) {
        if (first == null) {
            first = new SLLNode1<E>(o, null);
            return;
        }
        SLLNode1<E> tmp = first;
        while (tmp.succ != null)
            tmp = tmp.succ;
        tmp.succ = new SLLNode1<E>(o, null);
    }
    public void deleteShorterThan(int L) {
        while (first != null && ((String)first.element).length() < L) {
            first = first.succ;
        }
        SLLNode1<E> curr = first;
        while (curr != null && curr.succ != null) {
            if (((String) curr.succ.element).length() < L) {
                curr.succ = curr.succ.succ;
            } else {
                curr = curr.succ;
            }
        }
    }
    public String toString() {
        if (first == null)
            return "Prazna lista!!!";
        String ret = "";
        SLLNode1<E> tmp = first;
        ret += tmp.element;
        while (tmp.succ != null) {
            tmp = tmp.succ;
            ret += "->" + tmp.element;
        }
        return ret;
    }
}
public class SingleLinkedList1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        SLL1<String> lista = new SLL1<>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextLine());
        }
        int L = sc.nextInt();
        System.out.println(lista.toString());
        lista.deleteShorterThan(L);
        System.out.println(lista.toString());
    }
}
