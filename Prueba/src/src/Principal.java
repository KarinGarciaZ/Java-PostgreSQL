package src;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] argv) {
	try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
            return;
	}
        System.out.println("PostgreSQL JDBC Driver Registered!");   
	Connection connection = null;
        try {
            Scanner leer = new Scanner(System.in);
            int opc, opc2;
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Localidades", "postgres","Bankai123");
            do{
                System.out.println("\n-------------------------------");
                System.out.println("1.- Ciudades.");
                System.out.println("2.- Municipios.");
                System.out.println("3.- Estados.");
                System.out.println("4.- Salir.");                
                System.out.print("Ingresar opcion:  ");
                opc = leer.nextInt();
                if (opc > 0 && opc < 4){
                    System.out.println("\n1.- Insertar.");
                    System.out.println("2.- Consultar.");
                    System.out.println("3.- Eliminar.");
                    System.out.println("4.- Modificar.");
                    System.out.print("Ingresar opcion:  ");
                    opc2 = leer.nextInt();
                    
                    switch (opc){
                        case 1:
                        {
                            switch (opc2){
                                case 1:
                                {
                                    System.out.print("\nId a insertar: ");
                                    int id = leer.nextInt();
                                    
                                    leer.nextLine();
                                    System.out.print("Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    
                                    System.out.print("Id Municipio a insertar: ");
                                    int idM = leer.nextInt();
                                    
                                    System.out.print("Id Estado a insertar: ");
                                    int idE = leer.nextInt();
                                    
                                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO public.\"Ciudades\"(id, nombre, \"idMunicipio\", \"idEstado\") VALUES (" + id + ",'" + nom + "'," + idM + "," + idE + ")");
                                    stmt.executeUpdate();
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre, \"idMunicipio\", \"idEstado\" FROM public.\"Ciudades\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    System.out.println("ID Ciudad  ID Municipio  ID Estado  Nombre");
                                    while(Rs.next())
                                        System.out.println("    " + Rs.getInt(1) + "            " + Rs.getInt(3) + "            " + Rs.getInt(4) + "      " +Rs.getString(2));   
                                    break;
                                }
                                case 3:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Ciudades\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a eliminar: ");
                                    int eli = leer.nextInt();
                                    stmt = connection.prepareStatement("DELETE FROM public.\"Ciudades\" WHERE id = " + eli + "");
                                    stmt.executeUpdate();
                                    
                                    break;
                                }
                                case 4:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Ciudades\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a modificar: ");
                                    int mod = leer.nextInt();   
                                    
                                    System.out.print("Id a insertar: ");
                                    int id = leer.nextInt();
                                                                        
                                    leer.nextLine();
                                    System.out.print("Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    
                                    System.out.print("Id Municipio a insertar: ");
                                    int idM = leer.nextInt();
                                    
                                    System.out.print("Id Estado a insertar: ");
                                    int idE = leer.nextInt();                                    
                                    
                                    stmt = connection.prepareStatement("UPDATE public.\"Ciudades\" SET id=" + id + ", nombre='" + nom + "' WHERE id = " + mod + ", \"idMunicipio\"=" + idM + ", \"idEstado\"= " + idE);
                                    stmt.executeUpdate();
                                    break;
                                }
                            }
                            break;
                        }
                        case 2:
                        {
                            switch (opc2){
                                case 1:
                                {
                                    System.out.print("\n1.- Id a insertar: ");
                                    int id = leer.nextInt();
                                    
                                    leer.nextLine();
                                    System.out.print("2.- Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO public.\"Municipios\"(id, nombre) VALUES (" + id + ",'" + nom + "')");
                                    stmt.executeUpdate();
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Municipios\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));   
                                    break;
                                }
                                case 3:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Municipios\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a eliminar: ");
                                    int eli = leer.nextInt();
                                    stmt = connection.prepareStatement("DELETE FROM public.\"Municipios\" WHERE id = " + eli + "");
                                    stmt.executeUpdate();
                                    
                                    break;
                                }
                                case 4:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Municipios\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a modificar: ");
                                    int mod = leer.nextInt();   
                                    
                                    System.out.print("1.- Id a insertar: ");
                                    int id = leer.nextInt();
                                                                        
                                    leer.nextLine();
                                    System.out.print("2.- Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    
                                    stmt = connection.prepareStatement("UPDATE public.\"Municipios\" SET id=" + id + ", nombre='" + nom + "' WHERE id = " + mod);
                                    stmt.executeUpdate();
                                    break;
                                }
                            }
                            break;
                        }
                        case 3:
                        {
                            switch (opc2){
                                case 1:
                                {
                                    System.out.print("\n1.- Id a insertar: ");
                                    int id = leer.nextInt();
                                    
                                    leer.nextLine();
                                    System.out.print("2.- Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    PreparedStatement stmt = connection.prepareStatement("INSERT INTO public.\"Estados\"(id, nombre) VALUES (" + id + ",'" + nom + "')");
                                    stmt.executeUpdate();
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Estados\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));   
                                    break;
                                }
                                case 3:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Estados\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a eliminar: ");
                                    int eli = leer.nextInt();
                                    stmt = connection.prepareStatement("DELETE FROM public.\"Estados\" WHERE id = " + eli + "");
                                    stmt.executeUpdate();
                                    
                                    break;
                                }
                                case 4:
                                {
                                    System.out.println("\n--------CONSULTA GENERAL---------");
                                    PreparedStatement stmt = connection.prepareStatement("SELECT id, nombre FROM public.\"Estados\"");
                                    ResultSet Rs = stmt.executeQuery();
                                    while(Rs.next())
                                        System.out.println(Rs.getInt(1) + "     " + Rs.getString(2));
                                    
                                    System.out.print("Id de elemento a modificar: ");
                                    int mod = leer.nextInt();   
                                    
                                    System.out.print("1.- Id a insertar: ");
                                    int id = leer.nextInt();
                                                                        
                                    leer.nextLine();
                                    System.out.print("2.- Nombre a insertar: ");
                                    String nom = leer.nextLine();
                                    
                                    stmt = connection.prepareStatement("UPDATE public.\"Estados\" SET id=" + id + ", nombre='" + nom + "' WHERE id = " + mod);
                                    stmt.executeUpdate();
                                    break;
                                }
                            }
                            break;
                        }                        
                    }
                }               
                                                
            }while(opc != 4);          
                        
        }catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }             
    } 
}
