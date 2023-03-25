/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp.controle;

import com.jp.modelos.Lista;
import com.jp.modelos.Projetos;

/**
 *
 * @author aluno
 */
public interface IProjetosControle {
    
    void incluir(Projetos projeto) throws Exception;
    
    void alterar(Projetos projeto) throws Exception;
    
    Projetos excluir(int id) throws Exception;
    
    Lista<Projetos> listar() throws Exception;
    
    Lista<Projetos> filtrar(Projetos projeto) throws Exception;
    
}
