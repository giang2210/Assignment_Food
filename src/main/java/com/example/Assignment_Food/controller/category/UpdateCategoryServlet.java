package com.example.Assignment_Food.controller.category;


import com.example.Assignment_Food.entity.Category;
import com.example.Assignment_Food.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCategoryServlet extends HttpServlet {
    CategoryModel model = new CategoryModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            req.setAttribute("obj",obj);
            req.getRequestDispatcher("/Admin/Category/update-category.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            String categoryName = req.getParameter("categoryName");
            int status  = Integer.parseInt(req.getParameter("status"));
            obj.setCategoryName(categoryName);
            obj.setStatus(status);
            model.update(id, obj);
            resp.sendRedirect("/categories");
        }
    }
}
