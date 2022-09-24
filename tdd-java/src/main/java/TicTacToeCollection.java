import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TicTacToeCollection {

    private MongoCollection mongoCollection;

    protected MongoCollection getMongoCollection() {
        return mongoCollection;
    }

    public TicTacToeCollection () throws UnknownHostException {
        DB db = new MongoClient().getDB("tic-tac-toe");
        mongoCollection =
                new Jongo(db).getCollection("bla");
    }

    public boolean saveMove(TicTacToeBean bean) {
        try {
            getMongoCollection().save(bean);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean drop() {
        try {
            getMongoCollection().drop();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
