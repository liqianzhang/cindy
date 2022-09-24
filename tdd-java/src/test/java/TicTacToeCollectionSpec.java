import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TicTacToeCollectionSpec {

    TicTacToeCollection collection;
    TicTacToeBean bean;
    MongoCollection mongoCollection;
    @Before
    public void before() throws UnknownHostException {
        collection = spy(new TicTacToeCollection());
        bean = new TicTacToeBean(3, 2, 1, 'Y');
        mongoCollection = mock(MongoCollection.class);

    }

    @Test
    public void whenInstantiatedThenMongoHasDbNameTicTacToe()  {
        assertEquals("tic-tac-toe", collection.getMongoCollection()
                .getDBCollection().getDB().getName());
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        /*
        根据MongoCollection创建一个模拟对象每当调用间谍对象调用collection的方法
        getMongoCollection时，都返回模拟对象mongoCollection
         */
        doReturn(mongoCollection).when(collection).getMongoCollection();
        //调用要测试的方法
        collection.saveMove(bean);
        //验证是否正确调用了Jongo库，且只调用了一次
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMove(bean));
    }

    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse() {
        doThrow(new MongoException("bla"))
                .when(mongoCollection)
                .save(any(TicTacToeBean.class));
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        assertFalse(collection.saveMove(bean));
    }

    @Test
    public void whenDropThenInvokeMongoCollectionDrop() {
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        collection.drop();
        verify(mongoCollection).drop();
    }

    @Test
    public void whenDropThenReturnTrue() {
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        collection.drop();
        assertTrue(collection.drop());
    }

    @Test
    public void givenExceptionWhenDropThenRerurnFalse() {
        doThrow(new MongoException("Bla"))
                .when(mongoCollection)
                .drop();
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        assertFalse(collection.drop());
    }
}
