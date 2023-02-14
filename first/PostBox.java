package first;

public class PostBox<T> {  // generic class -> <> type을 정의
    private T item;     // 자료 type을 정의함

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}
