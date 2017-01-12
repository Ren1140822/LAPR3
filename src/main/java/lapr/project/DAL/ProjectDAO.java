/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Project;
import lapr.project.utils.DAL;
import static lapr.project.utils.DAL.close;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class ProjectDAO {
    
    DAL dal;
    
    public ProjectDAO() {
        dal = new DAL();
    }
    
    public List<Project> getAllProjects() {
        List<Project> projList = new LinkedList<>();
        ResultSet rs = null;
        Connection con = null;
        String query = "{?= call get_projects()}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                
                int projID = rs.getInt("ID");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                Project p = new Project();
                p.setIdProject(projID);
                p.setName(name);
                p.setDescription(desc);
                projList.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return projList;
    }
    
    public boolean createProject(Project p) {
        Connection con = null;
        con = dal.connect();
        boolean ret = false;
        
        try (CallableStatement st = con.prepareCall("{call insert_project(?,?)}")) {
            st.setString(2, p.getDescription());
            st.setString(1, p.getName());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } finally {
            
            close(con);
        }
        
        return ret;
    }
    
    public int getProjectID() {
        int projID = 0;
        ResultSet rs = null;
        Connection con = null;
        String query = "{? = call get_last_project_id()}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.registerOutParameter(1, java.sql.Types.INTEGER);
            st.execute();
            // rs =  st.executeQuery();

            projID = st.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return projID;
    }
    
    public List<String> getProject(int id) {
        int projID = 0;
        List<String> projAttributes = new LinkedList<>();
        ResultSet rs = null;
        Connection con = null;
        String query = "{? = call get_project(?)}";
        con = dal.connect();
        
        try (CallableStatement st = con.prepareCall(query)) {
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setInt(2, id);
            st.execute();
            rs = (ResultSet) st.getObject(1);
            while (rs.next()) {
                projID = rs.getInt(1);
                String projDesc = rs.getString("description");
                String name = rs.getString("name");
                projAttributes.add(String.valueOf(projID));
                projAttributes.add(name);
                projAttributes.add(projDesc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return projAttributes;
    }
}
