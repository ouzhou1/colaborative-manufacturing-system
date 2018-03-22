package sample.web.ui;

import java.io.Serializable;

/**
 * 审计日志记录
 * User: baoyu
 * Date: 2017/6/30
 * Time: 9:48
 */
public class AuditLog implements Serializable {
    public static final long serialVersionUID = 1L;

    // 日志元数据
    private Meta meta;

    // 请求时间	整形	8	单位秒，从1970年1月1日0时0分0秒至今经过的秒数
    private long requestTime;

    // 请求时间	整形 	8   单位微秒
    private long requestMicrosecond;
    // 会话ID 	整形 	4 	唯一
    private long sessionId;
    // 数据库ID 	整形 	4
    private long databaseId;

    // 用户名长度	整形 	4 	 数据库用户名的长度
    // 用户名 	字符 	用户名长度 	字符串类型，先是4字节整形表示字符串的长度，后跟着字符串的内容
    private String userName;
    private String userNameCode;

    // 客户端主机名长度	整形 	4 	客户端主机名的长度
    // 客户端主机名 	字符 	客户端主机名长度
    private String clientHost;

    // 客户端IP 	整形 	4
    private long clientIp;

    // 客户端端口 	整形 	2
    private int clientPort;

    // 客户端MAC长度 	整形 	4 	客户端MAC地址长度
    // 客户端MAC 	字符 	客户端MAC长度
    private String clientMAC;

    // 客户端App名长度 	整形 	4 	客户端应用程序名的长度
    // 客户端App名 	字符 	客户端App名长度
    private String clientApp;
    private String clientAppCode;

    // 服务端IP 	整形 	4
    private long serverIp;
    // 服务端端口 	整形 	2
    private int serverPort;

    // 服务端MAC长度 	整形 	4
    // 服务端MAC 	字符 	服务端MAC长度
    private String serverMAC;

    // 数据库实例名长度 	整形 	4
    // 数据库实例名 	字符 	数据库实例名长度
    private String databaseName;

    // 执行时长 	整形 	8 	数据库请求的耗时，单位微妙
    private long executeTime;

    // SQL长度 	整形 	4 	数据库请求的SQL语句的长度
    // SQL 	字符 	SQL长度
    private String sql;

    // SQL模板长度 	整形 	4
    // SQL模板化：去掉注释、统一参数，统一比较（大于、
    // 小于、等于、不大于、不小于、不等于等），统一空白符（统一为一个空格） ，屏蔽细微差异对SQL语句进行归类
    // SQL模板 	字符 	SQL模板长度
    private String sqlPattern;

    // sql状态
    // 1：未应答 2：成功 3：失败 4：超时 5：无效 6：会话断开
    private int sqlStatus;

    // 应答长度 	整形 	4 	数据库应答的内容的长度，包括应答信息（成功/错误） 、返回的内容
    // 应答内容
    private String reply;

    // 影响行数 	整形 	4 	执行SQL请求，影响的数据行数
    private int replyLineNum;
    // 请求类别 	整形 	4
    // 即：操作命令
    /**
     * 1：DDL数据定义语言
     * 2：DML数据操作语言
     * 3：TCL事务控制语言
     * 4：DQL数据查询语言
     * 5：DCL数据控制语言
     */
    private int requestType;
    // 操作命令 	整形 	4
    // 即：SqlType
    private int operateCommand;
    // 操作对象类型 	整形 	4
    private int operandType;

    // 操作对象名字长度	整形 	4 	操作对象的名字，多个操作对象使用分号（,）间隔
    // 操作对象名字 	字符 	操作对象名字长度 	 一级操作对象，如表名、视图名等
    private String operandName;
    private String operandNameCode;

    // 二级操作对象名字长度 	整形 	4 	二级操作对象，如字段名
    // 二级操作对象名字 	字符 	二级操作对象名字长度 	多个二级操作对象使用分号（,）间隔
    private String secondOperandName;

    // 告警类型长度	整形 	4 	告警类型字符串的长度,
    // 告警类型 	 字符	告警类型长度
    private String riskType;
    private String riskTypeCode;

    // 匹配规则长度 	整形 	4 	命中的规则列表长度
    // 匹配规则	字符 	匹配规则长度 	命中的规则列表，形式如：规则组名->规则名;规则组名->规则名
    private String matchedRules;

    // 风险等级 	整形 	4
    /**
     * 0：可信
     * 1：未识别
     * 2：低
     * 3：中
     * 4：高
     * 5：非法
     */
    private int riskLevel;
    // 保护动作 	整形 	4
    /**
     * '0': '不记日志',
     * '1': '通过',
     * '2': '丢弃',
     * '3': '阻断',
     * '4': '禁止'
     */
    private int protectOperate;

    // 3层关联
    /**
     * 应用端sessionId
     */
    private String webSessionId;
    /**
     * 应用端Ip
     */
    private String webIp;
    /**
     * 应用端用户名
     */
    private String webUserName;
    private String webUserNameCode;

