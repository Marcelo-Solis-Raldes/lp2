
package Aluno_Professor;

/**
 *
 * @author Mrcelo
 */
public class Aluno extends Pessoa{
    
     private String ra;
    
    public Aluno(){
      
    }
    public Aluno(String nome, int idade, String cpf, String sexo){
        super(nome, idade, cpf, sexo);
    }
    public Aluno(String nome, int idade, String cpf, String sexo, String ra){
        super(nome, idade, cpf, sexo);
        this.ra=ra;
    }
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Aluno{" +"\nNome: "+this.getNome() +"\nIdade: "+this.getIdade()+"\nSexo: "
        +this.getSexo()+ "\nra=" + ra +"\nCPF="+this.getCpf()+ "\n"+'}';
    }
}
