/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;

import org.casaortiz.dao.interfaces.ICrud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.Category;

/**
 * CRUD a Category
 *
 * @author Ing. Jorge Luis Ortiz Cáceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class CategoryDao implements ICrud<Category> {

    ConnectionDBPostgres connectionDBOracle;

    public CategoryDao() {
        connectionDBOracle = new ConnectionDBPostgres();
    }

    @Override
    public void insert(Category item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {

            PreparedStatement st = conn.prepareStatement("insert into category (name, description) values (?,?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Category: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public void update(Category item) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("update category set name = ?, description = ? where id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setInt(3, item.getId());
            st.execute();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar Category: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from category where id = " + id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception(e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    public Category get(int id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Category item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category c where c.id =" + id);
            rs = st.executeQuery();
            if (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la categoria: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la categoria: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    public List<Category> getList() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Category> items;
        Category item;
        try {
            items = new ArrayList<Category>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener categories: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener categories: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Para realizar busquedas en los
     * registros category
     *
     * @param texto - Lo que va a buscar
     * @return List<Category>
     * @throws Exception
     */
    public List<Category> searchList(String texto) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Category> items;
        Category item;
        try {
            items = new ArrayList<Category>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category where upper(id ||' '|| name ||' '||description) like upper('%" + texto + "%')");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener categories: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al buscar categories: \n" + e.getMessage());
        } finally {
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
}
