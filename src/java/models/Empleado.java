package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empleado {

    private int empno;
    private String apellido;
    private String oficio;
    private int salario;
    private int deptno;

    public Empleado() {
    }

    public Empleado(int empno, String apellido, String oficio, int salario, int deptno) {
        this.empno = empno;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

}
