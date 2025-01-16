package Pb1;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Scanner;

public class MainApp {
    public static void afisare_tabela_cautat(Statement statement, String mesaj) {
        String sql
                ="select * from persoane";
        System.out.println("\n---"
                +mesaj
                +"---");
        try(ResultSet rs
                    =statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="
                        + rs.getInt(3));
        } catch (SQLException
                e) {
            e.printStackTrace();
        }
    }
    public static void afisare_tabela(Statement statement,Connection con) {
        String sql
                ="select * from persoane";
        try(ResultSet rs
                    =statement.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="
                        + rs.getInt(3));
                PreparedStatement statement1 = con.prepareStatement("select * from excursii where id_persoana=?");
                statement1.setInt(1, rs.getInt(1));
                ResultSet rs1 = statement1.executeQuery();
                while (rs1.next())
                    System.out.println("id_pers=" + rs1.getInt(1) + ", id_excurc=" + rs1.getInt(2) + ",destinatie= "
                            + rs1.getString(3) + ",an= " + rs1.getInt(4));
            }
            } catch (SQLException
                e) {
            e.printStackTrace();
        }
    }
    public static int cautarePersoana(Connection con, int id1) throws SQLException {
        PreparedStatement  statement=con.prepareStatement("select count(*) from persoane where id=?");
        statement.setInt(1,id1);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
            return 1;
        return 0;
    }
    public static void adaugarePersoana(Connection connection,int id, String nume, int varsta) {
        String sql="insert into persoane values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setInt(3, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void adaugareExcursie(Connection connection,int id_excurise, int id_persoana,
                                        String destinatie, int an) {
        String sql="insert into excursii values (?,?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id_persoana);
            ps.setInt(2, id_excurise);
            ps.setString(3, destinatie);
            ps.setInt(4, an);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String dbUsername = dotenv.get("PASS");
        String url = "jdbc:mysql://localhost:3306/persoane";
        Scanner scanner = new Scanner(System.in);
        try {

            Connection connection = DriverManager.getConnection(url, "root", dbUsername);
            Statement statement = connection.createStatement();
            System.out.println("Cerinta 1");
            System.out.print("Varsta: ");
            int varsta = scanner.nextInt();
            System.out.print("Id: ");
            int id = scanner.nextInt();
            System.out.print("Nume: ");
            String nume = scanner.next();
            adaugarePersoana(connection, id, nume, varsta);
            System.out.println("Cerinta 2");
            System.out.println("Id Persoana: ");
            int id_pers;
            do {
                id_pers = scanner.nextInt();
                if(cautarePersoana(connection, id_pers)!=1)
                    System.out.println("Aceasta persoana nu exista");
            } while (cautarePersoana(connection, id_pers)!=1);
            System.out.println("Id_excursie:");
            int id_excursie = scanner.nextInt();
            System.out.println("Destinatie: ");
            String destinatie = scanner.next();
            System.out.println("An: ");
            int an = scanner.nextInt();
            adaugareExcursie(connection, id_excursie, id_pers, destinatie, an);
            System.out.println("Cerinta 3");
            afisare_tabela(statement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
}