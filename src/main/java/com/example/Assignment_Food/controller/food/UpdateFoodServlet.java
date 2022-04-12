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
import java.util.List;

public class UpdateFoodServlet extends HttpServlet {
    FoodModel model = new FoodModel();

    CategoryModel model2 = new CategoryModel();
    List<Category> listCategory = model2.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Food obj = model.findById(id);
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            req.setAttribute("obj", obj);
            req.setAttribute("listCategory", listCategory);

            req.getRequestDispatcher("/Admin/Food/update-food.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Food obj = model.findById(id);
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            String name = req.getParameter("name");
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            int status = Integer.parseInt(req.getParameter("status"));
            obj.setName(name);
            obj.setCategoryId(categoryId);
            obj.setDescription(description);
            obj.setThumbnail(thumbnail);
            obj.setPrice(price);
            obj.setStatus(status);
            model.update(id, obj);
            resp.sendRedirect("/foods");
        }
    }
}