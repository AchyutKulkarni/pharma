/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author HP
 */
public class tr extends JFrame implements ActionListener
{
    public tr() throws  FileNotFoundException, IOException
    {
        records recs[]=new records[100];
        
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
         columnNames.add("FRUIT ID" );
                columnNames.add("NAME");
                columnNames.add("COLOR");
                columnNames.add("LOCATION");
                columnNames.add("NUTRIENTS");
                int columns=5;
               BufferedReader f3=new BufferedReader(new FileReader("C:\\Users\\achuu\\Desktop\\FileStructures-B-Trees--master\\CMS\\traverse.txt"));
        String lineRead;
                int i=0;
                while((lineRead=f3.readLine())!=null)
        {
                    String [] t=lineRead.split("[|]");
        recs[i].oid=t[0];//f3.getline(recs[i].key1,5,'|');
        recs[i].name=t[1];//f3.getline(recs[i].airline,50,'|');
        recs[i].addr=t[2];//f3.getline(recs[i].to,50,'|');
        recs[i].dbname=t[3];//f3.getline(recs[i].from,50,'|');
        recs[i].titem=t[4];//f3.getline(recs[i].duration,50,'|');
        recs[i].tamt=t[5];//
                i++;
                ArrayList row = new ArrayList(columns);

                for ( i = 1; i <= columns; i++)
                {
                    row.add( recs[i].oid );
                    row.add( recs[i].name );
                    row.add( recs[i].addr);
                    row.add( recs[i].dbname );
                    row.add( recs[i].titem );
                    row.add( recs[i].tamt );
                }

                data.add( row );
                }
Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for ( i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        //table.setGridColor(Color.DARK_GRAY);
        //table.setBackground(Color.cyan);
        //table.setLayout();

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        
        JButton Home=new JButton("Back");
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(Home);
        Home.addActionListener(this);
    }
        
    



        
        
       
        
        
    
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {                                     
        try {
            // TODO add your handling code here:
            new home().setVisible(true);
            new tr().setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(traversal.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.setVisible(false);
    }                               

}


/**
 *
 * @author achuu
 */

    

