package services;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Empleado;
import repositories.RepositoryEmpleado;

@Path("/empleado")
public class ServiceEmpleado {

    RepositoryEmpleado repo;

    public ServiceEmpleado() {
        this.repo = new RepositoryEmpleado();

    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Empleado> getEmpleados() throws SQLException {
        return this.repo.getEmpleado();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Empleado getEmpleadoNo(@PathParam("id") String id) throws SQLException {
        int empno = Integer.parseInt(id);
        return this.repo.getEmpleadoNo(empno);
    }
}
