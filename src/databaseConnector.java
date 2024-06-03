import java.sql.*;
public class databaseConnector 
{
    String url = "jdbc:mysql://localhost:3306/student_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";

    public databaseConnector()
    {
        
    }

    public void connectToDatabase(String query)
    {
        try 
        {
            //Establish connection 
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement s = conn.createStatement();
            
            //Place all records retrieved in a result get
            ResultSet rs = s.executeQuery(query);

            // Iterate through the result set and display the records on the screen
            while (rs.next()) 
            {
                System.out.println(rs.getString("ID") + " " + rs.getString("FullName") + " " + rs.getString("Mobile"));
            }
            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
