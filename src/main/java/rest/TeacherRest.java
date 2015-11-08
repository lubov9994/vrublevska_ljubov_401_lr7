package rest;

import dao.TeacherDAO;
import dao.TeacherManager;
import entity.Teacher;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Path("teacher")
@Stateless
@Produces({"application/json"})
public class TeacherRest {
    @EJB
    TeacherManager teacherDAO;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Teacher[] getTeachers() throws SQLException {
        List<Teacher> list = teacherDAO.getAll();
        Teacher[] array = new Teacher[list.size()];

        for (int i = 0; i < list.size();i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
