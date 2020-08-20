import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.apache.tomcat.jdbc.pool.PoolProperties;

public class JDBCTest {
    public static void main(String a[])
    {
        //testTomcatJdbcConnPool();
        testPlainJdbcConn();
    }


    /*public static void testTomcatJdbcConnPool(){
        //tomcat jdbc connection pool

        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:oracle:thin:@ACT-DB-003639.voicelab.local:1521/ORCL");
        //p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        p.setUsername("FF_APP_DEV_17_RT");
        p.setPassword("password");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        Connection con = null;
        try {
            con = datasource.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from base_trx");
            int cnt = 1;
            System.out.println("Actimize_Transaction_key ");
            while(rs.next())
                System.out.println(rs.getString(6));
            rs.close();
            st.close();
        } catch(Exception e){}
        finally {
            if (con!=null) try {con.close();}catch (Exception ignore) {}
        }
    }
*/
    public static void testPlainJdbcConn() {
        //Creating the connection
        String url = "jdbc:oracle:thin:@ACT-DB-003639.voicelab.local:1521/ORCL";
        String user = "FF_APP_DEV_17_RT";
        String pass = "password";

        //Entering the data
        /*Scanner k = new Scanner(System.in);
        System.out.println("enter name");
        String name = k.next();
        System.out.println("enter roll no");
        int roll = k.nextInt();
        System.out.println("enter class");
        String cls =  k.next();*/

        //Inserting data using SQL query
        //String sql = "insert into student1 values('"+name+"',"+roll+",'"+cls+"')";
        String sql = "SELECT" +
                "  base_trx.trx_normalized_datetime AS \"transactionNormalizedDateTime\"," +
                "  base_trx.actimize_transaction_key AS \"actimizeTransactionKey\" ," +
                "  a.final_challenge_result AS \"finalCahllengeResult\" ," +
                "  a.challenge_response_code AS \"challngeResponseCode\" ," +
                "  b.authorization_decision_cd AS \"rejectedEventAuthDecisionCd\" ," +
                "  b.authorization_response_cd AS \"rejectedEventAuthResponseCd\" ," +
                "  b.actimize_authorization_dec_cd AS \"rejectedEventActAuthDecCd\" ," +
                "  b.rejected_type_cd AS \"rejectedEventTypeCd\" ," +
                "  b.actimize_rejected_type_cd AS \"rejectedEventActRejectTypeCd\"," +
                "  b.rejected_date AS \"rejectedEventDate\" ," +
                "  b.transaction_status_cd AS \"rejectedEventTrxStatusCd\" ," +
                "  b.actimize_transaction_status_cd AS \"rejectedEventActTrxStatusCd\" ," +
                "  CASE" +
                "  WHEN b.actimize_transaction_identity IS NOT NULL" +
                "  THEN 1" +
                "  ELSE 0" +
                "  END AS \"calculatedReject\"," +
                "  innerSelect.\"rownum\" AS \"rownum\" ," +
                "  r.trx_results AS \"trxResults\" ," +
                "  trx_data_vc AS \"trxDataVc\" ," +
                "  trx_data_ext AS \"trxDataExt\" ," +
                "  tw.state AS \"actimizeTwiState\" ," +
                "  tw.finding AS \"actimizeTwiFinding\"" +
                "  FROM" +
                "  (" +
                "  SELECT \"innerRowId\"," +
                "  rownum*(-1) AS \"rownum\"" +
                "  FROM" +
                "  (" +
                "  SELECT /*+ index_desc(BASE_TRX BASE_TRX_ACTIM_PARTY) */ base_trx.rowid AS \"innerRowId\"" +
                "  FROM base_trx" +
                "  WHERE" +
                "  ACTIMIZE_PARTY_KEY = ?" +
                "  AND base_trx.trx_normalized_datetime between ? AND ?" +
                "  AND" +
                "  (BASE_TRX.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  or" +
                "  BASE_TRX.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  )" +
                "   ORDER BY trx_normalized_datetime DESC " +
                "  )" +
                "  WHERE rownum" +
                "  <=200" +
                "  ) innerSelect" +
                "  inner join base_trx ON base_trx.rowid=innerSelect.\"innerRowId\"" +
                "  LEFT OUTER JOIN trx_challenge_appendix a" +
                "  ON" +
                "  base_trx.actimize_transaction_key = a.actimize_transaction_key" +
                "  AND base_trx.PARTITION_KEY = a.PARTITION_KEY" +
                "  AND" +
                "  (a.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  or" +
                "  a.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  )" +
                "  LEFT OUTER JOIN ff_reject_notifications b" +
                "  ON" +
                "  base_trx.actimize_transaction_identity = b.actimize_transaction_identity" +
                "  AND" +
                "  (b.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  or" +
                "  b.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  )" +
                "  LEFT OUTER JOIN base_trx_results r" +
                "  ON" +
                "  base_trx.actimize_transaction_key = r.actimize_transaction_key" +
                "  AND base_trx.PARTITION_KEY = r.PARTITION_KEY" +
                "  AND" +
                "  (r.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  or" +
                "  r.PARTITION_KEY between" +
                "  ?" +
                "  and" +
                "  ?" +
                "  )" +
                "  LEFT OUTER JOIN ff_twis tw" +
                "  ON base_trx.actimize_transaction_key = tw.actimize_transaction_key";

        Connection con=null;
        try
        {
            //uncomment below line to run
            //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            //Reference to connection interface
            con = DriverManager.getConnection(url,user,pass);

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "partyKey1_Login");
            st.setTimestamp(2, Timestamp.valueOf("2020-01-24 12:30:00"));
            st.setTimestamp(3, Timestamp.valueOf("2020-01-29 12:30:00"));
            st.setInt(4,24);
            st.setInt(5,24);
            st.setInt(6,29);
            st.setInt(7,29);

            st.setInt(8,24);
            st.setInt(9,24);
            st.setInt(10,29);
            st.setInt(11,29);

            st.setInt(12,24);
            st.setInt(13,24);
            st.setInt(14,29);
            st.setInt(15,29);

            st.setInt(16,24);
            st.setInt(17,24);
            st.setInt(18,29);
            st.setInt(19,29);


            ResultSet rs = st.executeQuery();
            System.out.println("Actimize_Transaction_key ");
            while(rs.next())
                System.out.println(rs.getString(2));
            con.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
    }
}


    //QueryParameters(partyKey1_Login,2020-01-24T12:30:00.000+05:30,2020-01-29T12:30:00.000+05:30,PartitionsRange(24,29,24,29))