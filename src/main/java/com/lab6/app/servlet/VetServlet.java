package com.lab6.app.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Realmente es en http://localhost:8080/lab7/veterinario porque tiene que referenciar la aplicacion primero
@WebServlet("/veterinario") // URL del Example
public class VetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vet.jsp").forward(request, response);
    }
}
