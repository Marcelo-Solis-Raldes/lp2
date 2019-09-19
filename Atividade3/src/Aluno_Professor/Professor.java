
package Aluno_Professor;

/**
 *
 * @author Marcelo
 */
public class Professor extends Pessoa{
    
    private String siape;
  
    public Professor(){
        
    }
 
    public Professor(String nome, int idade, String cpf, String sexo, String siape){
        super(nome, idade, cpf, sexo);
        this.siape = siape;
    }
    
     public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Override
    public String toString() {
        
        return "Professor{" +"\nNome: "+this.getNome()+"\nIdade: "+
        this.getIdade()+"\nSexo: "+this.getSexo()+ "\nsiape=" + siape 
        + "\nCPF: = "+this.getCpf()+"\n"+'}';
    }
}
