package com.example.Assignment_Food.controller.food;

import com.example.Assignment_Food.entity.Category;
import com.example.Assignment_Food.entity.Food;
import com.example.Assignment_Food.model.CategoryModel;
import com.example.Assignment_Food.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodModel model = new FoodModel();
        CategoryModel model2 = new CategoryModel();

        List<Food> listObj = model.findAll();
        List<Category> listCategory = model2.findAll();

        HashMap<Integer,String> cateHashmap = new HashMap<>();
        for (Category cate: listCategory) {
            cateHashmap.put(cate.getId(),cate.getCategoryName());
        }

        req.setAttribute("listObj",listObj);
        req.setAttribute("listCategory",cateHashmap);

        req.getRequestDispatcher("/Admin/Food/list-food.jsp").forward(req,resp);
    }
}