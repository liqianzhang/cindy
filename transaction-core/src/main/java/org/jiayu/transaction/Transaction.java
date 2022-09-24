package org.jiayu.transaction;

import org.jiayu.transaction.api.TransactionContext;
import org.jiayu.transaction.api.TransactionStatus;
import org.jiayu.transaction.api.TransactionType;
import org.jiayu.transaction.api.TransactionXid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @MethodName: $
 * @Description: tcc事务
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
public class Transaction implements Serializable {

    private static final long serialVersionUID = 229686822097604385L;

    /**
     * 事务编号
     */

    private TransactionXid xid;

    /**
     * 事务状态
     */

    private TransactionStatus status;

    /**
     * 事务类型
     */

    private TransactionType transactionType;

    /**
     * 重试次数
     */
    private volatile int retriedCount = 0;


    /**
     * 创建时间
     */

    private Date createTime = new Date();


    /**
     * 最后更新时间
     */
    private Date lastUpdateTime = new Date();

    /**
     * 版本号 用于乐观锁事务更新
     */
    private long version = 1;

    /**
     *参与者集合
     */

    private List<Participant> participants = new ArrayList<Participant>();

    /**
     * 附带属性映射
     */

    private Map<String, Object> attachments = new ConcurrentHashMap<String, Object>();

    public Transaction() {}

    /**
     * 创建事务分支
     */
    public Transaction(TransactionContext transactionContext) {
        this.xid = transactionContext.getXid(); //事务上下文的xid
        this.status = TransactionStatus.TRYING; //尝试中状态
    }















}
