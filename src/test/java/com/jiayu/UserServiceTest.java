package com.jiayu;

import com.mock.UserService;
import javassist.bytecode.stackmap.TypeData;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static com.jayway.jsonpath.internal.function.ParamType.JSON;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
@RunWith(PowerMockRunner.class)
public class UserServiceTest {

    /**
     * 用户服务，定义被测对象
     */
    @InjectMocks
    private UserService userService;
    @Mock
    private UserDao userDao;
    //标识生成器
    @Mock
    private IdGenerator idGenerator;


    @Before
    public void beforeTest() {
        //注入依赖对象
        Whitebox.setInternalState(userService, "canModify", Boolean.TRUE);
    }

    /**
     * 测试：创建新用户
     */

    @Test
    public void testCreateUserWithNew() {
        //模拟依赖方法userDao.getByName
        Mockito.doReturn(null).when(userDao).getIdByName(Mockito.any());
        Long userId = 1L;
        //模拟依赖方法；idGenerator.next
        Mockito.doReturn(userId).when(idGenerator).next();

        //调用被测方法
        String txt = ResourceHelper.getResourceAsString(getClass(), "userCreateVO.json");
    }

    @Test
    public void testMock() {
    }
}
