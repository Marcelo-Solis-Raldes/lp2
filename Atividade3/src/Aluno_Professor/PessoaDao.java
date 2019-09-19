
package Aluno_Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class PessoaDao {
    LinkedList<Pessoa> pessoas = new LinkedList<>();
    LerMetodos ler = new LerMetodos();
    
    public void gravarProfessorNoBD(Professor professor) throws SQLException{
        
        try(Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "")) {
            String sql = "insert into professor (nome, idade, sexo, cpf, siape) values(?,?,?,?,?)";
            PreparedStatement pre = conexao.prepareCall(sql);
            pre.setString(1, professor.getNome());
            pre.setInt(2, professor.getIdade());
            pre.setString(3, professor.getSexo());
            pre.setString(4, professor.getCpf());
            pre.setString(5, professor.getSiape());
            int retorno = pre.executeUpdate();
            if (retorno >  0 ) {
                JOptionPane . showMessageDialog ( null , " Professor cadastrado com Sucesso! " );
            }else{
                JOptionPane.showMessageDialog(null, "Professor nao cadasrado!!!!!!");
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void gravarAlunoNoBD(Aluno aluno) throws SQLException{
        
         Connection conexao = null;
         try{
             conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "");
            String sql = "insert into aluno(nome, idade, sexo, cpf, ra) values (?,?,?,?,?)";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, aluno.getNome());
            prepare.setInt(2, aluno.getIdade());
            prepare.setString(3, aluno.getSexo());
            prepare.setString(4, aluno.getCpf());
            prepare.setString(5, aluno.getRa());
            int retorno = prepare.executeUpdate();
            if(retorno > 0){
                JOptionPane . showMessageDialog ( null , " Aluno cadastrado com sucesso! " );
            }else{
                JOptionPane.showMessageDialog(null, "Aluno nao cadastrado!!!!!!");
            }
         }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
             conexao.close();
         }
    }
    public void deletarProfessorNoBD() throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "");
            String sql = "delete from professor where cpf=?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, ler.cpf());
            prepare.executeUpdate();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            conexao.close();
        }
    }
    public void deletarAlunoNoBD() throws SQLException{
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "");
            String sql = "delete from aluno where cpf=?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, ler.cpf());
            prepare.executeUpdate(); 
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            conexao.close();
        }
    }
    public void buscarProfessorNoBD(){
        
           try(Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "")){
               String sql = "select * from professor where nome=?";
              
               PreparedStatement prepare = conexao.prepareStatement(sql);
               prepare.setString(1, ler.nome());
    
               ResultSet rs = prepare.executeQuery();
               while(rs.next()){
               String nome = rs.getString("nome");
               int idade = rs.getInt("idade");
               String sexo = rs.getString("sexo");
               String cpf = rs.getString("cpf");
               String siape = rs.getString("siape");
               
               JOptionPane.showMessageDialog(null,"Professor \n\n"+"\nNome: "+nome+"\nIdade: "+idade+
               "\nSexo: "+sexo+"\nCpf: "+cpf+"\nSiape: "+siape);
               }
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
       }
    public void buscarAlunoNoBD(){
         try(Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "")){
               String sql = "select * from aluno where nome=?";
              
               PreparedStatement prepare = conexao.prepareStatement(sql);
               prepare.setString(1, ler.nome());
    
               ResultSet rs = prepare.executeQuery();
               while(rs.next()){
               String nome = rs.getString("nome");
               int idade = rs.getInt("idade");
               String sexo = rs.getString("sexo");
               String cpf = rs.getString("cpf");
               String ra = rs.getString("ra");
               
               JOptionPane.showMessageDialog(null,"Aluno \n"+"Nome: "+nome+"\nIdade: "+idade+
               "\nSexo: "+sexo+"\nCpf: "+cpf+"\nRa: "+ra);
               }
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage());
           }
    }
    public void alterarProfessorNoBD(){
        String leia = ler.cpf();
      Professor pro = new Professor();
        try(Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "")){
            ler.lerProfessor(pro);
            String sql = "UPDATE Professor set nome=?,idade=?,sexo=?,cpf=?,siape=? where cpf =?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, pro.getNome());
            prepare.setInt(2,pro.getIdade());
            prepare.setString(3, pro.getSexo());
            prepare.setString(4, pro.getCpf());
            prepare.setString(5, pro.getSiape());
            prepare.setString(6, leia);
            int retorno = prepare.executeUpdate();
            if(retorno > 0){
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!!!!!");
            }
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void alterarAlunnoNoBD(){
        String leia = ler.cpf();
      Aluno alu = new Aluno();
        try(Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "")){
            ler.lerAluno(alu);
            String sql = "UPDATE aluno set nome=?,idade=?,sexo=?,cpf=?,ra=? where cpf=?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, alu.getNome());
            prepare.setInt(2, alu.getIdade());
            prepare.setString(3, alu.getSexo());
            prepare.setString(4, alu.getCpf());
            prepare.setString(5, alu.getRa());
            prepare.setString(6, leia);
            int retorno = prepare.executeUpdate();
            if(retorno > 0){
               JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!!!!!");  
            }
            conexao.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void salvarPessoa(int x) throws SQLException{
        int opcao = -1;
        while(opcao !=0 ){
            x = Integer.parseInt(JOptionPane.showInputDialog("1- PROFESSOR: \n2-ALUNO: \n0 - SAIR"));
        switch (x) {
            case 1:
                Professor p = new Professor();
                ler.lerProfessor(p);
                System.out.println(p);
                gravarProfessorNoBD(p);
                break;
            case 2:
                Aluno a = new Aluno();
                ler.lerAluno(a);
                System.out.println(a);
                gravarAlunoNoBD(a);
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "voltar ao menu!!!!");
                opcao=0;
                break;
               
            default:
                JOptionPane.showMessageDialog(null, "Opçao invalida!!!!");
                break;
            }
        }
    }
    public void buscarTodosProfessores() throws SQLException{
        Connection conexao = null;
        ResultSet res = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "");
            String sql = "select * from professor";
            String list = "\t\t\tProfessores\n";
            PreparedStatement ps = conexao.prepareCall(sql);
            res = ps.executeQuery();
            while(res.next()){
                int cpf = res.getInt("cpf");
		String nome = res.getString("nome");
		int idade = res.getInt("idade");
		String siape = res.getString("siape");
		String sexo = res.getString("sexo");
		String ler = "\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nSexo: " + sexo + "\nSiape: " + siape + "\n";
		list += ler;
            }
            JOptionPane.showMessageDialog(null, list);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            conexao.close();
        }
    }
    public void buscarTodosAlunos() throws SQLException{ 
        Connection conexao = null;
        ResultSet res = null;
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cadastro", "root", "");
            String sql = "select * from aluno";
            String lista = "\t\t\tAluno\n";
            PreparedStatement pes = conexao.prepareCall(sql);
            res = pes.executeQuery();
            while(res.next()){
                int cpf = res.getInt("cpf");
		String nome = res.getString("nome");
		int idade = res.getInt("idade");
		String ra = res.getString("ra");
		String sexo = res.getString("sexo");
		String ler = "\nNome: " + nome + "\nIdade: " + idade + "\nCPF: " + cpf + "\nSexo: " + sexo + "\nRa: " + ra + "\n";
		lista += ler;            
            }
            JOptionPane.showMessageDialog(null, lista);
            
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }finally{
            conexao.close();
        }
    }
    public void buscarPeloNomeProfessor(){
        
        String nome = ler.nome();
        for(int i=0; i<pessoas.size(); i++){
            if(ler.nome().equalsIgnoreCase(nome)){
               buscarProfessorNoBD();
            }else{
                 JOptionPane.showMessageDialog(null, "Pessoa nao encontrada");
            }
        }
    }
}

    