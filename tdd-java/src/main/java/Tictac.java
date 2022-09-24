import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Tictac {
    @Rule
    public ExpectedException exception =
            ExpectedException.none();

    @Test
    public void whenDoFooThenThrowRuntimeException() {
       Foo foo = new Foo();
        exception.expect(RuntimeException.class);
        foo.doFoo();
    }
}
