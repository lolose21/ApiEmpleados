package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;

public class RepositoryEmpleado {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        String cadena
                = "jdbc:sqlserver://sqlserverjavaisma.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn = DriverManager.getConnection(cadena, "admiinsql", "Admin123");
        return cn;
    }

    public List<Empleado> getEmpleado() throws SQLException {

        Connection cn = this.getConnection();
        String sql = "select * from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int empno = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("oficio");
            int salario = rs.getInt("SALARIO");
            int deptno = rs.getInt("DEPT_NO");
            Empleado empleado = new Empleado(empno, apellido, oficio, salario, deptno);
            empleados.add(empleado);
        }
        rs.close();
        cn.close();
        return empleados;
    }

    public Empleado getEmpleadoNo(int empno) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from emp where emp_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, empno);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("oficio");
            int salario = rs.getInt("SALARIO");
            int deptno = rs.getInt("DEPT_NO");
            Empleado empleado = new Empleado(id, apellido, oficio, salario, deptno);
            rs.close();
            cn.close();
            return empleado;
        } else {
            rs.close();
            cn.close();
            return null;
        }

    }
}
