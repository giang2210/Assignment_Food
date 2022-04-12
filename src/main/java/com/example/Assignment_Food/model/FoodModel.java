package com.example.Assignment_Food.model;

import com.example.Assignment_Food.entity.Food;
import com.example.Assignment_Food.ulti.ConnectionHelper;
import com.example.Assignment_Food.ulti.SQLConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodModel {
    public boolean save(Food obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.FOODS_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getCategoryId());
            preparedStatement.setString(3, obj.getDescription());
            preparedStatement.setString(4, obj.getThumbnail());
            preparedStatement.setDouble(5, obj.getPrice());
            preparedStatement.setTimestamp(6, obj.getCreatedAt());
            preparedStatement.setTimestamp(7, obj.getUpdatedAt());
            preparedStatement.setInt(8, obj.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Food> findAll() {
        List<Food> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.FOODS_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            //id,name,categoryId,description,thumbnail,price,createdAt,updatedAt,status
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                Timestamp updatedAt = resultSet.getTimestamp("updatedAt");
                int status = resultSet.getInt("status");
                Food obj = new Food(id, name, categoryId, description, thumbnail, price, createdAt, updatedAt, status);
                listObj.add(obj);
            }
        } catch (Exception e) {

        }
        return listObj;
    }

    public Food findById(int id) {
        Food obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.FOODS_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int categoryId = resultSet.getInt("categoryId");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                Timestamp createdAt = resultSet.getTimestamp("createdAt");
                Timestamp updatedAt = resultSet.getTimestamp("updatedAt");
                int status = resultSet.getInt("status");
                obj = new Food(id, name, categoryId, description, thumbnail, price, createdAt, updatedAt, status);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    public boolean update(int id, Food updateFoods) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.FOODS_UPDATE);
            preparedStatement.setString(1, updateFoods.getName());
            preparedStatement.setInt(2, updateFoods.getCategoryId());
            preparedStatement.setString(3, updateFoods.getDescription());
            preparedStatement.setString(4, updateFoods.getThumbnail());
            preparedStatement.setDouble(5, updateFoods.getPrice());
            preparedStatement.setTimestamp(6, updateFoods.getCreatedAt());
            preparedStatement.setTimestamp(7, updateFoods.getUpdatedAt());
            preparedStatement.setInt(8, updateFoods.getStatus());
            preparedStatement.setInt(9, id);
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
            PreparedStatement statement = connection.prepareStatement(SQLConfig.FOODS_DELETE);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}