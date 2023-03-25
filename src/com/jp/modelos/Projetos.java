/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.modelos;

/**
 *
 * @author aluno
 */
public class Projetos {
    
    private int id = 0;
    private String descricao = "";
    private String endereco = "";
    private float valorDoProjeto = 0.0f;
    
    public Projetos(){
        
    }
    
    public Projetos(int id, String descricao, String endereco, float valorDoProjeto){
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
        this.valorDoProjeto = valorDoProjeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getValorDoProjeto() {
        return valorDoProjeto;
    }

    public void setValorDoProjeto(float valorDoProjeto) {
        this.valorDoProjeto = valorDoProjeto;
    }
    
}
