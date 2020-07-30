package list.linkedlist;

public class SingleNode<T> {
    private SingleNode<T> next;
    private T data;

    public SingleNode() {
    }

    public SingleNode(SingleNodeBuilder<T> builder) {
        this.next = builder.next;
        this.data = builder.data;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

    public static <T2> SingleNodeBuilder<T2> builder() {
        return new SingleNodeBuilder<T2>();
    }

    public static class SingleNodeBuilder<T1> {

        private SingleNode<T1> next;
        private T1 data;

        public SingleNodeBuilder<T1> data(T1 data) {
            this.data = data;
            return this;
        }

        public SingleNodeBuilder<T1> next(SingleNode<T1> next) {
            this.next = next;
            return this;
        }

        public SingleNode<T1> build() {
            return new SingleNode<T1>(this);
        }
    }
}
