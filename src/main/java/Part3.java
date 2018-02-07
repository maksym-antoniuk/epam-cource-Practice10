import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "Part3", urlPatterns = "/part3")
public class Part3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("lol"));


        HttpSession session = request.getSession();

        if (session.isNew()) {
            session.setAttribute("mylist", new ArrayList<String>());
            System.out.println("good");
        }
        if (Objects.isNull(session.getAttribute("mylist"))) {
            session.setAttribute("mylist", new ArrayList<String>());
        }
        String s = request.getParameter("lol");
        ((ArrayList<String>)session.getAttribute("mylist")).add(s);
        System.out.println(((ArrayList<String>)session.getAttribute("mylist")));
        response.sendRedirect("part3.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
