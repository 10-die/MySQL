public class Driver 
{
    public static void main(String[] args)
    {
        databaseConnector dbConnector = new databaseConnector();
        dbConnector.connectToDatabase("SELECT * FROM tblstudents");
    }
}
