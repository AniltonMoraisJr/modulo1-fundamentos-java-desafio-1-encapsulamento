package br.com.unipds.fundamentosjava.desafio;

import static java.util.Objects.isNull;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.validarProduto(id, nome, preco, quantidadeEmEstoque);

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    private void validarProduto(int id, String nome, double preco, int quantidadeEmEstoque){
        if(id < 0)
            throw new IllegalArgumentException("Id can't be null or negative");
        if(isNull(nome) || nome.isBlank())
            throw new IllegalArgumentException("Nome can't be null or blank");
        if(preco < 0)
            throw new IllegalArgumentException("Preco can't be null or negative");
        if(quantidadeEmEstoque < 0)
            throw new IllegalArgumentException("Quantidade em estoque can't be null or negative");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void aumentarPreco(double aumento) {
        this.preco += aumento;
    }

    public void diminuirPreco(double diminuicao) {
        this.preco -= (diminuicao < 0 ? diminuicao * -1 : diminuicao);
        if(this.preco < 0)
            this.preco = 0;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void adicionarAoEstoque(int quantidade) {
        this.quantidadeEmEstoque += quantidade;
    }

    public void removerDoEstoque(int quantidade) {
        this.quantidadeEmEstoque -= (quantidade < 0 ? quantidade * -1 : quantidade);
        if(this.quantidadeEmEstoque < 0)
            this.quantidadeEmEstoque = 0;
    }

    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }
}