    /**
     * 应用端请求url
     */
    private String webUrl;

    // 冗余字段
    private String requestTimeStr;
    private String operandTypeName;
    private String operandCommandName;

    public String getUserNameCode() {
        return userNameCode;
    }

    public void setUserNameCode(String userNameCode) {
        this.userNameCode = userNameCode;
    }

    public String getClientAppCode() {
        return clientAppCode;
    }

    public void setClientAppCode(String clientAppCode) {
        this.clientAppCode = clientAppCode;
    }

    public String getOperandNameCode() {
        return operandNameCode;
    }

    public void setOperandNameCode(String operandNameCode) {
        this.operandNameCode = operandNameCode;
    }

    public String getRiskTypeCode() {
        return riskTypeCode;
    }

    public void setRiskTypeCode(String riskTypeCode) {
        this.riskTypeCode = riskTypeCode;
    }

    public String getWebUserNameCode() {
        return webUserNameCode;
    }

    public void setWebUserNameCode(String webUserNameCode) {
        this.webUserNameCode = webUserNameCode;
    }

    public String getOperandTypeName() {
        return operandTypeName;
    }

    public void setOperandTypeName(String operandTypeName) {
        this.operandTypeName = operandTypeName;
    }

    public String getOperandCommandName() {
        return operandCommandName;
    }

    public void setOperandCommandName(String operandCommandName) {
        this.operandCommandName = operandCommandName;
    }

    public static class Meta {
        // 日志元数据 logFile, offset, size
        // 日志所在的文件路径
        private String logFile;
        // 日志在文件中的字节偏移量
        private long offset;
        // 日志大小
        private long size;

        public String getLogFile() {
            return logFile;
        }

        public void setLogFile(String logFile) {
            this.logFile = logFile;
        }

        public long getOffset() {
            return offset;
        }

        public void setOffset(long offset) {
            this.offset = offset;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }
    }

    public String getRequestTimeStr() {
        return requestTimeStr;
    }

    public void setRequestTimeStr(String requestTimeStr) {
        this.requestTimeStr = requestTimeStr;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public long getRequestMicrosecond() {
        return requestMicrosecond;
    }

    public void setRequestMicrosecond(long requestMicrosecond) {
        this.requestMicrosecond = requestMicrosecond;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(long databaseId) {
        this.databaseId = databaseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientHost() {
        return clientHost;
    }

    public void setClientHost(String clientHost) {
        this.clientHost = clientHost;
    }

    public long getClientIp() {
        return clientIp;
    }

    public void setClientIp(long clientIp) {
        this.clientIp = clientIp;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public String getClientMAC() {
        return clientMAC;
    }

    public void setClientMAC(String clientMAC) {
        this.clientMAC = clientMAC;
    }

    public String getClientApp() {
        return clientApp;
    }

    public void setClientApp(String clientApp) {
        this.clientApp = clientApp;
    }

    public long getServerIp() {
        return serverIp;
    }

    public void setServerIp(long serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerMAC() {
        return serverMAC;
    }

    public void setServerMAC(String serverMAC) {
        this.serverMAC = serverMAC;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSqlPattern() {
        return sqlPattern;
    }

    public void setSqlPattern(String sqlPattern) {
        this.sqlPattern = sqlPattern;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public int getReplyLineNum() {
        return replyLineNum;
    }

    public void setReplyLineNum(int replyLineNum) {
        this.replyLineNum = replyLineNum;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getOperateCommand() {
        return operateCommand;
    }

    public void setOperateCommand(int operateCommand) {
        this.operateCommand = operateCommand;
    }

    public int getOperandType() {
        return operandType;
    }

    public void setOperandType(int operandType) {
        this.operandType = operandType;
    }

    public String getOperandName() {
        return operandName;
    }

    public void setOperandName(String operandName) {
        this.operandName = operandName;
    }

    public String getSecondOperandName() {
        return secondOperandName;
    }

    public void setSecondOperandName(String secondOperandName) {
        this.secondOperandName = secondOperandName;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getMatchedRules() {
        return matchedRules;
    }

    public void setMatchedRules(String matchedRules) {
        this.matchedRules = matchedRules;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getProtectOperate() {
        return protectOperate;
    }

    public void setProtectOperate(int protectOperate) {
        this.protectOperate = protectOperate;
    }

    public int getSqlStatus() {
        return sqlStatus;
    }

    public void setSqlStatus(int sqlStatus) {
        this.sqlStatus = sqlStatus;
    }

    public String getWebSessionId() {
        return webSessionId;
    }

    public void setWebSessionId(String webSessionId) {
        this.webSessionId = webSessionId;
    }

    public String getWebIp() {
        return webIp;
    }

    public void setWebIp(String webIp) {
        this.webIp = webIp;
    }

    public String getWebUserName() {
        return webUserName;
    }

    public void setWebUserName(String webUserName) {
        this.webUserName = webUserName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}