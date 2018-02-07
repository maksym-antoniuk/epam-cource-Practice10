import com.mysql.jdbc.PreparedStatement;

import javax.jws.soap.SOAPBinding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AuthorizeServlet", urlPatterns = "/authorize")
public class AuthorizeServlet extends HttpServlet {

    private static final String GET_USER = "SELECT users.login as login, users.password as password, roles.name as role FROM users inner join roles on roles_id = id where users.login = ? and users.password = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try(Connection connection = getDataSource().getConnection()) {
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(GET_USER);
            preparedStatement.setString(1,request.getParameter("login"));
            preparedStatement.setString(2,request.getParameter("pass"));

            ResultSet rs = preparedStatement.executeQuery();
            User user = null;
            if (rs.next()) {
                user = extract(rs);
                request.getSession().setAttribute("user", user);
                response.sendRedirect("part1.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private DataSource getDataSource() {
        DataSource ds;
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/appname");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ds;
    }

    private User extract(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setRole(resultSet.getString("role"));
        return user;
    }


}
