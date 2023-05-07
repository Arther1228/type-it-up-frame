package provider;


import entity.ParamMap;

/**
 * @author wangxiaoyang
 */
public class SqlProvider {

    public String provideSql(ParamMap param) {
        return "<script>" + param.getSqlStatement() + "</script>";
    }

}