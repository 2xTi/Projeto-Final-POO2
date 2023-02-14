package Classes;

import java.util.ArrayList;

public class User implements Observer {

    private String cpf;
    private String nomeCompleto;
    private String senha;
    private ArrayList<Filme> meusFilmes = new ArrayList<>();

    public User(String cpf, String nomeCompleto, String senha) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
        System.out.println(cpf+senha+nomeCompleto);
    }

    @Override
    public void update() {
        //System.out.println("Ingressos disponíveis para o filme " + this.getNomeFilme() + " foram atualizados!");
    }

    public void comprarIngresso(Filme filme) {
        if (filme.getQntdIngressos() > 0) {
            filme.setQntdIngressos(filme.getQntdIngressos() - 1);
            meusFilmes.add(filme);
        } else {

            System.out.println("Ingressos esgotados para este filme.");
        }
    }


public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public ArrayList<Filme> getMeusFilmes() {
        return meusFilmes;
    }

    public void setMeusFilmes(ArrayList<Filme> meusFilmes) {
        this.meusFilmes = meusFilmes;
    }

    @Override
    public String toString() {
        return "User{" + "cpf=" + cpf + ", nomeCompleto=" + nomeCompleto + ", senha=" + senha + ", meusFilmes=" + meusFilmes + '}';
    }
    
    
}
