package com.pi4.ecommerce.entity;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prd_id")
    private long id_produto;

    @Column(name = "prd_nome", length = 200)
    private String nome;

    @Column(name = "prd_descricao", length = 200)
    private String descricao;

    @Column(name = "prd_custo")
    private double preco_custo;

    @Column(name = "prd_venda")
    private double preco_venda;

    @Column(name = "prd_quantidade")
    private int quantidade;
    
    @Lob
    @Column(name = "prd_imagem", length = Integer.MAX_VALUE, nullable = true)
    private byte[] imagem;
    
    @Column(name = "prd_status")
    private boolean active=true;
    
    public Produto(){
        
    }


    public long getId_produto() {
        return id_produto;
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", nome=" + nome + ", descricao=" + descricao + ", preco_custo=" + preco_custo + ", preco_venda=" + preco_venda + ", quantidade=" + quantidade + ", imagem="
				+ Arrays.toString(imagem) + ", active=" + active + "]";
	}
 
}
