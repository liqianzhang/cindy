package org.jiayu.transaction.api;

import javax.transaction.xa.Xid;
import java.io.Serializable;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TransactionXid implements Xid, Serializable {
    private static final long serialVersionUID = 3758866175955816310L;

    @Override
    public int getFormatId() {
        return 0;
    }

    @Override
    public byte[] getGlobalTransactionId() {
        return new byte[0];
    }

    @Override
    public byte[] getBranchQualifier() {
        return new byte[0];
    }
}
