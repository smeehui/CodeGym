package com.librarymanagement.utils;

import com.librarymanagement.components.book.service.BookDAO;
import com.librarymanagement.components.user.services.UserDAO;
import com.librarymanagement.services.IAbstractService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public class RequestUtils{
    public static String parseSearchQuery(HttpServletRequest request, String when) {
        Map<String, String[]> param = request.getParameterMap();
        StringBuilder condition = new StringBuilder();
        int count = 0;
        for (String k : param.keySet()) {
            count++;
            if (k.equals("action") || k.equals("q")||k.equals("page")||k.equals("size")) continue;
            String str = param.get(k)[0];
            if (count <= param.keySet().size()){
                switch (when) {
                    case "all" -> condition.append(" WHERE ");
                    case "search" -> condition.append(" AND ");
                }
            }
            condition.append(k).append("=").append(str);
        }
        if (condition.toString().equals(" AND ")) return null;
        return condition.toString();
    }

    public static String addPaging(HttpServletRequest request) {
        String pageStr = request.getParameter("page")==null?"1":request.getParameter("page");
        String elPerPage = request.getParameter("size");
        int size = elPerPage == null ? 5 : Integer.parseInt(elPerPage);
        int page = (Integer.parseInt(pageStr) - 1) * size;
        request.setAttribute("page", Integer.parseInt(pageStr));
        request.setAttribute("size", size);
        StringBuilder conditions = new StringBuilder(" LIMIT ");
        conditions.append(page).append(" ,").append(size);
        return conditions.toString();
    }
    public static  <Model>  void setPageAndAttributes (HttpServletRequest request, String when, IAbstractService service) {
        String pageDetails = RequestUtils.addPaging(request);
        Map<Long, Model> modelMap;
        String condition;
        switch (when) {
            case "search" -> {
                condition = RequestUtils.parseSearchQuery(request, "search");
                modelMap = service.search(request.getParameter("q"), condition + pageDetails);
                request.setAttribute("q", request.getParameter("q"));
            }
            default -> {
                condition = RequestUtils.parseSearchQuery(request,"all");
                modelMap = service.getPaging(pageDetails, condition);
            }
        }
        int noOfPage = (int) Math.ceil((float) service.getNoOfRecords() / (float) 5);
        request.setAttribute("noOfPages", noOfPage);
        if (service instanceof UserDAO) request.setAttribute("users", modelMap);
        else if (service instanceof BookDAO) request.setAttribute("books", modelMap);
    }
}
