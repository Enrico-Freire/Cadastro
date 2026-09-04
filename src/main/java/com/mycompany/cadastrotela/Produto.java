/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrotela;

/**
 *
 * @author enric
 */
public class Produto {
    public String nome, fabricante;
    public float peso, preco;
    
    public Produto(String nome, String fabricante, float peso, float preco){
        this.nome=nome;
        this.fabricante=fabricante;
        this.peso=peso;
        this.preco=preco;
    }
    
    public String setNome(){
        this.nome=nome;
        return this.nome;
    }
    public String setFabricante(){
        this.fabricante=fabricante;
        return this.fabricante;
    }
    public float setPeso(){
        this.peso=peso;
        return this.peso;
    }
    public float setPreco(){
        this.preco=preco;
        return this.preco;
    }
}