package list.linkedlist;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList;

    @Before
    public void doBefore(){
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void testIsEmptyTrue(){
        Assert.assertTrue(customLinkedList.isEmpty());
    }

    @Test
    public void testIsEmptyFalse(){
        customLinkedList.add(SingleNode.<Integer>builder().data(1).next(null).build());
        Assert.assertFalse(customLinkedList.isEmpty());
    }

    @Test
    public void addOneSingleRecord(){
        SingleNode<Integer> node = new SingleNode<Integer>();
        node.setData(1);
        node.setNext(null);
        customLinkedList = new CustomLinkedList<>(node);
        Assert.assertEquals(customLinkedList.getHead(), customLinkedList.getTail());
    }

    @Test
    public void addMultipleRecords(){
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).build();
        SingleNode<Integer> r2 = SingleNode.<Integer>builder().data(2).build();
        SingleNode<Integer> r3 = SingleNode.<Integer>builder().data(3).build();
        customLinkedList.add(r1);
        customLinkedList.add(r2);
        customLinkedList.add(r3);
        Assert.assertEquals(r1.getData(), customLinkedList.getHead().getData());
        Assert.assertEquals(r3.getData(), customLinkedList.getTail().getData());
    }

    @Test
    public void addAsFirstNotEmpty(){
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).build();
        SingleNode<Integer> r2 = SingleNode.<Integer>builder().data(2).build();
        SingleNode<Integer> asFirst = SingleNode.<Integer>builder().data(0).build();
        customLinkedList.add(r1);
        customLinkedList.add(r2);
        customLinkedList.addAsFirst(asFirst);
        Assert.assertEquals(asFirst.getData(), customLinkedList.getHead().getData());
    }


    @Test
    public void addAsFirstEmpty(){
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).build();
        Assert.assertTrue(customLinkedList.isEmpty());
        customLinkedList.addAsFirst(r1);
        Assert.assertEquals(customLinkedList.getHead().getData(), r1.getData());
        Assert.assertEquals(customLinkedList.getHead(), customLinkedList.getTail());

    }


    @Test
    public void removeFirstElement() {
        SingleNode<Integer> r2 = SingleNode.<Integer>builder().data(1).build();
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).next(r2).build();
        customLinkedList = new CustomLinkedList<>(r1);
        Assert.assertTrue(customLinkedList.remove(r1.getData()));
        Assert.assertEquals(r2, customLinkedList.getHead());
        Assert.assertEquals(customLinkedList.getHead(), customLinkedList.getTail());
    }

    @Test
    public void removeUniqueElement() {
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).build();
        customLinkedList = new CustomLinkedList<>(r1);
        Assert.assertTrue(customLinkedList.remove(r1.getData()));
        Assert.assertNull(customLinkedList.getHead());
        Assert.assertEquals(customLinkedList.getHead(), customLinkedList.getTail());
    }

    @Test
    public void removeIntermediateElement(){
        SingleNode<Integer> r3 = SingleNode.<Integer>builder().data(3).build();
        SingleNode<Integer> r2 = SingleNode.<Integer>builder().data(2).next(r3).build();
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).next(r2).build();
        customLinkedList = new CustomLinkedList<>(r1);
        Assert.assertFalse(customLinkedList.isEmpty());
        Assert.assertTrue(customLinkedList.remove(r2.getData()));
        Assert.assertEquals(customLinkedList.getHead().getData(), r1.getData());
        Assert.assertNotNull(customLinkedList.getHead().toString());
        Assert.assertEquals(customLinkedList.getTail().getData(), r3.getData());
    }

    @Test
    public void removeLastElement(){
        SingleNode<Integer> r3 = SingleNode.<Integer>builder().data(3).build();
        SingleNode<Integer> r2 = SingleNode.<Integer>builder().data(2).next(r3).build();
        SingleNode<Integer> r1 = SingleNode.<Integer>builder().data(1).next(r2).build();
        customLinkedList = new CustomLinkedList<>(r1);
        Assert.assertFalse(customLinkedList.isEmpty());
        Assert.assertTrue(customLinkedList.remove(r3.getData()));
        Assert.assertEquals(customLinkedList.getHead().getData(), r1.getData());
        Assert.assertNotNull(customLinkedList.getHead().toString());
        Assert.assertEquals(customLinkedList.getTail().getData(), r2.getData());
    }

}
