import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (!Objects.isNull(session.getAttribute("mylist"))) {
            ((ArrayList<String>)session.getAttribute("mylist")).clear();
        }
        request.getRequestDispatcher("part3").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (!Objects.isNull(session.getAttribute("mylist"))) {
            ((ArrayList<String>)session.getAttribute("mylist")).clear();
        }
        request.getRequestDispatcher("part3").forward(request, response);
    }
}
