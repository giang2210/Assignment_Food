package com.example.Assignment_Food.model;

import com.example.Assignment_Food.entity.Category;
import com.example.Assignment_Food.ulti.ConnectionHelper;
import com.example.Assignment_Food.ulti.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel {
    public boolean save(Category obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.CATEGORIES_INSERT);
            preparedStatement.setString(1, obj.getCategoryName());
            preparedStatement.setInt(2, obj.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Category> findAll() {
        List<Category> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.CATEGORIES_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            //id,name,categoryId,description,thumbnail,price,createdAt,updatedAt,status
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String categoryName = resultSet.getString("categoryName");
                int status = resultSet.getInt("status");
                Category obj = new Category(id, categoryName, status);
                listObj.add(obj);
            }
        } catch (Exception e) {

        }
        return listObj;
    }

    public Category findById(int id) {
        Category obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.CATEGORIES_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String categoryName = resultSet.getString("categoryName");
                int status = resultSet.getInt("status");
                obj = new Category(id, categoryName, status);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public boolean update(int id, Category updateCategory) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.CATEGORIES_UPDATE);
            preparedStatement.setString(1, updateCategory.getCategoryName());
            preparedStatement.setInt(2, updateCategory.getStatus());
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.CATEGORIES_DELETE);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
