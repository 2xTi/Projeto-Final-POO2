
package Classes;

import java.util.ArrayList;

    public class DadosFacade  {
        
    private ArrayList<User> usuarios = new ArrayList<>();
    private ArrayList<Filme> filmes = new ArrayList<>();
    private int indexUserLogado;

    public DadosFacade() {}

    public User getUser(int indexUser){
        return usuarios.get(indexUser);
    }

    public int getIndexUserLogado() {
        return indexUserLogado;
    }
    public void deletaUser(User user){
     usuarios.remove(user);
        System.out.println("removeu");
    }

    public void setIndexUserLogado(int indexUserLogado) {
        this.indexUserLogado = indexUserLogado;
    }

    
    public boolean verificaCodFilme(String codFilme) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getCodigo().equals(codFilme)) {
                System.out.println("ESSE CODIGO JA FOI UTILIZADO EM UM FILME!!");
               return false;
            }
        }
            System.out.println("Codigo nunca utilizado!");
            return true;
    }

    public void cadastrarFilme(Filme newFilme) {
        filmes.add(newFilme);
        System.out.println(newFilme.toString());
    }

    public void alterarDadosFilme(Filme newFilme) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getCodigo().equals(newFilme.getCodigo())) {
               
                filmes.get(i).setNomeFilme(newFilme.getNomeFilme());
                filmes.get(i).setSinopse(newFilme.getSinopse());
                filmes.get(i).setValorIngresso(newFilme.getValorIngresso());
                filmes.get(i).setQntdIngressos(newFilme.getQntdIngressos());
                filmes.get(i).setIdade(newFilme.getIdade());
                filmes.get(i).setDiretor(newFilme.getDiretor());
                filmes.get(i).setProdutora(newFilme.getProdutora());
                System.out.println("DADOS DO EVENTO ALTERADOS COM SUCESSO!!");
                break;
            }
        }
    }
    
    public ArrayList<Filme> getFilme() {
        return filmes;
    }

    // COD USER
    public ArrayList<User> getUsers() {
        return usuarios;
    }

    public boolean verificaUser(String cpf) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpf)) {
                System.out.println("CPF JA CADASTRADO!!");
                return false;           
            }
        }
            System.out.println("CADASTRO FEITO COM SUCESSO!");
            return true;
        
    }

    public int indexUser(String cpf) {
        int indexUser = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpf)) {
                indexUser = i;
                System.out.println("USUARIO ENCONTRADO!!");
                break;
            }
        }
        return indexUser;
    }
    
    

    public void cadastrarUsuario(User newUser) {
        usuarios.add(newUser);
    }

    public void alterarSenha(String cpf, String novaSenha) {
        boolean trocou = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpf)) {
                usuarios.get(i).setSenha(novaSenha);
                trocou = true;
                System.out.println("SENHA ALTERADA COM SUCESSO!!");
                break;
            }
        }
        if (!trocou) {
            System.out.println("NAO FOI POSSIVEL ALTERAR A SENHA!!");
        }
    }

    // LOGIN COD
    public boolean validarLogin(String cpf, String password) {
        boolean valido = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCpf().equals(cpf) && usuarios.get(i).getSenha().equals(password)) {
                System.out.println("LOGIN FEITO COM SUCESSO!!");
                this.indexUserLogado = i;
                valido = true;
            } else {
                System.out.println("CPF OU SENHA INCORRETOS!!");
            }
        }
        return valido;
    }
}
