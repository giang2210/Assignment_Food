package com.example.Assignment_Food.ulti;

public class PaginationSlave {
    public static final int pageSize = 5;

    public static String pagination(int pageIndex){
        return SQLConfig.SPACE+SQLConfig.LIMIT+SQLConfig.SPACE+(pageIndex-1)*pageSize+SQLConfig.COMMA+pageSize;
    }

}
