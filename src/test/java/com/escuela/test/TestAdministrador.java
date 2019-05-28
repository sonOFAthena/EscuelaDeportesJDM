
package com.escuela.test;
import com.escuela.dao.AdministradorDao;
import com.escuela.model.Administrador;
import java.util.ArrayList;
import java.util.List;

public class TestAdministrador 
{
    public static void main(String[] args) 
    {
        List<Administrador> adminArray= new ArrayList<>();
        AdministradorDao admin = new AdministradorDao();
        adminArray = admin.getAdministradores();
        admin.print2(adminArray);
    }
}
