/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp.persistencia;

import com.jp.modelos.Lista;
import com.jp.modelos.Projetos;
import com.jp.tools.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class ProjetosDao implements IProjetosDao {

    private Connection conexao = null;
    
    public ProjetosDao() throws Exception {
      conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public void incluir(Projetos projeto) throws Exception {
        try{
            String sql = "insert into Projetos(descricao, endereco, valorDoProjeto) values (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setString(1, projeto.getDescricao());
            preparedStatement.setString(2, projeto.getEndereco());
            preparedStatement.setFloat(3, projeto.getValorDoProjeto());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            //Erro do comando SQL - chave, coluna, nome da tabela, ...
            throw new Exception("SQL Erro: "+ erro.getMessage());
        } catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public void alterar(Projetos projeto) throws Exception {
        try{
            String sql = "update Projetos set descricao = ?, endereco = ?, valorDoProjeto = ? where(id = ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setString(1, projeto.getDescricao());
            preparedStatement.setString(2, projeto.getEndereco());
            preparedStatement.setFloat(3, projeto.getValorDoProjeto());
            preparedStatement.setInt(4, projeto.getId());
            preparedStatement.executeUpdate();
        }catch(SQLException erro){
            throw new Exception("SQL Erro: "+ erro.getMessage());
        }catch(Exception erro){
            throw erro;
        }
    }

    @Override
    public Projetos excluir(int id) throws Exception {
        Projetos projeto = new Projetos();
        try{
            // Buscar o projeto antes de excluir
            String sql = "select * from Projetos where(id = ?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            // Parameters iniciar os elementos
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            
            projeto.setId(id);
            projeto.setDescricao(rs.getString("descricao"));
            projeto.setEndereco(rs.getString("endereco"));
            projeto.setValorDoProjeto(rs.getFloat("valorDoProjeto"));
            
            // Excluir o projeto
            sql = "delete from Projetos where(id = ?)";
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        }catch(SQLException erro){
            throw new Exception("SQL Erro: "+ erro.getMessage());
        }catch(Exception erro){
            throw erro;
        }
        
        return projeto;
    }

    @Override
    public Lista<Projetos> listar() throws Exception {
        Lista<Projetos> projetos = new Lista<>();
        try {
            String sql = "select * from projetos";
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                Projetos projeto = new Projetos();
                projeto.setId(rs.getInt("id"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setEndereco(rs.getString("endereco"));
                projeto.setValorDoProjeto(rs.getFloat("valorDoProjeto"));
                projetos.add(projeto);
            }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        
        return projetos;
    }
    
}
