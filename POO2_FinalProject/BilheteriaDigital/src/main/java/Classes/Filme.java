package Classes;

import java.util.ArrayList;

public class Filme {

    private String nomeFilme, sinopse, diretor, produtora, codigo, idade;
    private float valorIngresso;
    private int qntdIngressos;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Filme(String nomeFilme, String sinopse, String diretor, String produtora, String codigo, float valorIngresso, String idade, int qntdIngressos) {
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.produtora = produtora;
        this.codigo = codigo;
        this.valorIngresso = valorIngresso;
        this.idade = idade;
        this.qntdIngressos = qntdIngressos;
    }

// Add a method to register new observers
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

// Add a method to notify all registered observers
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static class FilmeBuilder {

        private String nomeFilme, sinopse, produtora, diretor, codigo, idade;
        private float valorIngresso;
        private int qntdIngressos;

        public FilmeBuilder() {
        }

        public FilmeBuilder nomeFilme(String nomeFilme) {
            this.nomeFilme = nomeFilme;
            return this;
        }

        public FilmeBuilder valorIngresso(float valorIngresso) {
            this.valorIngresso = valorIngresso;
            return this;
        }

        public FilmeBuilder sinopse(String sinopse) {
            this.sinopse = sinopse;
            return this;
        }

        public FilmeBuilder idade(String idade) {
            this.idade = idade;
            return this;
        }

        public FilmeBuilder qntdIngressos(int qntdIngressos) {
            this.qntdIngressos = qntdIngressos;
            return this;
        }

        public FilmeBuilder produtora(String produtora) {
            this.produtora = produtora;
            return this;
        }

        public FilmeBuilder diretor(String diretor) {
            this.diretor = diretor;
            return this;
        }

        public FilmeBuilder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Filme criarFilme() {
            return new Filme(nomeFilme, sinopse, diretor, produtora, codigo, valorIngresso, idade, qntdIngressos);
        }
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public float getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(float valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getQntdIngressos() {
        return qntdIngressos;
    }

    public void setQntdIngressos(int qntdIngressos) {
        this.qntdIngressos = qntdIngressos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Filme{" + "nomeFilme=" + nomeFilme + ", sinopse=" + sinopse + ", diretor=" + diretor + ", produtora=" + produtora + ", codigo=" + codigo + ", idade=" + idade + ", valorIngresso=" + valorIngresso + ", qntdIngressos=" + qntdIngressos + '}';
    }

}
