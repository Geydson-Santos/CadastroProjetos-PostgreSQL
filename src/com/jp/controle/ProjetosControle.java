/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.controle;

import com.jp.modelos.Lista;
import com.jp.modelos.Projetos;
import com.jp.persistencia.IProjetosDao;
import com.jp.persistencia.ProjetosDao;

/**
 *
 * @author aluno
 */
public class ProjetosControle implements IProjetosControle {

    private IProjetosDao projetoPersistencia = null;

    public ProjetosControle() throws Exception{
        this.projetoPersistencia = new ProjetosDao();
    }
    
    @Override
    public void incluir(Projetos projeto) throws Exception {
        
        projetoPersistencia.incluir(projeto);
    }
    
    private boolean estaVazio(Projetos projeto){
        if(projeto.getDescricao().equals("")) return true;
        if(projeto.getEndereco().equals("")) return true;
        
        return false;
    }

    @Override
    public void alterar(Projetos projeto) throws Exception {
        projetoPersistencia.alterar(projeto);
    }

    @Override
    public Projetos excluir(int id) throws Exception {
        return projetoPersistencia.excluir(id);
    }

    @Override
    public Lista<Projetos> listar() throws Exception {
        return projetoPersistencia.listar();
    }

    @Override
    public Lista<Projetos> filtrar(Projetos projeto) throws Exception {
        Lista<Projetos> lista = new Lista<Projetos>();
        try{
            lista = listar();
            for(int i = 0; i < lista.getTamanho(); i++){
                boolean remover = false;
                if(projeto.getId() != 0) if(!("" + lista.get(i).getId()).contains("" + projeto.getId())) remover = true;
                if(!lista.get(i).getDescricao().contains(projeto.getDescricao())) remover = true;
                if(!lista.get(i).getEndereco().contains(projeto.getEndereco())) remover = true;

                if(remover){
                    lista.remove(i);
                    i--;
                }
            }
        }catch(Exception erro){
            throw erro;
        }
        
        return lista;
    }
    
}
