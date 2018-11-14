
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.mysql.jdbc.Driver;
import Conexao.Mysql;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/SalvarContato"})
public class SalvarContato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("data");

            try {
                DriverManager.registerDriver(new Driver());
                Connection mysql = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "1q");
                String instu = "insert into contato (nome, endereco, email) values (?,?,?)";
                PreparedStatement ps = mysql.prepareStatement(instu);
                ps.setString(1, nome);
                ps.setString(2, endereco);
                // ps.setString(3, nascimento);
                ps.setString(3, email);
                ps.execute();
            } catch (SQLException e) {
                out.println("Erro");
                out.println(e.getMessage());

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Mysql bancoDados = new Mysql();
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String nascimento = request.getParameter("data");
        Connection conexao = bancoDados.conecta();
        try {
            String instu = "insert into contato (nome, endereco, email) values (?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(instu);
            ps.setString(1, nome);
            ps.setString(2, endereco);
            // ps.setString(3, nascimento);
            ps.setString(3, email);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SalvarContato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
