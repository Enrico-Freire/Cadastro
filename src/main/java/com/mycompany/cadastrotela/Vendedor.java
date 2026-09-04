/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrotela;

/**
 *
 * @author enric
 */
public class Vendedor {
    
    private String nome;
    private int cpf;
    private float comissao;
    
    public Vendedor(String nome, int cpf, float comissao) {
        this.nome= nome;
        this.cpf= cpf;
        this.comissao= comissao;
    }
    
    public String setNome(){
        this.nome=nome;
        return this.nome;
    }
    
    public int setCpf(){
        this.cpf=cpf;
        return this.cpf;
    }
    
    public float setComissao(){
        this.comissao=comissao;
        return this.comissao;
    }
}

    