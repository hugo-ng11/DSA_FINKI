package Courses.SLL;
import java.util.Scanner;
public class SLLStarterCode{
    static class SLLNode<E>{
        protected E element;
        protected SLLNode<E> succ;
        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }
    }
    static class SLL<E>{
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
    public static void main(String[] args) {
    }
}
