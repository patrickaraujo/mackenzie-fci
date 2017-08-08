/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.LoCar.dao;

import com.br.LoCar.javabeans.User;
import com.br.LoCar.connection.SingletonConnection;
import com.br.LoCar.javabeans.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windows
 */
public class UserDAO implements GenericDAO <User>{

    @Override
    public boolean insert(User e) {
        boolean result = false;
        //Passo 1
        Connection con = SingletonConnection.getInstance().getConnection();
        String sql = "INSERT INTO user(email, password) VALUES(?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, e.getEmail());
            pst.setString(2, e.getPassword());

            int resp = pst.executeUpdate();
            long key = 0;
            ResultSet keys = pst.getGeneratedKeys();
            while(keys.next()){
                key = keys.getLong(1);
            }
            if(resp>0){
                //Passo 2b
                String sqlb = "INSERT INTO userinfo VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstb = con.prepareStatement(sqlb);
                pstb.setLong(1, key);
                pstb.setString(2, e.getUserInfo().getName());
                pstb.setString(3, e.getUserInfo().getLastName());
                pstb.setString(4, e.getUserInfo().getAddress());
                pstb.setString(5, String.valueOf(e.getUserInfo().getCpf()));
                pstb.setString(6, String.valueOf(e.getUserInfo().getCnpj()));
                pstb.setString(7, String.valueOf(e.getUserInfo().getTel()));
                pstb.setString(8, e.getUserInfo().getAccessTypeString());
                pstb.setDate    (9, new java.sql.Date  (
                                                            e.getUserInfo().getBirthday().getTime()
                                                        )
                                );
                pstb.setDate    (10, (java.sql.Date) new Date());
            
                //Passo 3b e 4b
                result = pstb.execute();
                
                //Passo 5b
                pstb.close();
            }
            
            pst.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        //Passo 1 - Estabelecer a conexão
        Connection con = SingletonConnection.getInstance().getConnection();
        //Passo 2 - Criar um statement
        String sql = "SELECT * FROM user INNER JOIN userInfo ON id = id";
        
        try {
            Statement stm = con.createStatement();

            //Passo 3 - executar a consulta
            ResultSet rs = stm.executeQuery(sql);

            //Passo 4 - tratar os resultados
            while (rs.next()) {
                User u = new User();
                UserInfo ui = new UserInfo();
                
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setId(rs.getLong("id"));
                
                ui.setName(rs.getString("name"));
                ui.setLastName(rs.getString("lastName"));                
                ui.setAddress(rs.getString("address"));
                ui.setCpf(rs.getLong("cpf"));
                ui.setCnpj(rs.getLong("cnpj"));
                ui.setTel(rs.getLong("tel"));
                java.sql.Date bday = rs.getDate("birthday");
                ui.setBirthday(new java.util.Date(bday.getTime()));
                ui.setId(rs.getLong("id"));
                
                users.add(u);
            }
            stm.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(long id) {
        User user = new User();
        //Passo 1
        Connection con = SingletonConnection.getInstance().getConnection();

        //Passo 2
        String sql = "SELECT * FROM user INNER JOIN userInfo ON id = id WHERE id=?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, id);
            
            //Passo 3
            ResultSet rs = pst.executeQuery();
            
            //Passo 4
            while (rs.next()) {
                UserInfo ui = new UserInfo();
                
                user.setUserInfo(ui);
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getLong("id"));
                
                ui.setName(rs.getString("name"));
                ui.setLastName(rs.getString("lastName"));                
                ui.setAddress(rs.getString("address"));
                ui.setCpf(rs.getLong("cpf"));
                ui.setCnpj(rs.getLong("cnpj"));
                ui.setTel(rs.getLong("tel"));
                java.sql.Date bday = rs.getDate("birthday");
                ui.setBirthday(new java.util.Date(bday.getTime()));
                ui.setId(rs.getLong("id"));
            }
            pst.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    @Override
    public User findByEmail(String email) {
        User user = null;
        //Passo 1
        Connection con = SingletonConnection.getInstance().getConnection();

        //Passo 2
        String sql = "SELECT * FROM user INNER JOIN userInfo ON id = id WHERE email = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            
            //Passo 3
            ResultSet rs = pst.executeQuery();
            
            //Passo 4
            while (rs.next()) {
                UserInfo ui = new UserInfo();
                user = new User();
                
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getLong("id"));
                user.setUserInfo(ui);
                
                ui.setName(rs.getString("name"));
                ui.setLastName(rs.getString("lastName"));                
                ui.setAddress(rs.getString("address"));
                ui.setCpf(rs.getLong("cpf"));
                ui.setCnpj(rs.getLong("cnpj"));
                ui.setTel(rs.getLong("tel"));
                java.sql.Date bday = rs.getDate("birthday");
                ui.setBirthday(new java.util.Date(bday.getTime()));
                ui.setId(rs.getLong("id"));
            }
            pst.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
        
    }
    
    @Override
    public boolean modify(User e) {
        boolean result = false;
        //Passo 1
        Connection con = SingletonConnection.getInstance().getConnection();
        
        //Passo 2
        String sql = "UPDATE userlp2 SET email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, e.getEmail());
            pst.setString(2, e.getPassword());
            pst.setLong(3, e.getId());
            
            //Passo 3
            int result2 = pst.executeUpdate();
            
            //Passo 4
            if(result2>0){
                System.out.println("AQUI");
                //Passo 2 b
                String sqlb = "UPDATE userinfo SET name = ?, lastname = ?, birthday = ?, address = ?, cpf = ?, cnpj = ?, tel = ?, date = ? WHERE id = ?";
                PreparedStatement pstb = con.prepareStatement(sqlb);
                pstb.setString(1, e.getUserInfo().getName());
                pstb.setString(2, e.getUserInfo().getLastName());
                pstb.setString(3, e.getUserInfo().getAddress());
                pstb.setLong(4, e.getUserInfo().getCpf());
                pstb.setLong(5, e.getUserInfo().getCnpj());
                pstb.setLong(6, e.getUserInfo().getTel());
                pstb.setDate(7, new java.sql.Date   (
                                                        e.getUserInfo().getBirthday().getTime())
                                                    );
//                pstb.setString(5, "");
                pstb.setLong(8, e.getUserInfo().getId());
                
                //Passo 3b e 4b (JUNTOS) 
                result = (pstb.executeUpdate()>0);
                
                //Passo 5b
                pstb.close();
            }
            
            //Passo 5
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(User e) {
        boolean result = false;
        //Passo 1
        Connection con = SingletonConnection.getInstance().getConnection();
        
        //Passo 2
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, e.getId());
            
            //Passo 3
            int resp = pst.executeUpdate();
            
            //Passo 4
            if(resp>0) result = true;
            
            //Passo 5
            pst.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                
        return result;
    }

       
}
