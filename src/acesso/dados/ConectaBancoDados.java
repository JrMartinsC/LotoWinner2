package acesso.dados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBancoDados {
    
    public Statement stm; // responsável por preparar e realizar pesquisa no banco de dados
    public ResultSet rs; // responsável por armazenar o resultado de uma pesquisa passada para o Statement
    public Connection con; // responsável por realizar a conexão com o banco de dados
    
    /*Responsável pela conexão com o banco de dados */
    private String driver = "com.mysql.jdbc.Driver"; // responsável por identificar o serviço de banco de dados
    private String caminho = "jdbc:mysql://127.0.0.1:3306/lotowinner"; // responsável por setar o local do banco de daos
    private String usuario = "root";
    private String senha = "";
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado ao banco de dados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar ao banco de dados!\nErro:" + ex.getMessage());
        }
    }
    
    public void executaSql(String comandoSql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(comandoSql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro em ConectaBancoDados/executaSql \n" + ex.getMessage());
        }
    }
        
    public void desconexao(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "Desconectado do banco de dados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar do banco de dados!\n" + ex.getMessage());
        }
    }
    
}
