package desktop.view;

import core.logic.Date;
import desktop.controller.DesktopDateManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bjørn on 01.04.2014.
 */
public class DateListPanel extends JPanel {

    private DesktopDateManager manager;
    private JList<Date> dateJList;


    public DateListPanel(DesktopDateManager parent, List<Date> dateList) {
        manager = parent;
        dateJList = new JList<Date>();
    }

    public void updateList(ArrayList<Date> datelist){

    }
}
