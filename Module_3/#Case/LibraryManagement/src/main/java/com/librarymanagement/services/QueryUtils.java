package com.librarymanagement.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public class QueryUtils {
    public static String parseSearchQuery(HttpServletRequest request) {
        Map<String, String[]> param = request.getParameterMap();
        StringBuilder condition = new StringBuilder();
        int count = 0;
        for (String k : param.keySet()) {
            count++;
            if (k.equals("action") || k.equals("q")||k.equals("page")) continue;
            String str = param.get(k)[0];
            if (count <= param.keySet().size()) condition.append(" AND ");
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
        StringBuilder conditions = new StringBuilder(" LIMIT ");
        conditions.append(page).append(" ,").append(size);
        return conditions.toString();
    }
}
