package org.jiayu.transaction.api;

import java.io.Serializable;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class TransactionContext implements Serializable {

    private static final long serialVersionUID = 6372623364470332465L;

    private TransactionXid xid;

    public TransactionXid getXid() {
        return xid;
    }

    public void setXid(TransactionXid xid) {
        this.xid = xid;
    }
}
