package com.example.Assignment_Food.ulti;

public class SQLConfig {
    //foods
    public static final String FOODS_INSERT = "insert into foods (name,categoryId,description,thumbnail,price,createdAt,updatedAt,status ) values ( ?,?,?,?,?,?,?,?)";
    public static final String FOODS_SELECT = "select * from foods";
    public static final String FOODS_SELECT2 = "select * from foods where id = ?";
    public static final String FOODS_UPDATE = "update foods set name = ?,categoryId = ?,description = ?,thumbnail = ?,price = ?,createdAt = ?,updatedAt = ?,status = ? where id = ?";
    public static final String FOODS_DELETE = "delete from foods where id = ?";

    //category
    public static final String CATEGORIES_INSERT = "insert into categories ( categoryName, status) values (?,?)";
    public static final String CATEGORIES_SELECT = "select * from categories";
    public static final String CATEGORIES_SELECT2 = "select * from  categories where id = ?";
    public static final String CATEGORIES_UPDATE = " update categories set categoryName = ?, status = ? where id = ?";
    public static final String CATEGORIES_DELETE = "delete from categories where id = ?";


    public static final String INSERT = "INSERT INTO";
    public static final String ALTER_TABLE = "ALTER TABLE";
    public static final String STAR = "*";
    public static final String QUESTION = "?";
    public static final String COUNT = "COUNT";
    public static final String AS = "AS";
    public static final String DROP_TABLE = "DROP TABLE";
    public static final String DROP = "DROP";
    public static final String CONSTRAINT = "CONSTRAINT";
    public static final String CREATE_TABLE = "CREATE TABLE";
    public static final String PRIMARY_KEY = "PRIMARY KEY";
    public static final String FOREIGN_KEY = "FOREIGN KEY";
    public static final String REFERENCES = "REFERENCES";
    public static final String AUTO_INCREMENT = "AUTO_INCREMENT";
    public static final String VALUES = "VALUES";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE_VALUE = "2";
    public static final String VARCHAR = "VARCHAR";
    public static final String TEXT = "TEXT";
    public static final String SET = "SET";
    public static final String STATUS = "STATUS";
    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String WHERE = "WHERE";
    public static final String ID = "ID";
    public static final String EQUAL_SIGN = "=";
    public static final String INFORMATION_SCHEMA = "information_schema.tables ";
    public static final String SELECT_ALL = "SELECT * FROM";
    public static final String SPACE = " ";
    public static final String OPEN_BRACKET = "(";
    public static final String CLOSE_BRACKET = ")";
    public static final String APOSTROPHE = "'";
    public static final String COMMA = ",";
    public static final String AND = "AND";
    public static final String TABLE_SCHEMA = "table_schema";
    public static final String TABLE_NAME = "table_name";
    public static final String LIMIT = "LIMIT";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "select * from accounts where username=?" ;
    public static final String LOCK_ACCOUNT = "update accounts set status=?,failureCount = ?,lockTime=? where username = ?" ;
}
