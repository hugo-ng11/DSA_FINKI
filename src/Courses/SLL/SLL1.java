package Courses.SLL;
import java.util.Scanner;
class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;
    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}
class SLL<E> {
    private SLLNode<E> first;
    public SLL() {
        this.first = null;
    }
    public void insertLast(E o) {
        if (first == null) {
            first = new SLLNode<E>(o, null);
            return;
        }
        SLLNode<E> tmp = first;
        while (tmp.succ != null)
            tmp = tmp.succ;
        tmp.succ = new SLLNode<E>(o, null);
    }
    public void deleteShorterThan(int L) {
        while (first != null && ((String)first.element).length() < L) {
            first = first.succ;
        }
        SLLNode<E> curr = first;
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
        SLLNode<E> tmp = first;
        ret += tmp.element;
        while (tmp.succ != null) {
            tmp = tmp.succ;
            ret += "->" + tmp.element;
        }
        return ret;
    }
}
public class SLL1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        SLL<String> lista = new SLL<>();
        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextLine());
        }
        int L = sc.nextInt();
        System.out.println(lista.toString());
        lista.deleteShorterThan(L);
        System.out.println(lista.toString());
    }
}
