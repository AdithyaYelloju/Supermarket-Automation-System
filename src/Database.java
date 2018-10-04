import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/SAS";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn=null;
    //inventorydetails()
    public ResultSet inventorydetails()
    {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from Employee");
            rs = stmt.executeQuery();
            if (rs != null) {
                return rs;
            }
        } catch (ClassNotFoundException | SQLException e) {

        }
        return rs;

    }
    
    public boolean addproduct(String id,String nam,String mrpp,String quantity)
    {
       try {
           
           int m = Integer.parseInt(mrpp);
           int q=Integer.parseInt(quantity);
           int tot=m*q;
           
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("insert into Employee (Id,Name,MRP,Quantity,Total) values(?,?,?,?,?)");
            stmt.setString(1,id);
            stmt.setString(2,nam);
            stmt.setInt(3,m);
            stmt.setInt(4,q);
            stmt.setInt(5,tot);
            int i = stmt.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Exception Found: "+e);
        }
        return false;
        
    }
    
 public boolean updateproductdetails(String id,String mr,String quant)
 {
     try {
           
           int m = Integer.parseInt(mr);
           int q=Integer.parseInt(quant);
           int tot=0;
           
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
            PreparedStatement stmt = conn.prepareStatement("select Quantity from Employee where Id=?");
            stmt.setString(1,id);
            ResultSet rs= stmt.executeQuery();
            if(rs.next())
            {
                int oldquant= rs.getInt("Quantity");
                System.out.println(oldquant);
                q=oldquant+q;
                PreparedStatement st = conn.prepareStatement("update Employee set MRP=?,Quantity=?,Total=? where Id=?");
                st.setInt(1,m);
                st.setInt(2,q);
                st.setInt(3,m*q);
                st.setString(4,id);
                
                int k= st.executeUpdate();
                if(k>0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                System.out.print("SOme problem");
                 return false;
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Exception Found: "+e);
        }
        return false;
     
 }

 public boolean login_enquiry(String username, String Password,String type) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String OrgUser = "";
            String OrgPass = "";

            PreparedStatement stmt = conn.prepareStatement("select * from Login where UserName=? and Password=? and type=? ");
            stmt.setString(1, username);
            stmt.setString(2, Password);
            stmt.setString(3,type);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
               
                System.out.println(rs.getString("UserName"));

                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
}