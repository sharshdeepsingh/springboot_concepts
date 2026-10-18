
package org.sharshdeep.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.sharshdeep.model.User;
import org.sharshdeep.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    // CREATE USER
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");

        if (idParam == null || idParam.isBlank()
                || name == null || name.isBlank()
                || email == null || email.isBlank()
                || number == null || number.isBlank()) {

            sendJson(response, 400,
                    "{\"message\":\"All fields are required\"}");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);

            if (userService.getUserById(id) != null) {
                sendJson(response, 409,
                        "{\"message\":\"User ID already exists\"}");
                return;
            }

            User user = new User(id, name, email, number);
            userService.createUser(user);

            sendJson(response, 201,
                    "{\"message\":\"User added successfully\"}");

        } catch (NumberFormatException e) {
            sendJson(response, 400,
                    "{\"message\":\"Invalid user ID\"}");
        }
    }

    // GET ONE USER OR ALL USERS
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isBlank()) {
            try {
                Integer id = Integer.parseInt(idParam);
                User user = userService.getUserById(id);

                if (user == null) {
                    sendJson(response, 404,
                            "{\"message\":\"User not found\"}");
                    return;
                }

                sendJson(response, 200, userToJson(user));

            } catch (NumberFormatException e) {
                sendJson(response, 400,
                        "{\"message\":\"Invalid user ID\"}");
            }

            return;
        }

        List<User> users = userService.getAllUser();
        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < users.size(); i++) {
            if (i > 0) {
                json.append(",");
            }

            json.append(userToJson(users.get(i)));
        }

        json.append("]");

        sendJson(response, 200, json.toString());
    }

    // UPDATE USER
    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");

        if (idParam == null || idParam.isBlank()
                || name == null || name.isBlank()
                || email == null || email.isBlank()
                || number == null || number.isBlank()) {

            sendJson(response, 400,
                    "{\"message\":\"All fields are required\"}");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);

            User user = new User(id, name, email, number);
            User updatedUser = userService.updateUser(user);

            if (updatedUser == null) {
                sendJson(response, 404,
                        "{\"message\":\"User not found\"}");
                return;
            }

            sendJson(response, 200, userToJson(updatedUser));

        } catch (NumberFormatException e) {
            sendJson(response, 400,
                    "{\"message\":\"Invalid user ID\"}");
        }
    }

    // DELETE USER
    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            sendJson(response, 400,
                    "{\"message\":\"User ID is required\"}");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);

            if (!userService.deleteUser(id)) {
                sendJson(response, 404,
                        "{\"message\":\"User not found\"}");
                return;
            }

            sendJson(response, 200,
                    "{\"message\":\"User deleted successfully\"}");

        } catch (NumberFormatException e) {
            sendJson(response, 400,
                    "{\"message\":\"Invalid user ID\"}");
        }
    }

    // Convert one user to JSON
    private String userToJson(User user) {
        return "{"
                + "\"id\":" + user.getId() + ","
                + "\"name\":\"" + escapeJson(user.getName()) + "\","
                + "\"email\":\"" + escapeJson(user.getEmail()) + "\","
                + "\"number\":\"" + escapeJson(user.getNumber()) + "\""
                + "}";
    }

    // Send JSON response
    private void sendJson(HttpServletResponse response,
                          int status,
                          String json) throws IOException {

        response.setStatus(status);
        response.getWriter().write(json);
    }

    // Escape special characters in JSON strings
    private String escapeJson(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\f", "\\f");
    }
}
