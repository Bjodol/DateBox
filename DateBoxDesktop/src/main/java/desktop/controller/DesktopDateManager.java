package desktop.controller;

import core.logic.Date;
import desktop.network.DataBaseConnection;
import desktop.view.DatePanel;

import javax.swing.*;

/**
 * Created by Bjørn on 31.03.2014.
 */
public class DesktopDateManager {

    private static final String
            DATEBOX_MANAGER_NAME = "Desktop Date Manager";

    private DataBaseConnection connection;
    private String clientMessage;
    private DatePanel datePane;

    public DesktopDateManager() {
        connection = new DataBaseConnection();
        clientMessage = "";
        datePane = new DatePanel(this);

        getList();

        JFrame frame = new JFrame(DATEBOX_MANAGER_NAME);
        frame.add(datePane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void addDate(Date date){
        String query = "INSERT INTO dates (";
        query += DataBaseConnection.SQL_TITLE_COLUMN + ",";
        query += DataBaseConnection.SQL_DESCRIPTION_COLUMN  + ",";
        query += DataBaseConnection.SQL_COST_COLUMN + ",";
        query += DataBaseConnection.SQL_DURATION_COLUMN + ",";
        query += DataBaseConnection.SQL_LOCATION_COLUMN + ",";
        query += DataBaseConnection.SQL_OTHER_COLUMN  + ")";
        query += " VALUES (";
        query += "'" + date.getTitle() + "',";
        query += "'" + date.getDescription() + "',";
        query += "'" + date.getCost() + "',";
        query += "'" + date.getDuration() + "',";
        query += "'" + date.getLocation() + "',";
        query += "'" + date.getOther() + "');";
        int result = connection.performDateInsert(query);
        if (result != -1){
            clientMessage = "Date added!";
            datePane.setDate(new Date(), true);
            getList();
        } else {
            clientMessage = "Date couldn't be saved... Try again please";
        }
    }

    public void getList(){
        String countQuery = "SELECT COUNT(*) AS total FROM " + DataBaseConnection.SQL_DATE_TABLE + ";";
        int rows = connection.performRowCount(countQuery);
        System.out.println("List number of rows: " + rows);
        String getDatesQuery = "SELECT * FROM " + DataBaseConnection.SQL_DATE_TABLE + ";";
        Date[] dateList = connection.performDateRetrieval(getDatesQuery, rows);
        System.out.println("Length of list: " + dateList.length);
        for (int i = 0; i < dateList.length; i++){
            System.out.println("Aquired Date: " + dateList[i].getTitle());
        }
    }

}
