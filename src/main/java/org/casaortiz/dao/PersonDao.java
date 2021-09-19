/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.casaortiz.dao.interfaces.ICrud;
import org.casaortiz.db.ConnectionDBPostgres;
import org.casaortiz.model.Person;

/**
 * CRUD a Person
 *
 * @author Ing. Jorge Luis Ortiz C�ceres
 * @since 31/08/2021
 * @version 0.0.1
 */
public class PersonDao implements ICrud<Person>{

    ConnectionDBPostgres connectionDBOracle;

    public PersonDao() {
        connectionDBOracle = new ConnectionDBPostgres();
    }

    /**
     * Call procedure PERSON_API.INS(p_name, p_description): Inserta un
     * registro a person
     *
     * @param item Person
     * @throws SQLException
     * @throws Exception
     */
    public void insert(Person item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement("insert into person (first_name, last_name, identification_id, address, "
                    + "email, birthday, phone, active, photo, type_person_id) values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, item.getFirstName());
            st.setString(2, item.getLastName());
            st.setString(3, item.getIdentificationId());
            st.setString(4, item.getAddress());
            st.setString(5, item.getEmail());
            st.setDate(6, new java.sql.Date(item.getBirthday().getTime()));
            st.setString(7, item.getPhone());
            st.setString(8, item.getActive());
            st.setString(9, item.getPhoto());
            st.setInt(10, item.getTypePersonId());
            st.execute();
            st.close();
            
            
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al insertar Person: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Call procedure PERSON_API.UPD(p_id, p_name, p_description) Actualiza
     * un registro de la Person
     *
     * @param item Person
     * @throws SQLException
     * @throws Exception
     */
    public void update(Person item) throws SQLException, Exception {
        Connection conn = null;
        conn = connectionDBOracle.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE public.person\n" +
                                "SET first_name=?, last_name=?, identification_id=?, address=?, email=?, birthday=?, phone=?, active=?, photo=?, type_person_id=?\n" +
                                "WHERE id=?");
            st.setString(1, item.getFirstName());
            st.setString(2, item.getLastName());
            st.setString(3, item.getIdentificationId());
            st.setString(4, item.getAddress());
            st.setString(5, item.getEmail());
            st.setDate(6, new java.sql.Date(item.getBirthday().getTime()));
            st.setString(7, item.getPhone());
            st.setString(8, item.getActive());
            st.setString(9, item.getPhoto());
            st.setInt(10, item.getTypePersonId());
            st.setInt(11, item.getId());
            st.execute();
            st.close();
            
            
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al actualizar Person: \n" + e.getMessage());
        } finally {
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Call procedure PERSON_API.DEL(p_id) Elimina un registro de la Person
     *
     * @param id - Id de la Person
     * @throws SQLException
     * @throws Exception
     */
    public void delete(int id) throws SQLException, Exception {
        Connection conn = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("delete from Person where id = "+id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            connectionDBOracle.closeConnection(conn);
            throw new Exception(e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * Call procedure PERSON_API.getPerson(p_id, Person_c) Obtengo un
     * registro a partir del id
     *
     * @param id - Id Person
     * @return Person
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public Person get(int id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Person item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from person c where c.id ="+id);
            rs = st.executeQuery();
            if(rs.next()){
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la Person: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la Person: \n" +e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }
    
    /**
     * Obtengo la persona mediante su cedula
     * @param identification_id cedula
     * @return Persona
     * @throws SQLException
     * @throws Exception 
     */
    public Person getPerIdentification_id(String identification_id) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        Person item = null;
        try {
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from person c where c.identification_id ='"+identification_id+"'");
            rs = st.executeQuery();
            if(rs.next()){
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
            }
            rs.close();
            return item;
        } catch (Exception e) {
            System.out.println("Error al obtener la Person: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la Person: \n" +e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * call procedure PERSON_API.LIST(Person_c) Recupero una lista de People
     *
     * @return List<Person>
     * @throws SQLException
     * @throws Exception
     */
    public List<Person> getList() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Person> items;
        Person item;
        try {
            items = new ArrayList<Person>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from person");
            rs = st.executeQuery();
            while(rs.next()){
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener People: " + e.getMessage());
            rs.close();
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener People: \n" + e.getMessage());
        }finally{
            rs.close();
            connectionDBOracle.closeConnection(conn);
        }
    }

    /**
     * call procedure PERSON_API.SEARCH(texto) Para realizar busquedas en
     * los registros Person
     *
     * @param texto - Lo que va a buscar
     * @return List<Person>
     * @throws Exception
     */
    public List<Person> searchList(String texto) throws Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Person> items;
        Person item;
        try {
            items = new ArrayList<Person>();
            conn = connectionDBOracle.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from person where upper(first_name ||' '|| last_name "
                    + "||' '||identification_id) like upper('%"+texto+"%')");
            rs = st.executeQuery();
            while(rs.next()){
                item = new Person();
                item.setId(rs.getInt("id"));
                item.setFirstName(rs.getString("first_name"));
                item.setLastName(rs.getString("last_name"));
                item.setIdentificationId(rs.getString("identification_id"));
                item.setAddress(rs.getString("address"));
                item.setEmail(rs.getString("email"));
                item.setBirthday(rs.getDate("birthday"));
                item.setPhone(rs.getString("phone"));
                item.setActive(rs.getString("active"));
                item.setPhoto(rs.getString("photo"));
                item.setTypePersonId(rs.getInt("type_person_id"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener People: " + e.getMessage());
            connectionDBOracle.closeConnection(conn);
            throw new Exception("Error al obtener People: \n" + e.getMessage());
        }finally{
            connectionDBOracle.closeConnection(conn);
        }
    }
}
