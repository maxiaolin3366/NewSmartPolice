package cn.smartpolice.protocol;



/**
 * 宏定义文件
 *
 */
public interface ConstParam {
    //定义全局常量
    int MASSAGE_LEN = 20; //报文最短长度

    int MAX_CMD = 12; //最大cmd
    /**
     * cmd = 0 是联通测试报文
     */
    int CMD_0 = 0;    //连通测试报文
    int CMD_1 = 1;    //报文协议类型（连接管理协议）
    int CMD_2 = 2;    //平台帐号管理协议
    int CMD_3 = 3;     //控制协议
    int CMD_4 = 4;    //数据查询协议
    int CMD_5 = 5;    //消息传递协议
    int CMD_6 = 6;   //局域网发现协议
    int CMD_7 = 7;   //文件信息传输协议
    int CMD_8 = 8;    //加密协议
    int CMD_9 = 9;    //关联人管理
    int CMD_10 = 10;  //联系人管理
    int CMD_11 = 11;  //升级查询

    int TYPE_0 = 0; //报文类型
    int TYPE_1 = 1;
    int TYPE_2 = 2;
    int TYPE_3 = 3;
    int TYPE_4 = 4;
    int TYPE_5 = 5;
    int TYPE_6 = 6;
    int TYPE_7 = 7;
    int TYPE_8 = 8;
    int TYPE_9 = 9;
    int TYPE_10 = 10;
    int TYPE_11 = 11;
    int TYPE_12 = 12;
    int DevMaxConLimit = -1;
    String MAN = "1";
    String WOMAN = "0";


    int SORT_0 = 0; //app user
    int SORT_2 = 2; //dev user
    int SORT_3 = 3; //服务器

    int OPT_1 = 1;   //表示此报文在服务器进行转发处理
    int OPT_2 = 2;   //表示此报文加密处理过
    int OPT_4 = 4;   //表示此报文携带源地址，便于NAT穿透处理
    int OPT_8 = 8;   //表示此报文是请求报文或者需要确认的报文
    int OPT_16 = 16; //表示此报文是应答报文，确认号有效
    int OPT_32 = 32; //表示此报文后面有非JSON格式数据

    int LOGIN_STATE_0 = 0; //登录状态  未验证只是在队列中存在此节点
    int LOGIN_STATE_1 = 1; //已返回要求验证报文
    int LOGIN_STATE_2 = 2; //登录成功

    int SENT_PKT_TYPE_1 = 1; //构造不同的返回报文   返回错误报文
    int SENT_PKT_TYPE_2 = 2; //构造让对方发送验证请求报文de报文
    int SENT_PKT_TYPE_3 = 3; //构造登录成功的报文
    int SENT_PKT_TYPE_4 = 4; //构造保活应答报文
    int SENT_PKT_TYPE_5 = 5; //构造保活应答报文

    int ERROR_PKT_STATE_0 = 0; // 报文信息不匹配
    int ERROR_PKT_STATE_1 = 1; // 报文验证失败
    int ERROR_PKT_STATE_2 = 2;
    int ERROR_PKT_STATE_3 = 3;

    int LOGIN_OPERATE_0 = 0;  //log表中标记登出
    int LOGIN_OPERATE_1 = 1;  //log表中标记登录
    int LOGIN_OPERATE_2 = -1;  //log表中标记注销

    int SERVER_ID = 1; //从数据库中获取的   先定义为常量
    int ZNAF = 4;
    int CONTACT_0 = 0;//等待确认             脱联
    int CONTACT_1 = 1;//帐号已经关联过       已脱联
    int CONTACT_2 = 2;//添加联系人失败      脱联失败  关联失败

    int FOUNDCONTACT = 1;//获取到的联系人
    int CHANGE = 0;//变更

    int CONTACT_ERROR_0 = 1;//不存在联系人
    int CONTACT_ERROR_1 = 2;//对方禁止添加

    int NOTICE_CUSER = 3;//联系人通告

    int ADD_ERROR_0 = 0;//关联错误 信息不完全
    int ADD_ERROR_1 = 1;//关联错误 关联人数过多
    int ADD_ERROR_2 = 2;//关联错误 关联人数过多

    int NOTICE_0 = 0;//信息确认
    int NOTICE_2 = 2;//拒绝或者没理睬

    int RELATE_0 = 0;//等待确认
    int RELATE_1 = 1;//表示帐号已经关联过
    int RELATE_2 = 2;//关联帐号失败

    int TO_BE_SUCCESSFUL_1 = 1;//获取成功
    int TO_BE_SUCCESSFUL_2 = -1;//获取失败

    String MessageType_0 = "0";//所有聊天类型
    String MessageType_1 = "1";//报警消息
    String MessageType_2 = "2";//聊天
    String MessageType_4 = "4";//系统通告
    //查询类型
    byte codeId = 64;
    byte codeNoRead = 0;
    byte codeAlarm = 1;
    byte codeChat = 2;
    byte codeNoice = 3;
    byte codeNoReadContact = 8;
    byte getCodeNoReadRelated = 16;
}
