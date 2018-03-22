package sample.web.ui;

import java.io.*;

/**
 * 解析日志文件，生产一个个的AuditLog 对象
 * User: baoyu
 * Date: 2017/6/30
 * Time: 10:35
 */
public class AuditLogsParser {
    private InputStream bis;
    private String encoding;

    private String logFile;
    private long offset = 0;
    private long size = 0;

    public AuditLogsParser(String filePath, String encoding) throws FileNotFoundException {
        this.bis = new BufferedInputStream(new FileInputStream(filePath));
        this.logFile = filePath;
        this.encoding = encoding;
    }

    public AuditLogsParser(String filePath, long offset, String encoding) throws IOException {
        this.bis = new BufferedInputStream(new FileInputStream(filePath));
        bis.skip(offset);

        this.logFile = filePath;
        this.encoding = encoding;
        this.offset = offset;
    }

    /**
     * 关闭文件流
     *
     * @throws IOException
     */
    public void close() throws IOException {
        bis.close();
    }

    /**
     * 返回null时， 说已到文件末尾
     *
     * @return
     * @throws IOException
     */
    public AuditLog next() throws IOException {
        if (bis.available() > 0) {
            return parse();
        } else {
            offset = 0;
            return null;
        }
    }

    private AuditLog parse() throws IOException {
        AuditLog auditLog = new AuditLog();
        size = 0;

        auditLog.setRequestTime(parseNumber(8));
        auditLog.setRequestMicrosecond(parseNumber(8));
        auditLog.setSessionId(parseNumber(4));
        auditLog.setDatabaseId(parseNumber(4));

        int userNameLength = (int) parseNumber(4);
        auditLog.setUserName(parseStr(userNameLength));
        int clientHostLength = (int) parseNumber(4);
        auditLog.setClientHost(parseStr(clientHostLength));

        auditLog.setClientIp(parseNumber(4));
        auditLog.setClientPort((int) parseNumber(2));
        int clientMACLength = (int) parseNumber(4);
        auditLog.setClientMAC(parseStr(clientMACLength));

        int clientAppLength = (int) parseNumber(4);
        auditLog.setClientApp(parseStr(clientAppLength));
        auditLog.setServerIp(parseNumber(4));
        auditLog.setServerPort((int) parseNumber(2));

        int serverMACLength = (int) parseNumber(4);
        auditLog.setServerMAC(parseStr(serverMACLength));
        int databaseNameLength = (int) parseNumber(4);
        auditLog.setDatabaseName(parseStr(databaseNameLength));

        auditLog.setExecuteTime(parseNumber(8));
        auditLog.setSqlStatus((int) parseNumber(2));
        int sqlLength = (int) parseNumber(4);
        auditLog.setSql(parseStr(sqlLength));

        int sqlPatternLength = (int) parseNumber(4);
        auditLog.setSqlPattern(parseStr(sqlPatternLength));
        int replyLength = (int) parseNumber(4);
        auditLog.setReply(parseStr(replyLength));

        auditLog.setReplyLineNum((int) parseNumber(4));
        auditLog.setRequestType((int) parseNumber(4));
        auditLog.setOperateCommand((int) parseNumber(4));
        auditLog.setOperandType((int) parseNumber(4));

        int operandNameLength = (int) parseNumber(4);
        auditLog.setOperandName(parseStr(operandNameLength));
        int secondOperandNameLength = (int) parseNumber(4);
        auditLog.setSecondOperandName(parseStr(secondOperandNameLength));

        int riskTypeLength = (int) parseNumber(4);
        auditLog.setRiskType(parseStr(riskTypeLength));
        int matchedRulesLength = (int) parseNumber(4);
        auditLog.setMatchedRules(parseStr(matchedRulesLength));

        auditLog.setRiskLevel((int) parseNumber(4));
        auditLog.setProtectOperate((int) parseNumber(4));

        // 3层关联
        int webUserNameLength = (int) parseNumber(4);
        auditLog.setWebUserName(parseStr(webUserNameLength));
        int webUrlLength = (int) parseNumber(4);
        auditLog.setWebUrl(parseStr(webUrlLength));
        int webIpLength = (int) parseNumber(4);
        auditLog.setWebIp(parseStr(webIpLength));
        int webSessionIdLength = (int) parseNumber(4);
        auditLog.setWebSessionId(parseStr(webSessionIdLength));

        AuditLog.Meta meta = new AuditLog.Meta();
        meta.setLogFile(logFile);
        meta.setOffset(offset);
        meta.setSize(size);
        auditLog.setMeta(meta);

        offset += size;

        return auditLog;
    }

    private String parseStr(int count) throws IOException {
        byte[] bs = new byte[count];
        bis.read(bs);
        size += count;
        return new String(bs, "UTF-8").trim();
    }

    private long parseNumber(int count) throws IOException {
        long result = 0L;
        for (int i = 0; i < count; i++) {
            result += (((long) (bis.read() & 0xFF)) << (8 * i));
        }
        size += count;
        return result;
    }
}
