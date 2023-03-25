/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp.persistencia;

import com.jp.modelos.Lista;
import com.jp.modelos.Projetos;

/**
 *
 * @author aluno
 */
public interface IProjetosDao {
    
    void incluir(Projetos projeto) throws Exception;
    
    void alterar(Projetos projeto) throws Exception;
    
    Projetos excluir(int id) throws Exception;
    
    Lista<Projetos> listar() throws Exception;
    
}
