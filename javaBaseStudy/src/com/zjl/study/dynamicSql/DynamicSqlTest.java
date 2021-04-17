package com.zjl.study.dynamicSql;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 拼接动态SQL
 * 而避免应用"WHERE 1=1"的方式进行拼接
 */
public class DynamicSqlTest {
    private static final String FNUMBER = "FNumber";
    private static final String FNAME = "FName";

    public static void main(String[] args) {
        Set<String> dynamicParameter = Sets.newHashSet(FNUMBER, FNAME);

        doQuery(dynamicParameter);
    }

    private static void doQuery(Set<String> dynamicParameter) {
        boolean hasWhere = false;
        StringBuilder sql = new StringBuilder("SELECT * FROM T_Employee");

        if (dynamicParameter.contains(FNUMBER)) {
            hasWhere = appendWhereIfNeed(sql, hasWhere);
            sql.append("FNumber BETWEEN 'DEV001' AND 'DEV008'");
        }

        if (dynamicParameter.contains(FNAME)) {
            hasWhere = appendWhereIfNeed(sql, hasWhere);
            sql.append("FName LIKE '%姓名%'");
        }

        System.out.println("DynamicSQL:" + sql);
    }

    private static boolean appendWhereIfNeed(StringBuilder sql, boolean hasWhere) {
        if (hasWhere == false) {
            sql.append(" WHERE ");
            return true;
        }

        sql.append(" AND ");
        return false;
    }
}
